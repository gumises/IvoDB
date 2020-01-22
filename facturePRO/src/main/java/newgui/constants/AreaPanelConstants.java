package newgui.constants;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class AreaPanelConstants {

	//texts add product panel
		public final static String PRODUCT_NAME = "nazwa:";
		public final static String PRODUCT_PRICE = "cena:";
		public final static String PRODUCT_AMOUNT = "ilosc:";
		public final static String PRODUCT_VAT = "vat:";
		public final static String PRODUCT_TITLE = "Dodaj nowy produkt";
		public final static String PRODUCT_ERROR = "Duplikacja nazwy lub niepoprawne dane!";
		public final static String PRODUCT_MESSAGE = "Dodano pomyślnie.";
	
	//texts add product panel
		public final static String PRODUCT_REMOVE_TITLE = "Usun produkt";
		public final static String PRODUCT_REMOVE_ERROR = "Produktu o podanej nazwie nie ma w magazynie!";
		public final static String PRODUCT_REMOVE_MESSAGE = "Usunieto pomyślnie.";
		
	//texts change amount of product panel
		public final static String PRODUCT_CHANGE_TITLE = "Zmien liczbe produktow";
		public final static String PRODUCT_CHANGE_ERROR1 = "Nieprawidlowa nazwa lub ilosc towaru!";
		public final static String PRODUCT_CHANGE_ERROR2 = "Za malo produktow w magazynie!";
		public final static String PRODUCT_CHANGE_MESSAGE = "Zmieniono pomyslnie.";
	
	//texts add purchaser panel
		public final static String PURCH_NAME = "nazwa:";
		public final static String PURCH_PHONE = "telefon:";
		public final static String PURCH_NIP = "nip:";
		public final static String PURCH_CITY = "miejscowosc:";
		public final static String PURCH_STREET = "ulica:";
		public final static String PURCH_HOUSE = "nr. domu:";
		public final static String PURCH_POST = "kod poczt.:";
		public final static String PURCH_TITLE1 = "Dane firmy";
		public final static String PURCH_TITLE2 = "Dane kontaktowe";
		public final static String PURCH_ERROR = "Duplikacja nazwy lub niepoprawne dane!";
		public final static String PURCH_MESSAGE = "Dodano pomyślnie.";
	
	//texts add facture data
		public final static String NO_CLIENT_TEXT = "Nie wybrano nabywcy";
	
	//texts dynamic query panel
		public final static String QUERY_TITLE = "Zapytanie dynamiczne";
		public final static String QUERY_NAME = "zapytanie:";
		public final static String QUERY_ERROR = "Bledna trest zapytania!";
		public final static String QUERY_MESSAGE = "Wykonano poprawnie.";
				
	//texts common
	public final static String BUTTON_ADD = "Dodaj";
	public final static String BUTTON_REMOVE = "Usun";
	public final static String BUTTON_PERFORM = "Wykonaj";
	public final static String ADD_FACTURE_BUTTON_TEXT = "Zatwierdz";
	
	//fonts
	public final static Font FIELD_FONT = new Font("sansserif", Font.PLAIN, 17);
	public final static Font BUTTON_FONT = new Font("sansserif", Font.BOLD, 20);
	public final static Font ERROR_FONT = new Font("sansserif", Font.PLAIN, 15);
	public final static Font LABEL_FONT = new Font("sansserif", Font.PLAIN, 18);
	public final static Font DATA_FONT = new Font("sansserif", Font.PLAIN, 18);
	public final static Font PRODUCT_FONT = new Font("sansserif", Font.PLAIN, 12);
	public final static Font PRODUCT_LABEL_FONT = new Font("sansserif", Font.BOLD, 12);
	public final static Font REMOVE_PRODUCT_FONT = new Font("sansserif", Font.BOLD, 15);
	public final static Font ADD_FACTURE_BUTTON_FONT = new Font("sansserif", Font.BOLD, 15);
	
	//colors
	public final static Color PANEL_COLOR = Color.LIGHT_GRAY;
	public final static Color BUTTON_COLOR = Color.DARK_GRAY;
	public final static Color ERROR_COLOR = Color.RED;
	public final static Color BORDER_COLOR = Color.BLACK;
	public final static Color DATA_COLOR = Color.BLACK;
	public final static Color PRODUCT_COLOR = Color.BLACK;
	public final static Color PRODUCT_LABEL_COLOR = Color.BLACK;
	public final static Color REMOVE_PRODUCT_COLOR = Color.RED;
	public final static Color ADD_FACTURE_BUTTON_COLOR = Color.BLUE;;
	
	//dimensions
	public final static Dimension PANEL_DIMENSION = new Dimension(400,300);
	public final static Dimension PANEL_DIMENSION2 = new Dimension(400,600);
	public final static Dimension MAINPANEL_DIMENSION = new Dimension(800,800);
	public final static Dimension ADD_FACTURE_DATA = new Dimension(600,300);
	public final static Dimension ADD_FACTURE_PRODUCTS = new Dimension(600,450);
	public final static Dimension ADD_FACTURE_LABEL = new Dimension(300,40);
	public final static Dimension ADD_FACTURE_BUTTON_DIMENSION = new Dimension(300,75);
	
	private AreaPanelConstants() {}
}
