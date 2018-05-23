/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletim.dao;

import boletim.database.DBconnect;
import boletim.model.Aluno;
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
public class DAOalunos extends DAOgenerico{
    
    Aluno aluno = new Aluno();

    @Override
    public void adicionar() throws SQLException{
        
        
        if(aluno.getStatus().equals(null)){
             String sql = "insert into aluno (matricula, nome, status) "
                                             + "values (?, ?, ?, ?)";
        
        
       
            Connection c = DBconnect.getConnection();
        
        
            PreparedStatement t = c.prepareStatement(sql);
                t.setInt(1, Integer.parseInt(aluno.getMatricula()));
                t.setString(2, aluno.getNome());
                t.setString(3, aluno.getStatus());
                
               // t.setString(4, aluno.getEnd());
                
                t.execute();  
                t.close();
        }else{
            
            String sql = "insert into aluno (matricula, nome) "
                + "values (?, ?, ?, ?)";
        
        
       
              Connection c = DBconnect.getConnection();
        
        
            PreparedStatement t = c.prepareStatement(sql);
                t.setInt(1, Integer.parseInt(aluno.getMatricula()));
                t.setString(2, aluno.getNome());
                //t.setString(3, aluno.getStatus());
                
               // t.setString(4, aluno.getEnd());
                
                t.execute();  
                t.close();
            
        }
            
        
        
        //super.adicionar(); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Aluno> read() throws SQLException{
        
        PreparedStatement t = null;
        ResultSet res = null;
        
        ArrayList<Aluno> alunos = new ArrayList<>();
        
            String sql = "select * from aluno";
            Connection c = DBconnect.getConnection();
            t = c.prepareStatement(sql);
            res = t.executeQuery(); 
            
            
            while(res.next()){
                Aluno a = new Aluno();
                
                a.setMatricula(" "+res.getInt("matricula"));
                a.setNome(res.getString("nome"));
                a.setStatus(" "+res.getString("status"));
                
                alunos.add(a);
            } 
                  
        return alunos;
        
        // https://www.youtube.com/watch?v=IWcV-9Lcu64
        
        //return super.listar(); //To change body of generated methods, choose Tools | Templates.
    }
    
    //super.
    
}
