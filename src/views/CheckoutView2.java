
package views;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CheckoutView2 extends JFrame{

   private JPanel topPanel, midPanel, paymentLabelPanel, paymentPanel, bottomPanel,
           totalPanel;
   private JLabel shippingInfoLabel, paymentInfoLabel, firstnameLabel, lastnameLabel,
           addressLabel, cityLabel, stateLabel, countryLabel, zipLabel, phoneLabel,
           emailLabel, creditcardLabel, cardholderLabel, creditcardnumberLabel, 
           expirationLabel, totalLabel, valueLabel;
   private JTextField firstnameTF, lastnameTF, cardholderTF, creditcardTF,
           addressTF, cityTF, stateTF, countryTF, zipTF, phoneTF, expirationTF,
           emailTF;
   private JButton okButton, cancelButton;
   
    public CheckoutView2() {
        
        ActionListener cancelListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
   
        };
        
        ActionListener okListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
   
        };
        
        Container content = getContentPane();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
      
        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        shippingInfoLabel = new JLabel("Shipping Information");
        topPanel.add(shippingInfoLabel);
        content.add(topPanel);
        
        midPanel = new JPanel();
        midPanel.setLayout(new GridLayout(9,2));
        firstnameLabel = new JLabel("First Name: ", SwingConstants.CENTER);
        midPanel.add(firstnameLabel);
        firstnameTF = new JTextField();
        midPanel.add(firstnameTF);
        lastnameLabel = new JLabel("Last Name: ", SwingConstants.CENTER);
        midPanel.add(lastnameLabel);
        lastnameTF = new JTextField();
        midPanel.add(lastnameTF);
        addressLabel = new JLabel("Address: ", SwingConstants.CENTER);
        midPanel.add(addressLabel);
        addressTF = new JTextField();
        midPanel.add(addressTF);
        cityLabel = new JLabel("City: ", SwingConstants.CENTER);
        midPanel.add(cityLabel);
        cityTF = new JTextField();
        midPanel.add(cityTF);
        stateLabel = new JLabel("State: ", SwingConstants.CENTER);
        midPanel.add(stateLabel);
        stateTF = new JTextField();
        midPanel.add(stateTF);
        countryLabel = new JLabel("Country: ", SwingConstants.CENTER);
        midPanel.add(countryLabel);
        countryTF = new JTextField();
        midPanel.add(countryTF);
        zipLabel = new JLabel("Zip Code: ", SwingConstants.CENTER);
        midPanel.add(zipLabel);
        zipTF = new JTextField();
        midPanel.add(zipTF);
        phoneLabel = new JLabel("Phone Number: ", SwingConstants.CENTER);
        midPanel.add(phoneLabel);
        phoneTF = new JTextField();
        midPanel.add(phoneTF);
        emailLabel = new JLabel("Email: ", SwingConstants.CENTER);
        midPanel.add(emailLabel);
        emailTF = new JTextField();
        midPanel.add(emailTF);
        content.add(midPanel);
        
        paymentLabelPanel = new JPanel();
        paymentLabelPanel.setLayout(new FlowLayout());
        
        paymentInfoLabel = new JLabel("Payment Information");
        paymentLabelPanel.add(paymentInfoLabel);
        content.add(paymentLabelPanel);
        
        paymentPanel = new JPanel();
        paymentPanel.setLayout(new GridLayout(4,2));
        creditcardLabel = new JLabel("Credit Card Type: ", SwingConstants.CENTER);
        paymentPanel.add(creditcardLabel);
        countryTF = new JTextField();
        paymentPanel.add(countryTF);
        cardholderLabel = new JLabel("Cardholder's Name: ", SwingConstants.CENTER);
        paymentPanel.add(cardholderLabel);
        cardholderTF = new JTextField();
        paymentPanel.add(cardholderTF);
        creditcardnumberLabel = new JLabel("Credit Card Number: ", SwingConstants.CENTER);
        paymentPanel.add(creditcardnumberLabel);
        creditcardTF = new JTextField();
        paymentPanel.add(creditcardTF);
        expirationLabel = new JLabel("Expiration Date: ", SwingConstants.CENTER);
        paymentPanel.add(expirationLabel);
        expirationTF = new JTextField();
        paymentPanel.add(expirationTF);
        content.add(paymentPanel);
        
        totalPanel = new JPanel();
        totalPanel.setLayout(new GridLayout(1,1));
        totalLabel = new JLabel("Total: ", SwingConstants.CENTER);
        totalPanel.add(totalLabel);
        valueLabel = new JLabel("$ Value");
        totalPanel.add(valueLabel);
        content.add(totalPanel);
       
        
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        okButton = new JButton("Submit Order");
        okButton.addActionListener(okListener);
        bottomPanel.add(okButton);
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(cancelListener);
        bottomPanel.add(cancelButton);
        content.add(bottomPanel);
    }
    
    public static void main(String[] args) {

        CheckoutView2 frame = new CheckoutView2();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Checkout");
        frame.setSize(350,500);
    }
    
}
