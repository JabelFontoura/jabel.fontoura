public class Batalha {

    private Saint oponente;
    private Saint desafiador;

    public Batalha(Saint oponente, Saint desafiador) {
        this.oponente = oponente;
        this.desafiador = desafiador;
    }

    public void iniciaBatalha() {
        Saint saintEmAcao = null;
        //Primeiro turno
        if(this.oponente.getValorCategoria() >= this.desafiador.getValorCategoria()) {
                saintEmAcao = this.oponente;
                atacar(oponente);
            }else {
                saintEmAcao = this.desafiador;
                atacar(desafiador);
            }
        
        //resto dos turnos    
        while(this.oponente.getStatus().equals(Status.VIVO) && this.desafiador.getStatus().equals(Status.VIVO)){
            saintEmAcao = saintEmAcao == this.oponente ? this.desafiador : this.oponente;
            
            atacar(saintEmAcao);
            
            mostrarQuemGanhou();         
        }
    }
    
    public void atacar(Saint atacado) {
        atacado.getProximoMovimento().executar();
    }
    
    public void mostrarQuemGanhou() {
        if(this.oponente.getStatus().equals(Status.MORTO)) {
            System.out.println(this.desafiador.getNome() + " ganhou com " + this.desafiador.getVida() + " de vida.");
        } else if(this.desafiador.getStatus().equals(Status.MORTO)){
            System.out.println(this.oponente.getNome() + " ganhou com " + this.oponente.getVida() + " de vida.");
        }
    }

}