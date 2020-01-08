package database;

import java.util.ArrayList;

import facturePRO.Catalog;
import facturePRO.Client;
import facturePRO.Facture;
import facturePRO.Product;

/** Baza danych zawierajaca klientow, faktury.*/
public class Database {

  ArrayList<Catalog> catalogs = new ArrayList<Catalog>();
  
  /** Konsturktor.*/
  public Database() {
    
    Catalog tempCatalog;
    Facture tempFacture;
    
    //Jan Kowalski
    tempCatalog = new Catalog();
    tempCatalog.addClient(new Client("Jan", "Kowalski", "Wroclaw, ul. Wittiga 123"));
    
    tempFacture = new Facture();
    tempFacture.addProduct(new Product("komputer", 10, 1232.50));
    tempFacture.addProduct(new Product("laptop", 20, 2222.50));
    tempFacture.addProduct(new Product("ołowek", 50, 1));
    tempCatalog.addFacture(tempFacture);
    catalogs.add(tempCatalog);
    
    //Witold Kowal
    tempCatalog = new Catalog();
    tempCatalog.addClient(new Client("Witold", "Kowal", "Warszwa, ul. Dluga 1"));
    
    tempFacture = new Facture();
    tempFacture.addProduct(new Product("biurko", 1, 1000.50));
    tempCatalog.addFacture(tempFacture);
    
    tempFacture = new Facture();
    tempFacture.addProduct(new Product("krzeslo", 15, 59.99));
    tempCatalog.addFacture(tempFacture);
    catalogs.add(tempCatalog);
    
    //Stanislaw Wokulski
    tempCatalog = new Catalog();
    tempCatalog.addClient(new Client("Stanislaw", "Wokulski", "Lublin, al. Raclawickie 134a"));
    catalogs.add(tempCatalog);
  }
  
  /** Zwraca liste katalogow.*/
  public static ArrayList<Catalog> getCatalogs() {
    
    Database database = new Database();
    return database.catalogs;
  }
  
  /** Zapisuje nowa fakture.*/
  public static void addCatalog(Catalog newCatalog) {
    System.out.println("Saved successfully!");
  }
}
