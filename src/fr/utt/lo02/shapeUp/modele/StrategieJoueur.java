package fr.utt.lo02.shapeUp.modele;

public interface StrategieJoueur {
    
	
//    public Carte piocherCarte(Pioche pioche);

    public Carte definirCarteAJouer(Joueur joueur, StrategieMode modeDeJeu);
    
    public int choisirLigneCarte(TapisDeJeu tapis);
	
	public int choisirColonneCarte(TapisDeJeu tapis);
	
//	public boolean proposerDeplacement(TapisDeJeu tapis);
//    
//    public void deplacerCarte(TapisDeJeu tapis);
//    
//    public void placerCarte(Partie partie, TapisDeJeu tapis);
//    
//    public void placerCarte(int lig, int col, Carte carteAJouer, TapisDeJeu tapis);
//    
//    public void jouer(Partie partie, TapisDeJeu tapis, Pioche pioche, StrategieMode modeDeJeu);

}
