<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=utf-8"%>
<html lang="en">
<head>
<title><spring:message code="sign.up" /></title>

<link href="resources/css/login.css" rel="stylesheet">
<script src="resources/js/jquery.js"></script>
<script src="resources/js/jquery-1.9.1.js"></script>
<script src="resources/js/validation.js"></script>

<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="/WEB-INF/pages/header.jsp" />
	<div class="container">

		<div id="signupbox" style="margin-top: 50px"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">
						<spring:message code="sign.up" />
					</div>
					<div
						style="float: right; font-size: 85%; position: relative; top: -10px">
						<a id="signinlink" href="login"><spring:message code="sign.in" /></a>
					</div>
				</div>
				<div class="panel-body">
					<form:form id="signupform" class="form-horizontal" role="form"
						commandName="newUser" action="registration" method="POST">

						<c:if test="${not empty message}">
							<div id="signupalert" class="alert alert-danger">
								<p>
									<spring:message code="${message}" />
								</p>
								<span></span>
							</div>
						</c:if>
						<div class="form-group">
							<label for="email" class="col-md-3 control-label"><spring:message
									code="email" /></label>
							<div class="col-md-9">
								<input type="text" class="form-control" name="login" id="login"
									placeholder="<spring:message code="login"/>" autofocus>
								<form:errors path="login" cssClass="error" />
							</div>
						</div>
						<div class="form-group">
							<label for="password" class="col-md-3 control-label"><spring:message
									code="pass" /></label>
							<div class="col-md-9">
								<input type="password" class="form-control" name="password"
									id="password" placeholder="<spring:message code="pass"/>">
							</div>
						</div>

						<div class="form-group">
							<label for="password" class="col-md-3 control-label"
								id="password"><spring:message code="confirm.pass" /></label>
							<div class="col-md-9">
								<input type="password" class="form-control" name="confirm"
									id="confirm"
									placeholder="<spring:message code="confirm.pass"/>">
									<form:errors path="password" cssClass="error" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-offset-3 col-md-9">
								<button id="btn-signup" type="submit" class="btn btn-primary"
									style="min-width: 100px">
									<i class="icon-hand-right"></i>
									<spring:message code="sign.up" />
								</button>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/pages/footer.jsp" />
</body>
</html>