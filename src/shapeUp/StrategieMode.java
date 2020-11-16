package shapeUp;


public interface StrategieMode {

	
    void distribuerCartes(Joueur joueur, Partie maPartie);

    void definirCarteVictoire(CarteDeVictoire carteVictoire, Joueur joueur);

    void voirCarteVictoire(Joueur joueur);

    // void Pioche getPiocheDeLaPartie();
}
