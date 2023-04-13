package Models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class UsuarioVip extends UsuarioModelo implements Usuario {

    Scanner sc = new Scanner(System.in);

    private String tipo;

    private String temWifi;

    private String temPiscina;

    private String temVistaProMar;

    public String getTemWifi() {
        return temWifi;
    }

    public void setTemWifi(String temWifi) {
        this.temWifi = temWifi;
    }

    public String getTemPiscina() {
        return temPiscina;
    }

    public void setTemPiscina(String temPiscina) {
        this.temPiscina = temPiscina;
    }

    public String getTemVistaProMar() {
        return temVistaProMar;
    }

    public void setTemVistaProMar(String temVistaProMar) {
        this.temVistaProMar = temVistaProMar;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public UsuarioVip() {
    }

    public UsuarioVip(String tipo, String nome, Integer idade, Long cpf, Integer quantidadeCamas, Integer quantidadePessoas, String confirmarDados, String dataInicial, String dataFinal, String temWifi, String temPiscina, String temVistaProMar) {
        super(nome, idade, cpf, quantidadeCamas, quantidadePessoas, confirmarDados, dataInicial,
                dataFinal);
        this.tipo = tipo;
        this.temWifi = temWifi;
        this.temPiscina = temPiscina;
        this.temVistaProMar = temVistaProMar;
    }

    @Override
    public String toString() {
        return "UsuarioVip{" +
                "tipo='" + tipo + '\'' +
                ", temWifi='" + temWifi + '\'' +
                ", temPiscina='" + temPiscina + '\'' +
                ", temVistaProMar='" + temVistaProMar + '\'' +
                "} " + super.toString();
    }

    @Override
    public UsuarioVip cadastroVip() {
        System.out.println("Tela de cadastro vip");
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
        System.out.println("Quer um quarto que tenha Wi-fi?");
        temWifi = sc.nextLine();
        System.out.println("Deseja um hotel que tenha acesso a piscina?");
        temPiscina = sc.nextLine();
        System.out.println("Deseja um quarto que tenha vista para o mar?");
        temVistaProMar = sc.nextLine();
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
        tipo = "Vip";
        UsuarioVip usuarioVip = new UsuarioVip(tipo, getNome(), getIdade(), getCpf(), getQuantidadeCamas(),
                getQuantidadePessoas(), "", getDataInicial(), getDataFinal(), temWifi, temPiscina,
                temVistaProMar);
        System.out.println("Confime seus dados!");
        System.out.println("-----------------------------------------------------------------");
        System.out.println(usuarioVip);
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Seus dados estão corretos [S/N]");
        setConfimarDados(sc.nextLine());
        if (Objects.equals(getConfimarDados(), "S")) {
            System.out.println("Ok, seu quarto está reservado, seguem as informações do mesmo");
            System.out.println(
                    "---------------------------------------------------------------------------------------------");
            quartosVip();
        } else {
            System.out.println("Seus dados estão incorretos, tente o cadastro novamente");
            System.out.println(
                    "--------------------------------------------------------------------------------------------");
            usuarioVip.cadastroVip();
        }
        return null;
    }

    @Override
    public UsuarioVip quartosVip() {
        System.out.println(new QuartosVip(tipo, 2, 4000.00, getQuantidadeCamas(), getQuantidadePessoas(),
                "", temWifi, temPiscina, temVistaProMar));
        return null;
    }

    @Override
    public UsuarioComum cadastro() {
        return null;
    }

    @Override
    public UsuarioComum quartos() {
        return null;
    }
}
