package br.com.crescer.aula01;
 
// @author jabel.fontoura

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

 
public class Main {
    public static void main(String[] args) {
        
        StringBuffer sb = new StringBuffer();
        List<String> list = new ArrayList<String>();
        
        for(Estados e : Estados.values()) 
            list.add(e.getNome());
        
        Collections.sort(list);
        
        for(String s : list)
            sb.append(s + ", ");
        
        System.out.println(sb.toString());
    }
}
