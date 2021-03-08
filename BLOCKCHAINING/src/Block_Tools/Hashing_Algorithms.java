   /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Block_Tools;

import java.security.MessageDigest;
import java.security.SecureRandom;

/**
 *
 * @author Ronald
 */
public class Hashing_Algorithms {
    
    
    public static String genhash(String input, String algorithm) throws Exception{
    
        MessageDigest md =  MessageDigest.getInstance(algorithm);
        md.update(Hashing_Algorithms.salt());
        byte[] hashcode = md.digest(input.getBytes());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < hashcode.length; i++) {
            
            sb.append(Integer.toString((hashcode[i] & 0xff) + 0x100,16)).substring(1);
        }
    
        return sb.toString();
    }
    
    public static byte[] salt() throws Exception{
    
        SecureRandom rand = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        rand.nextBytes(salt);
        return salt;
    
    }
    
 }
