/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.admin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AdminView extends JFrame {
     String[] roles = {"Admin", "Employee"};
    JLabel lTitle = new JLabel("Menu Admin");
    JLabel lUsername = new JLabel("Username");
    JLabel lRole = new JLabel("Karyawan"); //diganti karyawan jangan role
    
    JTextField tfUsername = new JTextField();
    
    public JComboBox<String> cbRole = new JComboBox<>(roles);
    
    public JButton bLogout = new JButton("Logout");
    public JButton bInput = new JButton("Input");
    public JButton bViewData = new JButton("View Pet Hotel Data");
    public JButton bPassword = new JButton("Change Password");
    public JButton bHapus = new JButton("Hapus");
    public JButton bUpdate = new JButton("Update");
    public JButton bReset = new JButton("Reset");
    public JTable table;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    Object[] header = {"username", "password", "role"};
    
    public AdminView() {
        dtm = new DefaultTableModel(header, 0);
        table = new JTable(dtm);
        scrollPane = new JScrollPane(table);
        
        setSize(720, 450);
        setTitle("Menu Admin");
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE); //DISPOSE_ON_CLOSE
        setLocationRelativeTo(null);
        
        add(scrollPane);
        scrollPane.setBounds(20, 20, 480, 300);
        
        add(lTitle);
        lTitle.setBounds(560, 20, 100, 20);
        
        add(lUsername);
        lUsername.setBounds(520, 70, 100, 20);
        add(tfUsername);
        tfUsername.setBounds(520,90, 160, 20);
        
        add(lRole);
        lRole.setBounds(520, 120, 100, 20);
        add(cbRole);
        cbRole.setBounds(520, 140, 160, 20);
        
        add(bPassword);
        bPassword.setBounds(520, 180, 160, 20);
        
        add(bInput);
        bInput.setBounds(520, 210, 160, 20);
        
        add(bUpdate);
        bUpdate.setBounds(520, 240, 160, 20);
        
        add(bHapus);
        bHapus.setBounds(520, 270, 160, 20);
        
        add(bReset);
        bReset.setBounds(520, 300, 160, 20);
        
        add(bLogout);
        bLogout.setBounds(550, 350, 100, 30);
        
        add(bViewData);
        bViewData.setBounds(20, 350, 200, 30);
        
    }

    public Object[] getHeader() {
        return header;
    }   

    public String getUsername() {
        return tfUsername.getText();
    }
    
    public String getKaryawan(){
        return cbRole.getItemAt(cbRole.getSelectedIndex());
    }

    public void setUsername(String username) {
        this.tfUsername.setText(username);
    }
}
