<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="itemAddForm" class="itemForm" method="post">
	    <table cellpadding="5">
	        <tr>
	            <td>商品类目:</td>
	            <td>
	            	<a href="javascript:void(0)" class="easyui-linkbutton button-success l-btn l-btn-small selectItemCat">选择类目</a>
	            	<input type="hidden" name="cid" style="width: 280px;"></input>
	            </td>
	        </tr>
	        <tr>
	            <td>商品标题:</td>
	            <td><input class="easyui-textbox" type="text" name="title" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>商品卖点:</td>
	            <td><input class="easyui-textbox" name="sellPoint" data-options="multiline:true,validType:'length[0,150]'" style="height:60px;width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>商品价格:</td>
	            <td><input class="easyui-numberbox" type="text" name="priceView" data-options="min:1,max:99999999,precision:2,required:true" />
	            	<input type="hidden" name="price"/>
	            </td>
	        </tr>
	        <tr>
	            <td>库存数量:</td>
	            <td><input class="easyui-numberbox" type="text" name="num" data-options="min:1,max:99999999,precision:0,required:true" /></td>
	        </tr>
	        <tr>
	            <td>条形码:</td>
	            <td>
	                <input class="easyui-textbox" type="text" name="barcode" data-options="validType:'length[1,30]'" />
	            </td>
	        </tr>
	        <tr>
	            <td>商品图片:</td>
	            <td>
	            	 <a href="javascript:void(0)" class="easyui-linkbutton picFileUpload">上传图片</a>
	                 <input type="hidden" name="image"/>
	            </td>
	        </tr>
	        <tr>
	            <td>商品描述:</td>
	            <td>
	                <textarea style="width:800px;height:300px;visibility:hidden;" name="desc"></textarea>
	            </td>
	        </tr>
	        <tr class="hide params">
	        	<td>商品规格:</td>
	        	<td>
	        		<span>
	        			
	        		</span>
	        	</td>
	        </tr>
	    </table>
	    <input type="hidden" name="itemParams"/>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	var itemAddEditor ;
	$(function(){
		itemAddEditor = TAOTAO.createEditor("#itemAddForm [name=desc]");
		var param = {fun:function(node){
			/* 动态生成商品规格模板 */
			TAOTAO.changeItemParam(node, "itemAddForm");
			
		}};
		TAOTAO.init(param);
		
	});
	
	function submitForm(){
		if(!$('#itemAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		//处理商品的价格的单位，将元转化为分
		$("#itemAddForm [name=price]").val(eval($("#itemAddForm [name=priceView]").val()) * 100);
		//将编辑器中的内容同步到隐藏多行文本中
		itemAddEditor.sync();
		
		//生成最终的规格参数数据
		var paramJson = [];
		$("#itemAddForm .params li").each(function(i,e){
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
		$("#itemAddForm [name=itemParams]").val(paramJson);
		
		//提交到后台的RESTful
		$.ajax({
		   type: "POST",
		   url: "/rest/page/item/insert",
		   data: $("#itemAddForm").serialize(),
		   statusCode : {
			   201 : function(){
				   $.messager.alert('提示','新增商品成功!');
				   $(".selectItemCat").next("span").remove();
				   $('#itemAddForm').form('reset');
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
		$(".selectItemCat").next("span").remove();
		$('#itemAddForm').form('reset');
		itemAddEditor.html('');
	}
</script>
