import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatalhaTest {

    @Test
    public void categoriaOponenteMaiorQueDesafiador() throws Exception {
        Saint shaina = new SilverSaint("Shaina", "Serpente");
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");

        Batalha batalha = new Batalha(shaina, hyoga);

        batalha.iniciaBatalha();

        assertEquals(100, shaina.getVida(), 0.01);
        assertEquals(90, hyoga.getVida(), 0.01);
    }

    @Test
    public void categoriasIguaisDesafiadorDevePerderVida() throws Exception {
        Saint aldebaram = new BronzeSaint("Aldebaram", "Aldebaram");
        Saint mascaraMorte = new BronzeSaint("Mascara da Morte", "Cancer");

        Batalha batalha = new Batalha(aldebaram, mascaraMorte);

        batalha.iniciaBatalha();

        assertEquals(100, aldebaram.getVida(), 0.01);
        assertEquals(90, mascaraMorte.getVida(), 0.01);
    }
    
      @Test
     public void categoriaDesafiadorMaiorOponentePerdeVida() throws Exception {
         // Arrange
         Saint ikki = new BronzeSaint("Ikki", "Fênix");
         Saint mascaraMorte = new GoldSaint("Máscara da Morte", "Câncer");
         Batalha batalha = new Batalha(ikki, mascaraMorte);
         // Act
         batalha.iniciaBatalha();
         // Assert
         assertEquals(90, ikki.getVida(), 0.01);
         assertEquals(100, mascaraMorte.getVida(), 0.01);
     }
}
