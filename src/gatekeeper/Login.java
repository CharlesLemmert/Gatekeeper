/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gatekeeper;

import javax.swing.JFrame;

public class Login {
    public static void main(String[] args) 
    
    {
    RegistrationFrame frame = new RegistrationFrame();
    frame.setTitle("GateKeepers Registration");
    frame.setVisible(true);
    //frame.setSize(600,400);
    frame.setBounds(10,10,500,700);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    {
    LoginFrame frame = new LoginFrame();
    frame.setTitle("GateKeepers Login");
    frame.setVisible(true);
    //frame.setSize(600,400);
    frame.setBounds(10,10,500,700);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
}
