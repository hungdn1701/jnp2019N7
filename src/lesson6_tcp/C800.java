/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson6_tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mam
 */
public class C800 {
    public static void main(String[] args) {
        int a, b;
        try (Socket client = new Socket("127.0.0.1", 1107);
                DataOutputStream out = new DataOutputStream(client.getOutputStream());
                DataInputStream in = new DataInputStream(client.getInputStream());) {
            out.writeUTF("B16DCCN999;800");
            a = in.readInt();
            b = in.readInt();
            out.writeInt(a+b);
            out.writeInt(a*b);
            
        } catch (IOException ex) {
            Logger.getLogger(C800.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
            
}
