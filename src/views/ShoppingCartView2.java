
package views;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ShoppingCartView2 extends JFrame{
    
    private JLabel categoryLabel, deli, seafood, meat, vegetable, bakery, total, price;
    private JPanel topPanel, categoryPanel, categorySubPanel1, categorySubPanel2, 
            categorySubPanel3, categorySubPanel4, categorySubPanel5, itemlistPanel, 
            totalPanel;
    private JTextField searchTF;
    private JButton searchButton, loginSignupButton, couponButton, checkoutButton;
   
    
    public ShoppingCartView2() {
        
        Container content = getContentPane();
        content.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        topPanel = new JPanel();
        c.fill = GridBagConstraints.NORTH;
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 0;
        c.gridy = 0;
        content.add(topPanel, c);
        
        searchTF = new JTextField("Search Field");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 1;
        c.gridy = 0;
        content.add(searchTF, c);
        
        searchButton = new JButton("Search");
        c.fill = GridBagConstraints.LINE_END;
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 2;
        c.gridy = 0;
        content.add(searchButton, c);
        
        loginSignupButton = new JButton("Login/Signup");
        c.fill = GridBagConstraints.FIRST_LINE_END;
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 3;
        c.gridy = 0;
        content.add(loginSignupButton, c);
        
        
        categoryLabel = new JLabel("Categories");
        c.fill = GridBagConstraints.LINE_START;
        c.weightx = 0;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 1;
        content.add(categoryLabel, c);
        
        
        categoryPanel = new JPanel();
        c.fill = GridBagConstraints.LINE_START;
        c.weightx = 1;
        c.weighty = 3;
        c.gridx = 0;
        c.gridy = 2;
        content.add(categoryPanel, c);
        categoryPanel.setLayout(new GridLayout(5,1));
        
       
        
        categorySubPanel1 = new JPanel();
        deli = new JLabel("Deli");
        categorySubPanel1.add(deli);
        categoryPanel.add(categorySubPanel1);
        
        categorySubPanel2 = new JPanel();
        seafood = new JLabel("Seafood");
        categorySubPanel2.add(seafood);
        categoryPanel.add(categorySubPanel2);
        
        categorySubPanel3 = new JPanel();
        meat = new JLabel("Meat");
        categorySubPanel3.add(meat);
        categoryPanel.add(categorySubPanel3);
        
        
        categorySubPanel4 = new JPanel();
        vegetable = new JLabel("Vegetable");
        categorySubPanel4.add(vegetable);
        categoryPanel.add(categorySubPanel4);
        
        categorySubPanel5 = new JPanel();
        bakery = new JLabel("Bakery");
        categorySubPanel5.add(bakery);
        categoryPanel.add(categorySubPanel5);
        
        
        itemlistPanel = new JPanel();
        c.fill = GridBagConstraints.CENTER;
        c.weightx = 1;
        c.weighty = 3;
        c.gridheight = 2;
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 1;
        content.add(itemlistPanel, c);
        itemlistPanel.setLayout(new BoxLayout(itemlistPanel, BoxLayout.Y_AXIS));
        
        totalPanel = new JPanel();
        c.fill = GridBagConstraints.LINE_END;
        c.weightx = 1;
        c.weighty = 3;
        c.gridx = 3;
        c.gridy = 2;
        content.add(totalPanel, c);
        totalPanel.setLayout(new GridLayout(4,1));
        
        total = new JLabel("Total: ");
        totalPanel.add(total);
        
        price = new JLabel("150");
        totalPanel.add(price);
        
        couponButton = new JButton("Coupon");
        totalPanel.add(couponButton);
        
        checkoutButton = new JButton("Checkout");
        totalPanel.add(checkoutButton);
        
        
        
        
        
    }
    
    public static void main(String[] args) {

        ShoppingCartView2 frame = new ShoppingCartView2();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Shopping Cart");
        frame.setSize(500,500);
    }
    
}
