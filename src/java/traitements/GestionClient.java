/*
 * auteur : pham duc
 * date creation : 13/01/2021
 */
package traitements;

import dao.ClientDao;
import java.sql.SQLException;
import java.util.HashMap;
import outils.CustomedException;

public class GestionClient {

    // proprietes
    private ClientDao clientDao;

    // constructeurs

    public GestionClient() {
       clientDao = new ClientDao();
    }

    // mehtodes/comportements
    public void creerNouveauClient(String nom, String prenom, String email, String pwd, String pwd2) throws CustomedException, SQLException {

        HashMap<String, String> erreurs = new HashMap<>();
        // verification des mots de passe
        // mdp d'au moins 8 caracteres

        if (!pwd.equals(pwd2)) {
            erreurs.put("errPwd", "Les mots de passes ne sont pas identiques");
            System.out.println("ERREUR MDP");
        } else if (pwd.equals(pwd2) && pwd.length() < 8) {
            erreurs.put("errPwd", "Il faut au moins 8 caractères");
        }
        int qte = clientDao.verifierExistanceEmail(email);
        if(qte > 0){
             erreurs.put("errMail", "Adresse mail déjà utilisé");
        }
        if (!erreurs.isEmpty()) {
            CustomedException ex = new CustomedException(erreurs, "Echec de l'inscription");
            throw ex;
        } else {
            clientDao.InsertClient(nom, prenom, email, pwd);
        }

    }
}
