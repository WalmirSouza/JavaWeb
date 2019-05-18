<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- Comentário no Padrão JSP --%>
<!-- Comentário no Padrão html --> 

<% String mensagem = "Bem vindo ao JSP!!!"; %>
<% out.println(mensagem); %><br/><br/><%-- Variavel impli --%>
<!-- Variavel out do tipo JDPWritter que possui o metodo print -->
<!-- imprimimos utilizando scriptlet JSP -->

<h1>Seja bem vindo ao JavaServer Pages</h1>
<%= mensagem %><br/><br/>
<!-- imprimimos utilizando scriptlet JSP -->
<%= System.out.println("Onde vai sair esta mensagem???") %><br/><br/>
</body>
</html>