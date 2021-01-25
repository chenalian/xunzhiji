<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- saved from url=(0051)https://onebugman.cn/semantic-ui/examples/login.php -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <!-- Standard Meta -->
  
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

  <!-- Site Properties -->
  <title>学生注册页面</title>
  <meta name="description" content="Semantic UI 是一款非常优秀的前端开发框架。它在用户体验的设计上与Bootstrap和Foundation相比，更胜一筹。中文文档和视频教程由“BUG先生公开课”友情出品。">
  <meta name="keywords" content="Semantic UI, BUG先生公开课, 中文文档, 视频教程, 前端框架, 模板主题, 网站设计,  Web框架, Web设计, Bootstrap, Foundation, html5, ui, library, framework, javascript">
  

  <link rel="stylesheet" type="text/css" href="../main_files/reset.css">
  <link rel="stylesheet" type="text/css" href="../main_files/site.css">

  <link rel="stylesheet" type="text/css" href="../main_files/container.css">
  <link rel="stylesheet" type="text/css" href="../main_files/grid.css">
  <link rel="stylesheet" type="text/css" href="../main_files/header.css">
  <link rel="stylesheet" type="text/css" href="../main_files/image.css">
  <link rel="stylesheet" type="text/css" href="../main_files/menu.css">

  <link rel="stylesheet" type="text/css" href="../main_files/divider.css">
  <link rel="stylesheet" type="text/css" href="../main_files/segment.css">
  <link rel="stylesheet" type="text/css" href="../main_files/form.css">
  <link rel="stylesheet" type="text/css" href="../main_files/input.css">
  <link rel="stylesheet" type="text/css" href="../main_files/button.css">
  <link rel="stylesheet" type="text/css" href="../main_files/list.css">
  <link rel="stylesheet" type="text/css" href="../main_files/message.css">
  <link rel="stylesheet" type="text/css" href="../main_files/icon.css">

  <script src="../main_files/jquery.min.js.下载"></script>
  <script src="../main_files/form.js.下载"></script>
  <script src="../main_files/transition.js.下载"></script>

  <style type="text/css">
    body {
      background-color: #DADADA;
    }
    body > .grid {
      height: 100%;
    }
    .image {
      margin-top: -100px;
    }
    .column {
      max-width: 450px;
    }
	@import url("https://fonts.googleapis.com/css?family=Montserrat:200,300,400,600");
.more-pens {
  position: fixed;
  left: 20px;
  bottom: 20px;
  z-index: 10;
  font-family: "Montserrat";
  font-size: 12px;
}

a.white-mode, a.white-mode:link, a.white-mode:visited, a.white-mode:active {
  font-family: "Montserrat";
  font-size: 12px;
  text-decoration: none;
  background: #212121;
  padding: 4px 8px;
  color: #f7f7f7;
}
a.white-mode:hover, a.white-mode:link:hover, a.white-mode:visited:hover, a.white-mode:active:hover {
  background: #edf3f8;
  color: #212121;
}

body {
  margin: 0;
  padding: 0;
  overflow: hidden;
  width: 100%;
  height: 100%;
  background: #000000;
}

.title {
  z-index: 10;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translateX(-50%) translateY(-50%);
  font-family: "Montserrat";
  text-align: center;
  width: 100%;
}
.title h1 {
  position: relative;
  color: #EEEEEE;
  font-weight: 600;
  font-size: 60px;
  padding: 0;
  margin: 0;
  line-height: 1;
  text-shadow: 0 0 30px #000155;
}
.title h1 span {
  font-weight: 600;
  padding: 0;
  margin: 0;
  color: #BBB;
}
.title h3 {
  font-weight: 200;
  font-size: 20px;
  padding: 0;
  margin: 0;
  line-height: 1;
  color: #EEEEEE;
  letter-spacing: 2px;
  text-shadow: 0 0 30px #000155;
}
  </style>
  <script>
  $(document)
    .ready(function() {
      $('.ui.form')
        .form({
          fields: {
            uid: {
              identifier  : 'uid',
              rules: [
                {
                  type   : 'empty',
                  prompt : 'Please enter your uid'
                },
                {
                  type   : 'length[6]',
                  prompt : 'Your uid must be at least 6 characters'
                } 
              ]
            },
            upwd: {
              identifier  : 'upwd',
              rules: [
                {
                  type   : 'empty',
                  prompt : 'Please enter your password'
                },
                {
                  type   : 'length[6]',
                  prompt : 'Your password must be at least 6 characters'
                }
              ]
            }
          }
        })
      ;
    })
  ;
  </script>

  
</head>
<body>
<div class="title">
<div class="ui middle aligned center aligned grid">
  <div class="column">
    <h2 class="ui teal image header">
      <img src="../main_files/logo.png" class="image">
      <div class="content">
        登录到账号
      </div>
    </h2>
    <form class="ui large form" action="Logincheck" method="post">
      <div class="ui stacked segment">
        <div class="field">
          <div class="ui left icon input">
            <i class="user icon"></i>
            <input type="text" name="uid" placeholder="用户名">
          </div>
        </div>
        <div class="field">
          <div class="ui left icon input">
            <i class="lock icon"></i>
            <input type="password" name="upwd" placeholder="密码">
          </div>
        </div>
         <div class="field">
          <div class="ui left icon input">
            <i class="user icon"></i>
            <input type="text" name="upwd2" placeholder="确认密码">
          </div>
        </div>
         <div class="field">
          <div class="ui left icon input">
            <i class="user icon"></i>
            <input type="text" name="upwd2" placeholder="身份证号">
          </div>
        </div>
        <div class="field">
          <div class="ui left icon input">
            <i class="user icon"></i>
            <input type="text" name="upwd2" placeholder="确认密码">
          </div>
        </div>
        <div class="field">
          <div class="ui left icon input">
            <i class="user icon"></i>
            <input type="text" name="upwd2" placeholder="确认密码">
          </div>
        </div>
        <div class="field">
          <div class="ui left icon input">
            <i class="user icon"></i>
            <input type="text" name="upwd2" placeholder="确认密码">
          </div>
        </div>
        <div class="field">
          <div class="ui left icon input">
            <i class="user icon"></i>
            <input type="text" name="upwd2" placeholder="确认密码">
          </div>
        </div>
        <div class="field">
          <div class="ui left icon input">
            <i class="user icon"></i>
            <input type="text" name="upwd2" placeholder="确认密码">
          </div>
        </div>
        <div class="field">
          <div class="ui left icon input">
            <i class="user icon"></i>
            <input type="text" name="upwd2" placeholder="确认密码">
          </div>
        </div>
        
        
        
        <div class="ui fluid large teal submit button">注册</div>
      </div>

      <div class="ui error message"></div>

    </form>

    <div class="ui message">
     <!--  新用户？ <a href="javascript:;" onclick="js_method()">注册</a>&nbsp;&nbsp; -->
	  <script>
			function js_method()
			{
				//alert("1");
				var result=confirm("注册企业点击确认，学生点击取消");
				if(result==true)
					{
						alert("企业");
						window.location.href="system/enterpriceR.jsp";
					}
				else {
					alert("学生");
					window.location.href="system/studentR.jsp";
				}
			}
	  </script>
  	<!-- <a href="main.jsp">游客登录？</a> -->
    </div>
  </div>
</div>
</div>
<style>
#cnzz_stat_icon_1275993213{
display:none;
}
</style>
</body></html>
<script>
let max_particles    = 100;
let particles        = [];
let frequency        = 100;
let init_num         = max_particles;
let max_time         = frequency*max_particles;
let time_to_recreate = false;

// Enable repopolate
setTimeout(function(){
  time_to_recreate = true;
}.bind(this), max_time)

// Popolate particles
popolate(max_particles);

var tela = document.createElement('canvas');
    tela.width = $(window).width();
    tela.height = $(window).height();
    $("body").append(tela);

var canvas = tela.getContext('2d');

class Particle{
  constructor(canvas, options){
    let colors = ["#feea00","#a9df85","#5dc0ad", "#ff9a00","#fa3f20"]
    let types  = ["full","fill","empty"]
    this.random = Math.random()
    this.canvas = canvas;
    this.progress = 0;

    this.x = ($(window).width()/2)  + (Math.random()*200 - Math.random()*200)
    this.y = ($(window).height()/2) + (Math.random()*200 - Math.random()*200)
    this.w = $(window).width()
    this.h = $(window).height()
    this.radius = 1 + (8*this.random)
    this.type  = types[this.randomIntFromInterval(0,types.length-1)];
    this.color = colors[this.randomIntFromInterval(0,colors.length-1)];
    this.a = 0
    this.s = (this.radius + (Math.random() * 1))/10;
    //this.s = 12 //Math.random() * 1;
  }

  getCoordinates(){
    return {
      x: this.x,
      y: this.y
    }
  }

  randomIntFromInterval(min,max){
      return Math.floor(Math.random()*(max-min+1)+min);
  }

  render(){
    // Create arc
    let lineWidth = 0.2 + (2.8*this.random);
    let color = this.color;
    switch(this.type){
      case "full":
        this.createArcFill(this.radius, color)
        this.createArcEmpty(this.radius+lineWidth, lineWidth/2, color)
      break;
      case "fill":
        this.createArcFill(this.radius, color)
      break;
      case "empty":
        this.createArcEmpty(this.radius, lineWidth, color)
      break;
    }
  }

  createArcFill(radius, color){
    this.canvas.beginPath();
    this.canvas.arc(this.x, this.y, radius, 0, 2 * Math.PI);
    this.canvas.fillStyle = color;
    this.canvas.fill();
    this.canvas.closePath();
  }

  createArcEmpty(radius, lineWidth, color){
    this.canvas.beginPath();
    this.canvas.arc(this.x, this.y, radius, 0, 2 * Math.PI);
    this.canvas.lineWidth = lineWidth;
    this.canvas.strokeStyle = color;
    this.canvas.stroke();
    this.canvas.closePath();
  }

  move(){

    this.x += Math.cos(this.a) * this.s;
    this.y += Math.sin(this.a) * this.s;
    this.a += Math.random() * 0.4 - 0.2;

    if(this.x < 0 || this.x > this.w - this.radius){
      return false
    }

    if(this.y < 0 || this.y > this.h - this.radius){
      return false
    }
    this.render()
    return true
  }

  calculateDistance(v1, v2){
    let x = Math.abs(v1.x - v2.x);
    let y = Math.abs(v1.y - v2.y);
    return Math.sqrt((x * x) + (y * y));
  }
}

/*
 * Function to clear layer canvas
 * @num:number number of particles
 */
function popolate(num){
  for (var i = 0; i < num; i++) {
   setTimeout(
     function(x){
       return function(){
         // Add particle
         particles.push(new Particle(canvas))
       };
     }(i)
     ,frequency*i);
  }
  return particles.length
 }

function clear(){
  // canvas.globalAlpha=0.04;
  canvas.fillStyle='#111111';
  canvas.fillRect(0, 0, tela.width, tela.height);
  // canvas.globalAlpha=1;
}

function connection(){
  let old_element = null
  $.each(particles, function(i, element){
    if(i>0){
      let box1 = old_element.getCoordinates()
      let box2 = element.getCoordinates()
      canvas.beginPath();
      canvas.moveTo(box1.x,box1.y);
      canvas.lineTo(box2.x,box2.y);
      canvas.lineWidth = 0.45;
      canvas.strokeStyle="#3f47ff";
      canvas.stroke();
      canvas.closePath();
    }

    old_element = element
  })
}

/*
 * Function to update particles in canvas
 */
function update(){
  clear();
  connection()
  particles = particles.filter(function(p) { return p.move() })
  // Recreate particles
  if(time_to_recreate){
    if(particles.length < init_num){ popolate(1);}
  }
  requestAnimationFrame(update.bind(this))
}

update()
</script><canvas width="1536" height="639"></canvas>