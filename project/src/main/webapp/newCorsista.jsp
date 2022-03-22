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
		<h1>form inserimento</h1>
	</div>
	
	<form action="/<%= application.getServletContextName()%>/aggiungi" method="post" class="form-horizontal" id="userForm">

		<!-- ----------------------------------------NOME -->
		<div class="form-group">
			<label class="col-md-1 control-label">Nome</label>
			<div class="col-md-4 inputGroupContainer">
				<div class="input-group">
					<span class="input-group-addon">
						<i class="glyphicon glyphicon-user"></i>
					</span>
					<input type="text" name="nomecorsista" id="nome"
					placeholder="Nome..."
					class="form-control">
				</div>
			</div>
			<div class="col-md-7 control-label" id="infoNome"></div>
		</div>
		
		<!-- ----------------------------------------COGNOME -->
		<div class="form-group">
			<label class="col-md-1 control-label">Cognome</label>
			<div class="col-md-4 inputGroupContainer">
				<div class="input-group">
					<span class="input-group-addon">
						<i class="glyphicon glyphicon-user"></i>
					</span>
					<input type="text" name="cognomecorsista" id="cognome"
					placeholder="Cognome..."
					class="form-control">
				</div>
			</div>
			<div class="col-md-7 control-label" id="infoCognome"></div>
		</div>
		
		<!-- ---------PRECEDENTI FORMATIVI -->
		<div class="form-group">
			<label class="col-md-1 control-label">Precedenti Formativi</label>
			<div class="col-md-4 inputGroupContainer">
				<div class="input-group">
					<span class="input-group-addon">
						<i class="glyphicon glyphicon-user"></i>
					</span>
					<input type="text" name="precedenti" id="precedenti"
					placeholder="Precedenti formativi..."
					class="form-control">
				</div>
			</div>
			<div class="col-md-7 control-label" id="infoPrecedenti"></div>
		</div>
		
		
		<div class="row">
			<div class="col-md-4 col-md-offset-1">
				<button type="submit" class="btn btn-warning">
					Registrati&nbsp;<span class="glyphicon glyphicon-send"></span>
				</button>
			</div>
		</div>
		</form>
		</div>
<%@ include file="footer.html" %>
</body>
</html>