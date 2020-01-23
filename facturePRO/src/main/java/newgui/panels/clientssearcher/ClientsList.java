package newgui.panels.clientssearcher;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import newdatabase.Nabywca;
import newdatabase.Towar;
import newgui.Gui;

import static newgui.constants.ListPanelConstants.*;
import static newdatabase.connector.ClientConnector.*;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;
import java.util.Vector;


public class ClientsList extends JPanel {

	List<Nabywca> nabywcy;
	Gui parent;
	String lastChoice;
	
	public ClientsList(Gui parent) {
		this.parent = parent;
		lastChoice = null;
 		refresh(null, null, null);
	}
	
	/** Refreshes screens and lists. */
	public void refresh(String name, String phone, String nip) {
		this.removeAll();
 		JTable table = new JTable(prepareTableModel(name, phone, nip));
 		
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
	public DefaultTableModel prepareTableModel(String name, String phone, String nip) {
		DefaultTableModel model = new DefaultTableModel(CLIENT_COLUMN_NAMES, 0);
        nabywcy = getClients(name, phone, nip);
        for(Nabywca nabywca: nabywcy)
        	System.out.println(nabywcy);
        System.out.println(nabywcy.size());
        for(Nabywca nabywca: nabywcy)
        	model.addRow(new Object[]{
        			nabywca.getNazwa(), 
        			nabywca.getTelefon(), 
        			nabywca.getNip(), 
        	});
        return model;
	}
	
	/** Selects specific row. */
	public void selectRow(String value) {
		for(Nabywca nabywca: nabywcy)
			if(nabywca.getNazwa().contentEquals(value) && !value.equals(lastChoice)) {
				parent.setNabywca(nabywca);
				lastChoice = value;
				break;
			}
		System.out.println(value);
	}
	
	public static void main(String [] args) {
		JFrame frame = new JFrame();
		frame.add(new ClientsList(null));
		frame.pack();
		frame.setVisible(true);;
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}
}
