import java.sql.Date;

public class Venda {
    private int codvenda;
    private Date dataVenda;
    private Double desconto;
    private Double totalVenda;
    private String formaPagamento;

    public int getCodvenda() {
        return codvenda;
    }
    public void setCodvenda(int codvenda) {
        this.codvenda = codvenda;
    }
    public Date getDataVenda() {
        return dataVenda;
    }
    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }
    public Double getDesconto() {
        return desconto;
    }
    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }
    public String getFormaPagamento() {
        return formaPagamento;
    }
    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    public Double getTotalVenda() {
        return totalVenda;
    }

   


}
