package mvc;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import GUI.MyFrame;
import Inventar.Player;
import Karte.Graph;

public class GameController implements KeyListener{
		private Model model;
		
		public GameController() {
			model = new Model();
			model.addKL(this);
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			  switch(e.getKeyCode()) {
			  case 37: //links
				  model.animateAvatar(-1,0);
				  model.updateKoordinaten(-1, 0);
			   break;
			  case 38: //oben
				  model.animateAvatar(0,-1);
				  model.updateKoordinaten(0, -1);
			   break;
			  case 39: //rechts
				  model.animateAvatar(1, 0);
				  model.updateKoordinaten(1, 0);
			   break;
			  case 40: //unten
				  model.animateAvatar(0,1);
				  model.updateKoordinaten(0, 1);
			   break;
			  }
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
}
