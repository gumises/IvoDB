package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.sun.prism.paint.Color;

public class FacturePRO extends JFrame {

  // buttons
  JButton addButton;
  JButton showButton;
  JButton exitButton;

  // fields
  JLabel factureLabel;
  MyLabel addLabel;
  MyLabel showLabel;
  MyLabel exitLabel;

  // icons
  public static final ImageIcon ICON_FACTURE = 
      new ImageIcon(new ImageIcon("res/factureImage2.png").getImage());
  public static final ImageIcon ICON_ADD = 
      new ImageIcon(new ImageIcon("res/addImage2.png").getImage());
  public static final ImageIcon ICON_SHOW = 
      new ImageIcon(new ImageIcon("res/showImage2.png").getImage());
  public static final ImageIcon ICON_EXIT = 
      new ImageIcon(new ImageIcon("res/exitImage3.png").getImage());

  /**
   * Konstruktor.
   */
  public FacturePRO() {

    addButton = new AddButton(ICON_ADD);
    showButton = new ShowButton(ICON_SHOW);
    exitButton = new ExitButton(ICON_EXIT);

    factureLabel = new JLabel(ICON_FACTURE);
    addLabel = new MyLabel("DODAJ FAKTURĘ");
    showLabel = new MyLabel("POKAŻ FAKTURY");
    exitLabel = new MyLabel("ZAKOŃCZ PROGRAM");

    // gridBagLayout
    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints con = new GridBagConstraints();
    setLayout(layout);

    // add Button
    con.gridx = 0;
    con.gridy = 0;
    add(addButton, con);

    // show Button
    con.gridx = 1;
    con.gridy = 0;
    add(showButton, con);

    // exit Button
    con.gridx = 2;
    con.gridy = 0;
    add(exitButton, con);

    // add Label
    con.gridx = 0;
    con.gridy = 1;
    add(addLabel, con);

    // show Label
    con.gridx = 1;
    con.gridy = 1;
    add(showLabel, con);

    // exit Label
    con.gridx = 2;
    con.gridy = 1;
    add(exitLabel, con);

    // factureField
    con.gridx = 0;
    con.gridy = 2;
    con.gridwidth = 3;
    add(factureLabel, con);

    // setPreferredSize(new Dimension(800,500));
    pack();
    validate();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("FacturePRO");
    setVisible(true);
    setEnabled(true);
  }

  public static void main(String[] args) {
    new FacturePRO();
  }
}
