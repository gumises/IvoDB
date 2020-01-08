package gui;

import javax.swing.ImageIcon;

/** Klasa przycisku akcji.*/
public class ShowButton extends MyButton {
  
  /** Konsttruktor. */
  public ShowButton(final ImageIcon icon) {
    super(icon);
  }

  @Override
  public void makeAction() {
    new ShowList();
  }
}
