/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio3.metodos;

import java.util.Random;

/**
 *
 * @author Leandro
 */
public class RandomBanco {

    public int[] RandomBancoOrdem() {
        Random random = new Random();
        int numero = random.nextInt(3);
        int banco[] = new int[3];
        switch(numero){
            case 0:
                banco[0] = 0;
                banco[1] = 1;
                banco[2] = 2;
                break;
            case 1:
                banco[0] = 1;
                banco[1] = 0;
                banco[2] = 2;
                break;
            case 2:   
                banco[0] = 2;
                banco[1] = 0;
                banco[2] = 1;
                break;
        }   
        return banco;
    }      
    
}
