package JAVA.CANTINA;
import java.util.ArrayList;

class Produto{
    private String nome;
    private String descricao;
    private double precoDeCompra;
    private double precoDeVenda;
    private int quantidadeComprada;
    private int quantidadeVendida;
    private int quantidadeDisponivel;

    ArrayList<Produto> estoque = new ArrayList<>();
    ArrayList<Produto> estoquePequeno = new ArrayList<>();
    ArrayList<Double> prejuizoProdutos = new ArrayList<>();
    ArrayList<Double> lucroProdutos = new ArrayList<>();

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

            estoque.add(this);
            if (quantidadeComprada <= 50){
                estoquePequeno.add(this);
        }   }
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
    
    //método que calcula o lucro ou prejuízo por produto vendido
    public void calculaLucroEPrejuizo(){
        double lucro = this.precoDeVenda - this.precoDeCompra;
        if (lucro == this.quantidadeComprada || lucro == 0){
            prejuizoProdutos.add(lucro);
        }else{
            lucroProdutos.add(lucro);
        }
    }
    //método que dá baixa em um produto vendido e chama o método calculaLucro, uma vez que se dado baixa, significa que um produto foi vendido
    public void darBaixa(int quantidadeVendida) throws QuantidadeInvalidaException{
        if (quantidadeVendida <= 0){
            throw new QuantidadeInvalidaException("Quantidade vendida não pode ser menor ou igual a 0!!!");
        }else{
            this.quantidadeDisponivel -= quantidadeVendida;
            int novaQuantidade = quantidadeDisponivel - quantidadeVendida;
            if(this.quantidadeDisponivel < 50 && estoquePequeno.contains(this) == false){
                estoquePequeno.add(this);
            }
          calculaLucroEPrejuizo();
        }
    }
    //exibe os produtos por nome e quantidade
    public void produtosPorQuantidade(){
        System.out.println(estoque);
    }
    //exibe os produtos por nome e descricao
    public void produtosPorDescricao(){

    }
}
