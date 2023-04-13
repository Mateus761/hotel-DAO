package Models;

import java.util.Objects;
import java.util.Scanner;

public class QuartosVip extends QuartoModelo {

    Scanner sc = new Scanner(System.in);

    String tipo;

    String temWifi;

    String temPisicna;

    String temVistaProMar;

    public String getTemWifi() {
        return temWifi;
    }

    public void setTemWifi(String temWifi) {
        this.temWifi = temWifi;
    }

    public String getTemPisicna() {
        return temPisicna;
    }

    public void setTemPisicna(String temPisicna) {
        this.temPisicna = temPisicna;
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

    public QuartosVip() {
    }

    public QuartosVip(String tipo, Integer numero, Double preco, Integer quantidadeCamas, Integer quantidadePessoas, String confirmarDados, String temWifi, String temPisicna, String temVistaProMar) {
        super(numero, preco, quantidadeCamas, quantidadePessoas, confirmarDados);
        this.tipo = tipo;
        this.temWifi = temWifi;
        this.temPisicna = temPisicna;
        this.temVistaProMar = temVistaProMar;
    }

    @Override
    public String toString() {
        return "QuartosVip{" +
                "tipo='" + tipo + '\'' +
                ", temWifi='" + temWifi + '\'' +
                ", temPisicna='" + temPisicna + '\'' +
                ", temVistaProMar='" + temVistaProMar + '\'' +
                "} " + super.toString();
    }

    public QuartosVip cadastroQuartosVip() {
        System.out.println("Tela de cadastro quarto vip");
        System.out.println("----------------------------------------------------");
        System.out.println("Digite o número do quarto: ");
        numero = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite o preço do quarto: ");
        preco = sc.nextDouble();
        sc.nextLine();
        System.out.println("Digite a quantidade de camas que o quarto terá: ");
        quantidadeCamas = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite a quantidade de pessoas que cabem no quarto: ");
        quantidadePessoas = sc.nextInt();
        sc.nextLine();
        System.out.println("O quarto tem Wi-fi?");
        temWifi = sc.nextLine();
        System.out.println("O prédio tem piscina?");
        temPisicna = sc.nextLine();
        System.out.println("O quarto tem vista para o mar?");
        temVistaProMar = sc.nextLine();
        tipo = "Vip";
        QuartosVip quartoVip = new QuartosVip(tipo, numero, preco, quantidadeCamas,
                quantidadePessoas, "", temWifi, temPisicna, temVistaProMar);
        System.out.println("Confirme os dados do quarto vip");
        System.out.println("-----------------------------------------------");
        System.out.println(quartoVip);
        System.out.println("-----------------------------------------------");
        System.out.println("Os dados estão corretos [S/N}");
        confirmarDados = sc.nextLine();
        if (Objects.equals(confirmarDados, "S")) {
            System.out.println("Seu quarto foi criado com sucesso!");
            System.out.println(
                    "---------------------------------------------------------------------------------------------");
            System.out.println(quartoVip);
            ;
        } else {
            System.out.println("Seus dados estão incorretos, tente o cadastro novamente");
            System.out.println(
                    "--------------------------------------------------------------------------------------------");
            cadastroQuartosVip();
        }
        return null;
    }
}


