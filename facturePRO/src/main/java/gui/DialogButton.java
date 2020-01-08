package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class DialogButton extends JButton {

  /*
   * Konstrutkor z ikona.
   */
  public DialogButton(ImageIcon icon) {

    super(icon);

    addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent event) {
        makeAction();
      }
    });
  }
  
  /*
   * Konstrutkor z tekstem.
   */
  public DialogButton(String text) {

    super(text);

    addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent event) {
        makeAction();
      }
    });
  }
  
  public void makeAction() {
  }
}
