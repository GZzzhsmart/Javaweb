function addProductType() {
	if (validateForm("addForm")) {
		$.post(contextPath + "/ptype/add",
			$("#addForm").serialize(),
			function(data) {
				if (data.controllerResult.result == "success") {
					$("#list").datagrid("reload");
					closeWin("addWin");
					showInfoAlert(data.controllerResult.message);
				} else {
					// 添加失败
					showInfoAlert(data.controllerResult.message);
				}
			}, "json"
		);
	}
}

function openEditWin(winId) {
	// 把数据放入到窗口中的form表单中
	var row = $("#list").datagrid("getSelected"); // 获取选中行所对应的json对象
	$("#editForm").form("load", row); // row json对象里的属性名需要与form表单中的input的name一致
	$("#" + winId).window("open");
}

//修改
function updateProductType() {
	
	if (validateForm("editForm")) {
		var c="";
		x=$("#editForm").serializeArray(),
		
	    $.each(x, function(i, field){
	    	c+="productType."+field.name + "=" + field.value + "&";
	    });
		$.post(contextPath + "/ptype/update", 
			c,
			function(data) {
				if (data.controllerResult.result == "success") {
					$("#list").datagrid("reload");
					closeWin("editWin");
					showInfoAlert(data.controllerResult.message);
				} else {
					// 添加失败
					showInfoAlert(data.controllerResult.message);
				}
			}, "json"
		);
	}
}

//冻结
function inactive() {
	var row = $("#list").datagrid("getSelected");
	if (row) {
		if (row.valid == "F") {
			showInfoAlert("此行数据已冻结，无需再次冻结");
		} else {
			$.post(contextPath + "/ptype/inactive", {"id":row.id},
					function(data) {
						if (data.controllerResult.result == "success") {
							$("#list").datagrid("reload");
						}
					}, "json"
			);
		}
	} else {
		showInfoAlert("请选择需要冻结的行");
	}
}

//激活
function active() {
	var row = $("#list").datagrid("getSelected");
	if (row) {
		if (row.valid == "Y") {
			showInfoAlert("此行数据已激，无需再次激活");
		} else {
			$.post(contextPath + "/ptype/active", {"id":row.id},
					function(data) {
						if (data.controllerResult.result == "success") {
							$("#list").datagrid("reload");
						}
					}, "json"
			);
		}
	} else {
		showInfoAlert("请选择需要激活的行");
	}
}