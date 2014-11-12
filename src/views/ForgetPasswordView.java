
package views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.*;


public class ForgetPasswordView extends JFrame {

    JPanel topPanel, midPanel, midPanel2, bottomPanel;
    JLabel passwordRecoveryLabel,usernameLabel, securityQuestionLabel, passwordLabel;
    JTextField usernameTF, passwordTF;
    JButton submitButton, cancelButton;
    String username, password;
    
    RegistrationView2 object = new RegistrationView2();
    


    public ForgetPasswordView() {
        
        ActionListener cancelListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                 dispose();
            }
   
        };
        
        
        ActionListener submitListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                passwordLabel.setText("Your password");
            }
   
        };
        

        Container content = getContentPane();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        

        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        content.add(topPanel);

        passwordRecoveryLabel = new JLabel("Password Recovery", SwingConstants.CENTER);
        topPanel.add(passwordRecoveryLabel);
        
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
        
        securityQuestionLabel = new JLabel(object.getQuestionString());
        c.fill = GridBagConstraints.LINE_START;
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 0;
        c.gridy = 1;
        midPanel.add(securityQuestionLabel, c);
        
        passwordTF = new JTextField();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.weighty = 0;
        c.gridx = 1;
        c.gridy = 1;
        midPanel.add(passwordTF, c);
        
        content.add(midPanel);
        
        midPanel2 = new JPanel();
        
        passwordLabel = new JLabel("");
        midPanel2.add(passwordLabel);
        content.add(midPanel2);
        
        
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        
        submitButton = new JButton("Submit");
        submitButton.addActionListener(submitListener);
        bottomPanel.add(submitButton);
        
        cancelButton = new JButton("Close");
        cancelButton.addActionListener(cancelListener);
        bottomPanel.add(cancelButton);
        content.add(bottomPanel);
        
        
        

    }

    public static void main(String[] args) {

        ForgetPasswordView frame = new ForgetPasswordView();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Forget my password");
        frame.setSize(300,200);
    }

}
