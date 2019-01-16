<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登录</title>
<jsp:include page="/commons/common-js.jsp"></jsp:include>
</head>
<body style="background-color: #F3F3F3">
    <form id="loginFrom" method="post" class="itemForm">
		    <div class="easyui-dialog" title="管理员登录" data-options="closable:false,draggable:false" style="width:400px;height:300px;padding:10px;">
		       	<div style="margin-left: 50px;margin-top: 50px;">
		       		<div style="margin-bottom:20px;">
			            <div>
			            	用户名: <input name="username" class="easyui-textbox" data-options="required:true" style="width:200px;height:32px" value=""/>
			            </div>
			        </div>
			        <div style="margin-bottom:20px">
			            <div>
			            	密&nbsp;&nbsp;码: <input name="password" class="easyui-textbox" data-options="required:true" type="password" style="width:200px;height:32px" value=""/>
			            </div>
			        </div>
			        <div>
			            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="userLoginPage.submitForm()" id="login"  iconCls="icon-ok" style="width:100px;height:32px;margin-left: 50px" >登录</a>
			            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="userLoginPage.clearForm()"  id="reset"  iconCls="icon-clear" style="width:100px;height:32px;margin-left: 50px" >重置</a>
			        </div>
		       	</div>
		    </div>
    </form>
    
    <script type="text/javascript">
    	/* $("#login").click(function(){
    		var username = $("[name=username]").val();
    		var password = $("[name=password]").val();
    		
    		if(username!="admin" || password!="admin"){
    			$.messager.alert('错误',"用户名密码不正确！");
    			return ;
    		}
    		window.location.href="/rest/page/index"; 
    		
    	});  */
    	
    	/* $('#forms').form('submit', {
    	    url: /user/doLogin,
    	    onSubmit: function(){
    	        // do some check
    	    	var reg = /^\s+|\s+$/g;
                if(form.username.value.replace(reg, "") == ""){
                    alert("请输入用户名");
                    form.username.focus();
                    return false;
                }else{
                    console.info(form.username.value);
                }
                if(form.password.value.replace(reg, "") == ""){
                    alert("请输入密码");
                    form.password.focus();
                    return false;
                }else{
                    console.info(form.password.value);
                }
    	        // return false to prevent submit;
    	    },
    	    success:function(data){
    	        alert(data)
    	    }
    	}); */
    	
    	
    	var userLoginPage  = {
                submitForm : function (){
                    if(!$('#loginFrom').form('validate')){
                        $.messager.alert('提示','用户名/密码还未填写完成!');
                        return ;
                    }
                    
                    /* $.post("/user/doLogin",$("#loginFrom").serialize(), function(data){
                        if(data.status == 200){
                            $.messager.alert('提示','登陆成功!');
                        }
                    }); */
                    
                    //提交到后台的RESTful
                    $.ajax({
                       type: "POST",
                       url: "/user/doLogin",
                       data: {username:$("[name=username]").val(),password:$("[name=password]").val()},
                       /* success: function(data){
                    	   console.info('success:'+data);
                       },
                       error: function(data){
                    	   console.info('error:'+data.status+','+data.msg);
                       } */
                       statusCode : {
                           200 : function(){
                        	   console.info('提示','登陆成功!');
                        	   window.location.href="http://127.0.0.1:6876/page/index"; 
                           },
                           400 : function(){
                        	   console.info('提示','登陆失败! username:'+username+',password:'+password);
                           },
                           404 :function(data){
                        	   console.info(data);
                           },
                           500 :function(data){
                        	   console.info(data);
                           }
                       } 
                    });
                },
                clearForm : function(){
                    $('#loginFrom').form('reset');
                }
        };
    </script>
</body>
</html>