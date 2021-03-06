import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;

public class ListaSaintsTest {
    
    @Test
    public void saintDeveSerAdicionandoNaLista() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pegaso");
        ListaSaints lista = new ListaSaints();
        
        lista.adicionar(seiya);
        
        assertEquals(lista.get(0), seiya);  
    }
    
    @Test
    public void buscarNomeRetornarSaintCerto() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pegaso");
        ListaSaints lista = new ListaSaints();
        
        lista.adicionar(seiya);
        
        assertEquals(seiya, lista.buscarPorNome("Seiya"));
    }
    
    @Test
    public void buscarNomeExistenteComRepeticao() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pegaso");
        Saint seiya2 = new BronzeSaint("Seiya", "Pegaso");
        ListaSaints lista = new ListaSaints();
        
        lista.adicionar(seiya);
        lista.adicionar(seiya2);
        
        assertEquals(seiya, lista.buscarPorNome("Seiya"));
    }
    
    @Test
    public void buscarNomeInexistente() throws Exception {
        Saint seiya = new BronzeSaint("Seiya", "Pegaso");
        Saint seiya2 = new BronzeSaint("Seiya", "Pegaso");
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
        Saint seiya = new BronzeSaint("Seiya", "Pegaso");
        ListaSaints lista = new ListaSaints();
        Saint marin = new SilverSaint("Marin", "Aguia");
        
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
        Saint june = new BronzeSaint("June", "Camaleão");
        listaSaints.adicionar(june);
        List<Saint> resultadoBusca = listaSaints.buscarPorCategoria(Categoria.PRATA);
        assertEquals(new ArrayList<Saint>(), resultadoBusca);
    }
    
    @Test
    public void buscarPorCategoriaComMaisDeUmExistenteNaCategoria() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("June", "Andrômeda");
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
        Saint seiya = new BronzeSaint("Seiya", "Pegaso");
        ListaSaints lista = new ListaSaints();
        Saint marin = new SilverSaint("Marin", "Aguia");
        
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
        Saint june = new BronzeSaint("June", "Camaleão");
        listaSaints.adicionar(june);
        List<Saint> resultadoBusca = listaSaints.buscarPorStatus(Status.MORTO);
        assertEquals(new ArrayList<Saint>(), resultadoBusca);
    }
    
    @Test
    public void buscarPorStatusComMaisDeUmExistenteNaCategoria() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("June", "Andrômeda");
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
    public void getSaintMenorVidaComApenasUm() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        listaSaints.adicionar(june);
        assertEquals(june, listaSaints.getSaintMenorVida());
    }
    
    @Test
    public void getSaintMenorVidaDeFatoRetornaOPrimeiroComMenorVida() throws Exception {
        ListaSaints lista = new ListaSaints();
        Saint seiya = new BronzeSaint("Seiya", "Pegaso");
        Saint marin = new SilverSaint("Marin", "Aguia");
        Saint saint1 = new BronzeSaint("Seiya", "Pegaso");
        Saint saint2 = new BronzeSaint("Seiya", "Pegaso");
        Saint saint3 = new BronzeSaint("Seiya", "Pegaso");
        
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
    public void getSaintMenorVidaComListaVazia() {
        ListaSaints listaSaints = new ListaSaints();
        Saint menorVida = listaSaints.getSaintMenorVida();
        assertNull(menorVida);
    }
    
    @Test
    public void getSaintMaiorVidaComApenasUm() throws Exception {
        ListaSaints lista = new ListaSaints();
        Saint seiya = new BronzeSaint("Seiya", "Pegaso");
        
        lista.adicionar(seiya);
        
        assertEquals(seiya, lista.getSaintMaiorVida());
    }
    
    
    @Test
    public void getSaintMaiorVidaDeFatoRetornaOPrimeiroComMaiorVida() throws Exception {
        ListaSaints lista = new ListaSaints();
        Saint seiya = new BronzeSaint("Seiya", "Pegaso");
        Saint marin = new SilverSaint("Marin", "Aguia");
        Saint saint1 = new BronzeSaint("Seiya", "Pegaso");
        Saint saint2 = new BronzeSaint("Seiya", "Pegaso");
        Saint saint3 = new BronzeSaint("Seiya", "Pegaso");
        
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
        Saint seiya = new BronzeSaint("Seiya", "Pegaso");
        Saint marin = new SilverSaint("Marin", "Aguia");
        Saint saint1 = new BronzeSaint("Seiya", "Pegaso");
        Saint saint2 = new BronzeSaint("Seiya", "Pegaso");
        Saint saint3 = new BronzeSaint("Seiya", "Pegaso");
        
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
    
    @Test
    public void ordernarComTipoDescendente() throws Exception {
        ListaSaints lista = new ListaSaints();
        Saint seiya = new BronzeSaint("Seiya", "Pegaso");
        Saint marin = new SilverSaint("Marin", "Aguia");
        Saint saint1 = new BronzeSaint("Seiya", "Pegaso");
        Saint saint2 = new BronzeSaint("Seiya", "Pegaso");
        Saint saint3 = new BronzeSaint("Seiya", "Pegaso");
        
        marin.perderVida(90);
        saint1.perderVida(10);
        saint2.perderVida(40);
        
        lista.adicionar(seiya);
        lista.adicionar(marin);
        lista.adicionar(saint1);
        lista.adicionar(saint2);
        lista.adicionar(saint3);
        
        lista.ordenar(TipoOrdenacao.DESCENDENTE);
        
        for(int i = 0; i < lista.todos().size() - 1; i++) { 
            assertTrue(lista.get(i).getVida() >= lista.get(i + 1).getVida()); 
        }
    }
    
    @Test
    public void ordenarComListaTotalmenteDesordenada() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        shun.perderVida(10);
        misty.perderVida(20);
        june.perderVida(30);
        listaSaints.ordenar();
        List<Saint> resultado = listaSaints.todos();
        assertEquals(june, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(shun, resultado.get(2));
    }
    
    @Test
    public void ordenarComListaTotalmenteOrdenada() throws Exception {
        ListaSaints listaSaints = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        Saint misty = new SilverSaint("Misty", "Lagarto");
        Saint shun = new BronzeSaint("Shun", "Andrômeda");
        listaSaints.adicionar(shun);
        listaSaints.adicionar(misty);
        listaSaints.adicionar(june);
        shun.perderVida(30);
        misty.perderVida(20);
        june.perderVida(10);
        listaSaints.ordenar();
        List<Saint> resultado = listaSaints.todos();
        assertEquals(shun, resultado.get(0));
        assertEquals(misty, resultado.get(1));
        assertEquals(june, resultado.get(2));
    }
    
    @Test
    public void unirAdicionaNovaListaNaLista() throws Exception {
        ListaSaints lista = new ListaSaints();
        ListaSaints novaLista = new ListaSaints();
        ListaSaints listaCompleta = new ListaSaints();
        
        Saint seiya = new BronzeSaint("Seiya", "Pegaso");
        Saint marin = new SilverSaint("Marin", "Aguia");
        Saint saint1 = new BronzeSaint("Seiya", "Pegaso");
        Saint saint2 = new BronzeSaint("Seiya", "Pegaso");
        Saint saint3 = new BronzeSaint("Seiya", "Pegaso");
        
        listaCompleta.adicionar(seiya);
        listaCompleta.adicionar(marin);
        listaCompleta.adicionar(saint1);
        listaCompleta.adicionar(saint2);
        listaCompleta.adicionar(saint3);
        
        lista.adicionar(seiya);
        lista.adicionar(marin);
        
        novaLista.adicionar(saint1);
        novaLista.adicionar(saint2);
        novaLista.adicionar(saint3);
        
        ListaSaints resultado = lista.unir(novaLista);
        
        assertTrue(resultado.todos().containsAll(listaCompleta.todos()));
        assertEquals(listaCompleta.todos().size(), resultado.todos().size());       
    }
    
    @Test
    public void unirAdicionaNovaListaVazia() throws Exception {
        ListaSaints lista = new ListaSaints();
        ListaSaints novaLista = new ListaSaints();
        ListaSaints listaCompleta = new ListaSaints();
        
        Saint seiya = new BronzeSaint("Seiya", "Pegaso");
        Saint marin = new SilverSaint("Marin", "Aguia");
        
        listaCompleta.adicionar(seiya);
        listaCompleta.adicionar(marin);
        
        lista.adicionar(seiya);
        lista.adicionar(marin);
        
        ListaSaints resultado = lista.unir(novaLista);
        
        assertTrue(resultado.todos().containsAll(listaCompleta.todos()));
        assertEquals(listaCompleta.todos().size(), resultado.todos().size());    
    }
    
    
    @Test
    public void diffRetornaListaCerta() throws Exception {
        ListaSaints lista = new ListaSaints();
        ListaSaints novaLista = new ListaSaints();
        ListaSaints listaDiff = new ListaSaints();
        
        Saint seiya = new BronzeSaint("Seiya", "Pegaso");
        Saint marin = new SilverSaint("Marin", "Aguia");
        Saint saint1 = new BronzeSaint("Seiya", "Pegaso");
        Saint saint2 = new BronzeSaint("Seiya", "Pegaso");
        Saint saint3 = new BronzeSaint("Seiya", "Pegaso");
        
        lista.adicionar(seiya);
        lista.adicionar(marin);
        lista.adicionar(saint1);
        
        novaLista.adicionar(saint1);
        novaLista.adicionar(saint2);
        novaLista.adicionar(saint3);
        
        listaDiff.adicionar(seiya);
        listaDiff.adicionar(marin);
        listaDiff.adicionar(saint2);
        listaDiff.adicionar(saint3);
        
        ListaSaints resultado = lista.diff(novaLista);
        
        assertTrue(resultado.todos().containsAll(listaDiff.todos()));
        assertEquals(listaDiff.todos().size(), resultado.todos().size()); 
    }
    
    @Test
    public void interscComValoresUnicos() throws Exception {
        ListaSaints lista = new ListaSaints();
        ListaSaints novaLista = new ListaSaints();
        ListaSaints listaInterSec = new ListaSaints();
        
        Saint seiya = new BronzeSaint("Seiya", "Pegaso");
        Saint marin = new SilverSaint("Marin", "Aguia");
        Saint saint1 = new BronzeSaint("Seiya", "Pegaso");
        Saint saint2 = new BronzeSaint("Seiya", "Pegaso");
        Saint saint3 = new BronzeSaint("Seiya", "Pegaso");
        
        lista.adicionar(seiya);
        lista.adicionar(marin);
        lista.adicionar(saint1);
        lista.adicionar(saint2);
        
        novaLista.adicionar(saint1);
        novaLista.adicionar(saint2);
        novaLista.adicionar(saint3);
        
        
        listaInterSec.adicionar(saint1);
        listaInterSec.adicionar(saint2);
        
        ListaSaints resultado = lista.intersec(novaLista);    
        
        assertTrue(resultado.todos().containsAll(listaInterSec.todos()));
        assertEquals(listaInterSec.todos().size(), resultado.todos().size()); 
    }
    
    @Test
    public void intersecComValoresRepetidos() throws Exception {
        ListaSaints lista = new ListaSaints();
        ListaSaints novaLista = new ListaSaints();
        ListaSaints listaInterSec = new ListaSaints();
        
        Saint seiya = new BronzeSaint("Seiya", "Pegaso");
        Saint marin = new SilverSaint("Marin", "Aguia");
        Saint saint1 = new BronzeSaint("Seiya", "Pegaso");
        Saint saint2 = new BronzeSaint("Seiya", "Pegaso");
        Saint saint3 = new BronzeSaint("Seiya", "Pegaso");
        
        lista.adicionar(seiya);
        lista.adicionar(seiya);
        lista.adicionar(marin);
        lista.adicionar(saint1);
        lista.adicionar(saint2);
        
        novaLista.adicionar(saint1);
        novaLista.adicionar(saint1);
        novaLista.adicionar(saint2);
        novaLista.adicionar(saint3);
        
        
        listaInterSec.adicionar(saint1);
        listaInterSec.adicionar(saint2);
        
        ListaSaints resultado = lista.intersec(novaLista);    
        
        assertTrue(resultado.todos().containsAll(listaInterSec.todos()));
        assertEquals(listaInterSec.todos().size(), resultado.todos().size()); 
    }
    
    @Test
    public void getCSVDoSaint() throws Exception {     
        ListaSaints lista = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        june.setGenero(Genero.FEMININO);
        june.perderVida(15.5);
        
        String csv = june.getCSV();
        
        String resultado = "June,84.5,Camaleão,BRONZE,VIVO,FEMININO,false";
        assertEquals(resultado, csv);
    }
    
    @Test
    public void getCSVDoSaintComArmadura() throws Exception {     
        ListaSaints lista = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        june.setGenero(Genero.FEMININO);
        june.perderVida(15.5);
        june.vestirArmadura();
        
        String csv = june.getCSV();
        
        String resultado = "June,84.5,Camaleão,BRONZE,VIVO,FEMININO,true";
        assertEquals(resultado, csv);
    }
    
    @Test
    public void getCSVDoSaintSemGenero() throws Exception {     
        ListaSaints lista = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        june.perderVida(15.5);
        june.vestirArmadura();
        
        String csv = june.getCSV();
        
        String resultado = "June,84.5,Camaleão,BRONZE,VIVO,NAO_INFORMADO,true";
        assertEquals(resultado, csv);
    }
    
    @Test
    public void getCSVDoSaintSemNome() throws Exception {     
        ListaSaints lista = new ListaSaints();
        Saint june = new BronzeSaint("", "Camaleão");
        june.perderVida(15.5);
        june.vestirArmadura();
        
        String csv = june.getCSV();
        
        String resultado = ",84.5,Camaleão,BRONZE,VIVO,NAO_INFORMADO,true";
        assertEquals(resultado, csv);
    }
    
    @Test
    public void getCSVDoSaintSComVida100() throws Exception {     
        ListaSaints lista = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        june.vestirArmadura();
        
        String csv = june.getCSV();
        
        String resultado = "June,100.0,Camaleão,BRONZE,VIVO,NAO_INFORMADO,true";
        assertEquals(resultado, csv);
    }
    
    
    @Test
    public void getCSVDoSaintSemCosntelacao() throws Exception {     
        ListaSaints lista = new ListaSaints();
        Saint june = new BronzeSaint("June", "");
        june.perderVida(15.5);
        june.vestirArmadura();
        
        String csv = june.getCSV();
        
        String resultado = "June,84.5,,BRONZE,VIVO,NAO_INFORMADO,true";
        assertEquals(resultado, csv);
    }
    
    @Test
    public void getCSVCom1Saint() throws Exception {     
        ListaSaints lista = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        june.setGenero(Genero.FEMININO);
        june.perderVida(15.5);
        lista.adicionar(june);
        
        String csv = lista.getCSV();
        
        String resultado = "June,84.5,Camaleão,BRONZE,VIVO,FEMININO,false";
        assertEquals(resultado, csv);
    }
    
    @Test
    public void getCSVCom2Saints() throws Exception {     
        ListaSaints lista = new ListaSaints();
        Saint june = new BronzeSaint("June", "Camaleão");
        june.setGenero(Genero.FEMININO);
        june.perderVida(15.5);
        lista.adicionar(june);
        
        Saint dohko = new SilverSaint("Dohko", (""));

        dohko.perderVida(90);
        dohko.vestirArmadura();
        lista.adicionar(dohko);
        
        String csv = lista.getCSV();

        String resultado = "June,84.5,Camaleão,BRONZE,VIVO,FEMININO,false\n"+
                        "Dohko,10.0,,PRATA,VIVO,NAO_INFORMADO,true";

        assertEquals(resultado, csv);
    }
    
    @Test
    public void getCSVComListaVazia() throws Exception {     
        ListaSaints lista = new ListaSaints();
        
        assertNull(lista.getCSV());
    }
}
