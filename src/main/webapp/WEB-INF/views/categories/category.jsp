
<ul>
<c:forEach var="category" items="${categories}">
    <c:set var="categories" value="${category.menuItems}" scope="request"/>
    <li>
      <a href="${category.id}"></a><span><c:out value="${category.name}" escapeXml="true"/></span></a>
    
      <c:if test="${fn:length(category.menuItems) > 0}">
            <jsp:include page="/WEB-INF/views/categories/categories.jsp"/>
      </c:if>
    </li>
</c:forEach>
</ul>