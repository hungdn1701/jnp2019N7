/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson6_tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mam
 */
public class SClient {
    public static void main(String[] args) {
        String str = "hungdn";
//        OutputStream out; 
        InputStream in;
        byte b[] ;

        try{
            Socket client = new Socket("localhost", 1107);
//            out = client.getOutputStream();
            in = client.getInputStream();
//            out.write(str.getBytes());
            int length = in.available();
//            System.out.println(length);
//            System.out.println(in.available());
            b = new byte[length];
            in.read(b);
            System.out.println(in.available());
            System.out.println(new String(b));
//            out.close();
            in.close();
            client.close();
        } catch (IOException ex) {
            Logger.getLogger(SClient.class.getName()).log(Level.SEVERE, null, ex);
        }
       
                
    }
}
