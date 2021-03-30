package newgui.panels.addfacture;

import newdatabase.Faktura;
import newdatabase.Kategoria;
import newdatabase.Nabywca;
import newdatabase.Towar;
import newgui.Gui;
import newgui.components.ActionButton;
import newgui.components.MyTextField;

import javax.swing.*;
import java.awt.*;

import static newdatabase.connector.FactureConnector.insertFacture;
import static newgui.components.FormatterFactory.getFormat;
import static newgui.constants.AreaPanelConstants.*;
import static newgui.constants.DataFormats.TEXT;
import static newgui.constants.ListPanelConstants.FIELD_FONT;

public class AddFacturePanel extends JPanel {

	//parent
	Gui parent;
	Nabywca nabywca;
	
	//components
	MyTextField number;
	FactureData data;
	FactureProducts products;
	ProductsLabel label;
	ProductsSumLabel sumLabel;
	SingleSum singleSum;
	ActionButton button;
	JScrollPane pane;
	
	public AddFacturePanel(Gui parent) {
		this.parent = parent;
		nabywca = null;
		refresh();
	}
	
	public void refresh() {
		removeAll();
		//components
		number = new MyTextField(getFormat(TEXT), FIELD_FONT, "numer:");
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
		button.addActionListener(event -> tryAddFacture());
		
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
	    
	    // number
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    add(number, gbc);
	    
	    // data
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	    add(data, gbc);
	    
	    // label
	    gbc.gridx = 0;
	    gbc.gridy = 2;
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
	    gbc.gridy = 3;
	    add(pane, gbc);
	    
	    // sum label
	    gbc.gridx = 0;
	    gbc.gridy = 4;
	    gbc.insets = new Insets(3,3,0,3);
	    add(sumLabel, gbc);
	    
	    // single sum
	    gbc.gridx = 0;
	    gbc.gridy = 5;
	    gbc.insets = new Insets(0,3,3,3);
	    add(singleSum, gbc);
	    
	    // button
	    gbc.gridx = 0;
	    gbc.gridy = 6;
	    gbc.fill = GridBagConstraints.VERTICAL;
	    gbc.insets = new Insets(3,3,3,3);
	    add(button, gbc);
	    
	    
	    //setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setBackground(PANEL_COLOR);
	    //pack();
	    setVisible(false);
	}
	
	public void addProduct(Towar towar) {
		products.addProduct(towar);
		repaint();
	}
	
	public void addNabywca(Nabywca nabywca) {
		data.setClient(nabywca);
		this.nabywca = nabywca;
		repaint();
	}
	
	public void tryAddFacture() {
		try {
			insertFacture(nabywca, (String)number.getValue(), products.getTowarsData());
		}
		catch(Exception exception) {
			System.out.println("Something went wrong!");
		}
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
		//panel.pack();
	}

	public void display(Faktura faktura) {
		removeAll();

		//components
		number = new MyTextField(getFormat(TEXT), FIELD_FONT, faktura.getNumer());
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

		// number
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(number, gbc);

		// data
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(data, gbc);

		// label
		gbc.gridx = 0;
		gbc.gridy = 2;
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
		gbc.gridy = 3;
		add(pane, gbc);

		// sum label
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.insets = new Insets(3,3,0,3);
		add(sumLabel, gbc);

		// single sum
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.insets = new Insets(0,3,3,3);
		add(singleSum, gbc);



		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBackground(PANEL_COLOR);
		//pack();
		setVisible(false);
	}

	public void addProduct(Kategoria kategoria) {
		products.addProduct(kategoria.getTowar(),kategoria.getId().getIlosc());
		repaint();
	}
}
