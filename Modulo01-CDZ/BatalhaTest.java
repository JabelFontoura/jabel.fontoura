import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatalhaTest {

    @Test
    public void categoriaOponenteMaiorQueDesafiador() throws Exception {
        Saint shaina = new SilverSaint("Shaina", "Serpente");
        Saint hyoga = new BronzeSaint("Hyoga", "Cisne");

        shaina.aprenderGolpe(new Golpe("Venha Cobra", 5));
        shaina.golpear(hyoga);
        hyoga.aprenderGolpe(new Golpe("Pó de diamante", 4));
        hyoga.golpear(shaina);

        Batalha batalha = new Batalha(shaina, hyoga);

        batalha.iniciaBatalha();

        assertEquals(24, shaina.getVida(), 0.01);
        assertEquals(0, hyoga.getVida(), 0.01);
    }

    @Test
    public void categoriasIguaisDesafiadorDevePerderVida() throws Exception {
        Saint aldebaran = new BronzeSaint("Aldebaram", "Aldebaram");
        Saint mascaraMorte = new BronzeSaint("Mascara da Morte", "Cancer");

        aldebaran.aprenderGolpe(new Golpe("Grande Chifre", 10));
        aldebaran.adicionarMovimento(new VestirArmadura(aldebaran));
        aldebaran.golpear(mascaraMorte);
        mascaraMorte.aprenderGolpe(new Golpe("Ondas do Inferno", 10));
        mascaraMorte.golpear(aldebaran);

        Batalha batalha = new Batalha(aldebaran, mascaraMorte);

        batalha.iniciaBatalha();

        assertEquals(10, aldebaran.getVida(), 0.01);
        assertEquals(0, mascaraMorte.getVida(), 0.01);
    }

    @Test
    public void categoriaDesafiadorMaiorOponentePerdeVida() throws Exception {
        // Arrange
        Saint ikki = new BronzeSaint("Ikki", "Fênix");
        Saint mascaraMorte = new GoldSaint("Máscara da Morte", "Câncer");

        ikki.aprenderGolpe(new Golpe("Ave Fênix", 15));
        ikki.adicionarMovimento(new VestirArmadura(ikki));
        ikki.golpear(mascaraMorte);
        mascaraMorte.aprenderGolpe(new Golpe("Ondas do Inferno", 10));
        mascaraMorte.golpear(ikki);

        Batalha batalha = new Batalha(ikki, mascaraMorte);
        // Act
        batalha.iniciaBatalha();
        // Assert
        assertEquals(20, ikki.getVida(), 0.01);
        assertEquals(0, mascaraMorte.getVida(), 0.01);
    }
}
