import java.util.Comparable;

class Produto implements Comparable{
    private String nome;
    private String descricao;
    private double precoDeCompra;
    private double precoDeVenda;
    private int quantidadeComprada;
    private int quantidadeVendida;
    private int quantidadeDisponivel;

    public Produto(String nome, String descricao, double precoDeCompra, double precoDeVenda, int quantidadeComprada) throws PrecoInvalidoException, QuantidadeInvalidaException{
        if (precoDeVenda <= precoDeCompra){
            throw new PrecoInvalidoException("Preço de venda não pode ser igual ou menor do que o preço de compra!!!");
        }else if(precoDeCompra == 0 || precoDeVenda == 0){
            throw new PrecoInvalidoException("Preço não pode ser igual a 0!!!");
        }else if(quantidadeComprada <= 0){
            throw new QuantidadeInvalidaException("Quantidade não pode ser igual ou menor a 0!!!");
        }else{
            this.nome = nome;
            this.desc = desc;
            this.precoDeCompra = precoDeCompra;
            this.precoDeVenda = precoDeVenda;
            this.quantidadeComprada = quantidadeComprada;
            produtosEmEstoque.add(this);
            if (quantidadeComprada <= 50){
                produtosEstoquePequeno.add(this);
        }
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
    public void CalculaLucroEPrejuizo(){
        double lucro = this.precoDeVenda - this.precoDeCompra;
        if (lucro == this.quantidadeComprada || lucro == 0){
            prejuizoProduto.put(this.nome lucro)
        }else{
            lucroProduto.put(this.nome, lucro);
        }
    }
    //método que ordena a arraylist
    public void CompareTo(Produto outro){
        if (this.nome)
    }
}