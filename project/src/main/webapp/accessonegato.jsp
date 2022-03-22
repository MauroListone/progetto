<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="CDN.html" %>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Accesso negato</title>
</head>
<body>
<jsp:include page="navbar.jsp"/>
	<div class="container">
		<div class="page-header">
			<h3>Non puoi accedere alla pagina</h3>
		</div>
		<div class="panel panel-danger">
			<div class="panel-heading">
				<h3>Risorsa non disponibile</h3>
			</div>
			<div class="panel-body">
				<p>Per accedere alla pagina:</p>
				<p>Torna alla pagina principale:
					<a href="index.jsp">Pagina principale</a>
				</p>
			</div>
		</div>
	</div>
<%@ include file="footer.html" %>
</body>
</html>