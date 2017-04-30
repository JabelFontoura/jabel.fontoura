import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GolpearComDanoDuploTest {
    
    @Test
    public void acertouAtaqueDuploDeveDarDobroDoDanoComArmaduraVestida() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        
        shiryu.aprenderGolpe(new Golpe("Cólera do Dragão", 10));
        
        new VestirArmadura(shiryu).executar();
        new GolpearComDanoDuplo(shiryu, seiya, new DadoFalso(3)).executar();
            
        assertEquals(60.0, seiya.getVida(), 0.01);
    }
    
    @Test
    public void acertarGolpeSemArmaduraVestida() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint shiryu = new SilverSaint("Shiryu", "Virgem");
        
        shiryu.aprenderGolpe(new Golpe("Cólera do Dragão", 10));
        
        new GolpearComDanoDuplo(shiryu, seiya, new DadoFalso(3)).executar();
        
        assertEquals(80.0, seiya.getVida(), 0.01);      
    }
    
    @Test
    public void errarGolpeComArmaduraVestidaDeveDarDanoNormalEPerderVida() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        
        shiryu.aprenderGolpe(new Golpe("Cólera do Dragão", 10));
        
        new VestirArmadura(shiryu).executar();
        new GolpearComDanoDuplo(shiryu, seiya, new DadoFalso(1)).executar();
            
        assertEquals(80.0, seiya.getVida(), 0.01);
        assertEquals(95.0, shiryu.getVida(), 0.01);
    }
    
    @Test
    public void errarGolpeSemArmaduraVestida() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint shiryu = new SilverSaint("Shiryu", "Virgem");
        
        shiryu.aprenderGolpe(new Golpe("Cólera do Dragão", 10));
        
        new GolpearComDanoDuplo(shiryu, seiya, new DadoFalso(1)).executar();
        
        assertEquals(90.0, seiya.getVida(), 0.01);
        assertEquals(95.0, shiryu.getVida(), 0.01);
    }
    
    
}
