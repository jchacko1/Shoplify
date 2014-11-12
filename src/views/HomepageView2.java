
package views;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.*;

public class HomepageView2 extends JFrame{
    
    private JLabel categoryLabel, deli, seafood, meat, vegetable, bakery, total;
    private JPanel topPanel, categoryPanel, historyPanel, reminderlistPanel;
    private JTextField searchTF;
    private JButton searchButton, loginSignupButton, couponButton, checkoutButton;
    private Border border;
    private JScrollPane historypane, reminderlistpane;
   
    
    public HomepageView2() {
        
        Container content = getContentPane();
        content.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        topPanel = new JPanel();
        //c.fill = GridBagConstraints.NORTH;
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 0;
        c.gridy = 0;
        content.add(topPanel, c);
        
        searchTF = new JTextField("Search Field");
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 1;
        c.gridy = 0;
        content.add(searchTF, c);
        
        searchButton = new JButton("Search");
        //c.fill = GridBagConstraints.LINE_END;
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 2;
        c.gridy = 0;
        content.add(searchButton, c);
        
        loginSignupButton = new JButton("Login/Signup");
        //c.fill = GridBagConstraints.FIRST_LINE_END;
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 3;
        c.gridy = 0;
        content.add(loginSignupButton, c);

        categoryPanel = new JPanel();
        //c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;
        c.gridheight = 6;
        c.gridx = 0;
        c.gridy = 2;
        content.add(categoryPanel, c);
        categoryPanel.setLayout(new GridLayout(6,1));
        
        //border = BorderFactory.createLineBorder(Color.black);
        //categoryPanel.setBorder(border);
        
        categoryLabel = new JLabel("Categories");
        categoryPanel.add(categoryLabel);
        
        deli = new JLabel("deli");
        categoryPanel.add(deli);
        
        seafood = new JLabel("seafood");
        categoryPanel.add(seafood);
       
        meat = new JLabel("meat");
        categoryPanel.add(meat);
        
        vegetable = new JLabel("vegetable");
        categoryPanel.add(vegetable);
        
        bakery = new JLabel("bakery");
        categoryPanel.add(bakery);
        
        historyPanel = new JPanel();
        historyPanel.setLayout(new BoxLayout(historyPanel, BoxLayout.X_AXIS));
        historypane = new JScrollPane(historyPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        //c.fill = GridBagConstraints.FIRST_LINE_END;
        c.weightx = 1;
        c.weighty = 1;
        c.gridheight = 3;
        c.gridwidth = 3;
        c.gridx = 1;
        c.gridy = 1;
        content.add(historypane, c);
        
        reminderlistPanel = new JPanel();
        reminderlistPanel.setLayout(new BoxLayout(reminderlistPanel, BoxLayout.X_AXIS));
        reminderlistpane = new JScrollPane(reminderlistPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        //c.fill = GridBagConstraints.FIRST_LINE_END;
        c.weightx = 1;
        c.weighty = 1;
        c.gridheight = 3;
        c.gridwidth = 3;
        c.gridx = 1;
        c.gridy = 4;
        content.add(reminderlistpane, c);
     

        
    }
    
    public static void main(String[] args) {

        HomepageView2 frame = new HomepageView2();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Homepage");
        frame.setSize(1000,500);
    }
    
}
