<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

    <!-- Fixed navbar -->
    <div class="navbar navbar-default navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="http://getbootstrap.com/examples/navbar-fixed-top/#">Restjplat</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a href="${ctx}">首页</a></li>
            <li><a href="${ctx}/rightweb">正常页面</a></li>
            <li><a href="${ctx}/errorweb">出错页面</a></li>
            <li class="dropdown">
              <a href="http://getbootstrap.com/examples/navbar-fixed-top/#" class="dropdown-toggle" data-toggle="dropdown">rest服务异常 <b class="caret"></b></a>
              <ul class="dropdown-menu">
              	<li><a href="${ctx}/rv1/book/add">add产品错误</a></li>
                <li><a href="${ctx}/rv1/ex/ex1">错误1</a></li>
                <li><a href="${ctx}/rv1/ex/ex2">错误2</a></li>
                <li><a href="${ctx}/rv1/ex/ex3">错误3</a></li>
                <li class="divider"></li>
                <li><a href="${ctx}/rv1/good">正确返回json</a></li>
              </ul>
            </li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>