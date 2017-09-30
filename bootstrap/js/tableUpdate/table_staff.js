
//   function inint(table){
//         //---先销毁表格 ---
//         this.bootstrapTable('destroy');  
//         //---初始化表格,动态从服务器加载数据--- 
//         this.bootstrapTable({
//            //【发出请求的基础信息】
//            url: '/RealEstate/budingDon/list',
//            method: 'post',
//            contentType: "application/x-www-form-urlencoded",
//            //【查询设置】
//            /* queryParamsType的默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
//                              设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber */
//            queryParamsType:'', 
//            queryParams: function queryParams(params) {  
//              var param = {  
//                  pageNumber: params.pageNumber,    
//                  pageSize: params.pageSize
//              }; 
//              for(var key in searchArgs){
//                  param[key]=searchArgs[key]
//              }  
//              return param;                   
//            }, 
//            
//            //【其它设置】
//            toolbar: '#toolbar',                //工具按钮用哪个容器
//            locale:'zh-CN',//中文支持
//            striped: true,      
//            showColumns:true,
//            pagination:true,//是否开启分页（*）
//            pageNumber:1,                       //初始化加载第一页，默认第一页
//            pageSize: 5,                       //每页的记录行数（*）
//            pageList: [5, 10,15,20],        //可供选择的每页的行数（*）
//            search: true,
//            uniqueId: "id",  //初始化加载第一页，默认第一页
//            sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
//            showRefresh:true,//刷新按钮
//            showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
//            clickToSelect: true,  //是否启用点击选中行
//            //【样式设置】
//            height: 500,//table的高度
//            //按需求设置不同的样式：5个取值代表5中颜色['active', 'success', 'info', 'warning', 'danger'];
//            rowStyle: function (row, index) {
//                var style = "";
//                if (row.name=="小红") {style='success';}
//                return { classes: style }
//            },
//            
//            //【设置列】
//            columns: [
//            	{checkbox: true},
////             {field: 'name',title: '名称'},
////             {field: 'gender',title: '性别'},
////             {field: 'headicon',title: '头像'},
////             {field: 'email',title: '邮箱'},
////             {field: 'phone',title: '手机号码'}, 
////             {field: 'basic_salary',title: '基本工资'}, 
////             {field: 'address',title: '联系地址'},
////             {field: 'des',title: '个人说明'},
//             {field: 'building_name',title: '楼栋名称'}, 
//             {field: 'total_floor',title: '总层数'}
//            ]
//        })
//     }

//var tb=$("table");
//inint(tb);


  //注册新增按钮的事件
//$("#btn_add").click(function () {
//		$("#myModalLabel").text("新增");
//		$('#myModal').modal();
//});

function format(value) {
	return "<img style='width:120;height:50px' src='http://localhost:8080/RealEstate/"+value+"'>";
}


$("#btn_edit").click(function () {
	//取表格的选中行数据
	var data = $("#tb").bootstrapTable('getSelections');
    if (data.length == 1) {
        $("#from1").fill(data[0]);
        $("#exampleModalLabel").text("修改");
        $('#exampleModal').modal();
        return;
    }else{
       // toastr.warning('请选择有效数据');
    	 $('#myModal').modal();
    	
        return;
    }
});




//编辑
function select() {
	//取表格的选中行数据
	alert("请选择数据！");
	var data=$("#tb").bootstrapTable("getSelections");
	if (data.length == 1) {
        $("#from1").fill(data[0]);
        $("#exampleModalLabel").text("编辑");
        $('#exampleModal').modal();
        return;
    }else{
        toastr.warning('请选择有效数据');

        return;
    }
};






//$("#btn_delete").click(function () {
//	//取表格的选中行数据
//	var data = $("#tb_departments").bootstrapTable('getSelections');
//    if (data.length == 1) {
// 
//        return;
//    }else{
//        toastr.warning('请选择有效数据');
//
//        return;
//    }
//});