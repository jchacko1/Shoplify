package views;

import businessLogic.AccountManager;
import controllers.AccountController;
import global.Global;
import models.AccountModel;

import javax.swing.*;
import java.awt.event.*;

public class LoginView extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField usernameText;
    private JPasswordField passwordText;
    private JButton signupBtn;
    private JPanel signupPanel;

    public LoginView() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

// call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

// call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
// add your code here
        dispose();
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    public boolean verifyAccountWithLogin(String login, String password)
    {
        AccountModel accountModel = AccountController.getAccountWithLogin(login, password);
        if(accountModel != null)
        {
            Global.currentAccount = accountModel;
            //do something with the data on the account
            return true;
        }
        else
        {
            //we did not find an account with this login and password
            return false;
        }
    }

    public static void main(String[] args) {
        LoginView dialog = new LoginView();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
