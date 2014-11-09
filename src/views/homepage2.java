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

public class homepage2 extends JFrame{

    private JPanel topPane;
    private JButton loginBtn;
    private JButton buttonOK;
    private JTextField searchField;
    private JButton searchBtn;
    private JLabel homeLabel;
    private JPanel homePane;
    private JPanel category;
    private JPanel adBannerPanel;
    private JTextArea advertismentsAndBannersTextArea;
    private JLabel categoryLabel1;
    private JLabel categoryLabel2;
    private JLabel categoryLabel3;
    private JLabel categoryLabel4;
    private JLabel ad;
    private JList Deli;
    private JList Meat;
    private JList Seafood;
    private JList Vegetable;
    private JList Bakery;
    private Border blackline;
    private GridBagConstraints c;



    //private LoginView loginView;

    public homepage2() {
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

    }

    public void init() {

        setTitle("Homepage");
        setLayout(new GridBagLayout());
        setSize(1000,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //top panel for icon
        c.fill = GridBagConstraints.NORTH;
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 0;
        c.gridy = 0;
        add(topPane, c);

        //search field
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 1;
        c.gridy = 0;
        add(searchField, c);

        //search button
        c.fill = GridBagConstraints.LINE_END;
        c.weightx = 0.5;
        c.weighty = 0;
        c.gridx = 2;
        c.gridy = 0;
        add(searchBtn, c);

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
        add(adBannerPanel, c);
        adBannerPanel.setBorder(blackline);
        adBannerPanel.add(ad);

        // c.fill = GridBagConstraints.

     //   loginBtn.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args){
        homepage2 account = new homepage2();
        account.init();
        // windows.addActionListeners();
    }
}