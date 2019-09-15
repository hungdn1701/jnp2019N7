/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson3_mvc;

/**
 *
 * @author mam
 */
public class MVCTest {
    public static void main(String[] args) {
//        LoginController lc = new LoginController();
            LoginController lc = 
                    new LoginController(new LoginModel("hungdn","xyz"));
    }
}
