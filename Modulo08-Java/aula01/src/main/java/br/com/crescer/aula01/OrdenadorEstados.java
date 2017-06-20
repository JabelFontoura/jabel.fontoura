package br.com.crescer.aula01;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OrdenadorEstados {
    
    private StringBuffer sb = new StringBuffer();
    private List<Estados> list = Arrays.asList(Estados.values());
    
    public void ordenar() {
        Collections.sort(list);

        for(Estados e : list)
            sb.append(e.getNome() + ", ");

        sb.deleteCharAt(sb.length() - 2);

        System.out.println(sb.toString());
        }
}
