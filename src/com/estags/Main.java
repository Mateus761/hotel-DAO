package com.estags;

import DAO.DataBaseConnection;
import Models.QuartosComum;
import Models.QuartosVip;
import Models.UsuarioComum;
import Models.UsuarioVip;

import java.sql.*;
import java.text.ParseException;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    private static void opcoes() {

        Scanner sc = new Scanner(System.in);

        UsuarioComum usuario = new UsuarioComum();

        UsuarioVip usuarioVip = new UsuarioVip();

        QuartosComum quartoComum = new QuartosComum();

        QuartosVip quartoVip = new QuartosVip();

        int opcao;

        String maisCadastro;

        System.out.println("Escolha uma opcão: ");
        System.out.println("1 - cadastrar um usuário");
        System.out.println("2 - cadastrar um usário vip");
        System.out.println("3 - cadastrar um quarto");
        System.out.println("4 - cadastrar um quarto vip");

        opcao = sc.nextInt();

        if (opcao == 1) {
            usuario.cadastro();
            System.out.println("----------------------------------------------------");
            System.out.println("Deseja fazer mais alguma cadastro [S/N]");
            System.out.println("----------------------------------------------------");
            sc.nextLine();
            maisCadastro = sc.nextLine();
            if (Objects.equals(maisCadastro, "S")) {
                opcoes();
            }
        } else if (opcao == 2) {
            usuarioVip.cadastroVip();
            System.out.println("----------------------------------------------------");
            System.out.println("Deseja fazer mais alguma cadastro [S/N]");
            System.out.println("----------------------------------------------------");
            sc.nextLine();
            maisCadastro = sc.nextLine();
            if (Objects.equals(maisCadastro, "S")) {
                opcoes();
            }
        } else if (opcao == 3) {
            quartoComum.cadastroQuartosComum();
            System.out.println("----------------------------------------------------");
            System.out.println("Deseja fazer mais alguma cadastro [S/N]");
            System.out.println("----------------------------------------------------");
            sc.nextLine();
            maisCadastro = sc.nextLine();
            if (Objects.equals(maisCadastro, "S")) {
                opcoes();
            }
        } else if (opcao == 4) {
            quartoVip.cadastroQuartosVip();
            System.out.println("----------------------------------------------------");
            System.out.println("Deseja fazer mais alguma cadastro [S/N]");
            System.out.println("----------------------------------------------------");
            sc.nextLine();
            maisCadastro = sc.nextLine();
            if (Objects.equals(maisCadastro, "S")) {
                opcoes();
            }
        } else {
            System.out.println("Opção inválida, escolha novamente");
            System.out.println("-----------------------------------------------");
            opcoes();
        }

        Connection connection = DataBaseConnection.getConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS USUARIOCOMUM (TIPO VARCHAR(255)," +
                    " NOME VARCHAR(255), IDADE INTEGER, CPF BIGINT, QUANTIDADEPESSOAS INTEGER, " +
                    "QUANTIDADECAMAS INTEGER, CONFIRMARDADOS VARCHAR(255), " +
                    "DATAINICIAL DATE, DATAFINAL DATE)");

            PreparedStatement statement1 = connection.prepareStatement("INSERT INTO USUARIOCOMUM" +
                    "(TIPO,NOME,IDADE,CPF,QUANTIDADEPESSOAS,QUANTIDADECAMAS,CONFIRMARDADOS," +
                    "DATAINICIAL,DATAFINAL) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");


            statement1.setString(1, usuario.getTipo());
            statement1.setString(2, usuario.getNome());
            statement1.setInt(3, usuario.getIdade());
            statement1.setLong(4, usuario.getCpf());
            statement1.setInt(5, usuario.getQuantidadePessoas());
            statement1.setInt(6, usuario.getQuantidadeCamas());
            statement1.setString(7, usuario.getConfimarDados());
            statement1.setString(8, usuario.getDataInicial());
            statement1.setString(9, usuario.getDataFinal());
            statement1.execute();

            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM USUARIOCOMUM");

            ResultSet resultSet = stmt.executeQuery();

            while(resultSet.next()) {
                String tipo = resultSet.getString("TIPO");
                String name = resultSet.getString("NOME");
                Integer idade = resultSet.getInt("IDADE");
                Long cpf = resultSet.getLong("CPF");
                Integer quantidadeCamas = resultSet.getInt("QUANTIDADECAMAS");
                Integer quantidadePessoas = resultSet.getInt("QUANTIDADEPESSOAS");
                String confirmarDados = resultSet.getString("CONFIRMARDADOS");
                String dataInicial = resultSet.getString("DATAINICIAL");
                String dataFinal = resultSet.getString("DATAFINAL");

                System.out.println(tipo +  "-"  +  name  +  "-"  +  idade  +  "-"  +  cpf +  "-"  +  quantidadeCamas
                        +  "-"  +  quantidadePessoas  +  "-"  +  confirmarDados  +  "-"  +  dataInicial  +  "-"  + dataFinal);

            }

            //Statement statement2 = connection.createStatement();

           // statement2.execute("DELETE FROM USUARIOCOMUM WHERE IDADE = 19");

            /*Statement statement3 = connection.createStatement();
            statement3.execute("CREATE TABLE IF NOT EXISTS USUARIOVIP (TIPO VARCHAR(255)," +
                    " NOME VARCHAR(255), IDADE INTEGER, CPF BIGINT, QUANTIDADEPESSOAS INTEGER, " +
                    "QUANTIDADECAMAS INTEGER, CONFIRMARDADOS VARCHAR(255), " +
                    "DATAINICIAL DATE, DATAFINAL DATE, WIFI VARCHAR(255), PISICINA VARCHAR(255), " +
                    "VISTAPROMAR VARCHAR(255))");

            PreparedStatement statement4 = connection.prepareStatement("INSERT INTO USUARIOCOMUM" +
                    "(TIPO,NOME,IDADE,CPF,QUANTIDADEPESSOAS,QUANTIDADECAMAS,CONFIRMARDADOS," +
                    "DATAINICIAL,DATAFINAL,WIFI,PISCINA,VISTAPROMAR) VALUES (?, ?, ?, ?, ?, ?," +
                    " ?, ?, ?, ?,?,?)");


            statement4.setString(1, usuarioVip.getTipo());
            statement4.setString(2, usuarioVip.getNome());
            statement4.setInt(3, usuarioVip.getIdade());
            statement4.setLong(4, usuarioVip.getCpf());
            statement4.setInt(5, usuarioVip.getQuantidadePessoas());
            statement4.setInt(6, usuarioVip.getQuantidadeCamas());
            statement4.setString(7, usuarioVip.getConfimarDados());
            statement4.setString(8, usuarioVip.getDataInicial());
            statement4.setString(9, usuarioVip.getDataFinal());
            statement4.setString(10, usuarioVip.getTemWifi());
            statement4.setString(11, usuarioVip.getTemPiscina());
            statement4.setString(12, usuarioVip.getTemVistaProMar());
            statement4.execute();

            PreparedStatement stmt1 = connection.prepareStatement("SELECT * FROM USUARIOCOMUM");

            ResultSet resultSet1 = stmt1.executeQuery();

            while(resultSet.next()) {
                String tipo = resultSet1.getString("TIPO");
                String name = resultSet1.getString("NOME");
                Integer idade = resultSet1.getInt("IDADE");
                Long cpf = resultSet1.getLong("CPF");
                Integer quantidadeCamas = resultSet1.getInt("QUANTIDADECAMAS");
                Integer quantidadePessoas = resultSet1.getInt("QUANTIDADEPESSOAS");
                String confirmarDados = resultSet1.getString("CONFIRMARDADOS");
                String dataInicial = resultSet1.getString("DATAINICIAL");
                String dataFinal = resultSet1.getString("DATAFINAL");
                String wifi = resultSet1.getString("WIFI");
                String temPiscina = resultSet1.getString("`PISCINA");
                String temVistraProMar = resultSet1.getString("VISTAPROMAR");

                System.out.println(tipo + "-" + name + "-" + idade + "-" + cpf + "-" + quantidadeCamas
                        + "-" + quantidadePessoas + "-" + confirmarDados + "-" + dataInicial +
                        "-" + dataFinal + " - " + wifi + " - " + temPiscina + " - " + temVistraProMar);
            }*/

        } catch (SQLException e) {
            e.printStackTrace();
        }











       /* try {
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS QUARTOSCOMUM(TIPO VARCHAR (255), NUMERO INTEGER, PRECO DOUBLE, QUANTIDADECAMAS INTEGER, QUANTIDADEPESSOAS INTEGER, CONFIRMARDADOS VARCHAR(255)");

            PreparedStatement statement1 = connection.prepareStatement("INSERT INTO  QUARTOSCOMUM(TIPO, NUMERO, PRECO, QUANTIDADECAMAS, QUANTIDADEPESSOAS, CONFIRMARDADOS) VALUES (?,?,?,?,?,?)");

            statement1.setString(1, quartoComum.getTipo());
            statement1.setInt(2, quartoComum.getNumero());
            statement1.setDouble(3, quartoComum.getPreco());
            statement1.setInt(4, quartoComum.getQuantidadeCamas());
            statement1.setInt(5, quartoComum.getQuantidadePessoas());
            statement1.setString(6, quartoComum.getConfirmarDados());
            statement1.execute();

            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM QUARTOSCOMUM");

            ResultSet resultSet = stmt.executeQuery();

            while(resultSet.next()) {
                String tipo = resultSet.getString("TIPO");
                Integer numero = resultSet.getInt("NUMERO");
                Double preco = resultSet.getDouble("PRECO");
                Integer quantidadeCamas = resultSet.getInt("QUANTIDADECAMAS");
                Integer quantidadePessoas = resultSet.getInt("QUANTIDADEPESSOAS");
                String confirmarDados = resultSet.getString("CONFIRMARDADOS");

                System.out.println(tipo + " - " + numero + " - " + preco  + " - " + quantidadeCamas + " - " + quantidadePessoas + " - " + confirmarDados);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

    }

    public static void main(String[] args) throws ParseException {

        opcoes();
    }
}
