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

public class StandardButtonHelper {

	public static Icon SetStandardSizeForImage(ImageIcon icon){
		Image img=icon.getImage();
		BufferedImage bi=new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);
		Graphics g=bi.createGraphics();
		g.drawImage(img,0,0,50,50, null);
		Icon newIcon=new ImageIcon(bi);
		return newIcon;
		
	}
	
	public static JButton SetStandardSizeForButton(JButton btn){
		btn.setMaximumSize(new Dimension(95, 95));
		btn.setMinimumSize(new Dimension(95,95));
		btn.setHorizontalTextPosition(SwingConstants.CENTER);
		btn.setVerticalTextPosition(SwingConstants.BOTTOM);
		btn.setFont(new Font("Arial", Font.PLAIN, 10));
		return btn;
	}



	

}
