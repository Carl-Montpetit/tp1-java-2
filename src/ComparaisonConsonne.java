import java.util.Objects;

/**
 * Permet de gérer un groupe de deux phonèmes de consonne.
 */
public class ComparaisonConsonne {
    /******************************************************************************************************************/
    // Variables.
    /******************************************************************************************************************/
    /**
     * La consonne de base du groupe de consonne.
     * La valeur {@code null} est utilisé pour indiquer qu'elle n'est pas présente dans le groupe.
     */
    protected API_Consonne consonneA = null;

    /**
     * La consonne secondaire du groupe de consonne.
     * La valeur {@code null} est utilisé pour indiquer qu'elle n'est pas présente dans le groupe.
     */
    protected API_Consonne consonneB = null;

    /******************************************************************************************************************/
    // Constructeurs.
    /******************************************************************************************************************/
    /**
     * Construit un groupe avec deux silences.
     */
    public ComparaisonConsonne() {
    }

    /**
     * Construit un groupe avec une seule consonne et un silence.
     *
     * @param consonneA La consonne du groupe.  Elle est placé comme consonne de base.  Ne doit pas être {@code null}.
     */
    public ComparaisonConsonne(API_Consonne consonneA) {
        this.consonneA = consonneA;
    }

    /**
     * Construit un groupe avec deux consonnes.
     *
     * @param consonneA La consonne de base du groupe.  Ne doit pas être
     * {@code null}.
     * @param consonneB La consonne secondaire du groupe.
     */
    public ComparaisonConsonne(API_Consonne consonneA, API_Consonne consonneB) {
        this.consonneA = consonneA;
        this.consonneB = consonneB;
    }
    /******************************************************************************************************************/
    // Getters.
    /******************************************************************************************************************/
    public API_Consonne getConsonneA() {
        return consonneA;
    }

    public API_Consonne getConsonneB() {
        return consonneB;
    }

    /******************************************************************************************************************/
    // Méthodes de retour.
    /******************************************************************************************************************/
    /**
     * à testé
     * retourne la distance de 2 consonnes avec 3 caractéristiques
     * @return la distance pour les 3 caractéristiques
     */
    public int partieConsonne() {
        int distance = 0;
        if ( ( getConsonneA() == null && getConsonneB() == null) ||
                ( getConsonneA() == null || getConsonneB() == null ) ) {
            distance = 0;
        } else {
            if ( ( !getConsonneA().estContinu() == getConsonneB().estContinu() ) ) {
                distance++;
            }
            if ( ( !getConsonneA().estCompact() == getConsonneB().estCompact() ) ) {
                distance++;
            }
            if ( ( !getConsonneA().estAigu() == getConsonneB().estAigu() ) ) {
                distance++;
            }
        }
        return distance;
    }

    /**
     * à testé
     * retourne la distance de 2 consonnes
     * @param distance1 la distance des 3 première caractéristiques
     * @return la distance totale entre les deux consonnes
     */
    public int deuxConsonnes ( int distance1 ) {
        int distance = 0;
        if ( getConsonneA() == null && getConsonneB() == null) {
            distance = 0;
        } else if ( getConsonneA() == null || getConsonneB() == null ) {
            distance = 6;
        } else {
            distance = distance1;
            if ( ( !getConsonneA().estVocalique() == getConsonneB().estVocalique() ) ) {
                distance++;
            }
            if ( ( !getConsonneA().estVoise() == getConsonneB().estVoise() ) ) {
                distance++;
            }
            if ( ( !getConsonneA().estNasal() == getConsonneB().estNasal() ) ) {
                distance++;
            }
        }
        return distance;
    }
    /******************************************************************************************************************/
    // toString.
    /******************************************************************************************************************/
    @Override
    public String toString() {
        return "ComparaisonConsonne{" +
                "consonneA=" + consonneA +
                ", consonneB=" + consonneB +
                '}';
    }

    /******************************************************************************************************************/
    // Equals & hashCode.
    /******************************************************************************************************************/
    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( !( o instanceof ComparaisonConsonne ) ) return false;
        ComparaisonConsonne that = ( ComparaisonConsonne ) o;
        return getConsonneA() == that.getConsonneA() && getConsonneB() == that.getConsonneB();
    }

    @Override
    public int hashCode() {
        return Objects.hash( getConsonneA(), getConsonneB() );
    }
}


