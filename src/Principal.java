import java.util.Scanner;

/**
 * TP1 INF2120
 *
 * @nom Montpetit, Carl
 * @code_permanent MONC08069000
 */

public class Principal {
    /******************************************************************************************************************/
    // Méthodes de demande.
    /******************************************************************************************************************/
    /**
     * Demande le nom du fichier dans lequel la suite de syllabe sera lu.
     *
     * @param scanner Indique l'endroit où le nom du fichier sera lu.
     * @return une chaîne de caractères contenant le nom du fichier.
     */
    public static String demanderNomFichier( Scanner scanner ) {
        String resultat = "";

        System.out.print( Textes.MSSG_DEMANDE_NOMFICHIER );
        resultat = scanner.nextLine();

        return resultat;
    }

    /**
     * Demande le nombre de syllabe cible que le logiciel doit utiliser pour faire la réduction.
     * <p>
     * Cette valeur doit être plus grande ou égal à {@code Constantes.MIN_NOMBRE_SYLLABE}.
     *
     * @param scanner Indique l'endroit où la valeur sera lu.
     * @return l'entier lu dans le {@code Scanner}.
     * @see Constantes
     */
    public static int demanderNombreDeSyllabe( Scanner scanner ) {
        int resultat = 0;

        System.out.print( Textes.MSSG_DEMANDE_NOMBRE_SYLLABE );
        resultat = scanner.nextInt();

        if ( resultat < Constantes.MIN_NOMBRE_SYLLABE ) {
            Erreur.NOMBRE_SYLLABE.lancer( "  Valeur entrée : " + resultat );
        }

        return resultat;
    }
    /******************************************************************************************************************/
    // Méthode principal.
    /******************************************************************************************************************/
    /**
     * Programme principal de l'application
     *
     * @param args Les paramètres externe de l'application.
     */
    public static void main( String[] args ) {
        // cette partie du code lie les entrées.
        Scanner scanner = new Scanner( System.in );
        String nomFichier = demanderNomFichier( scanner );
        int nombreDeSyllabes = demanderNombreDeSyllabe( scanner );

        scanner.close();

        TexteSonore texteSonore = new TexteSonore( nomFichier );

        /**************************************************************************************************************/
        // placer vos actions ici :
        /**************************************************************************************************************/

        // Comparaison objet syllabe (works!)
//        SyllabeFrancais syllabe1 = texteSonore.get( 0 );
//        System.out.println( syllabe1 );
//        SyllabeFrancais syllabe2 = texteSonore.get( 4 );
//        System.out.println( syllabe2 );
//        System.out.println( syllabe1.equals( syllabe2 ) );
//
//        System.out.println( texteSonore.occurrenceTexteSonore( texteSonore ) );

//        texteSonore.listIterator(texteSonore);

        /**************************************************************************************************************/
        // cette partie du code affiche les résultats, modifier au besoin.
        /**************************************************************************************************************/
//        System.out.println( texteSonore );
//        System.out.println( nombreDeSyllabes );
    }
    /******************************************************************************************************************/
}
