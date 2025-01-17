package com.gugawag.rpc.banco;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.gugawag.rpc.banco.model.Conta;

public class BancoServiceServer extends UnicastRemoteObject implements BancoServiceIF {

    private Map<String, Double> saldoContas;

    private List<Conta> contas = new ArrayList<Conta>();
    Random random = new Random();

    public BancoServiceServer() throws RemoteException {
        saldoContas = new HashMap<>();
        saldoContas.put("1", 100.0);
        saldoContas.put("2", 156.0);
        saldoContas.put("3", 950.0);
    }

    @Override
    public double saldo(String conta) throws RemoteException {
        return saldoContas.get(conta);
    }

    @Override
    public int quantidadeContas() throws RemoteException {
        return saldoContas.size();

    }

    @Override
    public void adicionarConta() throws RemoteException {
        int numero = random.nextInt(9);
        Conta conta = new Conta(String.valueOf(numero), 0.0);
        contas.add(conta);

    }

    @Override
    public void removerConta(String numero) throws RemoteException {
        saldoContas.remove(numero);

    }

}