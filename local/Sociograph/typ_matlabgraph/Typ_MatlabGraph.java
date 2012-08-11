/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package typ_matlabgraph;

import matlabcontrol.MatlabConnectionException;
import matlabcontrol.MatlabInvocationException;
import matlabcontrol.MatlabProxy;
import matlabcontrol.MatlabProxyFactory;


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
    public static void main(String[] args) throws MatlabConnectionException, MatlabInvocationException
{
    
    
    //Create a proxy, which we will use to control MATLAB
    //MatlabProxyFactory factory = new MatlabProxyFactory();
    //MatlabProxy proxy = factory.getProxy();

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
    
   //Set a variable, add to it, retrieve it, and print the result
    //proxy.setVariable("a", 5);
    //proxy.eval("a = sqrt(a)");
   
    
    //double result = ((double[]) proxy.getVariable("a"))[0];
    
    //System.out.println("Result: " + result);
    
    //proxy.disconnect();
    
    //String name = "1234";
    
    //System.out.println("name = "+name);
    
    //rot13.encrypt(name);
}
    
    

}
