package newgui.panels.products;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;

import static newgui.constants.ListPanelConstants.*;

/** Prints list of products. */
public class ProductsPanel extends JFrame {
	
	ProductsSearcher searcher;
	ProductsList list;
	
	public ProductsPanel() {
		
		searcher = new ProductsSearcher();
		list = new ProductsList();
		
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
	    add(searcher, gbc);
	    
	    // list
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	    add(list, gbc);
	    
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    setBackground(PANEL_COLOR);
	    pack();
	    setVisible(true);
	}
	
	public static void main(String [] args) {
		new ProductsPanel();
	}
}
