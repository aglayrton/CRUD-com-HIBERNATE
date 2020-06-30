package com.projetocursoshibernate;

import java.util.List;
import java.util.Scanner;

public class PagamentoApp {

	public static void main(String[] args) {
		try
		{
			Scanner entrada = new Scanner(System.in);
			int opcao = 0; 	long cpf, cdcurso;
			String datainscricao;
			PagamentoDAO dao = new PagamentoDAO();
			
			while(opcao != 6)
			{
				System.out.println("Sistema de Gerenciamento de Pagamentos");
				System.out.println("====================================");
				System.out.println("Digite [1] para Consultar Todos os Pagamentos");
				System.out.println("Digite [2] para Consultar um Pagamento Específico");
				System.out.println("Digite [3] para Cadastrar um Novo Pagamento");
				System.out.println("Digite [4] para Alterar um Pagamento");
				System.out.println("Digite [5] para Excluir um Pagamento");
				System.out.println("Digite [6] para Sair");
				System.out.println("====================================");
				opcao = entrada.nextInt();
				
				switch(opcao)
				{
					case 1: //Consultar Todos
					{
						System.out.println("[1] Consultar Todos");
						List<Pagamento> pagamentos = dao.findAll();
						pagamentos.forEach(System.out::println);
						break;
					}
					case 2: //Consultar
					{
						System.out.println("[2] Consultar um Pagamento Específico");
						System.out.println("Favor informar o CPF >>>");
						cpf = entrada.nextLong();
						System.out.println("Favor informar o CDCURSO >>>");
						cdcurso = entrada.nextLong();
						PagamentoId pgtoid = new PagamentoId(cpf, cdcurso);
						System.out.println(dao.find(pgtoid));
						break;						
					}
					case 3: //Cadastrar 
					{
						System.out.println("[3] Cadastrar um Novo Pagamento");
						System.out.println("Favor informar o CPF >>>");
						cpf = entrada.nextLong();
						System.out.println("Favor informar o CDCURSO >>>");
						cdcurso = entrada.nextLong();
						PagamentoId pgtoid = new PagamentoId(cpf, cdcurso);
						entrada.nextLine(); //esvaziar o buffer do teclado
						System.out.println("Favor informar a DATA DE INSCRICAO >>>");
						datainscricao = entrada.nextLine();
						Pagamento Pagamento = new Pagamento(pgtoid, datainscricao);
						dao.persist(Pagamento);
						break;					
					}
					case 4: //Alterar
					{
						System.out.println("[3] Cadastrar um Novo Pagamento");
						System.out.println("Favor informar o CPF >>>");
						cpf = entrada.nextLong();
						System.out.println("Favor informar o CDCURSO >>>");
						cdcurso = entrada.nextLong();
						PagamentoId pgtoid = new PagamentoId(cpf, cdcurso);
						entrada.nextLine(); //esvaziar o buffer do teclado
						System.out.println("Favor informar a DATA DE INSCRICAO >>>");
						datainscricao = entrada.nextLine();
						Pagamento Pagamento = new Pagamento(pgtoid, datainscricao);
						dao.merge(Pagamento);
						break;
					}
					case 5: //Excluir
					{
						System.out.println("[2] Consultar um Pagamento Específico");
						System.out.println("Favor informar o CPF >>>");
						cpf = entrada.nextLong();
						System.out.println("Favor informar o CDCURSO >>>");
						cdcurso = entrada.nextLong();
						PagamentoId pgtoid = new PagamentoId(cpf, cdcurso);
						Pagamento Pagamento = dao.find(pgtoid);
						dao.delete(Pagamento);
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
