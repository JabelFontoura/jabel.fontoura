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
            sb.append(e.getNome() + ",");
        
        for(String s : sb.toString().split(","))
            list.add(s);
        
        Collections.sort(list);
        
        for(String s : list)
            System.out.println(s);
    }
}
