
package org.tp3_mgl7460.main;


import java.io.IOException;
import static javafx.application.Platform.exit;
import static org.tp3_mgl7460.analyse.Traitement.*;
import org.tp3_mgl7460.file.FormationContinueException;

public class FormationContinue {

    
    public static void main(String[] args) throws IOException, Exception, FormationContinueException{
        
        if (args.length != 3){ 
            System.out.println("nombre d'arguments invalide...");
            exit();
        }
        try{
            traiterDemande(args[0], args[1], args[2]);
        }catch(FormationContinueException e)
        {
            System.out.println(e.toString());
        }
        
    }
    
}
