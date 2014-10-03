import javax.swing.*;

public class homepage extends JDialog {
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

    public homepage() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
    }

    public static void main(String[] args) {
        homepage dialog = new homepage();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
