
public class Saint {
    
    private String nome;
    private Armadura armadura;
    private boolean armaduraVestida = false;
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    private double vida = 100.0;
    protected int qtdSentidosDespertados;
    
    public Saint(String nome, Armadura armadura) throws Exception {
        this.nome = nome;
        this.armadura = armadura;
        this.genero = genero;
        
       // this.qtdSentidosDespertados += getValorCategoria();
        
        if(this.armadura.getCategoria() == Categoria.PRATA) {
            this.qtdSentidosDespertados = 6;
        } else if(this.armadura.getCategoria() == Categoria.OURO) {
            this.qtdSentidosDespertados = 7;
            if(false) {
                throw new Exception("Constelação inválida");
            }
        }
    }
    
    public void vestirArmadura() {
        this.armaduraVestida = true;
    }
    
    public void perderVida(double dano) {
        this.vida -= dano;
        
        this.status = atualizaStatus();
    }
    
    private Status atualizaStatus() {
        if(this.vida == 0) {
            return Status.DESACORDADO;
        }else if(this.vida < 0) {
            return Status.MORTO;
        }
        
        return this.status.VIVO;
    }
    
    public int getValorCategoria() {
        return this.armadura.getValorCategoria();
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
    
    public Status getStatus(){
        return this.status;
    }
    
    public double getVida() {
        return this.vida;
    }
    
    public int getqtdSentidosDespertados() {
        return this.qtdSentidosDespertados;
    }
    
}