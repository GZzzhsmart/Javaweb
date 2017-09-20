/**
 *
 * @param title 表示tab页的标题
 * @param url 表示此tab页的内容来源于服务端的哪个地址（跟原先的get与post请求的url是一致的）
 */
function addTab(title, url) {
    if ($('#tabs').tabs('exists', title)) { // 判断指定标题的选项卡是否存在
        $('#tabs').tabs('select', title); // 如果存在，则把此tab页改成选中状态（显示出这个tab页的内容）
        var currTab = $('#tabs').tabs('getSelected'); // 获取当前被选中的选项卡
        var url1 = $(currTab.panel('options').content).attr('src'); // 获取当前选中的选项卡的src属性
        if(url1 != undefined && currTab.panel('options').title != "主页") {// 判断当前选中的选项卡的url是否不为空，并且当前选中的选项卡不是主页选项卡，则更新此选项卡显示的资源 
            $('#tabs').tabs('update',{ //　开始更新此选项卡的内容
                tab:currTab, // 当前选项卡
                options:{
                    content:createFrame(url1) // 重新显示出一个框架，此框架的内容来源于原先此tab的url，只做更新（相当于重新发送一个请求到服务端）
                }
            })
        }
    } else { // 如果此选项卡不存在，则新建一个选项卡
        $('#tabs').tabs('add', { // 添加选项卡
            title: title, // 添加的选项卡的标题是传递过来的title参数
            content: createFrame(url), // 选项卡需要的内容来源于我们指定的url
            border: false,
            closable: true
        });
    }
}

/**
 * 创建iframe框架的
 * @param url 整个框架想要显示的资源的url
 * @returns {String}
 */
function createFrame(url) {
    return '<iframe scrolling="auto" frameborder="0"  src="' + url + '" style="width:100%;height:100%;"></iframe>';
}

/**
 * 给easyui的datagrid设置分布组件的属性
 * @param tableId
 */
function setPagination(tableId) {
    var p = $("#" + tableId).datagrid('getPager'); // 表示获取指定table的分布组件
    $(p).pagination({ // 给分页组件设置相关属性
        pageSize: 20, // 每页显示20个记录
        pageList: [10, 15, 20, 25], // 设置每一页中可选择的记录数
        beforePageText: '第',
        afterPageText: '页    共 {pages} 页', // pages属性是easyui自动获取
        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录', // from是开始页码, to是结束页码, total是总记录数
        onBeforeRefresh: function () { // 在整个表格的数据刷新之前做什么事
            $(this).pagination('loading');
            $(this).pagination('loaded');
        }
    });
}