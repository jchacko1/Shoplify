package views;


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

public class Homepage2 extends JFrame {

    private JPanel topPane, homePane, category, adBannerPanel;
    private JButton loginBtn, buttonOK, searchBtn;
    private JTextField searchField;
    private JTextArea advertismentsAndBannersTextArea;
    private JLabel homeLabel, categoryLabel1,categoryLabel2, categoryLabel3, categoryLabel4, ad;
    private JList Deli, Meat, Seafood, Vegetable, Bakery;
    private Border blackline;
    private GridBagConstraints c;


    //private LoginView loginView;

    public Homepage2() {

        ActionListener loginViewPopup = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            LoginView2 LoginView2Frame = new LoginView2();
            LoginView2Frame.setVisible(true);
            LoginView2Frame.setSize(500, 150);

            }

        };

        Container content = getContentPane();
        content.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        //this.contentPane = new JPanel();
        this.topPane = new JPanel();
        this.category = new JPanel();
        this.homeLabel = new JLabel("Shoplify");
        this.loginBtn = new JButton("Login/SignUp");
        this.searchBtn = new JButton("Search");
        this.searchField = new JTextField("Search field");
        this.c = new GridBagConstraints();
        this.homePane = new JPanel();
        this.adBannerPanel = new JPanel();
        this.categoryLabel1 = new JLabel("Some category 1");
        this.categoryLabel2 = new JLabel("Some category 2");
        this.categoryLabel3 = new JLabel("Some category 3");
        this.categoryLabel4 = new JLabel("Some category 4");
        this.ad = new JLabel("Some ad goes here");
        this.blackline = BorderFactory.createLineBorder(Color.black);


        //this.loginView = new LoginView();


        //top panel for icon
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0;
        c.weighty = 0;
        c.gridx = 0;
        c.gridy = 0;
        content.add(topPane, c);

//1st column for account info list
        c.fill = GridBagConstraints.LINE_START;
        c.weightx = 0;
        c.weighty = 0;
        c.gridx = 0;
        c.gridy = 0;
        topPane.add(homeLabel, c);
//        homePane.setLayout(new BoxLayout(homePane, BoxLayout.Y_AXIS));
//        homePane.add(homeLabel);

        //search field
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 1;
        c.gridy = 0;
        topPane.add(searchField, c);

        //search button
        c.fill = GridBagConstraints.LINE_END;
        c.weightx = 0.5;
        c.weighty = 0;
        c.gridx = 2;
        c.gridy = 0;
        topPane.add(searchBtn, c);

        //login button
        c.fill = GridBagConstraints.FIRST_LINE_END;
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 3;
        c.gridy = 0;
        topPane.add(loginBtn, c);
        loginBtn.addActionListener(loginViewPopup);

        //end of top panel//

        //catigory panel for icon
        c.fill = GridBagConstraints.VERTICAL;
        c.weightx = 0;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 1;
        content.add(category, c);



        //category field
//        c.fill = GridBagConstraints.VERTICAL;
//        c.weightx = 1;
//        c.weighty = 1;
//        c.gridx = 0;
//        c.gridy = 1;
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

    public static void main(String[] args) {

        Homepage2 account = new Homepage2();
        account.setTitle("Homepage");
        account.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        account.setSize(1000, 500);
        account.setVisible(true);
        // windows.addActionListeners();
    }
}