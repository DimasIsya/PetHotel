/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.admin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DataHotelView extends JFrame {
    JLabel lTitle = new JLabel("View Hotel Data");

    public JButton bExit = new JButton("Keluar");
    public JTable table;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    Object[] header = {"id", "nama_pemilik", "jenis_hewan", "harga",
                       "waktu_masuk", "waktu_keluar", "user_id"};
    
    public DataHotelView(){
        dtm = new DefaultTableModel(header, 0);
        table = new JTable(dtm);
        scrollPane = new JScrollPane(table);

        setSize(700, 450);
        setTitle("Hotel Hewan Data");
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        add(lTitle);
        lTitle.setBounds(300, 20, 200, 20);

        add(scrollPane);
        scrollPane.setBounds(10, 40, 665, 330);

        add(bExit);
        bExit.setBounds(300, 380, 100, 20);
    }

    public Object[] getHeader() {
        return header;
    }
    
    
}
