package newgui.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatter;
import javax.swing.text.InternationalFormatter;

import static newgui.constants.DataFormats.*;


public class MyTextField extends JFormattedTextField {
	
	String name;
	Color DEFAULT_ON = Color.LIGHT_GRAY;
	Color DEFAULT_OFF = Color.black;
	
	DefaultFormatter formatter;
	static DefaultFormatter defaultFormatter = FormatterFactory.getFormat(TEXT);
	
	public MyTextField(DefaultFormatter formatter, Font font, Dimension dimension) {
		super(formatter);
		this.formatter = formatter;
		setFont(font);
		setPreferredSize(dimension);
		setHorizontalAlignment(JTextField.CENTER);
		
		addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                setValue(null);
            }
        });
	}
	
	public MyTextField(Font font, Dimension dimension) {
		super();
		setFont(font);
		setPreferredSize(dimension);
		setHorizontalAlignment(JTextField.CENTER);
		
		addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                setText(null);
            }
        });
	}
	
	public MyTextField(Font font, String name) {
		super(name);
		this.name = name;
		setFont(font);
		setForeground(DEFAULT_ON);
		setHorizontalAlignment(JTextField.CENTER);
		
		addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                setText(null);
                setForeground(DEFAULT_OFF);
            }
        });
		
		addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				checkDefault();
			}
		});
	}
	
	public MyTextField(DefaultFormatter formatter, Font font, String name) {
		super(defaultFormatter);
		this.formatter = formatter;
		this.name = name;
		setText(name);
		setFont(font);
		setForeground(DEFAULT_ON);
		setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
		setHorizontalAlignment(JTextField.CENTER);
		
		addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	setValue(null);
            	setFormatter(formatter);
            	setForeground(DEFAULT_OFF);
            }
        });
		
		addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				checkDefault();
			}
		});
	}
	
	public void checkDefault() {
		
		try {commitEdit();
		}
		catch(Exception e) {}
		
		if(getText().equals("")) {
			setFormatter(defaultFormatter);
			setText(name);
			setForeground(DEFAULT_ON);
		}
	}
}
