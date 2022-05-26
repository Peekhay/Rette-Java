package Karte;

public class Graph {
	
	private Listenelement[][] lem;
	private int xAchse;
	private int yAchse;
	public static int karteGroesse;
	
	public Graph() {
		
		graphenErzeugen();
		
		abschlussBilder();
		
		mitteBilder();
		
		kampfBeispiel();
	}
	
	private void graphenErzeugen() {
	
		xAchse = 20;
		yAchse = 20;
		
		lem = new Listenelement[xAchse][yAchse];
		
		for(int x=0;x<lem.length;x++) {
			lem[0][x]= new Abschluss();
			lem[x][0]= new Abschluss();
			lem[lem.length-1][x]= new Abschluss();
			lem[x][lem.length-1]= new Abschluss();
		}
		//x ist die x-koordinate
		//y ist die y-koodrinate
		
		for(int x=0;x<lem.length;x++) {
			
			for(int y=0;y<lem.length;y++) {
				
				if(!(lem[x][y]  instanceof Abschluss )) {
				lem[x][y]= new Knoten();
				}
			}
		}
		//x ist die x-koordinate
		//y ist die y-koodrinate
		
		for(int x=1;x<lem.length-1;x++) {
			for(int y=1;y<lem.length-1;y++) {
				lem[x][y].setNorden(lem[x][y-1]);
				lem[x][y].setOsten(lem[x+1][y]);
				lem[x][y].setSueden(lem[x][y+1]);
				lem[x][y].setWesten(lem[x-1][y]);
			}
		}
	}
	
	private void abschlussBilder() {
		lem[0][0].setKarte("map/0.png");
		lem[0][lem.length-1].setKarte("map/6.png");
		lem[lem.length-1][0].setKarte("map/2.png");
		lem[lem.length-1][lem.length-1].setKarte("map/9.png");
		
		for(int i=1; i <lem.length-1; i++) {
			lem[i][0].setKarte("map/1.png");
			lem[0][i].setKarte("map/3.png");
			lem[i][lem.length-1].setKarte("map/7.png");
			lem[lem.length-1][i].setKarte("map/5.png");
		}
	}
	
	private void mitteBilder() {
		/*
		for(int i=1; i <lem.length-3; i++) {
			for(int k=1; k <lem.length-3; k++) {
				lem[i][k].setKarte("map/4.1.png");
			}
		}
		*/
		
		for(int i=1; i <lem.length-2;i=i+2) {
			for(int k=1; k < lem.length-2;k= k+2) {
				lem[i][k].setKarte("map/4.1.png");
				lem[i][k+1].setKarte("map/4.2.png");
				lem[i+1][k].setKarte("map/4.2.png");
				lem[i+1][k+1].setKarte("map/4.1.png");
			}
		}
	}

	public Listenelement getKnoten(int x, int y) {
		return lem[x][y];
	}
	public void updateKnoten(Listenelement l,int x,int y) {
		lem[x][y]= l;
	}

	private void kampfBeispiel() {
		
		Fight f = new Fight();
		f.setEnemy("MarcoMaurer");
		f.setInfo("Du triffst auf Marco Maurer, einen der geführchtetsten Programmier-Zauberer "
				+ "auf ganz Java. Seit der Herrschaft von professor P ist er sein treuer"
				+ " Diener und bewacht den Hafen der Insel. Er fordert dich zum Duell heraus. "
				+ "Wenn du die Herausforderung annimmst, drücke 'h'. Wenn du lieber fliehen möchtest drücke 'f'");
		lem[1][17].setEvent(f);
	}
}
