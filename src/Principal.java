import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * TP1 INF2120
 *
 * @nom Montpetit, Carl
 * @code_permanent MONC08069000
 * @nom Chagnon, Lysanne
 * @code_permanent CHAL65550003
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
    public static void main( String[] args ) throws ValeurInvalideSyllabeReductionException {
        // cette partie du code lie les entrées.
        Scanner scanner = new Scanner( System.in );
        String nomFichier = demanderNomFichier( scanner );
        int nombreDeSyllabes = demanderNombreDeSyllabe( scanner );

        scanner.close();

        TexteSonore texteSonore = new TexteSonore( nomFichier );

        /**************************************************************************************************************/
        // PLACER LES ACTIONS ICI :
        /**************************************************************************************************************/
        /**************************************************************************************************************/
        // VARIABLES
        /**************************************************************************************************************/
        TexteSonore syllabesUniques;
        ArrayList<Integer> occurrencesSyllabesUniques = new ArrayList<>();
        ArrayList<ComparaisonSyllabes> duosSyllabes = new ArrayList<>();
        Liste deuxSyllabes;
        ArrayList<Integer> distancesGroupesSyllabes = new ArrayList<>();
        ComparaisonSyllabes duoMinimum;
        SyllabeFrancais syllabe1;
        SyllabeFrancais syllabe2;
        int indexSyllabe1;
        int indexSyllabe2;
        int occurrenceSyllabe1;
        int occurrenceSyllabe2;
        final String erreurMessage = "\nLe nombre de syllabe cible doit être supérieur au nombre de syllabe dans le " +
                "texte pour la réduction! \nLa réduction est cancelée! \nVeuillez relancer le logiciel pour recommencer!";

        /**************************************************************************************************************/
        // RÉDUCTION ET TRANSFORMATION. (INCLUANT LE CALCUL DES OCCURRENCES)
        /**************************************************************************************************************/
        syllabesUniques = texteSonore.syllabeUnique( texteSonore );
//        lancement de l'exception si erreur
        if ( syllabesUniques.size() < nombreDeSyllabes ) {
            throw new ValeurInvalideSyllabeReductionException( erreurMessage );
        }

        do {
            syllabesUniques = texteSonore.syllabeUnique( texteSonore );

            occurrencesSyllabesUniques.clear();
            syllabesUniques.listeOccurrences( occurrencesSyllabesUniques, texteSonore );

            duosSyllabes.clear();
            syllabesUniques.liste2Syllabes( duosSyllabes );

            distancesGroupesSyllabes.clear();
            deuxSyllabes = new Liste( duosSyllabes );
            deuxSyllabes.listeDistancesSyllabes( distancesGroupesSyllabes );
//            Va chercher le duo avec la plus petite distance.
            duoMinimum = duosSyllabes.get( distancesGroupesSyllabes.indexOf( Collections.min( distancesGroupesSyllabes ) ) );
            syllabe1 = duoMinimum.getSyllabe1();
            syllabe2 = duoMinimum.getSyllabe2();
//            Va chercher l'index des syllabes dans le arraylist des occurrences.
            indexSyllabe1 = syllabesUniques.indexOf( syllabe1 );
            indexSyllabe2 = syllabesUniques.indexOf( syllabe2 );
//            Va chercher les occurrences des syllabes.
            occurrenceSyllabe1 = occurrencesSyllabesUniques.get( indexSyllabe1 );
            occurrenceSyllabe2 = occurrencesSyllabesUniques.get( indexSyllabe2 );

//            Si l'occurrence de la premiere syllabe est plus grande, la remplace dans le Texte sonore aux
//            emplacements en question
            if ( occurrenceSyllabe1 > occurrenceSyllabe2 ) {
                texteSonore.remplacementSyll2Pour1(syllabe1,syllabe2);

//            Si l'occurrence de la deuxième syllabe est plus grande ou égale, la remplace dans le Texte sonore aux
//            emplacements en question
            }else{
                texteSonore.remplacementSyll2Pour1(syllabe2,syllabe1);
            }
        } while ( syllabesUniques.size() != nombreDeSyllabes + 1 ) ;
            /**************************************************************************************************************/
            // SORTIE.
            /**************************************************************************************************************/
            System.out.println( texteSonore.toString() );

        }
    }
