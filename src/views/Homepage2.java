package views;


import models.Enums;
import models.ItemModel;

import javax.swing.*;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.*;

//TODO: Need ReminderList GUI
public class Homepage2 extends JFrame{

    private JPanel topPane;
    private JButton loginBtn, buttonOK, searchBtn, categoryLabel1, categoryLabel2,
            categoryLabel3, categoryLabel4;
    private JTextField searchField;
    private JLabel homeLabel, ad;
    private JPanel homePane, category, adBannerPanel, cat;
    private JTextArea advertismentsAndBannersTextArea;
    private JList Deli,Meat,Seafood,Vegetable,Bakery;
    private Border blackline;
    private Container content;
    private GridBagConstraints c;

    public Homepage2() {
        ActionListener listener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cat = new JPanel();
                GridBagConstraints c = new GridBagConstraints();
                content = getContentPane();
                content.remove(adBannerPanel);
                c.fill = GridBagConstraints.BOTH;
                c.weightx = 1;
                c.weighty = 1;
                c.gridwidth = 3;
                c.gridx = 1;
                c.gridy = 1;
                content.add(cat, c);
                cat.setBorder(blackline);
                validate();
                repaint();

            }


        };

        Container content = getContentPane();
        content.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();


        topPane = new JPanel();
        category = new JPanel();
        homePane = new JPanel();
        adBannerPanel = new JPanel();

        homeLabel = new JLabel("Shoplify");
        ad = new JLabel("Some ad goes here");

        loginBtn = new JButton("Login/SignUp");
        searchBtn = new JButton("Search");
        categoryLabel1 = new JButton("Meat");
        categoryLabel1.setBorderPainted(false);
        categoryLabel1.addActionListener(listener);
        categoryLabel2 = new JButton("Some category 2");
        categoryLabel3 = new JButton("Some category 3");
        categoryLabel4 = new JButton("Some category 4");

        searchField = new JTextField("Search field");

        blackline = BorderFactory.createLineBorder(Color.black);


        //top panel for icon
        c.fill = GridBagConstraints.NORTH;
        c.weightx = 0;
        c.weighty = 0;
        c.gridx = 0;
        c.gridy = 0;
        content.add(homeLabel, c);
        homeLabel.setBorder(blackline);

        //search field
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 1;
        c.gridy = 0;
        content.add(searchField, c);

        //search button
        c.fill = GridBagConstraints.LINE_END;
        c.weightx = 0.5;
        c.weighty = 0;
        c.gridx = 2;
        c.gridy = 0;
        content.add(searchBtn, c);

        //login button
        c.fill = GridBagConstraints.FIRST_LINE_END;
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 3;
        c.gridy = 0;
        add(loginBtn, c);

        //end of top panel//


        //1st column for account info list
        c.fill = GridBagConstraints.LINE_START;
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 0;
        c.gridy =0;
        add(homeLabel,c);
//        homePane.setLayout(new BoxLayout(homePane, BoxLayout.Y_AXIS));
//        homePane.add(homeLabel);

        //category field
        c.fill = GridBagConstraints.VERTICAL;
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 1;
        add(category, c);
        category.setBorder(blackline);
        category.setLayout(new BoxLayout(category, BoxLayout.Y_AXIS));
        category.add(categoryLabel1);

        category.add(categoryLabel2);
        category.add(categoryLabel3);
        category.add(categoryLabel4);

        //Advertisment panel
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;
        c.gridwidth = 3;
        c.gridx = 1;
        c.gridy = 1;
        content.add(adBannerPanel, c);
        adBannerPanel.setBorder(blackline);
        adBannerPanel.add(ad);
        // c.fill = GridBagConstraints.

     //   loginBtn.addActionListener(this);

    }


    public static void main(String[] args){
        Homepage2 hp = new Homepage2();
        hp.setTitle("Homepage");
        hp.setSize(1000, 500);
        hp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hp.setVisible(true);

//        Enums.Category
        // windows.addActionListeners();
//        for (Enums dir : Enum.values()) {
            // do what you want
//        }



    }
}