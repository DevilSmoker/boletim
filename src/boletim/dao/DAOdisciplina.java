/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletim.dao;

import boletim.database.DBconnect;
import boletim.model.Disciplina;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mircio
 */
public class DAOdisciplina extends DAOgenerico{
    
    @Override
    public void adicionar() {
        
        
        //super.adicionar(); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Disciplina> read() throws SQLException{
        
        PreparedStatement t = null;
        ResultSet res = null;
        
        ArrayList<Disciplina> disciplinas = new ArrayList<>();
        
            String sql = "select * from disciplina";  
            Connection c = DBconnect.getConnection();
            t = c.prepareStatement(sql);
            res = t.executeQuery(); 
            
            
            while(res.next()){
                Disciplina d = new Disciplina();
                
                d.setId(" "+res.getInt("iddisciplina"));
                d.setNome(res.getString("nome"));
                d.setHora(" "+res.getInt("horas"));
                
                disciplinas.add(d);
            } 
                  
        return disciplinas;
        
        // https://www.youtube.com/watch?v=IWcV-9Lcu64
        
        //return super.listar(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
  
    
}
