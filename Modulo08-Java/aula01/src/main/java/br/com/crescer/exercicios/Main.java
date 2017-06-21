package br.com.crescer.exercicios;

import java.math.BigDecimal;
import java.util.Date;

public class Main {
	
	public static void main(String[] args) {
		System.out.println(new MeuParcelator().calcular(new BigDecimal(1000), 10, 10, new Date("06/30/2016")));
	}

}
