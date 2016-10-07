package br.com.danielsilva;

import java.text.SimpleDateFormat;
import java.util.Date;
public class ContaPoupanca extends Conta {
	private final double TAXA = 2;
	
	private int diaAniversario;
	public ContaPoupanca(String nome, double saldo, int diaAniversario) {
		super(nome, saldo);
		this.diaAniversario = diaAniversario;
	}

	public int getDiaAniversario() {
		return diaAniversario;
	}

	
	public void setDiaAniversario(int diaAniversario) {
		this.diaAniversario = diaAniversario;
	}

	
	@Override
	public void imprimeExtratoDetalhado() {
		System.out.println("EXTRATO DETALHADO CONTA POUPANCA");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy HH:mm:ss");
		Date agora = new Date();
		
		System.out.println("Data:" + sdf.format(agora));
		System.out.println("Saldo" + this.getSaldo());
		System.out.println("Aniversario:" + this.getDiaAniversario());
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
