package Karte;

public abstract class Listenelement {
	
	private Listenelement norden;
	private Listenelement osten;
	private Listenelement sueden;
	private Listenelement westen;
	private boolean aufgedeckt;
	private String karte;
	
	
	public Listenelement getNorden() {
		return norden;
	}
	public void setNorden(Listenelement norden) {
		this.norden = norden;
	}
	public Listenelement getOsten() {
		return osten;
	}
	public void setOsten(Listenelement osten) {
		this.osten = osten;
	}
	public Listenelement getSueden() {
		return sueden;
	}
	public void setSueden(Listenelement sueden) {
		this.sueden = sueden;
	}
	public Listenelement getWesten() {
		return westen;
	}
	public void setWesten(Listenelement westen) {
		this.westen = westen;
	}
	public String getKarte() {
		return karte;
	}
	public void setKarte(String karte) {
		this.karte = karte;
	}
	public boolean isAufgedeckt() {
		return aufgedeckt;
	}
	public void setAufgedeckt(boolean aufgedeckt) {
		this.aufgedeckt = aufgedeckt;
	}
	

}
