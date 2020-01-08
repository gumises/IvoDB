package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;

import database.Database;
import facturePRO.Catalog;

/** Pokazuje liste klientow.*/
public class ShowList extends JDialog {
  
  /**
   * Konsturktor.
   */
  public ShowList() {
    super();
    
    ArrayList<Catalog> catalogs = Database.getCatalogs();
    
    //layout
    setLayout(new GridLayout(0,1));
    for (int i = 0; i < catalogs.size(); i++) {
      add(new CatalogButton(catalogs.get(i)), i);
    }
    
    setTitle("Lista klientow");
    pack();
    validate();
    setVisible(true);
    //setPreferredSize(new Dimension(400,400));
    setResizable(false);
  }
  
  /** Przycisk konkretnego katalogu.*/
  class CatalogButton extends JButton{
    
    Catalog catalog;
    
    /**
     * Konsturktor.
     */
    public CatalogButton(final Catalog catalog) {
      super();
      this.catalog = catalog;
      setText(catalog.getNameSurname());
      setPreferredSize(new Dimension(500,80));
      setBackground(Color.DARK_GRAY);
      setForeground(Color.WHITE);
      
      addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(final ActionEvent event) {
          new ShowDialog(catalog);
          //dispose();
        }
      });
    }
  }
  
}
