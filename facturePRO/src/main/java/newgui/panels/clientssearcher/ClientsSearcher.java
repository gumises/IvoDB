package newgui.panels.clientssearcher;

import javax.swing.JFrame;
import javax.swing.JPanel;
import newgui.components.ActionButton;
import newgui.components.MyTextField;

import static newgui.components.FormatterFactory.getFormat;
import static newgui.constants.ListPanelConstants.*;
import static newgui.constants.DataFormats.*;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class ClientsSearcher extends JPanel {

	//parent
	ClientsSearcherPanel parent;
	
	// fields
	MyTextField name;
	MyTextField phone;
	MyTextField nip;
	MyTextField minAmount;
	
	// button
	ActionButton search;
	
	public ClientsSearcher(ClientsSearcherPanel parent) {
		
		this.parent = parent;
		
		// fields
		name = new MyTextField(getFormat(TEXT), FIELD_FONT, CLIENT_NAME);
		phone = new MyTextField(getFormat(TEXT), FIELD_FONT, CLIENT_PHONE);
		nip = new MyTextField(getFormat(TEXT), FIELD_FONT, CLIENT_NIP);
		
		//button
		search = new ActionButton(SEARCH_TEXT, SEARCH_COLOR, BUTTON_FONT);
		search.addActionListener(event -> search());
		
	    // gridBagLayout
	    GridBagLayout layout = new GridBagLayout();
	    GridBagConstraints gbc = new GridBagConstraints();
	    setLayout(layout);
	    
	    //gbc init
	    gbc.weightx = 1;
	    gbc.weighty = 1;
	    gbc.insets = new Insets(6,3,3,3);
	    gbc.fill = GridBagConstraints.BOTH;
	    
	    // name
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.gridwidth = 2;
	    add(name, gbc);
	    
	    // phone
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	    gbc.gridwidth = 1;
	    gbc.insets = new Insets(3,3,3,3);
	    add(phone, gbc);
	    
	    // nip
	    gbc.gridx = 1;
	    gbc.gridy = 1;
	    add(nip, gbc);
	    
	    // search
	    gbc.gridx = 0;
	    gbc.gridy = 2;
	    gbc.gridwidth = 2;
	    gbc.weighty = 1.2;
	    add(search, gbc);
	    
	    //setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    setBackground(PANEL_COLOR);
	    //pack();
	    setVisible(true);
	}
	
	/** Sets dialog visible. */
	public void init() {
		setVisible(true);
		//pack();
	}
	
	/** Invoked when run button is pressed. */
	public void search() {
		try {
			String nameV = (String)name.getMyValue();
			String phoneV =  (String)phone.getMyValue();
			String nipV = (String)nip.getMyValue();
			
			System.out.println("name      = " + nameV);
			System.out.println("phone  = " + phoneV);
			System.out.println("nip  = " + nipV);
			
			parent.list.refresh(nameV, phoneV, nipV);
			parent.parent.pack();
			
		}
		catch(Exception exception) {
			exception.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ClientsSearcher(null);
	}

}
