package newgui.panels.addfacture;

import newdatabase.Towar;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class FactureProducts extends JPanel {

	//parent
	AddFacturePanel parent;
	
	int counter;
	SingleProduct temp;
	ArrayList<SingleProduct> products;
	
	//layout
	GridBagLayout layout;
	GridBagConstraints con;
	
	public FactureProducts(AddFacturePanel parent) {
		this.parent = parent;
		products = new ArrayList<SingleProduct>();
		setBackground(Color.DARK_GRAY);
		//setMaximumSize(new Dimension(100,100));
		counter = 0;
		
		// gridBagLayout
		layout = new GridBagLayout();
		con = new GridBagConstraints();
		setLayout(layout);

		// init
		con.fill = GridBagConstraints.HORIZONTAL;
		con.gridy = 0;
		con.gridx = 0;
		con.weightx = 1;
		con.weighty = 0;
		con.anchor = GridBagConstraints.NORTH;
		
	}
	
	public void addProduct(Towar towar) {
		
		temp = new SingleProduct(towar, this);
		con.gridy = counter;
		temp.setNumber(counter+1);
		products.add(temp);
		add(temp, con);
		counter++;
		setValues();
		
	}
	
	public void removeProducs(SingleProduct product) {
		remove(product);
		products.remove(product);
		counter = 1;
		
		for(SingleProduct sigProduct : products)
			sigProduct.setNumber(counter++);
		setValues();
		//parent.pack();
	}
	
	public void setValues() {
		double values[] = {0.0, 0.0, 0.0};
		double tempValues[];
		for(SingleProduct sigProduct : products) {
			tempValues = sigProduct.getValues();
			values[0] += tempValues[0];
			values[1] += tempValues[1];
			values[2] += tempValues[2];
		}
		parent.singleSum.setValues(values);
	}
	
	public List<TowarData> getTowarsData() {
		List<TowarData> towarsData = new ArrayList<TowarData>();
		for(SingleProduct product : products)
			towarsData.add(product.getTowarData());
		return towarsData;
	}

    public void addProduct(Towar towar, int ilosc) {
		temp = new SingleProduct(towar, this,ilosc);
		con.gridy = counter;
		temp.setNumber(counter+1);
		products.add(temp);
		add(temp, con);
		counter++;
		setValues();
    }
}
