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

/** Pokazuje liste klientow. */
public class AddList extends JDialog {

  /**
   * Konstruktor.
   */
  public AddList() {

    ArrayList<Catalog> catalogs = Database.getCatalogs();

    // layout
    setLayout(new GridLayout(0, 1));
    for (int i = 0; i < catalogs.size(); i++) {
      add(new CatalogButton(catalogs.get(i)), i);
    }
    add(new NewCatalogButton());

    setTitle("Lista klientow");
    pack();
    validate();
    setVisible(true);
    // setPreferredSize(new Dimension(400,400));
    setResizable(false);
  }

  /** Przycisk konkretnego katalogu. */
  class CatalogButton extends JButton {

    Catalog catalog;

    /**
     * Konsturktor.
     */
    public CatalogButton(final Catalog catalog) {
      super();
      this.catalog = catalog;
      setText(catalog.getNameSurname());
      setPreferredSize(new Dimension(500, 80));
      setBackground(Color.DARK_GRAY);
      setForeground(Color.WHITE);

      addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent event) {
          new AddDialog(catalog.getName(), catalog.getSurname(), catalog.getAddress(), false);
          dispose();
        }
      });
    }
  }

  /** Przycisk nowego katalogu. */
  class NewCatalogButton extends JButton {

    /**
     * Konsturktor.
     */
    public NewCatalogButton() {
      super("Nowy klient");
      setPreferredSize(new Dimension(500, 80));
      setBackground(Color.BLUE);
      setForeground(Color.WHITE);

      addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(final ActionEvent event) {
          new AddDialog("imię:", "nazwisko:", "adres", true);
          dispose();
        }
      });
    }
  }

}
