package entities;

import java.util.Scanner;

public class Menu {
    Scanner input = new Scanner(System.in);

    Cliente cliente = new Cliente();
    Conta cc = new ContaCorrente(cliente);
    Conta poupanca = new ContaPoupanca(cliente);

    public void menu(){
        double valor = 0.0;
        String titular;

        System.out.println(" ");

        System.out.println("\n        =========================");
        System.out.println("        O que o sr (a) deseja fazer? ");
        System.out.println("        |     1 - Depositar   |");
        System.out.println("        |     2 - Sacar       |");
        System.out.println("        |     3 - Transferir  |");
        System.out.println("        |     4 - Extrato     |");
        System.out.println("        |     0 - Sair        |");
        System.out.println("          =========================\n");
        System.out.print("Opção desejada: ");
        int op = input.nextInt();

        /*Cliente venilton = new Cliente();
        venilton.setNome("Venilton");

        Conta cc = new ContaCorrente(venilton);
        Conta poupanca = new ContaPoupanca(venilton);

        cc.depositar(100);
        cc.transferir(150, poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();*/



        do {
            switch (op){
                case 1:
                    System.out.print("Qual o nome do titular? ");
                    cliente.setNome(titular = input.next());
                    System.out.print("Quanto você deseja depositar? ");
                    System.out.print("R$ ");
                    valor = input.nextDouble();
                    cc.depositar(valor);
                    System.out.print(String.format("Foram depositados R$ %.2f",valor));
                    menu();
                    break;
                case 2:
                    System.out.print("Quanto você deseja sacar? ");
                    System.out.print("R$ ");
                    valor = input.nextDouble();
                    cc.sacar(valor);
                    System.out.print(String.format("Foram sacados R$ %.2f",valor));
                    menu();
                    break;
                case 3:
                    System.out.print("Quanto você deseja transferir para a poupança? ");
                    System.out.print("R$ ");
                    valor = input.nextDouble();
                    cc.transferir(valor, poupanca);
                    System.out.print(String.format("Foram transferidos R$ %.2f",valor));
                    menu();
                    break;
                case 4:
                    cc.imprimirExtrato();
                    poupanca.imprimirExtrato();
                    break;
                case 0:
                    System.out.print("Você está saindo do menu...");
                    break;
                // Caso a opção escolhida não seja válida, mostra o menu novamente
                default:
                    System.err.print("Opção inválida!");
                    menu();
                    break;
            }
        }while (op != 0);
    }
}
