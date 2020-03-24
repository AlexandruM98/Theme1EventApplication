package Model;

public class Serviciu {
	private String tipServiciu;
	private String descriere;
	private int pret;
	
	public Serviciu(String tip, String descriere, int pret) {
		this.tipServiciu = tip;
		this.descriere = descriere;
		this.pret = pret;
	}

	public String getTipServiciu() {
		return tipServiciu;
	}

	public void setTipServiciu(String tipServiciu) {
		this.tipServiciu = tipServiciu;
	}

	public String getDescriere() {
		return descriere;
	}

	public void setDescriere(String descriere) {
		this.descriere = descriere;
	}

	public int getPret() {
		return pret;
	}

	public void setPret(int pret) {
		this.pret = pret;
	}
	
	

}
