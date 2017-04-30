import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VestirArmaduraTest {
  
    @Test
    public void vestirArmadura() throws Exception {
        Saint shaina = new SilverSaint("Shaina", "Serpente");        
        Movimento movimento = new VestirArmadura(shaina);
        
        movimento.executar();
        
        assertTrue(shaina.isArmaduraVestida());
    }
    
    @Test
    public void naoVestirArmadura() throws Exception {        
        Saint shaina = new SilverSaint("Shaina", "Serpente");        
        Movimento movimento = new VestirArmadura(shaina);
        
        assertFalse(shaina.isArmaduraVestida());
    }
    
    @Test (expected=NullPointerException.class)
    public void vestirArmaduraComSaintNull() throws Exception {
        Movimento movimento = new VestirArmadura(null);
        movimento.executar();
        
    }
}
