class Token {
    protected String nome;
    protected double valor;

    public Token(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Token{" +
                "nome='" + nome + '\'' +
                ", valor=" + valor +
                '}';
    }
}

class TokenFungivel extends Token {
    private int quantidade;

    public TokenFungivel(String nome, double valor, int quantidade) {
        super(nome, valor);
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return "TokenFungivel{" +
                "nome='" + nome + '\'' +
                ", valor=" + valor +
                ", quantidade=" + quantidade +
                '}';
    }
}

class TokenNaoFungivel extends Token {
    private String idUnico;

    public TokenNaoFungivel(String nome, double valor, String idUnico) {
        super(nome, valor);
        this.idUnico = idUnico;
    }

    public String getIdUnico() {
        return idUnico;
    }

    @Override
    public String toString() {
        return "TokenNaoFungivel{" +
                "nome='" + nome + '\'' +
                ", valor=" + valor +
                ", idUnico='" + idUnico + '\'' +
                '}';
    }
}

public class Classe {
    public static void main(String[] args) {
        TokenFungivel tokenFungivel = new TokenFungivel("Token Fungível", 10.0, 100);
        TokenNaoFungivel tokenNaoFungivel = new TokenNaoFungivel("Token Não Fungível", 50.0, "ID123456");

        System.out.println(tokenFungivel);
        System.out.println(tokenNaoFungivel);
    }
}