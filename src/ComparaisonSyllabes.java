import java.util.Objects;

/**
 * Cette classe permet les syllabes.
 */
public class ComparaisonSyllabes {
    /******************************************************************************************************************/
    // Variables.
    /******************************************************************************************************************/
    protected SyllabeFrancais syllabe1;
    protected SyllabeFrancais syllabe2;

    /******************************************************************************************************************/
    // Constructeurs.
    /******************************************************************************************************************/
    public ComparaisonSyllabes() {
    }

    /**
     * Construit deux syllabes à comparer.
     *
     * @param syllabe1 la première syllabe
     * @param syllabe2 la deuxième syllabe
     */
    public ComparaisonSyllabes( SyllabeFrancais syllabe1,
                                SyllabeFrancais syllabe2 ) {
        this.syllabe1 = syllabe1;
        this.syllabe2 = syllabe2;
    }
    /******************************************************************************************************************/
    // Getters.
    /******************************************************************************************************************/
    public SyllabeFrancais getSyllabe1() {
        return syllabe1;
    }

    public SyllabeFrancais getSyllabe2() {
        return syllabe2;
    }

    /******************************************************************************************************************/
    // Méthodes de retour.
    /******************************************************************************************************************/

    /**
     * Cette méthode calcule la distance entre les attaques des deux syllabes.
     *
     * @return la distance entre les attaques
     */
    public int distanceAttaque() {
        int distanceDesAttaques;
        if ( getSyllabe1().getAttaque() == null && getSyllabe2().getAttaque() == null ) {
            distanceDesAttaques = Constantes.MIN_DISTANCE_ATTAQUE;
        } else if ( getSyllabe1().getAttaque() == null || getSyllabe2().getAttaque() == null ) {
            distanceDesAttaques = Constantes.MAX_DISTANCE_ATTAQUE;
        } else {
            ComparaisonConsonne attaque1 =
                    new ComparaisonConsonne( getSyllabe1().getAttaque().getConsonne1(), getSyllabe2().getAttaque().getConsonne1() );
            ComparaisonConsonne attaque2 =
                    new ComparaisonConsonne( getSyllabe1().getAttaque().getConsonne2(), getSyllabe2().getAttaque().getConsonne2() );
            ComparaisonGroupeConsonne attaque =
                    new ComparaisonGroupeConsonne( attaque1, attaque2 );
            distanceDesAttaques = attaque.distanceGroupeConsonne();
        }
        return distanceDesAttaques;
    }

    /**
     * Cette méthode calcule la distance entre les noyaux des deux syllabes.
     *
     * @return la distance entre les noyaux
     */
    public int distanceNoyau() {
        ComparaisonVoyelle noyau1 =
                new ComparaisonVoyelle( getSyllabe1().getNoyau().getSemiVoyelle(), getSyllabe2().getNoyau().getSemiVoyelle() );
        ComparaisonVoyelle noyau2 =
                new ComparaisonVoyelle( getSyllabe1().getNoyau().getVoyelle(),
                        getSyllabe2().getNoyau().getVoyelle() );
        ComparaisonGroupeVoyelle noyau = new ComparaisonGroupeVoyelle( noyau1,
                noyau2 );
        int distanceNasal = Constantes.MIN_DISTANCE_NASAL;
        if ( !getSyllabe1().getNoyau().estNasal() == getSyllabe2().getNoyau().estNasal() ) {
            distanceNasal = Constantes.MAX_DISTANCE_NASAL;
        }
        return noyau.distanceGroupeVoyelle() + distanceNasal;
    }

    /**
     * Cette méthode calcule la distance entre les codas des deux syllabes.
     *
     * @return la distance entre les codas
     */
    public int distanceCoda() {
        int distanceDesCodas;
        if ( getSyllabe1().getCoda() == null && getSyllabe2().getCoda() == null ) {
            distanceDesCodas = Constantes.MIN_DISTANCE_CODA;
        } else if ( getSyllabe1().getCoda() == null || getSyllabe2().getCoda() == null ) {
            distanceDesCodas = Constantes.MAX_DISTANCE_CODA;
        } else {
            ComparaisonConsonne coda1 =
                    new ComparaisonConsonne( getSyllabe1().getCoda().getConsonne1()
                            , getSyllabe2().getCoda().getConsonne1() );
            ComparaisonConsonne coda2 =
                    new ComparaisonConsonne( getSyllabe1().getCoda().getConsonne2()
                            , getSyllabe2().getCoda().getConsonne2() );
            ComparaisonGroupeConsonne coda =
                    new ComparaisonGroupeConsonne( coda1, coda2 );
            distanceDesCodas = coda.distanceGroupeConsonne();
        }
        return distanceDesCodas;
    }

    /**
     * Cette méthode calcule la distance entre les deux syllabes.
     *
     * @return la distance entre les deux syllabes
     */
    public int distanceSyllabe() {
        return distanceAttaque() + 2 * distanceNoyau() + distanceCoda();
    }

    /**
     * ToString.
     */
    @Override
    public String toString() {
        return "ComparaisonSyllabes{" +
                "syllabe1=" + syllabe1 +
                ", syllabe2=" + syllabe2 +
                '}';
    }
    /******************************************************************************************************************/
    // Equals & hashCode.
    /******************************************************************************************************************/
    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( !( o instanceof ComparaisonSyllabes ) ) return false;
        ComparaisonSyllabes that = ( ComparaisonSyllabes ) o;
        return Objects.equals( getSyllabe1(), that.getSyllabe1() ) && Objects.equals( getSyllabe2(), that.getSyllabe2() );
    }

    @Override
    public int hashCode() {
        return Objects.hash( getSyllabe1(), getSyllabe2() );
    }
}
