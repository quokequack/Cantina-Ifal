package JAVA.CANTINA;
import java.util.Scanner;
import JAVA.CANTINA.Produto;

public class Main{
    public static void main(String args[], char[] estoquePequeno){
        System.out.println("\n === Cantina Do Ifal ===\nO que deseja fazer?\n1 - Cadastrar produtos;\n2 - Ver produtos em estoque;\n3 - Ver relatório de lucro e prejuízo;\n4 - Dar baixa no estoque\n5 - Sair.");
        Scanner escolha = new Scanner(System.in);
        int opcaoEscolhida = escolha.nextInt();

        while(opcaoEscolhida != 5){
            if(opcaoEscolhida == 1){
                
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
