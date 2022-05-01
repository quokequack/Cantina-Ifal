package JAVA.CANTINA;
import java.util.ArrayList;
import java.util.List;

public class Estoque {
    static ArrayList<Produto> estoque = new ArrayList<>();
    static ArrayList<Produto> estoquePequeno = new ArrayList<>();
    static ArrayList<Double> prejuizoProdutos = new ArrayList<>();
    static ArrayList<Double> lucroProdutos = new ArrayList<>();

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
}
