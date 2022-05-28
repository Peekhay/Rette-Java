package Karte;

public class Fight extends Event{
	private String enemy;
	private String[] info;
	
	public Fight() {
		info = new String[2];
		info[0] = "Hier befindet sich kein Gegner.";
		info[1] = "Drücke 'Enter' um weiterzugehen";
		
	
	}
	
	
	public String getEnemy() {
		return enemy;
	}
	public void setEnemy(String enemy) {
		this.enemy = enemy;
	}
	public String[] getInfo() {
		return info;
	}
	public void setInfo(String[] info) {
		this.info = info;
	}
	
}
