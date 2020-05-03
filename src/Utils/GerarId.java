/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.Random;

/**
 *
 * @author 55419
 */
public class GerarId {
    
   public String GerarHex(){      
        String letras = "abcdef0123456789";  

        Random random = new Random();  

        String armazenaChaves = "";  
        int index = -1;  

        for( int i = 0; i < 8; i++ ) {  
           index = random.nextInt( letras.length() );  
           armazenaChaves += letras.substring( index, index + 1 );  
        }
        
        return  armazenaChaves;
       
   }

   
    
}
