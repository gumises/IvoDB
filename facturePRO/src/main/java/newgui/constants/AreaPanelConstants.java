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
				
	//texts common
	public final static String BUTTON_ADD = "Dodaj";
	public final static String BUTTON_REMOVE = "Usun";
	
	//fonts
	public final static Font FIELD_FONT = new Font("sansserif", Font.PLAIN, 17);
	public final static Font BUTTON_FONT = new Font("sansserif", Font.BOLD, 20);
	public final static Font ERROR_FONT = new Font("sansserif", Font.PLAIN, 15);
	public final static Font LABEL_FONT = new Font("sansserif", Font.PLAIN, 18);
	
	//colors
	public final static Color PANEL_COLOR = Color.LIGHT_GRAY;
	public final static Color BUTTON_COLOR = Color.DARK_GRAY;
	public final static Color ERROR_COLOR = Color.RED;
	public final static Color BORDER_COLOR = Color.BLACK;
	
	//dimensions
	public final static Dimension PANEL_DIMENSION = new Dimension(400,300);
	public final static Dimension PANEL_DIMENSION2 = new Dimension(400,600);
	public final static Dimension MAINPANEL_DIMENSION = new Dimension(800,800);
	/*
	//texts
	public final static String SEARCH_TEXT = "Wyszukaj";
	public final static String NAME_TEXT = "nazwa:";
	public final static String MAXPRICE_TEXT = "cena max:";
	public final static String MINPRICE_TEXT = "cena min:";
	public final static String MINWAREHOUSE_TEXT = "min magazyn:";
	
	//dimensions
	public final static Dimension SEARCHER_DIMENSION = new Dimension(400,220);
	public final static Dimension NAME_DIM = new Dimension(350,600);
	
	//colors
	public final static Color PANEL_COLOR = Color.LIGHT_GRAY;
	public final static Color SEARCH_COLOR = Color.BLUE.brighter();
	public final static Color LIST_COLOR = Color.LIGHT_GRAY;
	
	//fonts
	
	public final static Font LABEL_FONT = new Font("sansserif", Font.PLAIN, 17);
	
	*/
	
	private AreaPanelConstants() {}
}
