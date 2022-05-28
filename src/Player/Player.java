package Player;
import Items.Akatsuki;
import Items.HermesBoots;
import Items.MagicHat;
import Items.MagicWand;
import Items.Sharingan;
import Items.WoodSword;
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
		
		
		
		
		inv.setHelmet(new MagicHat());
		inv.setChestplate(new Akatsuki());
		inv.setBoots(new HermesBoots());
		inv.setWeapon1(new WoodSword());
		inv.setWeapon2(new Sharingan());
		inv.setWeapon3(new MagicWand());
		
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

	public Inventar getInv() {
		return inv;
	}

	public void setInv(Inventar inv) {
		this.inv = inv;
	}
	
	
	
}
