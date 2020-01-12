package newgui.panels.products;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import static newgui.constants.ListPanelConstants.*;


public class ProductsList extends JPanel {

	public ProductsList() {

 		JTable table = new JTable(prepareTableModel());
 		
 		table.setPreferredScrollableViewportSize(TABLE_DIMENSION);
 		table.setAutoCreateRowSorter(true);
 		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
 		table.setRowHeight(ROW_HEIGHT);
 		table.setFont(TABLE_FONT);
 		table.getTableHeader().setPreferredSize(HEADER_DIMENSION);
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

		//Add the scroll pane to this panel.
		add(scrollPane);
		setVisible(true);
		setBackground(LIST_COLOR);
	}
	
	/** Returns filled table model. */
	public DefaultTableModel prepareTableModel() {
		DefaultTableModel model = new DefaultTableModel(COLUMN_NAMES, 0);
        model.addRow(new Object[]{"Prankster", "USA", "Microsoft Pvt Ltd", "Party'14", 900000});
        model.addRow(new Object[]{"Ramanuj", "India", "Tata Consultancy", "Party'14", 500000});
        model.addRow(new Object[]{"Banana", "India", "Tata Consultancy", "Party'14", 500000});
        model.addRow(new Object[]{"Banana", "India", "Tata Consultancy", "Party'14", 500000});
        model.addRow(new Object[]{"Banana", "India", "Tata Consultancy", "Party'14", 500000});
        model.addRow(new Object[]{"Banana", "India", "Tata Consultancy", "Party'14", 500000});
        return model;
	}
	
	/** Selects specific row. */
	public void selectRow(String value) {
		System.out.println(value);
	}
	
	public static void main(String [] args) {
		JFrame frame = new JFrame();
		frame.add(new ProductsList());
		frame.pack();
		frame.setVisible(true);;
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}
}
