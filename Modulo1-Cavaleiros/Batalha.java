public class Batalha {

    private Saint oponente;
    private Saint desafiador;

    public Batalha(Saint oponente, Saint desafiador) {
        this.oponente = oponente;
        this.desafiador = desafiador;
    }

    public void iniciaBatalha() {
        this.oponente.aprenderGolpe(new Golpe("Soco", 10));
        this.desafiador.aprenderGolpe(new Golpe("Soco", 10));
        
        this.oponente.adicionarMovimento(new Golpear(oponente, desafiador));
        this.desafiador.adicionarMovimento(new Golpear(desafiador, oponente));
        
        while(this.oponente.getStatus().equals(Status.VIVO) && this.desafiador.getStatus().equals(Status.VIVO)){
            if(this.oponente.getValorCategoria() >= this.desafiador.getValorCategoria()) {
                this.desafiador.getProximoMovimento().executar();
            }else {
                this.oponente.getProximoMovimento().executar();
            }
            //TODO ajustar turnos
        }
    }

}