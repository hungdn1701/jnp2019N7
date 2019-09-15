/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson6_tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mam
 */
public class SServer {
    public static void main(String[] args) {
        InputStream in;
        OutputStream out;
        byte[] b = new byte[100];
        String str = "abc";
        try {
            ServerSocket server = new ServerSocket(1107);
            System.out.println("server started ... ");
            while(true){
                Socket conn = server.accept();
                System.out.format("client connected. Details: %s, port: %d, localport: %d\n",
                        conn.getInetAddress().getHostAddress(), conn.getPort(),conn.getLocalPort());
                out = conn.getOutputStream();
//                in = conn.getInputStream();
//                b = new byte[in.available()];
//                in.read(b);
                out.write("xxx".getBytes());
                
                out.close();
//                in.close();
//                System.out.println(new String(b));
                conn.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(SServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            
}
