package views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Registration2 extends JFrame{
    
    private JPanel topPanel, midPanel, bottomPanel;
    private JLabel signupLabel, firstnameLabel, lastnameLabel, emailLabel, 
            usernameLabel, passwordLabel;
    private JTextField firstnameTF, lastnameTF, emailTF, usernameTF, passwordTF;
    private JButton signupButton, cancelButton;
    
    
    public Registration2() {
        
        Container content = getContentPane();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        
        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        signupLabel = new JLabel("Sign Up");
        topPanel.add(signupLabel);
        content.add(topPanel);
        
        midPanel = new JPanel();
        midPanel.setLayout(new GridLayout (5,2));
        firstnameLabel = new JLabel("Firstname:", SwingConstants.CENTER);
        midPanel.add(firstnameLabel);
        firstnameTF = new JTextField();
        midPanel.add(firstnameTF);
        lastnameLabel = new JLabel("Lastname:", SwingConstants.CENTER);
        midPanel.add(lastnameLabel);
        lastnameTF = new JTextField();
        midPanel.add(lastnameTF);
        emailLabel = new JLabel("Email:", SwingConstants.CENTER);
        midPanel.add(emailLabel);
        emailTF = new JTextField();
        midPanel.add(emailTF);
        usernameLabel = new JLabel("Username:", SwingConstants.CENTER);
        midPanel.add(usernameLabel);
        usernameTF = new JTextField();
        midPanel.add(usernameTF);
        passwordLabel = new JLabel("Password:", SwingConstants.CENTER);
        midPanel.add(passwordLabel);
        passwordTF = new JTextField();
        midPanel.add(passwordTF);      
        content.add(midPanel);
        
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        signupButton = new JButton("Sign Up");
        bottomPanel.add(signupButton);
        cancelButton = new JButton("Cancel");
        bottomPanel.add(cancelButton);
        content.add(bottomPanel);
        

    }
    
    
    public static void main(String[] args) {

        Registration2 frame = new Registration2();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Registration");
        frame.setSize(300,300);
    }
    
}


