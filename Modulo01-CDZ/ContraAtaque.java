public class ContraAtaque implements Movimento {
    
    private Saint golpeador, golpeado;
    private Sorteador sorteador;
    
    public ContraAtaque(Saint golpeador, Saint golpeado, Sorteador sorteador) {
        this.golpeador = golpeador;
        this.golpeado = golpeado;
        this.sorteador = sorteador;
    }
    
    public void executar() {
        if(podeContraAtacar()) {
            golpeador.getProximoGolpe().anularGolpe();
            golpeador.perderVida(golpeador.getVida() * 0.25);
        }
    }
    
    public boolean podeContraAtacar() {
        if(golpeado.getVida() < 50 && !golpeado.isArmaduraVestida()){
            return acertouContraAtaque();
        }    
       return false;     
    }
    
    public boolean acertouContraAtaque() {
        return sorteador.sortear() <= 2;
    }
}
