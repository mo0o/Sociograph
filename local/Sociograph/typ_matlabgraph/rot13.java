/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package typ_matlabgraph;

/**
 *
 * @author richarddavies
 */
import java.lang.*;

public class rot13 { 
    
  
    
    
       public static String encrypt(String s) {
        
           String build = "";
         
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if       (c >= 'a' && c <= 'm') c += 13;
            else if  (c >= 'A' && c <= 'M') c += 13;
            else if  (c >= 'n' && c <= 'z') c -= 13;
            else if  (c >= 'N' && c <= 'Z') c -= 13;
            else if  (c == '0') c = '5';
            else if  (c == '1') c = '6';
            else if  (c == '2') c = '7';
            else if  (c == '3') c = '8';
            else if  (c == '4') c = '9';
            else if  (c == '5') c = '0';
            else if  (c == '6') c = '1';
            else if  (c == '7') c = '2';
            else if  (c == '8') c = '3';
            else if  (c == '9') c = '4';
            
            build += c; 
            
        }
        
        //Object rot = (char)c;
        //String out = (String)rot;
        return build;
    }

}
