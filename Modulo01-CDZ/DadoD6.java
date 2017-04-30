import java.util.Random;

public class DadoD6 implements Sorteador {
    
    public int sortear() {       
        return new Random().nextInt(6) + 1;
    }
}