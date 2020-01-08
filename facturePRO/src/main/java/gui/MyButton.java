package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MyButton extends JButton {

  /** Konsturktor. */
  public MyButton(final ImageIcon icon) {

    super(icon);

    // setPreferredSize(new Dimension(300, 50));

    addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(final ActionEvent event) {
        makeAction();
      }
    });
  }
  
  /** Obsluga akcji przycisku.*/
  public void makeAction() {
  }
}
