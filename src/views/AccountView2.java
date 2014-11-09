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

public class AccountView2 extends JFrame implements ActionListener{

    private JPanel iconPane;
    //private JPanel searchPan;
    private JPanel topPane;
    private JPanel accountListPane;
    private JPanel historyListPane;
    private JPanel returnInfoPane;
    private JPanel paymentInfoPane;

    private JButton loginBtn;
    private JButton okBtn;
    private JButton searchBtn;

    private JLabel accountInfoLabel;
    private JLabel historyInfoLabel;
    private JLabel returnInfoLabel;
    private JLabel paymentInfoLabel;

    private JTextField searchField;

    private GridBagConstraints c;

    private JTextArea accountNameList;
    private JTextArea passwordList;
    private JTextArea subscriptionList;
    private JTextArea detailsList;
    private JTextArea bakeryList;

    //private LoginView loginView;

    public AccountView2() {
        this.iconPane = new JPanel();
        this.topPane = new JPanel();
        this.loginBtn = new JButton("Login/SignUp");
        this.searchBtn = new JButton("Search");
        this.okBtn = new JButton("OK");
        this.searchField = new JTextField("Search field");
        this.c = new GridBagConstraints();
        this.accountInfoLabel = new JLabel("Account Info");
        this.historyInfoLabel = new JLabel();
        this.returnInfoLabel = new JLabel();
        this.paymentInfoLabel = new JLabel();
        this.accountListPane = new JPanel();
        //this.accountNameList = new JList();
        this.historyListPane = new JPanel();
        this.historyInfoLabel = new JLabel("History");
        this.paymentInfoPane = new JPanel();
        this.paymentInfoLabel = new JLabel("Payment info");
        this.returnInfoPane = new JPanel();
        this.returnInfoLabel = new JLabel("Return Info");
        this.accountNameList = new JTextArea("account name");
        this.passwordList = new JTextArea("password list");
        this.subscriptionList = new JTextArea("subscription list");
        this.detailsList = new JTextArea("detail list");
        this.bakeryList = new JTextArea("bakery");


        //this.loginView = new LoginView();

    }

    public void init() {

        setTitle("Account View");
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

        //1st column for account info list
        c.fill = GridBagConstraints.LINE_START;
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 0;
        c.gridy =1;
        add(accountListPane,c);
        accountListPane.setLayout(new BoxLayout(accountListPane, BoxLayout.Y_AXIS));
        accountListPane.add(accountInfoLabel);
       // accountNameList.setSize(150, 50);
        accountListPane.add(accountNameList);
        accountListPane.add(passwordList);
        accountListPane.add(subscriptionList);
        accountListPane.add(detailsList);
        accountListPane.add(bakeryList);

        c.fill = GridBagConstraints.CENTER;
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 1;
        c.gridy = 1;
        add(historyListPane,c);
        historyListPane.setLayout(new BoxLayout(historyListPane, BoxLayout.Y_AXIS));
        historyListPane.add(historyInfoLabel);


        c.weightx = 1;
        c.weightx = 0;
        c.gridx = 2;
        c.gridy = 1;
        add(returnInfoPane, c);
        returnInfoPane.setLayout(new BoxLayout(returnInfoPane, BoxLayout.Y_AXIS));
        returnInfoPane.add(returnInfoLabel);

        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 3;
        c.gridy = 1;
        add(paymentInfoPane, c);
        paymentInfoPane.setLayout(new BoxLayout(paymentInfoPane, BoxLayout.Y_AXIS));
        paymentInfoPane.add(paymentInfoLabel);


       // c.fill = GridBagConstraints.

        loginBtn.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args){
        AccountView2 account = new AccountView2();
        account.init();
       // windows.addActionListeners();
    }
}