package br.com.crescer.exercicios;

import java.text.Normalizer;

public class MeuStringUtils implements StringUtils {
  
  @Override
  public boolean isEmpty(String string) {
    return string == null || string.trim().isEmpty();
  }
  
  @Override
  public String inverter(String string) {
    return new StringBuilder(string).reverse().toString();
  }
  
  @Override
  public int contaVogais(String string) {
    return isEmpty(string) ? 0 : string.length() - Normalizer
            .normalize(string, Normalizer.Form.NFD)
            .replaceAll("[\\p{InCombiningDiacriticalMarks}]", "")
            .replaceAll("[aeiouAEIOU]", "")
            .length();
  }
  
  @Override
  public boolean isPalindromo(String string) {
    string = Normalizer
            .normalize(string, Normalizer.Form.NFD)
            .toLowerCase().replaceAll(" ", "")
            .replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
    
    int n = string.length();
    for( int i = 0; i < n / 2; i++ )
      if (string.charAt(i) != string.charAt(n - i - 1)) return false;
    return true;
  }
  
}
