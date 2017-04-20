import java.security.InvalidParameterException;
import java.util.List;

public class Saint {

    private String nome;
    private Armadura armadura;
    private boolean armaduraVestida = false;
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    private double vida = 100.0;
    protected int qtdSentidosDespertados;
    private int golpeAtual;

    public Saint(String nome, Armadura armadura) throws Exception {
        this.nome = nome;
        this.armadura = armadura;
        this.genero = genero;

        // this.qtdSentidosDespertados += getValorCategoria();
    }

    public void vestirArmadura() {
        this.armaduraVestida = true;
    }
    
    public Armadura getArmadura() {
        return this.armadura;
    }
    
    public Constelacao getConstelacaoArmadura() {
        return this.armadura.getConstelacao();
    }

    public void perderVida(double dano) {
        if(dano < 0) {
            throw new InvalidParameterException("O valor do dano não pode ser menor que 0.");
        }

        if(status != Status.MORTO) {
            this.vida -= dano;
            
            if(dano > this.vida) {
                this.vida = 0;
            }
        }
        
        this.status = atualizaStatus();
    }

    private Status atualizaStatus() {
        if(this.vida == 1) {
            return Status.DESACORDADO;
        }else if(this.vida < 1) {
            return Status.MORTO;
        }

        return this.status.VIVO;
    }
    
    public List<Golpe> getGolpes() {
        return this.armadura.getConstelacao().getGolpes();
    }
    
    public void aprenderGolpe(Golpe golpe) {
        this.armadura.getConstelacao().adicionarGolpe(golpe);
    }
    
    public Golpe getProximoGolpe() {
        if(this.golpeAtual >= getGolpes().size()) {
            this.golpeAtual = 0;
        }
        return getGolpes().get(golpeAtual++);
    }

    public int getValorCategoria() {
        return this.armadura.getValorCategoria();
    }
    
    public String getNome() {
        return this.nome;
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