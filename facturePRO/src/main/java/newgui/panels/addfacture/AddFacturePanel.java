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
	ProductsLabel label;
	ProductsSumLabel sumLabel;
	SingleSum singleSum;
	
	public AddFacturePanel(Gui parent) {
		this.parent = parent;
		
		//components
		data = new FactureData(parent);
		products = new FactureProducts(this);
		label = new ProductsLabel();
		sumLabel = new ProductsSumLabel();
		singleSum = new SingleSum();
		
	    // gridBagLayout
	    GridBagLayout layout = new GridBagLayout();
	    GridBagConstraints gbc = new GridBagConstraints();
	    setLayout(layout);
	    
	    //gbc init
	    gbc.weightx = 1;
	    gbc.weighty = 1;
	    gbc.insets = new Insets(3,3,3,3);
	    gbc.fill = GridBagConstraints.BOTH;
	    gbc.anchor = GridBagConstraints.NORTH;
	    
	    // data
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    add(data, gbc);
	    
	    // label
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	    add(label, gbc);
	    
	    // products
	    gbc.gridx = 0;
	    gbc.gridy = 2;
	    add(products, gbc);
	    
	    // sum label
	    gbc.gridx = 0;
	    gbc.gridy = 3;
	    gbc.insets = new Insets(3,3,0,3);
	    add(sumLabel, gbc);
	    
	    // single sum
	    gbc.gridx = 0;
	    gbc.gridy = 4;
	    gbc.insets = new Insets(0,3,3,3);
	    add(singleSum, gbc);
	    
	    
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setBackground(PANEL_COLOR);
	    pack();
	    setVisible(true);
	}
	
	public static void main(String [] args) {
		AddFacturePanel panel = new AddFacturePanel(null);
		//panel.data.setClient("weqweq");
		panel.products.addProduct(newdatabase.connector.TowarConnector.getTowar(13));
		panel.products.addProduct(newdatabase.connector.TowarConnector.getTowar(10));
		panel.products.addProduct(newdatabase.connector.TowarConnector.getTowar(10));
		panel.products.addProduct(newdatabase.connector.TowarConnector.getTowar(10));
		panel.products.addProduct(newdatabase.connector.TowarConnector.getTowar(10));
		panel.pack();
	}
}
