public abstract class ExercitoDeSaints {
    
    private ListaSaints lista = new ListaSaints();
    
    public void alistar(Saint saint) {
        lista.adicionar(saint);
    }
    
    public ListaSaints getLista() {
        return lista;
    }
    
    public abstract void ordenar();
}