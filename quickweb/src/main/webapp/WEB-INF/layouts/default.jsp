<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sitemesh"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title><sitemesh:title /></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />

<link rel="stylesheet" href="${ctxStatic}/bootstrap-3.1.1/css/bootstrap.min.css">
<link rel="stylesheet" href="${ctxStatic}/bootstrap-3.1.1/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="${ctxStatic}/google-code-prettify/prettify.css">
<link rel="stylesheet" href="${ctxStatic}/css/custom.css">
<style type="text/css">
  pre.prettyprint {
    border: 1px solid #ccc;
    margin-bottom: 0;
    padding: 9.5px;
  }
</style>
<sitemesh:head />
</head>
<body onload="prettyPrint()">
	<%@ include file="/WEB-INF/layouts/header.jsp"%>
	<div class="container">
		<sitemesh:body />
	</div>
	<!-- script -->
	<script src="${ctxStatic}/js/jquery-1.11.0.min.js"></script>
	<script src="${ctxStatic}/js/jquery-migrate-1.2.1.min.js"></script>
	<script src="${ctxStatic}/bootstrap-3.1.1/js/bootstrap.min.js"></script>
	<script src="${ctxStatic}/google-code-prettify/prettify.js"></script>
</body>
</html>