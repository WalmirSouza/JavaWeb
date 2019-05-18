package testes;

import dao.ClienteDao;
import modelo.Cliente;

public class TesteInsertDadosDao {
	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		
		cliente.setNome("Joao");
		cliente.setEmail("email@email.com");
		cliente.setEndereco("rua Joao Machado");
		
		ClienteDao dao = new ClienteDao();
		dao.inserir(cliente);
		
		System.out.println("Cliente incluído com sucesso!");
	
	}
}
