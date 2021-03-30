package newgui.panels.addfacture;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import newdatabase.Towar;
import newgui.components.MyLabel;

import static newgui.constants.AreaPanelConstants.*;

/** Products labels in products panel. */
class ProductsSumLabel extends JPanel {

	JLabel number;
	JLabel name;
	JLabel amount;
	JLabel nettoPrice;
	MyLabel nettoValue;
	MyLabel vat;
	MyLabel vatValue;
	MyLabel bruttoValue;
	JLabel remove;

	public ProductsSumLabel() {
		super();
		number = new JLabel();
		name = new JLabel();
		amount = new JLabel();
		nettoPrice = new JLabel();
		nettoValue = new MyLabel("podsumowanie", PRODUCT_LABEL_FONT, PRODUCT_LABEL_COLOR);
		vat = new MyLabel("wartosc netto", PRODUCT_LABEL_FONT, PRODUCT_LABEL_COLOR);
		vatValue = new MyLabel("wartosc vat", PRODUCT_LABEL_FONT, PRODUCT_LABEL_COLOR);
		bruttoValue = new MyLabel("wartosc brutto", PRODUCT_LABEL_FONT, PRODUCT_LABEL_COLOR);
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
		
		setPreferredSize(ADD_FACTURE_LABEL);
		setVisible(true);
	}
}
