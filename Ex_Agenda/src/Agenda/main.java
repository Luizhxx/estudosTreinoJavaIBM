package Agenda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

	/**
	 * @param args
	 */
	
	
	public static void main(String[] args) {
		
		List<Contato> contatos = new ArrayList<Contato>();
		
		Scanner opcaoMenu = new Scanner(System.in);
		int opc = 0;
		contatos.add(new Contato(0, "Joao", new Telefone((short)19, "988884444", "Celular")));
		
		contatos.add(new Contato(1, "Carla", new Telefone((short)11, "44443333", "Residencial")));
		
		
		
		do {			
			
			System.out.flush();
			System.out.print("\nMenu Telefonico:\n"
					+ "1 - Consultar contato;\r\n"
					+ "2 - Adicionar contato;\r\n"
					+ "3 - Remover contato;\r\n" 
					+ "4 - Sair;\r\n");
			
			opc = opcaoMenu.nextInt();
			int escolha = 0;
			
			switch(opc) {
			
			case 1:
				//CONSULTANDO CONTATO
				
				System.out.print("Entre com o ID a ser Buscado!!!");
				System.out.flush();
				opcaoMenu = new Scanner(System.in);
				escolha = opcaoMenu.nextInt();
				
				for (int i=0; i < contatos.size(); i++) {
					
					if(contatos.get(i).id==escolha) {
						contatos.get(i).MostrarNaTela();
						contatos.get(i).MostrarTelefones();
					}
				}
								
				System.out.print("Voltar ao Menu[Enter]");
				opcaoMenu = new Scanner(System.in);
				opcaoMenu.nextLine();
			break;
			
			case 2:
				//ADICIONANDO CONTATO
				int temp = 0;
				
				do {

					System.out.print("Escreva neste formato (nome,ddd,numero,tipo de telefone):\n");
					System.out.flush();
					
					//System.out.print(contatos.size());
					int id_temp = -1;
					int cond = 0;
					opcaoMenu = new Scanner(System.in);
//					
					String[] escolha1 = new String[3];
					escolha1 = opcaoMenu.nextLine().split(",");
					//List<Contatos> teste[] = new ArrayLsit<Contatos>[0];
					//String[] test = new String[5];
					//test = escolha1.split(",");
					
					for(int i=0; i<contatos.size(); i++) {
						id_temp = contatos.get(i).id;						
					}
					id_temp ++;
					try{
						System.out.print("ID em que estamos gravando: "+ (id_temp)+"\n");
						contatos.add(new Contato(id_temp, escolha1[0], new Telefone((short)Integer.parseInt(escolha1[1]), escolha1[2], escolha1[3])));		
						System.out.print("Gravado com sucesso!!!");
						System.out.print("ID="+(id_temp)+"\n");
						
						do {
							
							System.out.print("Quer add outro telefone? \nSim[1] || Não[0]\n");
							System.out.flush();
							opcaoMenu = new Scanner(System.in);
							cond = opcaoMenu.nextInt();
							
							if(cond == 1) {
								
								System.out.print("Digite o telefone (ddd,numero,tipo_detelefone)\n");
								System.out.flush();
								opcaoMenu = new Scanner(System.in);
//								
								String[] escolha2 = new String[3];
								escolha2 = opcaoMenu.nextLine().split(",");
								
								try{
									contatos.get(id_temp).telefones.add(new Telefone((short)Integer.parseInt(escolha2[0]), escolha2[1], escolha2[2]));								
								}catch (Exception ex1){
									
									System.out.print("Digite no formato correto!!!\n");
								}
								
							}else {
								System.out.print("Continuar add outros contatos[1] || Voltar ao Menu[0]\n");
								opcaoMenu = new Scanner(System.in);
								cond = opcaoMenu.nextInt();
								if(cond == 1) {
									temp = 1;
									break;
									
								}else
									temp = 0;
							}
							
						}while(cond!=0);
						
					}catch (Exception ex) {
						  System.out.print("\tErro: Escreva no formato correto!!!\n\n");
						  temp = 1;
					}
					
					
				}while(temp != 0);
			
			break;
				
			case 3:
				//REMOVENDO CONTATO				
				int busca = 0;
				int teclado = 0;
				if(!contatos.isEmpty()) {
					for (int i=0; i < contatos.size(); i++) {
						
						contatos.get(i).MostrarNaTela();
					
					}
					
					System.out.print("Digite a ID a ser deletada:\n");
					System.out.flush();
					opcaoMenu = new Scanner(System.in);
					busca = opcaoMenu.nextInt();
					
					for (int i=0; i < contatos.size(); i++) {
											
						if(contatos.get(i).id==busca) {
							busca = i;
							System.out.print("Remover[1] || Voltar ao Menu[0]");
							
							opcaoMenu = new Scanner(System.in);
							teclado = opcaoMenu.nextInt();						
							
							if(teclado == 1) {
							
								System.out.print("Tem certeza que deseja remover este contato?\n"
										+ "Sim[1] || Não[0]\n");
								opcaoMenu = new Scanner(System.in);
								teclado = opcaoMenu.nextInt();
								if(teclado == 1)
									contatos.remove(busca);
								else
									break;
								System.out.print("Removido com Sucesso!!!\n");
							}else 
								break;
						}
					}
					
				}else
					System.out.print("Agenda Vazia!!!");
				
			break;
			
			}	
			
		}while(opc != 4);		
		
		System.out.print("Programa Finalizado\n");
	}
}
