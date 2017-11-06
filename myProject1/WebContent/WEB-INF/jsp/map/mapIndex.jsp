<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../commons/commons_js.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
	<style type="text/css">
	body, html,#allmap {width: 100%;height: 100%;overflow: hidden;margin:0;font-family:"微软雅黑";}
	</style>
	
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak="></script>
	<title>地图展示</title>
</head>
<body  class="hold-transition skin-blue sidebar-mini">
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
		      	<div class="row">
		        <div class="col-md-12">
					<div id="allmap"></div>		    		
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
</body>
</html>



<script type="text/javascript">
//百度地图API功能
var map = new BMap.Map("allmap");    // 创建Map实例
map.centerAndZoom("武汉", 14);  // 初始化地图,设置中心点坐标和地图级别
//添加地图类型控件
map.addControl(new BMap.MapTypeControl({
	mapTypes:[
        BMAP_NORMAL_MAP,
        BMAP_HYBRID_MAP
    ]}));	  
map.setCurrentCity("武汉");          // 设置地图显示的城市 此项是必须设置的
map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放	

map.addControl(new BMap.NavigationControl());

	
	
</script>
