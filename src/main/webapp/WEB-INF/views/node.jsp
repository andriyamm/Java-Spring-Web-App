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