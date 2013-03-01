<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<title>ams</title>
	<meta name="description" content="" />

	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css"/>

	<script src="<%=request.getContextPath()%>/resources/js/jquery-1.7.1.min.js" type="text/javascript"
		charset="utf-8"></script>
</head>
<body>
	<div id="wrapper">
		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="body" />
		<tiles:insertAttribute name="sidebar" />
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>
