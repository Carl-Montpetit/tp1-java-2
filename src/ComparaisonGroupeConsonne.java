import java.util.Objects;

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
                getDuoConsonneA().distanceDeuxConsonnesPartieDeux( getDuoConsonneA().distanceDeuxConsonnesPartieUn() );
        int distance2 =
                getDuoConsonneB().distanceDeuxConsonnesPartieDeux( getDuoConsonneB().distanceDeuxConsonnesPartieUn() );
        distance = distance1 + distance2;
        return distance;
    }

    /**
     * toString
     */
    @Override
    public String toString() {
        return "ComparaisonGroupeConsonne{" +
                "duoConsonneA=" + duoConsonneA +
                ", duoConsonneB=" + duoConsonneB +
                '}';
    }

    /******************************************************************************************************************/
    // Equals & hashCode.
    /******************************************************************************************************************/
    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( !( o instanceof ComparaisonGroupeConsonne ) ) return false;
        ComparaisonGroupeConsonne that = ( ComparaisonGroupeConsonne ) o;
        return Objects.equals( getDuoConsonneA(), that.getDuoConsonneA() ) && Objects.equals( getDuoConsonneB(), that.getDuoConsonneB() );
    }

    @Override
    public int hashCode() {
        return Objects.hash( getDuoConsonneA(), getDuoConsonneB() );
    }
}
