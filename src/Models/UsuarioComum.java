package Models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class UsuarioComum  extends UsuarioModelo implements Usuario, Quarto{

    Scanner sc = new Scanner(System.in);

    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public UsuarioComum() {}

    public UsuarioComum(String tipo, String nome, Integer idade, Long cpf, Integer quantidadeCamas, Integer quantidadePessoas, String confirmarDados, String dataInicial, String dataFinal) {
        super(nome, idade, cpf, quantidadeCamas, quantidadePessoas, confirmarDados, dataInicial, dataFinal);
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "UsuarioComum{" +
                "tipo='" + tipo + '\'' +
                "} " + super.toString();
    }

    @Override
    public UsuarioComum cadastro() {
        System.out.println("Tela de cadastro");
        System.out.println("-------------------------------------------");
        System.out.println("Digite seu nome: ");
        setNome(sc.nextLine());
        System.out.println("Digite sua idade: ");
        setIdade(sc.nextInt());
        sc.nextLine();
        System.out.println("Digite seu cpf: ");
        setCpf(sc.nextLong());
        sc.nextLine();
        System.out.println("Qual a quantidade de camas que deseja que o quarto tenha?");
        setQuantidadeCamas(sc.nextInt());
        sc.nextLine();
        System.out.println("Qual a quantidade de pessoas ?");
        setQuantidadePessoas(sc.nextInt());
        sc.nextLine();
        System.out.println("Qual a data do check-in?");
        setDataInicial(sc.nextLine());
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dt = df.parse(getDataInicial());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Qual a data do check-out?");
        setDataFinal(sc.nextLine());
        DateFormat dy = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date de = dy.parse(getDataFinal());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        tipo = "Comum";
        UsuarioComum usuario = new UsuarioComum(tipo, getNome(), getIdade(), getCpf(), getQuantidadeCamas(),
                getQuantidadePessoas(), "", getDataInicial(), getDataFinal());
        System.out.println("Confime seus dados!");
        System.out.println("-----------------------------------------------------------------");
        System.out.println(usuario);
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Seus dados estão corretos [S/N]");
        setConfimarDados(sc.nextLine());
        if (Objects.equals(getConfimarDados(), "S")) {
            System.out.println("Ok, seu quarto está reservado, seguem as informações do mesmo");
            System.out.println(
                    "---------------------------------------------------------------------------------------------");
            quartos();
        } else {
            System.out.println("Seus dados estão incorretos, tente o cadastro novamente");
            System.out.println(
                    "--------------------------------------------------------------------------------------------");
            usuario.cadastro();
        }
        return null;
    }

    @Override
    public UsuarioComum quartos() {
        System.out.println(new QuartosComum(tipo, 1, 2000.00, getQuantidadeCamas(), getQuantidadePessoas(), ""));
        return null;
    }

    @Override
    public UsuarioVip cadastroVip() {
        return null;
    }

    @Override
    public UsuarioVip quartosVip() {
        return null;
    }

    @Override
    public QuartosComum cadastroQuartoComum() {
    return null;
    }

    @Override
    public QuartosVip cadastroQuartoVip() {
        return null;
    }
}


