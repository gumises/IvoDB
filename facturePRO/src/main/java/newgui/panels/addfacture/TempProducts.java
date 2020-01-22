package newgui.panels.addfacture;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * Panel produktow w oknie tworzenia nowej faktury.
 */
public class TempProducts extends JPanel {

  // produkty
  ArrayList<DialogProduct> products;
  int noumberOfProducts;

  /*
   * Konsturtkor.
   */
  public TempProducts() {

    super();

    products = new ArrayList<DialogProduct>();
    noumberOfProducts = 0;

    addProduct();
    addProduct();
    addProduct();
  }

  /** Ustawia sumaryczna cene produktow. */
  public void makeSum() {

  }

  /** Zwraca sumaryczna cene produktow. */
  public double getSum() {
    double sum = 0;
    for (int i = 0; i < products.size(); i++) {
      sum += products.get(i).getSumPrice();
    }
    return sum;
  }

  /** Dodaje nowy produkt na koniec listy produktow. */
  public void addProduct() {
    if (noumberOfProducts < 10) {
      noumberOfProducts += 1;
      products.add(new DialogProduct(noumberOfProducts, "produkt", 1, 0));
      repaintProducts();
    }
  }

  /** Usuwa produkt z konca listy produktow. */
  public void removeProduct() {
    if (noumberOfProducts > 1) {
      noumberOfProducts -= 1;
      products.remove(products.size() - 1);
      repaintProducts();
    }
  }

  /** Drukuje produkty w panelu produktow. */
  public void repaintProducts() {
    this.removeAll();

    // gridBagLayout
    final GridBagLayout layout = new GridBagLayout();
    final GridBagConstraints con = new GridBagConstraints();
    setLayout(layout);

    con.fill = GridBagConstraints.HORIZONTAL;
    con.weightx = 1;

    for (int i = 0; i < products.size(); i++) {
      con.gridy = i;
      add(products.get(i), con);
    }

    setBackground(Color.RED);
  }

  /** Zwraca fakture. */
  public Facture getFacture() {
    final Facture facture = new Facture();
    for (int i = 0; i < noumberOfProducts; i++) {
      facture.addProduct(products.get(i).getProduct());
    }
    return facture;
  }

  

  /** Numer produktu. */
  class IdLabel extends JLabel {

    /** Konstruktor. */
    public IdLabel(final String text) {
      super(text);
      setHorizontalAlignment(CENTER);
      setVerticalAlignment(CENTER);
      setPreferredSize(new Dimension(50, 20));
    }
  }

  /** Nazwa produktu. */
  class NameField extends JTextField {

    /** Konstruktor. */
    public NameField(final String text) {
      super(text);
      setHorizontalAlignment(CENTER);
      setPreferredSize(new Dimension(150, 20));

      addFocusListener(new FocusListener() {
        @Override
        public void focusGained(final FocusEvent event) {
          setBackground(Color.LIGHT_GRAY);
          setForeground(Color.BLACK);
          setText("");
        }

        @Override
        public void focusLost(final FocusEvent event) {
          setBackground(Color.WHITE);
          setForeground(Color.BLACK);
          makeSum();
        }
      });
    }

  }

}