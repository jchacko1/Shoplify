
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.*;

public class LoginView2 extends JFrame {

    JPanel topPanel, midPanel, bottomPanel;
    JLabel loginLabel;
    JTextField usernameTF, passwordTF;
    JButton signupButton, okButton, cancelButton;


    public LoginView2() {
        
        Container content = getContentPane();
        content.setLayout(new GridLayout(3,1));
        

        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(1,1));
        content.add(topPanel);

        loginLabel = new JLabel("Login", SwingConstants.CENTER);
        topPanel.add(loginLabel);
        
        midPanel = new JPanel();
        midPanel.setLayout(new GridLayout(2,1,3,3));
        
        usernameTF = new JTextField();
        midPanel.add(usernameTF);
        
        passwordTF = new JTextField();
        midPanel.add(passwordTF);
        content.add(midPanel);
        
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1,3));
        
        signupButton = new JButton("Sign Up");
        bottomPanel.add(signupButton);
        
        okButton = new JButton("OK");
        bottomPanel.add(okButton);
        
        cancelButton = new JButton("Cancel");
        bottomPanel.add(cancelButton);
        content.add(bottomPanel);
        
           

    }

    public static void main(String[] args) {

        LoginView2 frame = new LoginView2();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Login Page");
        frame.setSize(300,150);
    }

}
