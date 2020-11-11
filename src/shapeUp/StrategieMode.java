package shapeUp;


public interface StrategieMode {
    void distribuerCartes(Joueur joueur, Partie maPartie);

    CarteDeVictoire definirCarteVictoire(Carte carte, Joueur joueur);

    void voirCarteVictoire(Joueur joueur);

}
