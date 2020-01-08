package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JTextArea;

import database.Database;
import facturePRO.Catalog;
import gui.ShowList.CatalogButton;

/** Pokazuje dane klienta i jego faktury. */
public class ShowDialog extends JDialog {

  JTextArea textArea;
  String text;

  /**
   * Konstruktor.
   */
  public ShowDialog(final Catalog catalog) {
    super();

    textArea = new JTextArea("");
    text = "";

    text += "DANE KLIENTA:\n\n";
    text += catalog.clientToString();

    text += "\n\n";
    for (int i = 0; i < catalog.getFactures().size(); i++) {
      text += "FAKTURA " + Integer.toString(i + 1) + "\n\n";
      text += catalog.getFactures().get(i).toString();
      text += "\n\n";
    }

    textArea.setText(text);
    textArea.setPreferredSize(new Dimension(500, 500));
    textArea.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
    textArea.setEditable(false);
    add(textArea);

    setTitle("Podglad faktur");
    pack();
    validate();
    setVisible(true);
    // setResizable(false);
  }
}
