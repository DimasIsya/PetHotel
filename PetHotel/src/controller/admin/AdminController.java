/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.admin;

import controller.LoginController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.AdminModel;
import model.LoginModel;
import view.employee.LoginView;
import view.admin.AdminView;
import view.admin.GantiPassView;
import view.admin.DataHotelView;

public class AdminController {
    AdminModel adminModel;
    AdminView adminView;
    String primary = "";

    public AdminController(AdminModel adminModel, AdminView adminView) {
        this.adminModel = adminModel;
        this.adminView = adminView;
        
        if(adminModel.getUserData()>0){
            String dataUser[][] = adminModel.readAllUsers();
            adminView.table.setModel((new JTable(dataUser, adminView.getHeader())).getModel());
        }else{
            JOptionPane.showMessageDialog(null, "Data Kosong");
        }
        
        adminView.table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = adminView.table.getSelectedRow();
                String username = adminView.table.getValueAt(row, 0).toString();
                String roles = adminView.table.getValueAt(row, 2).toString();
                primary = username;
                
                adminView.setUsername(username);
                
                if(roles.equals("admin")){
                    adminView.cbRole.setSelectedIndex(0);
                }else{
                    adminView.cbRole.setSelectedIndex(1);
                }
            }
        });
        
        adminView.bLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                LoginView LoginView = new LoginView();
                LoginModel LoginModel = new LoginModel();
                LoginController LoginController = new LoginController(LoginModel, LoginView);
                adminView.dispose();
                
                JOptionPane.showMessageDialog(null, "Logout berhasil");
            }
        });
        
        adminView.bInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String username = adminView.getUsername();
                String role = adminView.getKaryawan();
                
                if(adminView.getUsername().equals("")){
                    JOptionPane.showMessageDialog(null, "Harus Di Isi");
                }else{
                    adminModel.insertUser(username, role);
                
                    primary = "";
                    String dataUser[][] = adminModel.readAllUsers();
                    adminView.table.setModel((new JTable(dataUser, adminView.getHeader())).getModel());
                }        
            }
        });
        
        adminView.bReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                adminView.setUsername("");
                primary = "";
            }
        });
        
        adminView.bUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                
                String username = adminView.getUsername();
                String role = adminView.getKaryawan();
                
                if(primary.equals("")){
                    primary = username;
                }
                
                if(adminView.getUsername().equals("")){
                    JOptionPane.showMessageDialog(null, "Harus Di Isi");
                }else{
                    adminModel.updateUser(username, role, primary); 
                    primary = "";
                    String dataUser[][] = adminModel.readAllUsers();
                    adminView.table.setModel((new JTable(dataUser, adminView.getHeader())).getModel());
                }
            }
        });
        
        adminView.bHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String username = adminView.getUsername();
                
                if(adminView.getUsername().equals("")){
                    JOptionPane.showMessageDialog(null, "Harus Di Isi");
                }else{
                    adminModel.deleteUser(username);
                    primary = "";
                    String dataUser[][] = adminModel.readAllUsers();
                    adminView.table.setModel((new JTable(dataUser, adminView.getHeader())).getModel());
                }
                
            }
        });
        
        adminView.bPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String username = adminView.getUsername();
                
                if(adminView.getUsername().equals("")){
                    JOptionPane.showMessageDialog(null, "Harus Di Isi");
                }else{
                    if(!adminModel.checkUsername(username)){
                        JOptionPane.showMessageDialog(null, "Username tidak ditemukan");
                    }else{
                        GantiPassView gantiPassView = new GantiPassView();
                        GantiPassController GantiPassController = new GantiPassController(gantiPassView, adminModel, username, AdminController.this);
                    }
                }
            }
        });
        
        adminView.bViewData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                DataHotelView dataHotelView = new DataHotelView();
                DataHotelController dpc = new DataHotelController(adminModel, dataHotelView);
            }
        });
    }
    
    public void updateTable(){
        if(adminModel.getUserData()>0){
            primary = "";
            String dataUser[][] = adminModel.readAllUsers();
            adminView.table.setModel((new JTable(dataUser, adminView.getHeader())).getModel());
        }else{
            JOptionPane.showMessageDialog(null, "Data Ksoong");
        }
    }
}
