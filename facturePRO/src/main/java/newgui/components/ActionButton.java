package newgui.components;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ActionButton extends JButton {

	int accessLevel;

	/** Constructor with image.*/
	public ActionButton(ImageIcon icon, int accessLevel, Color color) {
		super(icon);
		setBackground(color);
		this.accessLevel = accessLevel;
	}
  
	/** Constructor with text.*/
	public ActionButton(String text, int accessLevel, Color color) {
		super(text);
		setBackground(color);
		setForeground(Color.WHITE);
		this.accessLevel = accessLevel;
	}
	
	/** Disables or enables button depending on the status value. */
	public void changeAccess(int access) {
		if(access <= accessLevel)
			setEnabled(true);
		else
			setEnabled(false);
	}
}
