
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Estoque {
    static ArrayList<Produto> estoque = new ArrayList<>();
    static ArrayList<Produto> estoquePequeno = new ArrayList<>();
    double lucroProdutos;
    double prejuizoProdutos;

    public void cadastraProduto(int codigoProduto, String nome, String desc, double precoDeCompra, double precoDeVenda, int quantidadeComprada) throws PrecoInvalidoException, QuantidadeInvalidaException {
        estoque.add(new Produto(codigoProduto, nome, desc, precoDeCompra, precoDeVenda, quantidadeComprada));
        System.out.println("Produto cadastrado com sucesso!");
    }

    public void produtosPorQuantidade(){
        System.out.println("=== PRODUTOS POR QUANTIDADE ===");
        for(Produto produto: estoque){
            System.out.println(produto.getNome());
            System.out.println(produto.getQuantidadeDisponivel());
        }
    }
    //exibe os produtos por nome e descricao
    public void produtosPorDescricao(){
        System.out.println("=== PRODUTOS POR DESCRIÇÃO ===");
        for(Produto produto: estoque){
            System.out.println(produto.getNome());
            System.out.println(produto.getDescricao());
        }
    }
    //exibe os produtos com estoque pequeno
    public void produtosEstoquePequeno(){
        for(Produto produto: estoquePequeno){
            System.out.println(produto.getNome());
            System.out.println(produto.getQuantidadeDisponivel());
        }
    }
    //metodo para dar baixa em produto
    public void darBaixa(int quantidadeVendida, String nomeProduto) throws QuantidadeInvalidaException{
        for(Produto produto: estoque){
            if(produto.getNome() == nomeProduto){
                int quantidadeDisponivelNoProduto = produto.getQuantidadeDisponivel();
                if(quantidadeVendida <= 0){
                    throw new QuantidadeInvalidaException("Quantidade vendida não pode ser igual ou menor do que 0!!!");
                }else if(estoque.equals(produto) == false){
                    System.out.println("Esse produto não está no estoque!!!");
                }else if(quantidadeVendida > quantidadeDisponivelNoProduto){
                    throw new QuantidadeInvalidaException("Quantidade maior do que a disponível!!!");
                }else{
                    quantidadeDisponivelNoProduto -= quantidadeVendida;
                    if(quantidadeDisponivelNoProduto < 50 && estoquePequeno.equals(produto)){
                        estoquePequeno.add(produto);
                    }
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
