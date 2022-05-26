package GUI;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Karte.Knoten;
import Karte.Listenelement;

public class ImageLoader {
	
	private ImageIcon imagei;
	private ImageIcon hud;
	private ImageIcon avatar;
	
	public ImageLoader() {
		
		imagei = new ImageIcon("nftPrager.png");
		
		hud = new ImageIcon("interface/hud.png");
		// hintergrund = new ImageIcon("interface/Wasser-Hintergrund.png");
		avatar = new ImageIcon("interface/avatar.png");
		
	}

	public ImageIcon getImg() {
		return imagei;
	}
	public Image getHud() {
		return hud.getImage();
	}
	
	public Image getAvatar() {
		return avatar.getImage();
	}
	public ImageIcon loadImage (Listenelement k) {
		return new ImageIcon(k.getKarte());
	}
}
