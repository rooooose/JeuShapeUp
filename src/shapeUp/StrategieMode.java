package shapeUp;


public interface StrategieMode {

	
    void distribuerCartes(Partie maPartie);

    void definirCarteVictoire(CarteDeVictoire carteVictoire, Joueur joueur);

    void voirCarteVictoire(Joueur joueur);
    
    Pioche creerLaPiocheDeLaPartie (Partie maPartie);

}
