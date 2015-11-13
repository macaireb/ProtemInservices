/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proteminservices;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Date;
import javax.swing.*;

/**
 *
 * @author macaireb
 */
public class ProtemInservices {

    /**
     * @param args the command line arguments
     */
    
    protected static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Add the ubiquitous "Hello World" label.
        JLabel label = new JLabel("What is your name?");
        JTextArea area = new JTextArea(100, 100);
        
        area.setBounds(10, 30, 100, 100);
        area.setBackground(Color.white);
        area.setForeground(Color.black);
        
        frame.add(label);
        frame.add(area);        
        
        frame.setLayout(new GridLayout(1, 2));
        frame.setMinimumSize(new Dimension(300, 100));
        
        //Display the window.
        //frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        String testeeName = new String();
        Date testeeDate = new Date();
        
        //System.out.println("What is your name: ");
        createAndShowGUI();
    }
    
}
