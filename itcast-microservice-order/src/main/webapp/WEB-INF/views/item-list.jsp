<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="itemList" title="订单列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/order/pageQuery',method:'get',pageSize:30,toolbar:toolbar">
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
            <th data-options="field:'created',width:130,align:'center',sortable:true">创建日期</th>
            <th data-options="field:'updated',width:130,align:'center',sortable:true">更新日期</th>
        </tr>
    </thead>
</table>
<div id="itemEditWindow" class="easyui-window" title="编辑订单" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/page/item-edit'" style="width:80%;height:80%;padding:10px;">
</div>
<script>

   /* $(function(){
    	$.ajax({
            type:"GET",
            url:"http://127.0.0.1:6870/order/pageQuery?callback_=order_dataServer", //访问的链接
            dataType:"jsonp",  //数据格式设置为jsonp
            data:{page:1,rows:30,sort:'updated',order:'DESC'},
            success:function(data){  //成功的回调函数
            	console.info(data);
            },
            error: function (e) {
            	console.info(e);
            }
        });
    });

    function order_dataServer(data){
    	console.info(data.t+","+data.r);
    } */
    
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
        	$(".tree-title:contains('新增订单')").parent().click();
        }
    },{
        text:'编辑',
        iconCls:'icon-edit',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0 || ids.indexOf(',') > 0){
        		$.messager.alert('提示','必须/只能选择一个订单才能编辑!');
        		return ;
        	}
        	
        	$("#itemEditWindow").window({
        		onLoad :function(){
        			//回显数据
        			var data = $("#itemList").datagrid("getSelections")[0];
        			$("#itemeEditForm").form("load",data);
        		}
        	}).window("open");
        }
    },{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中订单!');
        		return ;
        	}
        	$.messager.confirm('确认','确定删除ID为 '+ids+' 的订单吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids,"_method":"DELETE"};
                	$.post("/order/delete",params, function(data,status,xhr){
            			if(xhr.status == 204){
            				$.messager.alert('提示','删除商品成功!',undefined,function(){
            					$("#itemList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    }];
</script>