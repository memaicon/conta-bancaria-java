package com.app;

public class ContaEspecial extends ContaCorrente {
    
    private float limite;

    // Construtor padrão
    public ContaEspecial() {
    }

    // Construtor
    public ContaEspecial(String nome, String cpf, int agencia, int numConta, float limite, float saldo) {
        this.nome = nome;
        this.cpf = cpf;
        this.agencia = agencia;
        this.numConta = numConta;
        this.limite = limite;
        this.saldo = saldo;
    }

    // Getters & Setters
    public float getLimite() {
        return limite;
    }

    public void setLimite(float limite) {
        this.limite = limite;
    }

    // Métodos
    @Override
    public void depositar(float deposito) {
        // Verifica se o valor é menor ou igual a 0, caso seja não efeta deposito.
        if(deposito <= 0) {
            System.out.println("Não pode ser efetuados depósitos com valor igual ou inferior a 0(zero).\n");
            return;
        }
        
        // Verifica se saldo + o valor do depósito não excede o limite da conta.
        if((saldo + deposito) > getLimite()) {
            System.out.println("O valor ultrapassa o limite da conta.\n");
            return;
        }
                
        saldo = saldo + deposito;
        System.out.println("Deposito de R$" + deposito + " efetuado com sucesso!" + "\nSaldo atual: R$" + getSaldo() + "\n");
    }
}
