package newgui.panels.fakturaSercher;

import newdatabase.Faktura;
import newdatabase.connector.FactureConnector;
import newgui.Gui;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static newgui.constants.ListPanelConstants.*;


public class FakturaList extends JPanel {

	List<Faktura> faktury;
	Gui parent;
	String lastChoice;
	
	public FakturaList(Gui parent) {
		this.parent = parent;
		lastChoice = null;
 		refresh();
	}
	
	/** Refreshes screens and lists. */
	public void refresh() {
		this.removeAll();
 		JTable table = new JTable(prepareTableModel());
 		
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
	public DefaultTableModel prepareTableModel() {
		DefaultTableModel model = new DefaultTableModel(FAKTURA_COLUMN_NAMES, 0);
		faktury = new ArrayList<>();

		try {
			faktury = FactureConnector.getFactury();

		}
		catch (Exception e)
		{e.printStackTrace();
			System.out.println("Access denied");
		}
        for(Faktura faktura: faktury)
        	System.out.println(faktura);
        System.out.println(faktury.size());
		for(Faktura faktura: faktury)
        	model.addRow(new Object[]{
					faktura.getNumer(),
					faktura.getDataWystawienia(),
					faktura.getNabywca().getNazwa(),
        	});
        return model;
	}
	
	/** Selects specific row. */
	public void selectRow(String value) {
		for(Faktura faktura: faktury)
			if(faktura.getNumer().contentEquals(value) && !value.equals(lastChoice)) {
				parent.setFaktura(faktura);
				lastChoice = value;
				break;
			}
		System.out.println(value);
	}
	
	public static void main(String [] args) {
		JFrame frame = new JFrame();
		frame.add(new FakturaList(null));
		frame.pack();
		frame.setVisible(true);;
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}
}
