package newgui.panels;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import newgui.components.ActionButton;
import static newgui.constants.ButtonsPanelConstants.*;
import static newgui.constants.AccessLevels.*;

public class ButtonsPanel extends JPanel {

	// temp button
	ActionButton tempButton;
	
	//list of buttons
	ArrayList<ActionButton> actionButtons;
	
	/** Constructor. */
	public ButtonsPanel() {

		actionButtons = new ArrayList<ActionButton>();
		
		// search Products
		tempButton = new ActionButton(SEARCH_PRODUCTS, VISITOR, PRODUCT);
		tempButton.addActionListener(event -> buttonPressed(SEARCH_PRODUCTS));
		actionButtons.add(tempButton);
		
		// add Product
		tempButton = new ActionButton(ADD_PRODUCT, WORKER, PRODUCT);
		tempButton.addActionListener(event -> buttonPressed(ADD_PRODUCT));
		actionButtons.add(tempButton);
		
		// remove Product
		tempButton = new ActionButton(REMOVE_PRODUCT, WORKER, PRODUCT);
		tempButton.addActionListener(event -> buttonPressed(REMOVE_PRODUCT));
		actionButtons.add(tempButton);
		
		// change amount of Products
		tempButton = new ActionButton(CHANGE_AMOUNT, WORKER, PRODUCT);
		tempButton.addActionListener(event -> buttonPressed(CHANGE_AMOUNT));
		actionButtons.add(tempButton);
		
		// search Invoices
		tempButton = new ActionButton(SEARCH_INVOICES, WORKER, INVOICE);
		tempButton.addActionListener(event -> buttonPressed(SEARCH_INVOICES));
		actionButtons.add(tempButton);
		
		// add Invoice
		tempButton = new ActionButton(ADD_INVOICE, WORKER, INVOICE);
		tempButton.addActionListener(event -> buttonPressed(ADD_INVOICE));
		actionButtons.add(tempButton);
		
		// search Clients
		tempButton = new ActionButton(SEARCH_CLIENTS, WORKER, CLIENT);
		tempButton.addActionListener(event -> buttonPressed(SEARCH_CLIENTS));
		actionButtons.add(tempButton);
		
		// add Client
		tempButton = new ActionButton(ADD_CLIENT, WORKER, CLIENT);
		tempButton.addActionListener(event -> buttonPressed(ADD_CLIENT));
		actionButtons.add(tempButton);
		
		// make Backup
		tempButton = new ActionButton(MAKE_BAKCUP, ADMIN, OTHER);
		tempButton.addActionListener(event -> buttonPressed(MAKE_BAKCUP));
		actionButtons.add(tempButton);
			
		// load Backup
		tempButton = new ActionButton(LOAD_BACKUP, ADMIN, OTHER);
		tempButton.addActionListener(event -> buttonPressed(LOAD_BACKUP));
		actionButtons.add(tempButton);
		
		// dynamic Query
		tempButton = new ActionButton(DYNAMIC_QUERY, ADMIN, OTHER);
		tempButton.addActionListener(event -> buttonPressed(DYNAMIC_QUERY));
		actionButtons.add(tempButton);
		
		// log In
		tempButton = new ActionButton(LOG_IN, VISITOR, OTHER);
		tempButton.addActionListener(event -> buttonPressed(LOG_IN));
		actionButtons.add(tempButton);
		
		setLayout(new GridLayout(1, 0));
		for(ActionButton button: actionButtons)
			add(button);
		
		
		setPreferredSize(PANEL_DIMENSION);
		//pack();
		setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	/** Invoked when action button is pressed, must be override by parent. */
	public void buttonPressed(String button) {
		System.out.println("Button pressed: " + button);
	}
	
	/** Changes the access. */
	public void changeAccess(int access) {
		for(ActionButton button: actionButtons)
			button.changeAccess(access);
	}

	public static void main(String[] args) {
		ButtonsPanel buttonsPanel = new ButtonsPanel();
		buttonsPanel.changeAccess(VISITOR);
	}
}
