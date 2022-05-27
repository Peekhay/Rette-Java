package mvc;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import GUI.MyFrame;
import Karte.Graph;
import Player.Player;

public class GameController implements KeyListener{
		private Model model;
		
		public GameController(Model model) {
			this.model = model;
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if(model.isUserMove()) {
				  switch(e.getKeyCode()) {
				  case 37: //links
					  model.setChangeX(-1);
					  break;
				  case 38: //oben
					  model.setChangeY(-1);
					  break;
				  case 39: //rechts
					  model.setChangeX(1);
					  break;
				  case 40: //unten
					  model.setChangeY(1);
					  break;
				  }
				}
			if(e.getKeyCode()== 10) { // enter
				model.setUserMove(true);
			}
			if(e.getKeyCode()== 73 ) { // i
				model.showInv();
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
		}
}
