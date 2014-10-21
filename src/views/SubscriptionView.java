package views;

import javax.swing.*;

public class SubscriptionView extends JDialog {
    private JPanel contentPane;
    private JPanel iconPanel;
    private JPanel topRightPanel;
    private JButton loginBtn;
    private JPanel searchPanel;
    private JTextField searchField;
    private JButton searchBtn;
    private JLabel categoryLabel;
    private JList Deli;
    private JList Meat;
    private JList Seafood;
    private JList Vegetable;
    private JList Bakery;
    private JPanel adBannerPanel;
    private JLabel totalTxt;
    private JLabel totalNumAmount;
    private JButton couponBtn;
    private JButton checkOutBtn;
    private JButton subscriptionBtn;
    private JPanel subPanel;
    private JPanel calendarPane;
    private JLabel shippingLabel;
    private JList item1;
    private JList item2;
    private JEditorPane updateAmount1;
    private JEditorPane updateAmount2;
    private JTextArea item1Amount;
    private JTextArea item2Amount;
    private JButton buttonOK;

    public SubscriptionView() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
    }

    public static void main(String[] args) {
        SubscriptionView dialog = new SubscriptionView();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
