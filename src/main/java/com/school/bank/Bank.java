package com.school.bank;

import java.awt.*;

/**
 *
 * @author Erwin Esparto
 */
public class Bank{
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
        @Override
        public void run(){
            Homepage home = new Homepage();
            home.setVisible(true);
        }
    });
    }
}