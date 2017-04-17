import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SaintTest {
    
    @Test
    public void vestirArmaduraDeixaTrue() {
        //AAA
        //1. Arrange - Montagem dos dados de teste
        Armadura escorpiao = new Armadura("Escorpião", Categoria.OURO);
        Saint milo = new Saint("Milo", escorpiao);
        
        //2. Act - Invocar a ação a ser testada
        milo.vestirArmadura();
        
        //3. Assert - Verificação dos resultados do teste
        boolean resultado = milo.isArmaduraVestida();
        assertEquals(true, resultado);
    }
    
    @Test
    public void naoVestirArmaduraDeixaFalse() {
        Saint hyoga = new Saint("Hyoga", new Armadura("Cisne", Categoria.BRONZE));
        assertEquals(false, hyoga.isArmaduraVestida());
    }
    
    @Test
    public void aoCriarSaintGeneroDeveSerNaoInformado() {
        Saint shaka = new Saint("Shaka", new Armadura("Vigem", Categoria.OURO));
        assertEquals(Genero.NAO_INFORMADO, shaka.getGenero());
    }
    
    @Test
    public void deveSerPossivelAlterarGenero() {
        Saint jabu = new Saint("Jabu", new Armadura("Unicórnio", Categoria.BRONZE));
        
        jabu.setGenero(Genero.MASCULINO);
        assertEquals(Genero.MASCULINO, jabu.getGenero());
        
        jabu.setGenero(Genero.FEMININO);
        assertEquals(Genero.FEMININO, jabu.getGenero());
    }
    
   @Test
    public void verificarSeSaintNasceVivo(){
        Saint hyoga = new Saint("Hyoga", new Armadura ("Cisne",Categoria.BRONZE));
        assertEquals(Status.VIVO, hyoga.getStatus());
    }
    
  @Test
  public void perderVidaDiminuiVidaInicial() {
      Saint hyoga = new Saint("Hyoga", new Armadura ("Cisne",Categoria.BRONZE));
      double vidaInicial = hyoga.getVida();
      
      hyoga.perderVida(10);
      
      assertTrue(vidaInicial > hyoga.getVida());
    }  
}
