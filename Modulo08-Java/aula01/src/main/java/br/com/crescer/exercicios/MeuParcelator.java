package br.com.crescer.exercicios;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MeuParcelator implements Parcelator {
	
	private Map<String, BigDecimal> parcelas = new HashMap<String, BigDecimal>();
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");	
	private Calendar calendar = Calendar.getInstance();

	@Override
	public Map<String, BigDecimal> calcular(BigDecimal valorParcelar, int numeroParcelas, double taxaJuros, Date dataPrimeiroVencimento) {
		calendar.setTime(dataPrimeiroVencimento);
		
		BigDecimal valor = new BigDecimal((valorParcelar.floatValue() * (1 + taxaJuros / 100)) / numeroParcelas);
		
		for (int i = 0; i < numeroParcelas; i++) {
			parcelas.put(sdf.format(calendar.getTime()), valor);
			calendar.add(Calendar.MONTH, 1);
		}
		
		return parcelas;
	}

}
