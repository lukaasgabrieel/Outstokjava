/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author lukaa
 */
public class ModelProduto {
    private int id;
    private String nome;
    private Float preco_custo;
    private Float preco_venda;
    private int quantidade;
    private String codigo;
    private int estoque;
    private String observacao;
    private int Fornecedor_id;
    private int Categorias_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getPreco_custo() {
        return preco_custo;
    }

    public void setPreco_custo(Float preco_custo) {
        this.preco_custo = preco_custo;
    }

    public Float getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(Float preco_venda) {
        this.preco_venda = preco_venda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public int getFornecedor_id() {
        return Fornecedor_id;
    }

    public void setFornecedor_id(int Fornecedor_id) {
        this.Fornecedor_id = Fornecedor_id;
    }

    public int getCategorias_id() {
        return Categorias_id;
    }

    public void setCategorias_id(int Categorias_id) {
        this.Categorias_id = Categorias_id;
    }
    
    
    
}
