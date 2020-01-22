package newgui.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class MyLabel extends JLabel {

	Double value;
	private static DecimalFormat df = new DecimalFormat("0.00");
	
	/** Text, Font, Dimension */
	public MyLabel(String text, Font font, Dimension dimension, Color color) {
		super(text);
		setFont(font);
		setPreferredSize(dimension);
		setForeground(color);
		setHorizontalAlignment(JLabel.CENTER);
		setVerticalAlignment(JLabel.CENTER);
	}
	
	/** Text, Font */
	public MyLabel(String text, Font font) {
		super(text);
		setFont(font);
		setHorizontalAlignment(JLabel.CENTER);
		setVerticalAlignment(JLabel.CENTER);
	}
	
	/** Text, Font, Color */
	public MyLabel(String text, String title, Font font, Color color) {
		super(text);
		setFont(font);
		setForeground(color);
		setHorizontalAlignment(JLabel.CENTER);
		setVerticalAlignment(JLabel.CENTER);
		
		//setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
		setBorder(new TitledBorder(new LineBorder(Color.LIGHT_GRAY), title, TitledBorder.LEADING,
	            TitledBorder.TOP, null, Color.LIGHT_GRAY));
	}
	
	/** Text, Font, Color */
	public MyLabel(String text, Font font, Color color) {
		super(text);
		setFont(font);
		setForeground(color);
		setHorizontalAlignment(JLabel.CENTER);
		setVerticalAlignment(JLabel.CENTER);
		
		//setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
		setBorder(new LineBorder(Color.LIGHT_GRAY));
	}
	
	/** Text, Font, Color */
	public MyLabel(Double value, Font font, Color color) {
		super(Double.toString(value));
		this.value = value;
		setFont(font);
		setForeground(color);
		setHorizontalAlignment(JLabel.CENTER);
		setVerticalAlignment(JLabel.CENTER);
		
		//setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
		setBorder(new LineBorder(Color.LIGHT_GRAY));
	}
	
	/** Text, Font, Color */
	public MyLabel(int value, Font font, Color color) {
		super(Integer.toString(value));
		this.value = (double)value;
		setFont(font);
		setForeground(color);
		setHorizontalAlignment(JLabel.CENTER);
		setVerticalAlignment(JLabel.CENTER);
		
		//setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
		setBorder(new LineBorder(Color.LIGHT_GRAY));
	}
	
	/** Sets currente value. */
	public void setValue(double newValue) {
		this.value = newValue;
		setText(df.format(newValue));
	}
	
	/** Sets currente value. */
	public void setValue(int newValue) {
		this.value = (double)newValue;
		setText(Integer.toString(newValue));
	}
	
	public Double getValue() {
		return value;
	}
}
