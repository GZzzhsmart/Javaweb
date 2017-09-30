class BstpTable{
    constructor(obj) {
        this.obj=obj;
    }
    inint(searchArgs){
         //---先销毁表格 ---
         this.obj.bootstrapTable('destroy');  
         //---初始化表格,动态从服务器加载数据--- 
         this.obj.bootstrapTable({
            //【发出请求的基础信息】
            method: 'post',
            contentType: "application/x-www-form-urlencoded",
            //【查询设置】
            /* queryParamsType的默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
                              设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber */
            queryParamsType:'', 
            queryParams: function queryParams(params) {  
              var param = {  
                  pageNumber: params.pageNumber,    
                  pageSize: params.pageSize
              }; 
              for(var key in searchArgs){
                  param[key]=searchArgs[key] 
              }  
              return param;                   
            }, 
            
            //【其它设置】
            locale:'zh-CN',//中文支持
            pagination: true,//是否开启分页（*）
            pageNumber:1,//初始化加载第一页，默认第一页
            pageSize: 5,//每页的记录行数（*）
            showToggle:true,//显示试图切换
            toolbar:"#toolbar",
            pageList: [5,10,15,30],//可供选择的每页的行数（*）
            sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
            showRefresh:true,//刷新按钮
            showColumns:true,
            showExport: true,//显示导出按钮  
            exportDataType: "basic",//导出类型 
            clickToSelect:true,
            //【样式设置】
            height: 600,//table的高度
            //按需求设置不同的样式：5个取值代表5中颜色['active', 'success', 'info', 'warning', 'danger'];
            rowStyle: function (row, index) {
                var style = "";
                if (row.name=="小红") {style='warning';}
                return { classes: style }
            }
        })
     }
}

var bstpTable=new BstpTable($("#tb"));
bstpTable.inint({})
$(function(){
	$(".search").click(function(){
	    var searchArgs={
	         name:$("input[name='name']").val(),
	    }
	    bstpTable.inint(searchArgs)
	})
	$("#edit").click(function(){
		var data=$("#tb").bootstrapTable("getSelections");
		if(data.length==1){
			$("#f").fill(data[0]);
		}else{
			alert("请选中行");
			$("#myModal").modal("toggle");
		}
	})
	$("#update").click(function(){
		alert();
		$.post("EstateSales/admin/updateArticleType",
				$("#f").serialize(),
				function(data){
				if(data.msg=="success"){
					$("#myModal").modal("toggle");
					$("#tb").bootstrapTable("refresh",{url:"EstateSales/admin/articleTypeList"});
				}else{
					alert("修改失败！");
				}
		},"json")
		
	})
	$("#delete").click(function(){
		var data=$("#tb").bootstrapTable("getSelections");
		if(data.length==1){
			$.post("EstateSales/admin/articleTypeDelte",
					{"articleType.id":data[0].id},
					function(msg){
						$("#tb").bootstrapTable("refresh",{url:"EstateSales/admin/articleTypeList"});
					},
					"json")
		}else{
			alert("请选中数据");
		}
	})
})
