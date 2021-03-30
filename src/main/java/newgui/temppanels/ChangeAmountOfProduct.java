package newgui.temppanels;

import javax.swing.JFrame;
import javax.swing.JPanel;

import newgui.Gui;
import newgui.components.ActionButton;
import newgui.components.ErrorLabel;
import newgui.components.MyLabel;
import newgui.components.MyTextField;

import static newgui.constants.AreaPanelConstants.*;
import static newgui.constants.ButtonsPanelConstants.SEARCH_PRODUCTS;
import static newgui.constants.DataFormats.*;
import static newgui.components.FormatterFactory.getFormat;
import static newdatabase.connector.TowarConnector.*;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class ChangeAmountOfProduct extends JPanel {

	//parent
	Gui parent;
	
	// fields
	MyTextField name;
	MyTextField amount;
	
	// button
	ActionButton add;
	ActionButton remove;
	
	// labels
	MyLabel title;
	ErrorLabel error;
	
	//values
	String nameValue;
	int amountValue;
	
	public ChangeAmountOfProduct(Gui parent) {
		
		this.parent = parent;
		// fields
		name = new MyTextField(getFormat(TEXT), FIELD_FONT, PRODUCT_NAME);
		amount = new MyTextField(getFormat(INTEGER), FIELD_FONT, PRODUCT_AMOUNT);
		
		// label
		error = new ErrorLabel(PRODUCT_CHANGE_MESSAGE, PRODUCT_CHANGE_ERROR1, PRODUCT_CHANGE_ERROR2, ERROR_FONT);
		title = new MyLabel(PRODUCT_CHANGE_TITLE, LABEL_FONT);
		
		//buttons
		add = new ActionButton(BUTTON_ADD, BUTTON_COLOR, BUTTON_FONT);
		add.addActionListener(event -> tryChange(1));
		
		remove = new ActionButton(BUTTON_REMOVE, BUTTON_COLOR, BUTTON_FONT);
		remove.addActionListener(event -> tryChange(-1));
		
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
	    
	    // amount
	    gbc.gridx = 0;
	    gbc.gridy = 2;
	    add(amount, gbc);
	    
	    // error
	    gbc.gridx = 0;
	    gbc.gridy = 3;
	    gbc.gridwidth = 2;
	    gbc.weighty = 0.3;
	    add(error, gbc);
	    
	    // add
	    gbc.gridx = 0;
	    gbc.gridy = 4;
	    gbc.gridwidth = 1;
	    gbc.weighty = 1.2;
	    add(add, gbc);
	    
	    // remove
	    gbc.gridx = 1;
	    gbc.gridy = 4;
	    gbc.weighty = 1.2;
	    add(remove, gbc);
	    
	    //setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    setPreferredSize(PANEL_DIMENSION);
	    setBackground(PANEL_COLOR);
	    //pack();
	    setVisible(false);
	}
	
	/** Invoked when user presses add button. */
	public void tryChange(int multiplier) {
		
		try {
			nameValue = (String)name.getValue();
			amountValue = (Integer)amount.getValue() * multiplier;
			
			changeTowarAmount(nameValue, amountValue);
			error.putMessage();
			parent.refresh(SEARCH_PRODUCTS);
		}
		catch(Exception e) {
			error.putError();
		}
		
	}
	
	public static void main(String[] args) {
	}

}
