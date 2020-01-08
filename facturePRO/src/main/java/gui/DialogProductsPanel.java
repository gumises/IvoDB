package gui;

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

import facturePRO.Facture;
import facturePRO.Product;

/*
 * Panel produktow w oknie tworzenia nowej faktury.
 */
public class DialogProductsPanel extends JPanel {

  // produkty
  ArrayList<DialogProduct> products;
  int noumberOfProducts;

  /*
   * Konsturtkor.
   */
  public DialogProductsPanel() {

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

  /*
   * Pojedynczy produkt
   */
  class DialogProduct extends JPanel {

    IdLabel id;
    NameField name;
    NameField amount;
    NameField price;

    /** Konstruktor. */
    public DialogProduct(final int newId, final String newName, final int newAmount, final double newPrice) {
      super();
      this.id = new IdLabel(Integer.toString(newId));
      this.name = new NameField(newName);
      this.amount = new NameField(Integer.toString(newAmount));
      this.price = new NameField(Double.toString(newPrice));

      // gridBagLayout
      final GridBagLayout layout = new GridBagLayout();
      final GridBagConstraints con = new GridBagConstraints();
      setLayout(layout);

      // common
      con.fill = GridBagConstraints.BOTH;
      con.weightx = 1;
      // con.weighty = 1;
      con.ipady = 20;
      con.insets = new Insets(2, 2, 2, 2);

      // id
      con.gridy = 0;
      con.gridx = 0;
      add(id, con);

      // name
      con.gridy = 0;
      con.gridx = 1;
      add(name, con);

      // amount
      con.gridy = 0;
      con.gridx = 2;
      add(amount, con);

      // price
      con.gridy = 0;
      con.gridx = 3;
      add(price, con);

      setVisible(true);
    }

    /** Zwraca nazwe produktu. */
    public String getName() {
      return name.getText();
    }

    /** Zwraca ilosc produktow. */
    public int getAmount() {
      try {
        return Integer.parseInt(amount.getText());
      } catch (NumberFormatException exception) {
      }
      return 1;
    }

    /** Zwraca cene produktu. */
    public double getPrice() {
      double tempPrice;
      try {
        tempPrice = Double.parseDouble(price.getText());
      } catch (NumberFormatException exception) {
        tempPrice = 0;
      }
      return tempPrice;
    }

    /** Zwraca sumaryczna cene produktow. */
    public double getSumPrice() {
      return getPrice() * getAmount();
    }

    /** Zwraca produkt. */
    public Product getProduct() {
      return new Product(getName(), getAmount(), getPrice());
    }
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
