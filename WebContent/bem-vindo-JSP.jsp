<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% String iniMsg = "Bem Vindo JSP..."; %>
	
	<%= iniMsg %>
	
	<form action="mostrar_idade.jsp">
		<p>Digite a Data de Nascimento:</p>
		<p><input type="date" name="dataNascimento"></p>
		<p><input type="submit" value="Calcular"></p>
	</form>
	
	<br/><br/>
	<a href="one">One</a>
	<br/><br/>
	<a href="add_contato.html">add_contato.html</a>	
</body>
</html>