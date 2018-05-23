/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletim.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mircio
 */
public class DBconnect {
    
    private static Connection conexao = null;

    public static Connection getConnection() throws SQLException {
        if (conexao == null) {
            String url = "jdbc:mysql://localhost/boletimdb";
            String pass = "root";
            String user = "root";

            conexao = DriverManager.getConnection(url, user, pass);
        }

        return conexao;
    }
    
}
