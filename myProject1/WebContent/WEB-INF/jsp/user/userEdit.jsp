<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../commons/commons_js.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户添加</title>
</head>

<!-- 引入js -->
<script type="text/javascript" src="../js/user/index.js"></script>

<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 头部 -->
		<jsp:include page="../commons/top.jsp" ></jsp:include>
		<!-- 左侧 -->
		<jsp:include page="../commons/left.jsp" ></jsp:include>
		
		<!-- 内容 -->
		<div class="content-wrapper">
			<section class="content-header">
		      <h1>用户功能
		        <small>修改</small>
		      </h1>
		      <ol class="breadcrumb">
		        <li><a href="#"><i class="fa fa-dashboard"></i>主页</a></li>
		        <li><a href="#">用户管理</a></li>
		        <li class="active">用户修改</li>
		      </ol>
		    </section>
			
			<!-- content -->
			<section class="content">
				<div class="row">
					<div class="col-md-12">
					<div class="box box-primary">
		            <div class="box-header with-border">
		              <h3 class="box-title">添加</h3>
		            </div>
					<form class="form-horizontal" action="updateUser"    method="post"  id="userAdd" >
		              <div class="box-body">
		              
		                <div class="form-group">
		                  <label  class="col-sm-2 control-label">用户昵称</label>
		
		                  <div class="col-sm-10">
		                    <input type="text" class="form-control" name="username" id="" value="${user.username }" placeholder="输入用户名称">
		                  </div>
		                </div>
		                
		                
		                <div class="form-group">
		                  <label  class="col-sm-2 control-label">用户邮箱</label>
		                  <div class="col-sm-10">
		                    <input type="text" class="form-control" name="useraccount" id="" value="${user.useraccount }"  placeholder="输入邮箱">
		                  </div>
		                </div>
		                
		                <div class="form-group">
		                  <label  class="col-sm-2 control-label">联系电话</label>
		                  <div class="col-sm-10">
		                    <input type="text" class="form-control" name="usercontact" id="" value="${user.usercontact }" placeholder="输入手机" />
		                  </div>
		                </div>
		                
		                <div class="form-group">
		                	<label  class="col-sm-2 control-label">用户角色</label>
		                	<div class="col-sm-10">
		                		<input type="hidden" value="" id="roles"  name="roles" />
		                		<c:forEach items="${roleList }" var="list" varStatus="status" >
		                			
		                			<div class="checkbox">
		                				<label>
		                					<!-- 这里是否checked -->
		                					<input type="checkbox" 
		                					<c:forEach items="${roleNameSet }" var="nameList" varStatus="statusSub" >
		                						<c:if test="${list.rolename eq nameList }">
		                							checked="checked"
		                						</c:if>
		                					</c:forEach>
		                					 class="checkboxRole" value="${list.roleid }" />${list.rolename }
		                				</label>
		                			</div>
		                			
		                		</c:forEach>
		                	</div>
		                </div>
		                
		              </div>
		              
		              <div class="box-footer">
		                <button type="button"   onclick="window.history.go(-1)" class="btn btn-default">取消</button>
		                <button type="button"   onclick="checkUpdate()" class="btn btn-info pull-right">确认</button>
		              </div>
		              <!-- /.box-footer -->
		              
		              <!-- hidden -->
		              <input type="hidden" name="userid" value="${user.userid }" />
		              
		            </form>					
		            </div>
					</div>
				</div>
			</section>
		
		</div>
		    
		
		
	</div>	
</body>
</html>