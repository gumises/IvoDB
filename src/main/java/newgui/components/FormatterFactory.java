package newgui.components;
import static newgui.constants.DataFormats.*;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatter;
import javax.swing.text.NumberFormatter;

public class FormatterFactory {

	public static DefaultFormatter getFormat(int format) {
		switch(format) {
		case FLOAT: 
			return getFloatFormat();
		case INTEGER:
			return getIntegerFormat();
		case DATE:
			return getDateFormat();
		case TEXT:
			return getTextFormat();
		}
		return null;
	}
	
	/** Returns floating point number format. */
	private static DefaultFormatter getFloatFormat() {
		
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setDecimalSeparator('.');

		NumberFormat format = new DecimalFormat("0.00", symbols);
		format.setMaximumFractionDigits(2);

		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setMinimum(0.0);
		formatter.setMaximum(1000000.0);
		formatter.setAllowsInvalid(false);

		return formatter;
	}
	
	/** Returns intenger format. */
	private static DefaultFormatter getIntegerFormat() {
		
		NumberFormat format = new DecimalFormat("0");
		format.setMaximumFractionDigits(0);

		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setMinimum(0);
		formatter.setMaximum(1000000);
		formatter.setAllowsInvalid(false);

		return formatter;
	}
	
	/** Returns date format. */
	private static DefaultFormatter getDateFormat() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		DateFormatter formatter = new DateFormatter(format);
		//formatter.setAllowsInvalid(false);
		return formatter;
	}
	
	/** Returns text format. */
	private static DefaultFormatter getTextFormat() {
		DefaultFormatter formatter = new DefaultFormatter();
		return formatter;
	}
}
