package Player;

import Items.BootsItem;
import Items.ChestplateItem;
import Items.HelmetItem;
import Items.WeaponItem;

public class Inventar {
	private HelmetItem helmet;
	private ChestplateItem chestplate;
	private BootsItem boots;
	private WeaponItem weapon1;
	private WeaponItem weapon2;
	private WeaponItem weapon3;
	
	public Inventar() {
		
	}

	public HelmetItem getHelmet() {
		return helmet;
	}

	public void setHelmet(HelmetItem helmet) {
		this.helmet = helmet;
	}

	public ChestplateItem getChestplate() {
		return chestplate;
	}

	public void setChestplate(ChestplateItem chestplate) {
		this.chestplate = chestplate;
	}

	public BootsItem getBoots() {
		return boots;
	}

	public void setBoots(BootsItem boots) {
		this.boots = boots;
	}

	public WeaponItem getWeapon1() {
		return weapon1;
	}

	public void setWeapon1(WeaponItem weapon1) {
		this.weapon1 = weapon1;
	}

	public WeaponItem getWeapon2() {
		return weapon2;
	}

	public void setWeapon2(WeaponItem weapon2) {
		this.weapon2 = weapon2;
	}

	public WeaponItem getWeapon3() {
		return weapon3;
	}

	public void setWeapon3(WeaponItem weapon3) {
		this.weapon3 = weapon3;
	}
	
	
	

}
