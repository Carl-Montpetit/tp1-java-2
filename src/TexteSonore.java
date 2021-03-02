import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Une classe pour contenir une suite de syllabe.
 * <p>
 * Cette classe permet la gestion d'une suite de syllabe.
 *
 * @see SyllabeFrancais
 */
public class TexteSonore extends ArrayList<SyllabeFrancais> {
    /******************************************************************************************************************/
    // Variables et constantes.
    /******************************************************************************************************************/
    /**
     * Le caractère utilisé pour séparé les syllabes lors de la lecture et de l'écriture.
     */
    public static final String SEPARATEUR = ".";
    /******************************************************************************************************************/
    // Méthodes de construction.
    /******************************************************************************************************************/
    /**
     * Construit une suite de syllabe vide.
     */
    public TexteSonore() {
    }

    /**
     * Construit une suite de syllabes à partir du contenu d'un fichier.
     *
     * @param nomFichier Le nom du fichier qui contient la suite de syllabes.
     */
    public TexteSonore( String nomFichier ) {
        File fichier = new File( nomFichier );
        Scanner scanner = null;

        try {
            scanner = new Scanner( fichier );
        } catch ( FileNotFoundException e ) {
            Erreur.FICHIER_INEXISTANT.lancer( "\"" + nomFichier + "\"" );
        }

        scanner.useDelimiter( "" );
        lire( scanner );
        scanner.close();
    }

    /**
     * Construit une chaîne de caractères contenant la suite de syllabe représenté par les symboles de l'API.
     *
     * @return la chaîne construite.  S'il n'y a pas de syllabe dans la suite, alors la chaîne sera vide.
     */
    @Override
    public String toString() {
        return stream().map( SyllabeFrancais::toString ).collect( Collectors.joining( SEPARATEUR ) );
    }

    /******************************************************************************************************************/
    // Méthodes de lecture.
    /******************************************************************************************************************/
    /**
     * Lit une suite de syllabe dans le {@code Scanner}.
     * <p>
     * Consulte le {@code Scanner} pour lire une suite de syllabe séparé par le caractère {@code SEPARATEUR}.
     *
     * @param scanner le {@code Scanner} dans lequel la lecture est effectué.
     * @return le groupe de consonne lu.
     * @throws NoSuchElementException s'il n'y a pas de {@code API_Consonne} valide.
     * @throws IllegalStateException  si le {@code Scanner} est fermé.
     */
    private void lire( Scanner scanner ) {
        try {
            while ( scanner.hasNext() ) {
                add( SyllabeFrancais.lire( scanner ) );
                scanner.next( SEPARATEUR );
            }
        } catch ( NoSuchElementException e ) {
        }
    }

    /******************************************************************************************************************/
    // Méthodes de retour.
    /******************************************************************************************************************/
    /**
     * Calcule le nombre d'occurrence d'une syllabe dans le texte.
     * @param texteSonore
     * @return nombre d'occurrence
     */
    public int occurrencesSyllabesDansTexteSonore( TexteSonore texteSonore, SyllabeFrancais syllabe ) {
        int compteur = 0;

        for ( int i = 0; i < texteSonore.size(); i++ ) {
            if ( texteSonore.get( i ).equals( syllabe ) ) {
                compteur++;
            }
        }
        return compteur;
    }

    /**
     * Crée un nouveau ArrayList sans occurrences.
     * @param texteSonore
     * @return ArrayList contenant les éléments unique sans occurrences
     */
    public TexteSonore syllabeUnique( TexteSonore texteSonore ) {
        TexteSonore texteÉlémentsUniques = new TexteSonore();

        for ( int i = 0; i < texteSonore.size(); i++ ) {
            if ( !texteÉlémentsUniques.contains( texteSonore.get( i ) ) ) {
                texteÉlémentsUniques.add( texteSonore.get( i ) );
            }
        }
        return texteÉlémentsUniques;
    }
}
