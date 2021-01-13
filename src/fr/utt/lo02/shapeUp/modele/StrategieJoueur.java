package fr.utt.lo02.shapeUp.modele;

/**
 * Interface de la stratégie des joueurs. Elle est implémentée différemment par les joueurs de chaque type.
 * 
 * @see JoueurReel, JoueurVirtuel
 *
 * @author Mathéa Z, Shir F
 */
public interface StrategieJoueur {
	
	/**
     * Permet au joueur de définir sa carte à placer, dans sa main.
     * @param joueur - lui-même
     * @param modeDeJeu - le mode de la partie en cours (Victoire Ennemie, Avancé, Base)
     * @return la carte choisie pour être placée - Parmi celles présentes dans la main du joueur
     * 
     * @exception NullPointerException - Si tout ou partie des paramètres sont null
     * 
     * @see JoueurReel
     * @see JoueurVirtuel
     */
    public Carte definirCarteAJouer(Joueur joueur, StrategieMode modeDeJeu);
    
    /**
     * Permet au joueur de choisir une ligne de destination pour une carte à placer ou déplacer, ou une ligne pour récupérer une carte du tapis.
     * @param tapis
     * @return la ligne choisie, un entier
     * @exception NullPointerException - Si le tapis est null
     * 
     * @see JoueurReel
     * @see JoueurVirtuel
     */
    public int choisirLigneCarte(TapisDeJeu tapis);
	
    /**
     * Permet au joueur de choisir une colonne de destination pour une carte à placer ou déplacer, ou une colonne pour récupérer une carte du tapis.
     * @param tapis
     * @return la colonne choisie, un entier
     * @exception NullPointerException - Si le tapis est null
     * 
     * @see JoueurReel
     * @see JoueurVirtuel
     */
	public int choisirColonneCarte(TapisDeJeu tapis);

}
