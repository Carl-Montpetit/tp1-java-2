import java.util.ArrayList;

public class Liste {
    /******************************************************************************************************************/
    // Variables et constantes.
    /******************************************************************************************************************/
    protected ArrayList<ComparaisonSyllabes> duosSyllabes;

    /******************************************************************************************************************/
    // Méthodes de construction.
    /******************************************************************************************************************/

    /**
     * Ce constructeur contient une liste de comparaison de syllabes.
     * @param duosSyllabes La liste de comparaison de deux syllabes
     */
    public Liste(ArrayList<ComparaisonSyllabes> duosSyllabes) {
        this.duosSyllabes = duosSyllabes;
    }

    /******************************************************************************************************************/
    // Méthodes de retour.
    /******************************************************************************************************************/

    /**
     * Cette méthode sert à remplir la liste des distances entre deux syllabes.
     * @param distancesGroupesSyllabes La liste à remplir
     */
    public void listeDistancesSyllabes(ArrayList<Integer> distancesGroupesSyllabes){
        for ( int k = 0; k < duosSyllabes.size(); k++ ) {
            distancesGroupesSyllabes.add( duosSyllabes.get( k ).distanceSyllabe() );
        }
    }
}
