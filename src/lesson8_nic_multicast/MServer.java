/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson8_nic_multicast;

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
public class MServer {

    public static void main(String[] args) {
        DatagramSocket server;
        DatagramPacket packet;
        byte[] data;
        try {
            server = new DatagramSocket();
            for (int i = 0; i < 1000; i++) {
                data = ("message  " + i).getBytes();
                InetAddress address = InetAddress.getByName("224.2.2.3");
                packet = new DatagramPacket(data, data.length,
                         address, 1107);
                server.send(packet);
                Thread.sleep(5000);
            }
        } catch (SocketException ex) {
            Logger.getLogger(MServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(MServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(MServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
