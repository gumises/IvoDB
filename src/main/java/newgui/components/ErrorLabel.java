package newgui.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

public class ErrorLabel extends JLabel {

	String message;
	String errorMessage;
	String errorMessage2;
	
	/** Text, Font, Color */
	public ErrorLabel(String message, String errorMessage, Font font) {
		super(" ");
		setFont(font);
		setForeground(Color.DARK_GRAY);
		this.message = message;
		this.errorMessage = errorMessage;
		setHorizontalAlignment(JLabel.CENTER);
		setVerticalAlignment(JLabel.CENTER);
	}
	
	/** Text, Font, Color */
	public ErrorLabel(String message, String errorMessage1, String errorMessage2, Font font) {
		super(" ");
		setFont(font);
		setForeground(Color.DARK_GRAY);
		this.message = message;
		this.errorMessage = errorMessage1;
		this.errorMessage2 = errorMessage2;
		setHorizontalAlignment(JLabel.CENTER);
		setVerticalAlignment(JLabel.CENTER);
	}
	
	/** Puts error message in label. */
	public void putError() {
		setForeground(Color.RED);
		setText(errorMessage);
	}
	
	/** Puts error message in label. */
	public void putError2() {
		setForeground(Color.RED);
		setText(errorMessage2);
	}
	
	/** Removes error message from label. */
	public void removeMessage() {
		setText(" ");
	}
	
	/** Puts message in label. */
	public void putMessage() {
		setForeground(Color.DARK_GRAY);
		setText(message);
	}
}
