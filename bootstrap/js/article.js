//修改
$("#btn_edit").click(function () {
	//取表格的选中行数据
	var data = $("#tb").bootstrapTable('getSelections');
    if (data.length == 1) {
        $("#form1").fill(data[0]);
        $("#exampleModalLabel").text("修改");
        $('#exampleModal').modal();
        return;
    }else{
    	 swal("未选中数据，请先选中！","","error");
        return;
    }
});

$("#active").click(function () {
	//取表格的选中行数据
	var data = $("#tb").bootstrapTable('getSelections');
    if (data.length == 1) {
    	if(data[0].article_status=="激活"){
    		swal("已激活无需再次激活请重新选择","","error");
    	}else{
    		$.ajax({ url: "http://localhost:8080/RealEstate/article/active?article_id="+data[0].article_id, 
    			success: function(){
    				$("#tb").bootstrapTable("refresh",{url:"http://localhost:8080/RealEstate/article/page"});
    		}
    	      });
    		swal("成功激活","","success");
    	}
    }else{
    	swal("请选中数据","","error");
        return;
    }
});


$("#inactive").click(function () {
	//取表格的选中行数据
	var data = $("#tb").bootstrapTable('getSelections');
    if (data.length == 1) {
    	if(data[0].article_status=="冻结"){
    		swal("已冻结无需再次冻结请重新选择","","error");
    	}else{
    		$.ajax({ url: "http://localhost:8080/RealEstate/article/inactive?article_id="+data[0].article_id, 
    			success: function(){
    				$("#tb").bootstrapTable("refresh",{url:"http://localhost:8080/RealEstate/article/page"});
    		}
    	      });
    		swal("成功冻结","","success");
    	}
    }else{
    	swal("请选中数据","","error");
        return;
    }
});


//修改图片的事件
$("#updatelogo").click(function () {
	//取表格的选中行数据
	var data = $("#tb").bootstrapTable('getSelections');
    if (data.length == 1) {
        $("#f1").fill(data[0]);
        $('#article_logo').modal();
        return;
    }else{
    	swal("请选中数据","","error");
        return;
    }
});

