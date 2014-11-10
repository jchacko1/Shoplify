package views;

import controllers.OrderController;

import javax.swing.*;

public class AccountView extends JDialog {
    private JPanel contentPane;
    private JPanel iconPanel;
    private JPanel topRightPanel;
    private JButton loginBtn;
    private JPanel searchPanel;
    private JTextField searchField;
    private JButton searchBtn;
    private JLabel categoryLabel;
    private JList accountName;
    private JList subscription;
    private JList password;
    private JList details;
    private JList Bakery;
    private JList pastOrder;
    private JList RAform;
    private JList cardInfo;
    private JList GiftCards;
    private JButton buttonOK;

    public AccountView() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
    }

    public static void main(String[] args) throws ClassNotFoundException {
        AccountView dialog = new AccountView();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
