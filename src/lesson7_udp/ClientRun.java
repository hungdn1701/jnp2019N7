/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson7_udp;

/**
 *
 * @author mam
 */
public class ClientRun {
    public static void main(String[] args) {
        UDPClient client = new UDPClient();
        client.send("hungdn@ptit.edu.vn");
        client.receive();
    }
}
