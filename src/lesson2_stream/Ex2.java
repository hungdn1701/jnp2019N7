/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson2_stream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 *
 * @author mam
 */
public class Ex2 {
    public static void main(String[] args) {
        String[] name = {"apple", "lemon","orange"};
        double[] price = {1.5, 2.5,3.5};
        int[] quantity = {5,10,15};
        String file = "C:\\jnp\\2019\\n7\\ex2.bin";
        try (FileInputStream fos = new FileInputStream(file);
                DataInputStream dos = new DataInputStream(fos)) {
            for(int i = 0; i < name.length; i++)
            {
                System.out.format("%s %.2f %d \n",dos.readUTF()
                        ,dos.readDouble(), dos.readInt() );
            }
        } catch (Exception e) {
            System.out.println("err:" + e.getMessage());
        }
    }
}
