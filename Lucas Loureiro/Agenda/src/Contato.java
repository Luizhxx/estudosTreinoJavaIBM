import java.util.ArrayList;
import java.util.List;

public class Contato {
	String nome;
	List<Telefone> telefones = new ArrayList<Telefone>();
    
    
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	
    
}
