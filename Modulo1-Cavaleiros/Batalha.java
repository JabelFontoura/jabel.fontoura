public class Batalha {

    private Saint oponente;
    private Saint desafiador;
    private int turno = 1;

    public Batalha(Saint oponente, Saint desafiador) {
        this.oponente = oponente;
        this.desafiador = desafiador;
    }

    public void iniciaBatalha() {
        this.oponente.aprenderGolpe(new Golpe("Soco", 10));
        this.desafiador.aprenderGolpe(new Golpe("Soco", 10));
        
        this.oponente.adicionarMovimento(new Golpear(oponente, desafiador));
        this.desafiador.adicionarMovimento(new Golpear(desafiador, oponente));
        
        //TODO melhorar logica
        //Primeiro turno
        if(this.oponente.getValorCategoria() >= this.desafiador.getValorCategoria()) {
                atacar(oponente);
            }else {
                atacar(desafiador);
            }
        
        //resto dos turnos    
        while(this.oponente.getStatus().equals(Status.VIVO) && this.desafiador.getStatus().equals(Status.VIVO)){
            if(turno % 2 == 0) {
                atacar(desafiador);
            } else {
                atacar(oponente);
            }
            
            mostrarQuemGanhou();         
        }
    }
    
    public void atacar(Saint atacado) {
        atacado.getProximoMovimento().executar();
        turno++;
    }
    
    public void mostrarQuemGanhou() {
        if(this.oponente.getStatus().equals(Status.MORTO)) {
            System.out.println(this.desafiador.getNome() + " ganhou com " + this.desafiador.getVida() + " de vida.");
        } else if(this.desafiador.getStatus().equals(Status.MORTO)){
            System.out.println(this.oponente.getNome() + " ganhou com " + this.oponente.getVida() + " de vida.");
        }
    }

}