package br.com.crescer.exercicios;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;
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
          calendar.setTime(new Date(this.getHoraZero(new Date()).getTime() - this.getHoraZero(date).getTime()));
          return String.format("%s ano(s), %s messe(s) e %s dia(s)", (calendar.get(YEAR) - 1970), calendar.get(MONTH), calendar.get(DAY_OF_MONTH));
	}
	
	public long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
	    long diffInMillies = date2.getTime() - date1.getTime();
	    return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
	}
    
        private Date getHoraZero(Date date) {
          calendar.setTime(date);
          calendar.set(calendar.get(YEAR), calendar.get(MONTH), calendar.get(DAY_OF_MONTH), 0, 0, 0);
          return calendar.getTime();
    }
}
