/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proteminservices;
import java.util.Enumeration;
import java.util.Vector;
/**
 *
 * @author macaireb
 */
public class Question {
    
    String Category,QuestionText,Answer;
    Vector<String> Choices;
    Boolean MultipleChoice;
    
    Question(String record){
        String[] temp = new String[10];
        MultipleChoice = !record.contains("__");
        temp = record.split(",", 10);
        Category = temp[0];
        QuestionText = temp[1];
        Answer = temp[2];
        Choices = new Vector<String>();
        for(int i=3;i < temp.length; i++)
            Choices.add(temp[i]);        
    }
    
    Question(){}
    
    String GetCategory(){
        return Category;
    }
    
    String GetQuestionText(){
        return QuestionText;
    }
    
    String GetAnswer(){
        return Answer;
    }
    
    void CopyChoices(Vector<String> NewChoices){
        NewChoices.addAll(Choices);
    }
    
    Boolean IsMultipleChoice(){
        return MultipleChoice;
    }
    
    String ToString(){
        String temp = new String();
        temp += "Category: " + Category;
        temp += " Question: " + QuestionText;
        temp += " Answer: " + Answer;
        temp += " Is Multiple Choice: " + MultipleChoice;
        
        for(int i=0;i<Choices.size();i++)
            temp += " Choice " + i + ": " + Choices.elementAt(i);
        return temp;
    }
    
}
