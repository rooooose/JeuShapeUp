package shapeUp;

public interface StrategieJoueur {
    
	
    public Carte piocherCarte(Pioche pioche);

    public Carte definirCarteAJouer(Joueur joueur, StrategieMode modeDeJeu);
    
    public int choisirLigneCarte(TapisDeJeu tapis);
	
	public int choisirColonneCarte(TapisDeJeu tapis);
	
	public boolean proposerDeplacement(TapisDeJeu tapis, Joueur joueur);

}
