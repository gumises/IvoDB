package newgui.panels.productssearcher;

import javax.swing.JFrame;
import javax.swing.JPanel;
import newgui.components.ActionButton;
import newgui.components.MyTextField;

import static newgui.components.FormatterFactory.getFormat;
import static newgui.constants.ListPanelConstants.*;
import static newgui.constants.DataFormats.*;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class ProductsSearcher extends JPanel {

	//parent
	ProductsSearcherPanel parent;
	
	// fields
	MyTextField name;
	MyTextField maxPrice;
	MyTextField minPrice;
	MyTextField minAmount;
	
	// button
	ActionButton search;
	
	public ProductsSearcher(ProductsSearcherPanel parent) {
		
		this.parent = parent;
		
		// fields
		name = new MyTextField(getFormat(TEXT), FIELD_FONT, NAME_TEXT);
		maxPrice = new MyTextField(getFormat(FLOAT), FIELD_FONT, MAXPRICE_TEXT);
		minPrice = new MyTextField(getFormat(FLOAT), FIELD_FONT, MINPRICE_TEXT);
		minAmount = new MyTextField(getFormat(INTEGER), FIELD_FONT, MINWAREHOUSE_TEXT);
		
		//button
		search = new ActionButton(SEARCH_TEXT, SEARCH_COLOR, BUTTON_FONT);
		search.addActionListener(event -> search());
		
	    // gridBagLayout
	    GridBagLayout layout = new GridBagLayout();
	    GridBagConstraints gbc = new GridBagConstraints();
	    setLayout(layout);
	    
	    //gbc init
	    gbc.weightx = 1;
	    gbc.weighty = 1;
	    gbc.insets = new Insets(6,3,3,3);
	    gbc.fill = GridBagConstraints.BOTH;
	    
	    // name
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.gridwidth = 3;
	    add(name, gbc);
	    
	    // min price
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	    gbc.gridwidth = 1;
	    gbc.insets = new Insets(3,3,3,3);
	    add(minPrice, gbc);
	    
	    // max price
	    gbc.gridx = 1;
	    gbc.gridy = 1;
	    add(maxPrice, gbc);
	    
	    // max warehouse
	    gbc.gridx = 2;
	    gbc.gridy = 1;
	    add(minAmount, gbc);
	    
	    // search
	    gbc.gridx = 0;
	    gbc.gridy = 2;
	    gbc.gridwidth = 3;
	    gbc.weighty = 1.2;
	    add(search, gbc);
	    
	    //setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    setBackground(PANEL_COLOR);
	    //pack();
	    setVisible(true);
	}
	
	/** Sets dialog visible. */
	public void init() {
		setVisible(true);
		//pack();
	}
	
	/** Invoked when run button is pressed. */
	public void search() {
		try {
			String nameValue = (String)name.getMyValue();
			Double maxPriceValue =  (Double)maxPrice.getMyValue();
			Double minPriceValue = (Double)minPrice.getMyValue();
			Integer minAmountValue = (Integer)minAmount.getMyValue();
			
			System.out.println("name      = " + nameValue);
			System.out.println("minPrice  = " + minPriceValue);
			System.out.println("maxPrice  = " + maxPriceValue);
			System.out.println("minAmount = " + minAmountValue);
			
			parent.list.refresh(nameValue, maxPriceValue, minPriceValue, minAmountValue);
			parent.parent.pack();
			
		}
		catch(Exception exception) {
			exception.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ProductsSearcher(null);
	}

}
