<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">  
<title>Insert title here</title>  
<script type="text/javascript" src="jquery.min.js"></script>  
<script type="text/javascript">  
    function testSpringParam(){
    	alert($("#name"));
        var name=$("#name").val();
        alert(3);
        var email=$("#email").val();      
        $.ajax({
            type: 'POST',  
            url: 'paramurl/paramTest.do' ,           
            dataType: 'text',  
            contentType:'application/json;charset=UTF-8',  
            data:JSON.stringify([{'name':name,'email':email}]),  //提交json字符串数组，如果提交json字符串去掉[]   
            success:function(data){  
                alert(data);  
            },  
            error:function(textStatus, errorThrown){  
                console.log(textStatus);  
                alert(textStatus);  
            }  
        });  
    }  
</script>  
</head>  
<body>  
<form action="paramurl/paramTest.do" id="f1" name="f1" method="post">  
    <input name="name" id="name"  type="text"  value="zhangsan1"><br>  
    <input name="email" id="email" type="text" value="zhangsan@163.com"><br><br>  
    <button onclick="submit();">测试</a>  
</form>  
</body>  
</html> 