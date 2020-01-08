package facturePRO;

/*
 * Klasa produktu.
 */
public class Product {

  String name;
  int amount;
  double price;

  public Product(String name, int amount, double price) {
    this.name = name;
    this.amount = amount;
    this.price = price;
  }

  @Override
  public String toString() {
    String text = "";
    text += name + "\t";
    text += amount + "\t";
    text += price + "\n";
    return text;
  }

  /** Zwraca sumaryczna cene produkow. */
  public double getSumPrice() {
    return amount * price;
  }
}
