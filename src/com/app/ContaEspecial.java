package com.app;

public class ContaEspecial extends ContaCorrente {
    
    private float limite;

    // Construtor padrão
    public ContaEspecial() {
    }

    // Construtor
    public ContaEspecial(String nome, String cpf, int agencia, int numConta, float limite) {
        this.nome = nome;
        this.cpf = cpf;
        this.agencia = agencia;
        this.numConta = numConta;
        this.saldo = 0;
        this.limite = limite;
    }

    // Getters & Setters
    public String getCliente() {
        return nome;
    }

    public void setCliente(String nome) {
        this.nome = nome;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }
    
    public float getLimite() {
        return limite;
    }

    public void setLimite(float limite) {
        this.limite = limite;
    }

    // Métodos 
    public void sacar(int saque) {
        if (saque <= saldo) {
            saldo = saldo - saque;
            System.out.println("Saque de R$" + saque + " efetuado com sucesso!" + "\nSaldo atual: R$" + getSaldo());
        } else {
            System.out.println("Saldo insuficiente" + "\nTente novamente");
        }
    }

    public void depositar(float deposito) {
        saldo = saldo + deposito;
        System.out.println("Deposito de R$" + deposito + " efetuado com sucesso!" + "\nSaldo atual: R$" + getSaldo());
    }

    public void trasferencia(float valor, String favorecido) {
        if (valor <= getSaldo()) {
            saldo = saldo - valor;
            System.out.println("Tranferencia realizado com sucesso!" + "\nNome do favorecido: " + favorecido + "\nSaldo atual: R$" + getSaldo());
        } else {
            System.out.println("Saldo insuficiente." + "\nTente novamente");
        }
    }

    public void consultarSaldo() {
        System.out.println("Seu saldo é de: R$" + this.saldo);
    }
}
