import java.util.Scanner;
class Cantina{
    public static void main(String args[]){
        System.out.println('''
        ==========CANTINA DO IFAL==========
        =======SEJA MUITO BEM-VINDO!=======
                  O que deseja?
                  1 - Ver o cardápio;
                  2 - Fazer um novo pedido;
                  3 - Ver histórico de pedidos;
                  4 - Sair;
                  ''');
        Scanner opc = new Scanner(System.in);
        int opcEscolhida = opc.nextInt();
        while (opcEscolhida != 4){
            if(opcaoEscolhida == 1 ){
                System.out.println("Como quer ver o cardápio?");
            }else if(opcaoEscolhida == 2){
                System.out.println(cardapio);
                fazerNovoPedido();
            }else if(opcaoEscolhida == 3){

            }
        }
    }
}