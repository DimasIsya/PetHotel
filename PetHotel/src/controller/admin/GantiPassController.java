/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.AdminModel;
import view.admin.GantiPassView;

public class GantiPassController {
    GantiPassView gantiPassView;
    AdminModel adminModel;

    public GantiPassController(GantiPassView gantiPassView, AdminModel adminModel, String username, AdminController ac) {
        this.gantiPassView = gantiPassView;
        this.adminModel = adminModel;
        
        gantiPassView.setUsername(username);
        
        gantiPassView.bchange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String oldPass = gantiPassView.getOldPassword();
                String newPass = gantiPassView.getNewPassword();
                
                if(adminModel.changePassword(oldPass, newPass, username)){
                    gantiPassView.dispose();
                    ac.updateTable();
                }
            }
        });
        
    }
}
