package newgui.constants;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class ListPanelConstants {

	// TABLE
	public final static String[] COLUMN_NAMES = {"nazwa", "cena", "vat", "ilosc"};
	public final static String[] CLIENT_COLUMN_NAMES = {"nazwa", "telefon", "nip"};
	public final static String[] FAKTURA_COLUMN_NAMES = {"numer", "data_wystawienia", "klient"};
	
	// public final static Dimension TABLE_DIMENSION = new Dimension(400,600);
	public final static Dimension HEADER_DIMENSION = new Dimension(400,40);
	public final static int ROW_HEIGHT = 30;
	public final static Font HEADER_FONT = new Font("sansserif", Font.BOLD, 16);
	public final static Font TABLE_FONT = new Font("sansserif", Font.PLAIN, 14);
	
	// products texts
	public final static String NAME_TEXT = "nazwa:";
	public final static String MAXPRICE_TEXT = "cena max:";
	public final static String MINPRICE_TEXT = "cena min:";
	public final static String MINWAREHOUSE_TEXT = "min magazyn:";
	
	// clients texts
	public final static String CLIENT_NAME = "nazwa:";
	public final static String CLIENT_PHONE = "nr. telefonu::";
	public final static String CLIENT_NIP = "nip:";
	
	// texts common
	public final static String SEARCH_TEXT = "Wyszukaj";
	
	//dimensions
	public final static Dimension PANEL_DIMENSION = new Dimension(400,800);
	
	//colors
	public final static Color PANEL_COLOR = Color.LIGHT_GRAY.brighter();
	public final static Color SEARCH_COLOR = Color.BLUE.brighter();
	public final static Color LIST_COLOR = Color.LIGHT_GRAY;
	
	//fonts
	public final static Font BUTTON_FONT = new Font("sansserif", Font.BOLD, 20);
	public final static Font LABEL_FONT = new Font("sansserif", Font.PLAIN, 17);
	public final static Font FIELD_FONT = new Font("sansserif", Font.PLAIN, 17);
	
	private ListPanelConstants() {}
}
