package newgui.temppanels;

import javax.swing.JFrame;
import javax.swing.JPanel;

import newgui.Gui;
import newgui.components.ActionButton;
import newgui.components.ErrorLabel;
import newgui.components.MyLabel;
import newgui.components.MyTextField;

import static newgui.constants.AreaPanelConstants.*;
import static newgui.constants.DataFormats.*;
import static newgui.components.FormatterFactory.getFormat;
import static newdatabase.connector.ClientConnector.*;
import static newgui.constants.ButtonsPanelConstants.*;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class AddClientPanel extends JPanel {

	//parent
	Gui parent;
	
	// fields
	MyTextField name;
	MyTextField phone;
	MyTextField nip;
	
	MyTextField city;
	MyTextField street;
	MyTextField house;
	MyTextField post;
	
	// button
	ActionButton button;
	
	// labels
	MyLabel title1;
	MyLabel title2;
	ErrorLabel error;
	
	//values
	String nameV;
	String phoneV;
	String nipV;
	
	String cityV;
	String streetV;
	String houseV;
	String postV;
	
	public AddClientPanel(Gui parent) {
		
		this.parent = parent;
		
		// fields
		name = new MyTextField(getFormat(TEXT), FIELD_FONT, PURCH_NAME);
		phone = new MyTextField(getFormat(TEXT), FIELD_FONT, PURCH_PHONE);
		nip = new MyTextField(getFormat(TEXT), FIELD_FONT, PURCH_NIP);
		
		city = new MyTextField(getFormat(TEXT), FIELD_FONT, PURCH_CITY);
		street = new MyTextField(getFormat(TEXT), FIELD_FONT, PURCH_STREET);
		house = new MyTextField(getFormat(TEXT), FIELD_FONT, PURCH_HOUSE);
		post = new MyTextField(getFormat(TEXT), FIELD_FONT, PURCH_POST);
		
		// label
		error = new ErrorLabel(PURCH_MESSAGE, PURCH_ERROR, ERROR_FONT);
		title1 = new MyLabel(PURCH_TITLE1, LABEL_FONT);
		title2 = new MyLabel(PURCH_TITLE2, LABEL_FONT);
		
		//button
		button = new ActionButton(BUTTON_ADD, BUTTON_COLOR, BUTTON_FONT);
		button.addActionListener(event -> tryAdd());
		
	    // gridBagLayout
	    GridBagLayout layout = new GridBagLayout();
	    GridBagConstraints gbc = new GridBagConstraints();
	    setLayout(layout);
	    
	    //gbc init
	    gbc.weightx = 1;
	    gbc.weighty = 1;
	    gbc.insets = new Insets(3,3,3,3);
	    gbc.fill = GridBagConstraints.BOTH;
	    
	    // title1
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.gridwidth = 2;
	    add(title1, gbc);
	    
	    // name
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	    gbc.gridwidth = 2;
	    add(name, gbc);
	    
	    // phone
	    gbc.gridx = 0;
	    gbc.gridy = 2;
	    gbc.gridwidth = 1;
	    add(phone, gbc);
	    
	    // nip
	    gbc.gridx = 1;
	    gbc.gridy = 2;
	    add(nip, gbc);
	    
	    // title2
	    gbc.gridx = 0;
	    gbc.gridy = 3;
	    gbc.gridwidth = 2;
	    add(title2, gbc);
	    
	    // city
	    gbc.gridx = 0;
	    gbc.gridy = 4;
	    add(city, gbc);
	    
	    // street
	    gbc.gridx = 0;
	    gbc.gridy = 5;
	    add(street, gbc);
	    
	    // post
	    gbc.gridx = 0;
	    gbc.gridy = 6;
	    gbc.gridwidth = 1;
	    add(post, gbc);
	    
	    // house
	    gbc.gridx = 1;
	    gbc.gridy = 6;
	    add(house, gbc);
	     
	    // error
	    gbc.gridx = 0;
	    gbc.gridy = 7;
	    gbc.gridwidth = 2;
	    gbc.weighty = 0.3;
	    add(error, gbc);
	    
	    // button
	    gbc.gridx = 0;
	    gbc.gridy = 8;
	    gbc.weighty = 1.5;
	    add(button, gbc);

	    //setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setPreferredSize(PANEL_DIMENSION2);
	    setBackground(PANEL_COLOR);
	   
	    setVisible(false);
	    //pack();
	}
	
	/** Invoked when user presses login button. */
	public void tryAdd() {
		try {
			nameV = (String)name.getMyValue();
			phoneV = (String)phone.getMyValue();
			nipV = (String)nip.getMyValue();
			
			cityV = (String)city.getMyValue();
			streetV = (String)street.getMyValue();
			houseV = (String)house.getMyValue();
			postV = (String)post.getMyValue();
			
			System.out.println("name: " + nameV);
			System.out.println("phone: " + phoneV);
			System.out.println("nip: " + nipV);
			System.out.println("city: " + cityV);
			System.out.println("street: " + streetV);
			System.out.println("house: " + houseV);
			System.out.println("post: " + postV);
			
			insertClient(nameV, phoneV, nipV, cityV, streetV, houseV, postV);
			parent.refresh(SEARCH_CLIENTS);
			error.putMessage();
		}
		catch (Exception exception) {
			error.putError();
		}
	}
	
	public static void main(String[] args) {
		AddClientPanel panel = new AddClientPanel(null);
		//panel.tryAdd();
	}

}
