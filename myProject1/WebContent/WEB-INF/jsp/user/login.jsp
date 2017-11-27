<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>个人项目 | 登录</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="../bower_components/bootstrap/dist/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="../bower_components/font-awesome/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="../bower_components/Ionicons/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../dist/css/AdminLTE.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="../plugins/iCheck/square/blue.css">

  <!-- Google Font -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
	
  <style type="text/css">
  	.kech{ background-image: url(../images/background.jpg) ;background-size:100%;background-repeat: no-repeat;}
  </style>	

</head>



<body class="kech" >
<div class="login-box">
  <div class="login-logo">
    <a href="../index.jsp"><b>用户</b>登录</a>
  </div>
  <input type="hidden" id="alertMessage"  value="${message}" />
  <!-- /.login-logo -->
  <div class="login-box-body">
    <p class="login-box-msg">请输入账号和密码</p>
	
    <form action="goLogin" method="post">
      <div class="form-group has-feedback">
        <input type="text"   name="userAccount"  class="form-control" placeholder="Account">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" name="password" class="form-control" placeholder="Password">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="row">
      	<input type="text" name="validCode" style="width:100px;float:left;" class="form-control" />
      	<img id="img" src="../authImage"  style="float: left;"  />
        <a href='#' onclick="javascript:changeImg()" style="float: left;"><label style="color:#72AFD2;">看不清？</label></a>
      </div>
      
      <div class="row">
        <div class="col-xs-8">
          <div class="checkbox icheck">
            <label>
              <input type="checkbox"> 记住密码
            </label>
          </div>
        </div>
        <!-- /.col -->
        <div class="col-xs-4">
          <button type="submit" class="btn btn-primary btn-block btn-flat">登录</button>
        </div>
        <!-- /.col -->
      </div>
    </form>

    <div class="social-auth-links text-center" style="display:none;">
      <p>- 或 -</p>
      <a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-facebook"></i> 通过Facebook登录</a>
      <a href="#" class="btn btn-block btn-social btn-google btn-flat"><i class="fa fa-google-plus"></i> 通过google登录</a>
    </div>
    <!-- /.social-auth-links -->

    <a href="#">忘记密码</a><br>
    <a href="register" class="text-center">注册新用户</a>

  </div>
  <!-- /.login-box-body -->
</div>
<!-- /.login-box -->
<jsp:include page="../commons/modal.jsp"></jsp:include>	

<!-- jQuery 3 -->
<script src="../bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="../plugins/iCheck/icheck.min.js"></script>
<script>
  $(function () {
    
  });
  
$(function(){
	if($("#alertMessage").val() != null && $("#alertMessage").val() != undefined && $("#alertMessage").val() != ""){
		$("#execute").hide();
		$("#modal").modal();
		
		$("#modalTitle").text("执行操作");
		$("#modalContext").text("操作成功！");
	}
	
	
	  /* $('input').iCheck({
	    checkboxClass: 'icheckbox_square-blue',
	    radioClass: 'iradio_square-blue',
	    increaseArea: '20%' // optional
	  }); */
})

function alertMessage(){
	if($("#alertMessage").val() != null && $("#alertMessage").val() != undefined){
		$("#execute").hide();
		$("#modal").modal();
		
		$("#modalTitle").text("执行操作");
		$("#modalContext").text("操作成功！");
	}
	
}
  
  function changeImg(){
      var img = document.getElementById("img"); 
      img.src = "../authImage?date=" + new Date();;
  }
  
</script>
</body>
</html>