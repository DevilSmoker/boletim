/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletim.dao;

import boletim.database.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mircio
 */
public class DAOprofessor extends DAOgenerico{
    
   // Connection c = DBconnect.getConnection();

    @Override
    public void adicionar() throws SQLException {
        super.adicionar(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet listar() {
        
       
        PreparedStatement t = null;
        ResultSet res = null;
        try{
            String sql = "select * from professor";
            Connection c = DBconnect.getConnection();
            t = c.prepareStatement(sql);
            res = t.executeQuery(); 
            
            while(res.next()){
                
            }
            
        } catch (SQLException ex) {
            
            System.out.println("Erro 404 Not Found! "+ex);
            Logger.getLogger(DAOalunos.class.getName()).log(Level.SEVERE, null, ex);
        }
                      
        return res;
        
       // super.listar(); //To change body of generated methods, choose Tools | Templates.
    }

    public void alterar() {
       // super.alterar(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar() {
        //super.atualizar(); //To change body of generated methods, choose Tools | Templates.
    }

    public void remover() {
       // super.remover(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
