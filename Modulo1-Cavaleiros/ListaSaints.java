import java.util.List;
import java.util.ArrayList;

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
    
    public Saint buscarPorCategoria(Categoria categoria) {
        List<Saint> listaCategoria = new ArrayList<Saint>();
        
        for(int i = 0; i < lista.size(); i++) {
            if(categoria.getValor() == lista.get(i).getValorCategoria()) {
                return lista.get(i);
            }
        }
        return null;
    }
    
    public Saint buscarPorStatus(Status status) {
        for(int i = 0; i < lista.size(); i++) {
            if(status == lista.get(i).getStatus()) {
                return lista.get(i);
            }
        }
        return null;
    }
    
}