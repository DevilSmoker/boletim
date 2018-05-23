/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletim.dao;

import boletim.database.DBconnect;
import boletim.model.Aluno;
import boletim.model.Nota;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author mircio
 */
public class DAOnotas extends DAOgenerico{
    
    Aluno a = new Aluno();
    
    Nota n = new Nota();
    
    @Override
    public void adicionar() throws SQLException {
        String sql;
        
        Connection c = DBconnect.getConnection();
        
        if(n.getNotaFinal() != null){
            sql = "insert into nota (av1, av2, media, final, aluno_fk) "
                                    + "values (?, ?, ?, ?)";
            
            PreparedStatement t = c.prepareStatement(sql);
                t.setFloat(1, n.getAv1());
                t.setFloat(2, n.getAv2());
                t.setFloat(3, n.getMedia());
                t.setFloat(4, n.getNotaFinal());
                t.setInt  (5, Integer.parseInt(a.getMatricula()));
                
                t.execute();  
                t.close(); 
                
        }else{
            sql = "insert into nota (av1, av2, media, aluno_fk) "
                             + "values (?, ?, ?, ?)";
        
            PreparedStatement t = c.prepareStatement(sql);
                t.setFloat(1, n.getAv1());
                t.setFloat(2, n.getAv2());
                t.setFloat(3, n.getMedia());
                t.setInt  (4, Integer.parseInt(a.getMatricula()));
                
                t.execute();  
                t.close();    
        
        }
        
    }
    
    
    //super.
    
}
