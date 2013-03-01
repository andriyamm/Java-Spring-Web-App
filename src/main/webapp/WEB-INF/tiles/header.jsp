<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<header>
	<p>header area</p>
	<table class="ul_header">
		<tr>
			<td>
			<a href="?lang=uk"><img src="<%=request.getContextPath()%>/resources/images/Ukraine.png"
				alt="Ukrainian" /></a>
				</td>
				<td>
				<a href="?lang=en"><img src="<%=request.getContextPath()%>/resources/images/United_Kingdom.png"
				alt="English" />
			</a>
			</td>
		</tr>
	</table>
</header>
		
