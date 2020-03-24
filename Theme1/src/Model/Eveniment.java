package Model;

import java.util.ArrayList;

public class Eveniment {
	private int idEvent;
	private String tip;
	private Locatie locatie;
	private String perioada;
	private String pret;
	private int nrPersoane;
	private ArrayList<Serviciu> listaServicii;
	
	public Eveniment(String tip, Locatie locatie, String perioada,int nrPersoane) {		
		this.tip = tip;
		this.locatie = locatie;
		this.perioada = perioada;	
		this.nrPersoane = nrPersoane;
		this.listaServicii = new ArrayList<Serviciu>();
	}
	
	public Eveniment(int id,String tip, Locatie locatie, String perioada,int nrPersoane) {
		this.idEvent = id;
		this.tip = tip;
		this.locatie = locatie;
		this.perioada = perioada;	
		this.nrPersoane = nrPersoane;
		this.listaServicii = new ArrayList<Serviciu>();
	}
	
	public void setId(int id) {
		idEvent = id;
	}
	
	public int getId() {
		return idEvent;
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
	
	

	public int getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}

	public ArrayList<Serviciu> getListaServicii() {
		return listaServicii;
	}

	public void setListaServicii(ArrayList<Serviciu> listaServicii) {
		this.listaServicii = listaServicii;
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
