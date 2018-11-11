/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tp3_mgl7460.main;


import java.io.IOException;
import static org.tp3_mgl7460.analyse.Traitement.*;
/**
 *
 * @author sergedelil
 */
public class FormationContinue {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException{
        
        if (args.length != 3){
            System.out.println("Le chemin du fichier manque...");
        }else { 
            traiterDemande(args[0]);
        } 
    }
    
}
