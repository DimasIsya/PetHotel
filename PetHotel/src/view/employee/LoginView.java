/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.employee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LoginView extends JFrame {
    JLabel ltitle = new JLabel("Admin Login");
    
    JLabel lusername = new JLabel("Username");
    JTextField fusername = new JTextField();
    
    JLabel lpassword = new JLabel("Password");
    JPasswordField fpassword = new JPasswordField();
    
    public JButton blogin = new JButton("Login");
    
    public LoginView() {
        setSize(800, 600);
        setTitle("Sistem Hotel Hewan Admin");
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        add(ltitle);
        add(lusername);
        add(lpassword);
        add(fusername);
        add(fpassword);
        add(blogin);
        
        ltitle.setBounds(365, 50, 75, 50);
        
        lusername.setBounds(275, 120, 100, 30);
        fusername.setBounds(275, 150, 250, 30);
        
        lpassword.setBounds(275, 180, 100, 30);
        fpassword.setBounds(275, 210, 250, 30);
        
        blogin.setBounds(300, 260, 200, 30);
    }
    
    public String getUsername(){
        return fusername.getText();
    }
    
    public String getPassword(){
        return String.valueOf(fpassword.getPassword());
    }
}
