package newgui.constants;

import java.awt.Color;
import java.awt.Dimension;

public class ButtonsPanelConstants {

	//texts products
	public final static String SEARCH_PRODUCTS = "Wyszukaj produkt";
	public final static String ADD_PRODUCT = "Dodaj produkt";
	public final static String REMOVE_PRODUCT = "Usun produkt";
	public final static String CHANGE_AMOUNT = "Zmien ilosc produktu";
	
	//texts invoices
	public final static String SEARCH_INVOICES = "Wyszukaj fakture";
	public final static String ADD_INVOICE = "Dodaj fakture";
	
	//texts clients
	public final static String SEARCH_CLIENTS = "Wyszukaj nabywce";
	public final static String ADD_CLIENT = "Dodaj nabywce";

	//texts other
	public final static String MAKE_BAKCUP = "Wykonaj backup";
	public final static String LOAD_BACKUP = "Wczytaj backup";
	public final static String DYNAMIC_QUERY = "Zapytanie dynamiczne";
	public final static String LOG_IN = "Zaloguj";
	
	//dimensions
	public final static Dimension PANEL_DIMENSION = new Dimension(900,75);

	//colors
	public final static Color PRODUCT = new Color(51,153,255);
	public final static Color INVOICE = new Color(0,128,255);
	public final static Color CLIENT = new Color(5,120,255);
	public final static Color OTHER = Color.DARK_GRAY;
	
	private ButtonsPanelConstants() {}
}
