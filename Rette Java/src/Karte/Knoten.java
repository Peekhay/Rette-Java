package Karte;
import java.awt.*;
import javax.swing.*;

public class Knoten extends Listenelement{
	
	private Event event;
	private boolean aufgedeckt;
	private String karte;
	
	public Knoten() {
		
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
	public void setEvent(Event e) {
		event = e;
	}
}
