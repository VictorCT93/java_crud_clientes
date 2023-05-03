package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Cliente;
import factories.ConnectionFactory;

public class ClienteRepository {

	public void create(Cliente cliente) throws Exception {
		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection
				.prepareStatement("insert into tb_cliente(nome, email, cpf, telefone) values(?, ?, ?, ?)");
		statement.setString(1, cliente.getNome());
		statement.setString(2, cliente.getEmail());
		statement.setString(3, cliente.getCpf());
		statement.setString(4, cliente.getTelefone());
		statement.execute();

		connection.close();
	}

	public void update(Cliente cliente) throws Exception {

		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection
				.prepareStatement("update tb_cliente set nome=?, email=?, cpf=?, telefone=? where idcliente=?");
		statement.setString(1, cliente.getNome());
		statement.setString(2, cliente.getEmail());
		statement.setString(3, cliente.getCpf());
		statement.setString(4, cliente.getTelefone());
		statement.setInt(5, cliente.getIdCliente());
		statement.execute();

		connection.close();
	}

	public void delete(Cliente cliente) throws Exception {
		
		Connection connection = ConnectionFactory.getConnection();
		
		PreparedStatement statement = connection.prepareStatement
				("delete from tb_cliente where idcliente=?");
		
		statement.setInt(1, cliente.getIdCliente());
		statement.execute();
		
		connection.close();
		
	}
	
	public List<Cliente> findAll() throws Exception {
		
		Connection connection = ConnectionFactory.getConnection();
		
		PreparedStatement statement = connection.prepareStatement
				("select * from tb_cliente");
		ResultSet resultSet = statement.executeQuery();
		
		List<Cliente> lista = new ArrayList<Cliente>();
		
		while(resultSet.next()) {
			
			Cliente cliente = new Cliente();
			
			cliente.setIdCliente(resultSet.getInt("idcliente"));
			cliente.setNome(resultSet.getString("nome"));
			cliente.setEmail(resultSet.getString("email"));
			cliente.setTelefone(resultSet.getString("telefone"));
			cliente.setCpf(resultSet.getString("cpf"));
			
			lista.add(cliente);
		}
		
		connection.close();
		return lista;
		
	}
	
	public Cliente findById(Integer idCliente) throws Exception {
		
		Connection connection = ConnectionFactory.getConnection();
		
		PreparedStatement statement = connection.prepareStatement
				("select * from tb_cliente where idcliente=?");
		statement.setInt(1, idCliente);
		ResultSet resultSet = statement.executeQuery();
		
		Cliente cliente = null;
		
		if(resultSet.next()) {
			
			cliente = new Cliente();
			
			cliente.setIdCliente(resultSet.getInt("idcliente"));
			cliente.setNome(resultSet.getString("nome"));
			cliente.setEmail(resultSet.getString("email"));
			cliente.setTelefone(resultSet.getString("telefone"));
			cliente.setCpf(resultSet.getString("cpf"));
			
		}
		
		connection.close();
		return cliente;
	}
	
}
