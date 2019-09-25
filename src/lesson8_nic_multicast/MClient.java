/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson8_nic_multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mam
 */
public class MClient {
    public static void main(String[] args) {
        try {
            MulticastSocket client = new MulticastSocket(1107);
            client.joinGroup(InetAddress.getByName("224.2.2.3"));
            while(true){
                byte[] data = new byte[1024];
                DatagramPacket p = new DatagramPacket(data, data.length);
                client.receive(p);
                System.out.println(new String(data).trim());
            }
        } catch (IOException ex) {
            Logger.getLogger(MClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
