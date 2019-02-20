package Agenda;

public class Telefone {
	
    Short ddd;
    String numero;
    String tipoTelefone;
    
   Telefone (short ddd, String numero, String tipoTelefone){
    	this.ddd = ddd;
    	this.numero = numero;
    	this.tipoTelefone = tipoTelefone;    	
    }
    
    
	public Short getDdd() {
		return ddd;
	}
	public void setDdd(Short ddd) {
		this.ddd = ddd;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getTipoTelefone() {
		return tipoTelefone;
	}
	public void setTipoTelefone(String tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}
    
    
    void ImprimirTelefone() {
    	
    	System.out.print(tipoTelefone+" "+"("+ddd+")"+" "+numero+"\n");
    }
    
}
