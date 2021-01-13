/*
 * auteur : pham duc
 * date creation : 13/01/2021
 */
package traitements;

import java.util.HashMap;
import outils.CustomedException;

public class GestionClient {

    // proprietes
    // constructeurs
    public GestionClient() {
    }

    // mehtodes/comportements
    public void creerNouveauClient(String nom, String prenom, String email, String pwd, String pwd2) throws CustomedException {

        HashMap<String, String> erreurs = new HashMap<>();
        // verification des mots de passe
        // mdp d'au moins 8 caracteres

        if (!pwd.equals(pwd2)) {
            erreurs.put("errPwd", "Les mots de passes ne sont pas identiques");
        } else if (pwd.equals(pwd2) && pwd.length() < 8) {
            erreurs.put("errPwd", "Il faut au moins 8 caractères");
        }
        
        if(!erreurs.isEmpty()){
            CustomedException ex = new CustomedException(erreurs, "Echec de l'inscription");
            throw ex;
        }
    }

}


