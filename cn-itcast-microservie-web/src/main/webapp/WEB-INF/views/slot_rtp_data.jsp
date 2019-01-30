<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div style="overflow:auto;height: 99.5%;">
    <div class="theme-user-info-panel">
        <div class="left">
            <img src="/js/tx.png" width="86"
                height="86">
        </div>
        <div class="right">
    
            <style>
                .gauge {
                    width: 130px;
                    height: 130px;
                }
            </style>
            <ul>
                <li><div id="slot_totalRTP" class="gauge" data-value="998"></div>
                    <span>totalRTP</span></li>
                <li><div id="slot_user_count" class="gauge" data-value="10000"></div>
                    <span>totalUserCount</span></li>
                <li><div id="slot_jackpotCount" class="gauge" data-value="100"></div>
                    <span>jackpotCount</span></li>
                <li><div id="slot_spinCount" class="gauge" data-value="100000"></div>
                    <span>spinCount</span></li>
            </ul>
        </div>
        <div class="center">
            <h1>
                michael<span class="color-success badge">CAO</span>
            </h1>
            <h2>account</h2>
            <dl>
                <dt>123455@qq.com</dt>
                <dd>18888888888</dd>
            </dl>
        </div>
    </div>
    <div>
    <div  class="fitem" style="font-family: monospace white-space: pre; background-color: rgb(240, 240, 240);">
        <label>from time:&nbsp;&nbsp;</label><input  type="text" id="slotTimeFrom"  data-options="formatter:ww3,parser:w3,required:true,editable:false" class="easyui-datetimebox" style="width: 280px;">&nbsp;&nbsp;&nbsp;&nbsp;<label>to time:&nbsp;&nbsp;</label><input type="text" id="slotTimeTo"  data-options="formatter:ww3,parser:w3,required:true,editable:false" class="easyui-datetimebox" style="width: 280px;">&nbsp;&nbsp;
        <label>game id:&nbsp;&nbsp;</label>
	    <select class="easyui-combobox" id="slotGameId" style="width: 200px;height: 90%">
                <option value=46 selected="selected">slot halloween 46</option>
                <option value=47>slot Era do Gelo 47</option>
                <option value=63>slot halloweenX 63</option>
                <option value=66>slot halloween25 66</option>
        </select>&nbsp;&nbsp;&nbsp;&nbsp;
        <a onclick="slotRtpQuery()" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" style="background-color:rgb(240, 240, 240)">start</a>
    </div>
   <script type="text/javascript">
	   var slot_gg1;var slot_gg2;var slot_gg3;var slot_gg4;
	   $(function() {
	       var slotDfltPer = {
        	   min : 0,
               max : 3000,
               donut : true,
               gaugeWidthScale : 0.6,
               counter : true,
               hideInnerShadow : true,
               symbol: "‰"
	       }
	       var slotDfltCount = {
	               min : 0,
	               max : 10000000,
	               gaugeWidthScale : 0.6,
	               symbol: ""
	       }
	       slot_gg1 = new JustGage({
	           id : 'slot_totalRTP',
	           defaults : slotDfltPer
	       });
	       slot_gg2 = new JustGage({
	           id : 'slot_user_count',
	           defaults : slotDfltCount
	       });
	       slot_gg3 = new JustGage({
	           id : 'slot_jackpotCount',
	           defaults : slotDfltCount
	       });
	       slot_gg4 = new JustGage({
	           id : 'slot_spinCount',
	           defaults : slotDfltCount
	       });
	   });
	   
       function slotRtpQuery(){
    	   //加载遮罩效果
    	   EasyUILoad();
    	   
    	   var slotTimeFrom = $('#slotTimeFrom').datetimebox('getValue');
    	   var slotTimeTo = $('#slotTimeTo').datetimebox('getValue');
    	   var slotGameId = $("#slotGameId").combobox("getValue");
    	   $(function(){
    	        $.ajax({
    	            type:"GET",
    	            url:"/rtp/query/slot",
    	            dataType:"json",
    	            data:{timeFrom:slotTimeFrom,timeTo:slotTimeTo,gameId:slotGameId},
    	            success:function(data){
    	            	//隐藏遮罩效果
                        dispalyEasyUILoad();
    	            	
    	                console.info(data);
    	                var slot_rtpChart = $('#slot_RTP_charts').highcharts();
    	                var slot_category0 = new Array();
    	                var slot_seriesData0 = new Array();
    	                $.each(data.rtp,function(key,values){
    	                	slot_category0.push(key);
    	                	slot_seriesData0.push(parseFloat(values));
    	                 });
    	                // get and set title
    	                var current_title = {
                                text: '[current game id:'+gameId+']  '+vb_rtpChart.title.textStr,   
                                style:{
                                    color:"#ff0000"
                                }
                            };
    	                slot_rtpChart.setTitle(current_title,null,true);
    	                
    	                slot_rtpChart.xAxis[0].setCategories(slot_category0);
    	                slot_rtpChart.series[0].setData(slot_seriesData0,true,true,true);
    	                
    	                slot_gg1.refresh(parseFloat(data.totalRTP)*1000);
    	                slot_gg2.refresh(parseFloat(data.total_user_count));
    	                slot_gg3.refresh(parseFloat(data.total_Jackpot_count));
    	                slot_gg4.refresh(parseFloat(data.totalSpins));
    	            },
    	            error: function (e) {
    	            	//隐藏遮罩效果
                        dispalyEasyUILoad();
    	            	
    	                console.info(e);
    	            }
    	        });
    	    });
       }
       
       function ww3(date){  
            var Y = date.getFullYear();  
            var M = date.getMonth()+1;  
            var D = date.getDate();  
            var h = date.getHours();
            var m = date.getMinutes();
            var s = date.getSeconds();
            var ms = date.getMilliseconds();
            var str = Y+'-'+(M<10?('0'+M):M)+'-'+(D<10?('0'+D):D)+' '+(h<10?('0'+h):h)+":"+(m<10?('0'+m):m)+":"+(s<10?('0'+s):s)+":"+(ms<10?('0'+ms):ms);  
            return str;  
        }  
        function w3(s){  
            if (!s) return new Date();  //2019-01-22 09:57:51:394
            var y = s.substring(0,4);  
            var m =s.substring(5,7);  
            var d = s.substring(8,10);  
            var h = s.substring(11,13);  
            var min = s.substring(14,16);  
            var sec = s.substring(17,19);
            if (!isNaN(y) && !isNaN(m) && !isNaN(d) && !isNaN(h) && !isNaN(min) && !isNaN(sec)){  
                return new Date(y,m-1,d,h,min,sec);  
            } else {  
                return new Date();  
            }  
        }
    </script>
    </div>
    <div id="slot_user-info-more"
        class="easyui-tabs theme-tab-blue-line theme-tab-body-unborder"
        data-options="tools:'#tab-tools',fit:true">
        <div title="RTP" id="slot_charts-layout_rtp">
            <div id="slot_RTP_charts" style="height: 400px;"></div>
            <script type="text/javascript">
                $(function() {
                    $('#slot_RTP_charts')
                            .highcharts(
                                    {
                                        chart : {
                                            type : 'spline',
                                            events : {
                                                load : function() {
    
                                                }
                                            }
                                        },
                                        title : {
                                            text : 'RTP'
                                        },
                                        subtitle : {
                                            text : 'UTC Every one minute refresh data'
                                        },
                                        xAxis : {
                                        	categories: [],
                                            name : 'spin count',
                                            labels: { 
                                                rotation: 45, //Inclination
                                            }
                                        },
                                        yAxis : {
                                            title : {
                                                text : 'percent (%)'
                                            },
                                            min : 0,
                                            minorGridLineWidth : 0,
                                            gridLineWidth : 0,
                                            alternateGridColor : null,
                                            plotBands : [ { // Light air
                                                from : 0.0,
                                                to : 1.5,
                                                color : 'rgba(68, 170, 213, 0.1)',
                                                label : {
                                                    text : 'Light air',
                                                    style : {
                                                        color : '#606060'
                                                    }
                                                }
                                            }, { // Light breeze
                                                from : 1.5,
                                                to : 3.3,
                                                color : 'rgba(0, 0, 0, 0)',
                                                label : {
                                                    text : 'Light breeze',
                                                    style : {
                                                        color : '#606060'
                                                    }
                                                }
                                            }, { // Gentle breeze
                                                from : 3.3,
                                                to : 5.5,
                                                color : 'rgba(68, 170, 213, 0.1)',
                                                label : {
                                                    text : 'Gentle breeze',
                                                    style : {
                                                        color : '#606060'
                                                    }
                                                }
                                            }, { // Moderate breeze
                                                from : 5.5,
                                                to : 8,
                                                color : 'rgba(0, 0, 0, 0)',
                                                label : {
                                                    text : 'Moderate breeze',
                                                    style : {
                                                        color : '#606060'
                                                    }
                                                }
                                            }, { // Fresh breeze
                                                from : 8,
                                                to : 11,
                                                color : 'rgba(68, 170, 213, 0.1)',
                                                label : {
                                                    text : 'Fresh breeze',
                                                    style : {
                                                        color : '#606060'
                                                    }
                                                }
                                            }, { // Strong breeze
                                                from : 11,
                                                to : 14,
                                                color : 'rgba(0, 0, 0, 0)',
                                                label : {
                                                    text : 'Strong breeze',
                                                    style : {
                                                        color : '#606060'
                                                    }
                                                }
                                            }, { // High wind
                                                from : 14,
                                                to : 15,
                                                color : 'rgba(68, 170, 213, 0.1)',
                                                label : {
                                                    text : 'High wind',
                                                    style : {
                                                        color : '#606060'
                                                    }
                                                }
                                            } ]
                                        },
                                        tooltip : {
                                            valueSuffix : 'per'
                                        },
                                        plotOptions : {
                                            spline : {
                                                lineWidth : 4,
                                                states : {
                                                    hover : {
                                                        lineWidth : 5
                                                    }
                                                },
                                                marker : {
                                                    enabled : false
                                                }
                                            }
                                        },
                                        series : [{
                                                    name : 'RTP',
                                                    data : []
    
                                                }],
                                        navigation : {
                                            menuItemStyle : {
                                                fontSize : '10px'
                                            }
                                        }
                                    });
                });
    
                document.addEventListener("DOMContentLoaded", function() {
                    var chart = $('#slot_RTP_charts').highcharts();
                    chart.reflow();
                });
            </script>
        </div>
    </div>
    <div id="slot_tab-tools">
	    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-set'"></a>
	</div>
</div>

</body>
</html>