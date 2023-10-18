import java.time.LocalDateTime;

public class Perecivel extends Produto {

    private int[] validade;

    // construtor que recebe a descrição, valor e data de validade de um produto
    // perecível

    public Perecivel(String descricao, double valor, int day, int month, int year) { //mandar uma array com 3 valores
        super(descricao, valor);
        validade = new int[3];
        validade[0] = day;
        validade[1] = month;
        validade[2] = year;
    }
    public boolean estaVencido(){
        LocalDateTime dataHoje = LocalDateTime.now();
        LocalDateTime dataVencimento = LocalDateTime.of(validade[2],validade[1],validade[0],0,0);

        return dataHoje.isAfter(dataVencimento);
    } //retorna true se estiver vencido
        //retorna false se NÃO estiver vencido

    public int[] getValidade(){
        return validade;  //retorna a array da data da validade
    }

    public void aplicaDesconto(double desconto){
        valor = valor * ((100-desconto)/100);
    }

    @Override
    public String toString() {
        return "Id do produto: " + getId() + "\nValor do produto: " + getValor() + "\nDescrição do produto: "
                + getDescricao() + "\nValidade:" + validade[0] + "/" + validade[1] + "/" + validade[2];
    }
}