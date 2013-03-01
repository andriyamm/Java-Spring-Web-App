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

