<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../commons/commons_js.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>角色修改</title>
</head>
<!-- 引用js文件 -->
<script type="text/javascript" src="../js/role/index.js"></script>
<script type="text/javascript" src="../js/role/update.js"></script>

<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 头部 -->
		<jsp:include page="../commons/top.jsp" ></jsp:include>
		<!-- 左侧 -->
		<jsp:include page="../commons/left.jsp" ></jsp:include>
	
		<!-- 内容 -->
		<div class="content-wrapper">
			<!-- 内容排版 subTop-->
			<section class="content-header">
			
			  <h1>
		        	修改
		        <small>查看</small>
		      </h1>
		      <ol class="breadcrumb">
		        <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
		        <li><a href="#">角色管理</a></li>
		        <li class="active">角色功能</li>
		        <li>角色修改</li>
		      </ol>
			</section>
			<!-- 内容排版 subTop -->
			<!-- 需要显示的内容 -->
			<section class="content">
				<div class="row">
					<div class="col-md-12">
					<div class="box box-primary">
		            <div class="box-header with-border">
		              <h3 class="box-title">修改</h3>
		            </div>
					<form class="form-horizontal" action="updateRole" method="post" >
		              <div class="box-body">
		                
		                <div class="form-group">
		                  <label  class="col-sm-2 control-label">角色名称</label>
		
		                  <div class="col-sm-10">
		                    <input type="text" class="form-control" name="rolename" id="" value="${role.rolename }"  placeholder="添加功能名称">
		                  </div>
		                </div>
		                <div class="form-group">
		                  <label  class="col-sm-2 control-label">角色功能</label>
		
		                  <div class="col-sm-10">
		                    <div class="span12">
								<div class="accordion" id="accordion-726397">
									
									<c:forEach   items="${funList }" var="list" varStatus="status">
										<!-- 判断是否为顶级菜单 -->
										<c:if test="${list.funfathernode eq '0' }">
											<div class="accordion-group">
												<div class="accordion-heading">
													 <input type="checkbox" 
													   <c:forEach items="${funRoleList }" var="funRoleList" varStatus="funstatus">
													   	  <c:if test="${funRoleList.funid eq list.funid }">
													   	  	checked="checked"
													   	  </c:if>
													   </c:forEach>
													 
													  funid="${list.funid }" class="fatherNode manage"   /><a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion-726397" href="#accordion-element-${list.funid }">${list.funname }</a>
												</div>
												<c:forEach items="${funList }" var="subList" varStatus="status">
													<c:if test="${subList.funfathernode eq list.funid }">
														<div id="accordion-element-${list.funid }" class="accordion-body collapse">
															<div class="accordion-inner">
																&nbsp;&nbsp;&nbsp;<input type="checkbox"
																	<c:forEach items="${funRoleList }"  var="funRoleList"  varStatus="funstatus"  >
																		<c:if test="${funRoleList.funid eq subList.funid }">
																			checked="checked"
																		</c:if>						
																	</c:forEach>
																												
																
																 funid="${subList.funid }" class="manage" />${subList.funname }
															</div>
														</div>
													</c:if>
												</c:forEach>
												
											</div>	
										</c:if>
									</c:forEach>
									
								</div>
							</div>
		                    
		                  </div>
		                </div>
		               
		              </div>
		              <!-- /.box-body -->
		              <div class="box-footer">
		                <button type="button" class="btn btn-default">取消</button>
		                <button type="button" id="confirm" class="btn btn-info pull-right">确认</button>
		              	<!-- hidden element -->
		              	<input type="submit" value="确认" id="submit" style="display:none;" />
		              	<input type="hidden" value="" id="funids" name="funids" />
						<input type="hidden" value="${role.roleid }" name="roleid" >
		              </div>
		              <!-- /.box-footer -->
		            </form>					
		            </div>
					</div>
				</div>
				
			</section>
			<!-- 需要显示的内容 -->
		</div>	
		<!-- 内容 -->
		
		<!-- 尾部 -->
		<jsp:include page="../commons/bottom.jsp" ></jsp:include>
		
		
		
	</div>

</body>
</html>