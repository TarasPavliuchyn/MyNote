<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=utf-8"%>
<html lang="en">
<head>
<title>Note</title>
</head>
<body style="overflow: hidden; overflow-y: auto">
	<jsp:include page="/WEB-INF/pages/header.jsp" />

	<c:url var="addAction" value="/note/add"></c:url>
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<h1>${note.firstName}&nbsp;${note.lastName}</h1>
			<table class="paginated table table-bordered">
				<tr>
					<td width="30"><spring:message code="fname" /></td>
					<td width="30">${note.firstName}</td>
				</tr>
				<tr>
					<td width="30"><spring:message code="lname" /></td>
					<td width="30">${note.lastName}</td>
				</tr>
				<tr>
					<td width="30"><spring:message code="patronymic" /></td>
					<td width="30">${note.patronymic}</td>
				</tr>
				<tr>
					<td width="30"><spring:message code="comment" /></td>
					<td width="30">${note.comment}</td>
				</tr>

				<c:if test="${!empty note.contacts}">
					<c:forEach items="${note.contacts}" var="contact" varStatus="iter">
						<tr>
							<td><spring:message code="${contact.contactType}" /></td>
							<td>${contact.contact}</td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
			<a href="${pageContext.request.contextPath}/"><spring:message
					code="back" /></a>
		</div>
	</div>

	<jsp:include page="/WEB-INF/pages/footer.jsp" />
</body>
</html>

