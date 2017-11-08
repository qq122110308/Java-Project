<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../commons/commons_js.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>操作日志记录</title>
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
		      <h1>日志查看
		        <small>日志</small>
		      </h1>
		      <ol class="breadcrumb">
		        <li><a href="#"><i class="fa fa-dashboard"></i>主页</a></li>
		        <li><a href="#">日志管理</a></li>
		        <li class="active">日志功能</li>
		      </ol>
		    </section>
		    <!-- 表格 -->
		    <section class="content">
		      <div class="row">
		        <div class="col-md-12">
		    		<div class="box">
            <div class="box-header with-border">
              <h3 class="box-title">表格</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
            	<div class="col-md-3">
            		<table class="table table-bordered text-center ">
            			<tr>
            				<td style="padding: 2px;"><button type="button" class="col-md-1 btn btn-block btn-primary"  onclick="addData()">添加</button></td>
            				<td style="padding: 2px;"><button type="button" class="col-md-1 btn btn-block btn-info"  onclick="updateData()" >修改</button></td>
            				<td style="padding: 2px;"><button type="button" class="col-md-1 btn btn-block btn-danger"  onclick="deleteData()"  >删除</button></td>
            			</tr>
            		</table>
            	</div>
            
              <table border="1" class="table table-bordered table-hover">
                <tr>
                  <th>序号</th>
                  <th>名称</th>
                  <th>类型</th>
                  <th>时间</th>
                  <th>IP</th>
                </tr>
                
                <!-- 显示数据库数据 -->
                <tbody>
               	<c:forEach var="list" items="${pageInfo.list}" varStatus="status">
               		<tr>
               			<td>
               			<label><input type="radio" name="funid"  value="${list.logid }" >${status.index+1}</label>
               			</td>
               			<td>${list.logname }</td>
               			<td>${list.logtype }</td>
               			<td><fmt:formatDate value="${list.logcreate }"  pattern="yyyy-MM-dd" /></td>
               			<td>${list.logip }</td>
               			
               		</tr>
               	</c:forEach>
                <!-- 显示数据库数据 -->
                </tbody>
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
	
	<jsp:include page="../commons/modal.jsp"></jsp:include>	


<script type="text/javascript">
	$(function(){
		//加载左侧项目栏菜单,先看效果怎么样
		
	});
</script>
	
		
</body>
</html>