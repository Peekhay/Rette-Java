package GUI;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;

import javax.swing.*;

import Karte.Abschluss;
import Karte.Graph;
import Karte.Knoten;
import Karte.Listenelement;
import Player.Inventar;


public class GamePanel extends Canvas{
	
	
	private Image image;
	private ImageIcon imgI;
	private ImageLoader imgl;
	private Graphics2D g;
	public BufferStrategy strategy;
	private Dimension d;
	private int avatarX;
	private int avatarY;
	private boolean showInv;
	private boolean userMove;

	
	public GamePanel(){
		imgl = new ImageLoader();
		
		setPreferredSize(d = new Dimension(imgl.getHud().getWidth(getFocusCycleRootAncestor()),imgl.getHud().getHeight(getFocusCycleRootAncestor())-1));
		
		imgI = imgl.getImg();
				
		image = imgI.getImage();
		
		avatarX = 220;
		avatarY = 221;
		
		showInv = false;
	
	}
	
	public void init() {
    	setIgnoreRepaint(true);
    	createBufferStrategy(2);
    	strategy = getBufferStrategy();    	
    }
	
	public void zeichnen(Listenelement[][] l, Inventar inv) {
		Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
        
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION,
                RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED);
        g.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING,
                RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_DITHERING,
                RenderingHints.VALUE_DITHER_ENABLE);
        g.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS,
                RenderingHints.VALUE_FRACTIONALMETRICS_OFF);
        g.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL,
                RenderingHints.VALUE_STROKE_DEFAULT);
        
        g.clearRect(0, 0, getWidth(), getHeight());
        
		g.drawImage(imgl.getHud(),0,0,null);
		
		updateKarte(l,g);
		
		g.drawImage(imgl.getAvatar(),avatarX, avatarY, null);
		
		if(showInv) {
			invZeichnen(inv,g);
		}
		
		g.setFont(new Font("test", Font.PLAIN, 18));
		
		if(!userMove) {
			drawTextMove((Knoten)l[2][2], g);
		}else {
			g.drawString("Du darfst nun weitergehen", 550, 100);
		}
		strategy.show();
        g.dispose();
		
	}
	
	public void updateKarte(Listenelement[][] l, Graphics2D g) {
		
		for(int i = 0; i < 5;i++) {
			for(int k = 0; k < 5;k++) {
				if(l[i][k].isAufgedeckt()) {
					g.drawImage(imgl.loadImage(l[i][k]).getImage(),i*100+20,k*100+21, null);
				}else {
					g.setColor(Color.black);
					g.fillRect(i*100+20,k*100+20, 100, 101);
				}
			}
			
		}
	}
	
	public void invZeichnen(Inventar inv,  Graphics2D g) {
		g.drawImage(imgl.loadItem(inv.getHelmet().getPic()),20,540,null);
		g.drawImage(imgl.loadItem(inv.getChestplate().getPic()),106,540,null);
		g.drawImage(imgl.loadItem(inv.getBoots().getPic()),192,540,null);
		
		g.drawImage(imgl.loadItem(inv.getWeapon1().getPic()),278,540,null);
		g.drawImage(imgl.loadItem(inv.getWeapon2().getPic()),364,540,null);
		g.drawImage(imgl.loadItem(inv.getWeapon3().getPic()),450,540,null);
	}
	
	
	public ImageIcon icon() {
		return imgl.getImg();
	}
	
	public Dimension getDimension() {
		return d;
	}
	public void moveAvatar(int x, int y) {
		avatarX = avatarX+5*x;
		avatarY = avatarY+5*y;
	}
	public void resetAvatar() {
		avatarX = 220;
		avatarY = 221;
	}

	public boolean isShowInv() {
		return showInv;
	}

	public void setShowInv(boolean showInv) {
		this.showInv = showInv;
	}
	
	public void drawTextMove(Knoten k, Graphics2D g) {
		
		for(int i = 0; i< k.getEvent().getInfo().length; i++) {
			g.drawString(k.getEvent().getInfo()[i], 550, 100+i*25);
		}
	}

	public boolean isUserMove() {
		return userMove;
	}

	public void setUserMove(boolean userMove) {
		this.userMove = userMove;
	}
	
		
}