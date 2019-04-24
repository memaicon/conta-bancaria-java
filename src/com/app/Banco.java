/*
 * Trabalho T2G1
 * Banco ACME - Gestão de Contas Correntes
 * Maicon Esperafico
 * Carlos Kasper
 */
package com.app;

import java.util.Random;
import java.util.Scanner;

/*
* Classe Principal
* Banco
*/
public class Banco {
    
    private static int agencia = 2031;
    private static float saldo = 0;
    private static int totalContasCorrente = 0;
    private static int totalContasEspecial = 0;
    
    private static ContaCorrente[] novaContaCorrente = new ContaCorrente[5];
    private static ContaEspecial[] novaContaEspecial = new ContaEspecial[5];

    public static void main(String[] args) {
        System.out.println("Bem vindo ao Banco ACME \n");
        // Chama método mostraMenu
        mostraMenuPrincipal();
    }
    
    private static void mostraMenuPrincipal() {
        boolean sair = true;

        Scanner Menu = new Scanner(System.in);
        
        while (sair) {
            int menu;
            System.out.println("\nEscolha a sua opção desejada:");

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
                case 2: // Criar Conta Especial
                    novaContaEspecial();
                    break;
                case 3: // Sacar Conta Corrente
                    sacarContaCorrente();
                    break;
                case 4: // Sacar Conta Especial
                    sacarContaEspecial();
                    break;
                case 5: // Depositar Conta Corrente
                    depositarContaCorrente();
                    break;
                case 6: // Depositar Conta Especial
                    depositarContaEspecial();
                    break;
                case 7: // Cancelar
                    System.out.println("Obrigado por escolher o Banco ACME. Aguardamos seu retorno.");
                    System.exit(0);
            }
        }
    }
    
    private static void novaContaCorrente() {
        Scanner entrada = new Scanner(System.in);
        
        /* Verifica se o tamanho do array é menor que 5 então prossegue.
         * Caso contrário cai retorna Limite de Conta Excedido.
         */
        if(totalContasCorrente >= 5) {
            System.out.println("Limite de Contas Corrente excedido!\n");
            return;
        }

        // Obtem os dados iniciais do Cliente para Conta Corrente
        String nome;
        String cpf;
        
        // Gera um número randomico para a conta
        Random numero = new Random();
        int numConta = 1 + numero.nextInt(9999);

        System.out.println("Cadastrando novo cliente.");
        System.out.print("Ente com o nome do cliente: ");
        nome = entrada.nextLine();
        System.out.print("Ente com o CPF do nome: ");
        cpf = entrada.nextLine();
        
        for(int i = 0; i < novaContaCorrente.length; i++) {
            /* Cria uma nova conta e um cliente.
             * Verifica se o valor do array é nulo, então aloca.
             */
            if(novaContaCorrente[i] == null) {
                novaContaCorrente[i] = new ContaCorrente(nome, cpf, agencia, numConta, saldo);
                System.out.println("\nCliente cadastrado com sucesso!\n");
                System.out.println("Cliente: " + novaContaCorrente[i].getCliente());
                System.out.println("CPF: " + novaContaCorrente[i].getCpf());
                System.out.println("Agência: " + novaContaCorrente[i].getAgencia() + " | Conta: " + novaContaCorrente[i].getNumConta());
                System.out.println("Saldo: " + novaContaCorrente[i].getSaldo() + "\n");
                break;
            }
        }
        totalContasCorrente++;
    }
    
    private static void novaContaEspecial() {
        Scanner entrada = new Scanner(System.in);
        
        /* Verifica se o tamanho do array é menor que 5 então prossegue.
         * Caso contrário cai retorna Limite de Conta Excedido.
         */
        if(totalContasEspecial >= 5) {
            System.out.println("Limite de Contas Especial excedido!\n");
            return;
        }
        
        // Obtem os dados iniciais do Cliente para Conta Especial
        String nome;
        String cpf;
        float limite;
        
        // Gera um número randomico para a conta
        Random numero = new Random();
        int numConta = 1 + numero.nextInt(99999);

        System.out.println("Cadastrando novo cliente.");
        System.out.print("Ente com o nome do cliente: ");
        nome = entrada.nextLine();
        System.out.print("Ente com o CPF do nome: ");
        cpf = entrada.nextLine();
        System.out.print("Ente com o limite da conta: ");
        limite = entrada.nextFloat();
        
        for(int i = 0; i < novaContaEspecial.length; i++) {
            /* Cria uma nova conta e um cliente.
             * Verifica se o valor do array é nulo, então aloca.
             */
            if(novaContaEspecial[i] == null) {
                novaContaEspecial[i] = new ContaEspecial(nome, cpf, agencia, numConta, limite, saldo);
                System.out.println("\nCliente cadastrado com sucesso!\n");
                System.out.println("Cliente: " + novaContaEspecial[i].getCliente());
                System.out.println("Agência: " + novaContaEspecial[i].getAgencia() + " | Conta: " + novaContaEspecial[i].getNumConta());
                System.out.println("Saldo: " + novaContaEspecial[i].getSaldo());
                System.out.println("Limite: " + novaContaEspecial[i].getLimite() + "\n");
                break;
            }
        }
        totalContasEspecial++;
    }
    
    private static void sacarContaCorrente() {
        Scanner entrada = new Scanner(System.in);
        int numConta;
        int valor = 0;
        
        System.out.print("Ente com o número da conta a ser sacado: ");
        numConta = entrada.nextInt();

        for(int i = 0; i < novaContaCorrente.length; i++) {
            if (novaContaCorrente[i] != null && numConta == novaContaCorrente[i].getNumConta()) {
                System.out.print("Olá, " + novaContaCorrente[i].getCliente() + "\n");
                System.out.print("Ente com o valor a ser sacado: ");
                valor = entrada.nextInt();
                
                novaContaCorrente[i].sacar(valor);
                return;
            }
        }
        
        System.out.print("Desculpe. Conta não encontrada.\n");
    }
    
    private static void sacarContaEspecial() {       
        Scanner entrada = new Scanner(System.in);
        int numConta;
        int valor = 0;
        
        System.out.print("Ente com o número da conta a ser sacado: ");
        numConta = entrada.nextInt();
        
        for(int i = 0; i < novaContaEspecial.length; i++) {
            if (novaContaEspecial[i] != null && numConta == novaContaEspecial[i].getNumConta()) {
                System.out.print("Olá, " + novaContaEspecial[i].getCliente() + "\n");
                System.out.print("Ente com o valor a ser sacado: ");
                valor = entrada.nextInt();
                
                novaContaEspecial[i].sacar(valor);
                return;
            }
        }
        
        System.out.print("Desculpe. Conta não encontrada.\n");
    }
    
    private static void depositarContaCorrente() {       
        Scanner entrada = new Scanner(System.in);
        int numConta;
        int valor = 0;
        
        System.out.print("Ente com o número da conta a ser depositado: ");
        numConta = entrada.nextInt();
        
        for(int i = 0; i < novaContaCorrente.length; i++) {
            if (novaContaCorrente[i] != null && numConta == novaContaCorrente[i].getNumConta()) {
                System.out.print("Ente com o valor a ser depositado: ");
                valor = entrada.nextInt();
                
                novaContaCorrente[i].depositar(valor);
                return;
            }
        }
        
        System.out.print("Desculpe. Conta não encontrada.\n");
    }
    
    private static void depositarContaEspecial() {       
        Scanner entrada = new Scanner(System.in);
        int numConta;
        int valor = 0;
        
        System.out.print("Ente com o número da conta a ser depositado: ");
        numConta = entrada.nextInt();
        
        for(int i = 0; i < novaContaEspecial.length; i++) {
            if (novaContaEspecial[i] != null && numConta == novaContaEspecial[i].getNumConta()) {
                System.out.print("Ente com o valor a ser depositado: ");
                valor = entrada.nextInt();
                
                novaContaEspecial[i].depositar(valor);
                return;
            }
        }
        
        System.out.print("Desculpe. Conta não encontrada.\n");
    }
}
