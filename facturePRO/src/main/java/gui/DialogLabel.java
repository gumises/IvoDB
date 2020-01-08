package gui;

import java.awt.Dimension;

import javax.swing.JLabel;

public class DialogLabel extends JLabel {

  /*
   * Domyslny konsturktor.
   */
  public DialogLabel(String text) {
    this(text, 'L');
  }
  
  /*
   * Konsturktor z orientacją horyznotalna.
   */
  public DialogLabel(String text, char horizontalAlignment) {
    this(text, horizontalAlignment, new Dimension(150,20));
  }

  /*
   * Konsturktor z orientacją horyznotalna i rozmiarami.
   */
  public DialogLabel(String text, char horizontalAlignment, Dimension dimension) {
    super(text);
    setPreferredSize(dimension);
    switch (horizontalAlignment) {
    case 'C':
      setHorizontalAlignment(CENTER);
      break;
    case 'L':
      setHorizontalAlignment(LEFT);
      break;
    case 'R':
      setHorizontalAlignment(RIGHT);
      break;
    }

  }
}
