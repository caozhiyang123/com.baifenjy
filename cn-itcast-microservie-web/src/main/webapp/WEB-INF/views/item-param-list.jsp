<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="itemParamList" title="商品列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/rest/item/param/list',method:'get',pageSize:30,toolbar:itemParamListToolbar">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'id',width:60">订单ID</th>
            <th data-options="field:'title',width:100">订单标题</th>
            <th data-options="field:'orderItem',width:100">订单详情</th>
            <th data-options="field:'orderAdditional',width:100">订单补充</th>
            <th data-options="field:'teacherItem',width:100">老师详情</th>
            <th data-options="field:'teacherAdditional',width:100">老师补充</th>
            <th data-options="field:'status',width:50,align:'center'">订单状态</th>
            <th data-options="field:'created',width:130,align:'center'">创建日期</th>
            <th data-options="field:'updated',width:130,align:'center'">更新日期</th>
        </tr>
    </thead>
</table>
<div id="itemParamEditWindow" class="easyui-window" title="编辑订单显示列" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/page/item-param-edit'" style="width:80%;height:80%;padding:10px;">
</div>
<script>
    function getSelectionsIds(){
    	var itemList = $("#itemParamList");
    	var sels = itemList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].id);
    	}
    	ids = ids.join(",");
    	return ids;
    }
    
    var itemParamListToolbar = [{
        text:'新增',
        iconCls:'icon-add',
        handler:function(){
        	TAOTAO.createWindow({
        		url : "/page/item-param-add",
        	});
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
        	
        	$("#itemParamEditWindow").window({
        		onLoad :function(){
        			//回显数据
        			var data = $("#itemList").datagrid("getSelections")[0];
        			
        			$("#itemeParamEditForm").form("load",data);
        			        			
        			TAOTAO.init({
        				"cid" : data.itemCatId,
        				"cname":data.cname,
        				fun:function(node){
        					TAOTAO.changeItemParam(node, "itemeParamEditForm");
        				}
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
        		$.messager.alert('提示','未选中订单显示列!');
        		return ;
        	}
        	$.messager.confirm('确认','确定删除ID为 '+ids+' 的订单显示列吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids,"_method":"DELETE"};
                	$.post("/order/param/delete",params, function(data,status,xhr){
                		console.info(data);
                		console.info(status);
                		console.info(xhr);
            			if(status == "nocontent"){
            				$.messager.alert('提示','删除订单显示列成功!',undefined,function(){
            					$("#itemParamList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    }];
</script>