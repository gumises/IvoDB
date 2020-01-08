package facturePRO;

/*
 * Obiekt klienta.
 */
public class Client {

  private String name;
  private String surname;
  private String address;

  /*
   * Klasa klienta.
   * 
   * @param name - imie produktu
   * 
   * @param surname - nazwisko klienta
   * 
   * @param address - adres klienta
   */
  public Client(final String name, final String surname, final String address) {
    this.name = name;
    this.surname = surname;
    this.address = address;
  }

  /** Zwraca imie i nazwisko klienta. */
  public String getNameSurname() {
    return (name + ' ' + surname);
  }

  /** Zwraca imie klienta. */
  public String getName() {
    return name;
  }

  /** Zwraca nazwisko klienta. */
  public String getSurname() {
    return surname;
  }

  /** Zwraca adres klienta. */
  public String getAddress() {
    return address;
  }

  @Override
  public String toString() {
    String text = "";
    text += name + '\t' + surname + '\n';
    text += address + '\n';
    return text;
  }
}
