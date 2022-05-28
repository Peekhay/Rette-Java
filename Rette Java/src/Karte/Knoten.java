package Karte;
import java.awt.*;
import javax.swing.*;

public class Knoten extends Listenelement{
	
	private Fight f;
	private boolean aufgedeckt;
	private String karte;
	
	public Knoten() {
		f = new Fight();
	}
	
	public boolean isAufgedeckt() {
		return aufgedeckt;
	}
	public void setAufgedeckt(boolean aufgedeckt) {
		this.aufgedeckt = aufgedeckt;
	}
	
	public String getKarte() {
		return karte;
	}
	public void setKarte(String karte) {
		this.karte = karte;
	}
	public void setEvent(Fight event) {
		this.f = event;
	}
	public Event getEvent() {
		return f;
	}
}
