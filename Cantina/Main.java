
import java.util.Scanner;

public class Main{
    public static void main(String args[]){
        //abre um novo estoque
        Estoque estoqueCantina = new Estoque();
        
        //produtos básicos do estoque
        Produto suco = new Produto(001,"Suco de Laranja", "500Ml", 2.82, 6.00,200);
        Produto pipoca = new Produto(002,"Pipoca Cheetos", "Sabor: queijo", 1.00, 2.00, 500);
        Produto cha = new Produto(003,"Chá Gelado", "Sabor: Limão", 2.30, 5.00, 150);
        Produto torta = new Produto(004,"Torta", "Salgada", 3.00, 6.00, 4);
        Produto refrigerante = new Produto(005,"Refrigerante", "Guaraná 100Ml", 1.80, 3.50, 100);
        //menu da cantina
        System.out.println("\n === Cantina Do Ifal ===\nO que deseja fazer?\n1 - Cadastrar produtos;\n2 - Ver produtos em estoque;\n3 - Ver relatório de lucro e prejuízo;\n4 - Dar baixa no estoque\n5 - Sair.");
        Scanner escolha = new Scanner(System.in);
        int opcaoEscolhida = escolha.nextInt();
        while(opcaoEscolhida != 5){
            if(opcaoEscolhida == 1){
                System.out.println("Insira o nome do produto que quer cadastrar: ");
                Scanner nome = new Scanner(System.in);
                String novoProdutoNome = nome.nextLine();
                System.out.println("Insira uma descrição: ");
                Scanner desc = new Scanner(System.in);
                String novoProdutoDesc = desc.nextLine();
                System.out.println("Insira o preço de compra: ");
                Scanner compra = new Scanner(System.in);
                double novoProdutoCompra = compra.nextDouble();
                System.out.println("Insira o preço de venda: ");
                Scanner venda = new Scanner(System.in);
                double novoProdutoVenda = venda.nextDouble();
                System.out.println("Insira a quantidade comprada: ");
                Scanner qtdd = new Scanner(System.in);
                int novoProdutoQuantidade = qtdd.nextInt();
                estoqueCantina.cadastraProduto(novoProdutoNome, novoProdutoDesc, novoProdutoCompra, novoProdutoVenda, novoProdutoQuantidade);

            }else if(opcaoEscolhida == 2){
                System.out.println("Deseja ver:\n 1 - Produtos disponíveis em estoque por descrição;\n 2 - Produtos disponíveis em estoque por quantidade;\n 3 - Produtos com menos de 50 itens;");
                Scanner opcao2 = new Scanner(System.in);
                int opcaoEscolhida2 = opcao2.nextInt();
                if (opcaoEscolhida2 == 1){
                    estoqueCantina.produtosPorDescricao();
                }else if(opcaoEscolhida2 == 2){
                    estoqueCantina.produtosPorQuantidade();
                }else if(opcaoEscolhida2 == 3){
                    System.out.println(estoqueCantina.estoquePequeno);
                }
            }else if(opcaoEscolhida == 3){
                System.out.println("Deseja ver:\n 1 - Relatório de lucratividade;\n 2 - Relatório de prejuízo.");
                Scanner opcao3 = new Scanner(System.in);
                int opcaoEscolhida3 = opcao3.nextInt();

                if(opcaoEscolhida3 == 1){
                    System.out.println(estoqueCantina.lucroProdutos);
                }else if(opcaoEscolhida3 == 2){
                    System.out.println(estoqueCantina.prejuizoProdutos);
                }
            }else if(opcaoEscolhida == 4){
                System.out.println("Qual produto deseja dar baixa?");
                Scanner produtoBaixa = new Scanner(System.in);
                String produtoParaBaixa = produtoBaixa.nextLine();
                System.out.println("Quantos você quer dar baixa? ");
                Scanner quantidade = new Scanner(System.in);
                int quantidadeBaixa = quantidade.nextInt();
                estoqueCantina.darBaixa(quantidadeBaixa,  );
                //problema: preciso dar um jeito de tirar um objeto da lista passado como parâmetro;
                //problema: preciso criar o método ...
            }else if(opcaoEscolhida == 5){
                System.out.println("Até a próxima!");
            }

        }

    }
}
