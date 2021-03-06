package newgui.panels.productssearcher;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;

import newgui.Gui;

import static newgui.constants.ListPanelConstants.*;

/** Prints list of products. */
public class ProductsSearcherPanel extends JPanel {
	
	//parent
	Gui parent;
	
	ProductsSearcher searcher;
	ProductsList list;
	
	public ProductsSearcherPanel(Gui parent) {
		this.parent = parent;
		refresh();
	}
	
	/** Refreshes screens and lists. */
	public void refresh() {
		removeAll();
		searcher = new ProductsSearcher(this);
		list = new ProductsList(parent);
		
	    // gridBagLayout
	    GridBagLayout layout = new GridBagLayout();
	    GridBagConstraints gbc = new GridBagConstraints();
	    setLayout(layout);
	    
	    //gbc init
	    gbc.weightx = 1;
	    gbc.weighty = 1;
	    gbc.fill = GridBagConstraints.BOTH;
	    
	    // searcher
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.weighty = 0.15;
	    add(searcher, gbc);
	    
	    // list
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	    gbc.weighty = 1;
	    add(list, gbc);
	    
	    //setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    setBackground(PANEL_COLOR);
	    //setPreferredSize(PANEL_DIMENSION);
	    //pack();
	    setVisible(true);
	}
	
	public static void main(String [] args) {
		new ProductsSearcherPanel(null);
	}
}
