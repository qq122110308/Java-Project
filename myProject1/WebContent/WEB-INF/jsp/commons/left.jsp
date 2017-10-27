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
          <p>阮洋</p>
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
        <li class="header">MAIN NAVIGATION</li>
        <li class="active treeview" style="display:none;" >
          <a href="#">
            <i class="fa fa-dashboard"></i> <span>仪表板</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li class="active"><a href="index.html"><i class="fa fa-circle-o"></i> 仪表板 v1</a></li>
            <li><a href="index2.html"><i class="fa fa-circle-o"></i> 仪表板 v2</a></li>
          </ul>
        </li>
        <li class="treeview" style="display:none;">
          <a href="#">
            <i class="fa fa-files-o"></i>
            <span>布局选项</span>
            <span class="pull-right-container">
              <span class="label label-primary pull-right">4</span>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="pages/layout/top-nav.html"><i class="fa fa-circle-o"></i> 顶部导航</a></li>
            <li><a href="pages/layout/boxed.html"><i class="fa fa-circle-o"></i> 盒装</a></li>
            <li><a href="pages/layout/fixed.html"><i class="fa fa-circle-o"></i> 固定的</a></li>
            <li><a href="pages/layout/collapsed-sidebar.html"><i class="fa fa-circle-o"></i> 倒塌的侧边栏</a></li>
          </ul>
        </li>
        <li style="display:none;">
          <a href="pages/widgets.html">
            <i class="fa fa-th"></i> <span>窗口小部件</span>
            <span class="pull-right-container">
              <small class="label pull-right bg-green">new</small>
            </span>
          </a>
        </li>
        
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
        
        
        
        <li class="treeview" style="display:none;">
          <a href="#">
            <i class="fa fa-pie-chart"></i>
            <span>图表</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="pages/charts/chartjs.html"><i class="fa fa-circle-o"></i> ChartJS</a></li>
            <li><a href="pages/charts/morris.html"><i class="fa fa-circle-o"></i> Morris</a></li>
            <li><a href="pages/charts/flot.html"><i class="fa fa-circle-o"></i> Flot</a></li>
            <li><a href="pages/charts/inline.html"><i class="fa fa-circle-o"></i> Inline charts</a></li>
          </ul>
        </li>
        <li class="treeview" style="display:none;">
          <a href="#">
            <i class="fa fa-laptop"></i>
            <span>UI 元素</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="pages/UI/general.html"><i class="fa fa-circle-o"></i> 一般</a></li>
            <li><a href="pages/UI/icons.html"><i class="fa fa-circle-o"></i> 图标</a></li>
            <li><a href="pages/UI/buttons.html"><i class="fa fa-circle-o"></i> 按钮</a></li>
            <li><a href="pages/UI/sliders.html"><i class="fa fa-circle-o"></i> 滑块</a></li>
            <li><a href="pages/UI/timeline.html"><i class="fa fa-circle-o"></i> 时间表</a></li>
            <li><a href="pages/UI/modals.html"><i class="fa fa-circle-o"></i> Modals</a></li>
          </ul>
        </li>
        <li class="treeview" style="display:none;">
          <a href="#">
            <i class="fa fa-edit"></i> <span>表单</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="pages/forms/general.html"><i class="fa fa-circle-o"></i> 通用元素</a></li>
            <li><a href="pages/forms/advanced.html"><i class="fa fa-circle-o"></i> 高级元素</a></li>
            <li><a href="pages/forms/editors.html"><i class="fa fa-circle-o"></i> 文本域</a></li>
          </ul>
        </li>
        <li class="treeview" style="display:none;">
          <a href="#">
            <i class="fa fa-table"></i> <span>表格</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="pages/tables/simple.html"><i class="fa fa-circle-o"></i> 简单表格</a></li>
            <li><a href="pages/tables/data.html"><i class="fa fa-circle-o"></i> 日期表格</a></li>
          </ul>
        </li>
        <li style="display:none;">
          <a href="pages/calendar.html">
            <i class="fa fa-calendar"></i> <span>日历</span>
            <span class="pull-right-container">
              <small class="label pull-right bg-red">3</small>
              <small class="label pull-right bg-blue">17</small>
            </span>
          </a>
        </li>
        <li style="display:none;">
          <a href="pages/mailbox/mailbox.html">
            <i class="fa fa-envelope"></i> <span>邮箱</span>
            <span class="pull-right-container">
              <small class="label pull-right bg-yellow">12</small>
              <small class="label pull-right bg-green">16</small>
              <small class="label pull-right bg-red">5</small>
            </span>
          </a>
        </li>
        <li class="treeview" style="display:none;">
          <a href="#">
            <i class="fa fa-folder"></i> <span>实例</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="pages/examples/invoice.html"><i class="fa fa-circle-o"></i> Invoice</a></li>
            <li><a href="pages/examples/profile.html"><i class="fa fa-circle-o"></i> Profile</a></li>
            <li><a href="pages/examples/login.html"><i class="fa fa-circle-o"></i> Login</a></li>
            <li><a href="pages/examples/register.html"><i class="fa fa-circle-o"></i> Register</a></li>
            <li><a href="pages/examples/lockscreen.html"><i class="fa fa-circle-o"></i> Lockscreen</a></li>
            <li><a href="pages/examples/404.html"><i class="fa fa-circle-o"></i> 404 Error</a></li>
            <li><a href="pages/examples/500.html"><i class="fa fa-circle-o"></i> 500 Error</a></li>
            <li><a href="pages/examples/blank.html"><i class="fa fa-circle-o"></i> Blank Page</a></li>
            <li><a href="pages/examples/pace.html"><i class="fa fa-circle-o"></i> Pace Page</a></li>
          </ul>
        </li>
        <li class="treeview" style="display:none;">
          <a href="#">
            <i class="fa fa-share"></i> <span>Multilevel</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="#"><i class="fa fa-circle-o"></i> Level One</a></li>
            <li class="treeview">
              <a href="#"><i class="fa fa-circle-o"></i> Level One
                <span class="pull-right-container">
                  <i class="fa fa-angle-left pull-right"></i>
                </span>
              </a>
              <ul class="treeview-menu">
                <li><a href="#"><i class="fa fa-circle-o"></i> Level Two</a></li>
                <li class="treeview">
                  <a href="#"><i class="fa fa-circle-o"></i> Level Two
                    <span class="pull-right-container">
                      <i class="fa fa-angle-left pull-right"></i>
                    </span>
                  </a>
                  <ul class="treeview-menu">
                    <li><a href="#"><i class="fa fa-circle-o"></i> Level Three</a></li>
                    <li><a href="#"><i class="fa fa-circle-o"></i> Level Three</a></li>
                  </ul>
                </li>
              </ul>
            </li>
            <li><a href="#"><i class="fa fa-circle-o"></i> Level One</a></li>
          </ul>
        </li>
        <li style="display:none;"><a href="https://adminlte.io/docs"><i class="fa fa-book"></i> <span>Documentation</span></a></li>
        <li class="header" style="display:none;">系统管理</li>
        <li style="display:none;"><a href="#"><i class="fa fa-circle-o text-red"></i> <span>Important</span></a></li>
        <li style="display:none;"><a href="#"><i class="fa fa-circle-o text-yellow"></i> <span>Warning</span></a></li>
        <li style="display:none;"><a href="#"><i class="fa fa-circle-o text-aqua"></i> <span>Information</span></a></li>
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>
  

	
