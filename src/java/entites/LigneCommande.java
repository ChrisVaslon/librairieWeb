
package entites;

public class LigneCommande {
    private int id;
    private float prixHT;
    private float tva;
    private int qte;
    
    private Livre livre;
    
    public LigneCommande(){
    }

    public LigneCommande(int id) {
        this.id = id;
    }

    public LigneCommande(Livre livre) {
        this.livre = livre;
        this.qte = 1;
        this.prixHT = livre.getPrixHT();
        this.tva= livre.getTva().getTaux();
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrixHT() {
        return prixHT;
    }

    public void setPrixHT(float prixHT) {
        this.prixHT = prixHT;
    }

    public float getTva() {
        return tva;
    }

    public void setTva(float tva) {
        this.tva = tva;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }
    
    
    
    
}
