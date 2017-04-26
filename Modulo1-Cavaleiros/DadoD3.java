import java.util.Random;

public class DadoD3 implements Sorteador {
    
    public int sortear() {
        return new Random().nextInt(3) + 1;
    }
}