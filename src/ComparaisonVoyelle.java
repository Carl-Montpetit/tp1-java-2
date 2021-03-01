import java.util.regex.Pattern;

public class ComparaisonVoyelle {

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
     *          .  Ne doit pas être {@code null}.
     */
    public ComparaisonVoyelle(API_Voyelle voyelleA) {
        this.voyelleA = voyelleA;
    }


    /**
     * Construit un groupe avec deux voyelle.
     * @param voyelleA la 1re voyelle
     * @param voyelleB la 2e voyelle
     */
    public ComparaisonVoyelle(API_Voyelle voyelleB,API_Voyelle voyelleA) {
        this.voyelleA = voyelleA;
        this.voyelleB = voyelleB;
    }

    public API_Voyelle getVoyelleA() {
        return voyelleA;
    }

    public API_Voyelle getVoyelleB() {
        return voyelleB;
    }

    /**
     * à testé
     * retourne la distance de 2 consonnes avec 3 caractéristiques
     * @return la distance pour les 3 caractéristiques
     */
    public int partieVoyelle(){
        int distance = 0;
        if((getVoyelleA()==null && getVoyelleB()==null) ||
                (getVoyelleA()==null || getVoyelleB()==null)){
            distance = 0;
        }else {
            if ((!getVoyelleA().estArrondi()==getVoyelleB().estArrondi())) {
                distance++;
            }
            if ((!getVoyelleA().estOuverte()==getVoyelleB().estOuverte())) {
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
    public int deuxVoyelles (int distance1) {
        int distance;
        if (getVoyelleA()==null && getVoyelleB()==null){
            distance = 0;
        }else if (getVoyelleA()==null || getVoyelleB()==null) {
            distance = 4;
        } else {
            distance = distance1;
            if ((!getVoyelleA().estArriere()==getVoyelleB().estArriere())) {
                distance++;
            }
            if ((!getVoyelleA().estHaut()==getVoyelleB().estHaut())) {
                distance++;
            }
        }
        return distance;
    }
}
