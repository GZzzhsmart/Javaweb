<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%String path = request.getContextPath();%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Chatroom|聊天室</title>
    <jsp:include page="/WEB-INF/views/commonfile.jsp"/>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>
<!-- content start -->
<div class="admin-content">
    <div class="" style="width: 80%;float:left;">
        <!-- 聊天区 -->
        <div class="am-scrollable-vertical" id="chat-view" style="height: 510px;">
            <ul class="am-comments-list" id="chat">
            </ul>
        </div>
        <!-- 输入区 -->
        <div class="am-form-group am-form" >
            <textarea class="" id="message" name="message" rows="5"  placeholder="这里输入你想发送的信息..."></textarea>
        </div>
        <%--预览区--%>
        <div class="" style="float:left;">
            <input type="file" id="img"> 预览：<img id="imgShow" src="" alt="">
        </div>
        <br>
        <!-- 接收者 -->
        <div class="" style="float: left">
            <p class="am-kai">发送给 : <span id="sendto">全体成员</span><button class="am-btn am-btn-xs am-btn-danger" onclick="$('#sendto').text('全体成员')">复位</button></p>
        </div>
        <!-- 按钮区 -->
        <div class="am-btn-group am-btn-group-xs" style="float:right;">
            <button class="am-btn am-btn-default" type="button" onclick="clearConsole()"><span class="am-icon-trash-o"></span> 清屏</button>
            <button class="am-btn am-btn-default" type="button" onclick="checkConnection()"><span class="am-icon-bug"></span> 检查</button>
            <button class="am-btn am-btn-default" type="button" onclick="sendMessage()"><span class="am-icon-commenting"></span> 发送</button>
            <button class="am-btn am-btn-default" type="file" onclick="uploadImage()"><span class="am-icon-file-image-o"></span> 上传图片</button>
            <button class="am-btn am-btn-default" type="file" onclick="sendImage()"><span class="am-icon-file-image-o"></span> 发送图片</button>
        </div>
    </div>
    <!-- 列表区 -->
    <div class="am-panel am-panel-default" style="float:right;width: 20%;">
        <div class="am-panel-hd">
            <h3 class="am-panel-title">在线列表 [<span id="onlinenum"></span>]</h3>
        </div>
        <ul class="am-list am-list-static am-list-striped" id="list">
        </ul>
    </div>
</div>
<!-- content end -->
<script>

    var imgData =null;   //base64类型的图片数据
    var ws = null;
    //判断当前浏览器是否支持WebSocket
    if ('WebSocket' in window) {
        ws = new WebSocket("ws://" + location.host+"${pageContext.request.contextPath}" + "/chatServer");
    }
    else {
        alert("对不起！你的浏览器不支持webSocket")
    }

    //连接成功建立的回调方法
    ws.onopen = function (event) {
        setMessageInnerHTML("系统消息：加入连接");
    };
    ws.onmessage = function (evt) {
        analysisMessage(evt.data);  //解析后台传回的消息,并予以展示
    };
    //连接关闭的回调方法
    ws.onclose = function () {
        setMessageInnerHTML("系统消息：断开连接");
    };
    //连接发生错误的回调方法
    ws.onerror = function () {
        setMessageInnerHTML("系统消息：error");
    };

    /**
     *监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，
     *防止连接还没断开就关闭窗口，server端会抛异常。
     */
    window.onbeforeunload = function () {
        var is = confirm("确定关闭窗口？");
        if (is){
            ws.close();
        }
    };

    /**
     * 关闭连接
     */
    //关闭连接
    function closeWebSocket() {
        ws.close();
    }

    /**
     * 检查连接
     */
    function checkConnection(){
        if(ws != null){
            alert(ws.readyState == 0? "连接异常":"连接正常", { offset: 0});
        }else{
            alert("连接未开启!", { offset: 0, shift: 6 });
        }
    }

    /**
     * 发送信息给后台
     */
    function sendMessage(){
        var message = $("#message").val();
        var to = $("#sendto").text() == "全体成员"? "": $("#sendto").text();
        ws.send(JSON.stringify({
            message : {
                content : message,//输入框的内容
                from : '${username}',//登录成功后保存在Session.attribute中的username
                to : to      //接收人,如果没有则置空,如果有多个接收人则用,分隔
            },
            type : "message"
        }));
    }

    /**
     * 发送图片给后台
     */
    function sendImage(){
        var to = $("#sendto").text() == "全体成员"? "": $("#sendto").text();
        ws.send(JSON.stringify({
            message : {
                content : imgData,//图片的base64类型字符串
                from : '${username}',//登录成功后保存在Session.attribute中的username
                to : to      //接收人,如果没有则置空,如果有多个接收人则用,分隔
            },
            type : "image"
        }));
    }

    /**
     * 解析后台传来的消息
     * "massage" : {
     *              "from" : "xxx",
     *              "to" : "xxx",
     *              "content" : "xxx"
     *          },
     * "type" : {notice|message},
     * "list" : {[xx],[xx],[xx]}
     */
    function analysisMessage(message){
        message = JSON.parse(message);
        if(message.type == "message"){      //会话消息
            showChat(message.message);
        }
        if(message.type == "notice"){       //提示消息
            showNotice(message.message);
        }
        if(message.type == "image"){        //图片消息
            showImage(message.message);
        }
        if(message.list != null && message.list != undefined){      //在线列表
            showOnline(message.list);
        }
    }

    /**
     * 展示会话信息
     */
    function showChat(message){
        var to = message.to == null || message.to == ""? "全体成员" : message.to;   //获取接收人
        var html = message.from+ " 发送给: "+ to + "\n" + message.content+"<br/>";
        $("#chat").append(html);
        $("#message").val("");  //清空输入区
        var chat = $("#chat-view");
        chat.scrollTop(chat[0].scrollHeight);   //让聊天区始终滚动到最下面
    }

    /**
     * 展示提示信息
     */
    function showNotice(notice){
        $("#chat").append("<div><p class=\"am-text-success\" style=\"text-align:center\"><span class=\"am-icon-bell\"></span> "+notice+"</p></div>");
        var chat = $("#chat-view");
        chat.scrollTop(chat[0].scrollHeight);   //让聊天区始终滚动到最下面
    }

    /**
     * 展示图片信息
     */
    function showImage(image) {
        var imgdata = image.content;
        var to = image.to == null || image.to == ""? "全体成员" : image.to;   //获取接收人
        var html = image.from+ " 发送给: "+ to + "\n" + "<img src=" + imgdata + ">" + "<br>";
        $("#chat").append(html);
        $("#message").val("");  //清空输入区
        $("#img").val("");      //清空上传的图片
        $("#imgdata").val("");  //清空base64类型的图片数据
        var imgShow = document.getElementById('imgShow');
        imgShow.setAttribute('src', "");//清空预览图片信息
        var chat = $("#chat-view");
        chat.scrollTop(chat[0].scrollHeight);   //让聊天区始终滚动到最下面



    }

    /**
     * 展示在线列表
     */
    function showOnline(list){
        $("#list").html("");    //清空在线列表
        $.each(list, function(index, item){     //添加私聊按钮
            var li = "<li>"+item+"</li>";
            if('${username}' != item){    //排除自己
                li = "<li>"+item+" <button type=\"button\" class=\"am-btn am-btn-xs am-btn-primary am-round\" onclick=\"addChat('"+item+"');\"><span class=\"am-icon-phone\"><span> 私聊</button></li>";
            }
            $("#list").append(li);
        });
        $("#onlinenum").text($("#list li").length);     //获取在线人数
    }

    /**
     * 添加接收人
     */
    function addChat(user){
        var sendto = $("#sendto");
        var receive = sendto.text() == "全体成员" ? "" : sendto.text() + ",";
        if(receive.indexOf(user) == -1){    //排除重复
            sendto.text(receive + user);
        }
    }

    /**
     * 清空聊天区
     */
    function clearConsole(){
        $("#chat").html("");
    }

    /**
     * 发送系统消息
     * @param innerHTML
     */
    function setMessageInnerHTML(innerHTML) {
        $("#chat").append(innerHTML+"<br/>")
    };

    /**
     * 上传图片
     * 使用FileReader对象将本地图片转换为base64发送给服务端
     */

    function uploadImage() {

        var img = document.getElementById('img')
            , imgShow = document.getElementById('imgShow')
            , message = document.getElementById('message')
        var imgFile = new FileReader();
        imgFile.readAsDataURL(img.files[0]);
        imgFile.onload = function () {
            imgData = this.result; //base64数据
            imgShow.setAttribute('src', imgData);
        }
    }

</script>
</body>
</html>

