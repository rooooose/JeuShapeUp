package fr.utt.lo02.shapeUp.modele;

import java.util.*;

import fr.utt.lo02.shapeUp.vue.Console;

/**
 * 
 * La classe abstraite Joueur représente un joueur du jeu ShapeUp. Il sera soit Réel, soit Virtuel
 * Il peut être actif (en train de jouer) ou non.
 * 
 * @see JoueurReel, JoueurVirtuel
 *
 * @author Mathéa Z, Shir F
 */
public abstract class Joueur extends Observable{
	
	/**
	 * Modélise la stratégie du Joueur. Les classes qui héritent de Joueur implémentent cette interface.
	 * Valeurs possibles : le joueur casté dans le type StrategieJoueur.
	 * Si strategie est null, il y aura l'exception NullPointerException, car Joueur utilise des méthodes de cette interface.
	 * @see StrategieJoueur
	 */
	private StrategieJoueur strategie;
	
	/**
	 * Modélise le nom du joueur. Un nom par défaut sera attribué si rien n'est entré par l'utilisateur (Joueur 1, Joueur 2, etc...)
	 * Si le nom est null, cela n'a aucune incidence sur le fonctionnement
	 */
    private String nom;
    
    /**
     * Permet de récupérer la ligne de la derniere carte placée par ce joueur dans l'interface graphique. 
     * Elle est réinitialisée à -1 à chaque tour de jeu
     * Valeurs possibles : (-1 ; dernière ligne du tapis)
     * 
     */
    private int ligCarteGUI = -1;
    
    /**
     * Permet de récupérer la ligne de la derniere carte à déplacer de ce joueur dans l'interface graphique. 
     * Elle est réinitialisée à -1 dès qu'on propose au joueur de déplacer une carte.
     * Valeurs possibles : (-1 ; dernière ligne du tapis)
     * 
     */
    private int ligCarteADepGUI = -1;
    
    /**
     * Permet de récupérer la ligne de la derniere carte déplacée par ce joueur dans l'interface graphique. 
     * Elle est réinitialisée à -1 dès que le joueur réel choisit une ligne pour sa carte.
     * Valeurs possibles : (-1 ; dernière ligne du tapis)
     * 
     */
    private int ligCarteDepGUI = -1;
    
    /**
     * Permet de savoir si le déplacement d'une carte est possible pour le joueur, càd si il peut sélectionner une carte à déplacer dans l'interface graphique.
     * 
     */
    private boolean deplacementPossible = false;
    
    /**
     * Permet de savoir si un déplacement est en cours
     * 
     */
    private boolean deplacementEnCours;
    
    /**
     * Permet de récupérer le numéro de carte choisi dans la main du joueur dans l'interface graphique, en mode Avancé. 
     * Elle est réinitialisée à -1 à chaque tour de jeu
     * Valeurs possibles : (-1 ; 2) => les cartes dans la main du joueur sont numérotées de 0 à 2.
     * 
     */
    private int numCarteGUI;
    
    /**
     * Modélise la dernière carte à placer ou à déplacer du joueur 
     * Valeurs possibles : une carte du jeu ShapeUp.
     * Si la carte est null, cela générera une exception NullPointerException lorsqu'on cliquera sur l'une des cases du tapis dans le GUI.
     * Et en jouant depuis la console, un objet null sera placé sur le tapis
     * @see Partie
     * 
     */
	private Carte carteAJouer = null;
	
	/**
	 * Modélise la carte de Victoire du joueur
	 * Valeurs possibles : une carte du jeu ShapeUp.
	 * Si elle est null, une exception sera générée lors du calcul du score, car toutes les cartes du tapis doivent être comparées à celle-ci.
	 * @see ScoreCouleur, ScoreForme, ScoreRemplissage
	 */
	private Carte carteDeVictoire;
	
	/**
	 * Modélise la main du joueur. Elle est composée de 1 carte en mode base et Victoire ennemie, et de 3 en mode avancé.
	 */
	private ArrayList<Carte> mainDuJoueur = new ArrayList<Carte>();
    
    /**
     * Getter de ligCarteDepGUI
     * @return la ligne de la carte déplacée dans le GUI
     */
    public int getLigCarteDepGUI() {
		return ligCarteDepGUI;
	}

    /**
     * Setter de ligCarteDepGUI
     * @param ligCarteDepGUI (la ligne de la carte déplacée dans le GUI)
     */
	public void setLigCarteDepGUI(int ligCarteDepGUI) {
		this.ligCarteDepGUI = ligCarteDepGUI;
	}
    
	/**
     * Getter de deplacementEnCours
     * @return le fait que le déplacement soit en cours ou non
     */
    public boolean isDeplacementEnCours() {
		return deplacementEnCours;
	}
    
    /**
     * Setter de deplacementEnCours
     * @param deplacementEnCours
     */
	public void setDeplacementEnCours(boolean deplacementEnCours) {
		this.deplacementEnCours = deplacementEnCours;
	}
	
	/**
	 * Getter de ligCarteADepGUI
	 * @return ligCarteADepGUI
	 */
	public int getLigCarteADepGUI() {
		return ligCarteADepGUI;
	}
	
	/**
	 * Setter de ligCarteADepGUI
	 * @param ligCarteADepGUI
	 */
	public void setLigCarteADepGUI(int ligCarteADepGUI) {
		this.ligCarteADepGUI = ligCarteADepGUI;
	}

	/**
	 * Getter de ligCarteGUI
	 * @return ligCarteUI
	 */
	public int getLigCarteGUI() {
		return ligCarteGUI;
	}

	/**
	 * Setter de ligCarteGUI
	 * @param ligCarteGUI
	 */
	public void setLigCarteGUI(int ligCarteGUI) {
		this.ligCarteGUI = ligCarteGUI;
	}
	
	/**
	 * Getter de deplacementPossible
	 * @return deplacementPossible
	 */
	public boolean isDeplacementPossible() {
		return deplacementPossible;
	}
	
	/**
	 * Setter de deplacementPossible
	 * @param deplacementPossible
	 */
	public void setDeplacementPossible(boolean deplacementPossible) {
		this.deplacementPossible = deplacementPossible;
	}
	
	/**
	 * Getter de numCarteGUI
	 * @return numCarteGUI
	 */
	public int getNumCarteGUI() {
		return numCarteGUI;
	}
	
	/**
	 * Setter de numCarteGUI
	 * @param numCarteGUI
	 */
	public void setNumCarteGUI(int numCarteGUI) {
		this.numCarteGUI = numCarteGUI;
	}
	
	/**
	 * Getter du nom du joueur
	 * @return le nom du joueur
	 */
    public String getNom() {
		return nom;
	}

    /**
     * Setter du nom du joueur
     * @param nom
     */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * Getter de la carte à jouer courante du joueur
	 * @return carteAJouer
	 */
	public Carte getCarteAJouer() {
		return carteAJouer;
	}
	
	/**
	 * Setter de la carte à jouer courante du joueur
	 * @param carteAJouer
	 */
	public void setCarteAJouer(Carte carteAJouer) {
		this.carteAJouer = carteAJouer;
	}
	
	/**
     * Getter de la carte de Victoire du joueur
     * @return carteDeVictoire
     */
    public Carte getCarteDeVictoire() {
		return carteDeVictoire;
	}
    
    /**
     * Setter de la carte de Victoire du joueur
     * @param carteDeVictoire
     */
	public void setCarteDeVictoire(Carte carteDeVictoire) {
		this.carteDeVictoire = carteDeVictoire;
	}
	
	/**
	 * Getter de la main du joueur
	 * @return la main du joueur
	 */
	public ArrayList<Carte> getMainDuJoueur() {
		return mainDuJoueur;
	}
	
	/**
	 * Setter de la main du joueur
	 * @param main
	 */
	public void setMain(ArrayList<Carte> main) {
		this.mainDuJoueur = main;
	}
	
	/**
	 * Instancie un joueur, en lui associant un nom et une stratégie
	 * @param nom
	 */
	Joueur(String nom) {
		
		this.setNom(nom);
		this.strategie = (StrategieJoueur) this;
	}


	public void jouer(Partie partie, TapisDeJeu tapis, Pioche pioche, StrategieMode modeDeJeu) {
		
		Carte cartePiochee;
		
		if(modeDeJeu instanceof StrategieDeBase || modeDeJeu instanceof StrategieVictoireEnnemie) {
			
			cartePiochee = this.piocherCarte(pioche);
			this.getMainDuJoueur().add(cartePiochee);
			this.notifyObservers(cartePiochee);
		}
		
    	if(tapis.getNbCartes()>1 && tapis.getNbCartes()<partie.getNbCartesJouables()) {
    		
    		boolean deplacementFait = this.proposerDeplacement(tapis, partie);

    		this.placerCarte(partie, tapis);
    		
    		if(!deplacementFait) {
    			this.proposerDeplacement(tapis, partie);
    		}
    		
    	} else {
    		this.placerCarte(partie, tapis);
    	}
    	
    	if(modeDeJeu instanceof StrategieAvance) {
    		
			cartePiochee = this.piocherCarte(pioche);
			this.getMainDuJoueur().add(cartePiochee);
			this.notifyObservers(cartePiochee);
		}
    }
	
	
	public Carte piocherCarte(Pioche pioche) {
    	
		if (pioche.getNbreDeCartes() < 0) {

			this.notifyObservers("Aucune carte disponible dans la pioche");			
			return null;
			}
		else {

	    	Carte cartePiochee = pioche.getPioche().poll();
	    	
	    	pioche.compterNbCartes(pioche.getNbreDeCartes() - 1);
	    	
	    	this.notifyObservers(this.getNom() + " a pioché sa carte :");	    	
	    	//System.out.println("Le joueur virtuel a pioché sa carte");
	    	return cartePiochee;
    	
		}
	}
	
	
	public abstract boolean proposerDeplacement(TapisDeJeu tapis, Partie partie);
	
	
	public void placerCarte(int lig, int col, Carte carteAJouer, TapisDeJeu tapis) {
		
    	int ligneCase;
    	int colonneCase;
    	this.notifyObservers(tapis);    	
    	
    	if(tapis.getNbCartes()>0) {
    		this.notifyObservers("Les cartes doivent être adjacentes.");    		
    	}
    	
    	do {
    		ligneCase = this.strategie.choisirLigneCarte(tapis);
        	colonneCase = this.strategie.choisirColonneCarte(tapis);
        	
        	if(!tapis.placementNormalPossible(ligneCase,colonneCase)) {
        		this.notifyObservers("Désolée, cette case n'est pas disponible");        		
        	}
        	if(ligneCase == lig && colonneCase == col) {
        		this.notifyObservers("La carte était déjà placée ici" + "\n");        		
        	}
        	
    	}while((!tapis.placementNormalPossible(ligneCase,colonneCase) && !tapis.decalagePossible(ligneCase, colonneCase)) || (ligneCase == lig && colonneCase == col));
    	
    	if(!tapis.caseRemplie(ligneCase,colonneCase)) {
    			
    			tapis.getContainer().get(ligneCase).set(colonneCase, carteAJouer);
    			
    	} else if(tapis.caseRemplie(ligneCase,colonneCase) && tapis.decalagePossible(ligneCase, colonneCase)){
    		
    			this.notifyObservers("Décalage du tapis...");    		
    		    tapis.decalerCartes(ligneCase, colonneCase);
    		    tapis.getContainer().get(ligneCase).set(colonneCase, carteAJouer);
    	}
    	this.notifyObservers(tapis);
    	tapis.setNbCartes(tapis.getNbCartes()+1);

    }
	
	
	public void placerCarte(Partie partie, TapisDeJeu tapis) {
		
    	int ligneCase;
    	int colonneCase = 0;
    	this.notifyObservers(tapis);    	
    	
    	if(tapis.getNbCartes()>0) {
    		this.notifyObservers("Les cartes doivent être adjacentes.");    		
    	}
    	this.notifyObservers("Carte(s) en main : " + this.getMainDuJoueur());    	
    	if(!this.deplacementEnCours) {
    		this.carteAJouer = this.strategie.definirCarteAJouer(this, partie.getModeDeJeu());
    	}
		
		partie.getModeDeJeu().voirCarteVictoire(partie, this);
    	
    	do {
    		ligneCase = this.strategie.choisirLigneCarte(tapis);
    		
    		if(this.ligCarteGUI == -1 && this.ligCarteDepGUI == -1) {
    			colonneCase = this.strategie.choisirColonneCarte(tapis);

	        	if(!tapis.placementNormalPossible(ligneCase,colonneCase) && !tapis.decalagePossible(ligneCase, colonneCase)) {
	        		this.notifyObservers("Désolée, cette case n'est pas disponible");          		
	        	}
    		}
        	
    	}while(!tapis.placementNormalPossible(ligneCase,colonneCase) && !tapis.decalagePossible(ligneCase, colonneCase) && ((this.ligCarteGUI == -1 && this.ligCarteDepGUI == -1)));
    	
    	if(this.ligCarteGUI == -1 && this.ligCarteDepGUI == -1) {
    		
    		if(!tapis.caseRemplie(ligneCase,colonneCase)) {
    			
        		tapis.getContainer().get(ligneCase).set(colonneCase, carteAJouer);
        			
        	} else if(tapis.caseRemplie(ligneCase,colonneCase) && tapis.decalagePossible(ligneCase, colonneCase)){

        			this.notifyObservers("Décalage du tapis...");      		
        		    tapis.decalerCartes(ligneCase, colonneCase);
        		    tapis.getContainer().get(ligneCase).set(colonneCase, carteAJouer);
        	}
        	this.notifyObservers(tapis);   
        	tapis.setNbCartes(tapis.getNbCartes()+1);
    	}

    	

    }
	
	public void placerCarteGUI(int ligneCase, int colonneCase, TapisDeJeu tapis, Carte carteAJouer) {  	
    	
    	if(!tapis.caseRemplie(ligneCase,colonneCase) && tapis.placementNormalPossible(ligneCase,colonneCase)) {
    			
    		tapis.getContainer().get(ligneCase).set(colonneCase, carteAJouer);
    			
    	} else if(tapis.caseRemplie(ligneCase,colonneCase) && tapis.decalagePossible(ligneCase, colonneCase)){

    			this.notifyObservers("Décalage du tapis...");      		
    		    tapis.decalerCartes(ligneCase, colonneCase);
    		    tapis.getContainer().get(ligneCase).set(colonneCase, carteAJouer);
    	}
    	this.notifyObservers(tapis);
    	tapis.setNbCartes(tapis.getNbCartes()+1);

    }
	
	public void deplacerCarte(TapisDeJeu tapis, Partie partie) {
    	
		this.deplacementEnCours = true;
    	int ligneCase;
    	int colonneCase = 0;
    	this.notifyObservers(tapis);       	
    	this.notifyObservers("Veuillez choisir une carte à déplacer :");       	

    	do {
    		
    		ligneCase = this.strategie.choisirLigneCarte(tapis);
    		//on ne peut plus choisir une carte à deplacer dans l'interface
    		this.setDeplacementPossible(false);
    		if(this.ligCarteADepGUI == -1) {
    			colonneCase = this.strategie.choisirColonneCarte(tapis);
            	
            	if(!tapis.caseRemplie(ligneCase,colonneCase)) {
            		this.notifyObservers("Désolée, cette case est vide");           		
            	}
    		}
        	
    	}while(!tapis.caseRemplie(ligneCase,colonneCase) && this.ligCarteADepGUI == -1);
    	
    	Carte carteADeplacer;
    	
    	if(this.ligCarteADepGUI == -1) {
    		
    		carteADeplacer = tapis.getContainer().get(ligneCase).get(colonneCase);
        	tapis.setNbCartes(tapis.getNbCartes()-1);
        	tapis.getContainer().get(ligneCase).set(colonneCase, null);
        	this.notifyObservers("Vous avez choisi de déplacer la carte " + carteADeplacer);
        	this.placerCarte(ligneCase, colonneCase, carteADeplacer, tapis);
    	
    	} else {
    		carteADeplacer = this.carteAJouer;
    		this.placerCarte(partie, tapis);
    	}

    	this.deplacementEnCours = false;

	}
	
	

	public void deplacerCarteGUI(int ligneCase, int colonneCase, TapisDeJeu tapis) {
    	
		this.carteAJouer = tapis.getContainer().get(ligneCase).get(colonneCase);
    	tapis.setNbCartes(tapis.getNbCartes()-1);
    	tapis.getContainer().get(ligneCase).set(colonneCase, null);
    	
    	this.notifyObservers("Vous avez choisi de déplacer la carte " + this.carteAJouer);   
    	this.notifyObservers(tapis); 

	}

	
}
