package principale;

public class Voce {
	//singola voce di un contatto, nome e telefono
	public String nome;
	public String numero;
	
	public Voce(String nomee, String numeroo) {
		this.nome=nomee;
		this.numero=numeroo;
	}
	
	public String getNumero() {return this.numero;}
	
	public int setNumero(String numeroo) {
		if(numero.matches("[0-9]+") && numeroo.length()<10){ 
			this.numero=numeroo;
			return 2; 
		}else {
			return 5;
		}
	}

	public String getNome() {return this.nome;}
	public int setNome(String a) {
		if((a.matches("[a-zA-Z]+")) && a.length()<15){
			this.nome=a;
			return 2;
		}else {
			return 5;
		}
	}
}
