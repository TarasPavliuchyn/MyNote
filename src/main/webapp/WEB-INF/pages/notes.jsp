<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="true"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@page pageEncoding="UTF-8"%>

<html>
<head>
<title>Notebook</title>
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
<script src="${pageContext.request.contextPath}/js/addcontact.js"></script>
<script src="resources/js/validation.js"></script>
<link href="resources/css/login.css" rel="stylesheet">
</head>
<body style="overflow: hidden; overflow-y: auto">
	<jsp:include page="/WEB-INF/pages/header.jsp" />
	<div class="row">
		<div class="col-xs-12 col-md-8">
			<h2>
				<spring:message code="your.contacts" />
			</h2>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-12 col-md-8" style="">
			<c:if test="${!empty listNotes}">
				<table class="paginated table table-bordered">
					<thead>
						<tr>
							<th width="30">№</th>
							<th width="100"><spring:message code="full.name" /></th>
							<th width="30"><spring:message code="edit" /></th>
							<th width="30"><spring:message code="delete" /></th>
						</tr>
					</thead>
					<c:forEach items="${listNotes}" var="note" varStatus="iter">
						<tr>
							<td>${iter.index + 1}</td>
							<td><a href="<c:url value="/note/${note.id}"/>">${note.lastName}&nbsp;${note.firstName}
									&nbsp;${note.patronymic}</a></td>
							<td><a href="<c:url value='/note/edit/${note.id}' />"><spring:message
										code="edit" /></a></td>
							<td><a href="<c:url value='/note/remove/${note.id}' />"><spring:message
										code="delete" /></a></td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		</div>
		<div class="col-xs-6 col-md-4">
			<div class="col-xs-12 col-md-8">
				<h2>
					<spring:message code="add.contact" />
				</h2>
			</div>
			<c:url var="addAction" value="/note/add"></c:url>
			<form:form action="${addAction}" commandName="note" id="addNote">
				<table>
					<c:if test="${!empty note.id}">
						<tr>
							<form:hidden path="id" />

						</tr>
					</c:if>
					<tr>
						<td width="30"><form:label path="firstName">
								<spring:message code="fname" />
							</form:label></td>
						<td width="30"><form:input path="firstName" id="firstName" required="required"/>
							<form:errors path="firstName" cssClass="error" /></td>
						<td></td>
					</tr>
					<tr>
						<td width="30"><form:label path="lastName">
								<spring:message code="lname" />
							</form:label></td>
						<td><form:input path="lastName" id="lastName" required="required"/> <form:errors
								path="lastName" cssClass="error" /></td>
					</tr>
					<tr>
						<td width="30"><form:label path="patronymic">
								<spring:message code="patronymic" />
							</form:label></td>
						<td><form:input path="patronymic" id="patronymic" required="required"/> <form:errors
								path="patronymic" cssClass="error" /></td>
					</tr>
					<tr>
						<td width="30"><form:label path="comment">
								<spring:message code="comment" />
							</form:label></td>
						<td><form:input path="comment" id="comment" required="required"/>
							<form:errors path="comment" cssClass="error" /></td>
					</tr>

					<c:if test="${!empty note.contacts}">
						<c:forEach items="${note.contacts}" var="contact" varStatus="iter">
							<tr>
								<td><form:label path="contacts">
										<spring:message code="${contact.contactType}" />
									</form:label></td>
								<td><form:input path="contacts[${ iter.index}].contact" />
									<form:hidden path="contacts[${ iter.index}].contactType" /> <a
									href="<c:url value='/contact/delete/${note.id}/${contact.contact}/${contact.contactType}' />"><spring:message
											code="delete" /></a></td>
							</tr>
						</c:forEach>
					</c:if>
					<tr>
						<td colspan="2"><c:if test="${!empty note.id}">
								<input class="btn btn-primary" type="submit"
									value="<spring:message text="Edit Note"/>" />
							</c:if> <c:if test="${empty note.id}">
								<input class="btn btn-primary" type="submit"
									value="<spring:message code="add.note"/>" />
							</c:if></td>
					</tr>
				</table>
			</form:form>
			<c:url var="addContact" value="/contact/add/${note.id}"></c:url>
			<c:if test="${!empty note.id}">
				<form:form id="contactForm" action="${addContact}" commandName="contact" >
					<table>
						<tr>
							<td width="30"><spring:message code="con.type" /></td>
							<td><form:select id="type" path="contactType" class="form-control">
									<form:options />
								</form:select></td>
						</tr>
						<tr>
							<td width="30"><form:label path="contact">
									<spring:message code="cont" />
								</form:label></td>
							<td><form:input id="contact" class="form-control" path="contact"
									required="required" /></td>
						</tr>
						<tr>
							<td colspan="2"><input class="btn btn-primary" type="submit"
								value="<spring:message code="add.con"/>" /></td>
						</tr>
					</table>
				</form:form>
			</c:if>
		</div>
	</div>
	<jsp:include page="/WEB-INF/pages/footer.jsp" />
</body>
</html>