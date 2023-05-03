package controllers;

import java.util.List;
import java.util.Scanner;

import entities.Cliente;
import repositories.ClienteRepository;

public class ClienteController {

	public void cadastrarCliente() {

		System.out.println("\n*** CADASTO DE CLIENTES ***");
		Scanner scanner = new Scanner(System.in);

		try {

			Cliente cliente = new Cliente();

			System.out.print("INFORME O NOME.........: ");
			cliente.setNome(scanner.nextLine());

			System.out.print("INFORME O EMAIL........: ");
			cliente.setEmail(scanner.nextLine());

			System.out.print("INFORME O TELEFONE.....: ");
			cliente.setTelefone(scanner.nextLine());

			System.out.print("INFORME O CPF..........: ");
			cliente.setCpf(scanner.nextLine());

			ClienteRepository clienterepository = new ClienteRepository();
			clienterepository.create(cliente);

			System.out.println("\nCliente cadastrado com sucesso!");

		}

		catch (Exception e) {

			System.out.println("\nFalha ao cadastrar cliente: " + e.getMessage());

		}

		finally {
			scanner.close();

		}
	}
		
		public void atualizarCliente() {
			
			System.out.println("\n*** ATUALIZAÇÃO DE CLIENTES ***");
			Scanner scanner = new Scanner(System.in);
			
			try {
				
				System.out.print("INFORME O ID DO CLIENTE: ");
				Integer idCliente = Integer.parseInt(scanner.nextLine());
				
				ClienteRepository clienteRepository = new ClienteRepository();
				Cliente cliente = clienteRepository.findById(idCliente);
				
				if(cliente != null) {
					System.out.print("ALTERE O NOME........: ");
					cliente.setNome(scanner.nextLine());
					System.out.print("ALTERE O EMAIL.......: ");
					cliente.setEmail(scanner.nextLine());
					System.out.print("ALTERE O TELEFONE....: ");
					cliente.setTelefone(scanner.nextLine());
					System.out.print("ALTERE O CPF.........: ");
					cliente.setCpf(scanner.nextLine());
					
					clienteRepository.update(cliente);
					
					System.out.println("\nCliente " + idCliente + " atualizado com sucesso!");
					
				}
				else {
					System.out.println("\nCliente nao encontrado.");
				}
			}
			catch(Exception e) {
				System.out.println("\nFalha ao atualizar cliente: " + e.getMessage());
			}
			finally {
				scanner.close();
			}
		}
		
		public void excluirCliente() {
			
			System.out.println("\n*** EXCLUSÃO DE CLIENTES ***");
			Scanner scanner = new Scanner(System.in);
			
			try {
				
				System.out.print("INFORME O ID DO CLIENTE: ");
				Integer idCliente = Integer.parseInt(scanner.nextLine());
				
				ClienteRepository clienteRepository = new ClienteRepository();
				Cliente cliente = clienteRepository.findById(idCliente);
				
				if (cliente != null) {
					
					clienteRepository.delete(cliente);
					System.out.println("\nCliente excluído com sucesso!");
				}
				else {
					System.out.println("\nCliente nao encontrado.");
				}
				
			}
			catch (Exception e) {
				System.out.println("\nFalha ao excluir cliente: " + e.getMessage());
				
			}
			finally {
				scanner.close();
			}
			
		}
		
		public void consultarClientes() {
			System.out.println("\n*** CONSULTA DE CLIENTES ***");
			
			try {
				
				ClienteRepository clienteRepository = new ClienteRepository();
				List<Cliente> lista = clienteRepository.findAll();
				
				for(Cliente cliente : lista) {
					
					System.out.println("ID DO CLIENTE.......: " + cliente.getIdCliente());
					System.out.println("NOME................: " + cliente.getNome());
					System.out.println("EMAIL...............: " + cliente.getEmail());
					System.out.println("TELEFONE............: " + cliente.getTelefone());
					System.out.println("CPF.................: " + cliente.getCpf());
					System.out.println("..");
				}
				
				System.out.println("\nQuantidade de clientes obtidos: " + lista.size());
				
			}
			catch (Exception e){
				System.out.println("\nFalha ao consultar cliente: " + e.getMessage());
				
			}
		}

	}


