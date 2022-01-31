package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contrato;
import model.entities.Parcelas;

public class ServicoContrato {
	
	private PagamentoOnline pagamentoOnline;
	
	public ServicoContrato(PagamentoOnline pagamentoOnline) {
		this.pagamentoOnline = pagamentoOnline;
	}
	
	public void contratoProcessado(Contrato contrato, int meses) {
		double parcelaBasica = contrato.getValorTotal() / meses; //pega o valor total e divide pelos meses para saber o valor de cada parcela sem o juros e taxa
		for(int i = 1; i <= meses; i++) {
			double parcelaAtualizadaComJuros = parcelaBasica + pagamentoOnline.juros(parcelaBasica, i);
			double parcelaComJurosMaisTaxa = parcelaAtualizadaComJuros + pagamentoOnline.taxaPagamento(parcelaAtualizadaComJuros);
			Date dataVencimento = addMeses(contrato.getData(), i);
			contrato.getParcelas().add(new Parcelas(dataVencimento, parcelaComJurosMaisTaxa));
			
		}
	}
	
	private Date addMeses(Date data, int N) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		calendar.add(Calendar.MONTH, N);
		return calendar.getTime();
	}

}
