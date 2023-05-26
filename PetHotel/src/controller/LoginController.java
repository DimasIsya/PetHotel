/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.admin.AdminController;
import controller.employee.HotelPageController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.AdminModel;
import model.LoginModel;
import model.HotelDataModel;
import view.employee.LoginView;
import view.admin.AdminView;
import view.employee.HotelPageView;

public class LoginController {
     LoginModel loginModel;
    LoginView loginView;

    public LoginController(LoginModel loginModel, LoginView loginView) {
        this.loginModel = loginModel;
        this.loginView = loginView;
        
        loginView.blogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String username = loginView.getUsername();
                String password = loginView.getPassword();
                
                if(loginModel.loginHandler(username, password)){
                    JOptionPane.showMessageDialog(null, "Login Berhasil");
                    if(loginModel.isAdmin(username, password)){ 
                        AdminView adminView = new AdminView();
                        AdminModel adminModel = new AdminModel();
                        AdminController AdminController = new AdminController(adminModel, adminView);
                    }else{
                        HotelDataModel parkingDataModel = new HotelDataModel();
                        HotelPageView parkingPageView = new HotelPageView();
                        HotelPageController ppc = new HotelPageController(parkingDataModel, parkingPageView, username);
                    }
                    loginView.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Login Gagal");
                }
            }
        });
        
    }
}
