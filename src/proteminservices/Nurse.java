/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proteminservices;
import java.io.*;
import java.util.Vector;

/**
 *
 * @author macaireb
 */
public class Nurse {
    
    static String FileName = "nurses.txt";;
    String FirstName, LastName;
    int Key;
    BufferedReader bufferedReader;
    FileReader fileReader;
    
    void generateKey(){
        String tmp;
        tmp = FirstName + LastName;
        Key = tmp.hashCode();
    }
    
    Nurse(String Record){
        String[] tmp = Record.split(",", 3);
        FirstName = tmp[0];
        LastName = tmp[1];
        Key = Integer.parseInt(tmp[2]);
    }
    
    Nurse(String FName, String LName){
        FirstName = FName;
        LastName = LName;
    }
    
    Nurse(){}
    
    static String findNurse(String Record){
        String Line = new String();
            
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(FileName);
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((Line = bufferedReader.readLine()) != null)
                if(Line.contains(Record))
                    break;

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
                    
           return Line;
    }
    
    static void AddNurse(String Name){
        if(Name.contains(" ")){
            String[] tmp = Name.split(" ");
            Name = tmp[0] + ", " + tmp[1];
            Name += ", " + Name.hashCode();
        }
        File file = new File(FileName);
        try {
            // FileReader reads text files in the default encoding.
            FileWriter Writer = new FileWriter(file.getAbsoluteFile(),true);
            // Always wrap FileReader in BufferedReader.
            BufferedWriter bufferedWriter = new BufferedWriter(Writer);
            bufferedWriter.newLine();
            bufferedWriter.write(Name);

            // Always close files.
            bufferedWriter.close();
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
        
    }
    
}
