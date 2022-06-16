
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Estoque {

    //CADASTRA UM NOVO PRODUTO
    public void cadastraProduto(int codigoProduto, String nome, String desc, double precoDeCompra, double precoDeVenda, int quantidadeComprada, int qtddVendida) throws PrecoInvalidoException, QuantidadeInvalidaException {
        Produto produto = new Produto(codigoProduto, nome, desc, precoDeCompra, precoDeVenda, quantidadeComprada, qtddVendida);
        try{
            ProdutoDAO prodDAO = new ProdutoDAO();
            prodDAO.adiciona(produto);
            System.out.println("Produto cadastrado com sucesso!");
        }catch(SQLException e){
            System.out.println("Produto não adicionado. Erro: "+e);
        }
    }
    //MOSTRA OS PRODUTOS POR QUANTIDADE
    public void produtosPorQuantidade(){
        System.out.println("=== PRODUTOS POR QUANTIDADE ===");
        ProdutoDAO prodDao = new ProdutoDAO();
        prodDao.prodPorQtdd();
    }
    //exibe os produtos por nome e descricao
    public void produtosPorDescricao(){
        System.out.println("=== PRODUTOS POR DESCRIÇÃO ===");
        ProdutoDAO prodDao = new ProdutoDAO();
        prodDao.prodPorDesc();
    }
    //exibe os produtos com estoque pequeno
    public void produtosEstoquePequeno(){
        ProdutoDAO prodDao = new ProdutoDAO();
        prodDao.estoquePeq();
    }
    //exibe o lucro dos produtos
    public void lucroProduto(){
        ProdutoDAO prodDao = new ProdutoDAO();
        prodDao.lucroProd();
    }
    //exibe o prejuizo dos produtos
    public void prejuizoProduto(){
        ProdutoDAO prodDao = new ProdutoDAO();
        prodDao.prejuizoProd();
    }
    //VENDE UM NOVO PRODUTO
    public void fazerVenda() throws SQLException{
        Venda venda = new Venda();
        System.out.println("Qual o código do funcionário? ");
        Scanner sc = new Scanner(System.in);
        String codFunc = sc.nextLine();
        venda.setCodFunc(codFunc);
        System.out.println("Qual é a forma de pagamento?\n1-Cartão;\n2-Dinheiro");
        Scanner sc2 = new Scanner(System.in);
        int formaPag = sc2.nextInt();
        if(formaPag == 1){
            venda.setFormaPagamento("Cartão");
            venda.setDesconto(0.0);
        }else if(formaPag == 2){
            venda.setFormaPagamento("Dinheiro");
            venda.setDesconto(2.00);
        }
        VendaDAO vendaNova = new VendaDAO();
        vendaNova.iniciaVenda(venda);
        ItemVenda item = new ItemVenda();
        System.out.println("Digite o código do produto que quer adicionar na venda: ");
        Scanner sc3 = new Scanner(System.in);
        int codproduto = sc3.nextInt();
        item.setCodproduto(codproduto);
        System.out.println("Quantos?");
        Scanner sc4 = new Scanner(System.in);
        int qtddP = sc4.nextInt();
        item.setQtdd(qtddP);
        ItemVendaDAO itemNovo = new ItemVendaDAO();
        Double preco = itemNovo.pesquisaPrecoProd(codproduto);
        item.setPreco(preco);
        int codvenda = vendaNova.selecionaVenda(codproduto);
        item.setCodVenda(codvenda);
        itemNovo.adicionaItemVenda(item);
        Double totalVenda = itemNovo.totalVenda(codvenda);
        vendaNova.atualizaVenda(codvenda, totalVenda);
        System.out.println("Deseja adicionar mais um item?\n1-Sim;\n2-Não");
        Scanner sc5 = new Scanner(System.in);
        int opt = sc5.nextInt();
        while(opt != 2){
            VendaDAO vendaNova2 = new VendaDAO();
            ItemVenda item2 = new ItemVenda();
            System.out.println("Digite o código do produto que quer adicionar na venda: ");
            Scanner sc6 = new Scanner(System.in);
            int codproduto2 = sc3.nextInt();
            item2.setCodproduto(codproduto2);
            System.out.println("Quantos?");
            Scanner sc7 = new Scanner(System.in);
            int qtddP2 = sc4.nextInt();
            item2.setQtdd(qtddP2);
            ItemVendaDAO itemNovo2 = new ItemVendaDAO();
            Double preco2 = itemNovo2.pesquisaPrecoProd(codproduto2);
            item2.setPreco(preco2);
            int codvenda2 = vendaNova2.selecionaVenda(codproduto2);
            item2.setCodVenda(codvenda2);
            itemNovo2.adicionaItemVenda(item);
            Double totalVenda2 = itemNovo2.totalVenda(codvenda2);
            vendaNova2.atualizaVenda(codvenda2, totalVenda2);
            System.out.println("Deseja adicionar mais um item?\n1-Sim;\n2-Não");
            Scanner sc8 = new Scanner(System.in);
            int opt1 = sc8.nextInt();
            if(opt == 2){
                Double totalVendas = totalVenda + totalVenda2;
                String nomes = itemNovo2.itensVenda(codvenda2);
                System.out.println("VENDA ENCERRADA."+nomes+"\nTOTAL DA VENDA: "+totalVendas);
            }

        }
    }
}