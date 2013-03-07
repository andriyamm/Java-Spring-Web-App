<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<ul>
	<c:forEach var="category" items="${categories}">
		<c:set var="categories" value="${category.subCategories}" scope="request"/>
		<li>
			<a href="${category.id}">
				<span>
					<c:out value="${category.id}" />
				</span>
				<c:if test="${!empty category.categoryDef}">
					<strong>
						<c:out value="${category.categoryDef[language].name}" />
					</strong>
				</c:if>
			</a>
			<c:if test="${!empty categories}">
				<jsp:include page="/WEB-INF/views/categories/category.jsp"/>
			</c:if>
		</li>
	</c:forEach>
</ul>