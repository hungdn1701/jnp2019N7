/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson7_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mam
 */
public class UDPServer {
    DatagramSocket server;
    DatagramPacket receivePacket, sendPacket;
    byte[] receiveData,sendData;
    int buffSize;
    int port;

    public UDPServer() {
       
        try {
            buffSize = 1024;
            port = 1107;
            server = new DatagramSocket(port);
            System.out.println(" server opened ...");
        } catch (SocketException ex) {
            Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void listening(){
        System.out.println("listening ....");
        while (true) {
            try {
                // Nhận gói tin từ client (tại server)
                receiveData = new byte[buffSize];
                receivePacket = new DatagramPacket(receiveData, receiveData.length);
                server.receive(receivePacket);
                String _temp = new String(receivePacket.getData()).trim();
                System.out.println(_temp);
                // Gửi trả gói tin kết quả cho client
                String response = StrUtil.reverse(_temp);
                sendData = response.getBytes();
                sendPacket = new DatagramPacket(sendData,sendData.length
                        ,receivePacket.getSocketAddress());
                server.send(sendPacket);
            } catch (IOException ex) {
                Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
