<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="page">

	<form:form method="post" action="${action}" >
		<table>
		<tr>
			<td><spring:message code="article.articletitle" /></td>
				<td>
				<p>
				<form:input path="articleTitle" type="text" id="articleTitle" value="${article}" />	
				</p>
				<p class="error" id="titleErrors">
					<form:errors path="articleTitle" cssClass="error" id="articleTitleErrors" />
				</p>
			</td>
			<td><spring:message code="article.articlebody" /></td>
				<td>
				<p>
				<form:input path="articleBody" type="text" id="articleBody" value="${article}" />	
				</p>
				<p class="error" id="bodyErrors">
					<form:errors path="articleBody" cssClass="error" id="articleBodyErrors" />
				</p>
			</td>
			<td><spring:message code="article.category" /></td>
				<td>
				<p>
				<form:select path="articleCategory">
					<c:if test="${!empty categories}">
						<c:forEach var="category" items="${categories}" varStatus="status">
							<form:option value="${category.id }">${category.name }</form:option>
						</c:forEach>
					</c:if>
				</form:select>
				</p>
				<p class="error" id="categoryErrors">
					<form:errors path="articleCategory" cssClass="error" id="articleCategoryErrors" />
				</p>
			</td>
			<td><spring:message code="article.tags" /></td>
				<td>
				<p>
				<form:input path="articleTags" type="text" id="articleTags" value="${article}" />	
				</p>
				<p class="error" id="tagsErrors">
					<form:errors path="articleTags" cssClass="error" id="articleTagsErrors" />
				</p>
			</td>
		</tr>
		<tr>
			<td>
			
			</td>
			<td>
				<form:input path="createArticle" id="createArticle" type="submit" name="submit" class="submit" />
			</td>
		</tr>
		</table>

	</form:form>

</div>



