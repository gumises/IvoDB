package newgui.panels;

import newgui.Gui;
import newgui.panels.clientssearcher.ClientsSearcherPanel;
import newgui.panels.fakturaSercher.FakturaSearcherPanel;
import newgui.panels.productssearcher.ProductsSearcherPanel;

import javax.swing.*;
import java.awt.*;

import static newgui.constants.ListPanelConstants.PANEL_COLOR;
import static newgui.constants.ListPanelConstants.PANEL_DIMENSION;

public class ListPanel extends JPanel {

	//parent
	Gui parent;
	
	//temporary panels
	ProductsSearcherPanel productsSearcherPanel;
	ClientsSearcherPanel clientsSearcherPanel;
	FakturaSearcherPanel fakturaSearcherPanel;
	GridBagConstraints gbc;
	
	
	public ListPanel(Gui parent) {
		
		this.parent = parent;
		
		//temporary panels
		productsSearcherPanel = new ProductsSearcherPanel(parent);
		clientsSearcherPanel = new ClientsSearcherPanel(parent);
		fakturaSearcherPanel = new FakturaSearcherPanel(parent);
		
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
	
	/** Sets the add product panel to be visible. */
	public void initClientsSearcherPanel() {
		removeAll();
		clientsSearcherPanel.refresh();
		add(clientsSearcherPanel, gbc);
	}
	public void initFakturaSearcherPanel() {
		removeAll();

		fakturaSearcherPanel.refresh();
		add(fakturaSearcherPanel, gbc);
	}
	
	/** Refreshes screens and lists. */
	public void refresh() {
		productsSearcherPanel.refresh();
	}
}
