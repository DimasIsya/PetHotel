/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package PetHotel;

import controller.LoginController;
import model.LoginModel;
import view.employee.LoginView;

public class PetHotel {

   
    public static void main(String[] args) {
       LoginView loginView = new LoginView();
       LoginModel loginModel = new LoginModel();
       LoginController loginController = new LoginController(loginModel, loginView);
    }
}
