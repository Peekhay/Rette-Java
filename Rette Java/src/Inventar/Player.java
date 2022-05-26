package Inventar;
import Karte.*;

public class Player {

	private Inventar inv;
	private int aktuellerKnotenX;
	private int aktuellerKnotenY;
	private int maxHP;
	private int currrentHP;
	
	public Player() {
		aktuellerKnotenX = 1;
		aktuellerKnotenY = 18;
		inv = new Inventar();
		
	}

	public int getAktuellerKnotenX() {
		return aktuellerKnotenX;
	}

	public void setAktuellerKnotenX(int aktuellerKnotenX) {
		this.aktuellerKnotenX = aktuellerKnotenX;
	}

	public int getAktuellerKnotenY() {
		return aktuellerKnotenY;
	}

	public void setAktuellerKnotenY(int aktuellerKnotenY) {
		this.aktuellerKnotenY = aktuellerKnotenY;
	}
	
	
}
