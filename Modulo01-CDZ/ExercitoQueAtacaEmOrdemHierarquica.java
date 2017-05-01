import java.util.Comparator;
import java.util.Collections;

public class ExercitoQueAtacaEmOrdemHierarquica extends ExercitoDeSaints{
 
    public void ordenar() {
       Collections.sort(super.getLista().todos(), (saint1, saint2) -> Integer.compare(saint1.getValorCategoria(), saint2.getValorCategoria()));
    }
}