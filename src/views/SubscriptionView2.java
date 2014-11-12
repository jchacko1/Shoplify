
package views;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SubscriptionView2 extends JFrame{
    
    private JLabel subscriptionLabel, blankLabel, totalLabel, valueLabel;
    private JPanel topPanel, midPanel, bottomPanel, pricePanel;
    private JButton closeButton, checkoutButton, shoppincartButton;
    private JScrollPane scrollpane;
   
    
    public SubscriptionView2() {
        
        ActionListener closeListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
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
        
        ActionListener subscriptionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ShoppingCartView2 ShoppingCartView2Frame = new ShoppingCartView2();
                ShoppingCartView2Frame.setVisible(true);
                ShoppingCartView2Frame.setSize(500,300);
                dispose();
            }

        };
        
        
        Container content = getContentPane();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        
        topPanel = new JPanel();
        topPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        shoppincartButton = new JButton("Normal Shopping Cart");
        shoppincartButton.addActionListener(subscriptionListener);
        c.fill = GridBagConstraints.FIRST_LINE_START;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0;
        c.weighty = 0;
        topPanel.add(shoppincartButton, c);
        
        subscriptionLabel = new JLabel("Subscription");
        c.fill = GridBagConstraints.PAGE_START;
        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 0;
        topPanel.add(subscriptionLabel, c);
        
        blankLabel = new JLabel("");
        c.fill = GridBagConstraints.FIRST_LINE_END;
        c.gridx = 2;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 0;
        topPanel.add(blankLabel, c);
        
        content.add(topPanel);
        
        
        midPanel = new JPanel();
        midPanel.setLayout(new BoxLayout(midPanel, BoxLayout.Y_AXIS));
        scrollpane = new JScrollPane(midPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollpane.setPreferredSize(new Dimension(300, 250));
        content.add(scrollpane);
        
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

        SubscriptionView2 frame = new SubscriptionView2();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Subscription");
        frame.setSize(500,300);
    }
    
}
