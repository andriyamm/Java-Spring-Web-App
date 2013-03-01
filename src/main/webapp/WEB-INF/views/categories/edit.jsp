<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="page">

	<form:form method="post" action="edit" modelAttribute="categoryCommand">
		<table>
			<tr>
				<td><spring:message code="category.categoryname" /></td>
				<td>
					<p>
					<form:input path="categoryName" type="text" id="categoryName" value="${article}" />	
					</p>
					<p class="error" id="titleErrors">
						<form:errors path="categoryName" cssClass="error" id="categoryNameErrors" />
					</p>
				</td>
			</tr>
			<tr>
				<td><spring:message code="category.parent" /></td>
				<td>
					<p>
					<form:select path="parentCategory">
						<form:option value="0">No parent</form:option>
						<c:if test="${!empty categories}">
							<c:forEach var="category" items="${categories}" varStatus="status">
								<form:option value="${category.id }">${category.name }</form:option>
							</c:forEach>
						</c:if>
					</form:select>
					</p>
					<p class="error" id="categoryErrors">
						<form:errors path="parentCategory" cssClass="error" id="categoryParentErrors" />
					</p>
				</td>
			</tr>
			<tr>
				<td><spring:message code="common.chooselanguage" /></td>
				<td>
					<form:select path="languageId">
						<c:if test="${!empty languages}">
							<c:forEach var="lang" items="${languages}" varStatus="status">
								<form:option value="${lang.id }">${lang.prefix }</form:option>
							</c:forEach>
						</c:if>
					</form:select>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input  id="createCategory" type="submit" name="submit" class="submit" />
				</td>
			</tr>
		</table>
	</form:form>
	
</div>