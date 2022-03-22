<%@page import="com.project.businesscomponent.facade.CorsistaFacade"%>
<%@page import="com.project.businesscomponent.CorsoBC"%>
<%@ page import="com.project.businesscomponent.model.Corso"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="CDN.html" %>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<jsp:include page="navbar.jsp"/>
<jsp:useBean id="corso" class="com.project.businesscomponent.model.Corso" scope="session"></jsp:useBean>
<div class="container">
	<div class="page-header">
		<h1>Gruppo Torino</h1>
	</div>
	<%
	String admin = (String) session.getAttribute("cognomeadmin");
	if(admin != null) {
		%>
		<div class="lista-corsisti">
			<div class="table-responsive">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Nome Corso</th>
							<th>opzioni</th>
						</tr>
					</thead>
					<tbody>
						<%
							Corso[] c = CorsistaFacade.getInstance().getCorsi();
							for(int i = 0; i<c.length; i++ ) {
						%>
						<tr>
							<td><%= c[i].getNomeCorso() %></td>
							<td> Elimina </td>
						</tr>
						
						<%
							}
						%>
					</tbody>
				</table>
				
				
			</div>
		</div>
		<%
	} else {
		response.sendRedirect("accessonegato.jsp");
	}
	%>

<%@ include file="footer.html" %>
</body>
</html>