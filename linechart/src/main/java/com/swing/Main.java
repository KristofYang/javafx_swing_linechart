package com.swing;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        JFrame jFrame= new JFrame("SwingLineChart");
        JPanel rootPane=new SwingLineChart().jpanel;
        jFrame.setContentPane(rootPane);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setSize(800, 600);
        jFrame.setLocationRelativeTo(rootPane);//居中
        jFrame.setVisible(true);
    }


}
