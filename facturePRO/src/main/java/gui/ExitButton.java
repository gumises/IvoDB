package gui;

import javax.swing.ImageIcon;

public class ExitButton extends MyButton {

  /** Konsturktor.*/
  public ExitButton(final ImageIcon icon) {
    super(icon);
  }
  
  @Override
  public void makeAction() {
    System.out.println("Bye!");
    System.exit(0);
  }
}
