package newgui.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ActionButton extends JButton {

	int accessLevel;

	/** Image, AccessLevel, Color */
	public ActionButton(ImageIcon icon, int accessLevel, Color color) {
		super(icon);
		setBackground(color);
		this.accessLevel = accessLevel;
	}
  
	/** Text, AccessLevel, Color */
	public ActionButton(String text, int accessLevel, Color color) {
		super(text);
		setBackground(color);
		setForeground(Color.WHITE);
		this.accessLevel = accessLevel;
	}
	
	/** Text, Color, Font, Dimension */
	public ActionButton(String text, Color color, Font font, Dimension dimension) {
		super(text);
		setBackground(color);
		setForeground(Color.WHITE);
		setPreferredSize(dimension);
		setFont(font);
	}
	
	/** Text, Color, Font, Dimension */
	public ActionButton(String text, Color color, Font font) {
		super(text);
		setBackground(color);
		setForeground(Color.WHITE);
		setFont(font);
	}
	
	/** Disables or enables button depending on the status value. */
	public void changeAccess(int access) {
		if(access <= accessLevel)
			setEnabled(true);
		else
			setEnabled(false);
	}
}
