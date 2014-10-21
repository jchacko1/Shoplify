package views;

import javax.swing.*;

public class HomepageView extends JDialog {
    private JPanel contentPane;
    private JButton loginBtn;
    private JButton buttonOK;
    private JTextField searchField;
    private JButton searchBtn;
    private JPanel iconPanel;
    private JPanel searchPanel;
    private JPanel topRightPanel;
    private JPanel adBannerPanel;
    private JTextArea advertismentsAndBannersTextArea;
    private JLabel categoryLabel;
    private JList Deli;
    private JList Meat;
    private JList Seafood;
    private JList Vegetable;
    private JList Bakery;

    public HomepageView() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
    }

    public static void main(String[] args) {
        HomepageView dialog = new HomepageView();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
