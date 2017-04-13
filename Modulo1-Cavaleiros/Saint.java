
public class Saint {
    
    private String nome;
    private Armadura armadura;
    private boolean armaduraVestida = false;
    private Genero genero = Genero.NAO_INFORMADO;
    
    public Saint(String nome, Armadura armadura) {
        this.nome = nome;
        this.armadura = armadura;
        this.genero = genero;
    }
    
    public void vestirArmadura() {
        this.armaduraVestida = true;
    }
    
    public boolean isArmaduraVestida() {
        return this.armaduraVestida;
    }
    
    public Genero getGenero() {
        return this.genero;
    }
    
    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}