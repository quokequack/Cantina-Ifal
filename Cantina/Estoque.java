package JAVA.CANTINA;
import java.util.ArrayList;
import java.util.List;

public class Estoque {
    static ArrayList<Produto> estoque = new ArrayList<>();
    static ArrayList<Produto> estoquePequeno = new ArrayList<>();
    double lucroProdutos;
    double prejuizoProdutos;

    public void cadastraProduto(String nome, String desc, double precoDeCompra, double precoDeVenda, int quantidadeComprada) throws PrecoInvalidoException, QuantidadeInvalidaException {
        estoque.add(new Produto(nome, desc, precoDeCompra, precoDeVenda, quantidadeComprada));
        System.out.println("Produto cadastrado com sucesso!");
    }

    public void produtosPorQuantidade(){
        System.out.println(estoque);
        for(Produto quantidade: estoque){
            System.out.println(quantidade.getQuantidadeDisponivel());
        }
    }
    //exibe os produtos por nome e descricao
    public void produtosPorDescricao(){
        System.out.println(estoque);
        for(Produto desc: estoque){
            System.out.println(desc.getDescricao());
        }
    }
    // 3 erros básicos:
    // 1 - metodo dar baixa n pega string, tenho que arranjar um jeito
    /* de fazer com que ele 
    */
    //metodo para dar baixa em produto
    public void darBaixa(int quantidadeVendida, Produto produto) throws QuantidadeInvalidaException{
        int quantidadeDisponivelNoProduto = produto.getQuantidadeDisponivel();
        for(Produto nome: estoque){
            if(quantidadeVendida <= 0){
                throw new QuantidadeInvalidaException("Quantidade vendida não pode ser igual ou menor do que 0!!!");
            }else if(estoque.equals(produto) == false){
                System.out.println("Esse produto não está no estoque!!!");
            }else if(quantidadeVendida > quantidadeDisponivelNoProduto){
                throw new QuantidadeInvalidaException("Quantidade maior do que a disponível!!!");
            }else{
                int quantidadeDisponivel = produto.getQuantidadeDisponivel();
                quantidadeDisponivel -= quantidadeVendida;
                if(quantidadeDisponivel < 50 && estoquePequeno.equals(produto)){
                    estoquePequeno.add(produto);
                }
                //ele chama o metodo para calcular prejuizo e lucro porque entende-se que uma vez que o produto foi dado baixa, ele foi vendido
                calculaLucroEPrejuizo(produto);
            }
        }
    }
     //método que calcula o lucro ou prejuízo por produto vendido
     public void calculaLucroEPrejuizo(Produto produto){
         double precoDeVendaDoProduto = produto.getPrecoDeVenda();
         double quantidadeCompradaProduto = produto.getQuantidadeComprada();
         double precoDeVendaProduto = produto.getPrecoDeVenda();
         double precoDeCompraProduto = produto.getPrecoDeCompra();
        double lucro = precoDeVendaDoProduto - precoDeCompraProduto;
        if (lucro == quantidadeCompradaProduto || lucro == 0){
            prejuizoProdutos += lucro;
        }else{
            lucroProdutos += lucro;
        }
    }
}
