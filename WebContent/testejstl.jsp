<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="dao" class=dao.ClienteDao></jsp:useBean>
<table>
   <c:forEach var="cliente" items="${dao.getClientes }">
      <tr>
          <td>${cliente.nome}</td>
          <td>${cliente.email}</td>
          <td>${cliente.endereco}</td>
   
   
   </c:forEach>
</table>
</body>
</html>