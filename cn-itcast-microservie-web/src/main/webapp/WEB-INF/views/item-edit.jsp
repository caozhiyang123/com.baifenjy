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
	            <td><input class="easyui-textbox" type="text" name="title" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>订单详情:</td>
	            <td><input class="easyui-textbox" name="orderItem" data-options="multiline:true,validType:'length[0,150]'" style="height:60px;width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>订单补充:</td>
	            <td><input class="easyui-textbox" name="orderAdditional" data-options="multiline:true,validType:'length[0,150]'" style="height:60px;width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>老师详情:</td>
	            <td><input class="easyui-textbox" name="teacherItem" data-options="multiline:true,validType:'length[0,150]'" style="height:60px;width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>老师补充:</td>
	            <td><input class="easyui-textbox" name="teacherAdditional" data-options="multiline:true,validType:'length[0,150]'" style="height:60px;width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>订单状态:</td>
	            <td><input class="easyui-textbox" name="status" data-options="multiline:true,validType:'length[0,150]'" style="height:60px;width: 60px;"></input></td>
	        </tr>
	        <tr>
	            <td>创建日期:</td>
	            <td><input class="easyui-textbox" name="created" data-options="multiline:true,validType:'length[0,150]'" disabled="disabled" style="height:60px;width: 100px;"></input></td>
	        </tr>
	        <tr>
	            <td>更新日期:</td>
	            <td><input class="easyui-textbox" name="updated" data-options="multiline:true,validType:'length[0,150]'" disabled="disabled" style="height:60px;width: 100px;"></input></td>
	        </tr>
	        <tr><td><input type="hidden" name="id"/></td></tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
	var itemEditEditor ;
	$(function(){
		//实例化富文本 编辑器
		itemEditEditor = TAOTAO.createEditor("#itemeEditForm [name=desc]");
		 /* var param = {fun:function(node){
			TAOTAO.changeItemParam(node, "itemeEditForm");
					},
					cname:node.text
		}; 
		TAOTAO.init(param); */
		
		
		
		
	});
	
	function submitForm(){
		if(!$('#itemeEditForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		$("#itemeEditForm [name=price]").val(eval($("#itemeEditForm [name=priceView]").val()) * 100);
		itemEditEditor.sync();
		
		//生成最终的规格参数数据
		var paramJson = [];
		$("#itemeEditForm .params li").each(function(i,e){
			//获取tr商品规格标签下所有子tr标签
			var trs = $(e).find("tr");
			//eq:是根据下标获取jquery对象
			//get:是根据下标获取dom对象
			//获取第一个tr标签文本内容
			var group = trs.eq(0).text();
			var ps = [];
			//遍历所有子tr标签
			for(var i=1;i<trs.length;i++){
				//从第二个tr标签开始获取每一个tr标签
				var tr = trs.eq(i);
				ps.push({
					"k":$.trim(tr.find("td").eq(0).find("span").text()),
					"v":$.trim(tr.find("input").val())
				});
			}
			paramJson.push({
				"group":group,
				"params":ps
			});
		});
		//将数组转换为json
		paramJson = JSON.stringify(paramJson);
		$("#itemeEditForm [name=itemParams]").val(paramJson);
		
		//提交到后台的RESTful
		$.ajax({
		   type: "PUT",
		   url: "/rest/page/item/edit",
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
