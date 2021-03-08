/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blockchain.core;

import Block_Tools.Block;
import com.google.gson.GsonBuilder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


//strategy to be used = specific data struc...LinkedList for block storage
//Strorage facility mechanism is into file ...different times
//update
public class Blockchain {
    
    //binary file 
    
    private static final String MED_FILES = "Medical Blockchain.dat";
    //data structure
    
    public List<Block> database = new LinkedList();
    
    //persist - store the linkedlist obj to the file 
    public static void persist(LinkedList<Block> chain){
    
        //write linkedlist to binaryfile
        try {
        
            FileOutputStream fout = new FileOutputStream(MED_FILES);
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(chain);
        } 
        
        catch (Exception e) {
            e.printStackTrace();
        }
    
    }
    
    //get- retrieve the linkedlist onj from the file for new entry 
     public static LinkedList<Block> get(){
    
        //read linkedlist to binaryfile
         try {
             
             FileInputStream fis = new FileInputStream(MED_FILES);
             ObjectInputStream ois = new ObjectInputStream(fis);
             return(LinkedList<Block>)ois.readObject();
             
         } catch (Exception e) {
        
             e.printStackTrace();
             return null;
         }
                  
    }
    //distribute - display blockchain
     
     public static void distribute(LinkedList<Block> chain){
     
        try {
                       
            String temp = new GsonBuilder().setPrettyPrinting().create().toJson(chain);
            System.out.println(temp);
            
            Files.write(Paths.get( "Medical Blockchain.txt"), temp.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException ex) {
            Logger.getLogger(Blockchain.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     }
}
