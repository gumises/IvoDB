package gui;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class DialogField extends JTextField {

  // status: 0 - active | 1 - typing | 2 - inactive | 3 - init | 4 - disabled
  int status;

  public DialogField(String text) {
    super(text);
    setHorizontalAlignment(CENTER);
    setStatus(3);

    addFocusListener(new FocusListener() {

      @Override
      public void focusGained(FocusEvent e) {
        setStatus(1);
        setText("");
      }

      @Override
      public void focusLost(FocusEvent e) {
        if (getText().equals("")) {
          setStatus(2);
        }
        else {
          setStatus(0);
        }
      }
    });
  }

  /** Zmienia tatus pola tekstowego. */
  public void setStatus(int newStatus) {
    switch (newStatus) {
      case 0: // active
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);
        if (status == 2) {
          status = 0;
          deleteException();
        }
        break;
      case 1: // typing
        setBackground(Color.LIGHT_GRAY);
        setForeground(Color.BLACK);
        break;
      case 2: // inactive
        setBackground(Color.RED);
        setForeground(Color.WHITE);
        if (status == 0) {
          status = 2;
          makeException();
        }
        break;
      case 3: // init
        setBackground(Color.RED);
        setForeground(Color.WHITE);
        status = 2;
        break;
      case 4: // disabled
        setBackground(Color.DARK_GRAY);
        setForeground(Color.WHITE);
        status = 4;
        setEnabled(false);
        break;
      default:
        break;
    }
  }

  /** Dodaje wyjatek do licznika wyjatkow. */
  public void makeException() {

  }

  /** Usuwa wyjatek z licznika wyjatkow. */
  public void deleteException() {

  }
}
