package shapeUp;


public interface StrategieMode {
    void distribuerCartes(Joueur joueur);

    CarteDeVictoire definirCarteVictoire(Carte carte, Joueur joueur);

    void voirCarteVictoire(Joueur joueur);

}
