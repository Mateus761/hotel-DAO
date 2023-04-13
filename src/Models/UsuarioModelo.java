package Models;

public class UsuarioModelo {

    private String nome;

    private Integer idade;

    private Long cpf;

    private Integer quantidadeCamas;

    private Integer quantidadePessoas;

    private String confimarDados;

    private String dataInicial;

    private String dataFinal;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getConfimarDados() {
        return confimarDados;
    }

    public void setConfimarDados(String confimarDados) {
        this.confimarDados = confimarDados;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
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

    public String getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public UsuarioModelo() {}

    public UsuarioModelo(String nome, Integer idade, Long cpf, Integer quantidadeCamas, Integer quantidadePessoas, String confimarDados, String dataInicial, String dataFinal) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.quantidadeCamas = quantidadeCamas;
        this.quantidadePessoas = quantidadePessoas;
        this.confimarDados = confimarDados;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
    }

    @Override
    public String toString() {
        return "UsuarioModelo{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cpf=" + cpf +
                ", quantidadeCamas=" + quantidadeCamas +
                ", quantidadePessoas=" + quantidadePessoas +
                ", confimarDados='" + confimarDados + '\'' +
                ", dataInicial='" + dataInicial + '\'' +
                ", dataFinal='" + dataFinal + '\'' +
                '}';
    }
}



