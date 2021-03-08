/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Block_Tools;

import Blockchain.core.Blockchain;
import java.util.LinkedList;

/**
 *
 * @author Ronald
 */
public class Blockchain_Test {
    
    
    private static LinkedList<Block> temp;
    

    //genesis block(very first block in a chain)
    public static void firstblock(){
    
        Block block = new Block("0");
        //System.out.println("Blocked data: "+block.actualblockhash("", "SHA-256"));
        temp = new LinkedList();
        temp.add(block);
        Blockchain.persist(temp);
        Blockchain.distribute(temp);
    }
    
    
    public static void nextblock(){
    //get existing block from the chain as in the ;ast block
     temp = Blockchain.get();
     String lastblockhash = temp.getLast().getCurrenthash();
     Block newblock = new Block(lastblockhash);
     temp.add(newblock);
     Blockchain.persist(temp);
     Blockchain.distribute(temp);
    
    
    }
    
    
    
    
    public static void main(String[] args) {
        
      //firstblock();
       nextblock();
        
//        Block block = new Block("Ron","0");
//        System.out.println("(Block-1): "+block.actualblockhash("", "MD5"));
//              
//        Block block1 = new Block("Rona","1");
//        System.out.println("(Block-2): "+block1.actualblockhash("", "MD5"));
//                
//        Block block2 = new Block("Fai","2");
//        System.out.println("(Block-3): "+block2.actualblockhash("", "SHA-256"));
//           
//        System.out.println("DONE");
        
    }
}
