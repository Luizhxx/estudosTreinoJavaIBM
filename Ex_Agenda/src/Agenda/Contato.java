package Agenda;

import java.util.List;
import java.util.ArrayList;

public class Contato{
	Integer id;
    String nome;
    List<Telefone> telefones = new ArrayList<Telefone>();; 
       
    Contato(int id, String nome, Telefone telefones){
    	this.id = id;
    	this.nome = nome;	
    	this.telefones.add(telefones);
    }
    
    void MostrarNaTela() {
    	
    	System.out.print("ID: "+ id + "\n"
    			+ "Nome:"+nome+"\n");
    }
    
    void MostrarTelefones() {
    	
    	for(int i = 0; i<telefones.size(); i++) {
    		System.out.print("Telefone "+ (i+1)+"\n");
    		telefones.get(i).ImprimirTelefone();
    		
    		
    	}
    	
    }
    
}
