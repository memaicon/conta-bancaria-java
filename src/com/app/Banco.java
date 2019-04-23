/*
 * Trabalho T2G1
 * Banco ACME - Gestão de Contas Correntes
 */
package com.app;

import java.util.Random;
import java.util.Scanner;

/*
* Classe Principal
* Banco
*/
public class Banco {

    public static void main(String[] args) {
        // Chama método mostraMenu
        mostraMenuPrincipal();
    }
    
    private static void mostraMenuPrincipal() {
        boolean sair = true;

        Scanner Menu = new Scanner(System.in);
        
        while (sair) {
            int menu;
            
            System.out.println("Bem vindo ao Banco ACME \n");
            System.out.println("Escolha a sua opção desejada:");

            do {
                System.out.println("1 – Criar Conta Corrente"); 
                System.out.println("2 – Criar Conta Corrente Especial");
                System.out.println("3 – Sacar Conta Corrente");
                System.out.println("4 – Sacar Conta Corrente Especial");
                System.out.println("5 – Depositar Conta Corrente");
                System.out.println("6 – Depositar Conta Corrente Especial");
                System.out.println("7 - Cancelar.");

                menu = Menu.nextInt();
            
                if (menu < 1 || menu > 7) {
                    System.out.println("Opção Inválida, tente novamente.");
                }

            } while (menu < 1 || menu > 7);
            
            // Menu
            switch (menu) {
                case 1: // Criar Conta Corrente
                    novaContaCorrente();
                    break;
                case 2: // Criar Conta Corrente Especial
                    novaContaEspecial();
                    break;
                case 3: // Sacar Conta Corrente
                    break;
                case 4: // Sacar Conta Corrente Especial
                    break;
                case 5: // Depositar Conta Corrente
                    break;
                case 6: // Depositar Conta Corrente Especial
                    break;
                case 7: // Cancelar
                    System.out.println("Obrigado por escolher o Banco ACME. Aguardamos seu retorno.");
                    System.exit(0);
            }
        }
    }
    
    private static void novaContaCorrente() {
        Scanner entrada = new Scanner(System.in);
        
        //Obtendo os dados iniciais do Cliente
        String nome;
        String cpf;
        int agencia = 002;
        Random numero = new Random();
        int numConta = 1 + numero.nextInt(9999);

        System.out.println("Cadastrando novo cliente.");
        System.out.print("Ente com o nome do cliente: ");
        nome = entrada.nextLine();
        System.out.print("Ente com o CPF do nome: ");
        cpf = entrada.nextLine();

        // Cria conta de um cliente
        ContaCorrente novaConta = new ContaCorrente(nome, cpf, agencia, numConta);
        System.out.println("\nCliente cadastrado com sucesso!\n");
        System.out.println("Cliente: " + novaConta.getCliente());
        System.out.println("Agência: " + novaConta.getAgencia() + " | Conta: " + novaConta.getNumConta());
        System.out.println("Saldo: " + novaConta.getSaldo() + "\n");
    }
    
    private static void novaContaEspecial() {
        Scanner entrada = new Scanner(System.in);
        
        //Obtendo os dados iniciais do Cliente
        String nome;
        String cpf;
        float limite;
        int agencia = 002;
        Random numero = new Random();
        int numConta = 1 + numero.nextInt(9999);

        System.out.println("Cadastrando novo cliente.");
        System.out.print("Ente com o nome do cliente: ");
        nome = entrada.nextLine();
        System.out.print("Ente com o CPF do nome: ");
        cpf = entrada.nextLine();
        System.out.print("Ente com o limite da conta: ");
        limite = entrada.nextFloat();

        ContaEspecial novaConta = new ContaEspecial(nome, cpf, agencia, numConta, limite);
        System.out.println("\nCliente cadastrado com sucesso!\n");
        System.out.println("Cliente: " + novaConta.getCliente());
        System.out.println("Agência: " + novaConta.getAgencia() + " | Conta: " + novaConta.getNumConta());
        System.out.println("Saldo: " + novaConta.getSaldo() + "\n");
        System.out.println("Limite: " + novaConta.getLimite() + "\n");
    }
}
