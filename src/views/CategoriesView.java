package views;

import javax.swing.*;

public class CategoriesView extends JDialog {
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
    private JTable foodTable;
    private JScrollBar scrollBar1;
    private JButton buttonOK;

    public CategoriesView() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
    }

    public static void main(String[] args) {
        CategoriesView dialog = new CategoriesView();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
