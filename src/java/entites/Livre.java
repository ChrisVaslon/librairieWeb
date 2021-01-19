/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author Win 7
 */
public class Livre {
    private String ean;
    private String titre;
    private float poids;
    
    private int nbPages;
    private Date parution;
    private int stock;
    
    private String resume; 
    private String image;
    
    private float prixHT;
    
    // propriete qui sont les associations
    private Tva tva;
    private Editeur editeur;
    private List<Auteur> auteurs;

    public Livre() {
    }

    public Livre(String ean, String titre, float poids, int nbPages, Date parution, int stock, float prixHT) {
        this.ean = ean;
        this.titre = titre;
        this.poids = poids;
        this.nbPages = nbPages;
        this.parution = parution;
        this.stock = stock;
        this.prixHT = prixHT;
    }

    public Livre(String ean, String titre, float poids, int nbPages, Date parution, int stock, String resume, String image, float prixHT, Tva tva, Editeur editeur, List<Auteur> auteurs) {
        this.ean = ean;
        this.titre = titre;
        this.poids = poids;
        this.nbPages = nbPages;
        this.parution = parution;
        this.stock = stock;
        this.resume = resume;
        this.image = image;
        this.prixHT = prixHT;
        this.tva = tva;
        this.editeur = editeur;
        this.auteurs = auteurs;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public float getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    public int getNbPages() {
        return nbPages;
    }

    public void setNbPages(int nbPages) {
        this.nbPages = nbPages;
    }

    public Date getParution() {
        return parution;
    }

    public void setParution(Date parution) {
        this.parution = parution;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getPrixHT() {
        return prixHT;
    }

    public void setPrixHT(float prixHT) {
        this.prixHT = prixHT;
    }

    public Tva getTva() {
        return tva;
    }

    public void setTva(Tva tva) {
        this.tva = tva;
    }

    public Editeur getEditeur() {
        return editeur;
    }

    public void setEditeur(Editeur editeur) {
        this.editeur = editeur;
    }

    public List<Auteur> getAuteurs() {
        return auteurs;
    }

    public void setAuteurs(List<Auteur> auteurs) {
        this.auteurs = auteurs;
    }

    @Override
    public String toString() {
        return "Livre{" + "ean=" + ean + ", titre=" + titre + ", auteurs=" + auteurs + '}';
    }
    
    
    
}
