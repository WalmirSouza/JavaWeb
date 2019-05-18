package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDao;
import modelo.Cliente;

@WebServlet("/insertCliente")
@SuppressWarnings("serial")
public class insertClienteServlets extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		
		Cliente cliente = new Cliente();
		cliente.setEmail(email);
		cliente.setEndereco(endereco);
		cliente.setNome(nome);
		
		ClienteDao dao = new ClienteDao();
		dao.inserir(cliente);
				
		out.println("<html>");
		out.println("<body>");
		out.println("Cliente : "+cliente.getNome()+" inserindo no banco!");
		out.println("</body>");
		out.println("</html>");
		
	}
	

}
