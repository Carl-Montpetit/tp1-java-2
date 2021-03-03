import java.util.Objects;

/**
 * Permet de gérer un groupe de deux phonèmes de voyelle.
 */
public class ComparaisonVoyelle {
    /******************************************************************************************************************/
    // Variables.
    /******************************************************************************************************************/

    /**
     * La 2e voyelle du groupe de voyelle.
     * La valeur {@code null} est utilisé pour indiquer qu'elle n'est pas présente dans le groupe.
     */
    protected API_Voyelle voyelleB = null;

    /**
     * La 1re voyelle du groupe.
     * Peut être null.
     */
    protected API_Voyelle voyelleA = null;

    /******************************************************************************************************************/
    // Constructeurs.
    /******************************************************************************************************************/

    /**
     * Construit un groupe avec deux silences.
     */
    public ComparaisonVoyelle() {
    }

    /**
     * Construit un groupe avec une seule voyelle et un silence.
     *
     * @param voyelleA La voyelle du groupe.  Elle est placé comme consonne de
     *                 base
     *                 .  Ne doit pas être {@code null}.
     */
    public ComparaisonVoyelle( API_Voyelle voyelleA ) {
        this.voyelleA = voyelleA;
    }


    /**
     * Construit un groupe avec deux voyelle.
     *
     * @param voyelleA la 1re voyelle
     * @param voyelleB la 2e voyelle
     */
    public ComparaisonVoyelle( API_Voyelle voyelleB, API_Voyelle voyelleA ) {
        this.voyelleA = voyelleA;
        this.voyelleB = voyelleB;
    }

    /******************************************************************************************************************/
    // Getters.
    /******************************************************************************************************************/

    public API_Voyelle getVoyelleA() {
        return voyelleA;
    }

    public API_Voyelle getVoyelleB() {
        return voyelleB;
    }

    /******************************************************************************************************************/
    // Méthodes de retour.
    /******************************************************************************************************************/

    /**
     * retourne la distance de 2 voyelles avec 3 caractéristiques.
     *
     * @return la distance pour les 3 caractéristiques
     */
    public int distanceDeuxVoyellesPartieUn() {
        int distance = 0;
        if ( ( getVoyelleA() == null && getVoyelleB() == null ) ||
                ( getVoyelleA() == null || getVoyelleB() == null ) ) {
            distance = 0;
        } else {
            if ( ( !getVoyelleA().estArrondi() == getVoyelleB().estArrondi() ) ) {
                distance++;
            }
            if ( ( !getVoyelleA().estOuverte() == getVoyelleB().estOuverte() ) ) {
                distance++;
            }
        }
        return distance;
    }

    /**
     * Retourne la distance de 2 voyelles.
     *
     * @param distance1 la distance des 3 première caractéristiques
     * @return la distance totale entre les deux voyelles
     */
    public int distanceDeuxVoyellesPartieDeux( int distance1 ) {
        int distance;
        if ( getVoyelleA() == null && getVoyelleB() == null ) {
            distance = 0;
        } else if ( getVoyelleA() == null || getVoyelleB() == null ) {
            distance = 4;
        } else {
            distance = distance1;
            if ( ( !getVoyelleA().estArriere() == getVoyelleB().estArriere() ) ) {
                distance++;
            }
            if ( ( !getVoyelleA().estHaut() == getVoyelleB().estHaut() ) ) {
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
        return "ComparaisonVoyelle{" +
                "voyelleB=" + voyelleB +
                ", voyelleA=" + voyelleA +
                '}';
    }

    /******************************************************************************************************************/
    // Equals & hashCode.
    /******************************************************************************************************************/
    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( !( o instanceof ComparaisonVoyelle ) ) return false;
        ComparaisonVoyelle that = ( ComparaisonVoyelle ) o;
        return getVoyelleA() == that.getVoyelleA() && getVoyelleB() == that.getVoyelleB();
    }

    @Override
    public int hashCode() {
        return Objects.hash( getVoyelleB(), getVoyelleA() );
    }
}
