package mvc;

import GUI.GamePanel;
import GUI.MyFrame;
import Karte.Abschluss;
import Karte.Graph;
import Karte.Knoten;
import Karte.Listenelement;
import Player.Player;

import java.util.concurrent.TimeUnit;

public class Model {
	private MyFrame frame;
	private GamePanel gameView;
	private Player player;
	private Graph graph;
	private boolean userMove;
	private GameController g;
	private int changeX;
	private int changeY;
	//private MenuPanel menuView;
	//private MenuPanel startView;
	
	public Model() {
		gameView = new GamePanel();
		frame = new MyFrame();
		player = new Player();
		graph = new Graph();
		frame.setSize(gameView.getDimension());
		frame.setIconImage(gameView.icon().getImage());
		frame.add(gameView);
		frame.pack();
		gameView.init();
		//updateKoordinaten(0, 0);
		userMove = true;
		//gameView.zeichnen(getKarte(), player.getInv());
		g = new GameController(this);
		frame.addKeyListener(g);
		frame.pack();
	
	}

	public void zeichnen() {
		updateKoordinaten();
		gameView.zeichnen(getKarte(),player.getInv());
	}
	
	public Listenelement[][] getKarte() {
		Listenelement[][] temp = new Listenelement[5][5];
		for(int i = 0; i < 5; i++) {
			for(int k = 0; k < 5; k++) {
				if(player.getAktuellerKnotenX()-2+i < 0 ||player.getAktuellerKnotenY()-2+k < 0|| player.getAktuellerKnotenX()-2+i >= 20 ||player.getAktuellerKnotenY()-2+k >= 20) {
					temp[i][k] = new Knoten();
					temp[i][k].setAufgedeckt(true);
				}else {
					temp[i][k] = graph.getKnoten(player.getAktuellerKnotenX()-2+i, player.getAktuellerKnotenY()-2+k);
				}
			}
		}
		return temp;
	}
	
	public void updateKoordinaten() {
		if(check(changeX,changeY)) {
			player.setAktuellerKnotenX(player.getAktuellerKnotenX()+changeX);
			player.setAktuellerKnotenY(player.getAktuellerKnotenY()+changeY);
			Listenelement temp = graph.getKnoten(player.getAktuellerKnotenX(), player.getAktuellerKnotenY());
			temp.setAufgedeckt(true);
			graph.updateKnoten(temp, player.getAktuellerKnotenX(), player.getAktuellerKnotenY());
			
			int tempx = player.getAktuellerKnotenX();
			int tempy = player.getAktuellerKnotenY();
			
			if(graph.getKnoten(player.getAktuellerKnotenX()-1, player.getAktuellerKnotenY()) instanceof Abschluss) {
				temp = graph.getKnoten(player.getAktuellerKnotenX()-1, player.getAktuellerKnotenY());
				temp.setAufgedeckt(true);
				graph.updateKnoten(temp, player.getAktuellerKnotenX()-1, player.getAktuellerKnotenY());
				tempx --;
			}
			
			if(graph.getKnoten(player.getAktuellerKnotenX()+1, player.getAktuellerKnotenY()) instanceof Abschluss) {
				temp = graph.getKnoten(player.getAktuellerKnotenX()+1, player.getAktuellerKnotenY());
				temp.setAufgedeckt(true);
				graph.updateKnoten(temp, player.getAktuellerKnotenX()+1, player.getAktuellerKnotenY());
				tempx ++;
			}
			
			if(graph.getKnoten(player.getAktuellerKnotenX(), player.getAktuellerKnotenY()-1) instanceof Abschluss) {
				temp = graph.getKnoten(player.getAktuellerKnotenX(), player.getAktuellerKnotenY()-1);
				temp.setAufgedeckt(true);
				graph.updateKnoten(temp, player.getAktuellerKnotenX(), player.getAktuellerKnotenY()-1);
				tempy --;
			}
			
			if(graph.getKnoten(player.getAktuellerKnotenX(), player.getAktuellerKnotenY()+1) instanceof Abschluss) {
				temp = graph.getKnoten(player.getAktuellerKnotenX(), player.getAktuellerKnotenY()+1);
				temp.setAufgedeckt(true);
				graph.updateKnoten(temp, player.getAktuellerKnotenX(), player.getAktuellerKnotenY()+1);
				tempy++;
			}
			
				temp = graph.getKnoten(tempx,tempy);
				temp.setAufgedeckt(true);
				graph.updateKnoten(temp,tempx,tempy);
		}
		changeX = 0;
		changeY = 0;
	}
		
	public boolean check(int changeX, int changeY) {
		if (graph.getKnoten(player.getAktuellerKnotenX()+changeX, player.getAktuellerKnotenY()+changeY) instanceof Abschluss) {
			return false;
		}
			return true;
	}
	/*
	public void animateAvatar(int x, int y){
		for(int i = 0; i <20; i++) {
			gameView.moveAvatar(x, y);
			gameView.zeichnen(getKarte(),player.getInv());
			try {
				TimeUnit.MILLISECONDS.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		gameView.resetAvatar();
		gameView.zeichnen(getKarte(),player.getInv());
	}
	 */
	public boolean isUserMove() {
		return userMove;
	}

	public void setUserMove(boolean userMove) {
		this.userMove = userMove;
	}
	public void showInv() {
		if(gameView.isShowInv()) {
			gameView.setShowInv(false);
		}else {
			gameView.setShowInv(true);
		}
	}

	public int getChangeX() {
		return changeX;
	}

	public void setChangeX(int changeX) {
		this.changeX = changeX;
		userMove = false;
	}

	public int getChangeY() {
		return changeY;
		
	}

	public void setChangeY(int changeY) {
		this.changeY = changeY;
		userMove = false;
	}
	
}
