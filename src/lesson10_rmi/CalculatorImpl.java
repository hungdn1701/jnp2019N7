/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson10_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author mam
 */
public class CalculatorImpl extends UnicastRemoteObject implements Calculator{

    public CalculatorImpl() throws RemoteException
    {
        super();
    }
    
    @Override
    public int add(int a, int b) {
        System.out.format("a client request (%d, %d)",a,b);
        return a+b;
    }
    
}
