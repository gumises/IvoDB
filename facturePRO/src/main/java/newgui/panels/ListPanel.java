package newgui.panels;

import javax.swing.JPanel;

import newgui.panels.productssearcher.ProductsList;
import newgui.panels.productssearcher.ProductsSearcherPanel;

import static newgui.constants.ListPanelConstants.*;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class ListPanel extends JPanel {

	public	//temporary panels
	ProductsSearcherPanel productsSearcherPanel;
	GridBagConstraints gbc;
	
	
	public ListPanel() {
		
		//temporary panels
		productsSearcherPanel = new ProductsSearcherPanel();
		
	    // gridBagLayout
	    GridBagLayout layout = new GridBagLayout();
	    gbc = new GridBagConstraints();
	    setLayout(layout);

	    //gbc init
	    gbc.weightx = 1;
	    gbc.weighty = 1;
	    gbc.fill = GridBagConstraints.BOTH;
	    
		setVisible(true);
		setPreferredSize(PANEL_DIMENSION);
		setBackground(PANEL_COLOR);
	}
	
	/** Sets the add product panel to be visible. */
	public void initProductsSearcherPanel() {
		removeAll();
		add(productsSearcherPanel, gbc);
	}
	
	/** Refreshes screens and lists. */
	public void refresh() {
		productsSearcherPanel.refresh();
	}
}
