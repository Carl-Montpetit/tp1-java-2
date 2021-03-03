#__Pour le Main.__
``` js
TexteSonore syllabesUniques = new TexteSonore();
Arraylist<Integer> occurence; = new Arraylist<>();
Arraylist<ComparaisonSyllabe> duoSyllabes = new Arraylist<>();
Arraylist<Integer> distances = new Arraylist<>();

// lancement de l'exception si il ya lieu
// if<=nombreDeSyllabes
do{
syllabesUniques = texteSonore.syllabeUnique(texteSonore);
occurence.removeAll();
// où on place les occurences dans le tableau
duoSyllabes.removeAll();
//insérer ComparaisonSyllabe dans Arraylist
for(int i = 0; i < syllabeUnique.size()-1; i++){
for(int j = i + 1; j < syllabeUnique.size(); j++){
duoSyllabes.add(new ComparaisonSyllabe(syllabeUnique.get(i), syllabeUnique.get(j));
}
}
distances.removeAll();
//insérer distances des syllabes dans Arraylist
for(int k = 0; k < duoSyllabes.size(); k++){
distances.add(duoSyllabes.get(k).distanceSyllabe());
}
//
// Réduction (modification texteSonore)
//

}while(syllabesUniques != nombreDeSyllabes+1 && distancesGroupesSyllabes.size() < 0);
sout(texteSonore);
``` 