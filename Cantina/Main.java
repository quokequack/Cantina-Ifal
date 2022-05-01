package JAVA.CANTINA;
import java.util.Scanner;

public class Main{
    public static void main(String args[]){
        //abre um novo estoque
        Estoque estoqueCantina = new Estoque();
        //produtos básicos do estoque
        Produto suco = new Produto("Suco de Laranja", "500Ml", 2.82, 6.00,200);
        Produto pipoca = new Produto("Pipoca Cheetos", "Sabor: queijo", 1.00, 2.00, 500);
        Produto cha = new Produto("Chá Gelado", "Sabor: Limão", 2.30, 5.00, 150);
        Produto torta = new Produto("Torta", "Salgada", 3.00, 6.00, 4);
        Produto refrigerante = new Produto("Refrigerante", "Guaraná 100Ml", 1.80, 3.50, 100);
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
                    produtosPorDescricao();
                }else if(opcaoEscolhida2 == 2){
                    produtosPorQuantidade();
                }else if(opcaoEscolhida2 == 3){
                    System.out.println();
                }
            }else if(opcaoEscolhida == 3){
                System.out.println("Deseja ver:\n 1 - Relatório de lucratividade;\n 2 - Relatório de prejuízo.");
                Scanner opcao3 = new Scanner(System.in);
                int opcaoEscolhida3 = opcao3.nextInt();

                if(opcaoEscolhida3 == 1){
                    System.out.println(lucroProdutos);
                }else if(opcaoEscolhida3 == 2){
                    System.out.println(prejuizoProdutos);
                }
            }else if(opcaoEscolhida == 4){
                darBaixa();
            }else if(opcaoEscolhida == 5){
                System.out.println("Até a próxima!");
            }

        }

    }
}
