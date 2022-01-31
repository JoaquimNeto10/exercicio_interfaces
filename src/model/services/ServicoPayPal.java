package model.services;

public class ServicoPayPal implements PagamentoOnline {
	
	public static final double TAXA_PAGAMENTO = 0.02;
	public static final double JUROS_MENSAL = 0.01;

	@Override
	public double taxaPagamento(double valor) {
		return valor * TAXA_PAGAMENTO;
	}

	@Override
	public double juros(double valor, int meses) {
		return valor * meses * JUROS_MENSAL;
	}

}
