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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author macaireb
 */
public class ProtemInservices {

    /**
     * @param args the command line arguments
     */
    static char CategorySelected;
    
    static void CategoryWindow(){
        
        JFrame frame = new JFrame("Category Selection Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ButtonGroup CategoryGroup = new ButtonGroup();
        JRadioButton[] Category = new JRadioButton[13];        
        JButton Next = new JButton("Next");
        JButton Exit = new JButton("Exit");
        
        String fileName = "category.txt";
        try {
            // FileReader reads text files in the default encoding.
            
            FileReader fileReader =   new FileReader(fileName);
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            String[] record = new String[2];
            
            for(int i=0;(line= bufferedReader.readLine()) != null;i++){
                record = line.split(",");
                Category[i] = new JRadioButton(record[1]);
                CategoryGroup.add(Category[i]);                
                frame.add(Category[i]);
            }

            // Always close files.
            bufferedReader.close();
            FileReader fileReaderTwo =   new FileReader(fileName);
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReaderTwo = new BufferedReader(fileReaderTwo);
            
            Next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String Line = null;
                    for(int i=0;i<13;i++){
                        if(Category[i].isSelected())
                            for(int j=0;(Line= bufferedReaderTwo.readLine()) != null;j++)
                                if(Line.contains(Category[i].getText()))
                                    CategorySelected = Line.charAt(0);
                                    System.out.println(CategorySelected);
                                    break;
                    }
                    
                bufferedReaderTwo.close();
                } catch (IOException ex) {
                    System.out.println(
                    "Error reading file '" 
                    + fileName + "'");  
                }
            }
        });
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
        
        
                        
        frame.add(Exit);
        frame.add(Next); 
        frame.setLayout(new GridLayout(4, 4));
        frame.setMinimumSize(new Dimension(1280, 1024));
        
        //Display the window.
        //frame.pack();
        frame.setVisible(true);        
    }
    
    protected static void createAndShowGUI() {
        
        //Create and set up the window.
        JFrame frame = new JFrame("Name Selection Window");
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
        //createAndShowGUI();
       
        
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
        CategoryWindow();
        System.out.println(Nurse.findNurse("Dalila Hoeft"));
    }
}
