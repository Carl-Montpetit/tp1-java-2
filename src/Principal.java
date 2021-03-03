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
        // CALCUL DES OCCURRENCES (works!)
        /**************************************************************************************************************/
//        System.out.println( "Le texte sonore est : " + texteSonore + "\n" );
//        System.out.println( "Le nombre de sylabes dans le texte est de : " + texteSonore.size() + "\n" );
//        TexteSonore syllabesUniques = new TexteSonore();
//        syllabesUniques = texteSonore.syllabeUnique( texteSonore );
//        System.out.println( "Les syllabes unique sont : " + syllabesUniques + "\n" );
//
//        ArrayList<Integer> occurrences = new ArrayList<Integer>();
//
//        for ( int i = 0; i < syllabesUniques.size(); i++ ) {
//            System.out.println( syllabesUniques.get( i ) + " : " + "Occurence(s) = " +
//                    texteSonore.occurrenceSyllabeDansTexteSonore( texteSonore, syllabesUniques.get( i ) ) + "\n" );
//            occurrences.add( texteSonore.occurrenceSyllabeDansTexteSonore( texteSonore, syllabesUniques.get( i ) ) );
//        }
//        System.out.println( "Les occurrences sont : " + occurrences.toString() );
        /**************************************************************************************************************/
        //Informations sur les syllabes (console).
        /**************************************************************************************************************/
//        for ( int i = 0; i < syllabesUniques.size(); i++ ) {
//            System.out.println( "Les charactéristiques de " + syllabesUniques.get( i ) + " sont : " );
//            System.out.println( "Attack : " + syllabesUniques.get( i ).getAttaque() );
//            System.out.println( "Coda : " + syllabesUniques.get( i ).getCoda() );
//            System.out.println( "Noyau : " + syllabesUniques.get( i ).getNoyau() + "\n" );
//        }
        /**************************************************************************************************************/
        // DISTANCE SONORE.
        /**************************************************************************************************************/
        // Distance entre deux phonèmes de consonne. (TESTS)
        /**************************************************************************************************************/
//        ComparaisonConsonne test =
//                new ComparaisonConsonne( syllabesUniques.get( 0 ).getAttaque
//                ().getConsonne1(),
//                        syllabesUniques.get( 1 ).getAttaque().getConsonne1() );
//        System.out.println( test.toString() );
//        System.out.println( test.distanceDeuxConsonnesPartieDeux( test.distanceDeuxConsonnesPartieUn() ) + "\n" );

        /**************************************************************************************************************/
        // Distance entre deux phonèmes de voyelles. (TESTS)
        /**************************************************************************************************************/
//        ComparaisonVoyelle test2 =
//                new ComparaisonVoyelle( syllabesUniques.get( 0 ).getNoyau()
//                .getVoyelle(),
//                        syllabesUniques.get( 0 ).getNoyau().getSemiVoyelle() );
//        System.out.println( test2.toString() );
//        System.out.println( test2.distanceDeuxVoyellesPartieDeux( test2.distanceDeuxVoyellesPartieUn() ) + "\n" );

        /**************************************************************************************************************/
        // Distance entre deux groupes de consonnes. (TESTS)
        /**************************************************************************************************************/
//      TODO ça fonctionne!!!!

//        ComparaisonConsonne test3 = new ComparaisonConsonne(syllabesUniques.get( 1 ).getAttaque().getConsonne1(),
//                syllabesUniques.get( 1 ).getAttaque().getConsonne2() );
//        System.out.println( test3.toString() );
//        System.out.println( test3.distanceDeuxConsonnesPartieDeux( test3.distanceDeuxConsonnesPartieUn() ) + "\n" );
//
//        ComparaisonGroupeConsonne test7 = new ComparaisonGroupeConsonne( test,
//                test3 );
//        System.out.println( test7.toString() );
//        System.out.println( test7.distanceGroupeConsonne() + "\n" );


        /**************************************************************************************************************/
        // Distance entre deux groupes de voyelles. (TESTS)
        /**************************************************************************************************************/
//      TODO ça fonctionne!!!!

//        ComparaisonVoyelle test4 = new ComparaisonVoyelle( syllabesUniques
//        .get( 1 ).getNoyau().getVoyelle(),
//                syllabesUniques.get( 1 ).getNoyau().getSemiVoyelle() );
//        System.out.println( test4.toString() );
//        System.out.println( test4.distanceDeuxVoyellesPartieDeux( test4.distanceDeuxVoyellesPartieUn() ) );
//
//        ComparaisonGroupeVoyelle test6 = new ComparaisonGroupeVoyelle( test2,
//                test4 );
//        System.out.println( test6.toString() );
//        System.out.println( test6.distanceGroupeVoyelle() );
        /**************************************************************************************************************/
        // Distance entre deux syllabes. (TESTS)
        /**************************************************************************************************************/
//        ComparaisonSyllabes test5 = new ComparaisonSyllabes( syllabesUniques.get(1), syllabesUniques.get(2));
//        System.out.println( test5.toString() );
//        System.out.println( test5.distanceSyllabe() );
        /**************************************************************************************************************/
        // RÉDUCTION ET TRANSFORMATION.
        /**************************************************************************************************************/
        // (tests)
        /**************************************************************************************************************/
        TexteSonore syllabesUniques = new TexteSonore();
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
        // AFFICHAGE INITIAL.
        /**************************************************************************************************************/
        System.out.println( "Le texte sonore est : " + texteSonore + "\n" );
        System.out.println( "Le nombre de sylabes dans le texte est de : " + texteSonore.size() + "\n" );
        syllabesUniques = texteSonore.syllabeUnique( texteSonore );
        System.out.println( "Les syllabes uniques dans le texte sont : " + syllabesUniques.toString() + "\n" );
        /**************************************************************************************************************/
        // RÉDUCTION ET TRANSFORMATION. (INCLUANT LE CALCUL DES OCCURRENCES)
        /**************************************************************************************************************/
//        lancement de l'exception si erreur
        if ( texteSonore.size() < nombreDeSyllabes ) {
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

//            TODO I know, va falloir réduire ce bordel en méthode! ☠️
//            Si l'occurrence de la premiere syllabe est plus grande la remplace dans le Texte sonore aux emplacements en question
            if ( occurrenceSyllabe1 > occurrenceSyllabe2 ) {
                for ( int i = 0; i < texteSonore.size(); i++ ) {
                    if ( texteSonore.get( i ).equals( syllabe2 ) ) {
                        texteSonore.set( i, syllabe1 );
                    }
                }
//            Si l'occurrence de la deuxième syllabe est plus grande la remplace dans le Texte sonore aux emplacements en question
            }
            if ( occurrenceSyllabe1 < occurrenceSyllabe2 ) {
                for ( int i = 0; i < texteSonore.size(); i++ ) {
                    if (texteSonore.get( i ).equals( syllabe2 )) {
                        texteSonore.set( i, syllabe2 );
                    }
                }
            }
//            Supprime le dernier élément du texte sonore pour réduire la taille de 1
            if ( texteSonore.size() != nombreDeSyllabes + 1 ) {
                texteSonore.remove( texteSonore.size() - 1);
            }
//            TODO HELP j'arrive pas a faire tourner la boucle while! 👽
        } while ( texteSonore.size() != nombreDeSyllabes + 1 && distancesGroupesSyllabes.size() < 0 ) ;
//            TODO si on trouve pas je vais m'amuser avec le debugger pour résoudre ca. (probablement une niaserie 💩)
            /**************************************************************************************************************/
            // SORTIE.
            /**************************************************************************************************************/
            System.out.println( "Les occurrences (selon les indices correspondant aux syllabes uniques) sont : "
                    + occurrencesSyllabesUniques.toString() + "\n" );
            System.out.println( "Les groupes de syllabes possible dans le texte sont : " + duosSyllabes.toString() + "\n" );
            System.out.println( "Les distances des groupes de syllabes possibles (selon les indices correspondant) sont : "
                    + distancesGroupesSyllabes.toString() + "\n" );
            System.out.println( "La distance la plus petite est : "
                    + Collections.min( distancesGroupesSyllabes ) + "\n" );
            System.out.println( "Le groupe de syllabe ayant la plus petite distance est : "
                    + duosSyllabes.get( distancesGroupesSyllabes.indexOf( Collections.min( distancesGroupesSyllabes ) ) ) + "\n" );
            System.out.println( "L'indice du groupe de syllabe ayant la plus petite distance est : "
                    + duosSyllabes.get( distancesGroupesSyllabes.indexOf( Collections.min( distancesGroupesSyllabes ) ) ) + "\n" );
            System.out.println( "La syllabe (de la pair) ayant l'occurence la plus grande : "
                    + duosSyllabes.get( distancesGroupesSyllabes.indexOf( Collections.min( distancesGroupesSyllabes ) ) ).getSyllabe1() + "\n" );
            System.out.println( "Le nombre de syllabe cible était de : " + nombreDeSyllabes );
            System.out.println( "Le nombre de syllabe après la réduction est de : " + texteSonore.size() );
            System.out.println( "Le texte sonore après la réduction est : " + texteSonore.toString() );
//            TODO ON A PRESQUE FINIT!!! OMG!!! 👌🏻🤌🏻💪🏻🍾🎊🎉

        }
    }
