import java.util.ArrayList;
import java.util.List;

public class Constelacao {
    
    private String nome;
    private List<Golpe> golpes = new ArrayList<Golpe>(); 
    
    public Constelacao(String nome) {
        this.nome = nome;
    }
    
    public void adicionarGolpe(Golpe golpe) {
        golpes.add(golpe);
    }
    
    public List<Golpe> getGolpes() {
        return this.golpes;
    }
    
    public String getNome() {
        return this.nome;
    }
}