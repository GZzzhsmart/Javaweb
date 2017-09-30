//设置弹出框参数
$(function(){
	toastr.options = {  
        closeButton: false,  
        debug: false,  
        progressBar: true,  
        positionClass: "toast-center-center",  
        onclick: null,  
        showDuration: "300",  //显示动作时间 
        hideDuration: "500", //隐藏动作时间 
        timeOut: "1000",  	  //自动关闭超时时间 
        extendedTimeOut: "1000",  
        showEasing: "swing",  
        hideEasing: "linear",  
        showMethod: "fadeIn",  
        hideMethod: "fadeOut"  
    };  
})