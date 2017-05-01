import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExercitoQueAtacaEmOrdemHierarquicaTest {
   
    @Test
    public void exercitoDeveRetornarEmOrdemHierarquica() throws Exception {
        ExercitoDeSaints defensoresDeAthena = new ExercitoQueAtacaEmOrdemHierarquica();
        defensoresDeAthena.alistar(new GoldSaint("Aiolia", "Leão"));
        defensoresDeAthena.alistar(new BronzeSaint("Hyoga", "Cisne"));
        defensoresDeAthena.alistar(new SilverSaint("Marin", "Águia"));
        defensoresDeAthena.alistar(new BronzeSaint("Seiya", "Pégaso"));
        defensoresDeAthena.alistar(new GoldSaint("Shura", "Capricórnio"));
        defensoresDeAthena.alistar(new BronzeSaint("Shiryu", "Dragão"));
        
        defensoresDeAthena.ordenar();
        
		int i = 0; 
		assertEquals("Hyoga", defensoresDeAthena.getLista().todos().get(i++).getNome());
		assertEquals("Seiya", defensoresDeAthena.getLista().todos().get(i++).getNome());
		assertEquals("Shiryu", defensoresDeAthena.getLista().todos().get(i++).getNome());
		assertEquals("Marin", defensoresDeAthena.getLista().todos().get(i++).getNome());
		assertEquals("Aiolia", defensoresDeAthena.getLista().todos().get(i++).getNome());
		assertEquals("Shura", defensoresDeAthena.getLista().todos().get(i).getNome());
    }

	@Test
    public void exercitoComListaVazia() throws Exception {
        ExercitoDeSaints defensoresDeAthena = new ExercitoQueAtacaEmOrdemHierarquica();

        defensoresDeAthena.ordenar();
		
		assertTrue(defensoresDeAthena.getLista().todos().isEmpty());
	}
}
