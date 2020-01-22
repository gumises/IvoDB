package newgui.panels;

import javax.swing.JPanel;

import newgui.Gui;
import newgui.panels.productssearcher.ProductsList;
import newgui.panels.productssearcher.ProductsSearcherPanel;

import static newgui.constants.ListPanelConstants.*;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class ListPanel extends JPanel {

	//parent
	Gui parent;
	
	public	//temporary panels
	ProductsSearcherPanel productsSearcherPanel;
	GridBagConstraints gbc;
	
	
	public ListPanel(Gui parent) {
		
		this.parent = parent;
		
		//temporary panels
		productsSearcherPanel = new ProductsSearcherPanel(parent);
		
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
		productsSearcherPanel.refresh();
		add(productsSearcherPanel, gbc);
	}
	
	/** Refreshes screens and lists. */
	public void refresh() {
		productsSearcherPanel.refresh();
	}
}
