/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Win 7
 */
public class ClientDao {
    private MaConnexionBDD mcBDD;

    public ClientDao() {
        mcBDD = new MaConnexionBDD();
    }

    public MaConnexionBDD getMcBDD() {
        return mcBDD;
    }

    public void setMcBDD(MaConnexionBDD mcBDD) {
        this.mcBDD = mcBDD;
    }
    
    // methode pour executer les requetes sql
    public void InsertClient(String nom, String prenom, String email, String mdp) throws SQLException{
        try(Connection cnn = mcBDD.getConnection();){
            String sql = "INSERT INTO client(client_nom, client_prenom, client_email, client_mdp) VALUES(?, ?, ?, md5(?))";
            PreparedStatement pstm = cnn.prepareStatement(sql);
            pstm.setString(1, nom);
            pstm.setString(2, prenom);
            pstm.setString(3, email);
            pstm.setString(4, mdp);
            
            pstm.executeUpdate();
        }
    }
    
    public int verifierExistanceEmail(String email)throws SQLException{
                try(Connection cnn = mcBDD.getConnection();){
            String sql = "SELECT COUNT(*) from client WHERE client_email = ?";
            PreparedStatement pstm = cnn.prepareStatement(sql);
            pstm.setString(1, email);
            ResultSet rs = pstm.executeQuery();
            rs.next();
            int qte = rs.getInt(1);
            return qte;
        }
    }
    
}
