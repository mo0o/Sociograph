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

public class profile {
    
    String firstName, gender, nat;
    long idProf;
    ArrayList friendList;
    //adjacency matrix
    
    
    
    
    public profile(long prof_id, String fName, String entSex, String nat){
    
        this.idProf = prof_id;
        this.firstName = fName;
        this.nat = nat;
        this.gender = entSex;
        this.friendList = new ArrayList();
        
    }
    
    public String getName(){
    
        return this.firstName;
    }
    
    void findProfile(){
        
    
    }
    
    void addFriend(int isFriend){
        
         this.friendList.set(isFriend,1);
        
    
    }
    
    void deleteProfile(){
    
    }
    
    void modProfile(){
    
    }
    
    //Does the adjacency matrix go here a 
    
    
}

