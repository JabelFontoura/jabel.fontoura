import java.security.InvalidParameterException;
import java.util.List;
import java.util.ArrayList;


public abstract class Saint {

    private String nome;
    private Armadura armadura;
    private boolean armaduraVestida = false;
    private Genero genero = Genero.NAO_INFORMADO;
    private Status status = Status.VIVO;
    private double vida = 100.0;
    protected int qtdSentidosDespertados;
    private int golpeAtual;
    private List<Movimento> movimentos = new ArrayList<Movimento>();
    private int movimentoAtual;
    private static int qtdSaints = 0;

    public Saint(String nome, Armadura armadura) throws Exception {
        this.nome = nome;
        this.armadura = armadura;
        
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
            if(dano >= this.vida) {
                this.vida = 0;
            }else {
                this.vida -= dano;  
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
    
    public void golpear(Saint golpeado) {
        this.adicionarMovimento(new Golpear(this, golpeado));
    }

    public Golpe getProximoGolpe() {
        if(this.golpeAtual >= getGolpes().size()) {
            this.golpeAtual = 0;
        }
        return getGolpes().get(golpeAtual++);
    }
    
    public void adicionarMovimento(Movimento movimento) {
        this.movimentos.add(movimento);
    }
    
    public Movimento getProximoMovimento() {
        if(this.movimentoAtual >= this.movimentos.size()) {
            this.movimentoAtual = 0;
        }
        return this.movimentos.get(movimentoAtual++);
    }

    public String getCSV() {
        StringBuilder sb = new StringBuilder();
        
            sb.append(getNome() + ","); 
            sb.append(getVida() + ","); 
            sb.append(getConstelacaoArmadura().getNome() + ","); 
            sb.append(getArmadura().getCategoria() + ",");
            sb.append(getStatus() + ",");
            sb.append(getGenero() + ","); 
            sb.append(isArmaduraVestida());
        
        return sb.toString();    
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
    
    public static int getQtdSaints() {
        return Saint.qtdSaints;
    }

}