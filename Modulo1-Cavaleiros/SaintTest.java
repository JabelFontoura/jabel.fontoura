import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.security.InvalidParameterException;

public class SaintTest {

    @Test
    public void vestirArmaduraDeixaTrue() throws Exception {
        //AAA
        //1. Arrange - Montagem dos dados de teste
        Armadura escorpiao = new Armadura(new Constelacao("Escorpião"), Categoria.OURO);
        Saint milo = new Saint("Milo", escorpiao);

        //2. Act - Invocar a ação a ser testada
        milo.vestirArmadura();

        //3. Assert - Verificação dos resultados do teste
        boolean resultado = milo.isArmaduraVestida();
        assertEquals(true, resultado);
    }

    @Test
    public void naoVestirArmaduraDeixaFalse() throws Exception {
        Saint hyoga = new Saint("Hyoga", new Armadura(new Constelacao("Cisne"), Categoria.BRONZE));
        assertEquals(false, hyoga.isArmaduraVestida());
    }

    @Test
    public void aoCriarSaintGeneroDeveSerNaoInformado() throws Exception {
        Saint shaka = new Saint("Shaka", new Armadura(new Constelacao("Vigem"), Categoria.OURO));
        assertEquals(Genero.NAO_INFORMADO, shaka.getGenero());
    }

    @Test
    public void deveSerPossivelAlterarGenero() throws Exception {
        Saint jabu = new Saint("Jabu", new Armadura(new Constelacao("Unicórnio"), Categoria.BRONZE));

        jabu.setGenero(Genero.MASCULINO);
        assertEquals(Genero.MASCULINO, jabu.getGenero());

        jabu.setGenero(Genero.FEMININO);
        assertEquals(Genero.FEMININO, jabu.getGenero());
    }

    @Test
    public void verificarSeSaintNasceVivo() throws Exception{
        Saint hyoga = new Saint("Hyoga", new Armadura(new Constelacao("Cisne"),Categoria.BRONZE));
        assertEquals(Status.VIVO, hyoga.getStatus());
    }

    @Test
    public void vidaInicialDeveSer100() throws Exception {
        Saint hyoga = new Saint("Hyoga", new Armadura(new Constelacao("Cisne"),Categoria.BRONZE));
        assertEquals(100.0, hyoga.getVida(), 0.01);
    }

    @Test
    public void perderVidaDiminuiVidaInicial() throws Exception {
        Saint hyoga = new Saint("Hyoga", new Armadura(new Constelacao("Cisne"),Categoria.BRONZE));
        double vidaInicial = hyoga.getVida();

        hyoga.perderVida(10);

        assertTrue(vidaInicial > hyoga.getVida());
    }  

    @Test
    public void perderVidaComDano10() throws Exception {
        Saint hyoga = new Saint("Hyoga", new Armadura(new Constelacao("Cisne"),Categoria.BRONZE));
        
        hyoga.perderVida(10);
        
        assertEquals(90, hyoga.getVida(), 0.01);
    }
    
    @Test
    public void perderVidaComDano100() throws Exception {
        Saint hyoga = new Saint("Hyoga", new Armadura(new Constelacao("Cisne"),Categoria.BRONZE));
        
        hyoga.perderVida(100);
        
        assertEquals(0, hyoga.getVida(), 0.01);
    }
    
    @Test
    public void perderVidaComDano1000() throws Exception {
        Saint hyoga = new Saint("Hyoga", new Armadura(new Constelacao("Cisne"),Categoria.BRONZE));
        
        hyoga.perderVida(100);
        
        assertEquals(0, hyoga.getVida(), 0.01);
    }
    
    @Test(expected=InvalidParameterException.class)
    public void perderVidaComDanoNegativoDeveLançarErro() throws Exception {
        Saint hyoga = new Saint("Hyoga", new Armadura(new Constelacao("Cisne"),Categoria.BRONZE));
        
        hyoga.perderVida(-1000);
    }
    
    @Test
    public void naoDeveSerPossivelAlterarStatusSeForMorto() throws Exception{
        Saint hyoga = new Saint("Hyoga", new Armadura(new Constelacao("Cisne"),Categoria.BRONZE));
        
        hyoga.perderVida(100);
        hyoga.perderVida(10);
        
        assertEquals(Status.MORTO, hyoga.getStatus());
        assertEquals(0, hyoga.getVida(), 0.01);
        
    }
    
    @Test
    public void saintIniciaCom5SentidosDespertados() throws Exception {
        BronzeSaint hyoga = new BronzeSaint("Hyoga", new Armadura (new Constelacao("Cisne"),Categoria.BRONZE));
        
        assertEquals(5, hyoga.getqtdSentidosDespertados());
    }
    
    @Test
    public void saintPrataIniciaCom6Sentidos() throws Exception {
        SilverSaint hyoga = new SilverSaint("Hyoga", new Armadura (new Constelacao("Cisne"),Categoria.PRATA));
        
        assertEquals(6, hyoga.getqtdSentidosDespertados());
    }
    
    @Test
    public void sainOuroIniciaCom7Sentidos() throws Exception {
        GoldSaint hyoga = new GoldSaint("Hyoga", new Armadura (new Constelacao("Virgem"),Categoria.OURO));
        
        assertEquals(7, hyoga.getqtdSentidosDespertados());
    }
    
    @Test(expected=Exception.class)
    public void constelacaoInvalidadeDeOuroDeveLancarErro() throws Exception {
        new GoldSaint("Jabel", new Armadura(new Constelacao("Test"), Categoria.OURO));
    }
    
    @Test
    public void verificarSeSaintAprendeGolpe() throws Exception {
         GoldSaint hyoga = new GoldSaint("Hyoga", new Armadura (new Constelacao("Virgem"),Categoria.OURO));
         
         hyoga.aprenderGolpe(new Golpe("Soco", 5));
         
         assertEquals(1, hyoga.getGolpes().size());
    }
    @Test
    public void proximoGolpeDeveSerRealmenteOProximo() throws Exception {
         GoldSaint hyoga = new GoldSaint("Hyoga", new Armadura (new Constelacao("Virgem"),Categoria.OURO));
         Golpe soco = new Golpe("Soco", 5);
         Golpe chute = new Golpe("Chute", 7);
         
         hyoga.aprenderGolpe(soco);             
         assertEquals(soco, hyoga.getProximoGolpe());
         hyoga.aprenderGolpe(chute);
         assertEquals(chute, hyoga.getProximoGolpe());
         
         assertEquals(soco, hyoga.getProximoGolpe());
    }
    
}
