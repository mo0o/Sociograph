/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package typ_matlabgraph;

import matlabcontrol.MatlabConnectionException;
import matlabcontrol.MatlabInvocationException;
import matlabcontrol.MatlabProxy;
import matlabcontrol.MatlabProxyFactory;
import matlabcontrol.MatlabProxyFactoryOptions;


import java.util.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author richarddavies
 */


public class Typ_MatlabGraph {
    
    
    static LinkedList<profile> people = new LinkedList();
    static LinkedList<edge> tie = new LinkedList();
    int fndUser = 0;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MatlabConnectionException, MatlabInvocationException{
    
    
    //Create a proxy, which we will use to control MATLAB
    //MatlabProxyFactory factory = new MatlabProxyFactory();
    //MatlabProxy proxy = factory.getProxy();

    MatlabProxyFactoryOptions options = new MatlabProxyFactoryOptions.Builder()
    .setUsePreviouslyControlledSession(true)
    .setHidden(true)
    .setMatlabLocation(null).build(); 

    MatlabProxyFactory factory = new MatlabProxyFactory(options);
    MatlabProxy proxy = factory.getProxy();    
        
    try{
            people = encryptOut.importer();
            //encryptOut.exporter(people);
            
            
           
       }
        catch(IOException ex){
        
            System.out.println(" error msg: "+ex);
        }
    
    try {
    
        tie = edge.importer();
       
    }
    
    catch(IOException ex){
    
        System.out.println("error msg: "+ex);
    }
    
    
    proxy.eval("adjMatrix = zeros("+people.size()+","+people.size()+")");
    
   
    
    for (int y = 0; y < people.size(); y++){
    
        System.out.println("id: "+people.get(y).idProf+" name : "+people.get(y).firstName+" Gender: "+people.get(y).gender+" Nationality: "+people.get(y).nat);
        
        for (int i = 0; i < tie.size(); i++){
        
            if (people.get(y).idProf == tie.get(i).i){
                
                int index_b = search.search(tie.get(i).j);
                int index_a = y;
                
                System.out.println(people.get(y).firstName+" Knows: "+people.get(index_b).firstName);
                
                index_b ++;
                index_a ++;
                
                proxy.eval("adjMatrix("+index_a+","+index_b+") = 1");
                
                
            }
            
        }
        
    }
    
    
    encryptOut.exporter(people, proxy);
    
   //Set a variable, add to it, retrieve it, and print the result
    //proxy.setVariable("a", 5);
    
   
    
    //double result = ((double[]) proxy.getVariable("a"))[0];
    
    //System.out.println("Result: " + result);
    
    proxy.disconnect();
    
  
}
    
    

}
