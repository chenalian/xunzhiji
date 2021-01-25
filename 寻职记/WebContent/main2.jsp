<%@page import="Bao.Page"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page isELIgnored="false"%><!--引用EL-->
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!--引用JSTL-->
<!DOCTYPE html>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>寻职记主页</title>
	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	
	<style type="text/css">
*{
    padding: 0px;
    margin: 0px;
}   
#div1{
    width:70px;
    height:70px;
    top: 400px;
    position: absolute;/*绝对定位*/
	background-image: image('./images/user.jpg');
}
		
</style>
    <script type="text/javascript">
window.onload=function(){
    //var oDiv=document.getElementById('div1');//获得div元素
     
    /* var x=1,y=1;
    setInterval(function(){//定时器
        var hei=oDiv.offsetHeight;//获得div的高度(加边框)
        var k_hei=document.documentElement.clientHeight;//获得可视区域的高度
        var max_top=k_hei-hei;//获得可以达到的最大高度
 
        var wid=oDiv.offsetWidth;//获得div的宽度(加边框)
        var k_wid=document.documentElement.clientWidth;//获得可视区域的宽度
        var max_left=k_wid-wid;//获得可以达到的最大宽度
 
        var left=oDiv.offsetLeft;//获得瞬时的离左边的距离
        var top=oDiv.offsetTop;//获得离上边的距离
        var new_left=left+1*x;//每过一个间隔，往右移一个像素
        var new_top=top+1*y;//每过一个间隔，往下移一个像素
        if(new_top>=max_top||new_top==0){//当新位置离上边距离大于最大位置，或新位置离上边距离等于0时(向上走时)，垂直方向上反向
                y=-1*y;
        }
        if(new_left>=max_left||new_left==0){//当新位置离左边距离大于最大位置，或新位置离左边距离等于0时(向左走时)，左右方向上反向
                x=-1*x;
        }
        oDiv.style.left=new_left+'px';//赋值(离左边的距离)
        oDiv.style.top=new_top+'px';//赋值(离右边的距离)
    },10); */
 
}
 
    </script>
</head>
<body>

<div id="div1"><a href="aboutus.jsp"><img width="70px" height="70px" src="images/logo.png"></a></div>
<ul width="1024px" class="nav nav-pills" style="color:#E40E12; font-size: 20px; background-color:#EAEAEA" >
  <li><a href="QueryJobByPage"><span class="glyphicon glyphicon-home">Home</span></a></li>
   <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                <span class="glyphicon glyphicon-user">职位</span>
                    
                    <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="findjobsbytiaojian?tiaojian=职位&shaixuan=程序员">程序员</a></li>
                    <li><a href="findjobsbytiaojian?tiaojian=职位&shaixuan=厂长">厂长</a></li>
                    <li><a href="findjobsbytiaojian?tiaojian=职位&shaixuan=服务员">服务员</a></li>
                    <li ><a href="findjobsbytiaojian?tiaojian=职位&shaixuan=教师">教师</a></li>
                    <li><a href="findjobsbytiaojian?tiaojian=职位&shaixuan=铁匠">铁匠</a></li>
                    <li><a href="findjobsbytiaojian?tiaojian=职位&shaixuan=导游">导游</a></li>
                    <li><a href="findjobsbytiaojian?tiaojian=职位&shaixuan=摄影师">摄影师</a></li>
                </ul>
   </li>
  <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    
                    <span class="glyphicon glyphicon-usd">月薪</span>
                    <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="findjobsbytiaojian?tiaojian=月薪&money1=2000&money2=3000">2000-3000</a></li>
                    <li><a href="findjobsbytiaojian?tiaojian=月薪&money1=3000&money2=4000">3000-4000</a></li>
                    <li><a href="findjobsbytiaojian?tiaojian=月薪&money1=4000&money2=5000">4000-5000</a></li>
                    <li ><a href="findjobsbytiaojian?tiaojian=月薪&money1=5000&money2=6000">5000-6000</a></li>
                    <li><a href="findjobsbytiaojian?tiaojian=月薪&money1=6000&money2=7000">6000-7000</a></li>
                    <li><a href="findjobsbytiaojian?tiaojian=月薪&money1=7000&money2=8000">7000-8000</a></li>
                    <li><a href="findjobsbytiaojian?tiaojian=月薪&money1=8000&money2=9000">8000-9000</a></li>
                    <li><a href="findjobsbytiaojian?tiaojian=月薪&money1=9000&money2=100000">9000以上</a></li>
                </ul>
   </li>
   <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    
                    <span class="glyphicon glyphicon-map-marker">地点</span>
                    <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="findjobsbytiaojian?tiaojian=地点&shaixuan=北京">北京</a></li>
                    <li><a href="findjobsbytiaojian?tiaojian=地点&shaixuan=上海">上海</a></li>
                    <li><a href="findjobsbytiaojian?tiaojian=地点&shaixuan=广东">广东</a></li>
                    <li ><a href="findjobsbytiaojian?tiaojian=地点&shaixuan=厦门">厦门</a></li>
                    <li><a href="findjobsbytiaojian?tiaojian=地点&shaixuan=山东">山东</a></li>
                    <li><a href="findjobsbytiaojian?tiaojian=地点&shaixuan=江西">江西</a></li>
                </ul>
   </li>
    <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    
                     <span class="glyphicon glyphicon-compressed">公司</span>
                    <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="findjobsbytiaojian?tiaojian=公司&shaixuan=阿里巴巴">阿里巴巴</a></li>
                    <li><a href="findjobsbytiaojian?tiaojian=公司&shaixuan=腾讯"">腾讯</a></li>
                    <li><a href="findjobsbytiaojian?tiaojian=公司&shaixuan=小米">小米</a></li>
                    <li ><a href="findjobsbytiaojian?tiaojian=公司&shaixuan=华为">华为</a></li>
                    <li><a href="findjobsbytiaojian?tiaojian=公司&shaixuan=联想">联想</a></li>
                    <li><a href="findjobsbytiaojian?tiaojian=公司&shaixuan=美的">美的</a></li>
                </ul>
   </li>
    <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    
                    <span class="glyphicon glyphicon-screenshot">人数</span>
                    <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="findjobsbytiaojian?tiaojian=人数&shaixuan=1">1</a></li>
                    <li><a href="findjobsbytiaojian?tiaojian=人数&shaixuan=2">2</a></li>
                    <li><a href="findjobsbytiaojian?tiaojian=人数&shaixuan=3">3</a></li>
                    <li ><a href="findjobsbytiaojian?tiaojian=人数&shaixuan=4">4</a></li>
                    <li><a href="findjobsbytiaojian?tiaojian=人数&shaixuan=5">5</a></li>
                    <li><a href="findjobsbytiaojian?tiaojian=人数&shaixuan=6">6人以上</a></li>
                </ul>
   </li>
   <li style="float:right">
   					<c:if test="${uid==null}">
						<a href="login.jsp"><img src="images/user.jpg">${state}</a>
					</c:if>
					<c:if test="${state eq 'student'}">
						<c:if test="${uid!=null}">
						<a href="student/user.jsp">${uid}<img src="images/user.jpg">${state}</a>
						</c:if>
					</c:if>
					<c:if test="${state eq 'enterprice'}">
						<c:if test="${uid!=null}">
						<a href="enterprice/user.jsp">${uid}<img src="images/user.jpg">${state}</a>
						</c:if>
					</c:if>
					<c:if test="${state eq 'administrator'}">
						<c:if test="${uid!=null}">
						<a href="administrator/user.jsp">${uid}<img src="images/user.jpg">${state}</a>
						</c:if>
					</c:if>
   	
   </li>
  <!--  <li style="float:right"><a href="SearchJobs"><img src="images/search.jpg"></a> </li> -->

   
</ul>
<table class="table" height="680px">
	<thead>
		
	</thead>
	<tboby>
		<tr>
			<td width="20%" bgcolor="#F2F2F2">
				<DIV id="scrollobj" style="white-space:nowrap;overflow:hidden;width:200px;margin: auto" width="100px">
					<span>
					<img border="0" src="images/01.jpg" height="200" width="200" > 
					<img border="0" src="images/02.jpg" height="200" width="200" >
					<img border="0" src="images/03.jpg" height="200" width="200" > 
					<img border="0" src="images/04.jpg" height="200" width="200" > 
					<img border="0" src="images/05.jpg" height="200" width="200" > 
					<img border="0" src="images/06.jpg" height="200" width="200" >  
					<img border="0" src="images/07.jpg" height="200" width="200" >  
					</span>
					</DIV>
					<script language="javascript" type="text/javascript">
					    function scroll(obj) {
					        var tmp = (obj.scrollLeft)++;
					        if (obj.scrollLeft==tmp) obj.innerHTML += obj.innerHTML;
					         if (obj.scrollLeft>=obj.firstChild.offsetWidth) obj.scrollLeft=0;
					    }
					    setInterval("scroll(document.getElementById('scrollobj'))",20);
				</script>
			</td>
				<td width="60%" bgcolor="#FFFAFA">
				  <table class="table" height="600px" align="center">
					<thead>

					</thead>

					<tbody >
					<%
				// 获取page信息
						Page a=(Page)request.getAttribute("jobs");
				
					%>
					<tr heighr="200px" align="center">
						<c:forEach items="<%=a.getJobs()%>" var="keyword" varStatus="id" begin="0" end="3">
							<td width=60px height=60px>
								<img width=130px height=130px src="./images/${keyword.getQid()}.jpg"><br/>
								<%-- 企业名称：<c:out value="${keyword.getQname()}" default="查询有误"></c:out><br/> --%>
								<font color="#090909">职位:<c:out value="${keyword.getPost()}" default="查询有误"></c:out><br/></font>
      							<font color="red">薪水:<c:out value="${keyword.getSalary()}" default="查询有误"></c:out><br/></font>
     						    <font color="#090909">人数:<c:out value="${keyword.getNsm()}" default="查询有误"></c:out><br/></font>
     						    <font color="#090909" size="4px">截止时间:<div id=${keyword.getJobid()} ></div></font> <br/>
     
							     <script>
							     	// 定时器 倒计时 
									 //window.onload = function () {
							
							            
									  var temp="<c:out value='${keyword.geteTime()}' default='查询有误'></c:out>";
									  var endTime = new Date(temp);//获取未来结束的时间
									  var jobid="<c:out value='${keyword.getJobid()}' default='查询有误'></c:out>";
							            setInterval(fun,1000,jobid,endTime);//开启定时器
							            function fun(jobid,endTime) {
							            	
							            	//alert("jobid"+jobid);
							            	//alert("每秒钟执行一次")
							                var newTime = new Date();//得到最新的时间
							                var ms = parseInt((endTime - newTime) / 1000); //得到毫秒，并取整
											
							                var s = parseInt(ms % 60);//秒
							                var m = parseInt((ms / 60) % 60); //分
							                var h = parseInt((ms / 3600) % 24);//小时
											
							                var day = parseInt((ms / 3600) /24);//天
							
											day<0? day="0"+day:day;
							                s<10? s="0"+s:s;
							                m<10? m="0"+m:m;
							                h<10? h="0"+h:h;
							                
							                document.getElementById(jobid).innerText= day+" 天 "+h +" 时 "+m+" 分 "+s+" 秒 ";
							        }
							     </script>
							     <a href="student/sendjianli.jsp?jobidtemp=${keyword.getJobid()}&qid=${keyword.getQid()}"  onmouseover="bigjianli(this)">  <font color="red"><span class="glyphicon glyphicon-send"></span></font></a>	
							</td>
							
						
						 
						 </c:forEach>
						 </tr>
						<tr heighr="200px" align="center">
						<c:forEach items="<%=a.getJobs()%>" var="keyword" varStatus="id" begin="4" end="7">
							<td width=60px height=60px>
								<img width=130px height=130px src="./images/${keyword.getQid()}.jpg"><br/>
<%-- 								企业名称：<c:out value="${keyword.getQname()}" default="查询有误"></c:out><br/> --%>
								<font color="#090909">职位:<c:out value="${keyword.getPost()}" default="查询有误"></c:out><br/></font>
      							<font color="red">薪水:<c:out value="${keyword.getSalary()}" default="查询有误"></c:out><br/></font>
     						    <font color="#090909">人数:<c:out value="${keyword.getNsm()}" default="查询有误"></c:out><br/></font>
     						    <font color="#090909" size="4px">截止时间:<div id=${keyword.getJobid()} ></div></font> <br/>
     
							     <script>
							     	// 定时器 倒计时 
									 //window.onload = function () {
							
							            
									  var temp="<c:out value='${keyword.geteTime()}' default='查询有误'></c:out>";
									  var endTime = new Date(temp);//获取未来结束的时间
									  var jobid="<c:out value='${keyword.getJobid()}' default='查询有误'></c:out>";
							            setInterval(fun,1000,jobid,endTime);//开启定时器
							            function fun(jobid,endTime) {
							            	
							            	//alert("jobid"+jobid);
							            	//alert("每秒钟执行一次")
							                var newTime = new Date();//得到最新的时间
							                var ms = parseInt((endTime - newTime) / 1000); //得到毫秒，并取整
											
							                var s = parseInt(ms % 60);//秒
							                var m = parseInt((ms / 60) % 60); //分
							                var h = parseInt((ms / 3600) % 24);//小时
											
							                var day = parseInt((ms / 3600) /24);//天
							
											day<0? day="0"+day:day;
							                s<10? s="0"+s:s;
							                m<10? m="0"+m:m;
							                h<10? h="0"+h:h;
							                
							                document.getElementById(jobid).innerText= day+" 天 "+h +" 时 "+m+" 分 "+s+" 秒 ";
							        }
							     </script>
							     <a href="student/sendjianli.jsp?jobidtemp=${keyword.getJobid()}&qid=${keyword.getQid()}"  onmouseover="bigjianli(this)">  <font color="red"><span class="glyphicon glyphicon-send" ></span></font></a>	
							</td>
							
						
						 
						 </c:forEach>
						 </tr>
						 
					</tbody>
				</table>
				
				<div align="center" style="font-size: 20px">
				
				 <div>
				 <%
				 	if(a.getCurrentPage()>1)
				 	{
				 		%>
				 			<a href="QueryJobByPage?page=<%=a.getCurrentPage()-1 %>"><span class="glyphicon glyphicon-arrow-left"></a>
				 		<% 
				 	}
				 %>
				  &nbsp;<font color="#090909">当前页面:<%=a.getCurrentPage() %></font> &nbsp;
				  
				  <%
					  if(a.getCurrentPage()*4<a.getTotalPage())
					  {
						 %>
						 	 <a href="QueryJobByPage?page=<%=a.getCurrentPage()+1 %>"><span class="glyphicon glyphicon-arrow-right"></span></a>
						 <%  
					  }
				  %>
				 
				  </div>
				</div>
			</td>
			
			<td width="20%" bgcolor="#F2F2F2">
				<DIV id="scrollobj1" style="white-space:nowrap;overflow:hidden;width:200px;margin: auto" width="100px">
					<span>
					<img border="0" src="images/02.jpg" height="200" width="200" > 
					<img border="0" src="images/03.jpg" height="200" width="200" >
					<img border="0" src="images/04.jpg" height="200" width="200" > 
					<img border="0" src="images/05.jpg" height="200" width="200" > 
					<img border="0" src="images/06.jpg" height="200" width="200" > 
					<img border="0" src="images/07.jpg" height="200" width="200" >  
					<img border="0" src="images/01.jpg" height="200" width="200" >  
					</span>
					</DIV>
					<script language="javascript" type="text/javascript">
					    function scroll(obj) {
					        var tmp = (obj.scrollLeft)++;
					        if (obj.scrollLeft==tmp) obj.innerHTML += obj.innerHTML;
					         if (obj.scrollLeft>=obj.firstChild.offsetWidth) obj.scrollLeft=0;
					    }
					    setInterval("scroll(document.getElementById('scrollobj1'))",20);
				</script>
			</td>
		</tr>
	</tboby>
</table>
</body>
</html>
<script>
	var array=$("li");
	var span=$("span");
	var i=0;
	var j=0;
	var k=1;
	function move(){
		j=(i+1)%6;
		
		k=(k+1)%6;
		k++;
		array[0].firstChild.src='pics/'+'pic'+k+'.jpg';//j
		span[i].className='';
		span[j].className='active';
		i++;
		i=i%6;
		setTimeout(move,1000);
	}
	
	
</script>