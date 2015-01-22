<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <title>DHgate Picture Search</title>
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <!-- 引入 Bootstrap -->
      <link href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">

      <!-- HTML5 Shim 和 Respond.js 用于让 IwE8 支持 HTML5元素和媒体查询 -->
      <!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
      <!--[if lt IE 9]>
         <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
         <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
      <![endif]-->
   </head>
   <body>

      <!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
      <script src="https://code.jquery.com/jquery.js"></script>
      <!-- 包括所有已编译的插件 -->
      <script src="js/bootstrap.min.js"></script>
      
   <nav class="navbar navbar navbar-inverse navbar-static-top" role="navigation">
   <div class="navbar-header">
      <a class="navbar-brand" href="www.dhgate.com" >    
           <span class="glyphicon glyphicon-home" title="回主页" > DHgate Picture</span>
                   <span class="icon-bar"></span>
         <span class="icon-bar"></span>
         <span class="icon-bar"></span>　
      </a>
   </div>
   <div>
   </div>
</nav>



<div style="padding: 100px 100px 10px;">
	<img src="Dh.png" />
</div>
<div style="padding: 100px 100px 10px;">
   <form class="bs-example bs-example-form" role="form"  action="/DHgate_Picture_Search/pic/get" method="GET">
      <div class="row">
         <div class="col-lg-6">
            <div class="input-group  input-group-lg ">
               <input type="text" class="form-control" name="img">
               <span class="input-group-btn">
                  <button class="btn btn-default" type="submit">
                     Go!
                  </button>
               </span>
            </div>
         </div>
      </div>
      <label for="name"></label>
      <div>
	    <label class="checkbox-inline">
	      <input type="radio" name="optionsRadiosinline" id="optionsRadios0" 
	         value="0" checked> ScalableColor
	   </label>
	   <label class="checkbox-inline">
	      <input type="radio" name="optionsRadiosinline" id="optionsRadios1" 
	         value="1"> ColorLayout
	   </label>
	    <label class="checkbox-inline">
	      <input type="radio" name="optionsRadiosinline" id="optionsRadios2" 
	         value="2" checked> CEDD
	   </label>
	   <label class="checkbox-inline">
	      <input type="radio" name="optionsRadiosinline" id="optionsRadios3" 
	         value="3"> PHOG
	   </label>
	   	   <label class="checkbox-inline">
	      <input type="radio" name="optionsRadiosinline" id="optionsRadios4" 
	         value="4"> EdgeHistogram
	   </label>
	  </div>
   </form>
</div>
   </body>
</html>