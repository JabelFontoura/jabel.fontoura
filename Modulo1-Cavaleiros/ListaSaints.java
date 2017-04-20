import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

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
        for(Saint saint : lista) {
            if(nome.equals(saint.getNome())) {
                return saint;
            }
        }
        return null;
    }

    public List<Saint> buscarPorCategoria(Categoria categoria) {
        return lista.stream()
        .filter(s -> s.getValorCategoria() == (categoria.getValor()))
        .collect(Collectors.toList());
    }

    public List<Saint > buscarPorStatus(Status status) {
        return lista.stream()
        .filter(s -> s.getStatus().equals(status))
        .collect(Collectors.toList());
    }

    public Saint getSaintMaiorVida() throws Exception {
        if(lista.isEmpty()) {
            return null;
        }

        Saint saintComMaiorVida = lista.get(0);

        for(Saint saint : lista) {
            if(saint.getVida() > saintComMaiorVida.getVida()) {
                saintComMaiorVida = saint;
            }
        }

        return saintComMaiorVida;       
    }

    public Saint getSaintMenorVida() {
        if(lista.isEmpty()) {
            return null;
        }

        ordenar();
        return lista.get(0);
    }

    public void ordenar() {    
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

    public void ordenar(TipoOrdenacao tipoOrdenacao) {
        int j;
        Saint aux;

        if(tipoOrdenacao.equals(TipoOrdenacao.DESCENDENTE)) {
            for (int i = 1; i < lista.size(); i++) {    
                aux = lista.get(i);

                for (j = i - 1; (j >= 0) && (lista.get(j).getVida() < aux.getVida()); j--) {
                    lista.set(j + 1, lista.get(j));
                }
                lista.set(j + 1, aux);
            } 

        } else {
            ordenar();
        }
    }

    public ListaSaints unir(ListaSaints novaLista) {
        ListaSaints resultado = new ListaSaints();

        resultado.todos().addAll(lista);
        resultado.todos().addAll(novaLista.todos());

        return resultado;
    }

    public ListaSaints diff(ListaSaints novaLista) {
        ListaSaints resultado = new ListaSaints();
        
        for(Saint saint : lista) {
            if(!(novaLista.todos().indexOf(saint) >= 0)){
                resultado.adicionar(saint);
            }
        }
        
        for(Saint saint : novaLista.todos()) {
           if(!lista.contains(saint)) {
               resultado.adicionar(saint);
            }
        }
        
        return resultado;
    }

    public ListaSaints intersec(ListaSaints novaLista) {
        ListaSaints resultado = new ListaSaints();
        
        for(Saint saint : novaLista.todos()) {
            if(lista.contains(saint) && !resultado.todos().contains(saint)) {
                resultado.adicionar(saint);
            }
        }
                
        return resultado;
    }
    
    public String getCSV() {
        String resultado = "";
        
        for(Saint saint : lista) {
            resultado += 
                saint.getNome() + "," + 
                saint.getVida() + "," + 
                saint.getConstelacaoArmadura().getNome() + "," + 
                saint.getArmadura().getCategoria() + "," +
                saint.getStatus() + "," + 
                saint.getGenero() + "," + 
                saint.isArmaduraVestida()  + "\n";
        }
        
        return resultado;
    }
}