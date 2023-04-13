package Models;

import java.util.Objects;
import java.util.Scanner;

public class QuartosComum extends QuartoModelo {

    Scanner sc = new Scanner(System.in);

    String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public QuartosComum() {}

    public QuartosComum(String tipo, Integer numero, Double preco, Integer quantidadeCamas, Integer quantidadePessoas, String confirmarDados) {
        super(numero, preco, quantidadeCamas, quantidadePessoas, confirmarDados);
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "QuartosComum{" +
                "tipo='" + tipo + '\'' +
                "} " + super.toString();
    }

    public QuartosComum cadastroQuartosComum() {
        System.out.println("Tela de cadastro quarto comum");
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
        tipo = "Comum";
        QuartosComum quartoComum = new QuartosComum(tipo, numero, preco, quantidadeCamas,
                quantidadePessoas, "");
        System.out.println("Confirme os dados do quarto");
        System.out.println("-----------------------------------------------");
        System.out.println(quartoComum);
        System.out.println("-----------------------------------------------");
        System.out.println("Os dados estão corretos [S/N}");
        confirmarDados = sc.nextLine();
        if (Objects.equals(confirmarDados, "S")) {
            System.out.println("Seu quarto foi criado com sucesso!");
            System.out.println(
                    "---------------------------------------------------------------------------------------------");
            System.out.println(quartoComum);
            ;
        } else {
            System.out.println("Seus dados estão incorretos, tente o cadastro novamente");
            System.out.println(
                    "--------------------------------------------------------------------------------------------");
            cadastroQuartosComum();
        }
        return null;
    }
}
