/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import outstok.conectaBanco;
import Model.ModelCidade;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author lukaa
 */
public class ControllerCidade {

    conectaBanco conn = new conectaBanco();

    public void Save(ModelCidade mod) {
        try {
            PreparedStatement pst
                    = conn.conn.prepareStatement("INSERT INTO cidade (nome, Estado_id) VALUES (?,?)");
            pst.setString(1, mod.getNome());
            pst.setInt(2, mod.getEstado_id());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar " + ex);
        }

    }

    public void Delete(ModelCidade mod) {

        try {
            PreparedStatement pst = conn.conn.prepareStatement("DELETE FROM cidade WHERE id = ?");
            pst.setInt(1, mod.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Deletado com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Deletar " + ex);
        }

    }

    public void Update(ModelCidade mod) {
        try {
            PreparedStatement pst = conn.conn.prepareStatement("UPDATE cidade SET nome = ?, Estado_id = ? WHERE id = ?");
            pst.setString(1, mod.getNome());
            pst.setInt(2, mod.getEstado_id());
            pst.setInt(3, mod.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Editado com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Editar" + ex);
        }
    }
}
