import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SaintTest {
    
    @Test
    public void vestirArmaduraDeixaTrue() {
        //AAA
        //1. Arrange - Montagem dos dados de teste
        Armadura escorpiao = new Armadura("Escorpião");
        Saint milo = new Saint("Milo", escorpiao);
        
        //2. Act - Invocar a ação a ser testada
        milo.vestirArmadura();
        
        //3. Assert - Verificação dos resultados do teste
        boolean resultado = milo.isArmaduraVestida();
        assertEquals(true, resultado);
    }
    
    @Test
    public void naoVestirArmaduraDeixaFalse() {
        Saint hyoga = new Saint("Hyoga", new Armadura("Cisne"));
        assertEquals(false, hyoga.isArmaduraVestida());
    }
}
