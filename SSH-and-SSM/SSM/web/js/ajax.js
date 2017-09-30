var xmlhttp;
function createXMLHttpRequest(){
	try{
		return new ActiveXObject("Msxml2.XMLHTTP");
	}catch(e){
		try{
			return new ActiveXObject("Microsoft.XMLHTTP");				
		}catch(e){
			try{
				return new XMLHttpRequest();
			}catch(e){
				alert("create XMLHTTPRequest object error!");
			}
		}
	}
}
function send(method,url,param,ascy){
	xmlhttp = createXMLHttpRequest();
	xmlhttp.onreadystatechange=recedata;
	url = url +"?"+param;
	xmlhttp.open(method,url,ascy);
	if(method=="get" || method=="GET"){
		xmlhttp.send(null);
	}else if(method=="post"|| method=="POST"){//post
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlhttp.send(param);
	}
}