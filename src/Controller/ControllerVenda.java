/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ModelVenda;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import outstok.conectaBanco;
import static outstok.conectaBanco.conn;

/**
 *
 * @author lukaa
 */
public class ControllerVenda {

    conectaBanco con = new conectaBanco();

    int codProduto;

    public void adicionaItem(ModelVenda mod) {
        acharProduto(mod.getNome_produto());
        try {
            PreparedStatement pst = conn.prepareStatement("INSERT INTO "
                    + "produtos_has_venda (produtos_id, venda_id,"
                    + " quantidade) VALUES (?, ?, ?)");
            pst.setInt(1,codProduto);
            pst.setInt(2, mod.getId());
            pst.setInt(3, mod.getQuantidade());
            pst.execute();
            con.executaSQL("SELECT * FROM produtos WHERE id='"+codProduto+"'");
            con.rs.first();           
            //baixa de estoque
            int qtd = con.rs.getInt("quantidade");
            int resul = qtd - mod.getQuantidade();
            pst = conn.prepareStatement("UPDATE produtos SET quantidade =? WHERE id =?");
            pst.setInt(1, resul);
            pst.setInt(2, codProduto);
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ControllerVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void finalizarVenda(ModelVenda mod){
        try {
            PreparedStatement pst = conn.prepareStatement("UPDATE venda SET data_venda"
                    + " = ?, valor_venda = ?, pagamento = ? WHERE id = ?" );
            pst.setString(1, mod.getData_venda());
            pst.setFloat(2, mod.getValor());
            pst.setString(3, mod.getForma());
            pst.setInt(4, mod.getId());
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO" +ex);
        }
                
    }
    public void acharProduto(String nome) {
        con.executaSQL("SELECT * FROM venda WHERE nome='" + nome + "'");
        try {
            con.rs.first();
            codProduto = con.rs.getInt("id");
        } catch (SQLException ex) {
            Logger.getLogger(ControllerVenda.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void cancelaVenda(){
        try {
            PreparedStatement pst = conn.prepareStatement("DELETE FROM venda WHERE valor_venda = ?");
            pst.setInt(1, 0);
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ControllerVenda.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao Cancelar Venda");
        }
    }
}
