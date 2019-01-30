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
                <li><div id="vb_totalRTP" class="gauge" data-value="88"></div>
                    <span>totalRTP</span></li>
                <li><div id="vb_totalBaseRTP" class="gauge" data-value="33"></div>
                    <span>totalBaseRTP</span></li>
                <li><div id="vb_totalEBRTP" class="gauge" data-value="44"></div>
                    <span>totalEBRTP</span></li>
                <li><div id="vb_deltaRTP" class="gauge" data-value="44"></div>
                    <span>deltaRTP</span></li>
                <li><div id="vb_deltaBaseRTP" class="gauge" data-value="55"></div>
                    <span>deltaBaseRTP</span></li>
                <li><div id="vb_deltaEBRTP" class="gauge" data-value="66"></div>
                    <span>deltaEBRTP</span></li>
                <li><div id="vb_jackpotCount" class="gauge" data-value="44"></div>
                    <span>jackpotCount</span></li>
                <li><div id="vb_user_count" class="gauge" data-value="66"></div>
                    <span>totalUserCount</span></li>
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
        <label>from time:&nbsp;&nbsp;</label><input  type="text" id="timeFrom"  data-options="formatter:ww3,parser:w3,required:true,editable:false" class="easyui-datetimebox" style="width: 280px;">&nbsp;&nbsp;&nbsp;&nbsp;<label>to time:&nbsp;&nbsp;</label><input type="text" id="timeTo"  data-options="formatter:ww3,parser:w3,required:true,editable:false" class="easyui-datetimebox" style="width: 280px;">&nbsp;&nbsp;
        <label>game id:&nbsp;&nbsp;</label>
	    <select class="easyui-combobox" id="gameId" style="width: 200px;height: 90%">
                <option value=19 selected="selected">v1 AmericanChampion 19</option>
                <option value=20>v1 showBall3 20</option>
                <option value=21>v1 showBall2 21</option>
                <option value=22>v1 showBall 22</option>
                <option value=23>v1 blackStar 23</option>
                <option value=24>v1 bingo3 24</option>
                <option value=38>v2 nineBalls 38</option>
                <option value=39>v2 turbo90 39</option>
                <option value=41>v2 pachinko3 41</option>
                <option value=42>v2 pharaos 42</option>
                <option value=45>v2 doubleBingo 45</option>
                <option value=48>v2 Pra Karamba 48</option>
                <option value=49>v2 silverBall 49</option>
                <option value=50>v2 aztec 50</option>
                <option value=51>v2 turboMania 51</option>
                <option value=52>v2 vipBingo 52</option>
                <option value=54>v2 hotBingo 54</option>
                <option value=56>v2 goldBall 56</option>
                <option value=57>v2 doubleTurbo90 57</option>
                <option value=61>v2 pachinko2 61</option>
                <option value=62>v2 tripleBonus 62</option>
                <option value=65>v2 bonusBingo 65</option>
                <!-- <option value=46>slot halloween 46</option>
                <option value=47>slot Era do Gelo 47</option>
                <option value=63>slot halloweenX 63</option>
                <option value=66>slot halloween25 66</option>
                 -->
        </select>&nbsp;&nbsp;&nbsp;&nbsp;
        <a onclick="rtpQuery()" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" style="background-color:rgb(240, 240, 240)">start</a>
        <div id="vb_progress" style="width:100%;"></div>
    </div>
   <script type="text/javascript">
	   var vb_gg1;var vb_gg2;var vb_gg3;var vb_gg4;var vb_gg5;var vb_gg6;var vb_gg7;
	   $(function() {
	       var dfltPer = {
        	   min : 0,
               max : 3000,
               donut : true,
               gaugeWidthScale : 0.6,
               counter : true,
               hideInnerShadow : true,
               symbol: "‰"
	       }
	       var dfltCount = {
	               min : 0,
	               max : 30000,
	               gaugeWidthScale : 0.6,
	               symbol: ""
	       }
	       
	       vb_gg1 = new JustGage({
	           id : 'vb_totalRTP',
	           defaults : dfltPer
	       });
	
	       vb_gg2 = new JustGage({
	           id : 'vb_totalBaseRTP',
	           defaults : dfltPer
	       });
	       vb_gg3 = new JustGage({
	           id : 'vb_totalEBRTP',
	           defaults : dfltPer
	       });
	       vb_gg4 = new JustGage({
	           id : 'vb_jackpotCount',
	           defaults : dfltCount
	       });
	       vb_gg5 = new JustGage({
	           id : 'vb_deltaRTP',
	           defaults : dfltPer
	       });
	       vb_gg6 = new JustGage({
	           id : 'vb_deltaBaseRTP',
	           defaults : dfltPer
	       });
	       vb_gg7 = new JustGage({
	           id : 'vb_deltaEBRTP',
	           defaults : dfltPer
	       });
	       vb_gg8 = new JustGage({
	           id : 'vb_user_count',
	           defaults : dfltCount
	       });
	   });
	// - - - - -- - sumlator - - - - - -- -  -
     /*   var vb_num1 = 500;
       var vb_num2 = 600;
       var vb_num3 = 700;
       var vb_num4 = 800;
       var vb_num5 = 900;
       var vb_num6 = 990;
       var vb_num7 = 100;
        var modifyVbValue = function (){
           vb_gg1.refresh(vb_num1);
           vb_gg2.refresh(vb_num2);
           vb_gg3.refresh(vb_num3);
           vb_gg4.refresh(vb_num4);
           vb_gg5.refresh(vb_num5);
           vb_gg6.refresh(vb_num6);
           vb_gg7.refresh(vb_num7);
           vb_num1++;
           vb_num2++;
           vb_num3++;
           vb_num4++;
           vb_num5++;
           vb_num6++;
           vb_num7++;
              if(vb_num1 > 30000 ||vb_num2 > 30000 || vb_num3 > 30000 ||vb_num4 > 30000 ||vb_num5 > 30000 || vb_num6 > 30000 ||vb_num7 > 30000){
                  vb_num1=120;
                  vb_num2=220;
                  vb_num3=330;
                  vb_num4=440;
                  vb_num5=550;
                  vb_num6=660;
                  vb_num7=770;
              }
              setTimeout("modifyVbValue()", 500);
          };
          
          modifyVbValue(); */
     // - - - - -- - sumlator - - - - - -- -  -
          
       function addProgressBar(){
    	   $('#vb_progress').progressbar({
               value: '0',
               width: '100%',
               height: '50',
               text: '{value}%'
           });
       }
          
       function changeRtpPro(){
    	   var vb_progress_value = $('#vb_progress').progressbar('getValue');
           if (vb_progress_value < 100){
               vb_progress_value += Math.floor(Math.random() * 10);
               $('#vb_progress').progressbar('setValue', vb_progress_value);
               setTimeout(arguments.callee, 200);
           }
       }
       
       function rtpQuery(){
    	   //progress
    	   //addProgressBar();
    	   //changeRtpPro();
    	   //加载遮罩效果
    	   EasyUILoad();
    	   
    	   var timeFrom = $('#timeFrom').datetimebox('getValue');
    	   var timeTo = $('#timeTo').datetimebox('getValue');
    	   //var gameId = $("input[name='gameId']").val();
    	   var gameId = $("#gameId").combobox("getValue");
    	   $(function(){
    		   //progress
    		   
    	        $.ajax({
    	            type:"GET",
    	            url:"/rtp/query/vb",
    	            dataType:"json",
    	            data:{timeFrom:timeFrom,timeTo:timeTo,gameId:gameId},
    	            success:function(data){
    	            	//隐藏遮罩效果
    	            	dispalyEasyUILoad();
    	            	
    	                var vb_rtpChart = $('#vb_RTP_charts').highcharts();
    	                
    	                var category0 = new Array();
    	                var seriesData0 = new Array();
    	                $.each(data.rtp,function(key,values){
    	                	category0.push(key);
    	                	seriesData0.push(parseFloat(values));
	   	                	//vb_rtpChart.series[0].addPoint([key, parseFloat(values)], true, true,true);  
    	                 });
    	                //get and set title
    	                var current_title = {
    	                	text: '[current game id:'+gameId+']  '+vb_rtpChart.title.textStr,	
    	                	style:{
    	                        color:"#ff0000"
    	                    }
    	                };
    	                vb_rtpChart.setTitle(current_title,null,true);
    	                
    	                vb_rtpChart.xAxis[0].setCategories(category0);
    	                vb_rtpChart.series[0].setData(seriesData0,true,true,true);
    	                
    	                var seriesData1 = new Array();
    	                $.each(data.baseRtp,function(key,values){
    	                	seriesData1.push(parseFloat(values));
    	                });
    	                vb_rtpChart.series[1].setData(seriesData1,true,true,true);
                        
    	                var seriesData2 = new Array();
    	                $.each(data.ebRtp,function(key,values){
    	                	seriesData2.push(parseFloat(values));
    	                });
    	                vb_rtpChart.series[2].setData(seriesData2,true,true,true);
    	                	
    	                vb_gg1.refresh(parseFloat(data.totalRTP)*1000);
    	                vb_gg2.refresh(parseFloat(data.totalBaseRTP)*1000);
    	                vb_gg3.refresh(parseFloat(data.totalEBRTP)*1000);
    	                vb_gg5.refresh(parseFloat(data.deltaRTP)*1000);
    	                vb_gg6.refresh(parseFloat(data.deltaBaseRTP)*1000);
    	                vb_gg7.refresh(parseFloat(data.deltaEBRTP)*1000);
    	                vb_gg4.refresh(parseFloat(data.jackpotCount));
    	                vb_gg8.refresh(parseFloat(data.user_count));
    	                
    	                //close progressBar
    	                //$('#vb_progress').progressbar('close');
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
    <div id="vb_user-info-more"
        class="easyui-tabs theme-tab-blue-line theme-tab-body-unborder"
        data-options="tools:'#tab-tools',fit:true">
    
        <div title="RTP" id="vb_charts-layout_rtp">
            <div id="vb_RTP_charts" style="height: 400px;"></div>
            <script type="text/javascript">
                $(function() {
                    $('#vb_RTP_charts')
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
                                            text : 'RTP | BaseRTP | EB RTP'
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
    
                                                },{
                                                    name : 'BaseRTP',
                                                    data : []
    
                                                },{
                                                    name : 'EB RTP',
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
                    var chart = $('#vb_RTP_charts').highcharts();
                    chart.reflow();
                });
                
                
                /* - - - - sumlator - - - - */
               /*  var vb_item_rtp = 0.0;
                var vb_item_base_rtp = 0.0;
                var vb_item_eb_rtp = 0.0;
                var vb_rtp_data = new Array();
                var vb_base_rtp_data = new Array();
                var vb_eb_rtp_data = new Array();
                
                var vb_rtpChart = null;
                $(function(){
                    vb_rtpChart = $('#vb_RTP_charts').highcharts();
                    //ä¸ä¿è¯ä»»å¡çº¿ç¨ååçæ§è¡é¡ºåº
                    // setInterval(refreshData, 500);  
                    
                    //ä¿è¯ä»»å¡çº¿ç¨ååçæ§è¡é¡ºåº  jsä¸ºäºä¿è¯ä»»å¡çååæ§è¡é¡ºåºä¼å­æ¾å°ä»»å¡éå
                    var modifyVbValue = function (){
                        refreshVbRtpData();
                        setTimeout(function(){
                        	modifyVbValue();
                        }, 500);
                    };
                    
                    modifyVbValue();
                });
                

                var updateVbPoint = true;

                function refreshVbRtpData(){
                    vb_item_rtp  =  Math.random().toFixed(1);
                    vb_item_base_rtp  =  Math.random().toFixed(1);
                    vb_item_eb_rtp  =  Math.random().toFixed(1);
                    if(vb_rtp_data.length == 100 || vb_base_rtp_data.length == 100 || vb_eb_rtp_data.length == 100){
                        vb_rtp_data.shift();
                        vb_base_rtp_data.shift();
                        vb_eb_rtp_data.shift();
                        updateVbPoint = false;
                    }
                    vb_rtp_data.push(parseFloat(vb_item_rtp));
                    vb_base_rtp_data.push(parseFloat(vb_item_base_rtp));
                    vb_eb_rtp_data.push(parseFloat(vb_item_eb_rtp));
                    
                    // ç¬¬2ä¸ªåæ°è¡¨ç¤ºæ¯å¦éç»ï¼ç¬¬3ä¸ªåæ°è¡¨ç¤ºæ¯å¦å¯ç¨å¨ç»ï¼ç¬¬4ä¸ªåæ°è¡¨ç¤ºæ¯å¦æ´æ°æ°æ®ç¹[æ°ç»é¿åº¦ä¸æ ·æ¶å»ºè®®false]
                    vb_rtpChart.series[0].setData(vb_rtp_data,true,true,updateVbPoint);
                    vb_rtpChart.series[1].setData(vb_base_rtp_data,true,true,updateVbPoint);
                    vb_rtpChart.series[2].setData(vb_eb_rtp_data,true,true,updateVbPoint); 
                     
                } */
                
                /* - - - - sumlator - - - - */
            </script>
    
        </div>
        <div title="ebPrice" id="vb_charts-layout_ebPrice">
            <div id="vb_ebPrice_charts" style="height: 400px;"></div>
            <script type="text/javascript">
                $(function() {
                    $('#vb_ebPrice_charts')
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
                                            text : 'ebPrice'
                                        },
                                        subtitle : {
                                            text : 'UTC Every one minute refresh data'
                                        },
                                        xAxis : {
                                            type : 'value'
                                        },
                                        yAxis : {
                                            title : {
                                                text : 'price ($)'
                                            },
                                            min : 0,
                                            minorGridLineWidth : 0,
                                            gridLineWidth : 0,
                                            alternateGridColor : null,
                                            plotBands : [ { // Light air
                                                from : 0.3,
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
                                            valueSuffix : ' $'
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
                                                },
                                                pointInterval : 2000,
                                                pointStart : 0
                                            }
                                        },
                                        series : [{
                                                    name : 'ebPrice',
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
                    var chart = $('#vb_ebPrice_charts').highcharts();
                    chart.reflow();
                });
                
                /* - - - - sumlator - - - - */
                var vb_item_ebPrice = 0;
                var vb_ebPrice_data = new Array();
                
                var vb_ebPriceChart = null;
                $(function(){
                    vb_ebPriceChart = $('#vb_ebPrice_charts').highcharts();
                    //ä¸ä¿è¯ä»»å¡çº¿ç¨ååçæ§è¡é¡ºåº
                    /* setInterval(refreshData, 500);  */
                    
                    //ä¿è¯ä»»å¡çº¿ç¨ååçæ§è¡é¡ºåº  jsä¸ºäºä¿è¯ä»»å¡çååæ§è¡é¡ºåºä¼å­æ¾å°ä»»å¡éå
                    var modifyVbEbPriceValue = function (){
                    	refreshVbEbPriceData();
                        setTimeout(function(){
                        	modifyVbEbPriceValue();
                        }, 500);
                    };
                    
                    modifyVbEbPriceValue();
                });
                

                var updateVbEbPricePoint = true;

                function refreshVbEbPriceData(){
                    vb_item_ebPrice  =  (Math.random()*20).toFixed(0);
                    if(vb_ebPrice_data.length == 100){
                        vb_ebPrice_data.shift();
                        updateVbEbPricePoint = false;
                    }
                    vb_ebPrice_data.push(parseFloat(vb_item_ebPrice));
                    
                    // ç¬¬2ä¸ªåæ°è¡¨ç¤ºæ¯å¦éç»ï¼ç¬¬3ä¸ªåæ°è¡¨ç¤ºæ¯å¦å¯ç¨å¨ç»ï¼ç¬¬4ä¸ªåæ°è¡¨ç¤ºæ¯å¦æ´æ°æ°æ®ç¹[æ°ç»é¿åº¦ä¸æ ·æ¶å»ºè®®false]
                    vb_ebPriceChart.series[0].setData(vb_ebPrice_data,true,true,updateVbEbPricePoint);
                     
                }
                
                /* - - - - sumlator - - - - */
            </script>
    
        </div>
        <div title="ebRoundPer" id="vb_charts-layout_ebRoundPer">
            <div id="vb_ebRoundPer_charts" style="height: 400px;"></div>
            <script type="text/javascript">
                $(function() {
                    $('#vb_ebRoundPer_charts')
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
                                            text : 'ebRoundPer'
                                        },
                                        subtitle : {
                                            text : 'UTC Every one minute refresh data[ebRound / spinCount]'
                                        },
                                        xAxis : {
                                            type : 'value'
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
                                                from : 0.3,
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
                                            valueSuffix : ' %'
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
                                                },
                                                pointInterval : 2000,
                                                pointStart : 0
                                            }
                                        },
                                        series : [{
                                                    name : 'ebRoundPer',
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
                    var chart = $('#vb_ebRoundPer_charts').highcharts();
                    chart.reflow();
                });
                
                /* - - - - sumlator - - - - */
                var vb_item_ebRoundPer = 0;
                var vb_ebRoundPer_data = new Array();
                
                var vb_ebRoundPerChart = null;
                $(function(){
                    vb_ebRoundPerChart = $('#vb_ebRoundPer_charts').highcharts();
                    //ä¸ä¿è¯ä»»å¡çº¿ç¨ååçæ§è¡é¡ºåº
                    /* setInterval(refreshData, 500);  */
                    
                    //ä¿è¯ä»»å¡çº¿ç¨ååçæ§è¡é¡ºåº  jsä¸ºäºä¿è¯ä»»å¡çååæ§è¡é¡ºåºä¼å­æ¾å°ä»»å¡éå
                    var modifyVbEbRoundPerValue = function (){
                    	refreshVbEbRoundPerData();
                        setTimeout(function(){
                        	modifyVbEbRoundPerValue();
                        }, 500);
                    };
                    
                    modifyVbEbRoundPerValue();
                });
                

                var updateVbEbRoundPerPoint = true;

                function refreshVbEbRoundPerData(){
                    vb_item_ebRoundPer  =  (Math.random()*1).toFixed(2);
                    if(vb_ebRoundPer_data.length == 100){
                    	vb_ebRoundPer_data.shift();
                    	updateVbEbRoundPerPoint = false;
                    }
                    vb_ebRoundPer_data.push(parseFloat(vb_item_ebRoundPer));
                    
                    // ç¬¬2ä¸ªåæ°è¡¨ç¤ºæ¯å¦éç»ï¼ç¬¬3ä¸ªåæ°è¡¨ç¤ºæ¯å¦å¯ç¨å¨ç»ï¼ç¬¬4ä¸ªåæ°è¡¨ç¤ºæ¯å¦æ´æ°æ°æ®ç¹[æ°ç»é¿åº¦ä¸æ ·æ¶å»ºè®®false]
                    vb_ebRoundPerChart.series[0].setData(vb_ebRoundPer_data,true,true,updateVbEbRoundPerPoint);
                }
                
                /* - - - - sumlator - - - - */
            </script>
        </div>
    </div>
    <div id="vb_tab-tools">
    <a href="javascript:void(0)" class="easyui-linkbutton"
        data-options="plain:true,iconCls:'icon-set'"></a>
</div>
</div>

<!--
            <span class="icons" style="font-size:28px;">&#xe601;</span>
            <a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-help'">å¨´å¬­ç¯</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-set'"></a>
            -->
</body>
</html>