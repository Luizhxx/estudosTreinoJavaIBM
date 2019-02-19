import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FuncoesAgenda {
	Scanner scan = new Scanner(System.in);
	int entrada;
	String textoNome;
	Short ddd;
	String textoTelefone;
	String textoTipoTelefone;
	String sN; 
	
	
	public void consultaContato(int idConsulta, List<Contato> contatos) {
		if (contatos.size() > idConsulta) {
			Contato contato = contatos.get(idConsulta);
			System.out.println(contato.getNome());
			for (Telefone telefone : contato.telefones) {
				System.out.println("(" + telefone.ddd + ") " + telefone.numero + " - " + telefone.tipoTelefone);
			}
		}else System.out.println("Contato nao existe.");
	}

	public Contato adicionaContato() {
		Contato novoContato = new Contato();
		System.out.println("Nome:");
		textoNome = scan.next();
		novoContato.setNome(textoNome);
		novoContato.telefones.add(adicionaTelefone());
		
		System.out.println("Adicionar mais um telefone?S/N");
		sN = scan.next();
		while (sN.equals("S")) {
			novoContato.telefones.add(adicionaTelefone());
			System.out.println("Adicionar mais um telefone?S/N");
			sN = scan.next();
		}
		
		return novoContato;
		
	}

	public Telefone adicionaTelefone() {
		Telefone telefone = new Telefone();
		System.out.println("DDD:");
		ddd = scan.nextShort();
		telefone.setDdd(ddd);
		System.out.println("Telefone:");
		textoTelefone = scan.next();
		telefone.setNumero(textoTelefone);
		System.out.println("Tipo de telefone:");
		textoTipoTelefone = scan.next();
		telefone.setTipoTelefone(textoTipoTelefone);
		return telefone;
	}

	public void removerContato(int idRemocao, List<Contato> contatos) {
		if (contatos.size() > idRemocao) {
			consultaContato(idRemocao, contatos);
			System.out.println("Remover contato?S/N");
			sN = scan.next();
			if (sN.equals("S")) {
				contatos.remove(idRemocao);
			}
		}else System.out.println("Contato nao existe.");
	}

	public int imprimeMenu() {
		System.out.println("Menu:");
		System.out.println("1 - Consultar contato;");
		System.out.println("2 - Adicionar contato;");
		System.out.println("3 - Remover contato;");
		System.out.println("4 - Sair;");
		System.out.println("5 - Listar contatos;");
		entrada = scan.nextInt();
		return entrada;
	}

	public void listaContatos(List<Contato> contatos) {
		if (contatos.size() > 0) {
			int i = 1;
			for (Contato contato : contatos) {
				System.out.println("ID " + i);
				System.out.println(contato.getNome());
				for (Telefone telefone : contato.telefones) {
					System.out.println("(" + telefone.ddd + ") " + telefone.numero + " - " + telefone.tipoTelefone);
				}
				i++;
			}
		}else System.out.println("Sem contatos.");
		
	}
}

