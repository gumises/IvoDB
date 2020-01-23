package newgui.panels.productssearcher;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import newdatabase.Towar;
import newgui.Gui;

import static newgui.constants.ListPanelConstants.*;
import static newdatabase.connector.TowarConnector.*;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;
import java.util.Vector;


public class ProductsList extends JPanel {

	List<Towar> towars;
	Gui parent;
	String lastChoice;
	
	public ProductsList(Gui parent) {
		this.parent = parent;
		lastChoice = null;
 		refresh(null, null, null, null);
	}
	
	/** Refreshes screens and lists. */
	public void refresh(String name, Double maxPrice, Double minPrice, Integer minAmount) {
		this.removeAll();
 		JTable table = new JTable(prepareTableModel(name, maxPrice, minPrice, minAmount));
 		
 		//table.setPreferredScrollableViewportSize(TABLE_DIMENSION);
 		table.setAutoCreateRowSorter(true);
 		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
 		table.setRowHeight(ROW_HEIGHT);
 		table.setFont(TABLE_FONT);
 		//table.getTableHeader().setPreferredSize(HEADER_DIMENSION);
 		table.getTableHeader().setFont(HEADER_FONT);
 		
		//Create the scroll pane and add the table to it.
		JScrollPane scrollPane = new JScrollPane(table);
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	        	try {
	        		selectRow(table.getValueAt(table.getSelectedRow(), 0).toString());
	        	} catch(Exception e) {}
	        }
	    });
		
	    // gridBagLayout
	    GridBagLayout layout = new GridBagLayout();
	    GridBagConstraints gbc = new GridBagConstraints();
	    setLayout(layout);

	    //gbc init
	    gbc.weightx = 1;
	    gbc.weighty = 1;
	    gbc.fill = GridBagConstraints.BOTH;
	    
		//Add the scroll pane to this panel.
		add(scrollPane, gbc);
		
		setVisible(true);
		setBackground(LIST_COLOR);
	}
	
	/** Returns filled table model. */
	public DefaultTableModel prepareTableModel(String name, Double maxPrice, Double minPrice, Integer minAmount) {
		System.out.println("refreshing!");
		DefaultTableModel model = new DefaultTableModel(COLUMN_NAMES, 0);
        towars = getTowars(name, maxPrice, minPrice, minAmount);
        for(Towar towar: towars)
        	System.out.println(towar);
        System.out.println(towars.size());
        for(Towar towar: towars)
        	model.addRow(new Object[]{
        			towar.getNazwa(), 
        			towar.getCena(), 
        			towar.getVat().getNazwa(), 
        			(towar.getMagazyn() != null) ? towar.getMagazyn().getIlosc() : 0});
        return model;
	}
	
	/** Selects specific row. */
	public void selectRow(String value) {
		for(Towar towar: towars)
			if(towar.getNazwa().contentEquals(value) && !value.equals(lastChoice)) {
				parent.setTowar(towar);
				lastChoice = value;
				break;
			}
		System.out.println(value);
	}
	
	public static void main(String [] args) {
		JFrame frame = new JFrame();
		frame.add(new ProductsList(null));
		frame.pack();
		frame.setVisible(true);;
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}
}
