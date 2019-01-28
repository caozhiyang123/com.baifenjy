<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Data analysis system</title>
<jsp:include page="/commons/common-js.jsp"></jsp:include>
<style type="text/css">
	.content {
		padding: 10px 10px 10px 10px;
	}
</style>
</head>
<body>
	<div id="master-layout">
		<div data-options="region:'north',border:false,bodyCls:'theme-header-layout'">
        	<div class="theme-navigate">
                <div class="left">
                </div>
                <div class="right">
                    <a href="#" class="easyui-menubutton theme-navigate-more-button" data-options="menu:'#more',hasDownArrow:false"></a>
                    <div id="more" class="theme-navigate-more-panel">
                    	<div>联系管理员</div>
                        <div>安全退出</div>
                        <div>关于</div>
                    </div>
                </div>
            </div>
        </div>
		 <div data-options="region:'west',title:'menu',split:true,border:false" style="width:200px; padding:10px 10px;">
	    	<ul id="menu" class="easyui-tree" style="margin-top: 10px;margin-left: 5px;">
	         	<li>
	         		<span>Data analysis</span>
	         		<ul>
		         		<li data-options="attributes:{'url':'/page/vb_rtp_data'}">VB RTP</li>
		         	</ul>
	         	</li>
	         </ul>
	    </div>
	    
	    <div data-options="region:'center',title:'',border:false">
	    	<div id="tabs" class="easyui-tabs" style="width:100%;height:100%">
			    <div title="首页" style="padding:20px;" data-options="fit:false,border:false,href:'/js/EasyUI_of_InsdepTheme-1.5.1-1.0.0-rc2/info.html'">
			        	
			    </div>
			</div>
	    </div>
	</div>
   
    
    <!--第三方插件加载-->
    <script src="/js/EasyUI_of_InsdepTheme-1.5.1-1.0.0-rc2/plugin/justgage-1.2.2/raphael-2.1.4.min.js"></script>
    <script src="/js/EasyUI_of_InsdepTheme-1.5.1-1.0.0-rc2/plugin/justgage-1.2.2/justgage.js"></script>

    <script src="/js/EasyUI_of_InsdepTheme-1.5.1-1.0.0-rc2/plugin/Highcharts-5.0.0/js/highcharts.js"></script>
    <!--第三方插件加载结束-->
    
    
<script type="text/javascript">
$(function(){
	/*布局部分*/
	$('#master-layout').layout({
		fit:true/*布局框架全屏*/
	});   
	
	$('#menu').tree({
		onClick: function(node){
			//判断是否是叶子节点,node.target获取的是叶子节点Dom对象
			if($('#menu').tree("isLeaf",node.target)){
				var tabs = $("#tabs");
				//获取指定选项卡面板
				var tab = tabs.tabs("getTab",node.text);
				if(tab){
					tabs.tabs("select",node.text);
				}else{
					tabs.tabs('add',{
					    title:node.text,
					    href: node.attributes.url,
					    closable:true,
					    bodyCls:"content"
					});
				}
			}
		}
	});
});
</script>
</body>
</html>