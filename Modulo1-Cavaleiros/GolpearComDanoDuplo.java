public class GolpearComDanoDuplo implements Movimento {
    
    private Saint golpeador;
    private Saint golpeado;
    private int dano;

    public GolpearComDanoDuplo(Saint golpeador, Saint golpeado) {
        this.golpeador = golpeador;
        this.golpeado = golpeado;
    }

    public void executar() {
        dano = this.golpeador.getProximoGolpe().getFatorDano();
        
        if(this.golpeador.isArmaduraVestida()) {
            dano *= 2 + this.golpeador.getValorCategoria();
        }
        
        this.golpeado.perderVida(dano);
    }
    
    public boolean acertouOAtaque(Sorteador sorteador) { 
        return sorteador.sortear() == 3;
    }
    
    public boolean equals(Object outro) {
        GolpearComDanoDuplo outroGolpear = (GolpearComDanoDuplo)outro;
        return this.golpeador.equals(outroGolpear.golpeador)
            && this.golpeado.equals(outroGolpear.golpeado);
    }

}