package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;

import database.Database;
import facturePRO.Catalog;
import facturePRO.Client;
import facturePRO.Facture;
import gui.DialogProductsPanel.DialogProduct;

/**
 * Okno tworzenia nowej faktury.
 */
public class AddDialog extends JDialog {
  
  //labels
  DialogLabel personalData;
  DialogLabel productsData;
  
  DialogLabel productId;
  DialogLabel productName;
  DialogLabel productAmount;
  DialogLabel productPrice;
  DialogLabel sumLabel;
  
  //text fields
  DialogField name;
  DialogField surname;
  DialogField address;
  DialogField sumField;
  
  //products panel
  DialogProductsPanel productsPanel;
  
  //buttons
  DialogButton add;
  DialogButton more;
  DialogButton less;
  
  //icons
  public static final ImageIcon ICON_MORE = new ImageIcon(new ImageIcon("res/moreProduct2.png").getImage());
  public static final ImageIcon ICON_LESS = new ImageIcon(new ImageIcon("res/lessProduct2.png").getImage());
  
  //exceptions
  int noumberOfExceptions;

  /*
   * Konstruktor.
   */
  public AddDialog(String newName, String newSurname, String newAddress, boolean isEnabled) {
    noumberOfExceptions = 0;
    
    personalData = new DialogLabel("  DANE KLIENTA:", 'L', new Dimension(100,50));
    productsData = new DialogLabel("  PRODUKTY:", 'L', new Dimension(100,50));
    
    productId = new DialogLabel("nr.", 'C', new Dimension(50,30));
    productName = new DialogLabel("nazwa", 'C', new Dimension(150,30));
    productAmount = new DialogLabel("ilosc", 'C', new Dimension(150,30));
    productPrice = new DialogLabel("cena", 'C', new Dimension(150,30));
    sumLabel = new DialogLabel("suma:  ",'R', new Dimension(150,30));
    sumField = new DialogField("0.00");
    sumField.setStatus(4);
    
    name = new DialogField(newName) {
      @Override
      public void makeException() {
        addException();
      }
      
      @Override
      public void deleteException() {
        removeException();
      }
    };
    
    surname = new DialogField(newSurname){
      @Override
      public void makeException() {
        addException();
      }
      
      @Override
      public void deleteException() {
        removeException();
      }
    };
    
    address = new DialogField(newAddress){
      @Override
      public void makeException() {
        addException();
      }
      
      @Override
      public void deleteException() {
        removeException();
      }
    };
   
    add = new DialogButton("DODAJ") {
      @Override
      public void makeAction() {
        addFacture();
      }
    };
    
    more = new DialogButton(ICON_MORE) {
      @Override
      public void makeAction() {
        addProduct();
      }
    };
    
    less = new DialogButton(ICON_LESS) {
      @Override
      public void makeAction() {
        removeProduct();
      }
    };
    if(isEnabled) {
      noumberOfExceptions += 3;
      add.setEnabled(false);
    }
    else {
      name.setStatus(4);
      surname.setStatus(4);
      address.setStatus(4);
      noumberOfExceptions = 0;
      add.setEnabled(true);
    }

    
    productsPanel = new DialogProductsPanel() {
      @Override
      public void makeSum() {
        setSum();
      }
    };
    
    // gridBagLayout
    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints con = new GridBagConstraints();
    setLayout(layout);
    
    //common
    con.fill = GridBagConstraints.BOTH;
    //con.ipadx = 50;
    con.weightx = 1;
    //con.weighty = 1;
    
    //personal Data
    con.gridy = 0;
    con.gridx = 0;
    //con.ipady = 50;
    con.gridwidth = 4;
    add(personalData, con);
    
    //name
    con.gridy = 1;
    con.gridx = 0;
    con.ipady = 30;
    con.insets = new Insets(2,2,2,2);
    con.gridwidth = 2;
    add(name, con);
    
    //surname
    con.gridy = 1;
    con.gridx = 2;
    con.gridwidth = 2;
    add(surname, con);
    
    //address
    con.gridy = 2;
    con.gridx = 0;
    con.gridwidth = 4;
    add(address, con);
    
    //products data
    con.ipadx = 0;
    con.ipady = 0;
    con.insets = new Insets(0,0,0,0);
    con.gridy = 3;
    con.gridx = 0;
    con.gridwidth = 4;
    add(productsData, con);
    
    //product id
    con.gridy = 4;
    con.gridx = 0;
    con.gridwidth = 1;
    add(productId, con);
    
    //product name
    con.gridy = 4;
    con.gridx = 1;
    con.gridwidth = 1;
    add(productName, con);
    
    //product amount
    con.gridy = 4;
    con.gridx = 2;
    con.gridwidth = 1;
    add(productAmount, con);
    
    //product price
    con.gridy = 4;
    con.gridx = 3;
    con.gridwidth = 1;
    add(productPrice, con);
    
    //products panel
    con.gridy = 5;
    con.gridx = 0;
    con.gridwidth = 4;
    add(productsPanel, con);
    
    //sum label
    con.gridy = 6;
    con.gridx = 2;
    con.gridwidth = 1;
    con.ipady = 20;
    con.insets = new Insets(2,2,2,2);
    add(sumLabel, con);
    
    //sum field
    con.gridy = 6;
    con.gridx = 3;
    con.gridwidth = 1;
    add(sumField, con);
    
    //more button
    con.fill = GridBagConstraints.NONE;
    con.anchor = GridBagConstraints.EAST;
    con.gridy = 9;
    con.gridx = 2;
    con.gridwidth = 1;
    add(more, con);
    
    //less button
    con.fill = GridBagConstraints.NONE;
    con.anchor = GridBagConstraints.WEST;
    con.weightx = 0;
    con.gridy = 9;
    con.gridx = 3;
    con.gridwidth = 1;
    add(less, con);
    
    //add button
    con.fill = GridBagConstraints.BOTH;
    con.anchor = GridBagConstraints.CENTER;
    con.weightx = 1;
    con.gridy = 10;
    con.gridx = 0;
    con.insets = new Insets(2,2,2,2);
    con.ipady = 60;
    con.gridwidth = 4;
    add(add, con);
    
    //setPreferredSize(new Dimension(600,600));
    setTitle("Nowa faktura!");
    
    pack();
    validate();
    setVisible(true);
    //setEnabled(true);
    
  }
  
  /** Dodaje nowy produkt na koniec listy produktow. */
  public void addProduct() {
    productsPanel.addProduct();
    setSum();
    pack();
  }

  /** Usuwa produkt z konca listy produktow. */
  public void removeProduct() {
    productsPanel.removeProduct();
    setSum();
    pack();
  }
  
  /** Dodaje wyjatek do licznika wyjatkow.*/
  public void addException() {
    noumberOfExceptions += 1;
    add.setEnabled(false);
  }
  
  /** Usuwa wyjatek z licznika wyjatkow.*/
  public void removeException() {
    noumberOfExceptions -= 1;
    if(noumberOfExceptions == 0)
        add.setEnabled(true);
  }
  
  /** Dodaje nowa fakture. */
  public void addFacture() {
    Catalog catalog = new Catalog();
    Client client = getClient();
    Facture facture = getFacture();
    
    catalog.addClient(client);
    catalog.addFacture(facture);
    Database.addCatalog(catalog);
    dispose();
  }
  
  /** Ustawia sumaryczna cene produktow. */
  public void setSum() {
    sumField.setText(Double.toString(productsPanel.getSum()));
  }
  
  /** Zwraca obiekt klienta.*/
  public Client getClient() {
    return new Client(name.getText(), surname.getText(), address.getText());
  }
  
  /** Zwraca obiekt faktury. */
  public Facture getFacture() {
    return productsPanel.getFacture();
  }
}
