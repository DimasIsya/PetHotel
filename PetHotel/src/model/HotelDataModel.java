/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class HotelDataModel  extends Connector implements Hitung {
     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     
    public HotelDataModel() {
        
    }
    
    public String dataSisa(){
        String data = "";
        try {
            String query = "SELECT * FROM `pengaturan`";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                data = resultSet.getString("Sisa");
            }
            statement.close();
            return data;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return data;
        }
    }
    
    public int checkId(){
        int data = 0;
        try {
            String query = "SELECT * FROM `riwayat`";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                data = resultSet.getInt("id");
            }
            statement.close();
            
            return data;
        } catch (Exception e) {
            
            System.out.println("Error : " + e.getMessage());
            return 0;
        }
    }
    
    public boolean insertHotel(String id, String nama_pemilik, String jenis_hewan, String user_id){
        Date dateNow = new Date();
        String types;
        if(jenis_hewan.equals("Kucing")){
            types = "Kucing";
        }else{
            types = "Anjing";
        }
        try {
            String query = "INSERT INTO `riwayat` "
                    + "(`id`, `nama_pemilik`, `jenis_hewan`, `waktu_masuk`, `user_id`) "
                    + "VALUES "
                    + "(" + id+ ""
                    + ",'"+ nama_pemilik + "'"
                    + ",'" + types + "'"
                    + ",'" + formatter.format(dateNow) + "'"
                    + ",'" + user_id + "')";
            
            statement = connection.createStatement();
            statement.executeUpdate(query);
            
            statement.close();
            
            int sisa = Integer.parseInt(dataSisa());
            sisa--;
            
            updateSisa(String.valueOf(sisa));
            
            JOptionPane.showMessageDialog(null, "Input Berhasil");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed : " + e.getMessage());
            return false;
        }
    }
    
    public void updateSisa(String sisa){
        try {
            String query = "UPDATE `pengaturan` "
                    + "SET "
                    + "`sisa`=" + sisa + "";
            
            statement = connection.createStatement();
            statement.executeUpdate(query);
            
            statement.close();
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    public boolean checkInput(String id){
        try {
            int totalData = 0;
            String query = "SELECT * FROM `riwayat` WHERE `id`='" + id + "'" 
                    + " AND `harga`=0";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                totalData++;
            }
            statement.close();
            
            if(totalData>0){
                return true;
            }
            
            JOptionPane.showMessageDialog(null, "Data Kosong");
            return false;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return false;
        }
    }
    
    public String[] readHotelData(String id){
        String[] data = new String[5];
        try {
            String query = "SELECT * FROM `riwayat` WHERE `id`=" + id;
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                data[0] = resultSet.getString("id");
                data[1] = resultSet.getString("nama_pemilik");
                data[2] = resultSet.getString("jenis_hewan");
                data[3] = resultSet.getString("waktu_masuk");
                data[4] = resultSet.getString("harga");
            }
            statement.close();

            return data;
            
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Check Gagal");
            return null;
        }
    }
    
    public void outHotel(String id){
        try {
            String[] data = readHotelData(id);
            Date d1 = formatter.parse(data[3]);
            Date d2 = new Date();
            
            long time = d2.getTime() - d1.getTime();
            long diffHours = time / (60 * 60 * 1000);
            
            long total = totalHarga(diffHours, data[2]);
       
            updateHotel(total, formatter.format(d2), id);
            
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    public void updateHotel(long total, String format, String id){
        try {
            String query = "UPDATE `riwayat` "
                    + "SET "
                    + "`harga`='" + total + "', "
                    + "`waktu_keluar`='" + format + "' "
                    + "WHERE `id`=" + id;
            
            statement = connection.createStatement();
            statement.executeUpdate(query);
            
            statement.close();
            
            int sisa = Integer.parseInt(dataSisa());
            sisa++;
            
            updateSisa(String.valueOf(sisa));
            
            JOptionPane.showMessageDialog(null, "Update Berhasil");
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    public String[] getWaktudanHarga(String id){
        String[] data = new String[2];
        try {
            String query = "SELECT * FROM `riwayat` WHERE `id`=" + id;
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                data[0] = resultSet.getString("harga");
                data[1] = resultSet.getString("waktu_keluar");
            }
            statement.close();

            return data;
            
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Failed");
            return null;
        }
    }
    
     public long totalHarga(long time, String jenis_hewan) {
        long first=0, add=0;
        
        if(jenis_hewan.equals("Kucing")){
            first = 50000;
            add = 50000;
        }else{
            first = 40000;
            add = 40000;
        }
        
        if(time<=1){
            return first;
        }
        
        if(time>1){
            return first + (time*add);
        }
        
        if(time >= 24){
            return first + (add);
        }
        
        return 0;
    }
}
