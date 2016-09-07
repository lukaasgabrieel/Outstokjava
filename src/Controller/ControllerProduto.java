/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ModelProduto;
import outstok.conectaBanco;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author lukaa
 */
public class ControllerProduto {

    conectaBanco conn = new conectaBanco();

    public void Save(ModelProduto mod) {
        try {
            PreparedStatement pst = conn.conn.prepareStatement("INSERT INTO produtos (nome, preco_custo, "
                    + "preco_venda, quantidade, codigo, estoque_minimo, observacao, Fornecedor_id)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            pst.setString(1, mod.getNome());
            pst.setFloat(2, mod.getPreco_custo());
            pst.setFloat(3, mod.getPreco_venda());
            pst.setInt(4, mod.getQuantidade());
            pst.setString(5, mod.getCodigo());
            pst.setInt(6, mod.getEstoque());
            pst.setString(7, mod.getObservacao());
            pst.setInt(8, mod.getFornecedor_id());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar " + ex);
        }

    }

    public void Delete(ModelProduto mod) {
        try {
            PreparedStatement pst = conn.conn.prepareStatement("DELETE FROM produtos WHERE id = ?");
            pst.setInt(1, mod.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Deletado com Sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Deletar " + ex);
        }
    }

    public void Update(ModelProduto mod) {
        try {
            PreparedStatement pst = conn.conn.prepareStatement("UPDATE produtos SET nome = ?, preco_custo = ?, "
                    + "preco_venda = ?, quantidade = ?,codigo = ? , estoque_minimo = ?,observacao = ?, "
                    + "Fornecedor_id = ? WHERE id = ?");
            pst.setString(1, mod.getNome());
            pst.setFloat(2, mod.getPreco_custo());
            pst.setFloat(3, mod.getPreco_venda());
            pst.setInt(4, mod.getQuantidade());
            pst.setString(5, mod.getCodigo());
            pst.setInt(6, mod.getEstoque());
            pst.setString(7, mod.getObservacao());
            pst.setInt(8, mod.getFornecedor_id());
            pst.setInt(9, mod.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Editado com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Editar" + ex);
        }
    }
}
