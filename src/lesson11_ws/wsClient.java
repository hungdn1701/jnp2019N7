/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson11_ws;

/**
 *
 * @author mam
 */
public class wsClient {
    public static void main(String[] args) {
        vn.medianews.Calculator_Service service = new vn.medianews.Calculator_Service();
        vn.medianews.Calculator port = service.getCalculatorPort();
        System.out.println(port.add(100, 200));
    }

  
}
