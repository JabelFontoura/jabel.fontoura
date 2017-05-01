public class GuerraEntreExercitos {
    
    private ExercitoDeSaints defensoresDeAthena, impostores;
    
    public GuerraEntreExercitos(ExercitoDeSaints defensoresDeAthena, ExercitoDeSaints impostores) {
        this.defensoresDeAthena = defensoresDeAthena;
        this.impostores = impostores;
    }
    
    public void iniciar() { // TODO testar
        int tamanho = impostores.getLista().todos().size() < defensoresDeAthena.getLista().todos().size() ? 
            impostores.getLista().todos().size() : defensoresDeAthena.getLista().todos().size();
            
         for(int i = 0; i < tamanho; i++) {
             new Batalha(defensoresDeAthena.getLista().get(i), impostores.getLista().get(i)).iniciaBatalha();
         }
    }
}
