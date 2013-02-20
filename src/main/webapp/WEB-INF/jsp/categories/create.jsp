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
			<td></td>
			<td>
				<form:input path="createCategory" id="createCategory" type="submit" name="submit" class="submit" />
			</td>
		</tr>
		</table>
	</form:form>
	
</div>