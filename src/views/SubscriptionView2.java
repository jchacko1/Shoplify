package views;

import javax.swing.*;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class SubscriptionView2 extends JFrame implements ActionListener{

    private JPanel iconPane;
    //private JPanel searchPan;
    private JPanel topPane;
    private JPanel categoriesPane;
    private JPanel calculatePane;

    private JButton loginBtn;
    private JButton okBtn;
    private JButton searchBtn;
    private JButton couponBtn;
    private JButton checkoutBtn;


    private JLabel totalNumLabel;
    private JLabel categoryLabel;

    private JTextField searchField;
    private JTextField totalAmountField;

    private GridBagConstraints c;

    private JTextArea deliList;
    private JTextArea seafoodList;
    private JTextArea meatList;


    //private LoginView loginView;

    public SubscriptionView2() {
        this.iconPane = new JPanel();
        this.topPane = new JPanel();
        this.loginBtn = new JButton("Login/SignUp");
        this.searchBtn = new JButton("Search");
        this.okBtn = new JButton("OK");
        this.searchField = new JTextField("Search field");
        this.c = new GridBagConstraints();
        this.categoriesPane = new JPanel();
        this.categoryLabel = new JLabel("Categories");
        this.deliList = new JTextArea();
        this.seafoodList = new JTextArea();
        this.meatList = new JTextArea();
        this.calculatePane = new JPanel();
        this.totalAmountField = new JTextField("number");
        this.couponBtn = new JButton("Coupon");
        this.checkoutBtn = new JButton("Check Out");
        this.totalNumLabel = new JLabel("Total");


        //this.loginView = new LoginView();

    }

    public void init() {

        setTitle("Subscription View");
        setLayout(new GridBagLayout());
        setSize(500,500);
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

        //1st column for category info list
        c.fill = GridBagConstraints.LINE_START;
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 1;
        add(categoryLabel, c);

        c.fill = GridBagConstraints.FIRST_LINE_START;
        c.weightx = 1;
        c.weighty = 5;
        c.gridx = 0;
        c.gridy = 2;
        add(categoriesPane,c);
        categoriesPane.setLayout(new BoxLayout(categoriesPane, BoxLayout.Y_AXIS));
        categoriesPane.add(deliList);
        categoriesPane.add(seafoodList);
        categoriesPane.add(meatList);
        deliList.setText("Deli");
        seafoodList.setText("Seafood");
        meatList.setText("Meat");

        c.fill = GridBagConstraints.LAST_LINE_END;
        c.weightx = 1;
        c.weighty = 5;
        c.gridx = 3;
        c.gridy = 2;
        add(calculatePane, c);
        calculatePane.setLayout(new BoxLayout(calculatePane, BoxLayout.Y_AXIS));
        calculatePane.add(totalNumLabel);
        calculatePane.add(totalAmountField);
        calculatePane.add(couponBtn);
        calculatePane.add(checkoutBtn);

        loginBtn.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(loginBtn.getModel().isArmed()){

        }
    }

    public static void main(String[] args){
        SubscriptionView2 subscription = new SubscriptionView2();
        subscription.init();
        // windows.addActionListeners();
    }
}