public class Golpear implements Movimento {

    private Saint golpeador;
    private Saint golpeado;
    private int dano;

    public Golpear(Saint golpeador, Saint golpeado) {
        this.golpeador = golpeador;
        this.golpeado = golpeado;
    }

    public void executar() {
        dano = 0;
        Golpe golpe = this.golpeador.getProximoGolpe();
        
        dano = golpe.getFatorDano();
        
        if(this.golpeador.isArmaduraVestida()) {
            dano = dano * (this.golpeador.getValorCategoria() + 1);
        }
        
        this.golpeado.perderVida(dano);
    }

}