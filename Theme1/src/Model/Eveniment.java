package Model;

import java.util.ArrayList;

public class Eveniment implements java.io.Serializable  {
	private int idEvent;
	private String tip;
	private Locatie locatie;
	private String perioada;
	private String pret;
	private int nrPersoane;
	
	public Eveniment(String tip, Locatie locatie, String perioada,int nrPersoane) {		
		this.tip = tip;
		this.locatie = locatie;
		this.perioada = perioada;	
		this.nrPersoane = nrPersoane;
		
	}
	
	public Eveniment(int id,String tip, Locatie locatie, String perioada,int nrPersoane) {
		this.idEvent = id;
		this.tip = tip;
		this.locatie = locatie;
		this.perioada = perioada;	
		this.nrPersoane = nrPersoane;		
	}
	
	public Eveniment() {
		this.locatie = new Locatie();
	}

	public void setId(int id) {
		idEvent = id;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public Locatie getLocatie() {
		return locatie;
	}

	public void setLocatie(Locatie locatie) {
		this.locatie = locatie;
	}

	public String getPerioada() {
		return perioada;
	}

	public void setPerioada(String perioada) {
		this.perioada = perioada;
	}

	public String getPret() {
		return pret;
	}

	public void setPret(String pret) {
		this.pret = pret;
	}
	public void setOras(String oras) {
		locatie.setOras(oras);
	}
	public void setNumeR(String numeR) {
		locatie.setANume(numeR);
	}
	
	

	public int getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}	

	public int getNrPersoane() {
		return nrPersoane;
	}
	

	public void setNrPersoane(int nrPersoane) {
		this.nrPersoane = nrPersoane;
	}
	//De exemplu : 1 Nunta Medias Tarnava 20.02.2021 250
	public String toString() {
		return idEvent + " " + tip + " " + locatie.toString() + " " + perioada + " " + nrPersoane;
	}
	
	
	
	
	
	

}
