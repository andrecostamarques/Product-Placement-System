public class Produto {
    private int id;
    protected double valor;
    private String descricao;
    private static int quantidade = 0;

    // construtor que recebe a descrição e valor de um produto
    // e incrementa a quantidade a cada instância
    public Produto(String descricao, double valor) {
        quantidade++;
        this.id = quantidade;
        this.descricao = descricao;
        this.valor = valor;
    }

    // getters e setters
    public String getDescricao() {
        return descricao;
    }

    public int getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    // método que retorna dados do

    public String toString() {
        return "Id do produto: " + getId() + "\nValor do produto: " + getValor() + "\nDescrição do produto: "
                + getDescricao();
    }

}