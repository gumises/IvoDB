package newgui.panels.productssearcher;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;

import static newgui.constants.ListPanelConstants.*;

/** Prints list of products. */
public class ProductsSearcherPanel extends JPanel {
	
	ProductsSearcher searcher;
	ProductsList list;
	
	public ProductsSearcherPanel() {
		
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
	
	/** Refreshes screens and lists. */
	public void refresh() {
		list.refresh();
	}
	
	public static void main(String [] args) {
		new ProductsSearcherPanel();
	}
}
