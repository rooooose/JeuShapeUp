package shapeUp;


public interface StrategieJoueur {
    
	
    Carte piocherCarte(Pioche pioche);
    // Carte piocherCarte(StrategieMode strategie)
    
    void deplacerCarte(int ligneCase, int colonneCase, CarteJouable carte);

    void placerCarte(int ligneCase, int colonneCase, CarteJouable carte, TapisDeJeu tapis);

    CarteJouable definirCarteAJouer(Carte carte, StrategieMode modeDeJeu);

}
