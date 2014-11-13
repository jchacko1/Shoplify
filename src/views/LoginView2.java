package views;

import controllers.AccountController;
import models.AccountModel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.*;


public class LoginView2 extends JFrame {

    JPanel topPanel, midPanel, bottomPanel, bottomPanel2;
    JLabel loginLabel, usernameLabel, passwordLabel;
    JTextField usernameTF, passwordTF;
    JButton signupButton, okButton, cancelButton, forgotpasswordButton;
    String username, password;
    


    public LoginView2() {
        
        
        
        ActionListener okListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                username = usernameTF.getText();
                password = passwordTF.getText(); 
                System.out.println(username);
                System.out.println(password);
                dispose();
            }
   
        };
        
        ActionListener cancelListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
   
        };
        
        ActionListener signupListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrationView2 Registration2Frame = new RegistrationView2();
                Registration2Frame.setVisible(true);
                Registration2Frame.setSize(300,350);
            }
   
        };
        
        ActionListener forgotpasswordListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ForgetPasswordView ForgetpasswordView2Frame = new ForgetPasswordView();
                ForgetpasswordView2Frame.setVisible(true);
                ForgetpasswordView2Frame.setSize(300,200);
            }
   
        };
        
        
        
        Container content = getContentPane();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        

        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        content.add(topPanel);

        loginLabel = new JLabel("Login", SwingConstants.CENTER);
        topPanel.add(loginLabel);
        
        midPanel = new JPanel();
        midPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        usernameLabel = new JLabel("Username:");
        c.fill = GridBagConstraints.LINE_START;
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 0;
        c.gridy = 0;
        midPanel.add(usernameLabel, c);
        
        usernameTF = new JTextField();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 1;
        c.gridy = 0;
        midPanel.add(usernameTF, c);
        
        passwordLabel = new JLabel("Password:");
        c.fill = GridBagConstraints.LINE_START;
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 0;
        c.gridy = 1;
        midPanel.add(passwordLabel, c);
        
        passwordTF = new JTextField();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 1;
        c.gridy = 1;
        midPanel.add(passwordTF, c);
        
        content.add(midPanel);
        
        
        
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        
        okButton = new JButton("OK");
        okButton.addActionListener(okListener);
        bottomPanel.add(okButton);
        
        
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(cancelListener);
        bottomPanel.add(cancelButton);
        
        content.add(bottomPanel);
        
        bottomPanel2 = new JPanel();
        bottomPanel2.setLayout(new FlowLayout());
        
        signupButton = new JButton("Sign Up");
        signupButton.addActionListener(signupListener);
        bottomPanel2.add(signupButton);
        
        
        forgotpasswordButton = new JButton("Forgot my Password");
        forgotpasswordButton.addActionListener(forgotpasswordListener);
        bottomPanel2.add(forgotpasswordButton);
        
        content.add(bottomPanel2);

    }
    

    public static void main(String[] args) {

        LoginView2 frame = new LoginView2();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Login Page");
        frame.setSize(300,200);
        AccountModel accountModel = AccountController.getAccountWithLogin("login","password");
        if(accountModel != null){
            //the account exists
        }
    }

}
