import java.util.*;

/**
 * Représente l'unité de base pour la prononciation en français.
 * <p>
 * Une syllabe est composé d'un groupe de syllabe (le noyau).
 * optionnellement, elle peu avoir deux groupes de consonne.
 * Le groupe de consonne avant le noyau est l'attaque de la syllabe.
 * Le groupe de consonne après le noyau est le coda de la syllabe.
 *
 * @see ConsonneFrancais
 * @see VoyelleFrancais
 * @see <a href="https://fr.wiktionary.org/wiki/Annexe:Prononciation/fran%C3%A7ais">référence</a>
 */
public class SyllabeFrancais {
    /******************************************************************************************************************/
    // Variables.
    /******************************************************************************************************************/
    /**
     * Le groupe de consonne pour l'attaque de la syllabe.  S'il n'est pas présent, alors la valeur est à {@code null}.
     */
    protected ConsonneFrancais attaque = null;

    /**
     * Le groupe de voyelle pour la syllabe.  Ne doit pas être {@code null}.
     */
    protected VoyelleFrancais noyau;

    /**
     * Le groupe de consonne pour le code de la syllabe.  S'il n'est pas présent, alors la valeur est à {@code null}.
     */
    protected ConsonneFrancais coda = null;

    /******************************************************************************************************************/
    // Constructeurs.
    /******************************************************************************************************************/
    /**
     * Construit une syllabe avec un noyau seulement.
     *
     * @param noyau le groupe de voyelle utilisé pour la syllabe.  Ne doit pas être {@code null}.
     */
    public SyllabeFrancais( VoyelleFrancais noyau ) {
        this.noyau = noyau;
    }

    /**
     * Construit une syllabe avec une attaque et un noyau.
     *
     * @param attaque le groupe de consonne utilisé pour la syllabe.
     * @param noyau   le groupe de voyelle utilisé pour la syllabe.  Ne doit pas être {@code null}.
     */
    public SyllabeFrancais( ConsonneFrancais attaque, VoyelleFrancais noyau ) {
        this.attaque = attaque;
        this.noyau = noyau;
    }

    /**
     * Construit une syllabe avec une attaque, un noyau et un coda.
     *
     * @param attaque le groupe de consonne utilisé pour la syllabe.
     * @param noyau   le groupe de voyelle utilisé pour la syllabe.  Ne doit pas être {@code null}.
     * @param coda    le groupe de consonne utilisé pour la syllabe.
     */
    public SyllabeFrancais( ConsonneFrancais attaque, VoyelleFrancais noyau, ConsonneFrancais coda ) {
        this.attaque = attaque;
        this.noyau = noyau;
        this.coda = coda;
    }

    /**
     * Construit une syllabe avec un noyau et un coda.
     *
     * @param noyau le groupe de voyelle utilisé pour la syllabe.  Ne doit pas être {@code null}.
     * @param coda  le groupe de consonne utilisé pour la syllabe.
     */
    public SyllabeFrancais( VoyelleFrancais noyau, ConsonneFrancais coda ) {
        this.noyau = noyau;
        this.coda = coda;
    }

    /******************************************************************************************************************/
    // Méthode de lecture.
    /******************************************************************************************************************/
    /**
     * Lit une syllabe dans le {@code Scanner}.
     * <p>
     * Cherche possiblement un groupe de consonne qui servira d'attaque, ensuite un groupe de voyelle qui
     * servira de noyau et finalement un autre groupe de consonne pour le coda.
     *
     * @param scanner le {@code Scanner} dans lequel la lecture est effectué.
     * @return la voyelle lu.
     * @throws NoSuchElementException s'il n'y a pas de {@code SyllabeFrancais} valide.
     * @throws IllegalStateException  si le {@code Scanner} est fermé.
     */
    public static SyllabeFrancais lire( Scanner scanner ) {
        ConsonneFrancais attaque = null;
        VoyelleFrancais noyau;
        ConsonneFrancais coda = null;

        try {
            attaque = ConsonneFrancais.lire( scanner );
        } catch ( NoSuchElementException e ) {
        }

        noyau = VoyelleFrancais.lire( scanner );

        try {
            coda = ConsonneFrancais.lire( scanner );
        } catch ( NoSuchElementException e ) {
        }


        return new SyllabeFrancais( attaque, noyau, coda );
    }

    /******************************************************************************************************************/
    // Méthodes de retour.
    /******************************************************************************************************************/
    /**
     * retourne une chaîne de caractère composée des phonèmes de la syllabe.
     *
     * @return la chaîne contenant les symboles des phonèmes de la syllabe.
     */
    @Override
    public String toString() {
        return "" + ( null == attaque ? "" : attaque )
                + noyau
                + ( null == coda ? "" : coda );
    }

    /******************************************************************************************************************/
    // Getters.
    /******************************************************************************************************************/
    public ConsonneFrancais getAttaque() {
        return attaque;
    }

    public VoyelleFrancais getNoyau() {
        return noyau;
    }

    public ConsonneFrancais getCoda() {
        return coda;
    }

    /******************************************************************************************************************/
    // Equals & hashCode. (Override)
    /******************************************************************************************************************/
    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( !( o instanceof SyllabeFrancais ) ) return false;
        SyllabeFrancais that = ( SyllabeFrancais ) o;
        return Objects.equals( getAttaque(), that.getAttaque() ) && Objects.equals( getNoyau(), that.getNoyau() )
                && Objects.equals( getCoda(), that.getCoda() );
    }






    @Override
    public int hashCode() {
        return Objects.hash( getAttaque(), getNoyau(), getCoda() );
    }
}
