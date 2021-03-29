/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gary Senoc
 */
public class SplitProgram {
    
    
    public static String splitWords(String word){
        
        int count = 0;
        
        
        StringBuilder first = new StringBuilder();
        
        
        
        
        
        for(int i  = 0;i < word.length();i++){
         
            if(word.charAt(i) == '|'){
                count++;
            }
               
            if(count !=3){
                first.append(word.charAt(i));
            }
        }
        
        
        
        return first.toString();
    }
    
    
    public static void main(String args[]){
        
        
        System.out.print(splitWords("123456 || Gary lloyd Senoc || Hello"));
    }
    
}
