package newgui.dialogs;

import javax.swing.JDialog;

import newdatabase.HibernateUtil;
import newgui.components.ActionButton;
import newgui.components.MyLabel;
import newgui.components.MyTextField;

import static newgui.constants.ButtonsPanelConstants.SEARCH_PRODUCTS;
import static newgui.constants.LoginDialogConstants.*;
import static newgui.constants.DataFormats.*;
import static newgui.components.FormatterFactory.getFormat;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class LoginDialog extends JDialog {

	//labels
	MyLabel loginLabel;
	MyLabel passwordLabel;
	MyLabel wrongDataLabel;
	
	// fields
	MyTextField loginField;
	MyTextField passwordField;
	
	// button
	ActionButton button;
	
	// values
	String password;
	String login;
	
	public LoginDialog() {
		
		// labels
		loginLabel = new MyLabel(LOGIN_TEXT, LABEL_FONT, LABEL_DIMENSION, LABEL_TEXT_COLOR);
		passwordLabel = new MyLabel(PASSWORD_TEXT, LABEL_FONT, LABEL_DIMENSION, LABEL_TEXT_COLOR);
		wrongDataLabel = new MyLabel("", LABEL_FONT);
		
		// fields
		loginField = new MyTextField(FIELD_FONT, FIELD_DIMENSION);
		passwordField = new MyTextField(getFormat(INTEGER), FIELD_FONT, FIELD_DIMENSION);
		
		//button
		button = new ActionButton(BUTTON_TEXT, BUTTON_COLOR, BUTTON_FONT, BUTTON_DIMENSION);
		button.addActionListener(event -> tryLogIn());
		
	    // gridBagLayout
	    GridBagLayout layout = new GridBagLayout();
	    GridBagConstraints gbc = new GridBagConstraints();
	    setLayout(layout);
	    
	    //gbc init
	    //gbc.weightx = 1;
	    //gbc.weighty = 1;
	    gbc.insets = new Insets(5,5,5,5);
	    //gbc.fill = GridBagConstraints.BOTH;
	    
	    // login label
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    add(loginLabel, gbc);
	    
	    // login field
	    gbc.gridx = 1;
	    gbc.gridy = 0;
	    add(loginField, gbc);
	    
	    // password Label
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	    add(passwordLabel, gbc);
	    
	    // password field
	    gbc.gridx = 1;
	    gbc.gridy = 1;
	    add(passwordField, gbc);
	    
	    // button
	    gbc.gridx = 0;
	    gbc.gridy = 3;
	    gbc.gridwidth = 2;
	    add(button, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		add(wrongDataLabel, gbc);

	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    setPreferredSize(DIALOG_DIMENSION);
	    setBackground(DIALOG_COLOR);
	    setTitle(TITLE);
	    pack();
	    setVisible(false);
	}
	
	/** Sets dialog visible. */
	public void init() {
		setVisible(true);
		//pack();
	}
	
	/** Invoked when user presses login button. */
	public void tryLogIn() {
		wrongDataLabel.setText("");
		login = loginField.getText();
		password = passwordField.getText();
		try {
			HibernateUtil.createNewSession(password, login);
			HibernateUtil.getSessionFactory().openSession().beginTransaction();
		}
		catch(Exception e)
		{
			System.out.println("Unsuccessful logging ");
			HibernateUtil.reset();
			wrongDataLabel.setText("Try again");
		}
		}

	
	public static void main(String[] args) {
		new LoginDialog();
	}

}
