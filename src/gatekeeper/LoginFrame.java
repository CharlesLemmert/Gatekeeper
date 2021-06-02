/* Group 24
   Group Leader: 216049245 - Brandon Kruger
   Group Member(s): 
 */

package gatekeeper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
    
public class LoginFrame extends JFrame implements ActionListener {
    Container container=getContentPane();
    JLabel userLabel=new JLabel("Username");
    JLabel passwordLabel=new JLabel("Password");
    JTextField userTextField=new JTextField();
    JPasswordField passwordField=new JPasswordField();
    JButton loginButton=new JButton("Login");
    JButton resetButton=new JButton("Reset");
    JButton registerButton=new JButton("Register");
    JCheckBox showPassword=new JCheckBox("Show Password");
    
    
    LoginFrame()
    { 
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }
    public void setLayoutManager()
    {
       container.setLayout(null);
    }
    public void setLocationAndSize()
    {   //setBounds  = (x:,y:,width:,height:)
        userLabel.setBounds(50,150,100,30);
        passwordLabel.setBounds(50,220,100,30);
        passwordField.setBounds(50,220,100,30);
        userTextField.setBounds(150,150,150,30);
        passwordField.setBounds(150,220,150,30);
        showPassword.setBounds(150,250,150,30);
        loginButton.setBounds(50,300,100,30);
        resetButton.setBounds(200,300,100,30);
        registerButton.setBounds(50,370,250,30);
    }
    public void addComponentsToContainer()
    {
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
        container.add(registerButton);
    }
    
    public void addActionEvent()
    {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
        registerButton.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==loginButton)
        {
            String userText;
            String passwordText;
            userText=userTextField.getText();
            passwordText=passwordField.getText();
            //User Verification goes here.
            if(userText.equalsIgnoreCase("Brandon")&&passwordText.equalsIgnoreCase("1234"))
            {
                JOptionPane.showMessageDialog(this, "Login Successful");
                
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Invalid Username/Password or User does not exist");
            }
        }
        if(e.getSource()==resetButton)
        {
        userTextField.setText("");
        passwordField.setText("");
        }
        if(e.getSource()==showPassword)
        {
            if(showPassword.isSelected())
            {
            passwordField.setEchoChar((char) 0);
            
            }
            else
            {
            passwordField.setEchoChar('*');
            }
        }
    }
 
}
