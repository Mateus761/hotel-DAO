package Models;

public class QuartoModelo {

    Integer numero;

    Double preco;

    Integer quantidadeCamas;

    Integer quantidadePessoas;

    String confirmarDados;

    public Integer getNumero() {
        return numero;
    }

    public String getConfirmarDados() {
        return confirmarDados;
    }

    public void setConfirmarDados(String confirmarDados) {
        this.confirmarDados = confirmarDados;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidadeCamas() {
        return quantidadeCamas;
    }

    public void setQuantidadeCamas(Integer quantidadeCamas) {
        this.quantidadeCamas = quantidadeCamas;
    }

    public Integer getQuantidadePessoas() {
        return quantidadePessoas;
    }

    public void setQuantidadePessoas(Integer quantidadePessoas) {
        this.quantidadePessoas = quantidadePessoas;
    }

    public QuartoModelo() {}

    public QuartoModelo(Integer numero, Double preco, Integer quantidadeCamas, Integer quantidadePessoas, String confirmarDados) {
        this.numero = numero;
        this.preco = preco;
        this.quantidadeCamas = quantidadeCamas;
        this.quantidadePessoas = quantidadePessoas;
        this.confirmarDados = confirmarDados;
    }

    @Override
    public String toString() {
        return "QuartoModelo{" +
                "numero=" + numero +
                ", preco=" + preco +
                ", quantidadeCamas=" + quantidadeCamas +
                ", quantidadePessoas=" + quantidadePessoas +
                ", confirmarDados='" + confirmarDados + '\'' +
                '}';
    }
}
