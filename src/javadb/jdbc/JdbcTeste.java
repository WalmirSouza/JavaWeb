package javadb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTeste {
	
	public static void main(String[] args) {
		try {
			Connection con= DriverManager.getConnection("jdbc:mysql://127.0.0.1/test", "root", "");
			con.close();
			System.out.println("Conectado ao Banco de Dados MariaDB Local");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
