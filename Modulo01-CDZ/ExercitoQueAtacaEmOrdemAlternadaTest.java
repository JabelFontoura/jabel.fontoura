import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExercitoQueAtacaEmOrdemAlternadaTest {
    
    @Test
    public void exercitoDeveRetornarEmOrdemAlternadaCom6() throws Exception {
        ExercitoDeSaints impostores = new ExercitoQueAtacaEmOrdemAlternada();
        impostores.alistar(new SilverSaint("Misty", "Lagarto"));
        impostores.alistar(new GoldSaint("Máscara da Morte", "Câncer"));
        impostores.alistar(new BronzeSaint("Ikki", "Fênix"));
        impostores.alistar(new GoldSaint("Saga", "Gêmeos"));
        impostores.alistar(new SilverSaint("Algol", "Perseu"));
        impostores.alistar(new GoldSaint("Afrodite", "Peixes"));
        
        impostores.ordenar();
        
        int i = 0; 
        assertEquals("Ikki", impostores.getLista().todos().get(i++).getNome());
        assertEquals("Misty", impostores.getLista().todos().get(i++).getNome());
        assertEquals("Máscara da Morte", impostores.getLista().todos().get(i++).getNome());
        assertEquals("Algol", impostores.getLista().todos().get(i++).getNome());
        assertEquals("Saga", impostores.getLista().todos().get(i++).getNome());
        assertEquals("Afrodite", impostores.getLista().todos().get(i).getNome());
    }
    
    @Test
    public void exercitoDeveRetornarEmOrdemAlternadaCom9() throws Exception {
        ExercitoDeSaints impostores = new ExercitoQueAtacaEmOrdemAlternada();
        impostores.alistar(new SilverSaint("Misty", "Lagarto"));
        impostores.alistar(new GoldSaint("Máscara da Morte", "Câncer"));
        impostores.alistar(new BronzeSaint("Ikki", "Fênix"));
        impostores.alistar(new GoldSaint("Saga", "Gêmeos"));
        impostores.alistar(new SilverSaint("Algol", "Perseu"));
        impostores.alistar(new GoldSaint("Afrodite", "Peixes"));
        impostores.alistar(new SilverSaint("Saint1", "Gêmeos"));
        impostores.alistar(new GoldSaint("Saint3", "Peixes"));
        impostores.alistar(new SilverSaint("Saint2", "Perseu"));        
        
        impostores.ordenar();
        
        int i = 0; 
        assertEquals("Ikki", impostores.getLista().todos().get(i++).getNome());
        assertEquals("Misty", impostores.getLista().todos().get(i++).getNome());
        assertEquals("Máscara da Morte", impostores.getLista().todos().get(i++).getNome());
        assertEquals("Algol", impostores.getLista().todos().get(i++).getNome());
        assertEquals("Saga", impostores.getLista().todos().get(i++).getNome());
        assertEquals("Saint1", impostores.getLista().todos().get(i++).getNome());
        assertEquals("Afrodite", impostores.getLista().todos().get(i++).getNome());
        assertEquals("Saint2", impostores.getLista().todos().get(i++).getNome());
        assertEquals("Saint3", impostores.getLista().todos().get(i).getNome());
    }
    
    @Test
    public void exercitoComListaVazia() throws Exception {
        ExercitoDeSaints impostores = new ExercitoQueAtacaEmOrdemAlternada();   
        
        impostores.ordenar();
        
        assertTrue(impostores.getLista().todos().isEmpty());
    }
}
