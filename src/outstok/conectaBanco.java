/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outstok;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author lukaa
 */
public class conectaBanco {

    public static Statement stm;
    public static ResultSet rs;
    private String driver = "com.mysql.jdbc.Driver";
    private String caminho = "jdbc:mysql://localhost/outstok";
    private String usuario = "root";
    private String senha = "";
    public static Connection conn;

    public void conexao() {
        System.setProperty("jdbc.Drivers", driver);
        try {
            conn = DriverManager.getConnection(caminho, usuario, senha);
        } catch (SQLException ex) {
            Logger.getLogger(conectaBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void executaSQL(String sql) {
        try {
            stm = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger("Erro ao executar SQL" + ex);
        }
    }
}
