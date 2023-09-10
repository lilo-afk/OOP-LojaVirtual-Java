package Loja;

import java.util.ArrayList;

public class CarrinhoService {
     
    private int id;
    private String situacao;
    private ArrayList<Produto> produtos;

    public CarrinhoService(int id) {
        this.id = id;
        this.situacao = "aberto";
        this.produtos = new ArrayList<>();
    }

    public boolean adicionar(Produto produto) {
        if (situacao.equals("fechado"))
            return false;

        produtos.add(produto);
        return true;
    }

    public boolean remover(int indice) {
        if (situacao.equals("fechado") || indice >= produtos.size())
            return false;

        produtos.remove(indice);
        return true;
    }

    public Object finalizar() {
        if (produtos.isEmpty())
            return null;

        double precoTotal = 0;
        for (Produto produto : produtos) {
            precoTotal += produto.getPreco();
        }

        situacao = "fechado";
        return precoTotal;
    }
    
    public ArrayList<Produto> getProdutos() {
        return produtos;
    }
}