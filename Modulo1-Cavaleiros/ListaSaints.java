import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListaSaints {

    private List<Saint> lista = new ArrayList<Saint>();

    public ListaSaints() {

    }

    public void adicionar(Saint saint) {
        lista.add(saint);
    }

    public Saint get(int i) {
        return lista.get(i);
    }

    public List<Saint> todos() {
        return lista;
    }

    public void remover(Saint saint) {
        lista.remove(saint);
    }

    public Saint buscarPorNome(String nome) {
        for(int i = 0; i < lista.size(); i++) {
            if(nome.equals(lista.get(i).getNome())) {
                return lista.get(i);
            }
        }
        return null;
    }

    public List<Saint> buscarPorCategoria(Categoria categoria) {
        List<Saint> listaCategoria = new ArrayList<Saint>();

        for(int i = 0; i < lista.size(); i++) {
            if(categoria.getValor() == lista.get(i).getValorCategoria()) {
                listaCategoria.add(lista.get(i));
            }
        }
        return listaCategoria;
    }

    public List<Saint >buscarPorStatus(Status status) {
        List<Saint> listaStatus = new ArrayList<Saint>();

        for(int i = 0; i < lista.size(); i++) {
            if(status == lista.get(i).getStatus()) {
                listaStatus.add(lista.get(i));
            }
        }
        return listaStatus;
    }

    public Saint getSaintMaiorVida() throws Exception {
        Saint saintComMaiorVida = new Saint("Seiya", new Armadura(new Constelacao("Pegaso"), Categoria.BRONZE));
        saintComMaiorVida.perderVida(99);

        for(Saint saint : lista) {
            if(saint.getVida() > saintComMaiorVida.getVida()) {
                saintComMaiorVida = saint;
            }
        }

        return saintComMaiorVida;       
    }

    public Saint getSaintMenorVida() {
        ordenar();
        return lista.get(0);
    }

    public void ordenar() {    
        //Collections.sort(lista, (saint1, saint2) -> Double.compare(saint1.getVida(), saint2.getVida()));
       
       int j;
       Saint aux;
       
       for (int i = 1; i < lista.size(); i++) {    
          aux = lista.get(i);
          
          for (j = i - 1; (j >= 0) && (lista.get(j).getVida() > aux.getVida()); j--) {
              lista.set(j + 1, lista.get(j));
          }
          lista.set(j + 1, aux);
        }
       
   }

}