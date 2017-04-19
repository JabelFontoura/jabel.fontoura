import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;

public class ListaSaintsTest {
    
    @Test
    public void saintDeveSerAdicionandoNaLista() throws Exception {
        Saint seiya = new Saint("Seiya", new Armadura(new Constelacao("Pegaso"), Categoria.BRONZE));
        ListaSaints lista = new ListaSaints();
        
        lista.adicionar(seiya);
        
        assertEquals(lista.get(0), seiya);  
    }
    
    @Test
    public void buscarNomeRetornarSaintCerto() throws Exception {
        Saint seiya = new Saint("Seiya", new Armadura(new Constelacao("Pegaso"), Categoria.BRONZE));
        ListaSaints lista = new ListaSaints();
        
        lista.adicionar(seiya);
        
        assertEquals(seiya, lista.buscarPorNome("Seiya"));
    }
    
    @Test
    public void buscarNomeExistenteComRepeticao() throws Exception {
        Saint seiya = new Saint("Seiya", new Armadura(new Constelacao("Pegaso"), Categoria.BRONZE));
        Saint seiya2 = new Saint("Seiya", new Armadura(new Constelacao("Pegaso"), Categoria.BRONZE));
        ListaSaints lista = new ListaSaints();
        
        lista.adicionar(seiya);
        lista.adicionar(seiya2);
        
        assertEquals(seiya, lista.buscarPorNome("Seiya"));
    }
    
    @Test
    public void buscarNomeInexistente() throws Exception {
        Saint seiya = new Saint("Seiya", new Armadura(new Constelacao("Pegaso"), Categoria.BRONZE));
        Saint seiya2 = new Saint("Seiya", new Armadura(new Constelacao("Pegaso"), Categoria.BRONZE));
        ListaSaints lista = new ListaSaints();
        
        lista.adicionar(seiya);
        lista.adicionar(seiya2);
        
        assertNull(lista.buscarPorNome("Um nome que não existe"));
    }
    
    @Test
    public void buscarNomeComListaVazia() {
        assertNull(new ListaSaints().buscarPorNome("Um nome que não existe"));
    }
    
    @Test
    public void buscarSaintPorCategoriaDeveRetornarListaDeSaintsCerto() throws Exception {
        Saint seiya = new Saint("Seiya", new Armadura(new Constelacao("Pegaso"), Categoria.BRONZE));
        ListaSaints lista = new ListaSaints();
        Saint marin = new Saint("Marin", new Armadura(new Constelacao("Aguia"), Categoria.PRATA));
        
        lista.adicionar(seiya);
        lista.adicionar(marin);
        
        List<Saint> listaCategoria = new ArrayList<Saint>();
        
        listaCategoria.add(seiya);
        
        assertEquals(listaCategoria, lista.buscarPorCategoria(Categoria.BRONZE));
    }
     
    
    @Test
    public void buscarSaintPorCategoriaListaVazia() throws Exception {
        List<Saint> listaCategoria = new ArrayList<Saint>();
        
        assertEquals(listaCategoria, new ListaSaints().buscarPorCategoria(Categoria.OURO));
    }
    
    @Test
    public void buscarPorCategoriaInexistente() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        listaSaints.adicionar(june);
        List<Saint> resultadoBusca = listaSaints.buscarPorCategoria(Categoria.PRATA);
        assertEquals(new ArrayList<Saint>(), resultadoBusca);
    }
    
    @Test
    public void buscarPorCategoriaComMaisDeUmExistenteNaCategoria() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        Saint misty = new SilverSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));
        Saint shun = new Saint("June", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE));
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        List<Saint> resultadoBusca = listaSaints.buscarPorCategoria(Categoria.BRONZE);
        assertEquals(shun, resultadoBusca.get(0));
        assertEquals(june, resultadoBusca.get(1));
        assertEquals(2, resultadoBusca.size());
    }
    
    @Test
    public void buscarSaintPorStatusDeveRetornarListaDeSaintsCerto() throws Exception {
        Saint seiya = new Saint("Seiya", new Armadura(new Constelacao("Pegaso"), Categoria.BRONZE));
        ListaSaints lista = new ListaSaints();
        Saint marin = new Saint("Marin", new Armadura(new Constelacao("Aguia"), Categoria.PRATA));
        
        lista.adicionar(seiya);
        lista.adicionar(marin);
        
        List<Saint> listaStatus = new ArrayList<Saint>();
        
        listaStatus.add(seiya);
        listaStatus.add(marin);
        
        assertEquals(listaStatus, lista.buscarPorStatus(Status.VIVO));
    }
    
    @Test
    public void buscarPorStatusListaVazia() {
        ListaSaints listaSaints = new ListaSaints();
        List<Saint> resultadoBusca = listaSaints.buscarPorStatus(Status.VIVO);
        assertEquals(new ArrayList<Saint>(), resultadoBusca);
    }

    @Test
    public void buscarPorStatusInexistente() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        listaSaints.adicionar(june);
        List<Saint> resultadoBusca = listaSaints.buscarPorStatus(Status.MORTO);
        assertEquals(new ArrayList<Saint>(), resultadoBusca);
    }
    
    @Test
    public void buscarPorStatusComMaisDeUmExistenteNaCategoria() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new Saint("June", new Armadura(new Constelacao("Camaleão"), Categoria.BRONZE));
        Saint misty = new SilverSaint("Misty", new Armadura(new Constelacao("Lagarto"), Categoria.PRATA));
        Saint shun = new Saint("June", new Armadura(new Constelacao("Andrômeda"), Categoria.BRONZE));
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        shun.perderVida(100);
        june.perderVida(100);
        List<Saint> resultadoBusca = listaSaints.buscarPorStatus(Status.MORTO);
        assertEquals(shun, resultadoBusca.get(0));
        assertEquals(june, resultadoBusca.get(1));
        assertEquals(2, resultadoBusca.size());
    }
    
    @Test
    public void getSaintMenorVidaDeFatoRetornaOPrimeiroComMenorVida() throws Exception {
        ListaSaints lista = new ListaSaints();
        Saint seiya = new Saint("Seiya", new Armadura(new Constelacao("Pegaso"), Categoria.BRONZE));
        Saint marin = new Saint("Marin", new Armadura(new Constelacao("Aguia"), Categoria.PRATA));
        Saint saint1 = new Saint("Seiya", new Armadura(new Constelacao("Pegaso"), Categoria.BRONZE));
        Saint saint2 = new Saint("Seiya", new Armadura(new Constelacao("Pegaso"), Categoria.BRONZE));
        Saint saint3 = new Saint("Seiya", new Armadura(new Constelacao("Pegaso"), Categoria.BRONZE));
        
        marin.perderVida(90);
        saint1.perderVida(10);
        saint2.perderVida(40);
        
        lista.adicionar(seiya);
        lista.adicionar(marin);
        lista.adicionar(saint1);
        lista.adicionar(saint2);
        lista.adicionar(saint3);
        
        assertEquals(marin, lista.getSaintMenorVida());       
    }
    
    @Test
    public void getSaintMaiorVidaComApenasUm() throws Exception {
        ListaSaints lista = new ListaSaints();
        Saint seiya = new Saint("Seiya", new Armadura(new Constelacao("Pegaso"), Categoria.BRONZE));
        
        lista.adicionar(seiya);
        
        assertEquals(seiya, lista.getSaintMaiorVida());
    }
    
    
    @Test
    public void getSaintMaiorVidaDeFatoRetornaOPrimeiroComMaiorVida() throws Exception {
        ListaSaints lista = new ListaSaints();
        Saint seiya = new Saint("Seiya", new Armadura(new Constelacao("Pegaso"), Categoria.BRONZE));
        Saint marin = new Saint("Marin", new Armadura(new Constelacao("Aguia"), Categoria.PRATA));
        Saint saint1 = new Saint("Seiya", new Armadura(new Constelacao("Pegaso"), Categoria.BRONZE));
        Saint saint2 = new Saint("Seiya", new Armadura(new Constelacao("Pegaso"), Categoria.BRONZE));
        Saint saint3 = new Saint("Seiya", new Armadura(new Constelacao("Pegaso"), Categoria.BRONZE));
        
        marin.perderVida(90);
        saint1.perderVida(10);
        saint2.perderVida(40);
        
        lista.adicionar(seiya);
        lista.adicionar(marin);
        lista.adicionar(saint1);
        lista.adicionar(saint2);
        lista.adicionar(saint3);
        
        assertEquals(seiya, lista.getSaintMaiorVida());       
    }
    
    @Test
    public void getSaintMaiorVidaComListaVazia() throws Exception {
        assertNull(new ListaSaints().getSaintMaiorVida());
    }
    
    @Test
    public void ordernarDeveSerAscendente() throws Exception {
        ListaSaints lista = new ListaSaints();
        Saint seiya = new Saint("Seiya", new Armadura(new Constelacao("Pegaso"), Categoria.BRONZE));
        Saint marin = new Saint("Marin", new Armadura(new Constelacao("Aguia"), Categoria.PRATA));
        Saint saint1 = new Saint("Seiya", new Armadura(new Constelacao("Pegaso"), Categoria.BRONZE));
        Saint saint2 = new Saint("Seiya", new Armadura(new Constelacao("Pegaso"), Categoria.BRONZE));
        Saint saint3 = new Saint("Seiya", new Armadura(new Constelacao("Pegaso"), Categoria.BRONZE));
        
        marin.perderVida(90);
        saint1.perderVida(10);
        saint2.perderVida(40);
        
        lista.adicionar(seiya);
        lista.adicionar(marin);
        lista.adicionar(saint1);
        lista.adicionar(saint2);
        lista.adicionar(saint3);
        
        lista.ordenar();
        
        for(int i = 0; i < lista.todos().size() - 1; i++) { 
            assertTrue(lista.get(i).getVida() <= lista.get(i + 1).getVida()); 
        }
    }
    
}
