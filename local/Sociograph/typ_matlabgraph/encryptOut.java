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
                         System.out.println(profile);
                         
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
                                  System.out.println("id: "+rot_IntId+" name: "+rot_Name+" gender: "+gender+" nationality: "+nat);
                                  people.add(entry);                      
                                }
                          
                                    
                     }
          
             }
      
        catch(IOException ex){
            return people;
                       
                                //System.out.println("(No System File profile.txt)"+ex);
                            }
        return people;
 }
    

     public static void exporter(LinkedList<profile> usr) {
    
        String file = "/Users/richarddavies/NetBeansProjects/typ_MatlabGraph/rotCmp_2012.txt";
        int i = 0;
       
        try{
                FileWriter fw = new FileWriter (file);
                BufferedWriter bw = new BufferedWriter (fw);
                PrintWriter outFile = new PrintWriter(bw);
                    
                outFile.println("nodedef>name VARCHAR,label VARCHAR,sex VARCHAR,locale VARCHAR");
                outFile.println();
                
                    for(i = 0; i < usr.size(); i++){

                            outFile.print (usr.get(i).idProf+","+usr.get(i).firstName+","+usr.get(i).gender+","+usr.get(i).nat);
                            outFile.println();
                        }
                    outFile.close();
                }
             
                 catch(IOException ex){
                                        System.out.println(" error : "+ex);
                                        }
        
        
      
        
    }
}

