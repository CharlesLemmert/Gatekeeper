/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.loginverification;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 * GateKeeper Login Verification code demo
 *
 * @author Charles Moses Lemmert Student Number: 220498385
 */
public class BasicLoginGUI extends JFrame  implements ActionListener{

    private String username;
    private String password;
    //--------------------------------------------------------------------------J Labels and Textfields
    private JLabel lblUsername;
    private JTextField txtUsername;

    private JLabel lblPassword;
    private JPasswordField txtPassword;

    private JButton btnLogin;
    private JButton btnRegister;
    private JLabel lblSuccessfullLogin;

    //--------------------------------------------------------------------------Login Constructor
    public BasicLoginGUI() {

        //---------------------------------------------------Username label and textfield
        lblUsername = new JLabel("Username: ");
        txtUsername = new JTextField(15);

        //---------------------------------------------------Password label and textfield
        lblPassword = new JLabel("Password: ");
        txtPassword = new JPasswordField(15);

        //---------------------------------------------------Login button & Registration button
        btnLogin = new JButton("Login");
        btnRegister = new JButton("Register");

        //---------------------------------------------------Successfull login message box
        lblSuccessfullLogin = new JLabel("");
    }

    //--------------------------------------------------------------------------Demo GUI layout for Login and Registration test
    public void startGUI() {

        //---------------------------------------------------Creating window and setting window Size
        JFrame window = new JFrame("Login Demo");
        window.setSize(480, 400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //---------------------------------------------------Creating panel to place textfields and labels in
        JPanel borders = new JPanel();
        window.add(borders);
        borders.setLayout(null);

        //---------------------------------------------------positioning Username label and textfield
        lblUsername.setBounds(150, 70, 80, 25);
        borders.add(lblUsername);
        txtUsername.setBounds(150, 100, 165, 25);
        borders.add(txtUsername);

        //---------------------------------------------------positioning Password label and textfield
        lblPassword.setBounds(150, 130, 80, 25);
        borders.add(lblPassword);
        txtPassword.setBounds(150, 160, 165, 25);
        borders.add(txtPassword);

        //---------------------------------------------------positioning login button and adding action listener
        btnLogin.setBounds(190, 200, 80, 25);
        borders.add(btnLogin);

        //---------------------------------------------------positioning  Submit button 
        btnRegister.setBounds(185, 230, 90, 25);
        borders.add(btnRegister);

        //---------------------------------------------------positioning successfull login box
        lblSuccessfullLogin.setBounds(10, 110, 300, 25);
        borders.add(lblSuccessfullLogin);

        window.setLocationRelativeTo(null);
        window.setVisible(true);
        //---------------------------------------------------Action Listener onclick functionality implemented here:Open Register form and login form

        btnLogin.addActionListener(this);

        //--------------------------------------------------------------------------Registration button
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == btnRegister) {
                    window.setVisible(false);
                    RegistrationDemo resgistrationW = new RegistrationDemo();
                    resgistrationW.startGUI();

                }

            }
        });
    }

    //---------------------------------------------------Action event onclick functionality implemented here:Verify Login information
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {
            RegistrationDemo caller = new RegistrationDemo();
            caller.numberOfLines();
            caller.validatingData(txtUsername.getText(),txtPassword.getText());
            txtUsername.setText("");
            txtPassword.setText("");
        }
    }
        //---------------------------------------------------main function calls starter method to run program
    public void starter() {
        new BasicLoginGUI().startGUI();

    }

}
