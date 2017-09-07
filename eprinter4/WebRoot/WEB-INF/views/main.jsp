<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 	<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/pintuer.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/admin.css" type="text/css">
	<!-- <script src="resource/js/pintuer.js"></script> --> 
	<script src="<%=request.getContextPath() %>/resource/js/pintuer.js"></script>
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/css/main.css">
	
    <title>首页</title>
    <style>
     body
         {
            background-image: -moz-linear-gradient(top, rgba(0,0,0,0.5), rgba(0,0,0,0.5)), url("resource/images/background.jpg");
            background-image: -webkit-linear-gradient(top, rgba(0,0,0,0.5), rgba(0,0,0,0.5)), url("resource/images/background.jpg");
            background-image: -ms-linear-gradient(top, rgba(0,0,0,0.5), rgba(0,0,0,0.5)), url("resource/images/background.jpg");
            background-image: linear-gradient(top, rgba(0,0,0,0.5), rgba(0,0,0,0.5)), url("resource/images/background.jpg");
            background-attachment: fixed;
            background-position: center center;
            background-repeat: no-repeat;
            background-size: cover;
            text-align: center;
        }
        
    </style>
  </head>
  
  <body>
    <ul id="ul">
        <li class="mainpage1" style="color: white; width: 100%;height: 100%;padding-top: 5%;" >
            <div class="fadein-top" style="width: 60%; margin:0 auto">
                <p  style="margin-top:25% ; width: 70%;margin-left: 15%; color: white"><hr><strong style="font-size: 45px;">EPrinter在线打印系统</strong><br><h3>让您的打印更加方便</h3><hr></p>
            </div>
            <form action="mainLogin">
            <div class="fadein-bottom" style="margin:0 auto; padding-top: 10%">
            <button class="button button-large bg-gray" type="submit">开始打印</button>
            </div>
            </form>
        </li>
        <li style="background-color:  width: 100%; height: 100%;padding-top: 100px;">
            <div class="introcontainer" style="width: 100%; height: 80%;margin: 0 auto;">
            <div class="introHead" ><p class="introTitle" style=""><strong style="font-size: 48px;">EPrinter介绍</strong></p></div>
            <div>
                <div class="intro" >
                    <div style="height: 30%">
                        <p class="text-center" style="border: none; width: 80%;height:20% margin:0 auto;font-size: 22px;background-color: ;padding-top: 22%; padding-left:15%;color: white">告别繁琐的U盘打印</p>
                    </div>
                    <div style="height: 70%">
                        <span style="margin-left: -30px;"><img src="resource/images/usb.png" style="height: 200px; width:160px;margin-top: 10%"></span>
                    </div>
                </div>
                <div class="intro" >
                    <div style="height: 70% ">
                        <p class="text-center" style="border: none; width: 80%;height:20% margin:0 auto;font-size: 22px;background-color: ;padding-top: 22%; padding-left:15%;color: white ">公共文档提高整体办公效率</p>
                    </div>
                    <div style="height: 100%">
                        <span style="margin:0 auto"><img src="resource/images/公共文档.png" style="height: 250px; width:100%; margin-top:-50%"></span>
                    </div>
                </div>
                <div class="intro">
                    <div style="height: 70%">
                        <p class="text-center" style="border: none; width: 80%;height:20% margin:0 auto;font-size: 22px;background-color: ;padding-top: 22%; padding-left:15%;color: white ">支持多种格式文档打印</p>
                    </div>
                    <div style="height: 70%">
                        <span style="margin-left: -30px;"><img src="resource/images/多种格式.png" style="height: 300px; width:420px;margin-top:-50%"></span>
                    </div>
                </div>
            </div>
                <!-- <span class="introTitle" style="top: 120px;"><strong style="font-size: 45px;">EPrinter介绍</strong><br><hr><br>
                <p><h2>与以往的打印方式不同，在线打印无需进行繁复的拷贝、U盘、拷贝、打印过程，轻轻点击鼠标，立刻就能打印</p></h2><br>
                <span><img src="img/UDisc.png" style="height: 300px;width: 490px;"></span>
                <p><h2>公共文档的实现使得整体打印办公效率得到提高</p></h2><br>
                <span><img src="#" style="height: 300px; width:490px; "></span>
                <p><h2>支持多种格式文档打印</p></h2></span> -->
            </div>
        </li>
   
        <li style="height: 250px;background-color: #263639;margin-top:20%">
            <div class="widget ">
                <h3>联系我们</h3>       
                <div class="contact_info_widget " id="contact" >
                    <p style="color: white"><i class="icon-envelope">&nbsp;&nbsp;&nbsp;</i>ak_39@qq.com</p>
                    <p><i class="icon-phone-square">&nbsp;&nbsp;&nbsp;</i>+86 18896937173</p>
                    <p><i class="icon-home">&nbsp;&nbsp;&nbsp;</i> 江苏省 苏州市 独墅湖苏州研究院</p>
                </div>
            </div>
        </li>
    </ul>
    <div class="nav">
        <div class="logo">
            <span style="color: white; margin-top: -18px;margin-left: -5px; font-size: 45px;">EPrinter</span><br>
            <span href="" style="margin-top: 35px; color: white; font-size: 14px;">在线打印系统</span>

            <div id="background" style="top: 100px; " ></div>
        </div>
        <div class="mainNav">
        <ol id="ol" >
            <li>首页</li>
            <li>产品介绍</li>
            <li>联系我们</li>
        </ol>
        </div>

    </div>
<script>
    //需求：给所有盒子添加颜色，点击ol的li，页面跳转到ul中相应的li
    //步骤：
    //1、利用数组给所有盒子添加颜色
    //2、缓动框架移动最顶端
    //3、移动到指定位置（给ol中的li绑定索引值，获取对应的ul中的li距离顶端的距离，赋值给target，好让页面跳转
    //4、屏幕滑动，记录屏幕的位置

    var ul = document.getElementById("ul");
    var ol = document.getElementById("ol");
    var ulLis = ul.children;
    var olLis = ol.children;
    var oPicHeigth= document.getElementById('background');
    oPicHeigth.style.height = olLis.height;
   /* var arr = ["#1d953f","#78cdd1","#45b97c","#d3d7d4"];*/

    var timer = null,target = 0,leader = 0;

    window.onscroll = function () {
        //屏幕滑动，给屏幕目前所在的位置赋值。
      /*  leader = scroll().top;*/
    }

    for(var i=0;i<olLis.length;i++){
        //为每一个盒子上色，ul和ol中的li对应颜色
        /*ulLis[i].style.backgroundColor = arr[i];
        olLis[i].style.backgroundColor = arr[i];*/

        olLis[i].index = i;
        olLis[i].onclick = function(){
            //给目标位置赋值(小盒子对应的大盒子距离顶部的距离)
            target = ulLis[this.index].offsetTop;
            clearInterval(timer);
            timer = setInterval(function(){
                var step = (target-leader)/10;
                step = step>0?Math.ceil(step):Math.floor(step);
                leader = leader+step;
                window.scrollTo(0,leader);
                if(target == leader){
                    clearInterval(timer);
                }
            },30)
        }
    }

</script>
  </body>
</html>
