package newgui.panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import newgui.temppanels.AddProductPanel;
import newgui.temppanels.ChangeAmountOfProduct;
import newgui.temppanels.RemoveProductPanel;

import static newgui.constants.AreaPanelConstants.*;

public class AreaPanel extends JPanel {

	//temporary panels
	AddProductPanel addProductPanel;
	RemoveProductPanel removeProductPanel;
	ChangeAmountOfProduct changeAmountOfProduct;
	
	ArrayList<JPanel> panels;
	
	public AreaPanel() {
		
		//temporary panels
			panels = new ArrayList<JPanel>();
		addProductPanel = new AddProductPanel();
			panels.add(addProductPanel);
		removeProductPanel = new RemoveProductPanel();
			panels.add(removeProductPanel);
		changeAmountOfProduct = new ChangeAmountOfProduct();
			panels.add(changeAmountOfProduct);
		
	    // gridBagLayout
	    GridBagLayout layout = new GridBagLayout();
	    GridBagConstraints gbc = new GridBagConstraints();
	    setLayout(layout);

	    //gbc init
	    gbc.weightx = 1;
	    gbc.weighty = 1;
	    gbc.fill = GridBagConstraints.BOTH;
	    
	    add(addProductPanel);
	    add(removeProductPanel);
	    add(changeAmountOfProduct);
	    
		setVisible(true);
		setBackground(PANEL_COLOR);
		setPreferredSize(MAINPANEL_DIMENSION);
	}
	
	/** Sets the add product panel to be visible. */
	public void initAddProductPanel() {
		invisibleAll();
		addProductPanel.setVisible(true);
	}
	
	/** Sets the remove product panel to be visible. */
	public void initRemoveProductPanel() {
		invisibleAll();
		removeProductPanel.setVisible(true);
	}
	
	/** Sets the change amount of product panel to be visible. */
	public void initChangeAmountOfProductPanel() {
		invisibleAll();
		changeAmountOfProduct.setVisible(true);
	}
	
	/** Sets all panels to be invisible. */
	public void invisibleAll() {
		for(JPanel panel: panels)
			panel.setVisible(false);
	}
}
