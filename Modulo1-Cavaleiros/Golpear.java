public class Golpear implements Movimento {

    private Saint golpeador;
    private Saint golpeado;

    public Golpear(Saint golpeador, Saint golpeado) {
        this.golpeador = golpeador;
        this.golpeado = golpeado;
    }

    public void executar() {
        Golpe golpe = this.golpeador.getProximoGolpe();

        if(this.golpeador.isArmaduraVestida()) {
            golpe.setFatorDano(golpe.getFatorDano() * (this.golpeador.getValorCategoria() + 1));
        }
        
        this.golpeado.perderVida(golpe.getFatorDano());
    }

}