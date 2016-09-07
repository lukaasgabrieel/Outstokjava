/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ModelFornecedor;
import outstok.conectaBanco;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author lukaa
 */
public class ControllerFornecedor {

    conectaBanco conn = new conectaBanco();

    public void Save(ModelFornecedor mod) {
        try {
            PreparedStatement pst = conn.conn.prepareStatement("INSERT INTO fornecedor (nome, telefone,"
                    + "celular, endereco, bairro, Cidade_id, email, cnpj, observacao) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getTelefone());
            pst.setString(3, mod.getCelular());
            pst.setString(4, mod.getEndereco());
            pst.setString(5, mod.getBairro());
            pst.setInt(6, mod.getCidade_id());
            pst.setString(7, mod.getEmail());
            pst.setString(8, mod.getCnpj());
            pst.setString(9, mod.getObservacao());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar " + ex);
        }

    }

    public void Delete(ModelFornecedor mod) {
        try {
            PreparedStatement pst = conn.conn.prepareStatement("DELETE FROM fornecedor WHERE id = ?");
            pst.setInt(1, mod.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Deletado com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Deletar " + ex);
        }
    }

    public void Update(ModelFornecedor mod) {
        try {
            PreparedStatement pst = conn.conn.prepareStatement("UPDATE fornecedor SET nome = ?, telefone = ?,"
                    + " celular = ?,endereco = ?, bairro = ?, Cidade_id = ?, email = ?, cnpj = ?, observacao = ?"
                    + " WHERE id = ?");
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getTelefone());
            pst.setString(3, mod.getCelular());
            pst.setString(4, mod.getEndereco());
            pst.setString(5, mod.getBairro());
            pst.setInt(6, mod.getCidade_id());
            pst.setString(7, mod.getEmail());
            pst.setString(8, mod.getCnpj());
            pst.setString(9, mod.getObservacao());
            pst.setInt(10, mod.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Editado com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Editar" + ex);
        }
    }
}
