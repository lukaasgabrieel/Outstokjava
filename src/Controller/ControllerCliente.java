/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ModelCliente;
import outstok.conectaBanco;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author lukaa
 */
public class ControllerCliente {

    conectaBanco conn = new conectaBanco();

    public void Save(ModelCliente mod) {
        try {
            PreparedStatement pst = conn.conn.prepareStatement("INSERT INTO cliente (nome, data_nascimento, "
              + "sexo, telefone, celular,endereco, bairro, Cidade_id, email, rg, cpf, observacao) VALUES"
              + " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getNascimento());
            pst.setString(3, mod.getSexo());
            pst.setString(4, mod.getTelefone());
            pst.setString(5, mod.getCelular());
            pst.setString(6, mod.getEndereco());
            pst.setString(7, mod.getBairro());
            pst.setInt(8, mod.getCidade_id());
            pst.setString(9, mod.getEmail());
            pst.setString(10, mod.getRg());
            pst.setString(11, mod.getCpf());
            pst.setString(12, mod.getObservacao());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar " + ex);
        }

    }

    public void Delete(ModelCliente mod) {
        try {
            PreparedStatement pst = conn.conn.prepareStatement("DELETE FROM cliente WHERE id = ?");
            pst.setInt(1, mod.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Deletado com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Deletar " + ex);
        }
    }

    public void Update(ModelCliente mod) {
        try {
            PreparedStatement pst = conn.conn.prepareStatement("UPDATE cliente SET nome = ?, "
                    + "data_nascimento = ?,sexo = ?, telefone = ?, celular = ?, endereco = ?, bairro = ?, Cidade_id = ?,"
                    + "email = ?, rg = ?, cpf = ?, observacao = ? WHERE cliente.id = ?");
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getNascimento());
            pst.setString(3, mod.getSexo());
            pst.setString(4, mod.getTelefone());
            pst.setString(5, mod.getCelular());
            pst.setString(6, mod.getEndereco());
            pst.setString(7, mod.getBairro());
            pst.setInt(8, mod.getCidade_id());
            pst.setString(9, mod.getEmail());
            pst.setString(10, mod.getRg());
            pst.setString(11, mod.getCpf());
            pst.setString(12, mod.getObservacao());
            pst.setInt(13, mod.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Editado com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Editar" + ex);
        }
    }
}
