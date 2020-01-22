package newgui.panels.addfacture;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import newdatabase.Towar;
import newgui.Gui;

import static newgui.constants.AreaPanelConstants.*;

public class FactureProducts extends JPanel {

	//parent
	AddFacturePanel parent;
	
	int counter;
	SingleProduct temp;
	ProductsLabel label;
	ArrayList<SingleProduct> products;
	
	//layout
	GridBagLayout layout;
	GridBagConstraints con;
	
	public FactureProducts(AddFacturePanel parent) {
		this.parent = parent;
		label = new ProductsLabel();
		products = new ArrayList<SingleProduct>();
		setBackground(Color.RED);
		counter = 0;
		
		// gridBagLayout
		layout = new GridBagLayout();
		con = new GridBagConstraints();
		setLayout(layout);

		// init
		con.fill = GridBagConstraints.BOTH;
		con.gridy = 0;
		con.gridx = 0;
		con.weightx = 1;
		con.weighty = 0;
		
		add(label, con);
		counter++;
	}
	
	public void addProduct(Towar towar) {
		
		temp = new SingleProduct(towar, this);
		con.gridy = counter;
		temp.setNumber(counter);
		products.add(temp);
		add(temp, con);
		counter++;
		
	}
	
	public void removeProducs(SingleProduct product) {
		remove(product);
		products.remove(product);
		counter = 1;
		
		for(SingleProduct sigProduct : products)
			sigProduct.setNumber(counter++);
		parent.pack();
	}
}
