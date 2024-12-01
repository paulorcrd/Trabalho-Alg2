import java.util.ArrayList;
import java.util.List;

class Item {
    private String nome;
    private double preco;

    public Item(String nome, double preco) {
        if (preco < 0) {
            throw new IllegalArgumentException("O preço não pode ser negativo.");
        }
        this.nome = nome;
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return nome + ": R$ " + String.format("%.2f", preco);
    }
}

class Eletronico extends Item {
    private int garantia;

    public Eletronico(String nome, double preco, int garantia) {
        super(nome, preco);
        this.garantia = garantia;
    }

    @Override
    public String toString() {
        return super.toString() + " (Garantia: " + garantia + " anos)";
    }
}

class Alimento extends Item {
    private String validade;

    public Alimento(String nome, double preco, String validade) {
        super(nome, preco);
        this.validade = validade;
    }

    @Override
    public String toString() {
        return super.toString() + " (Validade: " + validade + ")";
    }
}

class Carrinho {
    private List<Item> itens;

    public Carrinho() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("O item não pode ser nulo.");
        }
        itens.add(item);
    }

    public void removerItem(Item item) {
        if (!itens.remove(item)) {
            System.out.println("Item não encontrado no carrinho.");
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (Item item : itens) {
            total += item.getPreco();
        }
        return total;
    }

    public void listarItens() {
        if (itens.isEmpty()) {
            System.out.println("O carrinho está vazio.");
        } else {
            for (Item item : itens) {
                System.out.println(item);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Carrinho carrinho = new Carrinho();

        try {
            Eletronico eletronico = new Eletronico("Smartphone", 1200.00, 2);
            Alimento alimento = new Alimento("Maçã", 3.50, "10/10/2023");

            carrinho.adicionarItem(eletronico);
            carrinho.adicionarItem(alimento);

            System.out.println("Itens no carrinho:");
            carrinho.listarItens();
            System.out.println("Total: R$ " + String.format("%.2f", carrinho.calcularTotal()));

            carrinho.removerItem(alimento);
            System.out.println("\nApós remover o alimento:");
            carrinho.listarItens();
            System.out.println("Total: R$ " + String.format("%.2f", carrinho.calcularTotal()));
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}