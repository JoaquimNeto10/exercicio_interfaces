package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Parcelas {
	
	private Date dataVencimento;
	private Double qtdParcelas;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Parcelas() {}
	
	public Parcelas(Date dataVencimento, Double qtdParcelas) {
		this.dataVencimento = dataVencimento;
		this.qtdParcelas = qtdParcelas;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Double getQtdParcelas() {
		return qtdParcelas;
	}

	public void setQtdParcelas(Double qtdParcelas) {
		this.qtdParcelas = qtdParcelas;
	}
	
	@Override
	public String toString() {
		return sdf.format(dataVencimento) + " - " + String.format("%.2f", qtdParcelas);
 	}
}
