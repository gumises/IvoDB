package newgui.panels.addfacture;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;

import newdatabase.Adres;
import newdatabase.Nabywca;
import newgui.Gui;
import newgui.components.MyLabel;

import static newgui.constants.AreaPanelConstants.*;
import static newdatabase.connector.ClientConnector.*;

public class FactureData extends JPanel {

	//parent
	Gui parent;
	
	//labels
	MyLabel noClient;
	
	MyLabel name;
	MyLabel phone;
	MyLabel nip;
	
	MyLabel city;
	MyLabel street;
	MyLabel house;
	MyLabel post;
	
	//layout
	GridBagLayout layout;
    GridBagConstraints gbc;
	
	public FactureData(Gui parent) {
		
		//parent
		this.parent = parent;
		
		//components
		noClient = new MyLabel(NO_CLIENT_TEXT, LABEL_FONT);
		name = new MyLabel("", "nazwa", DATA_FONT, DATA_COLOR);
		phone = new MyLabel("", "telefon", DATA_FONT, DATA_COLOR);
		nip = new MyLabel("", "nip", DATA_FONT, DATA_COLOR);
		
		city = new MyLabel("", "miasto", DATA_FONT, DATA_COLOR);
		street = new MyLabel("", "ulica", DATA_FONT, DATA_COLOR);
		house = new MyLabel("", "nr. domu", DATA_FONT, DATA_COLOR);
		post = new MyLabel("", "kod pocztowy", DATA_FONT, DATA_COLOR);

	    // gridBagLayout
	    layout = new GridBagLayout();
	    gbc = new GridBagConstraints();
	    setLayout(layout);
	    
	    //gbc init
	    gbc.weightx = 1;
	    gbc.weighty = 1;
	    //gbc.insets = new Insets(3,3,3,3);
	    gbc.fill = GridBagConstraints.BOTH;
	    
	    setNoClient();
	    
		setPreferredSize(ADD_FACTURE_DATA);
	    setVisible(true);

	}
	
	public void setNoClient() {
		removeAll();
		add(noClient, gbc);
	}
	
	public void setClient(Nabywca nabywca) {
		removeAll();
		Adres adres = nabywca.getAdres();
		name.setText(nabywca.getNazwa());
		phone.setText(nabywca.getTelefon());
		nip.setText(nabywca.getNip());
		city.setText(adres.getMiejscowosc());
		street.setText(adres.getUlica());
		post.setText(adres.getKodPocztowy());
		house.setText(adres.getNumerDomu());
		
		// name
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.gridwidth = 2;
	    gbc.weighty = 2;
	    add(name, gbc);
	    
		// phone
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	    gbc.gridwidth = 1;
	    gbc.weighty = 1;
	    gbc.insets = new Insets(0, 0, 0, 5);
	    add(phone, gbc);
	    
		// nip
	    gbc.gridx = 1;
	    gbc.gridy = 1;
	    gbc.insets = new Insets(0, 0, 0, 0);
	    add(nip, gbc);
	    
		// city
	    gbc.gridx = 0;
	    gbc.gridy = 2;
	    gbc.gridwidth = 2;
	    add(city, gbc);
	    
		// street
	    gbc.gridx = 0;
	    gbc.gridy = 3;
	    add(street, gbc);
	    
		// post
	    gbc.gridx = 0;
	    gbc.gridy = 4;
	    gbc.gridwidth = 1;
	    gbc.insets = new Insets(0, 0, 0, 5);
	    add(post, gbc);
	    
	    // house
	    gbc.gridx = 1;
	    gbc.gridy = 4;
	    gbc.insets = new Insets(0, 0, 0, 0);
	    add(house, gbc);
	}
	
	public static void main(String [] args) {
		FactureData panel = new FactureData(null);
		panel.setNoClient();
		
	}
}
