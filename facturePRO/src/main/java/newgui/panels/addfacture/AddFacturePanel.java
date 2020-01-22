package newgui.panels.addfacture;

import static newgui.constants.AreaPanelConstants.*;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.ScrollPaneLayout;

import newgui.Gui;
import newgui.components.ActionButton;

public class AddFacturePanel extends JFrame {

	//parent
	Gui parent;
	
	//components
	FactureData data;
	FactureProducts products;
	ProductsLabel label;
	ProductsSumLabel sumLabel;
	SingleSum singleSum;
	ActionButton button;
	JScrollPane pane;
	
	public AddFacturePanel(Gui parent) {
		this.parent = parent;
		
		//components
		data = new FactureData(parent);
		products = new FactureProducts(this);
		label = new ProductsLabel();
		sumLabel = new ProductsSumLabel();
		singleSum = new SingleSum();
		button = new ActionButton(
				ADD_FACTURE_BUTTON_TEXT, 
				ADD_FACTURE_BUTTON_COLOR, 
				ADD_FACTURE_BUTTON_FONT, 
				ADD_FACTURE_BUTTON_DIMENSION);
		
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
	    pane = new JScrollPane(products);
	    pane.setLayout(new ScrollPaneLayout());
	    pane.setPreferredSize(ADD_FACTURE_PRODUCTS);
	    //pane.setAlignmentY(pane.TOP_ALIGNMENT);
	    //pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	    pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    gbc.anchor = GridBagConstraints.NORTH;
	    gbc.gridx = 0;
	    gbc.gridy = 2;
	    add(pane, gbc);
	    
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
	    
	    // button
	    gbc.gridx = 0;
	    gbc.gridy = 5;
	    gbc.fill = GridBagConstraints.VERTICAL;
	    gbc.insets = new Insets(3,3,3,3);
	    add(button, gbc);
	    
	    
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
		panel.products.addProduct(newdatabase.connector.TowarConnector.getTowar(13));
		panel.products.addProduct(newdatabase.connector.TowarConnector.getTowar(10));
		panel.products.addProduct(newdatabase.connector.TowarConnector.getTowar(10));
		panel.products.addProduct(newdatabase.connector.TowarConnector.getTowar(10));
		panel.products.addProduct(newdatabase.connector.TowarConnector.getTowar(10));
		panel.products.addProduct(newdatabase.connector.TowarConnector.getTowar(13));
		panel.products.addProduct(newdatabase.connector.TowarConnector.getTowar(10));
		panel.products.addProduct(newdatabase.connector.TowarConnector.getTowar(10));
		panel.products.addProduct(newdatabase.connector.TowarConnector.getTowar(10));
		panel.products.addProduct(newdatabase.connector.TowarConnector.getTowar(10));
		panel.pack();
	}
}
