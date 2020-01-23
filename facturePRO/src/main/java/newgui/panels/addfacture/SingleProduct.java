package newgui.panels.addfacture;

import newdatabase.Towar;
import newgui.components.ActionButton;
import newgui.components.MyLabel;
import newgui.components.MyTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import static newgui.components.FormatterFactory.getFormat;
import static newgui.constants.AreaPanelConstants.*;
import static newgui.constants.DataFormats.INTEGER;

/** Single product in facture. */
class SingleProduct extends JPanel {

	MyLabel number;
	MyLabel name;
	MyTextField amount;
	MyLabel nettoPrice;
	MyLabel nettoValue;
	MyLabel vat;
	MyLabel vatValue;
	MyLabel bruttoValue;
	
	Towar towar;
	ActionButton remove;
	
	FactureProducts parent;
	
	public SingleProduct(Towar towar, FactureProducts parent) {
		super();
		this.parent = parent;
		this.towar = towar;
		number = new MyLabel("", PRODUCT_FONT, PRODUCT_COLOR);
		name = new MyLabel(towar.getNazwa(), PRODUCT_FONT, PRODUCT_COLOR);
		amount = new MyTextField(getFormat(INTEGER), FIELD_FONT, "0");
		nettoPrice = new MyLabel(towar.getCena(), PRODUCT_FONT, PRODUCT_COLOR);
		nettoValue = new MyLabel(0.00, PRODUCT_FONT, PRODUCT_COLOR);
		vat = new MyLabel(towar.getVat().getMnoznik(), PRODUCT_FONT, PRODUCT_COLOR);
		vatValue = new MyLabel(0.00, PRODUCT_FONT, PRODUCT_COLOR);
		bruttoValue = new MyLabel(0.00, PRODUCT_FONT, PRODUCT_COLOR);

		remove = new ActionButton("-", REMOVE_PRODUCT_COLOR, REMOVE_PRODUCT_FONT);
		remove.addActionListener(event -> parent.removeProducs(this));
		
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
		setVisible(true);
		
		amount.addFocusListener(new FocusAdapter() {

			@Override
			public void focusLost(FocusEvent arg0) {
				if(amount.getMyValue() == null)
					amount.setValue(0);
				setValues();
			}
		});
		
		setPreferredSize(ADD_FACTURE_LABEL);
	}
	
	public void setNumber(int newNumber) {
		number.setText(Integer.toString(newNumber));
	}
	
	public void setValues() {
		System.out.println("setting");
		Integer amountt = (Integer)amount.getValue();
		
		if(amountt == null) {
			nettoValue.setValue(0);
			vatValue.setValue(0);
			bruttoValue.setValue(0);
			parent.setValues();
			return;
		}
		
		Double vatt = (double)towar.getVat().getMnoznik()/100;
		Double pricee = towar.getCena();
			
		nettoValue.setValue(pricee * amountt);
		vatValue.setValue(pricee * amountt * vatt);
		bruttoValue.setValue(pricee * amountt * (1 + vatt));
		
		parent.setValues();
	}
	
	public double[] getValues() {
		
		return new double[] {
				nettoValue.getValue(),
				vatValue.getValue(),
				bruttoValue.getValue()
		};
	}
	
	public TowarData getTowarData() {
		return new TowarData(towar.getId(), (int)amount.getValue());
	}
}
