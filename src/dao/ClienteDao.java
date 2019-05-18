package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javadb.jdbc.ConnectionFactory;
import modelo.Cliente;

public class ClienteDao {
	private Connection con;
	
	public  ClienteDao() {
		this.con = new ConnectionFactory().getConnection();
	}
	
	public void inserir(Cliente cliente) {
		String sql= "insert into clientes(nome, email, endereco) values (?,?,?)";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEmail());
			stmt.setString(3, cliente.getEndereco());
			
			stmt.execute();
			stmt.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	
	public List<Cliente> getClientes() {
		try {
			List<Cliente> clientes = new ArrayList<Cliente>();
			PreparedStatement stmt = con.prepareStatement("Select * from Cliente");
			ResultSet rs =  stmt.executeQuery() ;
			
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getLong("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEmail(rs.getString("email"));
				cliente.setEndereco(rs.getString("endereco"));
				
				clientes.add(cliente);
			}
			rs.close();
			stmt.close();
			return clientes;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		
	}
	
	public void Editar(Cliente cliente) {
		String sql= "update Cliente set nome = ?, email=?, endereco = ? where id = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEmail());
			stmt.setString(3, cliente.getEndereco());
			stmt.setLong(4, cliente.getId());
			
			stmt.execute();
			stmt.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}	

	
	public void Excluir(Cliente cliente) {
		String sql= "delete from Cliente  where id = ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setLong(1, cliente.getId());
			
			stmt.execute();
			stmt.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}	

	public Cliente Obter(long id) {
		String sql= "Select * from Cliente where Id = ?";
		
		try {
			Cliente clienteEncontrado = new Cliente() ;
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs =  stmt.executeQuery() ;
			if (rs.next()){
				clienteEncontrado.setId(rs.getLong("id"));
				clienteEncontrado.setNome(rs.getString("nome"));
				clienteEncontrado.setEmail(rs.getString("email"));
				clienteEncontrado.setEndereco(rs.getString("endereco"));
			} else {
				System.out.println("Cliente não encontrado!");
			}
			
			stmt.execute();
			stmt.close();
			
			return clienteEncontrado;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}	


}
