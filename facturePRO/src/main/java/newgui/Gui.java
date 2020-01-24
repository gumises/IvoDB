package newgui;

import newdatabase.*;
import newdatabase.connector.BackupConnector;
import newgui.dialogs.LoginDialog;
import newgui.panels.AreaPanel;
import newgui.panels.ButtonsPanel;
import newgui.panels.ListPanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Set;

import static newgui.constants.AccessLevels.VISITOR;
import static newgui.constants.ButtonsPanelConstants.*;

public class Gui extends JFrame {

    // panels
    ButtonsPanel buttonsPanel;
    ListPanel listPanel;
    AreaPanel areaPanel;

    //dialogs
    LoginDialog loginDialog;
    private int access =2;

    public Gui() {

        //panels
        buttonsPanel = new ButtonsPanel() {
            @Override
            public void buttonPressed(String button) {
                actionButtonPressed(button);
            }
        };
        buttonsPanel.changeAccess(VISITOR);
        listPanel = new ListPanel(this);

        areaPanel = new AreaPanel(this);


        //dialogs
        loginDialog = new LoginDialog(this);

        // gridBagLayout
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(layout);

        //gbc init
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;

        // buttons panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 0;
        gbc.gridwidth = 2;
        add(buttonsPanel, gbc);

        // list panel
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        gbc.gridwidth = 1;
        add(listPanel, gbc);

        // area panel
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(areaPanel, gbc);

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("IvoDB");
        setVisible(true);

        refresh(SEARCH_PRODUCTS);
    }

    /**
     * Invoked when action button is pressed.
     */
    public void actionButtonPressed(String action) {
        switch (action) {
            case SEARCH_INVOICES:
                listPanel.initFakturaSearcherPanel();
                break;
            case SEARCH_PRODUCTS:
                listPanel.initProductsSearcherPanel();
                break;
            case ADD_PRODUCT:
                areaPanel.initAddProductPanel();
                break;
            case REMOVE_PRODUCT:
                areaPanel.initRemoveProductPanel();
                break;
            case CHANGE_AMOUNT:
                areaPanel.initChangeAmountOfProductPanel();
                break;
            case LOG_IN:
                if (access == 2) {
                    initLoginDialog();
                } else {
                    HibernateUtil.reset();
                    changeAccess(2);
                }
                break;
            case ADD_CLIENT:
                areaPanel.initAddPurchaserPanel();
                break;
            case SEARCH_CLIENTS:
                listPanel.initClientsSearcherPanel();
                break;
            case DYNAMIC_QUERY:
                areaPanel.initDynamicQueryPanel();
                break;
            case ADD_INVOICE:
                areaPanel.initAddFacturePanel();
                break;
            case MAKE_BACKUP:
                try {
                    BackupConnector.makeBackup();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case LOAD_BACKUP:
                try {
                    BackupConnector.loadBackup();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
        pack();
    }

    /**
     * Invokes login dialog.
     */
    public void initLoginDialog() {
        loginDialog.setLocationRelativeTo(this);
        loginDialog.init();
    }

    /**
     * Refreshes screens and lists.
     */
    public void refresh(String action) {
        actionButtonPressed(action);
    }

    public void setTowar(Towar towar) {
        areaPanel.addFacturePanel.addProduct(towar);
        pack();
        System.out.println("setting towar");
    }

    public void setNabywca(Nabywca nabywca) {
        areaPanel.addFacturePanel.addNabywca(nabywca);
        pack();
        System.out.println("setting towar");
    }

    public void changeAccess(int access) {
        this.access = access;
        buttonsPanel.changeAccess(access);
    }

    public static void main(String[] args) {
        //TODO delete main method
        new Gui();
    }

    public void setFaktura(Faktura faktura) {
        areaPanel.initAddFacturePanel(faktura);
    }

    public void setTowar(Set<Kategoria> kategorias) {
        for(Kategoria kategoria : kategorias) {
            areaPanel.addFacturePanel.addProduct(kategoria);
            pack();
            System.out.println("setting towar");
        }
    }
}
