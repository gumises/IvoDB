package newgui.panels.addfacture;

import java.awt.Color;

import javax.swing.JPanel;
import newgui.Gui;

import static newgui.constants.AreaPanelConstants.*;

public class FactureProducts extends JPanel {

	//parent
	Gui parent;
	
	public FactureProducts(Gui parent) {
		this.parent = parent;
		setBackground(Color.RED);
		setPreferredSize(ADD_FACTURE_PRODUCTS);
	}
}
