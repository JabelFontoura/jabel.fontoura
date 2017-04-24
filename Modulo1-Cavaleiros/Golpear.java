public class Golpear implements Movimento {

    private Saint golpeador;
    private Saint golpeado;
    private int dano;

    public Golpear(Saint golpeador, Saint golpeado) {
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

}