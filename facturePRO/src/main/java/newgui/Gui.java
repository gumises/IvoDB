package newgui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

import newgui.dialogs.LoginDialog;
import newgui.panels.AreaPanel;
import newgui.panels.ButtonsPanel;
import newgui.panels.ListPanel;

import static newgui.constants.ButtonsPanelConstants.*;

public class Gui extends JFrame {

	// panels
	ButtonsPanel buttonsPanel;
	ListPanel listPanel;
	AreaPanel areaPanel;
	
	//dialogs
	LoginDialog loginDialog;
	
	public Gui() {

		//panels
		buttonsPanel = new ButtonsPanel() {
			@Override
			public void buttonPressed(String button) {
				actionButtonPressed(button);
			}
		};
		
		listPanel = new ListPanel();
		
		areaPanel = new AreaPanel();
		
		
		//dialogs
		loginDialog = new LoginDialog();
		
	    // gridBagLayout
	    GridBagLayout layout = new GridBagLayout();
	    GridBagConstraints gbc = new GridBagConstraints();
	    setLayout(layout);

	    //gbc init
	    gbc.weightx = 1;
	    gbc.weighty = 1;
	    gbc.fill = GridBagConstraints.BOTH;
	    
	    // buttons panel
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.weighty = 0;
	    gbc.gridwidth = 2;
	    add(buttonsPanel, gbc);

	    // list panel
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	    gbc.weightx = 0;
	    gbc.weighty = 1;
	    gbc.gridwidth = 1;
	    add(listPanel, gbc);
	    
	    // area panel
	    gbc.gridx = 1;
	    gbc.gridy = 1;
	    add(areaPanel, gbc);
	    
	    pack();
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setTitle("IvoDB");
	    setVisible(true);
	}
	
	/** Invoked when action button is pressed. */
	public void actionButtonPressed(String action) {
		switch(action) {
		case SEARCH_PRODUCTS:
			listPanel.initProductsSearcherPanel();
			break;
		case ADD_PRODUCT:
			areaPanel.initAddProductPanel();
			break;
		case REMOVE_PRODUCT:
			areaPanel.initRemoveProductPanel();
			break;
		case CHANGE_AMOUNT:
			areaPanel.initChangeAmountOfProductPanel();
			break;
		case LOG_IN:
			initLoginDialog();
			break;
		}
		pack();
	}
	
	/** Invokes login dialog. */
	public void initLoginDialog() {
		loginDialog.setLocationRelativeTo(this);
		loginDialog.init();
	}

	public static void main(String[] args) {
		//TODO delete main method
		new Gui();
	}
}
