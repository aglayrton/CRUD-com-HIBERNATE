package com.projetocursoshibernate;

import java.util.List;
import java.util.Scanner;

public class ClienteApp {

	public static void main(String[] args) {
		try
		{
			Scanner entrada = new Scanner(System.in);
			int opcao = 0; 	long cpf;
			String nome, email;
			ClienteDao dao = new ClienteDao();
			
			while(opcao != 6)
			{
				System.out.println("Sistema de Gerenciamento de Clientes");
				System.out.println("====================================");
				System.out.println("Digite [1] para Consultar Todos os Clientes");
				System.out.println("Digite [2] para Consultar um Cliente Específico");
				System.out.println("Digite [3] para Cadastrar um Novo Cliente");
				System.out.println("Digite [4] para Alterar um Cliente");
				System.out.println("Digite [5] para Excluir um Cliente");
				System.out.println("Digite [6] para Sair");
				System.out.println("====================================");
				opcao = entrada.nextInt();
				
				switch(opcao)
				{
					case 1: //Consultar Todos
					{
						System.out.println("[1] Consultar Todos");
						List<Cliente> clientes = dao.findAll();
						for (Cliente cliente : clientes) {
							System.out.println(cliente.toString());
						}
						
						break;
					}
					case 2: //Consultar
					{
						System.out.println("[2] Consultar um Cliente Específico");
						System.out.println("Favor informar o CPF >>>");
						cpf = entrada.nextLong();
						System.out.println(dao.find(cpf));
						break;						
					}
					case 3: //Cadastrar 
					{
						System.out.println("[3] Cadastrar um Novo Cliente");
						System.out.println("Favor informar o CPF >>>");
						cpf = entrada.nextLong();
						entrada.nextLine(); //esvaziar o buffer do teclado
						System.out.println("Favor informar o Nome >>>");
						nome = entrada.nextLine();
						System.out.println("Favor informar o Email >>>");
						email = entrada.nextLine();
						Cliente cliente = new Cliente(cpf,nome,email);
						dao.persist(cliente);
						break;					
					}
					case 4: //Alterar
					{
						System.out.println("[4] Alterar um Cliente");
						System.out.println("Favor informar o CPF >>>");
						cpf = entrada.nextLong();
						entrada.nextLine(); //esvaziar o buffer do teclado
						System.out.println("Favor informar o Nome >>>");
						nome = entrada.nextLine();
						System.out.println("Favor informar o Email >>>");
						email = entrada.nextLine();
						Cliente cliente = new Cliente(cpf,nome,email);
						dao.merge(cliente);
						break;
					}
					case 5: //Excluir
					{
						System.out.println("[5] Excluir um Cliente");
						System.out.println("Favor informar o CPF >>>");
						cpf = entrada.nextLong();
						Cliente cliente = dao.find(cpf);
						dao.delete(cliente);
						break;						
					}
					case 6: //Sair
					{
						System.out.println("Encerrando o Sistema...");
						break;
					}
				}	
			}
			entrada.close();			
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
