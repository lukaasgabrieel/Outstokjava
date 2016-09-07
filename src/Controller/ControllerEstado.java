/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import outstok.conectaBanco;
import Model.ModelCidade;
import Model.ModelEstado;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author lukaa
 */
public class ControllerEstado {

    conectaBanco conn = new conectaBanco();

    public void Save(ModelEstado mod) {
        try {
            PreparedStatement pst
                    = conn.conn.prepareStatement("INSERT INTO estado (nome, sigla) VALUES (?,?)");
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getSigla());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar " + ex);
        }

    }

    public void Delete(ModelEstado mod) {
        try {
            PreparedStatement pst = conn.conn.prepareStatement("DELETE FROM estado WHERE id = ?");
            pst.setInt(1, mod.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Deletado com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Deletar " + ex);
        }
    }

    public void Update(ModelEstado mod) {
        try {
            PreparedStatement pst = conn.conn.prepareStatement("UPDATE estado SET nome = ?, sigla = ? WHERE id = ?");
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getSigla());
            pst.setInt(3, mod.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Editado com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Editar" + ex);
        }
    }
}
