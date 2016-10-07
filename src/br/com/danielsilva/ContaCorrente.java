package br.com.danielsilva;

import java.text.SimpleDateFormat;
import java.util.Date;
public class ContaCorrente extends Conta{
	private final double TAXA = 1;
	public ContaCorrente(String nome, double saldo) {
		super(nome, saldo);
	
	}

	@Override
	public void imprimeExtratoDetalhado() {
		System.out.println("EXTRATO DETALHADO CONTA POUPANCA");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy HH:mm:ss");
		Date agora = new Date();
		
		System.out.println("Data:" + sdf.format(agora));
		System.out.println("Saldo" + this.getSaldo());

	}

	@Override
	public void sacar(double valor) {
       if (valor + TAXA < this.getSaldo()){
    	   this.setSaldo(this.getSaldo() - valor - TAXA);
       }
	}

	@Override
	public void depositar(double valor) {
		if(valor > 0){
			this.setSaldo(this.getSaldo()+valor - TAXA);
		}else{
			System.out.println("nao foi possivel realizar o deposito");
		}	
	}
}
