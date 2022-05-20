package JAVA.CANTINA;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Produto{
    private String nome;
    private String descricao;
    private double precoDeCompra;
    private double precoDeVenda;
    private int quantidadeComprada;
    private int quantidadeVendida;
    private static int quantidadeDisponivel;

    static ArrayList<Double> prejuizoProdutos = new ArrayList<>();
    static ArrayList<Double> lucroProdutos = new ArrayList<>();

    public Produto(String nome, String descricao, double precoDeCompra, double precoDeVenda, int quantidadeComprada) throws PrecoInvalidoException, QuantidadeInvalidaException{
        if (precoDeVenda <= precoDeCompra){
            throw new PrecoInvalidoException("Preço de venda não pode ser igual ou menor do que o preço de compra!!!");
        }else if(precoDeCompra == 0 || precoDeVenda == 0){
            throw new PrecoInvalidoException("Preço não pode ser igual a 0!!!");
        }else if(quantidadeComprada <= 0){
            throw new QuantidadeInvalidaException("Quantidade não pode ser igual ou menor a 0!!!");
        }else{
            this.nome = nome;
            this.descricao = descricao;
            this.precoDeCompra = precoDeCompra;
            this.precoDeVenda = precoDeVenda;
            this.quantidadeComprada = quantidadeComprada;
            Estoque.estoque.add(this);
            if (quantidadeComprada <= 50){
                Estoque.estoquePequeno.add(this);
            }
        }
    }
    public double getPrecoDeVenda(){
        return this.precoDeVenda;
    }
    public double getPrecoDeCompra(){
        return this.precoDeCompra;
    }
    public void setPrecoDeVenda(double precoNovo){
        this.precoDeVenda = precoNovo;
    }
    public int getQuantidadeComprada(){
        return this.quantidadeComprada;
    }
    public int getQuantidadeVendida(){
        return this.quantidadeVendida;
    }
    public int getQuantidade(){
        return this.quantidadeDisponivel;
    }
    public int getQuantidadeDisponivel(){
        return this.quantidadeDisponivel;
    }
    public String getDescricao(){
        return this.descricao;
    }
}
