package GUI;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;

import javax.swing.*;

import Karte.Abschluss;
import Karte.Graph;
import Karte.Knoten;
import Karte.Listenelement;


public class GamePanel extends Canvas{
	
	
	private Image image;
	private ImageIcon imgI;
	private ImageLoader imgl;
	private Graphics2D g;
	public BufferStrategy strategy;
	private Dimension d;
	private int avatarX;
	private int avatarY;

	
	public GamePanel(){
		imgl = new ImageLoader();
		
		this.setPreferredSize(d = new Dimension(imgl.getHud().getWidth(getFocusCycleRootAncestor()),imgl.getHud().getHeight(getFocusCycleRootAncestor())-1));
		
		imgI = imgl.getImg();
				
		image = imgI.getImage();
		
		avatarX = 220;
		avatarY = 221;
	}
	
	public void init() {
    	setIgnoreRepaint(true);
    	createBufferStrategy(2);
    	strategy = getBufferStrategy();    	
    }
	
	public void zeichnen(Listenelement[][] l) {
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
	
		
}