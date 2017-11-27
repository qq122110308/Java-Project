<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

	<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="../dist/img/mypictrue.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>${nowUser.username }</p>
          <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
        </div>
      </div>
      <!-- search form -->
      <form action="#" method="get" class="sidebar-form">
        <div class="input-group">
          <input type="text" name="q" class="form-control" placeholder="Search...">
          <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
        </div>
      </form>
      <!-- /.search form -->
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu" data-widget="tree">
        <li class="header">菜单</li>
        
        <!-- 植入左侧功能栏 -->
        <c:forEach items="${funList}"  var="list"  varStatus="stauts">
        	<c:if test="${list.funfathernode eq '0'}">
        		<li class="treeview">
		          <a href="#">
		            <i class="fa ${list.funicon }"></i>
		            <span>${list.funname}</span>
		            <span class="pull-right-container">
		              <i class="fa fa-angle-left pull-right"></i>
		            </span>
		          </a>
		          <!-- 二级菜单 -->
		          <ul class="treeview-menu">
		          	<c:forEach items="${funList }" var="subList" varStatus="status">
		          		<c:if test="${subList.funfathernode eq list.funid }">
		          			<li><a href="../${subList.funurl }" ><i class="fa ${subList.funicon }"></i> ${subList.funname }</a></li>
		          		</c:if>
		          	</c:forEach>
		          </ul>
	        	</li>
        	</c:if>
        	
        </c:forEach>
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>
  

	
