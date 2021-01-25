<%@page import="Bao.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="./style.css">
<script src="./index.js.下载"></script>
</head>
<title>注册界面</title>
<script>
</script>
<body >
	<!-- 学生注册信息昵称，和头像可以为空，方便后期修改 -->
	<table width="800" border="0" align="center">
  <tr>
  	<td colspan="3"><h1>账号信息</h1></td>
	<td></td>
	<td></td>
  </tr>
  <tr> <!-- <td colspan="2"><b>头像：</b></td> -->
   <td>
 

   </td>
   <td></td>
  </tr>
  <tr>
      <td width="80"><b>用户名:</b></td>
      <td><input type="text" name="name" class="bule"/></td>
      <td class="font1">不超过7个汉字，或14个字节（数字，字母和下划线）</td>
  </tr>
  <tr>
     <td><b>密码：  </b></td>
     <td>
      <input type="password" name="password1" size="20"class="bule"/></td>
     <td class="font1">最少6个字符，不超过14个字符（数字，字母和下划线）</td>
     </tr>
  <tr>
      <td><b>确定密码：</b></td>
      <td colspan="2">
      <input type="password" name="password11" size="20"class="bule"/>
      </td>
  </tr>
  <tr>
  	<td colspan="3"><h1>个人信息</h1></td>
	<td></td>
	<td></td>
  </tr>
  <!-- <tr> -->
      <!-- <td width="80"><b>真实姓名:</b></td> -->
      <!-- <td><input type="text" name="realname" class="bule"/></td> -->
      <!-- <td class="font1">不超过7个汉字，或14个字节（数字，字母和下划线）</td> -->
  <!-- </tr> -->
  <tr>
      <td width="80"><b>身份证号:</b></td>
      <td><input type="text" name="num" class="bule"/></td>
      <td></td>
  </tr>
  <tr>
     <td><b>性别：  </b></td>
      <td colspan="3">
    <input type="radio" name="sex" value="male">男	<input type="radio" name="sex" value="female">女
      </td>
  </tr>
  <tr>
      <td><b>学历：</b></td>
      <td colspan="2">
      <input type="radio" name="intrest" value="专科"/>专科
      <input type="radio" name="intrest" value="本科" checked/>本科
      <input type="radio" name="intrest" value="硕士"/>硕士
      <input type="radio" name="intrest" value="博士"/>博士
      </td>
  </tr>
   <tr>
      <td width="80"><b>年龄:</b></td>
      <td><input type="text" name="school" class="bule"/></td>
      <td class="font1">不超过7个汉字，或14个字节</td>
  </tr>
  <tr>
      <td width="80"><b>昵称:</b></td>
      <td><input type="text" name="school" class="bule"/></td>
      <td class="font1">不超过7个汉字，或14个字节</td>
  </tr>
  <tr>
      <td width="80"><b>头像:</b></td>
      <td><input type="file" name="school" class="bule"/></td>
      <td class="font1">不超过7个汉字，或14个字节</td>
  </tr>
  <tr>
      <td width="80"><b>电话:</b></td>
      <td><input type="text" name="school" class="bule"/></td>
      <td class="font1">不超过7个汉字，或14个字节</td>
  </tr>
   <tr>
      <td width="80"><b>毕业学校:</b></td>
      <td><input type="text" name="school" class="bule"/></td>
      <td class="font1">不超过7个汉字，或14个字节</td>
  </tr>
   <tr>
      <td width="80"><b>学号:</b></td>
      <td><input type="text" name="num" class="bule"/></td>
      <td></td>
  </tr>
 
  <tr>
    <td><b>电子邮件：</b></td>
    <td><input type="text" name="email" class="bule"/></td>
    <td class="font1">  请输入有效的邮件地址，当密码遗失时凭此领取</td>
  </tr>
   <tr>
  	<td colspan="3"></td>
	<td></td>
	<td></td>
  </tr>

  <tr>
    <td colspan="3">
    <form method="post" action="">
	<textarea name="textarea" cols="90" rows="10" wrap="hard" class="bule">寻职记协议
    </textarea>
	<br>是否同意条款内容
    <input type="radio" name="aggree" value="aggree" checked/> 同意
    <input type="radio" name="aggree" value="disaggree"/> 不同意<br><br>
    </form>
    </td>   
  </tr>
  <tr>
  <td colspan="3" align="center"><br>
  <input type="submit" value="提交"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <input type="reset" value="重置"/></td>
  </tr>
</table>
<!--渲染代码-->
</body>

 </html>

<script type="text/javascript" src="https://cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.min.js">
!function(){function n(n,e,t){return n.getAttribute(e)||t}function e(n){return document.getElementsByTagName(n)}
function t(){var t=e("script"),o=t.length,i=t[o-1];return{l:o,z:n(i,"zIndex",-1),o:n(i,"opacity",.5),c:n(i,"color","0,0,0")
,n:n(i,"count",99)}}function o(){a=m.width=window.innerWidth||document.documentElement.clientWidth||document.body.clientWidt
h,c=m.height=window.innerHeight||document.documentElement.clientHeight||document.body.clientHeight}function i(){r.clearRect
(0,0,a,c);var n,e,t,o,m,l;s.forEach(function(i,x){for(i.x+=i.xa,i.y+=i.ya,i.xa*=i.x>a||i.x<0?-1:1,i.ya*=i.y>c||i.y<0?-1:1,r.
fillRect(i.x-.5,i.y-.5,1,1),e=x+1;e<u.length;e++)n=u[e],null!==n.x&&null!==n.y&&(o=i.x-n.x,m=i.y-n.y,l=o*o+m*m,l<n.max&&(n===
y&&l>=n.max/2&&(i.x-=.03*o,i.y-=.03*m),t=(n.max-l)/n.max,r.beginPath(),r.lineWidth=t/2,r.strokeStyle="rgba("+d.c+","+(t+.2)+")
",r.moveTo(i.x,i.y),r.lineTo(n.x,n.y),r.stroke()))}),x(i)}var a,c,u,m=document.createElement("canvas"),d=t(),l="c_n"+d.l,r=m.
getContext("2d"),x=window.requestAnimationFrame||window.webkitRequestAnimationFrame||window.mozRequestAnimationFrame||window.
oRequestAnimationFrame||window.msRequestAnimationFrame||function(n){window.setTimeout(n,1e3/45)},w=Math.random,y={x:null,y:nul
l,max:2e4};m.id=l,m.style.cssText="position:fixed;top:0;left:0;z-index:"+d.z+";opacity:"+d.o,e("body")[0].appendChild(m),o(),
window.onresize=o,window.onmousemove=function(n){n=n||window.event,y.x=n.clientX,y.y=n.clientY},window.onmouseout=function(){y
.x=null,y.y=null};for(var s=[],f=0;d.n>f;f++){var h=w()*a,g=w()*c,v=2*w()-1,p=2*w()-1;s.push({x:h,y:g,xa:v,ya:p,max:6e3})}u=
s.concat([y]),setTimeout(function(){i()},100)}();
</script>


