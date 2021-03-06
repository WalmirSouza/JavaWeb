package testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javadb.jdbc.ConnectionFactory;

public class TesteInserDados {
	public static void main(String[] args) throws SQLException {
		Connection con = new ConnectionFactory().getConnection();
		
		String sql= "insert into clientes(nome, email, endereco) values (?,?,?)";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setString(1, "Maria");
		stmt.setString(2, "maria@maria.com");
		stmt.setString(3, "Av, Brasil... 100");
		
		stmt.execute();
		stmt.close();
		
		con.close();
		
		System.out.println("Dados inseridos com sucesso!");
		
		
	
	}
}
