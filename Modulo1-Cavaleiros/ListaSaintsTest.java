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
    public void buscarSaintPorCategoriaBronzeDeveRetornarListaDeSaintsCerto() throws Exception {
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
    public void getSaintMenorVidaDeFatoRetornaOComMenorVida() throws Exception {
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
            System.out.println(lista.get(i).getVida());
            assertTrue(lista.get(i).getVida() <= lista.get(i + 1).getVida()); 
        }
    }
    
}
