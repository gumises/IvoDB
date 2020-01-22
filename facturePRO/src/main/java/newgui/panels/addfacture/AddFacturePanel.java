package newgui.panels.addfacture;

import static newgui.constants.AreaPanelConstants.PANEL_COLOR;
import static newgui.constants.AreaPanelConstants.PANEL_DIMENSION;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;

import newgui.Gui;

public class AddFacturePanel extends JFrame {

	//parent
	Gui parent;
	
	//components
	FactureData data;
	FactureProducts products;
	
	public AddFacturePanel(Gui parent) {
		this.parent = parent;
		
		//components
		data = new FactureData(parent);
		products = new FactureProducts(parent);
		
	    // gridBagLayout
	    GridBagLayout layout = new GridBagLayout();
	    GridBagConstraints gbc = new GridBagConstraints();
	    setLayout(layout);
	    
	    //gbc init
	    gbc.weightx = 1;
	    gbc.weighty = 1;
	    gbc.insets = new Insets(3,3,3,3);
	    gbc.fill = GridBagConstraints.BOTH;
	    
	    // data
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    add(data, gbc);
	    
	    // products
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	    add(products, gbc);
	    
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setBackground(PANEL_COLOR);
	    pack();
	    setVisible(true);
	}
	
	public static void main(String [] args) {
		AddFacturePanel panel = new AddFacturePanel(null);
		panel.data.setClient("weqweq");
		panel.pack();
	}
}
