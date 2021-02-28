/**
 * Caractéristique sonore indiquant le débit d'air expiré et la tension sur les cordes vocales.
 *
 * @see <a href="https://fr.wikipedia.org/wiki/Phonation">référence</a>
 */
public enum Phonation {
    /******************************************************************************************************************/
    // Constantes.
    /******************************************************************************************************************/
    ND,
    SOURDE,
    VOISEE,

    ;

    /******************************************************************************************************************/
    // Méthodes de validation.
    /******************************************************************************************************************/
    /**
     * Caractéristique sonore indiquant si la consonne est voisée.
     *
     * @return {@code true} si la consonne est voisée.
     */
    public boolean estVoise() {
        return VOISEE == this;
    }
}
