public class Batalha {
    
    private Saint oponente;
    private Saint desafiador;
    
    public Batalha(Saint oponente, Saint desafiador) {
        this.oponente = oponente;
        this.desafiador = desafiador;
    }
    
    public void iniciaBatalha() {
        double dano = 10;
        
        if(this.oponente.getValorCategoria() >= this.desafiador.getValorCategoria()) {
            this.desafiador.perderVida(dano);
        }else {
            this.oponente.perderVida(dano);
        }
        
    }
    
}