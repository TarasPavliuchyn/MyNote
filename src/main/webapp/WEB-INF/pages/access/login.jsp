<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ page session="true"%>
<head>
<title>Sign in</title>

<!-- Bootstrap core CSS -->
<link href="resources/css/login.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>

<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="/WEB-INF/pages/header.jsp" />
	<div class="container" >
		<div id="loginbox" style="margin-top: 50px;flaot:right"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-info" >
				<div class="panel-heading">
					<div class="panel-title">
						<spring:message code="sign.in" />
					</div>
				</div>

				<div style="padding-top: 30px" class="panel-body">

					<div style="display: none" id="login-alert"
						class="alert alert-danger col-sm-12"></div>

					<form  id="loginform" class="form-horizontal" role="form"
						action="<c:url value='/j_spring_security_check' />" method="post" >

						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input id="login-username"
								type="text" class="form-control" name="login"
								placeholder=<spring:message code="login"/> autofocus>
						</div>

						<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-lock"></i></span> <input id="login-password"
								type="password" class="form-control" name="password"
								placeholder=<spring:message code="pass" />>
						</div>
						<c:if test="${not empty msg}">
							<span class="message"><spring:message code="${msg}" /></span>
						</c:if>
						<c:if test="${not empty error}">
							<span class="message"><spring:message code="${error}" />
							</span>
						</c:if>
						<div style="margin-top: 10px" class="form-group">
							<!-- Button -->

							<div class="col-sm-12 controls" >
								<button  class="btn btn-success" style="min-width:100px">
									<spring:message code="sign.in" />
								</button>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-12 control">
								<div
									style="border-top: 1px solid #888; padding-top: 15px; font-size: 85%">
									<spring:message code="dont.have.acc" />
									<a href="registration"> <spring:message code="sign.up.here" />
									</a>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/pages/footer.jsp" />
</body>
</html>

