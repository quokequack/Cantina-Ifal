import java.lang.List;
import java.util.Map;


class Estoque {
    //lista com produtos disponíveis
    ArrayList<Produto> produtosEmEstoque = new ArrayList<>();

    //lista com produtos com estoque < 50
    ArrayList<Produto> produtosEstoquePequeno = new ArrayList<>();

    //cardapio com preços
    Map<Produto, double> cardapio = new HashMap<>();

    //lista com itens vendidos (MAP)
    Map<Produto, double> produtosVendidos = new HashMap<>();

    //lista com lucro de cada venda (MAP)
    Map<Produto, double> lucroProduto = new HashMap<>();

    //lista com prejuizo de cada venda (MAP)
    Map<Produto, double> prejuizoProduto = new HashMap<>();
}