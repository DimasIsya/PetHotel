/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.employee;

import controller.LoginController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import model.LoginModel;
import model.HotelDataModel;
import view.employee.LoginView;
import view.employee.HotelPageView;

public class HotelPageController {
    HotelDataModel hotelDataModel;
    HotelPageView hotelPageView;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date;
    
    
    public HotelPageController(HotelDataModel hotelDataModel, HotelPageView hotelPageView, String username) {
        this.hotelDataModel = hotelDataModel;
        this.hotelPageView = hotelPageView;
        
        
        hotelPageView.setUsername(username);
        hotelPageView.priceDisable();
        hotelPageView.bOut.setEnabled(false);
        hotelPageView.setRemaining(hotelDataModel.dataSisa());
        
        hotelPageView.bLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                LoginView LoginView = new LoginView();
                LoginModel LoginModel = new LoginModel();
                LoginController LoginController = new LoginController(LoginModel, LoginView);
                hotelPageView.dispose();
                
                JOptionPane.showMessageDialog(null, "Logout Berhasil");
            }
        });
        
        hotelPageView.bCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String[] data;
                String id = hotelPageView.getId();
                hotelPageView.bOut.setEnabled(true);
                if(id.equals("")){
                    JOptionPane.showMessageDialog(null, "Harus Di Isi");
                }else{
                    if(hotelDataModel.checkInput(id)){
                        data = hotelDataModel.readHotelData(id);
                        hotelPageView.setId(data[0]);
                        hotelPageView.setLicense(data[1]);
                        hotelPageView.setTypes(data[2]);
                        hotelPageView.setIn(data[3]);
                        hotelPageView.allDisabled();
                        JOptionPane.showMessageDialog(null, "Read Berhasil");
                    }
                }         
            }
        });
        
        hotelPageView.bClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                hotelPageView.clear();
                hotelPageView.bOut.setEnabled(false);
                hotelPageView.setRemaining(hotelDataModel.dataSisa());
            }
        });
        
        hotelPageView.bIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {        
                //input
                int check = Integer.parseInt(hotelDataModel.dataSisa());
                
                if(check<=0){
                    JOptionPane.showMessageDialog(null, "Kamar Full");
                }else{
                    String id = hotelPageView.getId();
                    String nama_pemilik = hotelPageView.getLicense();
                    String jenis_hewan = hotelPageView.getTypes();

                    if(id.equals("") || nama_pemilik.equals("")){
                        JOptionPane.showMessageDialog(null, "Harus Di Isi");
                    }else{
                        if(hotelDataModel.insertHotel(id, nama_pemilik, jenis_hewan, username)){
                            date = new Date();
                            hotelPageView.setRemaining(hotelDataModel.dataSisa());
                            hotelPageView.setIn(formatter.format(date));
                        }
                        
                    }
                }            
            }
        });
        
        hotelPageView.bAuto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                int id = hotelDataModel.checkId();
                id++;
                hotelPageView.setIdTrans(String.valueOf(id));
            }
        });
        
        hotelPageView.bOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String id = hotelPageView.getId();
                System.out.println("id " + id);  
                hotelDataModel.outHotel(id);
                String[] data = hotelDataModel.getWaktudanHarga(id);
                hotelPageView.priceVisible();
                hotelPageView.setPrice("Rp" + data[0]);
                hotelPageView.setOut(data[1]);
                hotelPageView.setRemaining(hotelDataModel.dataSisa());
              hotelPageView.bOut.setEnabled(false);
            }
        });
          
    }
}
