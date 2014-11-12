package views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class RegistrationView2 extends JFrame{
    
    private JPanel topPanel, midPanel, bottomPanel, securityPanel, securityPanel2;
    private JLabel signupLabel, firstnameLabel, lastnameLabel, emailLabel, 
            usernameLabel, passwordLabel, securityquestionLabel, securityLabel;
    private JTextField firstnameTF, lastnameTF, emailTF, usernameTF, passwordTF, securityTF;
    private JButton signupButton, cancelButton;
    private JComboBox combobox;
    
    String[] questionString = {"Question1", "Question2", "Question3"};
    
    
    public RegistrationView2() {
        
        ActionListener signupListener = new ActionListener() {

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
        
        securityPanel = new JPanel();
        securityPanel.setLayout(new FlowLayout());
        securityquestionLabel = new JLabel("Pick your security qustion for password recovery", SwingConstants.CENTER);
        securityPanel.add(securityquestionLabel);
        content.add(securityPanel);

        securityPanel2 = new JPanel();
        securityPanel2.setLayout(new GridLayout(1,1));
        combobox = new JComboBox(questionString);
        
        securityPanel2.add(combobox);
        securityTF = new JTextField();
        securityPanel2.add(securityTF); 
        content.add(securityPanel2);
        
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        signupButton = new JButton("Sign Up");
        signupButton.addActionListener(signupListener);
        bottomPanel.add(signupButton);
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(cancelListener);
        bottomPanel.add(cancelButton);
        content.add(bottomPanel);
        

    }
    
    public String getQuestionString() {
        return questionString[0];
    }
    
    
    public static void main(String[] args) {

        RegistrationView2 frame = new RegistrationView2();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Registration");
        frame.setSize(320,300);
    }
    
}


