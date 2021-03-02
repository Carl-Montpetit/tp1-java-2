public class ValeurInvalideSyllabeReductionException extends Exception{
    String erreurMessage = "Le nombre de syllabe cible doit être supérieur au nombre de syllabe dans le texte pour la réduction! ";
    public ValeurInvalideSyllabeReductionException(String erreurMessage) {
        super(erreurMessage);
    }
}
