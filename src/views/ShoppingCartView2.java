
package views;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ShoppingCartView2 extends JFrame{
    
    private JLabel shoppingcartLabel, blankLabel, totalLabel, valueLabel, couponLabel;
    private JPanel topPanel, midPanel, bottomPanel, pricePanel, couponPanel;
    private JButton closeButton, couponButton, checkoutButton, subscriptionButton;
    private JTextField couponTF;
    private JScrollPane scrollpane;
   
    
    public ShoppingCartView2() {
        
        
        ActionListener subscriptionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SubscriptionView2 SubscriptionView2Frame = new SubscriptionView2();
                SubscriptionView2Frame.setVisible(true);
                SubscriptionView2Frame.setSize(500,300);
                dispose();
            }

        };
        
        ActionListener checkoutListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                CheckoutView2 CheckoutView2Frame = new CheckoutView2();
                CheckoutView2Frame.setVisible(true);
                CheckoutView2Frame.setSize(350,500);
                dispose();
            }

        };
        
        ActionListener closeListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }

        };
        
        
        Container content = getContentPane();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        
        topPanel = new JPanel();
        topPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        subscriptionButton = new JButton("Subscription");
        subscriptionButton.addActionListener(subscriptionListener);
        c.fill = GridBagConstraints.FIRST_LINE_START;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0;
        c.weighty = 0;
        topPanel.add(subscriptionButton, c);
        
        shoppingcartLabel = new JLabel("Shopping Cart");
        c.fill = GridBagConstraints.PAGE_START;
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 0;
        topPanel.add(shoppingcartLabel, c);
        
        blankLabel = new JLabel("");
        c.fill = GridBagConstraints.FIRST_LINE_END;
        c.gridx = 2;
        c.gridy = 0;
        c.weightx = 0.5;
        c.weighty = 0;
        topPanel.add(blankLabel, c);
        
        content.add(topPanel);
        
        
        midPanel = new JPanel();
        midPanel.setLayout(new BoxLayout(midPanel, BoxLayout.Y_AXIS));
        scrollpane = new JScrollPane(midPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollpane.setPreferredSize(new Dimension(300, 250));
        content.add(scrollpane);
        
        couponPanel = new JPanel();
        couponPanel.setLayout(new BoxLayout(couponPanel, BoxLayout.X_AXIS));
        couponLabel = new JLabel("Coupon Code: ");
        couponPanel.add(couponLabel);
        couponTF = new JTextField();
        couponPanel.add(couponTF);
        couponButton = new JButton("Submit");
        couponPanel.add(couponButton);
        content.add(couponPanel);
        
        pricePanel = new JPanel();
        pricePanel.setLayout(new BorderLayout());
        totalLabel = new JLabel("Total: ");
        pricePanel.add(totalLabel, BorderLayout.WEST);
        valueLabel = new JLabel("$ Value");
        pricePanel.add(valueLabel, BorderLayout.CENTER);
        content.add(pricePanel);
        
        bottomPanel = new JPanel();
        closeButton = new JButton("Close");
        closeButton.addActionListener(closeListener);
        bottomPanel.add(closeButton);
        checkoutButton = new JButton("Check Out");
        checkoutButton.addActionListener(checkoutListener);
        bottomPanel.add(checkoutButton);
        content.add(bottomPanel);
        
    }
    
    public static void main(String[] args) {

        ShoppingCartView2 frame = new ShoppingCartView2();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Shopping Cart");
        frame.setSize(500,300);
    }
    
}
