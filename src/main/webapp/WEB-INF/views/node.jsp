<ul>
	<s:iterator value='rootNode.childList'>
		<s:include value='node.jsp' />
	</s:iterator>
</ul>




<li><s:property value='name'/>
	<s:if test='childList != null && childList.size'>
		<ul>
			<s:iterator value='childList'>
				<s:include value='node.jsp'/>
			</s:iterator>
		</ul>
	</s:if>
</li>

<c:if test="${!empty category.categoryDef}">
			<c:forEach var="def" items="${category.categoryDef}" varStatus="status">
				<li id="${category.id }">${category.id }|${def.name }</li>
			</c:forEach>
		</c:if>

		<li id="${category.id }">${category.id }|${category.categoryDef}</li>




		<c:if test="${!empty category.categoryDef}">
			<c:forEach var="def" items="${category.categoryDef}" varStatus="status">
				<li id="${category.id }">${category.id }|${def.name }</li>
			</c:forEach>
		</c:if>







<ul>
	<c:forEach var="category" items="${categories}">
		<c:set var="categories" value="${category.subCategories}" scope="request"/>
		<li>
			<a href="${category.id}">
			<span>
				<c:out value="${category.id}" />
			</span>
			<c:if test="${!empty category.categoryDef}">
				<c:forEach var="def" items="${category.categoryDef}">
			
						<strong>
							<c:out value="${def.id}" />
							<c:out value="${def.name}" />
						</strong>
					
				</c:forEach>
				</c:if>
			</a>
			<c:if test="${!empty categories}">
				<jsp:include page="/WEB-INF/views/categories/category.jsp"/>
			</c:if>
		</li>
	</c:forEach>
</ul>