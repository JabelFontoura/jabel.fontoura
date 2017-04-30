import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ContraAtaqueTest {
    
    @Test
    public void acertouContraAtaqueCom40DeVidaSemArmadura() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        
        shiryu.aprenderGolpe(new Golpe("Cólera do Dragão", 10));
        seiya.perderVida(60);
        
        new VestirArmadura(shiryu).executar();
        
        new ContraAtaque(shiryu, seiya, new DadoFalso(1)).executar();
        
        assertEquals(40.0, seiya.getVida(), 0.01);
        assertEquals(75.0, shiryu.getVida(), 0.01);
    }
    
    @Test
    public void acertouContraAtaqueCom40DeVidaSemArmaduraDanoDoProximoGolpeDeveSerZero() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        
        shiryu.aprenderGolpe(new Golpe("Cólera do Dragão", 10));
        seiya.perderVida(60);
        
        new VestirArmadura(shiryu).executar();        
        new ContraAtaque(shiryu, seiya, new DadoFalso(1)).executar();
        new Golpear(shiryu, seiya).executar();        
        
        assertEquals(40.0, seiya.getVida(), 0.01);       
    }
    
    @Test
    public void errouContraAtaqueCom40DeVidaComArmadura() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        
        shiryu.aprenderGolpe(new Golpe("Cólera do Dragão", 10));
        seiya.perderVida(60);
        
        new VestirArmadura(shiryu).executar();
        new VestirArmadura(seiya).executar();
        System.out.println(seiya.isArmaduraVestida());
        
        new ContraAtaque(shiryu, seiya, new DadoFalso(1)).executar();
        
        assertEquals(40.0, seiya.getVida(), 0.01);
        assertEquals(100.0, shiryu.getVida(), 0.01);
    }
    
    @Test
    public void errouContraAtaqueCom100DeVidaSemArmadura() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        
        shiryu.aprenderGolpe(new Golpe("Cólera do Dragão", 10));
        
        new VestirArmadura(shiryu).executar();
        
        new ContraAtaque(shiryu, seiya, new DadoFalso(1)).executar();
        
        assertEquals(100.0, seiya.getVida(), 0.01);
        assertEquals(100.0, shiryu.getVida(), 0.01);
    }
    
    @Test
    public void errouContraAtaqueCom40DeVidaSemArmadura() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pégaso");
        Saint shiryu = new BronzeSaint("Shiryu", "Dragão");
        
        shiryu.aprenderGolpe(new Golpe("Cólera do Dragão", 10));
        seiya.perderVida(60);
        
        new VestirArmadura(shiryu).executar();
        
        new ContraAtaque(shiryu, seiya, new DadoFalso(3)).executar();
        
        assertEquals(40.0, seiya.getVida(), 0.01);
        assertEquals(100.0, shiryu.getVida(), 0.01);
    }
}
