package views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class AccountView2 extends JFrame{
    
    private JPanel topPanel, midPanel, bottomPanel, securityPanel, extraPanel;
    private JLabel signupLabel, firstnameLabel, lastnameLabel, emailLabel, 
            usernameLabel, passwordLabel, securityquestionLabel, blankLabel;
    private JTextField firstnameTF, lastnameTF, emailTF, passwordTF, securityTF;
    private JButton cancelButton, makechangeButton, historyButton, returnInfoButton,
            paymentInfoButton, reminderButton;
    private JComboBox combobox;
    
    String[] questionString = {"Question1", "Question2", "Question3"};
    
    
    public AccountView2() {
        
        ActionListener makechangeListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
   
        };
        
        ActionListener cancelListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
   
        };
        
        ActionListener historyListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                HistoryView2 HistoryView2Frame = new HistoryView2();
                HistoryView2Frame.setVisible(true);
                HistoryView2Frame.setSize(500,500);
            }
   
        };
        
        ActionListener reminderListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ReminderListView ReminderListFrame = new ReminderListView();
                ReminderListFrame.setVisible(true);
                ReminderListFrame.setSize(320,300);
            }
   
        };
        
        ActionListener paymentListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
   
        };
        
        ActionListener returnListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
   
        };
        
        Container content = getContentPane();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        
        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        signupLabel = new JLabel("Account Information");
        topPanel.add(signupLabel);
        content.add(topPanel);
        
        midPanel = new JPanel();
        midPanel.setLayout(new GridLayout (6,2));
        usernameLabel = new JLabel("yourUsername", SwingConstants.CENTER);
        midPanel.add(usernameLabel);
        blankLabel = new JLabel("");
        midPanel.add(blankLabel);
        passwordLabel = new JLabel("Password: ", SwingConstants.CENTER);
        midPanel.add(passwordLabel);
        passwordTF = new JTextField("Your password");
        midPanel.add(passwordTF);
        firstnameLabel = new JLabel("Firstname:", SwingConstants.CENTER);
        midPanel.add(firstnameLabel);
        firstnameTF = new JTextField("Your first name");
        midPanel.add(firstnameTF);
        lastnameLabel = new JLabel("Lastname:", SwingConstants.CENTER);
        midPanel.add(lastnameLabel);
        lastnameTF = new JTextField("Your last name");
        midPanel.add(lastnameTF);
        emailLabel = new JLabel("Email:", SwingConstants.CENTER);
        midPanel.add(emailLabel);
        emailTF = new JTextField("your email");
        midPanel.add(emailTF);
        securityquestionLabel = new JLabel("Security Question:", SwingConstants.CENTER);
        midPanel.add(securityquestionLabel);
        
        content.add(midPanel);
        
        securityPanel = new JPanel();
        securityPanel.setLayout(new GridLayout(1,1));
        combobox = new JComboBox(questionString);
        
        securityPanel.add(combobox);
        securityTF = new JTextField("Your security answer");
        securityPanel.add(securityTF); 
        content.add(securityPanel);
        
        extraPanel = new JPanel();
        extraPanel.setLayout(new FlowLayout());
        historyButton = new JButton("History");
        extraPanel.add(historyButton);
        historyButton.addActionListener(historyListener);
        reminderButton = new JButton("Reminder List");
        reminderButton.addActionListener(reminderListener);
        extraPanel.add(reminderButton);
        returnInfoButton = new JButton("Return Info");
        reminderButton.addActionListener(returnListener);
        extraPanel.add(returnInfoButton);
        paymentInfoButton = new JButton("Payment Info");
        reminderButton.addActionListener(paymentListener);
        extraPanel.add(paymentInfoButton);
        content.add(extraPanel);
        
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        makechangeButton = new JButton("Make Change");
        makechangeButton.addActionListener(makechangeListener);
        bottomPanel.add(makechangeButton);
        cancelButton = new JButton("Close");
        cancelButton.addActionListener(cancelListener);
        bottomPanel.add(cancelButton);
        content.add(bottomPanel);
        

    }
    
    public String getQuestionString() {
        return questionString[0];
    }
    
    
    public static void main(String[] args) {

        AccountView2 frame = new AccountView2();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Account");
        frame.setSize(350,450);
    }
    
}


