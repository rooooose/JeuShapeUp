package fr.utt.lo02.shapeUp.modele;

import java.util.*;

import fr.utt.lo02.shapeUp.vue.Console;

/**
 * 
 * La classe abstraite Joueur repr�sente un joueur du jeu ShapeUp. Il sera soit R�el, soit Virtuel
 * Il peut �tre actif (en train de jouer) ou non.
 * 
 * @see JoueurReel, JoueurVirtuel
 *
 * @author Math�a Z, Shir F
 */
public abstract class Joueur extends Observable{
	
	/**
	 * Mod�lise la strat�gie du Joueur. Les classes qui h�ritent de Joueur impl�mentent cette interface.
	 * Valeurs possibles : le joueur cast� dans le type StrategieJoueur.
	 * Si strategie est null, il y aura l'exception NullPointerException, car Joueur utilise des m�thodes de cette interface.
	 * @see StrategieJoueur
	 */
	private StrategieJoueur strategie;
	
	/**
	 * Mod�lise le nom du joueur. Un nom par d�faut sera attribu� si rien n'est entr� par l'utilisateur (Joueur 1, Joueur 2, etc...)
	 * Si le nom est null, cela n'a aucune incidence sur le fonctionnement
	 */
    private String nom;
    
    /**
     * Permet de r�cup�rer la ligne de la derniere carte plac�e par ce joueur dans l'interface graphique. 
     * Elle est r�initialis�e � -1 � chaque tour de jeu
     * Valeurs possibles : (-1 ; derni�re ligne du tapis)
     * 
     */
    private int ligCarteGUI = -1;
    
    /**
     * Permet de r�cup�rer la ligne de la derniere carte � d�placer de ce joueur dans l'interface graphique. 
     * Elle est r�initialis�e � -1 d�s qu'on propose au joueur de d�placer une carte.
     * Valeurs possibles : (-1 ; derni�re ligne du tapis)
     * 
     */
    private int ligCarteADepGUI = -1;
    
    /**
     * Permet de r�cup�rer la ligne de la derniere carte d�plac�e par ce joueur dans l'interface graphique. 
     * Elle est r�initialis�e � -1 d�s que le joueur r�el choisit une ligne pour sa carte.
     * Valeurs possibles : (-1 ; derni�re ligne du tapis)
     * 
     */
    private int ligCarteDepGUI = -1;
    
    /**
     * Permet de savoir si le d�placement d'une carte est possible pour le joueur, c�d si il peut s�lectionner une carte � d�placer dans l'interface graphique.
     * 
     */
    private boolean deplacementPossible = false;
    
    /**
     * Permet de savoir si un d�placement est en cours
     * 
     */
    private boolean deplacementEnCours;
    
    /**
     * Permet de r�cup�rer le num�ro de carte choisi dans la main du joueur dans l'interface graphique, en mode Avanc�. 
     * Elle est r�initialis�e � -1 � chaque tour de jeu
     * Valeurs possibles : (-1 ; 2) => les cartes dans la main du joueur sont num�rot�es de 0 � 2.
     * 
     */
    private int numCarteGUI;
    
    /**
     * Mod�lise la derni�re carte � placer ou � d�placer du joueur 
     * Valeurs possibles : une carte du jeu ShapeUp.
     * Si la carte est null, cela g�n�rera une exception NullPointerException lorsqu'on cliquera sur l'une des cases du tapis dans le GUI.
     * Et en jouant depuis la console, un objet null sera plac� sur le tapis
     * @see Partie
     * 
     */
	private Carte carteAJouer = null;
	
	/**
	 * Mod�lise la carte de Victoire du joueur
	 * Valeurs possibles : une carte du jeu ShapeUp.
	 * Si elle est null, une exception sera g�n�r�e lors du calcul du score, car toutes les cartes du tapis doivent �tre compar�es � celle-ci.
	 * @see ScoreCouleur, ScoreForme, ScoreRemplissage
	 */
	private Carte carteDeVictoire;
	
	/**
	 * Mod�lise la main du joueur. Elle est compos�e de 1 carte en mode base et Victoire ennemie, et de 3 en mode avanc�.
	 */
	private ArrayList<Carte> mainDuJoueur = new ArrayList<Carte>();
    
    /**
     * Getter de ligCarteDepGUI
     * @return la ligne de la carte d�plac�e dans le GUI
     */
    public int getLigCarteDepGUI() {
		return ligCarteDepGUI;
	}

    /**
     * Setter de ligCarteDepGUI
     * @param ligCarteDepGUI (la ligne de la carte d�plac�e dans le GUI)
     */
	public void setLigCarteDepGUI(int ligCarteDepGUI) {
		this.ligCarteDepGUI = ligCarteDepGUI;
	}
    
	/**
     * Getter de deplacementEnCours
     * @return le fait que le d�placement soit en cours ou non
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
	 * Getter de la carte � jouer courante du joueur
	 * @return carteAJouer
	 */
	public Carte getCarteAJouer() {
		return carteAJouer;
	}
	
	/**
	 * Setter de la carte � jouer courante du joueur
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
	 * Instancie un joueur, en lui associant un nom et une strat�gie
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
	    	
	    	this.notifyObservers(this.getNom() + " a pioch� sa carte :");	    	
	    	//System.out.println("Le joueur virtuel a pioch� sa carte");
	    	return cartePiochee;
    	
		}
	}
	
	
	public abstract boolean proposerDeplacement(TapisDeJeu tapis, Partie partie);
	
	
	public void placerCarte(int lig, int col, Carte carteAJouer, TapisDeJeu tapis) {
		
    	int ligneCase;
    	int colonneCase;
    	this.notifyObservers(tapis);    	
    	
    	if(tapis.getNbCartes()>0) {
    		this.notifyObservers("Les cartes doivent �tre adjacentes.");    		
    	}
    	
    	do {
    		ligneCase = this.strategie.choisirLigneCarte(tapis);
        	colonneCase = this.strategie.choisirColonneCarte(tapis);
        	
        	if(!tapis.placementNormalPossible(ligneCase,colonneCase)) {
        		this.notifyObservers("D�sol�e, cette case n'est pas disponible");        		
        	}
        	if(ligneCase == lig && colonneCase == col) {
        		this.notifyObservers("La carte �tait d�j� plac�e ici" + "\n");        		
        	}
        	
    	}while((!tapis.placementNormalPossible(ligneCase,colonneCase) && !tapis.decalagePossible(ligneCase, colonneCase)) || (ligneCase == lig && colonneCase == col));
    	
    	if(!tapis.caseRemplie(ligneCase,colonneCase)) {
    			
    			tapis.getContainer().get(ligneCase).set(colonneCase, carteAJouer);
    			
    	} else if(tapis.caseRemplie(ligneCase,colonneCase) && tapis.decalagePossible(ligneCase, colonneCase)){
    		
    			this.notifyObservers("D�calage du tapis...");    		
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
    		this.notifyObservers("Les cartes doivent �tre adjacentes.");    		
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
	        		this.notifyObservers("D�sol�e, cette case n'est pas disponible");          		
	        	}
    		}
        	
    	}while(!tapis.placementNormalPossible(ligneCase,colonneCase) && !tapis.decalagePossible(ligneCase, colonneCase) && ((this.ligCarteGUI == -1 && this.ligCarteDepGUI == -1)));
    	
    	if(this.ligCarteGUI == -1 && this.ligCarteDepGUI == -1) {
    		
    		if(!tapis.caseRemplie(ligneCase,colonneCase)) {
    			
        		tapis.getContainer().get(ligneCase).set(colonneCase, carteAJouer);
        			
        	} else if(tapis.caseRemplie(ligneCase,colonneCase) && tapis.decalagePossible(ligneCase, colonneCase)){

        			this.notifyObservers("D�calage du tapis...");      		
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

    			this.notifyObservers("D�calage du tapis...");      		
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
    	this.notifyObservers("Veuillez choisir une carte � d�placer :");       	

    	do {
    		
    		ligneCase = this.strategie.choisirLigneCarte(tapis);
    		//on ne peut plus choisir une carte � deplacer dans l'interface
    		this.setDeplacementPossible(false);
    		if(this.ligCarteADepGUI == -1) {
    			colonneCase = this.strategie.choisirColonneCarte(tapis);
            	
            	if(!tapis.caseRemplie(ligneCase,colonneCase)) {
            		this.notifyObservers("D�sol�e, cette case est vide");           		
            	}
    		}
        	
    	}while(!tapis.caseRemplie(ligneCase,colonneCase) && this.ligCarteADepGUI == -1);
    	
    	Carte carteADeplacer;
    	
    	if(this.ligCarteADepGUI == -1) {
    		
    		carteADeplacer = tapis.getContainer().get(ligneCase).get(colonneCase);
        	tapis.setNbCartes(tapis.getNbCartes()-1);
        	tapis.getContainer().get(ligneCase).set(colonneCase, null);
        	this.notifyObservers("Vous avez choisi de d�placer la carte " + carteADeplacer);
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
    	
    	this.notifyObservers("Vous avez choisi de d�placer la carte " + this.carteAJouer);   
    	this.notifyObservers(tapis); 

	}

	
}
