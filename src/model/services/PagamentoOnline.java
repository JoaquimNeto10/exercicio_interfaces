package model.services;

public interface PagamentoOnline {
	
	double taxaPagamento(double valor);
	double juros(double valor, int meses);
}
