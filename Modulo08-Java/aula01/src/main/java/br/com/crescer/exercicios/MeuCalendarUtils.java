package br.com.crescer.exercicios;

import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MeuCalendarUtils implements CalendarUtils {
	
	private Calendar calendar = Calendar.getInstance();
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@Override
	public DiaSemana diaSemana(Date date) {
		calendar.setTime(date);
		return DiaSemana.values()[calendar.get(Calendar.DAY_OF_WEEK) - 1];
	}

	@Override
	public String tempoDecorrido(Date date) {
		calendar.setTime(date);
		
		int duracao = (int)getDateDiff(calendar.getTime(), Calendar.getInstance().getTime(), TimeUnit.DAYS);
		
		int anos = duracao / 365;
		duracao -= 365 * anos;
		
		int meses = (int) (duracao / 30.41);
		duracao -= 30.41 * meses;
		
		int dias = duracao;
		
		return String.format("%1s ano(s), %2s mês(es) e %3s dia(s)", anos, meses, dias);
	}
	
	public long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
	    long diffInMillies = date2.getTime() - date1.getTime();
	    return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
	}

}
