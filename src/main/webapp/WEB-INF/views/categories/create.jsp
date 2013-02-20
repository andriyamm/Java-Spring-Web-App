<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="page">

	<form:form method="post" action="${action}" >
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
					<form:select path="articleCategory">
						<c:if test="${!empty categories}">
							<c:forEach var="category" items="${categories}" varStatus="status">
								<form:option value="${category.id }">${category.name }</form:option>
							</c:forEach>
						</c:if>
					</form:select>
					</p>
					<p class="error" id="categoryErrors">
						<form:errors path="categoryParent" cssClass="error" id="categoryParentErrors" />
					</p>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<form:input path="createCategory" id="createCategory" type="submit" name="submit" class="submit" />
				</td>
			</tr>
		</table>
	</form:form>
	
</div>