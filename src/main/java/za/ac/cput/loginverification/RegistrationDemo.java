/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.loginverification;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 * GateKeeper Registration Saving data to text file code
 *
 * @author Charles Moses Lemmert Student Number: 220498385
 */
public class RegistrationDemo extends JFrame implements ActionListener {

    String Username,Password;
    int numLn;
    //--------------------------------------------------------------------------J Labels and Textfields
    private JLabel lblFirstName;
    private JTextField txtFirstName;

    private JLabel lblSurname;
    private JTextField txtSurname;

    private JLabel lblUsername;
    private JTextField txtUsername;

    private JLabel lblCellNo;
    private JTextField txtCellNo;

    private JLabel lblCompanyName;
    private JTextField txtCompanyName;

    private JLabel lblPassword;
    private JPasswordField pfPassword;

    private JButton btnCreateAccount;
    private JButton btnLogin;

    //--------------------------------------------------------------------------Registration Constructor
    public RegistrationDemo() {
        super("Registration Demo");

        //---------------------------------------------------First Name label and textfield
        lblFirstName = new JLabel("First Name:");
        txtFirstName = new JTextField(15);

        //---------------------------------------------------Last Name label and textfield
        lblSurname = new JLabel("Last Name:");
        txtSurname = new JTextField(15);

        //---------------------------------------------------Username label and textfield
        lblUsername = new JLabel("Username:");
        txtUsername = new JTextField(15);

        //---------------------------------------------------Cellphone Number label and textfield
        lblCellNo = new JLabel("Phone No:");
        txtCellNo = new JTextField(15);

        //---------------------------------------------------Company Name label and textfield
        lblCompanyName = new JLabel("Company:");
        txtCompanyName = new JTextField(15);

        //---------------------------------------------------Password label and textfield
        lblPassword = new JLabel("Password");
        pfPassword = new JPasswordField(15);

        //---------------------------------------------------Submission button & Return to login button
        btnCreateAccount = new JButton("Submit");
        btnLogin = new JButton("Return");
    }

    //--------------------------------------------------------------------------Demo GUI layout for Login and Registration test
    public void startGUI() {

        //---------------------------------------------------Creating window and setting window Size
        JFrame resWindow = new JFrame("Registration Demo");
        resWindow.setSize(550, 550);
        resWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //---------------------------------------------------Creating panel to place textfields and labels in
        JPanel resBorder = new JPanel();
        resWindow.add(resBorder);
        resBorder.setLayout(null);

        //---------------------------------------------------positioning First Name label and textfield
        lblFirstName.setBounds(190, 20, 80, 25);
        resBorder.add(lblFirstName);
        txtFirstName.setBounds(190, 50, 165, 25);
        resBorder.add(txtFirstName);

        //---------------------------------------------------positioning Last Name label and textfield
        lblSurname.setBounds(190, 80, 80, 25);
        resBorder.add(lblSurname);
        txtSurname.setBounds(190, 110, 165, 25);
        resBorder.add(txtSurname);

        //---------------------------------------------------positioning Username label and textfield
        lblUsername.setBounds(190, 140, 80, 25);
        resBorder.add(lblUsername);
        txtUsername.setBounds(190, 170, 165, 25);
        resBorder.add(txtUsername);

        //---------------------------------------------------positioning Cellphone number label and textfield
        lblCellNo.setBounds(190, 200, 80, 25);
        resBorder.add(lblCellNo);
        txtCellNo.setBounds(190, 230, 165, 25);
        resBorder.add(txtCellNo);

        //---------------------------------------------------positioning Company Name label and textfield
        lblCompanyName.setBounds(190, 260, 80, 25);
        resBorder.add(lblCompanyName);
        txtCompanyName.setBounds(190, 290, 165, 25);
        resBorder.add(txtCompanyName);

        //---------------------------------------------------positioning Password label and textfield
        lblPassword.setBounds(190, 320, 80, 25);
        resBorder.add(lblPassword);
        pfPassword.setBounds(190, 350, 165, 25);
        resBorder.add(pfPassword);

        //---------------------------------------------------positioning  Submit button and adding action listeners 
        btnCreateAccount.setBounds(230, 390, 80, 25);
        resBorder.add(btnCreateAccount);

        //---------------------------------------------------positioning  Return button and adding action listeners
        btnLogin.setBounds(225, 420, 90, 25);
        resBorder.add(btnLogin);

        //----------------------------------------------------------------------
        resWindow.setLocationRelativeTo(null);
        resWindow.setVisible(true);

        //----------------------------------------------------------------------Action Listener onclick functionality implemented here:Login and Register
        //--------------------------------------------------------------------------Registration button
        btnCreateAccount.addActionListener(this);

        //--------------------------------------------------------------------------Login button
        btnLogin.addActionListener(new ActionListener() {

            //the only way to close the window is by placing the action event inside the btnlogin action listener
            @Override
            public void actionPerformed(ActionEvent e) {

                //---------------------------------------------------opening login form 
                if (e.getSource() == btnLogin) {

                    resWindow.setVisible(false);
                    BasicLoginGUI loginw = new BasicLoginGUI();
                    loginw.startGUI();

                }

            }

        });
    }
    //--------------------------------------------------------------------------Saving user data to text file
    void savingData(String username,String password,String firstName, String lastName, String cellNumber, String companyName) {

        
        
        //----------------------------------------------------------try and catch: saving data to text file and checking for errors
        try {
            
            try(RandomAccessFile userData = new RandomAccessFile("RegisteredUserData.txt", "rw")) {
                for(int i = 0; i<numLn;i++){
                    
                    userData.readLine();
                }
                //Formating and writing user data to text file "RegisteredUserData.txt"
                userData.writeBytes("\r\n");
                userData.writeBytes("\r\n");
                userData.writeBytes("Username:" + username+ "\r\n");
                userData.writeBytes("Password:" + password+ "\r\n");
                userData.writeBytes("Name:" + firstName+ "\r\n");
                userData.writeBytes("Surname:" + lastName+ "\r\n");
                userData.writeBytes("PhoneNo:" + cellNumber+ "\r\n");
                userData.writeBytes("CompanyName:" + companyName);
            }
            JOptionPane.showMessageDialog(null, "Successful Registration!");

            //Reseting txtFields to its default(empty boxes)
            txtFirstName.setText("");
            txtSurname.setText("");
            txtUsername.setText("");
            txtCellNo.setText("");
            txtCompanyName.setText("");
            pfPassword.setText("");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(RegistrationDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RegistrationDemo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //--------------------------------------------------------------------------Verify Login information
    public void validatingData(String username,String password){
        
        try {
            RandomAccessFile userData = new RandomAccessFile("RegisteredUserData.txt", "rw");
            //Looping through saved data reaches new username and password after reading through seven lines
            for(int y = 0; y < numLn; y+=7){
            
                String User = userData.readLine().substring(9);
                String Passw = userData.readLine().substring(9);
                
                if(username.equals(User) & password.equals(Passw)){
                    JOptionPane.showMessageDialog(null, "Successful Login!");
                    break;
                    
                }else if(y ==(numLn-7)){
                    JOptionPane.showMessageDialog(null, "Incorrect Username/Password");
                }
                for(int z = 1; z <= 5;z++){
                   
                    userData.readLine();
                }

            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RegistrationDemo.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
            Logger.getLogger(RegistrationDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //line Counter
    public void numberOfLines(){
         try {
            numLn = 1;
            RandomAccessFile userData = new RandomAccessFile("RegisteredUserData.txt","rw");
            for(int x = 0; userData.readLine()!= null;x++){
                numLn++;
                    
            
            }
            System.out.println("Number of lines:"+ numLn);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RegistrationDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RegistrationDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    
    
    }

    //--------------------------------------------------------------------------Registration onclick action event calls savingData()
    @Override
    public void actionPerformed(ActionEvent e) {

        //---------------------------------------------------Saving the users input data to a text file
        if (e.getSource() == btnCreateAccount) {
            numberOfLines();
            savingData(txtUsername.getText(), pfPassword.getText(), txtFirstName.getText(), txtSurname.getText(), txtCellNo.getText(), txtCompanyName.getText());
        }
    }

    
}

//--------------------------------------------------------------------------End of Demo GUI

