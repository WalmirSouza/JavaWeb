<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="dao.*, javadb.jdbc.*, modelo.*, servlet.*", javadb %>
<ul>
  <%
  ClienteDao dao = new ClienteDao();
  List<Cliente>clientes = dao.getClientes();
  %>
</ul>
</body>
</html>