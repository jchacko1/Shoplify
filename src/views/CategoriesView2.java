
package views;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CategoriesView2 extends JFrame{

    private JLabel categoryLabel, deli, seafood, meat, vegetable, bakery, shapeLabel,
            colorLabel;
    private JPanel topPanel, categoryPanel, categorySubPanel1, categorySubPanel2,
            categorySubPanel3, categorySubPanel4, categorySubPanel5;
    private JTextField searchTF;
    private JButton searchButton, loginSignupButton;


    public CategoriesView2() {

        ActionListener loginViewPopup = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                LoginView2 LoginView2Frame = new LoginView2();
                LoginView2Frame.setVisible(true);
                LoginView2Frame.setSize(500,150);

            }

        };

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
        loginSignupButton.addActionListener(loginViewPopup);


        categoryLabel = new JLabel("Categories");
        c.fill = GridBagConstraints.LINE_START;
        c.weightx = 2;
        c.weighty = 1;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 1;
        content.add(categoryLabel, c);



        categoryPanel = new JPanel();
        c.fill = GridBagConstraints.LINE_START;
        c.weightx = 2;
        c.weighty = 1;
        c.gridwidth = 2;
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


        shapeLabel = new JLabel("Shape");
        c.fill = GridBagConstraints.CENTER;
        c.weightx = 1;
        c.weighty = 1;
        c.gridwidth = 1;
        c.gridx = 2;
        c.gridy = 1;
        content.add(shapeLabel, c);



        colorLabel = new JLabel("Color");
        c.fill = GridBagConstraints.LINE_END;
        c.weightx = 1;
        c.weighty = 1;
        c.gridwidth = 1;
        c.gridx = 3;
        c.gridy = 1;
        content.add(colorLabel, c);


    }

    public static void main(String[] args) {

        CategoriesView2 frame = new CategoriesView2();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Categories");
        frame.setSize(500,300);
    }

}
