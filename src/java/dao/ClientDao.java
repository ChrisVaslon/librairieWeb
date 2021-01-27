/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entites.Client;
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
    public void InsertClient(String nom, String prenom, String email, String mdp) throws SQLException {
        try (Connection cnn = mcBDD.getConnection();) {
            String sql = "INSERT INTO client(client_nom, client_prenom, client_email, client_mdp) VALUES(?, ?, ?, md5(?))";
            PreparedStatement pstm = cnn.prepareStatement(sql);
            pstm.setString(1, nom);
            pstm.setString(2, prenom);
            pstm.setString(3, email);
            pstm.setString(4, mdp);

            pstm.executeUpdate();
        }
    }

    public int verifierExistanceEmail(String email) throws SQLException {
        try (Connection cnn = mcBDD.getConnection();) {
            String sql = "SELECT COUNT(*) from client WHERE client_email = ?";
            PreparedStatement pstm = cnn.prepareStatement(sql);
            pstm.setString(1, email);
            ResultSet rs = pstm.executeQuery();
            rs.next();
            int qte = rs.getInt(1);
            return qte;
        }
    }

    public Client selectClientByEmailAndPassword(String email, String password) throws SQLException {
        Client user = null;

        try (Connection cnn = mcBDD.getConnection();) {
            String sql = "SELECT * FROM client "
                    + "WHERE client_email = ?  AND client_mdp = md5(?)";
            PreparedStatement pstm = cnn.prepareStatement(sql);
            pstm.setString(1, email);
            pstm.setString(2, password);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                user = new Client();
                
                user.setNom(rs.getString("client_nom"));
                user.setPrenom(rs.getString("client_prenom"));
                user.setEmail(rs.getString("client_email"));
                user.setId(rs.getInt("client_id"));
            }

        }
        return user;
    }
}
