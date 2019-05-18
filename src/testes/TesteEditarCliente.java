package testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.ClienteDao;
import javadb.jdbc.ConnectionFactory;
import modelo.Cliente;

public class TesteEditarCliente {
   public static void main(String[] args) {
		
  	    Connection con = new ConnectionFactory().getConnection();
	    ClienteDao dao = new ClienteDao();
		
		try {
			
			
			Cliente cliente = dao.Obter((long) 1) ;
			
			cliente.setEmail("xxxx@gmail.com");
			cliente.setEndereco("12345 12345 ");
			cliente.setNome("Walmir");
			
			
			dao.Editar(cliente);
			
			System.out.println("Dados inseridos com sucesso!");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	   
   }
}
