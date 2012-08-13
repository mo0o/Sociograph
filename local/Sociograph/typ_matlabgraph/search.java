/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package typ_matlabgraph;

/**
 *
 * @author richarddavies
 */

import java.util.*;
import java.lang.*;
import java.io.*;

public class search {
    
    
    public static int search(Long id){
        
       int indexNumber = 0;
        
        for(int i = 0; i < Typ_MatlabGraph.people.size(); i++){

            if ( id.equals( ( Long ) Typ_MatlabGraph.people.get( i ).idProf ) ){
                
                //System.out.println("found matching identity number...");
                indexNumber = i;
                }
            
        
            
            }
    
        return indexNumber;
    }
}
