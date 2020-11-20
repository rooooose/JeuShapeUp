package shapeUp;

public interface StrategieJoueur {
    
	
    Carte piocherCarte(Pioche pioche);
    // Carte piocherCarte(StrategieMode strategie)
    
    void deplacerCarte(TapisDeJeu tapis);

    void placerCarte(Carte carte, TapisDeJeu tapis);

    Carte definirCarteAJouer(Joueur joueur, StrategieMode modeDeJeu);
    
    public int choisirLigneCarte();
	
	public int choisirColonneCarte();
	
	public void proposerDeplacement(TapisDeJeu tapis);

}
