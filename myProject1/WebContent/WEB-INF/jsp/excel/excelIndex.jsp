<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../commons/commons_js.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>导出列表</title>
</head>

<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 头部 -->
		<jsp:include page="../commons/top.jsp" ></jsp:include>
		<!-- 左侧 -->
		<jsp:include page="../commons/left.jsp" ></jsp:include>
		
		<!-- 内容 -->
		
		<div class="content-wrapper">
			<section class="content-header">
		      <h1>Excel功能
		        <small>表格</small>
		      </h1>
		      <ol class="breadcrumb">
		        <li><a href="#"><i class="fa fa-dashboard"></i>主页</a></li>
		        <li><a href="#">Excel导出管理</a></li>
		        <li class="active">Excel功能</li>
		      </ol>
		    </section>
		    <!-- 表格 -->
		    <section class="content">
		      <div class="row">
		        <div class="col-md-12">
		    		<div class="box">
            <div class="box-header with-border">
              <h3 class="box-title">简单表格1</h3>
            </div>
            <!-- /.box-header -->
            <form action="toExcel" method="post" >
            
            <div class="box-body">
            	<div class="col-md-1">
            		<table class="table table-bordered text-center">
            			<tr>
            				<td style="padding: 2px;"><button type="button"  onclick="excelData()"  class="col-md-1 btn btn-block btn-primary"  >导出</button></td>
            			</tr>
            		</table>
            	</div>
            
              <table border="1" class="table table-responsive table-bordered table-striped  table-hover">
                <tr>
                  <th>序号</th>
                  <th>用户名称</th>
                  <th>用户账号</th>
                  <th>联系电话</th>
                </tr>
                
                <tbody>
                <!-- 显示数据库数据 -->
               	<c:forEach var="list" items="${pageInfo.list}" varStatus="status">
               		<tr>
               			<td>
               			<label><input type="radio" name="funid"  value="${list.userid }" >${status.index+1}</label>
               			</td>
               			<td>${list.username }</td>
               			<td>${list.useraccount }</td>
               			<td>${list.usercontact }</td>
               			
               		</tr>
               	</c:forEach>
                </tbody>	
                		
                <!-- 显示数据库数据 -->
                
              </table>
            </div>
            <!-- /.box-body -->
            <!-- 分页操作 -->
            <div class="box-footer clearfix">
              <ul class="pagination pagination-sm no-margin pull-right">
                <li><a href="#">&laquo;</a></li>
                <c:forEach  begin="1" end="${pageInfo.pages }"   varStatus="status1">
					<li><a href="">${status1.index}</a></li>
                </c:forEach>
                
                <li><a href="#">&raquo;</a></li>
              </ul>
            </div>
          	</form>
          </div>
          <!-- /.box -->
		    	</div>
		      </div>
		    </section>  		
		</div>
				
		<!-- 内容 -->
		
		<!-- 尾部 -->
		<jsp:include page="../commons/bottom.jsp" ></jsp:include> 
		
	</div>
	
	<script type="text/javascript">
		//导出功能
		function excelData(){
			window.location.href="toExcel";
		}
		
	</script>
	

</body>
</html>