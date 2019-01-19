<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="itemeEditForm" class="itemForm" method="post">
		<input type="hidden" name="id"/>
	    <table cellpadding="5">
	        <tr>
	            <td>订单标题:</td>
	            <td>
	               <input class="easyui-textbox" type="text" name="title" data-options="required:true" style="width: 280px;"></input>
	            </td>
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
	        <tr>
	            <td>创建日期:</td>
	            <td>
	               <input class="easyui-textbox" name="created" data-options="multiline:true,validType:'length[0,150]'" disabled="disabled" style="height:60px;width: 100px;"></input>
	            </td>
	        </tr>
	        <tr>
	            <td>更新日期:</td>
	            <td>
	               <input class="easyui-textbox" name="updated" data-options="multiline:true,validType:'length[0,150]'" disabled="disabled" style="height:60px;width: 100px;"></input>
	            </td>
	        </tr>
	        <tr><td><input type="hidden" name="id"/></td></tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
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
		if(!$('#itemeEditForm').form('validate')){
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
		   type: "PUT",
		   url: "http://127.0.0.1:6870/order/edit",
		   data: $("#itemeEditForm").serialize(),
		   statusCode : {
			   204 : function(){
				   $.messager.alert('提示','修改商品成功!','info',function(){
						$("#itemEditWindow").window('close');
						$("#itemList").datagrid("reload");
					});
			   },
			   400 : function(){
				   $.messager.alert('提示','请求参数不合法!');
			   },
			   500 : function(){
				   $.messager.alert('提示','修改商品失败!');
			   }
		   }
		});
	}
</script>
