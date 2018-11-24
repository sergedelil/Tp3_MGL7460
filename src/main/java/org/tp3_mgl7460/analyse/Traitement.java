
package org.tp3_mgl7460.analyse;

import static org.tp3_mgl7460.analyse.Createur.*;
import org.tp3_mgl7460.domain.Architecte;
import org.tp3_mgl7460.domain.Membre;

public class Traitement {
    
    public static void traiterDemande(String inputFile, String categories, String output) throws Exception{
        
        Membre membre = chargerFormation(inputFile, categories);
        Message msg = new Message(output);
        validerDemandeur(membre, msg);
        if(membre.examinerDemande(msg)){
            msg.init();
            msg.save();
            msg.show();
        }
    }
    
    private static void validerDemandeur(Membre membre, Message msg){
        
        if (! membre.validerNom())
            msg.getErreurs().add("Le nom du demandeur n'est pas valide");
        if(! membre.validerPrenom())
            msg.getErreurs().add("Le prenom du demandeur n'est pas valide");
        if (! membre.validerSexe())
            msg.getErreurs().add("Le sexe du demandeur n'est pas valide");
        if (! membre.validerNumeroPermis())
            msg.getErreurs().add("Le numero du permis du demandeur n'est pas valide");
        if (! membre.validerCycle())
            msg.getErreurs().add("Le cycle du demandeur n'est pas valide");
        if (! membre.validerOrdre())
            msg.getErreurs().add("L'ordre du demandeur n'est pas valide");
        if( membre instanceof Architecte)
            if (! ((Architecte) membre).validerHeureTranferee())
                msg.getErreurs().add("le nombre d'heures transférées n'est pas valide");
    }
    
}
