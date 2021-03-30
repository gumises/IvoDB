package newgui.temppanels;

import javax.swing.JFrame;
import javax.swing.JPanel;

import newgui.Gui;
import newgui.components.ActionButton;
import newgui.components.ErrorLabel;
import newgui.components.MyLabel;
import newgui.components.MyTextField;

import static newgui.constants.AreaPanelConstants.*;
import static newgui.constants.DataFormats.*;
import static newgui.components.FormatterFactory.getFormat;
import static newdatabase.connector.DBConnector.*;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class DynamicQueryPanel extends JPanel {

	//parent
	Gui parent;
	
	// fields
	MyTextField query;
	
	// button
	ActionButton button;
	
	// labels
	MyLabel title;
	ErrorLabel error;
	
	public DynamicQueryPanel(Gui parent) {
		
		this.parent = parent;
		
		// fields
		query = new MyTextField(getFormat(TEXT), FIELD_FONT, QUERY_NAME);
		
		// label
		error = new ErrorLabel(QUERY_MESSAGE, QUERY_ERROR, ERROR_FONT);
		title = new MyLabel(QUERY_TITLE, LABEL_FONT);
		
		//button
		button = new ActionButton(BUTTON_PERFORM, BUTTON_COLOR, BUTTON_FONT);
		button.addActionListener(event -> tryPerform());
		
	    // gridBagLayout
	    GridBagLayout layout = new GridBagLayout();
	    GridBagConstraints gbc = new GridBagConstraints();
	    setLayout(layout);
	    
	    //gbc init
	    gbc.weightx = 1;
	    gbc.weighty = 1;
	    gbc.insets = new Insets(3,3,3,3);
	    gbc.fill = GridBagConstraints.BOTH;
	    
	    //title
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.gridwidth = 2;
	    add(title, gbc);
	    
	    // query
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	    add(query, gbc);
	    
	    // error
	    gbc.gridx = 0;
	    gbc.gridy = 3;
	    gbc.gridwidth = 2;
	    gbc.weighty = 0.3;
	    add(error, gbc);
	    
	    // button
	    gbc.gridx = 0;
	    gbc.gridy = 4;
	    gbc.gridwidth = 2;
	    gbc.weighty = 1.2;
	    add(button, gbc);
	    
	    //setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    setPreferredSize(PANEL_DIMENSION);
	    setBackground(PANEL_COLOR);
	    //pack();
	    setVisible(false);
	}
	
	/** Invoked when user presses login button. */
	public void tryPerform() {
		try {
			String queryV = (String)query.getValue();
			dynamicQuery(queryV);
			error.putMessage();
		}
		catch(Exception exception) {
			error.putError();
		}
	}
	
	public static void main(String[] args) {
		DynamicQueryPanel panel = new DynamicQueryPanel(null);
	}

}
