import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public void cantina() throws PrecoInvalidoException, QuantidadeInvalidaException, SQLException{
        //DB database = new DB();
        //database.CriaTabelas();
        //MainGUI telaPrincipal = new MainGUI();
        Estoque estoqueCantina = new Estoque();
        int contador = 0;
        while (contador != 7){
            System.out.println("\n === Cantina Do Ifal ===\nO que deseja fazer?\n1 - Cadastrar produtos;\n2 - Ver produtos em estoque;\n3 - Ver relatório de lucro e prejuízo;\n4 - Dar baixa no estoque\n5 - Registrar compra de um produto\n6 - Excluir item do estoque\n7 - Sair.");
            Scanner escolha = new Scanner(System.in);
            int opcaoEscolhida = escolha.nextInt();
            if(opcaoEscolhida == 1){
                System.out.println("Insira o código do produto que deseja cadastrar: ");
                Scanner codigo = new Scanner(System.in);
                int novoProdutoCodigo = codigo.nextInt();
                System.out.println("Insira o nome do produto que quer cadastrar: ");
                Scanner nome = new Scanner(System.in);
                String novoProdutoNome = nome.nextLine();
                System.out.println("Insira uma descrição: ");
                Scanner desc = new Scanner(System.in);
                String novoProdutoDesc = desc.nextLine();
                System.out.println("Insira o preço de compra: ");
                Scanner compra = new Scanner(System.in);
                Double novoProdutoCompra = compra.nextDouble();
                System.out.println("Insira o preço de venda: ");
                Scanner venda = new Scanner(System.in);
                Double novoProdutoVenda = venda.nextDouble();
                System.out.println("Insira a quantidade comprada: ");
                Scanner qtdd = new Scanner(System.in);
                int novoProdutoQuantidade = qtdd.nextInt();
                estoqueCantina.cadastraProduto(novoProdutoCodigo, novoProdutoNome, novoProdutoDesc, novoProdutoCompra, novoProdutoVenda, novoProdutoQuantidade, 0);

            }else if(opcaoEscolhida == 2){
                System.out.println("Deseja ver:\n 1 - Produtos disponíveis em estoque por descrição;\n 2 - Produtos disponíveis em estoque por quantidade;\n 3 - Produtos com menos de 50 itens;");
                Scanner opcao2 = new Scanner(System.in);
                int opcaoEscolhida2 = opcao2.nextInt();
                if (opcaoEscolhida2 == 1){
                    estoqueCantina.produtosPorDescricao();
                }else if(opcaoEscolhida2 == 2){
                    estoqueCantina.produtosPorQuantidade();
                }else if(opcaoEscolhida2 == 3){
                    estoqueCantina.produtosEstoquePequeno();
                }
            }else if(opcaoEscolhida == 3){
                System.out.println("Deseja ver:\n 1 - Relatório de lucratividade;\n 2 - Relatório de prejuízo.");
                Scanner opcao3 = new Scanner(System.in);
                int opcaoEscolhida3 = opcao3.nextInt();

                if(opcaoEscolhida3 == 1){
                    estoqueCantina.lucroProduto();
                }else if(opcaoEscolhida3 == 2){
                    estoqueCantina.prejuizoProduto();
                }
            }else if(opcaoEscolhida == 4){
                estoqueCantina.fazerVenda();
            }else if(opcaoEscolhida == 5){
                System.out.println("Você deseja atualizar:\n1-Nome;\n2-Preço;\n3-Quantidade comprada");
                Scanner opt = new Scanner(System.in);
                int opcao4 = opt.nextInt();
                if(opcao4 == 1){
                    System.out.println("Insira o código do produto: ");
                    Scanner sc = new Scanner(System.in);
                    int codigoP = sc.nextInt();
                    System.out.println("Insira o novo nome do produto: ");
                    Scanner sc2 = new Scanner(System.in);
                    String nomeNovo = sc2.nextLine();
                    ProdutoDAO proddao = new ProdutoDAO();
                    proddao.atualizaNome(codigoP, nomeNovo);
                }else if(opcao4 == 2){
                    System.out.println("Insira o código do produto: ");
                    Scanner sc = new Scanner(System.in);
                    int codigoP = sc.nextInt();
                    System.out.println("Insira o novo preço do produto: ");
                    Scanner sc2 = new Scanner(System.in);
                    Double precoNovo = sc2.nextDouble();
                    ProdutoDAO proddao = new ProdutoDAO();
                    proddao.atualizaPrecoVenda(codigoP, precoNovo);
                }else if(opcao4 == 3){
                    System.out.println("Insira o código do produto: ");
                    Scanner sc = new Scanner(System.in);
                    int codigoP = sc.nextInt();
                    System.out.println("Insira a nova quantidade do produto: ");
                    Scanner sc2 = new Scanner(System.in);
                    int qtddNova = sc2.nextInt();
                    ProdutoDAO proddao = new ProdutoDAO();
                    proddao.atualizaQtdd(codigoP, qtddNova);
                }
            }else if(opcaoEscolhida == 6){
                System.out.println("Digite o código do item para excluir: ");
                Scanner sc4 = new Scanner(System.in);
                int codDelete = sc4.nextInt();
                ProdutoDAO proddao = new ProdutoDAO();
                proddao.ExcluirItem(codDelete);
            }
            else if(opcaoEscolhida == 7){
                System.out.println("Até a próxima!");
                break;

            }

        }

    }
}
