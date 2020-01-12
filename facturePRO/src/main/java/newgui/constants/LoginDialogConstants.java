package newgui.constants;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class LoginDialogConstants {

	//texts
	public final static String TITLE = "Okno logowania";
	public final static String LOGIN_TEXT = "login :";
	public final static String PASSWORD_TEXT = "haslo :";
	public final static String BUTTON_TEXT = "zaloguj";
	
	//dimensions
	public final static Dimension FIELD_DIMENSION = new Dimension(200,60);
	public final static Dimension LABEL_DIMENSION = new Dimension(100,60);
	public final static Dimension BUTTON_DIMENSION = new Dimension(310,75);
	public final static Dimension DIALOG_DIMENSION = new Dimension(470,330);
	
	//colors
	public final static Color BUTTON_COLOR = Color.blue;
	public final static Color DIALOG_COLOR = Color.BLUE.darker();
	public final static Color LABEL_TEXT_COLOR = Color.DARK_GRAY;
	
	//fonts
	public final static Font BUTTON_FONT = new Font("Helvetica", Font.PLAIN, 25);
	public final static Font LABEL_FONT = new Font("Helvetica", Font.PLAIN, 20);
	public final static Font FIELD_FONT = new Font("Helvetica", Font.PLAIN, 20);
	
	private LoginDialogConstants() {}
}
