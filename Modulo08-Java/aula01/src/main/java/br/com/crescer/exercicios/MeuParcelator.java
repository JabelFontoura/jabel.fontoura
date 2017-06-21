package br.com.crescer.exercicios;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class MeuParcelator implements Parcelator {
	
	private Map<String, BigDecimal> parcelas = new LinkedHashMap<String, BigDecimal>();
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");	
	private Calendar calendar = Calendar.getInstance();

	@Override
	public Map<String, BigDecimal> calcular(BigDecimal valorParcelar, int numeroParcelas, double taxaJuros, Date dataPrimeiroVencimento) {
		calendar.setTime(dataPrimeiroVencimento);
		
		BigDecimal total = valorParcelar.multiply(BigDecimal.valueOf(taxaJuros).divide(BigDecimal.valueOf(100)).add(BigDecimal.ONE));
		
                BigDecimal parcela = total.divide(BigDecimal.valueOf(numeroParcelas), 2, RoundingMode.HALF_UP);
                
                BigDecimal resto = parcela.multiply(BigDecimal.valueOf(numeroParcelas)).subtract(total);
                
		for (int i = 0; i < numeroParcelas; i++) {
			parcelas.put(sdf.format(calendar.getTime()), parcela.subtract(resto));
                        resto = BigDecimal.ZERO;
			calendar.add(Calendar.MONTH, 1);
		}
		
		return parcelas;
	}

}
