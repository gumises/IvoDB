package facturePRO;

import java.util.ArrayList;

/*
 * Katalog zawierajacy klienta i faktury.
 */
public class Catalog {
  
  Client client;
  ArrayList<Facture> factures = new ArrayList<Facture>();
  
  /** Dodaje klienta.*/
  public void addClient(final Client newClient) {
    this.client = newClient;
  }
  
  /** Dodaje fakture.*/
  public void addFacture(final Facture newFacture) {
    factures.add(newFacture);
  }
  
  /** Zwraca klienta.*/
  public Client getClient() {
    return client;
  }
  
  /** Zwraca faktury.*/
  public ArrayList<Facture> getFactures() {
    return factures;
  }
  
  /** Zwraca imie i nazwisko klienta.*/
  public String getNameSurname() {
    return client.getNameSurname();
  }
  
  /** Zwraca imie klienta.*/
  public String getName() {
    return client.getName();
  }
  
  /** Zwraca nazwisko klienta.*/
  public String getSurname() {
    return client.getSurname();
  }
  
  /** Zwraca adres klienta.*/
  public String getAddress() {
    return client.getAddress();
  }
  
  
  /** Zwraca napisowa reprezentajce klineta.*/
  public String clientToString() {
    return client.toString();
  }
}
