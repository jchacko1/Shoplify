import javax.swing.*;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
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

    private JButton loginBtn;
    private JButton okBtn;
    private JButton searchBtn;

    private JLabel accountInfoLabel;
    private JLabel historyInfoLabel;
    private JLabel returnInfoLabel;
    private JLabel paymentInfoLabel;

    private JTextField searchField;

    private GridBagConstraints c;

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

        //this.loginView = new LoginView();

    }

    public void init() {

        setTitle("Account View");
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
        c.gridy =1;
        add(accountListPane,c);
        accountListPane.setLayout(new BoxLayout(accountListPane, BoxLayout.Y_AXIS));
        accountListPane.add(accountInfoLabel);




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