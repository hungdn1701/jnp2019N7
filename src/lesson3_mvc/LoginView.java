/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson3_mvc;

import java.util.Scanner;

/**
 *
 * @author mam
 */
public class LoginView {
    LoginModel user;
    String _user, _pass;
    public LoginView() {
        // login view
        System.out.println(" login form ");
        Scanner in = new Scanner(System.in);
        _user = in.nextLine();
        _pass = in.nextLine();
        new LoginController(_user, _pass);
    }

    public LoginView(LoginModel user) {
        
        this.user = user;
        // details view
        System.out.println(" details form");
        System.out.println("user: " + this.user.getUser());
    }
    
}
