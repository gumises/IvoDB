package newgui.panels.addfacture;

import java.awt.GridLayout;

import javax.swing.JPanel;

import newdatabase.Towar;
import newgui.components.MyLabel;

import static newgui.constants.AreaPanelConstants.*;

/** Products labels in products panel. */
class ProductsLabel extends JPanel {

	MyLabel number;
	MyLabel name;
	MyLabel amount;
	MyLabel nettoPrice;
	MyLabel nettoValue;
	MyLabel vat;
	MyLabel vatValue;
	MyLabel bruttoValue;
	MyLabel remove;

	public ProductsLabel() {
		super();
		number = new MyLabel("l.p.", PRODUCT_LABEL_FONT, PRODUCT_LABEL_COLOR);
		name = new MyLabel("nazwa", PRODUCT_LABEL_FONT, PRODUCT_LABEL_COLOR);
		amount = new MyLabel("liczba", PRODUCT_LABEL_FONT, PRODUCT_LABEL_COLOR);
		nettoPrice = new MyLabel("cena netto", PRODUCT_LABEL_FONT, PRODUCT_LABEL_COLOR);
		nettoValue = new MyLabel("wartosc netto", PRODUCT_LABEL_FONT, PRODUCT_LABEL_COLOR);
		vat = new MyLabel("stawka vat %", PRODUCT_LABEL_FONT, PRODUCT_LABEL_COLOR);
		vatValue = new MyLabel("wartosc vat", PRODUCT_LABEL_FONT, PRODUCT_LABEL_COLOR);
		bruttoValue = new MyLabel("wartosc brutto", PRODUCT_LABEL_FONT, PRODUCT_LABEL_COLOR);
		remove = new MyLabel("usun", PRODUCT_LABEL_FONT, PRODUCT_LABEL_COLOR);
		
		setLayout(new GridLayout(1,0));

		add(number);
		add(name);
		add(amount);
		add(nettoPrice);
		add(vat);
		add(nettoValue);
		add(vatValue);
		add(bruttoValue);
		add(remove);
		
		setPreferredSize(ADD_FACTURE_LABEL);
		setVisible(true);
	}
}
