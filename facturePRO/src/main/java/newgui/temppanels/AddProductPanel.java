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

import static newdatabase.connector.TowarConnector.*;
import static newdatabase.connector.VatConnector.*;
import static newgui.constants.ButtonsPanelConstants.SEARCH_PRODUCTS;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class AddProductPanel extends JPanel {

	//parent
	Gui parent;
	
	// fields
	MyTextField name;
	MyTextField price;
	MyTextField vat;
	
	// button
	ActionButton button;
	
	// labels
	MyLabel title;
	ErrorLabel error;
	
	//values
	String nameValue;
	double priceValue;
	int vatValue;
	
	public AddProductPanel(Gui parent) {
		
		this.parent = parent;
		
		// fields
		name = new MyTextField(getFormat(TEXT), FIELD_FONT, PRODUCT_NAME);
		price = new MyTextField(getFormat(FLOAT), FIELD_FONT, PRODUCT_PRICE);
		vat = new MyTextField(getFormat(INTEGER), FIELD_FONT, PRODUCT_VAT);
		
		// label
		error = new ErrorLabel(PRODUCT_MESSAGE, PRODUCT_ERROR, ERROR_FONT);
		title = new MyLabel(PRODUCT_TITLE, LABEL_FONT);
		
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
	    
	    //title
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.gridwidth = 2;
	    add(title, gbc);
	    
	    // name
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	    add(name, gbc);
	    
	    // price
	    gbc.gridx = 0;
	    gbc.gridy = 2;
	    gbc.gridwidth = 1;
	    add(price, gbc);
	    
	    // vat
	    gbc.gridx = 1;
	    gbc.gridy = 2;
	    add(vat, gbc);
	    
	    // error
	    gbc.gridx = 0;
	    gbc.gridy = 3;
	    gbc.gridwidth = 2;
	    gbc.weighty = 0.3;
	    add(error, gbc);
	    
	    // button
	    gbc.gridx = 0;
	    gbc.gridy = 4;
	    gbc.gridwidth = 2;
	    gbc.weighty = 1.2;
	    add(button, gbc);
	    
	    //setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    setPreferredSize(PANEL_DIMENSION);
	    setBackground(PANEL_COLOR);
	    //pack();
	    setVisible(false);
	}
	
	/** Invoked when user presses login button. */
	public void tryAdd() {
		try {
			nameValue = (String)name.getValue();
			priceValue = (Double)price.getValue();
			vatValue = (Integer)vat.getValue();
			
			insertTowar(getVat(vatValue), nameValue, priceValue);
			error.putMessage();
			parent.refresh(SEARCH_PRODUCTS);
		}
		catch (Exception exception) {
			error.putError();
		}
	}
	
	public static void main(String[] args) {
		AddProductPanel panel = new AddProductPanel(null);
		panel.tryAdd();
	}

}
