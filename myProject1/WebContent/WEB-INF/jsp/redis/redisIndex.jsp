<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../commons/commons_js.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Redis实例</title>
</head>
<!-- 引入js -->
<script type="text/javascript" src="../js/redis/index.js"></script>

<body class="hold-transition skin-blue sidebar-mini" >
	<div class="wrapper">
		<!-- 头部 -->
		<jsp:include page="../commons/top.jsp" ></jsp:include>
		<!-- 左侧 -->
		<jsp:include page="../commons/left.jsp" ></jsp:include>
		
		<!-- 内容 -->
		
		<div class="content-wrapper">
			<section class="content-header">
		      <h1>Redis测试
		        <small>Redis</small>
		      </h1>
		      <ol class="breadcrumb">
		        <li><a href="#"><i class="fa fa-dashboard"></i>主页</a></li>
		        <li><a href="#">Redis功能</a></li>
		        <li class="active">Redis功能</li>
		      </ol>
		    </section>
		    <!-- 表格 -->
		    <section class="content">
		    	<ul class="nav nav-tabs">
		    		<li class="active">
		    			<a href="#panel1" data-toggle="tab" contenteditable="true" >String</a>
		    		</li>
		    		<li class="">
		    			<a href="#panel2" data-toggle="tab" contenteditable="true">Hash</a>
		    		</li>
		    		<li class="">
		    			<a href="#panel3" data-toggle="tab" contenteditable="true">List</a>
		    		</li>
		    		<li class="">
		    			<a href="#panel4" data-toggle="tab" contenteditable="true">Set</a>
		    		</li>
		    		<li class="">
		    			<a href="#panel5" data-toggle="tab" contenteditable="true">Zset</a>
		    		</li>
		    	</ul>
		    	
		    	<div class="tab-content">
		    		<div  class="tab-pane active" id="panel1">
		    			<div class="row">
		    			<!-- String -->
		    			<div class="col-md-12">
			    		<div class="box">
				            <div class="box-header with-border">
				              <h3 class="box-title">字符串</h3>
				            </div>
				            <!-- /.box-header -->
				            <div class="box-body">
				            	<div class="form-group form-horizontal">
									<label  class="control-label col-sm-2">说明</label>
				            		<div class="col-sm-10">
				            			<textarea class="form-control" rows="5" >参考：http://www.runoob.com/redis/redis-strings.html,通过key来取得value</textarea>
				            		</div>
				            	</div>
				            	
				            	<div class="col-xs-1">
				            		<table class="table table-bordered text-center">
				            			<tr>
				            				<td style="padding: 2px;"><button type="button" class="col-md-1 btn btn-block btn-primary"  onclick="addData('String')">添加</button></td>
				            				<td style="padding: 2px;"><button type="button" class="col-md-1 btn btn-block btn-info" style="display:none;"  onclick="updateData('String')" >修改</button></td>
				            				<td style="padding: 2px;"><button type="button" class="col-md-1 btn btn-block btn-danger" style="display:none;"  onclick="deleteData('String')"  >删除</button></td>
				            			</tr>
				            		</table>
				            	</div>
				            
				              <table border="1" class="table table-bordered">
				                <tr>
				                  <th>序号</th>
				                  <th>String</th>
				                </tr>
				                
				                <tbody id="StringTable">
				                <!-- 显示数据库数据 -->
				                <c:if test="${stringList ne null }">
				                	<c:forEach var="list" items="${stringList}" varStatus="status">
					               		<tr>
					               			<td>${status.index+1}</td>
					               			<td>${list}</td>
					               		</tr>
					               	</c:forEach>	
				                </c:if>
				                
				               	
				                <!-- 显示数据库数据 -->
				                </tbody>
				                
				              </table>
				            </div>
				            <!-- /.box-body -->
				
				          </div>
	          			<!-- /.box -->
			    	</div>	
		    			</div>
		    		</div>
		    		
		    		
		    		<div class="tab-pane" id="panel2">
		    			<div class="row">
		    				<div class="box">
				            <div class="box-header with-border">
				              <h3 class="box-title">哈希Hash</h3>
				            </div>
				            <!-- /.box-header -->
				            <div class="box-body">
				            	
				            	<div class="panel panel-default">
				            		<div class="panel-heading">
										<h3 class="panel-title">
											hash说明
										</h3>
				            		</div>
				            		<div class="panel-body">
										<div>Redis hash 是一个string类型的field和value的映射表，hash特别适合用于存储对象。</div>
										<div>Redis 中每个 hash 可以存储 232 - 1 键值对（40多亿）。</div>
										<div>HMSET key field1 value1 [field2 value2 ] </div>
										<img class="img-rounded" src="../images/hash1.png" />
										
										
				            		</div>
				            	</div>
				            	
				            	<div class="col-xs-1">
				            		<table class="table table-bordered text-center">
				            			<tr>
				            				<td style="padding: 2px;"><button type="button" class="col-md-1 btn btn-block btn-primary"  onclick="addData('Hash')">添加</button></td>
				            				<td style="padding: 2px;"><button type="button" class="col-md-1 btn btn-block btn-info" style="display:none;"  onclick="updateData('Hash')" >修改</button></td>
				            				<td style="padding: 2px;"><button type="button" class="col-md-1 btn btn-block btn-danger"  style="display:none;" onclick="deleteData('Hash')"  >删除</button></td>
				            			</tr>
				            		</table>
				            	</div>
				            
				              <table border="1" class="table table-bordered">
				                <tr>
				                  <th>序号</th>
				                  <th>Field</th>
				                  <th>Value</th>
				                </tr>
				            	
				            	<tbody id="HashList">    
				                <!-- 显示数据库数据 -->
				               	<c:if test="${hashList ne null }">
				               		<tr>
										<td>object.name</td>
										<td>name</td>
										<td>${hashList.name }</td>
				               		</tr>
				               		<tr>
										<td>object.age</td>
										<td>age</td>
										<td>${hashList.age }</td>
				               		</tr>
				               		<tr>
										<td>object.score</td>
										<td>score</td>
										<td>${hashList.score }</td>
				               		</tr>
				               	</c:if>
				                <!-- 显示数据库数据 -->
				                </tbody>
				              </table>
				            </div>
				            <!-- /.box-body -->
				
				          </div>
		         			<!-- /.box -->
		    			</div>
		    		</div>
		    		
		    		<div class="tab-pane" id="panel3">
		    			<div class="box">
				            <div class="box-header with-border">
				              <h3 class="box-title">列表List</h3>
				            </div>
				            <!-- /.box-header -->
				            <div class="box-body">
				            	
				            	<div class="panel panel-default">
				            		<div class="panel-heading">
				            			<h3 class="panel-title">
				            				List(列表)说明
				            			</h3>
				            		</div>
									<div class="panel-body">
										<div>Redis列表是简单的字符串列表，按照插入顺序排序。你可以添加一个元素到列表的头部（左边）或者尾部（右边）</div>
										<div>一个列表最多可以包含 232 - 1 个元素 (4294967295, 每个列表超过40亿个元素)。</div>
										<img class="img-rounded" src="../images/list1.png"  />
									</div>				            		
				            	</div>
				            
				            	<div class="col-xs-1">
				            		<table class="table table-bordered text-center">
				            			<tr>
				            				<td style="padding: 2px;"><button type="button" class="col-md-1 btn btn-block btn-primary"  onclick="addData('List')">添加</button></td>
				            				<td style="padding: 2px;"><button type="button" class="col-md-1 btn btn-block btn-info" style="display:none;"  onclick="updateData('List')" >修改</button></td>
				            				<td style="padding: 2px;"><button type="button" class="col-md-1 btn btn-block btn-danger" style="display:none;"  onclick="deleteData('List')"  >删除</button></td>
				            			</tr>
				            		</table>
				            	</div>
				            
				              <table border="1" class="table table-bordered">
				                <tr>
				                  <th>序号</th>
				                  <th>List</th>
				                </tr>
				                
				                <tbody id="ListList">
				                <!-- 显示数据库数据 -->
				               	<c:forEach var="list" items="${listList}" varStatus="status">
				               		<tr>
				               			<td>${status.index+1}</td>
				               			<td>${list }</td>
				               		</tr>
				               	</c:forEach>
				                <!-- 显示数据库数据 -->
				                </tbody>
				              </table>
				            </div>
				            <!-- /.box-body -->
				
				          </div>
	          			<!-- /.box -->
		    		</div>
		    		
		    		<div class="tab-pane" id="panel4">
		    			<div class="box">
			            <div class="box-header with-border">
			              <h3 class="box-title">集合Set</h3>
			            </div>
			            <!-- /.box-header -->
			            <div class="box-body">
			            	
			            	<div class="panel">
			            		<div class="panel-heading">
			            			<h3 class="panel-title">set说明</h3>
			            		</div>
			            		<div class="panel-body">
									<div>Redis的Set是string类型的无序集合。集合成员是唯一的，这就意味着集合中不能出现重复的数据。</div>			            			
			            			<div>Redis 中 集合是通过哈希表实现的，所以添加，删除，查找的复杂度都是O(1)。</div>
			            			<div>集合中最大的成员数为 232 - 1 (4294967295, 每个集合可存储40多亿个成员)。</div>
			            			<img alt="别点" class="img-rounded" src="../images/set1.png" />
			            		</div>
			            	</div>
			            
			            	<div class="col-xs-1">
			            		<table class="table table-bordered text-center">
			            			<tr>
			            				<td style="padding: 2px;"><button type="button" class="col-md-1 btn btn-block btn-primary"  onclick="addData('Set')">添加</button></td>
			            				<td style="padding: 2px;"><button type="button" class="col-md-1 btn btn-block btn-info" style="display:none;"  onclick="updateData('Set')" >修改</button></td>
			            				<td style="padding: 2px;"><button type="button" class="col-md-1 btn btn-block btn-danger" style="display:none;"  onclick="deleteData('Set')"  >删除</button></td>
			            			</tr>
			            		</table>
			            	</div>
			            
			              <table border="1" class="table table-bordered">
			                <tr>
			                  <th>序号</th>
			                  <th>Key</th>
			                  <th>Value</th>
			                </tr>
			                
			                <!-- 显示数据库数据 -->
			               	<c:forEach var="list" items="${setList}" varStatus="status">
			               		<tr>
			               			<td>${status.index+1}</td>
			               			<td>${list }</td>
			               			<td>${list }</td>
			               		</tr>
			               	</c:forEach>
			                <!-- 显示数据库数据 -->
			                
			              </table>
			            </div>
			            <!-- /.box-body -->
			
			          </div>
          			<!-- /.box -->
		    		</div>
		    		
		    		<div class="tab-pane" id="panel5">
		    			<div class="box">
			            <div class="box-header with-border">
			              <h3 class="box-title">有序集合Zset</h3>
			            </div>
			            <!-- /.box-header -->
			            <div class="box-body">
			            	<div class="panel panel-default">
								<div class="panel-heading">
									<h3 class="panel-title">zset说明</h3>
								</div>
								<div class="panel panel-body">
									<div>Redis 有序集合和集合一样也是string类型元素的集合,且不允许重复的成员。</div>
									<div>不同的是每个元素都会关联一个double类型的分数。redis正是通过分数来为集合中的成员进行从小到大的排序。</div>
									<div>有序集合的成员是唯一的,但分数(score)却可以重复。</div>
									<div>集合是通过哈希表实现的，所以添加，删除，查找的复杂度都是O(1)。 集合中最大的成员数为 232 - 1 (4294967295, 每个集合可存储40多亿个成员)。</div>
									<img alt="别点" class="img-rounded" src="../images/zset1.png" />
								</div>								
			            	</div>
			            	
			            	<div class="col-xs-1">
			            		<table class="table table-bordered text-center">
			            			<tr>
			            				<td style="padding: 2px;"><button type="button" class="col-md-1 btn btn-block btn-primary"  onclick="addData('Zset')">添加</button></td>
			            				<td style="padding: 2px;"><button type="button" class="col-md-1 btn btn-block btn-info" style="display:none;" onclick="updateData('Zset')" >修改</button></td>
			            				<td style="padding: 2px;"><button type="button" class="col-md-1 btn btn-block btn-danger"  style="display:none;" onclick="deleteData('Zset')"  >删除</button></td>
			            			</tr>
			            		</table>
			            	</div>
			            
			              <table border="1" class="table table-bordered">
			                <tr>
			                  <th>序号</th>
			                  <th>Key</th>
			                  <th>Value</th>
			                </tr>
			                
			                <!-- 显示数据库数据 -->
			               	<c:forEach var="list" items="${zsetList}" varStatus="status">
			               		<tr>
			               			<td>${status.index+1}</td>
			               			<td>${list }</td>
			               			<td>${list }</td>
			               		</tr>
			               	</c:forEach>
			                <!-- 显示数据库数据 -->
			                
			              </table>
			            </div>
			            <!-- /.box-body -->
			
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
	
<!-- 模态框begin -->
<div class="modal fade" id="RedisModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="modalTitle">填写数据</h4>
            </div>
            <div class="modal-body" id="">
            	<div class="row">
            		<div class="form-group">
            			<label class="form-label col-md-2">Key</label>
            			<div class = "col-md-10">
            				<input type="text" class="form-control"  id="redisKey" >
            			</div>
            			
            		</div>
            	</div>
            	
            	<div class="row">
            		<div class="form-group">
            			<label class="form-label col-md-2">Value</label>
            			<div class="col-md-10">
            				<input type="text" class="form-control" id="redisValue" >
            			</div>	
            			
            		</div>
            	</div>
            	
            </div>
            <div class="modal-footer">
                <a class="btn btn-default" id="rModal" data-dismiss="modal">关闭</a>
                <a  class="btn btn-primary" id="redisExecute" >确认</a>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<!-- 模态框end -->
	
	
</body>
</html>