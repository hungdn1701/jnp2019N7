/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson4_jdbc;

/**
 *
 * @author mam
 */
public class JDBCTest {
    public static void main(String[] args) {
        Product[] products = new ProductDAO().selectAll();
        for(int i = 0; i < products.length; i++)
            System.out.println(products[i]);
    }
}
