public class GolpearComDanoDuplo implements Movimento {
    
    private Saint golpeador;
    private Saint golpeado;
    private int dano;
    private Sorteador sorteador;

    public GolpearComDanoDuplo(Saint golpeador, Saint golpeado, Sorteador sorteador) {
        this.golpeador = golpeador;
        this.golpeado = golpeado;
        this.sorteador = sorteador;
    }

    public void executar() {
        this.dano = this.golpeador.getProximoGolpe().getFatorDano();
        
        if(acertouAtaque()) {
            golpear(2);
        }else {
            golpear(1);
            this.golpeador.perderVida(golpeador.getVida() * 0.05);
        }
           System.out.println(dano);
        this.golpeado.perderVida(dano);
    }
    
    public void golpear(int multiplicador) {
        if(this.golpeador.isArmaduraVestida())
            this.dano *= (2 + this.golpeador.getValorCategoria()) * multiplicador;
        else
            this.dano *= this.golpeador.getValorCategoria() * multiplicador;
    }
    
    public boolean acertouAtaque() { 
        return sorteador.sortear() == 3;
    }
    
    public boolean equals(Object outro) {
        GolpearComDanoDuplo outroGolpear = (GolpearComDanoDuplo)outro;
        return this.golpeador.equals(outroGolpear.golpeador)
            && this.golpeado.equals(outroGolpear.golpeado);
    }

}