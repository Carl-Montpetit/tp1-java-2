import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;

/**
 * Décrit le son d'un groupe de consonne en français.
 * <p>
 * Cette description permet de contenir une ou deux consonnes afin de décrire le son des consonnes dans une syllabe.
 *
 * @see API_Consonne
 * @see SyllabeFrancais
 * @see <a href="https://fr.wiktionary.org/wiki/Annexe:Prononciation/fran%C3%A7ais">référence</a>
 */
public class ConsonneFrancais {
    /******************************************************************************************************************/
    // Variables.
    /******************************************************************************************************************/
    /**
     * La consonne de base du groupe de consonne.
     * Ne doit pas être {@code null}.
     */
    protected API_Consonne consonne1;

    /**
     * La consonne secondaire du groupe de consonne.
     * La valeur {@code null} est utilisé pour indiquer qu'elle n'est pas présente dans le groupe.
     */
    protected API_Consonne consonne2 = null;

    /**
     * Construit un groupe avec une seule consonne.
     *
     * @param consonne1 La consonne du groupe.  Elle est placé comme consonne de base.  Ne doit pas être {@code null}.
     */
    public ConsonneFrancais( API_Consonne consonne1 ) {
        this.consonne1 = consonne1;
    }

    /**
     * Construit un groupe avec deux consonnes.
     *
     * @param consonne1 La consonne de base du groupe.  Ne doit pas être {@code null}.
     * @param consonne2 La consonne secondaire du groupe.
     */
    public ConsonneFrancais( API_Consonne consonne1, API_Consonne consonne2 ) {
        this.consonne1 = consonne1;
        this.consonne2 = consonne2;
    }
    /******************************************************************************************************************/
    // Méthodes de lecture.
    /******************************************************************************************************************/
    /**
     * Lit un groupe de consonnes dans le {@code Scanner}.
     * <p>
     * Vérifie si le prochain caractère du {@code scanner} représente une consonne.  Si oui, alors cette consonne
     * deviendra la consonne de base du groupe retourné.
     * Ensuite, vérifie si le prochain caractère représente une consonne.  Si oui, alors cette consonne deviendra la
     * consonne secondaire du groupe retourné.
     *
     * @param scanner le {@code Scanner} dans lequel la lecture est effectué.
     * @return le groupe de consonne lu.
     * @throws NoSuchElementException s'il n'y a pas de {@code API_Consonne} valide.
     * @throws IllegalStateException  si le {@code Scanner} est fermé.
     */
    public static ConsonneFrancais lire( Scanner scanner ) {
        ConsonneFrancais resultat = null;
        API_Consonne consonne1 = API_Consonne.lire( scanner );
        API_Consonne consonne2;

        try {
            consonne2 = API_Consonne.lire( scanner );
            resultat = new ConsonneFrancais( consonne1, consonne2 );
        } catch ( NoSuchElementException e ) {
            resultat = new ConsonneFrancais( consonne1 );
        }

        return resultat;
    }
    /******************************************************************************************************************/
    // Méthodes de retour.
    /******************************************************************************************************************/
    /**
     * retourne une chaîne de caractère composée des consonnes du groupe.
     *
     * @return la chaîne contenant les symboles des consonnes du groupe.
     */
    @Override
    public String toString() {
        return "" + consonne1 + ( null == consonne2 ? "" : consonne2 );
    }

    /******************************************************************************************************************/
    // Getters.
    /******************************************************************************************************************/
    public API_Consonne getConsonne1() {
        return consonne1;
    }

    public API_Consonne getConsonne2() {
        return consonne2;
    }
    /******************************************************************************************************************/
    // Equals & hashCode.
    /******************************************************************************************************************/
    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( !( o instanceof ConsonneFrancais ) ) return false;
        ConsonneFrancais that = ( ConsonneFrancais ) o;
        return getConsonne1() == that.getConsonne1() && getConsonne2() == that.getConsonne2();
    }

    @Override
    public int hashCode() {
        return Objects.hash( getConsonne1(), getConsonne2() );
    }

    /**
     * à testé
     * retourne la distance de 2 consonnes avec 3 caractéristiques
     * @return la distance pour les 3 caractéristiques
     */
    public int partieConsonne(){
        int distance = 0;
        if((consonne1.equals(null) && consonne2.equals(null)) ||
                (consonne1.equals(null) || consonne2.equals(null))){
            distance = 0;
        }else {
            if (!(consonne1.estContinu() && consonne2.estContinu())) {
                distance++;
            }
            if (!(consonne1.estCompact() && consonne2.estCompact())) {
                distance++;
            }
            if (!(consonne1.estAigu() && consonne2.estAigu())) {
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
    public int deuxConsonnes (int distance1) {
        int distance = 0;
        if (consonne1.equals(null) && consonne2.equals(null)){
            distance = 0;
        }else if (consonne1.equals(null) || consonne2.equals(null)) {
            distance = 6;
        } else {
            if (!(consonne1.estVocalique() && consonne2.estVocalique())) {
                distance = distance1++;
            }
            if (!(consonne1.estVoise() && consonne2.estVoise())) {
                distance++;
            }
            if (!(consonne1.estNasal() && consonne2.estNasal())) {
                distance++;
            }
        }
        return distance;
    }
}
