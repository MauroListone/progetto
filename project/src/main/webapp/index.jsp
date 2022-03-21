<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="CDN.html" %>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Pagina principale</title>
</head>
<body>
<jsp:include page="navbar.jsp"/>
<div class="container">
	<div class="page-header">
		<h1>Gruppo Torino</h1>
	</div>
	<%
	String admin = (String) session.getAttribute("codadmin");
	if(admin == null) {
		%>
		<form action="" method="post" class="form-horizontal" id="adminForm">
			<!-- NOME -->
			<div class="form-group">
				<label class="control-label">Nome</label>
				<div class="inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon">
							<i class="glyphicon glyphicon-user"></i>
						</span>
						<input type="text" name="nome" id="adminNome" placeholder="Nome" class="form-control">
					</div>
				</div>
			</div>
			<!-- COGNOME -->
			<div class="form-group">
				<label class="control-label">Cognome</label>
				<div class="inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon">
							<i class="glyphicon glyphicon-user"></i>
						</span>
						<input type="text" name="cognome" id="adminCognome" placeholder="Cognome" class="form-control">
					</div>
				</div>
			</div>
			<!-- CODICE -->
			<div class="form-group">
				<label class="control-label">Codice admin</label>
				<div class="inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon">
							<i class="glyphicon glyphicon-lock"></i>
						</span>
						<input type="text" name="codice" id="adminCodice" placeholder="Codice" class="form-control">
					</div>
				</div>
			</div>
			<!-- BOTTONE -->
			<div class="row">
				<button type="submit" class="btn btn-primary">
					Accedi&nbsp;<span class="glyphicon glyphicon-log-in"></span>
				</button>
			</div>
		</form>
		<%
	}
	%>
</div>
<%@ include file="footer.html" %>
</body>
</html>