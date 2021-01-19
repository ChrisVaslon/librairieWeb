/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author Win 7
 */
public class Tva {
    private int id;
    private String label;
    private float taux;

    public Tva() {
    }

    public Tva(int id, String label, float taux) {
        this.id = id;
        this.label = label;
        this.taux = taux;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public float getTaux() {
        return taux;
    }

    public void setTaux(float taux) {
        this.taux = taux;
    }

    @Override
    public String toString() {
        return "Tva{" + "id=" + id + ", label=" + label + ", taux=" + taux + '}';
    }
    
}
