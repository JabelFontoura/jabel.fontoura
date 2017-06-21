import br.com.crescer.exercicios.MeuStringUtils;
import static org.junit.Assert.*;

import org.junit.Test;

public class MeuStringUtilsTest {

	@Test
	public void isEmptyComStringVazia() {
		assertTrue(new MeuStringUtils().isEmpty(""));
	}
	
	@Test
	public void isEmptyComStringNull() {
		assertTrue(new MeuStringUtils().isEmpty(null));
	}
	
	@Test
	public void isEmptyComStringPreenchida() {
		assertFalse(new MeuStringUtils().isEmpty("String"));
	}
	
	@Test
	public void inverterComUmaPalavra() {
		assertEquals("lebaj", new MeuStringUtils().inverter("jabel"));
	}
	
	@Test
	public void inverterComEspaco() {
		assertEquals("aruotnof lebaj", new MeuStringUtils().inverter("jabel fontoura"));
	}
	
	@Test(expected = NullPointerException.class)
	public void inverterComNull() {
		assertEquals(null, new MeuStringUtils().inverter(null));
	}
	
	@Test
	public void contaVogaisCom6() {
		assertEquals(6, new MeuStringUtils().contaVogais("jabel fontoura"));
	}
	
	@Test
	public void contaVogaisCom0() {
		assertEquals(0, new MeuStringUtils().contaVogais("wwww"));
	}
	
	@Test
	public void contaVogaisCom1ComAcento() {
		assertEquals(1, new MeuStringUtils().contaVogais("á"));
	}
	
	@Test
	public void contaVogaisCom2ComCaps() {
		assertEquals(2, new MeuStringUtils().contaVogais("AO"));
	}
	
	@Test
	public void isPalidromeComUmaPalavra() {
		assertTrue(new MeuStringUtils().isPalindromo("ovo"));
	}
	
	@Test
	public void isPalidromeComFrase() {
		assertTrue(new MeuStringUtils().isPalindromo("Ame a ema"));
	}
	
	@Test
	public void isPalidromeComFraseEAcento() {
		assertTrue(new MeuStringUtils().isPalindromo("A sogra má e amargosa"));
	}
	
	@Test
	public void isPalidromeComEmpty() {
		assertTrue(new MeuStringUtils().isPalindromo(""));
	}
	
	@Test
	public void isPalidromeComFalso() {
		assertFalse(new MeuStringUtils().isPalindromo("lasjuwiv iy  wyi"));
	}
}
