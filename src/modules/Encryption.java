/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modules;

/**
 *
 * @author kelvi
 */
public class Encryption {
    
    public static String getEncrypt(String word){
    
        String result = "";
        
        int up;
        String inp = word;
        char chr;
        
        for (int i = 0; i < inp.length() ; i++) {
            up = inp.charAt(i);
            if(i == 0){
                up += 1;
            }else{
                up += i + 1;
            }
            chr = (char) up;
            
            result += String.valueOf(chr);
        }
        
        return result;
    }
    
    public static String getDecrypt(String word){    
        
        String result = "";
        
        int up;
        String inp = word;
        char chr;
        
        for (int i = 0; i < inp.length() ; i++) {
            up = inp.charAt(i);
            if(i == 0){
                up -= 1;
            }else{
                up -= i + 1;
            }
            chr = (char) up;
            
            result += String.valueOf(chr);
        }
        
        return result;
    }
}



