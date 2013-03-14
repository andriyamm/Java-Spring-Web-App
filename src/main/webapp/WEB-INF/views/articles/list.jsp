<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<ul>
	<c:if test="${!empty articles}">
	<c:forEach var="article" items="${articles}">
		<li>
			<a href="${article.id}">
				<span>
					<c:out value="${article.articlesDef}" />
				</span>
			</a>

		</li>
	</c:forEach>
	</c:if>
</ul>