import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}

class ItemCarrinho {
    private Produto produto;
    private int quantidade;

    public ItemCarrinho(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double calcularSubtotal() {
        return produto.getPreco() * quantidade;
    }
}

class CarrinhoDeCompras {
    private List<ItemCarrinho> itens;

    public CarrinhoDeCompras() {
        this.itens = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        for (ItemCarrinho item : itens) {
            if (item.getProduto().getNome().equalsIgnoreCase(produto.getNome())) {
                item.setQuantidade(item.getQuantidade() + quantidade);
                System.out.println("Quantidade atualizada para o produto: " + produto.getNome());
                return;
            }
        }
        itens.add(new ItemCarrinho(produto, quantidade));
        System.out.println("Produto adicionado ao carrinho: " + produto.getNome());
    }

    public void removerProduto(String nomeProduto) {
        if (itens.removeIf(item -> item.getProduto().getNome().equalsIgnoreCase(nomeProduto))) {
            System.out.println("Produto removido do carrinho: " + nomeProduto);
        } else {
            System.out.println("Produto não encontrado no carrinho: " + nomeProduto);
        }
    }

    public void atualizarQuantidade(String nomeProduto, int novaQuantidade) {
        for (ItemCarrinho item : itens) {
            if (item.getProduto().getNome().equalsIgnoreCase(nomeProduto)) {
                item.setQuantidade(novaQuantidade);
                System.out.println("Quantidade atualizada para o produto: " + nomeProduto);
                return;
            }
        }
        System.out.println("Produto não encontrado no carrinho: " + nomeProduto);
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemCarrinho item : itens) {
            total += item.calcularSubtotal();
        }
        return total;
    }

    public void exibirCarrinho() {
        if (itens.isEmpty()) {
            System.out.println("O carrinho está vazio.");
            return;
        }
        System.out.println("Itens no carrinho:");
        for (ItemCarrinho item : itens) {
            System.out.printf("%s - Quantidade: %d - Subtotal: R$ %.2f%n",
                    item.getProduto().getNome(),
                    item.getQuantidade(),
                    item.calcularSubtotal());
        }
        System.out.printf("Total: R$ %.2f%n", calcularTotal());
    }
}

public class LojaOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Remover produto");
            System.out.println("3 - Atualizar quantidade");
            System.out.println("4 - Exibir carrinho");
            System.out.println("5 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o preço do produto: ");
                    double preco = scanner.nextDouble();
                    System.out.print("Digite a quantidade: ");
                    int quantidade = scanner.nextInt();

                    Produto produto = new Produto(nome, preco);
                    carrinho.adicionarProduto(produto, quantidade);
                    break;

                case 2:
                    System.out.print("Digite o nome do produto a ser removido: ");
                    String nomeRemover = scanner.nextLine();
                    carrinho.removerProduto(nomeRemover);
                    break;

                case 3:
                    System.out.print("Digite o nome do produto: ");
                    String nomeAtualizar = scanner.nextLine();
                    System.out.print("Digite a nova quantidade: ");
                    int novaQuantidade = scanner.nextInt();
                    carrinho.atualizarQuantidade(nomeAtualizar, novaQuantidade);
                    break;

                case 4:
                    carrinho.exibirCarrinho();
                    break;

                case 5:
                    System.out.println("Encerrando o programa.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
