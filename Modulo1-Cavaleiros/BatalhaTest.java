import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatalhaTest {

    @Test
    public void categoriaOponenteMaiorQueDesafiador() throws Exception {
        Saint shaina = new Saint("Shaina", new Armadura("Serpente", Categoria.PRATA));
        Saint hyoga = new Saint("Hyoga", new Armadura("Serpente", Categoria.BRONZE));

        Batalha batalha = new Batalha(shaina, hyoga);

        batalha.iniciaBatalha();

        assertEquals(100, shaina.getVida(), 0.01);
        assertEquals(90, hyoga.getVida(), 0.01);
    }

    @Test
    public void categoriasIguaisDesafiadorDevePerderVida() throws Exception {
        Saint aldebaram = new Saint("Aldebaram", new Armadura("Aldebaram", Categoria.OURO));
        Saint mascaraMorte = new Saint("Mascara da Morte", new Armadura("Cancer", Categoria.OURO));

        Batalha batalha = new Batalha(aldebaram, mascaraMorte);

        batalha.iniciaBatalha();

        assertEquals(100, aldebaram.getVida(), 0.01);
        assertEquals(90, mascaraMorte.getVida(), 0.01);
    }
    
      @Test
     public void categoriaDesafiadorMaiorOponentePerdeVida() throws Exception {
         // Arrange
         Saint ikki = new Saint("Ikki", new Armadura("Fênix", Categoria.BRONZE));
         Saint mascaraMorte = new Saint("Máscara da Morte", new Armadura("Câncer", Categoria.OURO));
         Batalha batalha = new Batalha(ikki, mascaraMorte);
         // Act
         batalha.iniciaBatalha();
         // Assert
         assertEquals(90, ikki.getVida(), 0.01);
         assertEquals(100, mascaraMorte.getVida(), 0.01);
     }
}
