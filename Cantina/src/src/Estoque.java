
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Estoque {
    //static ArrayList<Produto> estoque = new ArrayList<>();
    //static ArrayList<Produto> estoquePequeno = new ArrayList<>();
    //double lucroProdutos;
    //double prejuizoProdutos;

    public void cadastraProduto(int codigoProduto, String nome, String desc, double precoDeCompra, double precoDeVenda, int quantidadeComprada, int qtddVendida) throws PrecoInvalidoException, QuantidadeInvalidaException {
        Produto produto = new Produto(codigoProduto, nome, desc, precoDeCompra, precoDeVenda, quantidadeComprada, qtddVendida);
        //estoque.add(produto);
        try{
            ProdutoDAO prodDAO = new ProdutoDAO();
            prodDAO.adiciona(produto);
            System.out.println("Produto cadastrado com sucesso!");
        }catch(SQLException e){
            System.out.println("Produto não adicionado. Erro: "+e);
        }
    }

    public void produtosPorQuantidade(){
        System.out.println("=== PRODUTOS POR QUANTIDADE ===");
        /*for(Produto produto: estoque){
            System.out.println(produto.getNome());
            System.out.println(produto.getQuantidadeDisponivel());
        }*/
        ProdutoDAO prodDao = new ProdutoDAO();
        prodDao.prodPorQtdd();
    }
    //exibe os produtos por nome e descricao
    public void produtosPorDescricao(){
        System.out.println("=== PRODUTOS POR DESCRIÇÃO ===");
        /*for(Produto produto: estoque){
            System.out.println(produto.getNome());
            System.out.println(produto.getDescricao());
        }*/
        ProdutoDAO prodDao = new ProdutoDAO();
        prodDao.prodPorDesc();
    }
    //exibe os produtos com estoque pequeno
    public void produtosEstoquePequeno(){
        /*  for(Produto produto: estoquePequeno){
            System.out.println(produto.getNome());
            System.out.println(produto.getQuantidadeDisponivel());
        }*/
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
    public void fazerVenda() throws SQLException{
        Venda venda = new Venda();
        VendaDAO vendaNova = new VendaDAO();
        vendaNova.iniciaVenda(venda);
        System.out.println("Qual o código do funcionário? ");
        Scanner sc = new Scanner(System.in);
        String codFunc = sc.nextLine();
        venda.setCodFunc(codFunc);
        System.out.println("Qual é a forma de pagamento?\n1-Cartão;\n2-Dinheiro");
        Scanner sc2 = new Scanner(System.in);
        int formaPag = sc2.nextInt();
        if(formaPag == 1){
            venda.setFormaPagamento("Cartão");
        }else if(formaPag == 2){
            venda.setFormaPagamento("Dinheiro");
            venda.setDesconto(2.00);
        }
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
        int codvenda = vendaNova.selecionaVenda(item.getIdItem());
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
            int codvenda2 = vendaNova2.selecionaVenda(item2.getIdItem());
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
        

        /*Venda venda = new Venda();
        VendaDAO vDao = new VendaDAO();
        ItemVenda item = new ItemVenda();
        ItemVendaDAO itemDAO = new ItemVendaDAO();
        System.out.println("Insira o código do vendedor: ");
        Scanner cV = new Scanner(System.in);
        String codVendedor = cV.nextLine();
        venda.setCodFunc(codVendedor);
        vDao.iniciaVenda(venda);
        System.out.println("Insira o código do produto que deseja vender: ");
        Scanner sc3 = new Scanner(System.in);
        int codp = sc3.nextInt();
        itemDAO.verificaBanco(codp);
        System.out.println("Quer adicionar mais algum item?\n 1-Sim; 2-Não");
        Scanner sc5 = new Scanner(System.in);
        int opc = sc5.nextInt();
        while(opc != 2){
            System.out.println("Insira o código do produto que deseja vender: ");
            Scanner sc4 = new Scanner(System.in);
            int codprd = sc3.nextInt();
            itemDAO.verificaBanco(codp);
            ItemVendaDAO itemNovo = new ItemVendaDAO();
            System.out.println("Insira a quantidade: ");
            Scanner sc6 = new Scanner(System.in);
            int qtdd = sc6.nextInt();
            itemNovo.adicionaItemVenda(item);
            Double totalVenda = item.getPreco();
            // venda.atualizaVenda(totalVenda, qtdd);
            // itemNovo.atualizaItemVendido();
            
        }*/

	/*public void darBaixa(int quantidadeBaixa, String produtoParaBaixa) {
		ProdutoDAO venda = new ProdutoDAO();
		venda.venda(produtoParaBaixa, quantidadeBaixa);
		
		
	}
    //metodo para dar baixa em produto
    //public void darBaixa(int quantidadeVendida, String nomeProduto) throws QuantidadeInvalidaException{
        /*for(Produto produto: estoque){
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
                    ProdutoDAO prodDao = new ProdutoDAO();
                    prodDao.atualizaQtdd(produto);                
                    if(quantidadeDisponivelNoProduto < 50 && estoquePequeno.equals(produto)){
                        estoquePequeno.add(produto);
                    }
                }
                //ele chama o metodo para calcular prejuizo e lucro porque entende-se que uma vez que o produto foi dado baixa, ele foi vendido
                //calculaLucroEPrejuizo(produto);
            }
        }*/
    }
     /*//método que calcula o lucro ou prejuízo por produto vendido
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
    }*/

