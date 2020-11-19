package shapeUp;

import java.util.Scanner;

public interface StrategieJoueur {
    
	
    Carte piocherCarte(Pioche pioche);
    // Carte piocherCarte(StrategieMode strategie)
    
    void deplacerCarte(int ligneCase, int colonneCase, CarteJouable carte);

    void placerCarte(Carte carte, TapisDeJeu tapis);

    //CarteJouable definirCarteAJouer(Carte carte, Joueur joueur, StrategieMode modeDeJeu);
    
    public int choisirLigneCartePlacement();
	
	public int choisirColonneCartePlacement();
	
	public char choisirPlacementDeplacement();

}
