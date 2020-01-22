package newgui.panels.addfacture;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import newdatabase.Towar;
import newgui.components.ActionButton;
import newgui.components.MyLabel;
import newgui.components.MyTextField;
import newgui.panels.addfacture.TempProducts.NameField;

import static newgui.components.FormatterFactory.getFormat;
import static newgui.constants.AreaPanelConstants.*;
import static newgui.constants.ButtonsPanelConstants.SEARCH_PRODUCTS;
import static newgui.constants.DataFormats.*;

/** Single product in facture. */
class SingleSum extends JPanel {

	JLabel number;
	JLabel name;
	JLabel amount;
	JLabel nettoPrice;
	JLabel nettoValue;
	MyLabel vat;
	MyLabel vatValue;
	MyLabel bruttoValue;
	JLabel remove;
	
	public SingleSum() {
		super();
		number = new JLabel();
		name = new JLabel();
		amount = new JLabel();
		nettoPrice = new JLabel();
		nettoValue = new MyLabel("RAZEM", PRODUCT_FONT, PRODUCT_COLOR);
		vat = new MyLabel(0.0, PRODUCT_FONT, PRODUCT_COLOR);
		vatValue = new MyLabel(0.0, PRODUCT_FONT, PRODUCT_COLOR);
		bruttoValue = new MyLabel(0.0, PRODUCT_FONT, PRODUCT_COLOR);
		remove = new JLabel();
		setLayout(new GridLayout(1,0));

		add(number);
		add(name);
		add(amount);
		add(nettoPrice);
		add(nettoValue);
		add(vat);
		add(vatValue);
		add(bruttoValue);
		add(remove);
		setVisible(true);
		
		setPreferredSize(ADD_FACTURE_LABEL);
	}
	
	public void setValues(double [] values) {
		vat.setValue(values[0]);
		vatValue.setValue(values[0]);
		bruttoValue.setValue(values[0]);
	}
}
