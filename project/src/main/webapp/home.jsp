<%@page import="com.project.businesscomponent.facade.CorsistaFacade"%>
<%@page import="com.project.businesscomponent.CorsistaBC"%>
<%@ page import="com.project.businesscomponent.model.Corsista"%>
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
<jsp:useBean id="corsista" class="com.project.businesscomponent.model.Corsista" scope="session"></jsp:useBean>
<jsp:useBean id="corsistaBC" class="com.project.businesscomponent.CorsistaBC" scope="session"></jsp:useBean>
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
							<th>Nome</th>
							<th>Cognome</th>
						</tr>
					</thead>
					<tbody>
						<%
							Corsista[] c = CorsistaFacade.getInstance().getCorsisti();
							for(int i = 0; i<c.length; i++ ) {
						%>
						<tr>
							<td><%= c[i].getNomecorsista() %></td>
							<td><%= c[i].getCognomecorsista() %></td>
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
</div>
<%@ include file="footer.html" %>
</body>
</html>