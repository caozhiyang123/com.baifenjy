<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="itemList" title="商品列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/rest/page/item/pageQuery',method:'get',pageSize:30,toolbar:toolbar">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'id',width:60">商品ID</th>
            <th data-options="field:'title',width:200">商品标题</th>
            <th data-options="field:'cid',width:50">叶子类目</th>
            <th data-options="field:'sellPoint',width:100">卖点</th>
            <th data-options="field:'price',width:70,align:'right',formatter:TAOTAO.formatPrice,sortable:true">价格</th>
            <th data-options="field:'num',width:70,align:'right',sortable:true">库存数量</th>
            <th data-options="field:'barcode',width:50">条形码</th>
            <th data-options="field:'status',width:60,align:'center',formatter:TAOTAO.formatItemStatus">状态</th>
            <th data-options="field:'created',width:130,align:'center',formatter:TAOTAO.formatDateTime,sortable:true">创建日期</th>
            <th data-options="field:'updated',width:130,align:'center',formatter:TAOTAO.formatDateTime,sortable:true">更新日期</th>
        </tr>
    </thead>
</table>
<div id="itemEditWindow" class="easyui-window" title="编辑商品" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/rest/page/item-edit'" style="width:80%;height:80%;padding:10px;">
</div>
<script>
    function getSelectionsIds(){
    	var itemList = $("#itemList");
    	var sels = itemList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].id);
    	}
    	ids = ids.join(",");
    	return ids;
    }
    
    var toolbar = [{
        text:'新增',
        iconCls:'icon-add',
        handler:function(){
        	$(".tree-title:contains('新增商品')").parent().click();
        }
    },{
        text:'编辑',
        iconCls:'icon-edit',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','必须选择一个商品才能编辑!');
        		return ;
        	}
        	if(ids.indexOf(',') > 0){
        		$.messager.alert('提示','只能选择一个商品!');
        		return ;
        	}
        	
        	$("#itemEditWindow").window({
        		onLoad :function(){
        			//回显数据
        			var data = $("#itemList").datagrid("getSelections")[0];
        			data.priceView = TAOTAO.formatPrice(data.price);
        			$("#itemeEditForm").form("load",data);
        			
        			// 加载商品描述
        			$.getJSON('/rest/page/item/desc?id='+data.id,function(_data){
        				itemEditEditor.html(_data.itemDesc);
        			});
        			
        			//回显商品规格数据
        			 $.getJSON('/rest/item/param/item/'+data.id,function(_data){
        				$("#itemeEditForm .params").show();
        				$("#itemeEditForm [name=itemParams]").val(_data.paramData);
        				$("#itemeEditForm [name=itemParamId]").val(_data.id);
        				//json字符串转对象
        				var paramData = JSON.parse(_data.paramData);
        				var html = "<ul>";
        				for(var i in paramData){
							var pd = paramData[i];
							html+="<li><table>";
							console.info(pd.group);
							html+="<tr><td colspan=\"2\" class=\"group\">"+pd.group+"</td></tr>";

							for(var j in pd.params){
								var ps = pd.params[j];
								console.info(ps.k);
								html+="<tr><td class=\"param\"><span>"+ps.k+"</span>: </td><td><span class='textbox'><input autocomplete=\"off\" type=\"text\" value='"+ps.v+"'/></span></td></tr>";
							}

							html+="</li></table>";
						}
        				html+= "</ul>";
						$("#itemeEditForm .params td").eq(1).html(html);
        			}) 
        			//回显商品类目
        			$.getJSON('/rest/page/item/itemCat/'+data.cid,function(_data){
        				console.info(_data.name);
        				itemEditEditor.html(_data.itemDesc);
        				TAOTAO.init({
            				"pics" : data.image,
            				"cid" : data.cid,
            				"cname":_data.name,
            				fun:function(node){
            					TAOTAO.changeItemParam(node, "itemeEditForm");
            				}
            			});
        			});
        			
        		}
        	}).window("open");
        }
    },{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中商品!');
        		return ;
        	}
        	$.messager.confirm('确认','确定删除ID为 '+ids+' 的商品吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids,"_method":"DELETE"};
                	$.post("/rest/page/item/delete",params, function(data,status,xhr){
            			if(xhr.status == 204){
            				$.messager.alert('提示','删除商品成功!',undefined,function(){
            					$("#itemList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    },'-',{
        text:'下架',
        iconCls:'icon-remove',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中商品!');
        		return ;
        	}
        	$.messager.confirm('确认','确定下架ID为 '+ids+' 的商品吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids,"_method":"PUT"};
                	$.post("/rest/page/item/instock",params, function(data){
            			if(data == 204){
            				$.messager.alert('提示','下架商品成功!',undefined,function(){
            					$("#itemList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    },{
        text:'上架',
        iconCls:'icon-remove',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中商品!');
        		return ;
        	}
        	$.messager.confirm('确认','确定上架ID为 '+ids+' 的商品吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids,"_method":"PUT"};
                	$.post("/rest/page/item/reshelf",params, function(data){
            			if(data == 204){
            				$.messager.alert('提示','上架商品成功!',undefined,function(){
            					$("#itemList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    }];
</script>