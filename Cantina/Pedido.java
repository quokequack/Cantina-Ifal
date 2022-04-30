class Pedido implements Produto{

    public void novoPedido(String produto, int quantidade){
        System.out.println(cardapio);
        System.out.println("Deseja qual produto? ");
        Scanner produto = new Scanner(System.in);
        String produtoEscolhido = produto.nextLine();
            if (cardapio.contains(produtoEscolhido) == false){
                System.out.println("Nós não temos esse produto no estoque. Sentimos muito não poder te atender.");
            }else{
                System.out.println("Você escolheu: "+ produtoEscolhido +". Quantos você quer?")
                Scanner qtdd = new Scanner(System.in);
                int quantidadeEscolhida = qtdd.nextInt();

                System.out.println("Seu pedido é: "+quantidadeEscolhida + produtoEscolhido+". Deseja adicionar mais alguma coisa?\n 1 - Sim;\n 2 - Não");
                Scanner algoMais = new Scanner(System.in);
                int simOuNao = algoMais.nextInt();
                while(simOuNao == 1){
                    System.out.println(cardapio);
                    System.out.println("O que deseja adicionar? ")
                    Scanner maisProduto = new Scanner(System.in);
                    String outroProduto = maisProduto.nextLine();

                }

            }
        }
}