package Loja;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        CarrinhoService carrinho = new CarrinhoService(1);

        Produto produto1 = new Produto(3, "Bermuda", 29.90);
        Produto produto2 = new Produto(1, "Tablet", 599.90);

        carrinho.adicionar(produto1);
        carrinho.adicionar(produto2);

        System.out.println("Produtos no carrinho:");
        for (Produto produto : carrinho.getProdutos()) {
            System.out.println(produto.getNome());
        }

        carrinho.remover(0);

        System.out.println("Produtos no carrinho após remoção:");
        for (Produto produto : carrinho.getProdutos()) {
            System.out.println(produto.getNome());
        }

        Object precoTotal = carrinho.finalizar();
        if (precoTotal == null) {
            System.out.println("Carrinho vazio.");
        } else {
            System.out.println("Preço total: " + precoTotal);
        }
    }
}