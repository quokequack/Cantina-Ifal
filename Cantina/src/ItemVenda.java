public class ItemVenda {
    private int idItem;
    private int codproduto;
    private int codVenda;
    private int qtdd;
    private Double preco;

        /*public ItemVenda(){
        this.idItem = idItem;
        this.codVenda = codvenda;
        this.qtdd = qtdd;
        this.preco = preco;
    }*/
    public int getCodVenda() {
        return codVenda;
    }public int getIdItem() {
        return idItem;
    }public Double getPreco() {
        return preco;
    }public int getQtdd() {
        return qtdd;
    }
    public int getCodproduto() {
        return codproduto;
    }public void setCodproduto(int codproduto) {
        this.codproduto = codproduto;
    }


}
