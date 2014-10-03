import javax.swing.*;
import java.awt.event.*;

public class checkout extends JDialog {
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
    private JLabel totalTxt;
    private JLabel totalNumAmount;
    private JTextArea etaDateField;
    private JLabel shippingLabel;
    private JLabel paymentLabel;
    private JList shippingName;
    private JList address;
    private JList phone;
    private JList priority;
    private JList carrier;
    private JList cardHolderName;
    private JList billingAddr;
    private JList paymentPhone;
    private JList cardType;
    private JList cardExp;
    private JPanel shippingPan;
    private JPanel paymentPan;
    private JButton buttonOK;
    private JButton buttonCancel;

    public checkout() {
        setContentPane(contentPane);
        setModal(true);
        
        }



    public static void main(String[] args) {
        checkout dialog = new checkout();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
