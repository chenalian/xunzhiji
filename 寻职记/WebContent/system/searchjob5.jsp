<%@page import="Bao.Job"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page isELIgnored="false"%><!--引用EL-->
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!--引用JSTL-->
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
	<style type="text/css">
		body, html,#allmap {width: 100%;height: 100%;overflow: hidden;margin:0;font-family:"΢ɭ҅ۚ";}
	</style>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=215qGFUvd4HaAp0O80aMAxXml6f8XQ2V"></script>
	<title>调取百度API</title>
</head>
<body>
	<div id="allmap"></div>
	<%
		// 将查询到的工作信息返回到该页面，存入js数组
	%>
	
<script type="text/javascript">
           
            var dizhi=[
            <%
        		List <Job> jobs=(List<Job>)request.getAttribute("searchjobs");
            	int i=0;
            	for(Job job:jobs)
            	{
            		
            		if(i<jobs.size()-1){
	            			%>
	            				{jobid:"<%=job.getJobid() %>",qid:"<%=job.getQid()%>",dizhi:"<%=job.getJobaddr()%>"},
	        				<%
            		}
            		else if(i==jobs.size()-1)// 表示最后一个工作地址
            		{
            				%>
            				{jobid:"<%=job.getJobid() %>",qid:"<%=job.getQid()%>",dizhi:"<%=job.getJobaddr()%>"}
            				<%
            		}
            		i++;
            	}
            %>
            ];
            
           alert("总共有"+dizhi.length+"个工作");
           var markerList = []
           // 创建地图
           var map = new BMap.Map("allmap");      
           map.centerAndZoom(new BMap.Point(116.404, 39.915), 11);      
           // 创建地址解析器实例     
           var myGeo = new BMap.Geocoder();      
           // 将地址解析结果显示在地图上，并调整地图视野  
           
          /*  var opts = {    
			    width : 250,     // 信息窗口宽度    
			    height: 100,     // 信息窗口高度    
			    title : "Hello"  // 信息窗口标题   
			}    
			var infoWindow = new BMap.InfoWindow("World", opts);  // 创建信息窗口对象    
			map.openInfoWindow(infoWindow, map.getCenter());      // 打开信息窗口 */
           
           
           dizhi.forEach(function(e,index){
        	   myGeo.getPoint(e.dizhi, function(point){      
				   if (point) {				   
					   map.centerAndZoom(point,16); 
					   var marker=new BMap.Marker(point);
					   map.addOverlay(marker);   
					   	marker.addEventListener
							("click",function () {
								//alert(index+"地址 "+dizhi[index].dizhi);
								// "<a href='student/sendJianli.jsp?qid=qwe&jobidtemp=hajdjk' >"+"我是超链接"+"</a>" 
								//var temp=dizhi[index].jobid;
								 var opts = {    
										    width : 250,     // 信息窗口宽度    
										    height: 100,     // 信息窗口高度    
										    title : "地址"+dizhi[index].dizhi+"  "+dizhi[index].jobid+" "+dizhi[index].qid    +"<br/>"+ "<a href='student/sendJianli.jsp?jobidtemp= "+dizhi[index].jobid+"&qid="+dizhi[index].qid+  "'>"   +"我是超链接"+"</a>" 
										}    
								var infoWindow = new BMap.InfoWindow("", opts);  // 创建信息窗口对象    
								map.openInfoWindow(infoWindow,point);      // 打开信息窗口
								
							});
					   markerList.push(marker)
						  // window.location.href="student/sendJianli.jsp?jobidtemp=${keyword.getJobid()}&qid=${keyword.getQid()}"; 
				   }
				});   
		   });
           
           
           //for(var i=0;i<dizhi.length;i++){
        	   
			   //var marker;
			   // var j=i;
        	  // myGeo.getPoint(dizhi[i].dizhi, function(point,a){      
				//   if (point) {
					   
				//	   var index;
				//	   dizhi.forEach(function(e,i){
				//		   if (e.dizhi == a.address) {
				//			   index = i;
				//		   }
				//	   });
					   
			
					   
				//	   map.centerAndZoom(point,16); 
				//	   var marker=new BMap.Marker(point);
				//	   map.addOverlay(marker);   
				//	   marker.j=i;
				//	   	marker.addEventListener
				//			("click",function () {
				//				alert(index);
				//			});
				//	   markerList.push(marker)
						  // window.location.href="student/sendJianli.jsp?jobidtemp=${keyword.getJobid()}&qid=${keyword.getQid()}"; 
				 //  }
				 
				//}, 
			 //  "北京市");
           //}
           function temp1(str)
           {
        	   alert(str);
           }
		   function temp(x)
           {
				alert(x);
           }
		   
		   function showIndex (i) {
			   alert(i)
		   }
		   
           // 地图的缩放
           map.enableScrollWheelZoom(true);
           
           // 用户定位
           var geolocation = new BMap.Geolocation();
      	 	geolocation.getCurrentPosition(function(r){
       		if(this.getStatus() == BMAP_STATUS_SUCCESS){
       			var mk = new BMap.Marker(r.point);
       			map.addOverlay(mk);
       			map.panTo(r.point);
       			alert('您的位置：'+r.point.lng+','+r.point.lat);
       		}
       		else {
       			alert('failed'+this.getStatus());
       		}        
       	},{enableHighAccuracy: true})
 </script>
</body>
</html>