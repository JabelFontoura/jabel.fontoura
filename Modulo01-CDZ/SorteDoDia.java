public class SorteDoDia {
    
    private Sorteador sorteador;
    
    public SorteDoDia(Sorteador sorteador) {
        this.sorteador = sorteador;
    }
    
    public boolean estouComSorte() {        
        return this.sorteador.sortear() % 2 == 0;
    }
}
