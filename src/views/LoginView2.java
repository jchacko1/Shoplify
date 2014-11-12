
package views;

import controllers.OrderController;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.*;


public class LoginView2 extends JFrame {

    JPanel topPanel, midPanel, bottomPanel;
    JLabel loginLabel, usernameLabel, passwordLabel;
    JTextField usernameTF, passwordTF;
    JButton signupButton, okButton, cancelButton;
    String username, password;
    


    public LoginView2() {
        
        ActionListener listener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                username = usernameTF.getText();
                password = passwordTF.getText(); 
                System.out.println(username);
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
        
        signupButton = new JButton("Sign Up");
        bottomPanel.add(signupButton);
        
        okButton = new JButton("OK");
        okButton.addActionListener(listener);
        bottomPanel.add(okButton);
        
        
        cancelButton = new JButton("Cancel");
        bottomPanel.add(cancelButton);
        content.add(bottomPanel);


    }

    public static void main(String[] args) throws ClassNotFoundException {

        LoginView2 frame = new LoginView2();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Login Page");
        frame.setSize(300,150);

        OrderController.testSql();

    }

}
