package newgui.panels.fakturaSercher;

import newgui.Gui;

import javax.swing.*;
import java.awt.*;

import static newgui.constants.ListPanelConstants.PANEL_COLOR;

/** Prints list of products. */
public class FakturaSearcherPanel extends JPanel {

	//parent
	Gui parent;


	FakturaList list;

	public FakturaSearcherPanel(Gui parent) {
		this.parent = parent;
		refresh();
	}
	
	/** Refreshes screens and lists. */
	public void refresh() {
		removeAll();

		list = new FakturaList(parent);
		
	    // gridBagLayout
	    GridBagLayout layout = new GridBagLayout();
	    GridBagConstraints gbc = new GridBagConstraints();
	    setLayout(layout);
	    
	    //gbc init
	    gbc.weightx = 1;
	    gbc.weighty = 1;
	    gbc.fill = GridBagConstraints.BOTH;

	    
	    // list
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	    gbc.weighty = 1;
	    add(list, gbc);
	    
	    //setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setBackground(PANEL_COLOR);
	    //setPreferredSize(PANEL_DIMENSION);
	    //pack();
	    setVisible(true);
	}
	
	public static void main(String [] args) {
		new FakturaSearcherPanel(null);
	}
}
