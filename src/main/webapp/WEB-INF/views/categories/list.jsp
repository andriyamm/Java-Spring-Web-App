<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<ul>
	<c:forEach var="category" items="${categories}">
		<c:set var="categories" value="${category.subCategories}" scope="request"/>
		<li>
			<a href="${category.id}">
			<span>
				<c:out value="${category.id}" />
				
				<c:if test="${!empty category.categoryDef}">
					<strong>
						<c:out value="${category.categoryDef[language].name}" />
					</strong>
				</c:if>

			</span>
			</a>
			<c:if test="${!empty categories}">
				<jsp:include page="/WEB-INF/views/categories/category.jsp"/>
			</c:if>
		</li>
	</c:forEach>
</ul>
