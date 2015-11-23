/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proteminservices;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;
import java.io.*;
import java.util.Enumeration;
import java.util.Vector;

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
        JButton Exit = new JButton("Exit");
        ButtonGroup category = new ButtonGroup();
        JRadioButton[] Months = new JRadioButton[13];
        Months[0] = new JRadioButton("January");
        Months[1] = new JRadioButton("February");
        Months[2] = new JRadioButton("March");
        Months[3] = new JRadioButton("April");
        Months[4] = new JRadioButton("May");
        Months[5] = new JRadioButton("June");
        Months[6] = new JRadioButton("July");
        Months[7] = new JRadioButton("August");
        Months[8] = new JRadioButton("September");
        Months[9] = new JRadioButton("October");
        Months[10] = new JRadioButton("November");
        Months[11] = new JRadioButton("December");
        Months[12] = new JRadioButton("January 2017");
        for(int i=0;i<13;i++){
            category.add(Months[i]);
            frame.add(Months[i]);
        }
        
        
        Exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        
        area.setBounds(10, 30, 100, 100);
        area.setBackground(Color.white);
        area.setForeground(Color.black);
        
        frame.add(label);
        //frame.add(new JSeparator());
        frame.add(area);
        frame.add(Exit);
        
        frame.setLayout(new GridLayout(4, 4));
        frame.setMinimumSize(new Dimension(1280, 1024));
        
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
       
        
        // The name of the file to open.
        String fileName = "questions.txt";

        // This will reference one line at a time
        String line = null;
        try {
            // FileReader reads text files in the default encoding.
            
            FileReader fileReader =   new FileReader(fileName);
            Vector<String> names = new Vector<String>();

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            Vector<Question> question = new Vector<>();
            
            for(int i=0;(line = bufferedReader.readLine()) != null;i++){                 
                names.addElement(line);
                question.addElement(new Question(line));
            }
            
            
            //Enumeration questionsEnum = question.elements();
            //while(questionsEnum.hasMoreElements())
                //System.out.println(questionsEnum.nextElement().toString());
                
            for(int i=0;i<question.size();i++)
                System.out.println(question.elementAt(i).ToString());

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        
        System.out.println(Nurse.findNurse("Dalila Hoeft"));
    }
}
