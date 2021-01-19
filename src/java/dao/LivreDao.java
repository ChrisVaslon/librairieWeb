/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import entites.Livre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
            while(rs.next()){
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

}
