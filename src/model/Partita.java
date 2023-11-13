package model;

public class Partita {
	
	private String sceltaClient1;
	private String sceltaClient2;
	private String esito;
	
	public Partita() {
		this.sceltaClient1=null;
		this.sceltaClient2=null;
		this.esito=null;
	}

	public String getSceltaClient1() {
		return sceltaClient1;
	}

	public String getSceltaClient2() {
		return sceltaClient2;
	}

	public void setSceltaClient1(String sceltaClient1) {
		this.sceltaClient1 = sceltaClient1;
	}

	public void setSceltaClient2(String sceltaClient2) {
		this.sceltaClient2 = sceltaClient2;
	}

	public String getEsito() {
		return esito;
	}

	public void setEsito(String esito) {
		this.esito = esito;
	}
	
	public void confrontaScelte() {
		if((this.sceltaClient1.compareTo("forbice")==0 && this.sceltaClient2.compareTo("forbice")==0)||(this.sceltaClient1.compareTo("sasso")==0 && this.sceltaClient2.compareTo("sasso")==0)||(this.sceltaClient1.compareTo("carta")==0 && this.sceltaClient2.compareTo("carta")==0)) {
			this.setEsito("Pareggio");
		}else if((this.sceltaClient1.compareTo("forbice")==0 && this.sceltaClient2.compareTo("carta")==0)||(this.sceltaClient1.compareTo("sasso")==0 && this.sceltaClient2.compareTo("forbice")==0)||(this.sceltaClient1.compareTo("carta")==0 && this.sceltaClient2.compareTo("sasso")==0)){
			this.setEsito("Vittoria a giocatore 1!");
		}else {
			this.setEsito("Vittoria a giocatore 2!");
		}
	}
}
