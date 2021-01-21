/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traitements;

import dao.LivreDao;
import entites.Livre;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author Win 7
 */
public class GestionLivre {
    private LivreDao livreDao;
    
    public GestionLivre(){
        this.livreDao = new LivreDao();
    }
    
    // methodes
    
    public List<Livre> selectAllLivres() throws SQLException{
        return livreDao.selectAllLivres();

    }
    
       public Livre selectUnLivreAvecEan(String ean) throws SQLException, ParseException{
           Livre lv = null;
           if(ean == null || ean.trim().isEmpty()){
               return null;
           } else {
               ean = ean.trim();
               lv = livreDao.selectUnLivreAvecEan(ean);
               return lv;
           }
       

    }
}
