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

/**
 *
 * @author richarddavies
 */
import java.util.*;
import java.lang.*;
import java.io.*;

public class encryptOut {
    
    
    public static LinkedList<profile> importer() throws IOException {
 
  
     LinkedList<profile> people = new LinkedList<profile>();
     Scanner sFile;
     profile entry;
    
          
        try{
            sFile = new Scanner (new File("/Users/richarddavies/NetBeansProjects/typ_MatlabGraph/users.dat"));
            sFile.nextLine();
                 while(sFile.hasNext()){

                         String profile = sFile.nextLine();
                         //System.out.println(profile);
                         
                         Scanner profScan = new Scanner(profile);
                         profScan.useDelimiter(",");
                         

                      while(profScan.hasNext()){
                              

                                  Long id = profScan.nextLong();
                                  String ident = String.valueOf(id);
                                  String rot_Id = rot13.encrypt(ident);
                                  Long rot_IntId = Long.parseLong(rot_Id);
                                  
                                  String fname = profScan.next();
                                  String rot_Name = rot13.encrypt(fname);
                                  //String sname = profScan.next();
                                  //int age = profScan.nextInt();
                                  String gender = profScan.next();
                                  String nat = profScan.next();

                                  entry = new profile( id, fname, gender, nat);
                                  //System.out.println("id: "+id+" name: "+fname+" gender: "+gender+" nationality: "+nat);
                                  //System.out.println("id: "+rot_IntId+" name: "+rot_Name+" gender: "+gender+" nationality: "+nat);
                                  people.add(entry);                      
                                }
                          
                                    
                     }
          
             }
      
        catch(IOException ex){
            //return people;
                       
                                System.out.println("(No System File profile.txt)"+ex);
                            }
        return people;
 }
    

     public static void exporter(LinkedList<profile> usr, MatlabProxy proxy) throws MatlabConnectionException, MatlabInvocationException{
    
        String file = "/Users/richarddavies/NetBeansProjects/typ_MatlabGraph/rotCmp_2012.txt";
        int i = 0;
        
       
        try{
            
                double result;
                int index_a = 0;
                int index_b = 0;
                int item;
            
                FileWriter fw = new FileWriter (file);
                BufferedWriter bw = new BufferedWriter (fw);
                PrintWriter outFile = new PrintWriter(bw);
                    
                outFile.println("nodedef>name VARCHAR,label VARCHAR,sex VARCHAR,locale VARCHAR");
                
                
                    for(i = 0; i < usr.size(); i++){

                            outFile.println(usr.get(i).idProf+","+usr.get(i).firstName+","+usr.get(i).gender+","+usr.get(i).nat);
                            
                        }
                    
                    outFile.println("edgedef>node1 VARCHAR,node2 VARCHAR");

                 
                    
                    for (i = 0; i < usr.size(); i++){
                        
                        System.out.println(usr.get(i).firstName+": ");
                    
                        for (int j = 0; j < usr.size(); j++){
                            
                            index_a = i + 1;
                            index_b = j + 1;
                            
                            
                        
                          // result = proxy.getVariable("adjMatrix("+index_a+","+index_b+");");
                           
                           result = ((double[]) proxy.getVariable("adjMatrix("+index_a+","+index_b+");"))[0];
                           
                           item = (int)result;
                           
                           //item = ((Integer)result).intValue();
                           //System.out.println(result);
                           if (item == 1){
                               
                               System.out.print(" ("+usr.get(j).firstName+") ");
                           
                               outFile.println(usr.get(i).idProf+","+usr.get(j).idProf);
                           }
                        }
                        
                        System.out.println(" ");
                        System.out.println(" ");
                        System.out.println(" ");
                        System.out.println(" ");
                    }
                    
                    outFile.close();
                }
             
                 catch(IOException ex){
                                        System.out.println(" error : "+ex);
                                        }
        
        
      
        
    }
}

