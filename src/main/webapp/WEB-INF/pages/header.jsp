<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>EasyNote</title>
<meta name="generator" content="Bootply" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/bootstrap/css/styles.css" />
<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/css/login.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/footer.css"
	rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
<script
	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<!-- begin template -->
	<div class="navbar navbar-custom navbar-fixed-top">
		<div class="navbar-header">
			<a class="navbar-brand" href="${pageContext.request.contextPath}/"
				style="font-size: 20; font-family: Georgia; font-style: italic; font-weight: bold">EasyNote</a>
			<a class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse"> <span class="icon-bar"></span> <span
				class="icon-bar"></span>
			</a>

		</div>
		<div class="navbar-collapse collapse">

			<ul class="nav navbar-nav" style="float: right">
				<security:authorize access="isAnonymous()">
					<li><a href="login"><spring:message code="login" /></a></li>
					<li><a href="registration"><spring:message code="reg" /></a></li>
				</security:authorize>
				<security:authorize access="isAuthenticated()">
					<li><a href=""><span><%=SecurityContextHolder.getContext()
						.getAuthentication().getName()%></span></a></li>
				</security:authorize>
				<security:authorize access="isAuthenticated()">
					<li><a href="<c:url value="/j_spring_security_logout"/>"><spring:message
								code="log" /></a></li>
				</security:authorize>

				<li><a href="?lang=en"><spring:message code="en" /></a></li>
				<li><a href="?lang=ua"><spring:message code="ua" /></a></li>
				<li>&nbsp;</li>
			</ul>
		</div>
	</div>
</body>
</html>