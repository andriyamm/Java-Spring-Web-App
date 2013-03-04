<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:if test="${!empty categories}">
<ul>
	<c:forEach var="category" items="${categories}" varStatus="status">
		
		<li id="${category.id }">${category.id }|${category.categoryDef }</li>

	</c:forEach>
</ul>
</c:if>
