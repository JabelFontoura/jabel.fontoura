public class ExercitoQueAtacaEmOrdemAlternada extends ExercitoDeSaints{
  
    private ListaSaints bronze = new ListaSaints();
    private ListaSaints silver = new ListaSaints();
    private ListaSaints gold = new ListaSaints();
    
    public void ordenar() {
        dividirLista();
        
        int tamanho = bronze.todos().size() + silver.todos().size() + gold.todos().size();
        
        for(int i = 0; i < tamanho / 2; i++) {
            if(existePosicao(bronze, i))super.getLista().adicionar(bronze.get(i));
            if(existePosicao(silver, i))super.getLista().adicionar(silver.get(i));
            if(existePosicao(gold, i))super.getLista().adicionar(gold.get(i));
        }
    }
    
    private void dividirLista() {
        for(Saint saint : super.getLista().todos()) {
           switch(saint.getValorCategoria()) {
               case 0:
                bronze.adicionar(saint);
                break;
                
               case 1:
                silver.adicionar(saint);                   
                break;
                
               case 2:
                gold.adicionar(saint);
                break;
            }
        }
        
        super.getLista().todos().clear();
    }
    
    public boolean existePosicao(final ListaSaints lista, final int i) {
        return i >= 0 && i < lista.todos().size();
    }   
}
