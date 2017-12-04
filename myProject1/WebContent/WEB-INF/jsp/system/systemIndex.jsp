<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../commons/commons_js.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统管理</title>

<link rel="stylesheet" href="../css/demo.css" type="text/css">
<link rel="stylesheet" href="../css/zTreeStyle/zTreeStyle.css" type="text/css">

<script type="text/javascript" src="../js/ztree/jquery.ztree.core.js"></script>
<script type="text/javascript" src="../js/ztree/jquery.ztree.excheck.js"></script>
	<script type="text/javascript" src="../js/ztree/jquery.ztree.exedit.js"></script>
<script type="text/javascript" src="../js/system/index.js"></script>
<SCRIPT type="text/javascript">
	//这里请求系统菜单
	var zNodes = [];
	var setting = {
			view: {
				selectedMulti: false
			},
			edit: {
				enable: true,
				showRemoveBtn: false,
				showRenameBtn: false
			},
			data: {
				keep: {
					parent:true,
					leaf:true
				},
				simpleData: {
					enable: true
				}
			},
			callback: {
				beforeDrag: beforeDrag,
				beforeRemove: beforeRemove,
				beforeRename: beforeRename,
				onRemove: onRemove
			}
		};
	
	$(function(){
		$.ajax({
			type:"POST",			
			url:"sTree",
			data:{t:Math.random()},
			dataType:"json",
			success:function(res){
				//console.log(res);
				zNodes = res;
				
				$.fn.zTree.init($("#treeDemo"), setting, zNodes);
				
				//这里如果取消注释 相当于调用两次函数,因为下面有
/* 				$("#addParent").bind("click", {isParent:true}, add);
				$("#addLeaf").bind("click", {isParent:false}, add);
				$("#edit").bind("click", edit);
				$("#remove").bind("click", remove);
				$("#clearChildren").bind("click", clearChildren); */
				
			}
		});
	});
	
	var log, className = "dark";
	function beforeDrag(treeId, treeNodes) {
		return false;
	}
	function beforeRemove(treeId, treeNode) {
		className = (className === "dark" ? "":"dark");
		showLog("[ "+getTime()+" beforeRemove ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
		return confirm("确认删除 节点 -- " + treeNode.name + " 吗？");
	}
	function onRemove(e, treeId, treeNode) {
		showLog("[ "+getTime()+" onRemove ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
	}
	function beforeRename(treeId, treeNode, newName) {
		if (newName.length == 0) {
			alert("节点名称不能为空.");
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			setTimeout(function(){zTree.editName(treeNode)}, 10);
			return false;
		}
		return true;
	}
	function showLog(str) {
		if (!log) log = $("#log");
		log.append("<li class='"+className+"'>"+str+"</li>");
		if(log.children("li").length > 8) {
			log.get(0).removeChild(log.children("li")[0]);
		}
	}
	function getTime() {
		var now= new Date(),
		h=now.getHours(),
		m=now.getMinutes(),
		s=now.getSeconds(),
		ms=now.getMilliseconds();
		return (h+":"+m+":"+s+ " " +ms);
	}

	var newCount = 1;
	function add(e) {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
		isParent = e.data.isParent,
		nodes = zTree.getSelectedNodes(),
		treeNode = nodes[0];
		
		if (treeNode) {
			//上级节点
			var arrs = treeNode.id;
			var arr = arrs.split("_");
			$("#funfatherid").val(arr[1]);
			//treeNode = zTree.addNodes(treeNode, {id:(100 + newCount), pId:treeNode.id, isParent:isParent, name:"new node" + (newCount++)});
		} else {
			//树节点
			$("#funfatherid").val("0");
			//treeNode = zTree.addNodes(null, {id:(100 + newCount), pId:0, isParent:isParent, name:"new node" + (newCount++)});
		}
		if (treeNode) {
			zTree.editName(treeNode[0]);
		} else {
			//alert("叶子节点被锁定，无法增加子节点");
		}
		$("#OperTitle").text("功能添加");
		$("#OperExecute").bind("click",manageAdd);
		$("#Oper").modal();
	};
	function edit() {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
		nodes = zTree.getSelectedNodes(),
		treeNode = nodes[0];
		if (nodes.length == 0) {
			alert("请先选择一个节点");
			return;
		}
		zTree.editName(treeNode);
	};
	function remove(e) {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
		nodes = zTree.getSelectedNodes(),
		treeNode = nodes[0];
		if (nodes.length == 0) {
			alert("请先选择一个节点");
			return;
		}
		var callbackFlag = $("#callbackTrigger").attr("checked");
		zTree.removeNode(treeNode, callbackFlag);
	};
	function clearChildren(e) {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
		nodes = zTree.getSelectedNodes(),
		treeNode = nodes[0];
		if (nodes.length == 0 || !nodes[0].isParent) {
			alert("请先选择一个父节点");
			return;
		}
		zTree.removeChildNodes(treeNode);
	};
	
	$(document).ready(function(){
		//$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		$("#addParent").bind("click", {isParent:true}, add);
		$("#addLeaf").bind("click", {isParent:false}, add);
		$("#edit").bind("click", edit);
		$("#remove").bind("click", remove);
		$("#clearChildren").bind("click", clearChildren);
	});
	
		

	</SCRIPT>


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
		      <h1>系统功能
		        <small>表格</small>
		      </h1>
		      <ol class="breadcrumb">
		        <li><a href="#"><i class="fa fa-dashboard"></i>主页</a></li>
		        <li><a href="#">系统管理</a></li>
		        <li class="active">系统功能</li>
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
            <div class="box-body content_wrap">
            	<div class="zTreeDemoBackground left">
					<ul id="treeDemo" class="ztree"></ul>
				</div>
            	
              <li><p>对节点进行 增 / 删 / 改，试试看：<br/>
					&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" id="callbackTrigger" checked /> removeNode 方法是否触发 callback<br/>
					&nbsp;&nbsp;&nbsp;&nbsp;[ <a id="addParent" href="#" title="增加父节点" onclick="return false;">增加父节点</a> ]
					&nbsp;&nbsp;&nbsp;&nbsp;[ <a id="addLeaf" href="#" title="增加叶子节点" onclick="return false;">增加叶子节点</a> ]
					&nbsp;&nbsp;&nbsp;&nbsp;[ <a id="edit" href="#" title="编辑名称" onclick="return false;">编辑名称</a> ]<br/>
					&nbsp;&nbsp;&nbsp;&nbsp;[ <a id="remove" href="#" title="删除节点" onclick="return false;">删除节点</a> ]
					&nbsp;&nbsp;&nbsp;&nbsp;[ <a id="clearChildren" href="#" title="清空子节点" onclick="return false;">清空子节点</a> ]<br/>
					remove log:<br/>
					<ul id="log" class="log"></ul></p>
				</li>
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
	
	<!-- 添加、修改、删除操作的模态框 -->
	<div class="modal fade" id="Oper" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h4 class="modal-title" id="OperTitle">	</h4>
	            </div>
	            
	            <div class="modal-body" id="OperContext">
	            	<div class="form-group">
	                  <label  class="col-sm-2 control-label">功能名称</label>
	
	                  <div class="col-sm-10">
	                    <input type="text" class="form-control" name="funname" id="funname" placeholder="添加功能名称">
	                  </div>
	                </div>
	                
	                <div class="form-group">
					  <label  class="col-sm-2 control-label">功能地址</label>
					
					  <div class="col-sm-10">
					    <input type="text" class="form-control" name="funurl" id="funurl" placeholder="添加功能地址">
					  </div>
					</div>
					
					<div class="form-group">
					  <label  class="col-sm-2 control-label">图标</label>
					  <div class="col-sm-10">
					    <input type="text" class="form-control" name="funicon" id="funicon" placeholder="添加图标">
					  </div>
					</div>
					
					<input type="hidden" class="form-control" name="funfatherid" id="funfatherid" placeholder="上级ID">
	                	
	            </div>
	            
	            <div class="modal-footer">
	                <a class="btn btn-default" data-dismiss="modal">关闭</a>
	                <a  class="btn btn-primary" id="OperExecute" >确认</a>
	            </div>
	        </div><!-- /.modal-content -->
	    </div><!-- /.modal -->
	</div>

	
<script type="text/javascript">
	$(function(){
		//加载左侧项目栏菜单,先看效果怎么样
		
	});
	
	function addData(){
		window.location.href="goadd";
	}
	function updateData(){
		//判断哪个被选中，取出value
		
		var funid=0;
		
		funid=$("input:radio:checked").val();
		
		console.log(funid);
		if(funid==0||funid==undefined){
			alert("请选择一条数据");
		}
		else{
			window.location.href="goupdate?funid="+funid;
		}
	}
	
</script>
	
	
</body>
</html>