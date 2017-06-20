package br.com.crescer.aula01;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Datas {

    private Calendar calendar = Calendar.getInstance();
    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    public void somar() {
        try (final Scanner scanner = new Scanner(System.in)) {
            System.out.println("Digite uma data inicial: ");
            calendar.setTime(format.parse(scanner.nextLine()));
            
            System.out.println("Digite o número de dias a somar nesta data: ");
            calendar.add(Calendar.DATE, Integer.parseInt(scanner.nextLine()));
            
            System.out.println(format.format(calendar.getTime()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
