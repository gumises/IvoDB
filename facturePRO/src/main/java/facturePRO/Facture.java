package facturePRO;

import java.util.ArrayList;

/*
 * Obiekt faktury.
 */
public class Facture {

  ArrayList<Product> products;

  /** Konstruktor. */
  public Facture() {
    products = new ArrayList<Product>();
  }

  /** Dodaje produkt do faktury. */
  public void addProduct(Product product) {
    products.add(product);
  }
  
  /** Dodaje produkt do faktury. */
  public void addProduct(String name, int amount, double price) {
    products.add(new Product(name, amount, price));
  }

  @Override
  public String toString() {

    String text = "";
    text += getInfoLabel();
    for (int i = 0; i < products.size(); i++) {
      text += Integer.toString(i + 1) + "\t" + products.get(i).toString();
    }
    return text;
  }

  /** Zwraca etykiete informacyjna do faktury. */
  public String getInfoLabel() {
    String text = "";
    text += "nr." + '\t';
    text += "nazwa" + '\t';
    text += "ilosc" + '\t';
    text += "cena" + '\n';
    return text;

  }

  /** Zwraca sumaryczna cene produktow.*/
  public double getSum() {
    double tempSum = 0;
   
    for (int i = 0; i < products.size(); i++) {
      tempSum += products.get(i).getSumPrice();
    }
    return tempSum;
  }
}
