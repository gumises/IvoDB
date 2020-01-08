package gui;

import java.awt.Dimension;

import javax.swing.JLabel;

public class MyLabel extends JLabel {

  /**
   * Konsturktor.
   */
  public MyLabel(String text) {

    super(text);

    setPreferredSize(new Dimension(250, 50));
    setHorizontalAlignment(CENTER);
  }
}
