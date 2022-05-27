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
					  model.setUserMove(false);
					  model.animateAvatar(-1,0);
					  model.updateKoordinaten(-1, 0);
					  //model.setUserMove(true);
				   break;
				  case 38: //oben
					  model.setUserMove(false);
					  model.animateAvatar(0,-1);
					  model.updateKoordinaten(0, -1);
					  //model.setUserMove(true);
				   break;
				  case 39: //rechts
					  model.setUserMove(false);
					  model.animateAvatar(1, 0);
					  model.updateKoordinaten(1, 0);
					  //model.setUserMove(true);
				   break;
				  case 40: //unten
					  model.setUserMove(false);
					  model.animateAvatar(0,1);
					  model.updateKoordinaten(0, 1);
				   break;
				  }
				}
			if(e.getKeyCode()== 10) { // enter
				model.setUserMove(true);
				model.updateKoordinaten(0, 0);
			}
			if(e.getKeyCode()== 73 ) { // i
				model.drawInv();
				model.updateKoordinaten(0, 0);
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
		}
}
