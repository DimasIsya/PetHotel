/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.AdminModel;
import view.admin.DataHotelView;

public class DataHotelController {
    AdminModel adminModel;
    DataHotelView dataHotelView;

    public DataHotelController(AdminModel adminModel, DataHotelView dataHotelView) {
        this.adminModel = adminModel;
        this.dataHotelView = dataHotelView;
        
        if(adminModel.getRecapData()>0){
            String dataUser[][] = adminModel.readAllRecap();
            dataHotelView.table.setModel((
                    new JTable(dataUser, dataHotelView.getHeader())).getModel()
            );
            
        }else{
            JOptionPane.showMessageDialog(null, "Data Kosong");
        }
        
        dataHotelView.bExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                dataHotelView.dispose();
            }
        });
    }
    
    
}
