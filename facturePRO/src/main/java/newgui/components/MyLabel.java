package newgui.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class MyLabel extends JLabel {

	/** Text, Font, Dimension */
	public MyLabel(String text, Font font, Dimension dimension, Color color) {
		super(text);
		setFont(font);
		setPreferredSize(dimension);
		setForeground(color);
		setHorizontalAlignment(JLabel.CENTER);
		setVerticalAlignment(JLabel.CENTER);
	}
	
	/** Text, Font */
	public MyLabel(String text, Font font) {
		super(text);
		setFont(font);
		setHorizontalAlignment(JLabel.CENTER);
		setVerticalAlignment(JLabel.CENTER);
	}
	
	/** Text, Font, Color */
	public MyLabel(String text, String title, Font font, Color color) {
		super(text);
		setFont(font);
		setForeground(color);
		setHorizontalAlignment(JLabel.CENTER);
		setVerticalAlignment(JLabel.CENTER);
		
		//setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
		setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY), title, TitledBorder.LEADING,
	            TitledBorder.TOP, null, Color.LIGHT_GRAY));
	}
}
