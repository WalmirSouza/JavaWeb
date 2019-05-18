package testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javadb.jdbc.ConnectionFactory;

public class TesteInsertDados2 {
	public static void main(String[] args) throws SQLException {
		Connection con = null;
		
		try {
			con = new ConnectionFactory().getConnection();
			String sql= "insert into clientes(nome, email, endereco) values (?,?,?)";
			
			PreparedStatement stmt ;
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, "Maria");
			stmt.setString(2, "maria@maria.com");
			stmt.setString(3, "Av, Brasil... 100");
			
			stmt.execute();
			stmt.close();
			
			con.close();
			
			System.out.println("Dados inseridos com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
			// TODO: handle finally clause
		}
		
	}
}
