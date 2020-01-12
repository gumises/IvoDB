package newgui.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

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
}
