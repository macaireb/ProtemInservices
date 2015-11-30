/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proteminservices;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;
import java.io.*;
import java.util.Vector;
import static proteminservices.Nurse.FileName;
import java.awt.*;

/**
 *
 * @author macaireb
 */
public class ProtemInservices {

    /**
     * @param args the command line arguments
     */
    static char CategorySelected;
    static String testeeName = new String();
    
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
                    search:
                    for(int i=0;i<13;i++){
                        if(Category[i].isSelected())
                            for(int j=0;(Line= bufferedReaderTwo.readLine()) != null;j++)
                                if(Line.contains(Category[i].getText())){
                                    CategorySelected = Line.charAt(0);
                                    System.out.println(CategorySelected);
                                    frame.dispose();
                                    break search;
                                }
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
        
        Exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
                        
        frame.add(Exit);
        frame.add(Next); 
        frame.setLayout(new GridLayout(4, 4));
        frame.setMinimumSize(new Dimension(1280, 1024));
        
        //Display the window.
        //frame.pack();
        frame.setVisible(true);        
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Date testeeDate = new Date();
        
        //System.out.println("What is your name: ");
       
        
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
        System.out.println(Nurse.findNurse("Dalila, Hoeft"));
        NursesWindow();
        
    }
    
    static void NursesWindow(){
        
        JFrame frame = new JFrame("Nurses Selection Window");
        JPanel listPanel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JList nursesList;
        Vector<String> nurses = new Vector<String>();
        JButton Save = new JButton("Save Name");
        JButton Next = new JButton("Next");
        JButton Exit = new JButton("Exit");
        JLabel label = new JLabel("If the name is unlisted, please type it below");
        JTextArea nursesName = new JTextArea();
        String[] tmp = new String[3];
        String fileName = "nurses.txt";
        String Line = new String();
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(FileName);
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int i=0;
            while((Line = bufferedReader.readLine()) != null){
                tmp = Line.split(",");
                nurses.add(tmp[0] + "," +tmp[1]);
                System.out.println(nurses.elementAt(i));
                i++;
            }            

            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                FileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + FileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        nursesList = new JList(nurses);
        nursesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        nursesList.setLayoutOrientation(JList.VERTICAL_WRAP);
        nursesList.setVisibleRowCount(-1);
        Exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        
        Save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Nurse.AddNurse(nursesName.getText());//To change body of generated methods, choose Tools | Templates.
            }
        });
        
        Next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                testeeName = nursesList.getSelectedValue().toString();
                System.out.println(testeeName);                
                frame.dispose();
                CategoryWindow();
            }
        });
        
        nursesName.setMaximumSize(new Dimension(250, 50));
        listPanel.setLayout(new GridLayout(6, 1));
        listPanel.add(label);
        listPanel.add(nursesName);
        listPanel.add(Save);
        listPanel.add(Next);
        listPanel.add(Exit);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().add(nursesList, BorderLayout.CENTER);
        frame.getContentPane().add(listPanel, BorderLayout.LINE_END);
        frame.setMinimumSize(new Dimension(1280, 1024));
        
        //Display the window.
        //frame.pack();
        frame.setVisible(true);   
    }
    
    
}