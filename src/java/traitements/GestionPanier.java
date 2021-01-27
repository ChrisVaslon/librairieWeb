/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traitements;

import dao.LivreDao;
import entites.LigneCommande;
import entites.Livre;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author Win 7
 */
public class GestionPanier {

    // panier propre a un utilisateur
    private HashMap<String, LigneCommande> panier;
    private LivreDao livreDao;

    public GestionPanier() {
        this.panier = new HashMap<>();
        this.livreDao = new LivreDao();
    }

    public void addLivre(String ean) throws SQLException, ParseException {
        if (ean == null || ean.trim().isEmpty()) {
            return;
        }

        ean = ean.trim();

        if (panier.containsKey(ean)) {
            LigneCommande lc = panier.get(ean);
            int newQte = lc.getQte() + 1;
            lc.setQte(newQte);
        } else {
            Livre lv = this.livreDao.selectUnLivreAvecEan(ean);
            if (lv != null) {
                LigneCommande lc = new LigneCommande(lv);
                panier.put(ean, lc);
            }

        }

    }

    public void viderPanier() {
        this.panier.clear();
    }

    public Collection<LigneCommande> getAllLignesPanier() {
        return this.panier.values();
    }

    public int CompterArticles() {
        int somme = 0;
        Collection<LigneCommande> lignes = this.getAllLignesPanier();
        for (LigneCommande lc : lignes) {
            somme += lc.getQte();
        }
        return somme;
    }
}
