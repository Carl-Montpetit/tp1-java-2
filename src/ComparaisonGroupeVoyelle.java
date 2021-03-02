public class ComparaisonGroupeVoyelle {

    protected ComparaisonVoyelle duoVoyelleA = null;

    protected ComparaisonVoyelle duoVoyelleB = null;

    public ComparaisonGroupeVoyelle() {
    }

    /**
     * Construit deux groupes de deux voyelles
     * @param duoVoyelleA le 1er groupe de voyelle
     * @param duoVoyelleB le 2e groupe de voyelle
     */
    public ComparaisonGroupeVoyelle(ComparaisonVoyelle duoVoyelleA,
                                    ComparaisonVoyelle duoVoyelleB) {
        this.duoVoyelleA = duoVoyelleA;
        this.duoVoyelleB = duoVoyelleB;
    }

    public ComparaisonVoyelle getDuoVoyelleA() {
        return duoVoyelleA;
    }

    public ComparaisonVoyelle getDuoVoyelleB() {
        return duoVoyelleB;
    }

    /**
     * à testé
     * Cette méthode calcule la distance entre 2 groupes de consonnes
     * @return la distance entre 2 groupes de consonnes
     */
    public int distanceGroupeVoyelle(){
        int distance;
        int distance1 =
                getDuoVoyelleA().deuxVoyelles(getDuoVoyelleA().partieVoyelle());
        int distance2 =
                getDuoVoyelleB().deuxVoyelles(getDuoVoyelleB().partieVoyelle());
        distance = distance1 + distance2;
        return distance;
    }
}
