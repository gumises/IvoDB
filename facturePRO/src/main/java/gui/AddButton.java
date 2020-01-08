package gui;

import javax.swing.ImageIcon;

public class AddButton extends MyButton {

  /** Konstruktor.*/
  public AddButton(ImageIcon icon) {
    super(icon);
  }

  @Override
  public void makeAction() {
    new AddList();
  }
  
}
