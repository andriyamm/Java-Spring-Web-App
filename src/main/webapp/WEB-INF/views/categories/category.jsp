<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<ul>
	<c:forEach var="category" items="${categories}">
		<c:set var="categories" value="${category.subCategories}" scope="request"/>
		<li>
			<a href="${category.id}"></a><span><c:out value="${category.name}" escapeXml="true"/></span></a>
 
		<c:if test="${!empty categories}">
			<jsp:include page="/WEB-INF/views/categories/category.jsp"/>
		</c:if>
		</li>
	</c:forEach>
</ul>