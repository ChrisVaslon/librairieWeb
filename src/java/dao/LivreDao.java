/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entites.Editeur;
import entites.Livre;
import entites.Tva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Win 7
 */
public class LivreDao {

    private MaConnexionBDD mcBDD;

    public LivreDao() {
        this.mcBDD = new MaConnexionBDD();
    }

    public void setMcBDD(MaConnexionBDD mcBDD) {
        this.mcBDD = mcBDD;
    }

    // les methodes pour executer le sql
    public List<Livre> selectAllLivres() throws SQLException {
        List<Livre> livres = new ArrayList<>();

        try (Connection cnn = mcBDD.getConnection()) {
            String sql = "SELECT * FROM livre";
            PreparedStatement pstm = cnn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Livre lv = new Livre();
                String titre = rs.getString("livre_titre");
                lv.setTitre(titre);
                lv.setEan(rs.getString("livre_ean"));
                lv.setImage(rs.getString("livre_image"));
                lv.setPrixHT(rs.getFloat("livre_prixHT"));
                livres.add(lv);
            }
        }

        return livres;
    }

    public Livre selectUnLivreAvecEan(String ean) throws SQLException, ParseException {

        Livre lv = null;

        try (Connection cnn = mcBDD.getConnection()) {
            String sql = "SELECT * FROM livre AS l "
                    + "JOIN tva AS t ON l.tva_id = t.tva_id "
                    + "JOIN editeur AS e ON l.editeur_id = e.editeur_id "
                    + "WHERE l.livre_ean = ?";
            PreparedStatement pstm = cnn.prepareStatement(sql);
            pstm.setString(1, ean);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                lv = new Livre();
                String titre = rs.getString("livre_titre");
                lv.setTitre(titre);
                lv.setEan(rs.getString("livre_ean"));
                lv.setImage(rs.getString("livre_image"));
                lv.setPrixHT(rs.getFloat("livre_prixHT"));
                lv.setResume(rs.getString("livre_resume"));
                lv.setPoids(rs.getFloat("livre_poids"));
                lv.setNbPages(rs.getInt("livre_nb_pages"));

                String dateStr = rs.getString("libre_parution");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date dateParution = sdf.parse(dateStr);
                lv.setParution(dateParution);

                //tva
                int idTva = rs.getInt("tva_id");
                String labelTva = rs.getString("tva_label");
                float tauxTva = rs.getFloat("tva_taux");

                Tva tva = new Tva(idTva, labelTva, tauxTva);
                lv.setTva(tva);

                //editeur
                int idEditeur = rs.getInt("editeur_id");
                String nomEditeur = rs.getString("editeur_nom");

                Editeur ed = new Editeur(idEditeur, nomEditeur);
                lv.setEditeur(ed);
            }

        }
        return lv;
    }

}
