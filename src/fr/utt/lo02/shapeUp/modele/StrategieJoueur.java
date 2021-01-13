package fr.utt.lo02.shapeUp.modele;

/**
 * Interface de la strat�gie des joueurs. Elle est impl�ment�e diff�remment par les joueurs de chaque type.
 * 
 * @see JoueurReel, JoueurVirtuel
 *
 * @author Math�a Z, Shir F
 */
public interface StrategieJoueur {
	
	/**
     * Permet au joueur de d�finir sa carte � placer, dans sa main.
     * @param joueur - lui-m�me
     * @param modeDeJeu - le mode de la partie en cours (Victoire Ennemie, Avanc�, Base)
     * @return la carte choisie pour �tre plac�e - Parmi celles pr�sentes dans la main du joueur
     * 
     * @exception NullPointerException - Si tout ou partie des param�tres sont null
     * 
     * @see JoueurReel
     * @see JoueurVirtuel
     */
    public Carte definirCarteAJouer(Joueur joueur, StrategieMode modeDeJeu);
    
    /**
     * Permet au joueur de choisir une ligne de destination pour une carte � placer ou d�placer, ou une ligne pour r�cup�rer une carte du tapis.
     * @param tapis
     * @return la ligne choisie, un entier
     * @exception NullPointerException - Si le tapis est null
     * 
     * @see JoueurReel
     * @see JoueurVirtuel
     */
    public int choisirLigneCarte(TapisDeJeu tapis);
	
    /**
     * Permet au joueur de choisir une colonne de destination pour une carte � placer ou d�placer, ou une colonne pour r�cup�rer une carte du tapis.
     * @param tapis
     * @return la colonne choisie, un entier
     * @exception NullPointerException - Si le tapis est null
     * 
     * @see JoueurReel
     * @see JoueurVirtuel
     */
	public int choisirColonneCarte(TapisDeJeu tapis);

}
