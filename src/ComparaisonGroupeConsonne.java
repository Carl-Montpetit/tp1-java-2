
/**
 * Permet de gérer deux groupes de voyelle.
 */
public class ComparaisonGroupeConsonne {
    /******************************************************************************************************************/
    // Variables.
    /******************************************************************************************************************/
    protected ComparaisonConsonne duoConsonneA = null;
    protected ComparaisonConsonne duoConsonneB = null;

    /******************************************************************************************************************/
    // Constructeur.
    /******************************************************************************************************************/
    /**
     * Construit deux groupes de deux consonnes vide  (silencieuse).
     */
    public ComparaisonGroupeConsonne() {
    }

    /**
     * Construit deux groupes de deux consonnes.
     * @param duoConsonneA le 1er groupe de Consonne
     * @param duoConsonneB le 2e groupe de Consonne
     */
    public ComparaisonGroupeConsonne(ComparaisonConsonne duoConsonneA,
                                    ComparaisonConsonne duoConsonneB) {
        this.duoConsonneA = duoConsonneA;
        this.duoConsonneB = duoConsonneB;
    }
    /******************************************************************************************************************/
    // Getters.
    /******************************************************************************************************************/
    public ComparaisonConsonne getDuoConsonneA() {
        return duoConsonneA;
    }

    public ComparaisonConsonne getDuoConsonneB() {
        return duoConsonneB;
    }
    /******************************************************************************************************************/
    // Méthodes de retour.
    /******************************************************************************************************************/
    /**
     * à testé
     * Cette méthode calcule la distance entre 2 groupes de consonne.
     * @return la distance entre 2 groupes de consonnes
     */
    public int distanceGroupeConsonne() {
        int distance;
        int distance1 =
                getDuoConsonneA().deuxConsonnes( getDuoConsonneA().partieConsonne() );
        int distance2 =
                getDuoConsonneB().deuxConsonnes( getDuoConsonneB().partieConsonne() );
        distance = distance1 + distance2;
        return distance;
    }
}
