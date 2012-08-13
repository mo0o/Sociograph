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
import java.lang.*;
import java.io.*;


public class edge {
    
    //LinkedList<edge> tie = new LinkedList<edge>();
    Long i, j;
    
    
    public edge(long i, long j){
        
        this.i = i;
        this.j = j;
      }
    
    public Long get_i(Long i){
        
        return i;
       }
    
    public void set_i(Long i){
    
        this.i = i;
    }
    
    public static LinkedList<edge> importer(MatlabProxy proxy) throws IOException, MatlabConnectionException, MatlabInvocationException {
        
        Scanner sFile;
        edge entry;
        LinkedList<edge> tie = new LinkedList<edge>();
        Long k, p;
        
        try{
            sFile = new Scanner (new File("/Users/richarddavies/NetBeansProjects/typ_MatlabGraph/edges.dat"));
            
            System.out.println(sFile.nextLine());
          
                 while(sFile.hasNext()){

                         String edge = sFile.nextLine();
                         //System.out.println(edge);
                         
                         Scanner edgeScan = new Scanner(edge);
                         edgeScan.useDelimiter(",");
                         

                      while(edgeScan.hasNext()){

                         
                                  k = edgeScan.nextLong();
                                 System.out.print(k+" ");
                                 
                                 String ident_k = String.valueOf(k);
                                  String rot_Id_k = rot13.encrypt(ident_k);
                                  Long rot_k = Long.parseLong(rot_Id_k);
                                  
                                 
                                  p = edgeScan.nextLong();
                                System.out.print(p);
                                 
                                 String ident_p = String.valueOf(p);
                                  String rot_Id_p = rot13.encrypt(ident_p);
                                  Long rot_p = Long.parseLong(rot_Id_p);
                                  
                                 //System.out.println(rot_k+" : "+rot_p);
                                  entry = new edge( k, p);
                                  
                                  int n = search.search(k);
                                  int m = search.search(p);
                                  System.out.print(" : "+Typ_MatlabGraph.people.get(n).idProf+" "+Typ_MatlabGraph.people.get(m).idProf);
                                  System.out.println("");
                                  n++;
                                  m++;
                                  
                                  proxy.eval("adjMatrix("+n+","+m+") = 1");
                                  
                                  tie.add(entry);                      
                                }
                          
                                    
                     }
                 
                
          
             }
      
        catch(IOException ex){
                       
                                System.out.println("(No System File profile.txt)"+ex);
                            }
    
     return tie;
       
    }
}
