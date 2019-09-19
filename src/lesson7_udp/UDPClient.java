/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson7_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mam
 */
public class UDPClient {
    DatagramSocket client;
    DatagramPacket sendPacket, receivePacket;
    byte[] sendData, receiveData;
    public UDPClient() {
        try {
            client = new DatagramSocket();
        } catch (SocketException ex) {
            Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void send(String _str){
        // gửi gói tin tại client
        sendData = _str.getBytes();
        InetAddress address;
        try {
            address = InetAddress.getByName("localhost");
            sendPacket = new DatagramPacket(sendData, sendData.length,
                    address, 1107);
            client.send(sendPacket);
            
        } catch (UnknownHostException ex) {
            Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void receive(){
      
        try {
            receiveData = new byte[1024];
            receivePacket = new DatagramPacket(receiveData, receiveData.length);
            client.receive(receivePacket);
            System.out.println(new String(receivePacket.getData()).trim());
            client.close();
        } catch (IOException ex) {
            Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
