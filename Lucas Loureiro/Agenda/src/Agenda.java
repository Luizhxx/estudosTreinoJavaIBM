import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Agenda {

	public static void main(String[] args) {
		int entrada;
		int id;
		List<Contato> contatos = new ArrayList<Contato>();
		FuncoesAgenda fAgenda = new FuncoesAgenda();
		Scanner scan = new Scanner(System.in);
		String sN;
		
		entrada = fAgenda.imprimeMenu();
		while(entrada != 4) {
			switch(entrada) {
			case 1:
				System.out.println("ID do contato:");
				id = scan.nextInt();
				fAgenda.consultaContato(id - 1, contatos);
				System.out.println("ENTER para voltar ao menu.");
				scan = new Scanner(System.in);
				scan.nextLine();
				entrada = fAgenda.imprimeMenu();
				break;
			case 2:
				contatos.add(fAgenda.adicionaContato());
				System.out.println("Adicionar mais um contato?S/N");
				sN = scan.next();
				while(sN.equals("S")) {
					contatos.add(fAgenda.adicionaContato());
					System.out.println("Continuar adicionando?S/N");
					sN = scan.next();
				}
				entrada = fAgenda.imprimeMenu();
				break;
			case 3:
				System.out.println("ID do contato:");
				id = scan.nextInt();
				if (contatos.size() > id - 1) {
					fAgenda.consultaContato(id - 1, contatos);
					System.out.println("Remover contato?S/N");
					sN = scan.next();
					if (sN.equals("S")) {
						contatos.remove(id);
					}
				}else System.out.println("Contato nao existe.");
				entrada = fAgenda.imprimeMenu();
				break;
			case 5:
				fAgenda.listaContatos(contatos);
				System.out.println("ENTER para voltar ao menu.");
				scan = new Scanner(System.in);
				scan.nextLine();
				entrada = fAgenda.imprimeMenu();
				break;
			}
		}	
	}
}
