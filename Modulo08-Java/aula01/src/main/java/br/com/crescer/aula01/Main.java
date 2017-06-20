package br.com.crescer.aula01;
 
// @author jabel.fontoura

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

 
public class Main {
    public static void main(String[] args) {
        
        StringBuffer sb = new StringBuffer();
        List<Estados> list = Arrays.asList(Estados.values());
        Collections.sort(list);
        
        for(Estados e : list)
            sb.append(e.getNome() + ", ");
        
        sb.deleteCharAt(sb.length() - 2);
        
        System.out.println(sb.toString());
    }
}
