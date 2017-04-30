import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConstelacaoTest {
    
    @Test
    public void adicionarUmGolpe() {
        Constelacao gemeos = new Constelacao("Gêmeos");
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        gemeos.adicionarGolpe(outraDimensao);
        
        assertEquals(outraDimensao, gemeos.getGolpes().get(0));
    }
    
    @Test
    public void adicionarDoisGolpe() {
        Constelacao gemeos = new Constelacao("Gêmeos");
        Golpe outraDimensao = new Golpe("Outra dimensão", 10);
        Golpe explosaoGalatica = new Golpe("Explosão Galática", 11);
        
        gemeos.adicionarGolpe(outraDimensao);
        gemeos.adicionarGolpe(explosaoGalatica);
        
        assertEquals(outraDimensao, gemeos.getGolpes().get(0));
        assertEquals(explosaoGalatica, gemeos.getGolpes().get(1));
    }
}
