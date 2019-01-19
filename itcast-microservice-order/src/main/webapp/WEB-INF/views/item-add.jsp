<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="orderAddForm" class="itemForm" method="post">
	    <table cellpadding="5">
	        <tr>
	            <td>订单标题:</td>
	            <td><input class="easyui-textbox" type="text" name="title" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>订单详情:</td>
	            <td>
	                <textarea style="width:800px;height:300px;visibility:hidden;" name="orderItem"></textarea>
	            </td>
	        </tr>
	        <tr>
	            <td>订单补充:</td>
	            <td>
	                <textarea style="width:800px;height:300px;visibility:hidden;" name="orderAdditional"></textarea>
	            </td>
	        </tr>
	        <tr>
	            <td>老师详情:</td>
	            <td>
	                <textarea style="width:800px;height:300px;visibility:hidden;" name="teacherItem"></textarea>
	            </td>
	        </tr>
	        <tr>
	            <td>老师补充:</td>
	            <td>
	                <textarea style="width:800px;height:300px;visibility:hidden;" name="teacherAdditional"></textarea>
	            </td>
	        </tr>
	        <tr>
	            <td>订单状态:</td>
	            <td>
	                <select id="status" class="easyui-combobox" name="dept" style="width:200px;">
					    <option value=0 selected="selected">未试教</option>
					    <option value=1>正在试教</option>
					    <option value=2>试教成功</option>
					    <option value=3>试教失败</option>
					</select>
	            </td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	var orderItemEditor ;
	var orderAdditionalEditor ;
	var teacherItemEditor ;
	var teacherAdditionalEditor ;
	$(function(){
		orderItemEditor = TAOTAO.createEditor("#orderAddForm [name=orderItem]");
		orderAdditionalEditor = TAOTAO.createEditor("#orderAddForm [name=orderAdditional]");
		teacherItemEditor = TAOTAO.createEditor("#orderAddForm [name=teacherItem]");
		teacherAdditionalEditor = TAOTAO.createEditor("#orderAddForm [name=teacherAdditional]");
	});
	
	function submitForm(){
		if(!$('#orderAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		//将编辑器中的内容同步到隐藏多行文本中
		orderItemEditor.sync();
		orderAdditionalEditor.sync();
		teacherItemEditor.sync();
		teacherAdditionalEditor.sync();
		
		
		//提交到后台的RESTful
		$.ajax({
		   type: "POST",
		   url: "/order/insert",
		   data: $("#orderAddForm").serialize(),
		   statusCode : {
			   201 : function(){
				   $.messager.alert('提示','新增商品成功!');
				   $('#orderAddForm').form('reset');
					itemAddEditor.html('');
			   },
			   400 : function(){
				   $.messager.alert('提示','参数有误!');
			   },
			   500 : function(){
				   $.messager.alert('提示','新增商品失败!');
			   }
		   }
		});
	}
	
	function clearForm(){
		$("input[name='title']").val("").focus();
		orderItemEditor.html('');
		orderAdditionalEditor.html('');
		teacherItemEditor.html('');
		teacherAdditionalEditor.html('');
	}
</script>
