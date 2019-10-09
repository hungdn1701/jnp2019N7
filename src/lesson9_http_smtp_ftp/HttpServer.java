/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson9_http_smtp_ftp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mam
 */
public class HttpServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            while(true){
                Socket conn = server.accept();
                BufferedReader in = 
                        new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line = in.readLine();
                while(!line.isEmpty()){
                    System.out.println(line);
                    line = in.readLine();
                }
                System.out.println("---------------------------");
                OutputStream out = conn.getOutputStream();
                String _res = "HTTP/1.1 200 OK \r\n\r\n Today is: " + new Date(); 
                out.write(_res.getBytes());
                
                in.close();
                out.close();
                conn.close();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(HttpServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
}
