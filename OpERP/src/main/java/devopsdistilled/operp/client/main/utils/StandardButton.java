package devopsdistilled.operp.client.main.utils;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class StandardButton {
	private static StandardButton standardButton;
	
	public StandardButton(){
	
	}
	
	public static StandardButton getStandardButton() {
		return standardButton;
	}

	public static void setStandardButton(StandardButton standardButton) {
		StandardButton.standardButton = standardButton;
	}
	
	public  Icon SetStandardSizeForImage(ImageIcon icon){
		Image img=icon.getImage();
		BufferedImage bi=new BufferedImage(60, 60, BufferedImage.TYPE_INT_ARGB);
		Graphics g=bi.createGraphics();
		g.drawImage(img,0,0,60,60, null);
		Icon newIcon=new ImageIcon(bi);
		return newIcon;
		
	}
	
	public JButton SetStandardSizeForButton(JButton btn){
		btn.setMaximumSize(new Dimension(90, 90));
		btn.setMinimumSize(new Dimension(90,90));
		btn.setHorizontalTextPosition(SwingConstants.CENTER);
		btn.setVerticalTextPosition(SwingConstants.BOTTOM);
		btn.setFont(new Font("Arial", Font.PLAIN, 10));
		return btn;
	}



	

}
