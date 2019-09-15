/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson5_thread;

/**
 *
 * @author mam
 */
public class Ex1 {
    public static void main(String[] args) throws InterruptedException {
         new Thread(new PrintNameThread("a")).start();
         new Thread(new PrintNameThread("b")).start();
         new Thread(new PrintNameThread("c")).start();
         new Thread(new PrintNameThread("d")).start();
        
    }
}


class PrintNameThread implements Runnable {
    private String name;
    public PrintNameThread(String name) {
        this.name = name;
        
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++)
            System.out.println(name);
    }
    
}