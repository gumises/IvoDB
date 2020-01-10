package newgui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

import newgui.panels.AreaPanel;
import newgui.panels.ButtonsPanel;
import newgui.panels.ListPanel;

public class Gui extends JFrame {

	//panels
	ButtonsPanel buttonsPanel;
	ListPanel listPanel;
	AreaPanel areaPanel;
	
	public Gui() {

		buttonsPanel = new ButtonsPanel() {
			@Override
			public void buttonPressed(String button) {
				
			}
		};
		
		listPanel = new ListPanel();
		
		areaPanel = new AreaPanel();
		
	    // gridBagLayout
	    GridBagLayout layout = new GridBagLayout();
	    GridBagConstraints gbc = new GridBagConstraints();
	    setLayout(layout);

	    // buttons panel
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.gridwidth = 2;
	    add(buttonsPanel, gbc);

	    // list panel
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	    gbc.gridwidth = 1;
	    add(listPanel, gbc);
	    
	    // area panel
	    gbc.gridx = 1;
	    gbc.gridy = 1;
	    add(areaPanel, gbc);
	    
	    pack();
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setTitle("IvoDB");
	    setVisible(true);
	}

	public static void main(String[] args) {
		//TODO delete main method
		new Gui();
	}
}
