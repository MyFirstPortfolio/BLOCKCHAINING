/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Block_Tools;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;

/**
 *
 * @author Ronald
 */
public class Block_Hash {
    
     public static String genhash(Block input, String algorithm) throws Exception{
    
        MessageDigest md =  MessageDigest.getInstance(algorithm);
        md.update(Hashing_Algorithms.salt());
        byte[] hashcode = md.digest(genbytearray(input));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < hashcode.length; i++) {
            
            sb.append(Integer.toString((hashcode[i] & 0xff) + 0x100,16)).substring(1);
        }
    
        return sb.toString();
    }
     
     
    public static byte[] genbytearray(Block blk){
    
        try {
             ByteArrayOutputStream bout = new ByteArrayOutputStream();
             ObjectOutputStream out = new ObjectOutputStream(bout);
             out.writeObject(blk);
             return bout.toByteArray();
             
        } catch (Exception e) {
        
            return null;
        }
       
    
    }
}
