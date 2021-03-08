/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Block_Tools;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import org.javatuples.Quartet;

/**
 *
 * @author Ronald
 */
public class Block implements Serializable {
   
    private String Hashed_data;
    private String previoushash;
    private String currenthash;
    private long timestamp;

    //TRIAL one
    public Block(String previoushash) {
        this.Hashed_data = this.actualblockhash("", "SHA-256");
        this.currenthash = this.actualblockhash("", "SHA-256");
        this.previoushash = previoushash;
        this.timestamp= Calendar.getInstance().getTimeInMillis();
    }
  
    //ORIGINAL METHOD
// public Block(List<Quartet<String, String, String, String>> Hashed_data, String previoushash) {
//        this.Hashed_data = Hashed_data;
//        this.currenthash = this.actualblockhash("", "SHA-256");
//        this.previoushash = previoushash;
//         this.timestamp= Calendar.getInstance().getTimeInMillis();

    public String getBlocked_data() {
        return Hashed_data;
    }

    public void setBlocked_data(String Blocked_data) {
        this.Hashed_data = Blocked_data;
    }

    public String getPrevioushash() {
        return previoushash;
    }

    public void setPrevioushash(String previoushash) {
        this.previoushash = previoushash;
    }

    public String getCurrenthash() {
        return currenthash;
    }

    public void setCurrenthash(String currenthash) {
        this.currenthash = currenthash;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    
    
 
    public String actualblockhash(String input, String algorithm){
    
        try {
        
            return Block_Hash.genhash(this, algorithm);
        } 
        
        catch (Exception e) {
            
            return null;
        }
    
    
    }
    
}
