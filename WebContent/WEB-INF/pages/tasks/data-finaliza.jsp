<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
	< type="text/java" src="resources/js/jquery.js"></>
	< type="text/java" src="resources/js/jquery-ui.js"></>
	<link type="text/css" href="resources/css/tasks.css" rel="stylesheet" />
	
	< type="text/java">
		function finalizar(id) {
			$.post("finalizatask", {'id' : id}, function(response) {
				$("#task_"+id).html(response);
				alert(response);
			});
		}
	</>
</head>

<body>

	<a href="novatask">Inserir nova <i>task</i></a>
	<br />
	<br />
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Descri��o</th>
			<th>Finalizada</th>
			<th>Data de finaliza��o</th>
			<th>A��o 1</th>
			<th>A��o 2</th>
		</tr>
		<c:forEach items="${tasks}" var="task">
			<tr id="task_${task.id}" bgcolor="#${task.id % 2 == 0 ? 'ffffff' : 'F0F8FF'}">
				<td>${task.id}</td>
				<td>${task.descricao}</td>
				<c:if test="${task.finalizada eq false}">
					<td>
						<a href="#" onclick="finalizar(${task.id})">
							Finalizar!
						</a>
					</td>
				</c:if>
				<c:if test="${task.finalizada eq true}">
					<td>Finalizada</td>
				</c:if>
				<td><fmt:formatDate value="${task.dataFinalizacao.time}"
						pattern="dd/MM/yyyy" /></td>
				<td><a href="excluitask?id=${task.id}">Excluir</a></td>
				<td><a href="buscatask?id=${task.id}">Editar</a></td>
			</tr>
		</c:forEach>
	</table>
	<br /><br /><br /><br />
	<h4><a href="logout">Logout</a></h4>
</body>
</html>