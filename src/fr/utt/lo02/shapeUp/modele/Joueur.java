package fr.utt.lo02.shapeUp.modele;

import java.util.*;

import fr.utt.lo02.shapeUp.vue.Console;

/**
 * 
 * La classe abstraite Joueur repr�sente un joueur du jeu ShapeUp. Il sera soit R�el, soit Virtuel
 * Il peut �tre actif (en train de jouer) ou non.
 * Il h�rite de la classe Observable pour permettre la mise � jour des vues.
 * 
 * @see JoueurReel
 * @see JoueurVirtuel
 * @see VuePartie
 * @see Console
 *
 * @author Math�a Z, Shir F
 */
public abstract class Joueur extends Observable{
	
	/**
	 * Mod�lise la strat�gie du Joueur. Les classes qui h�ritent de Joueur impl�mentent cette interface.
	 * Valeurs possibles : le joueur cast� dans le type StrategieJoueur.
	 * Si strategie est null, il y aura l'exception NullPointerException lors de l'appel aux m�thode de cette interface : definirCarteAJouer, choisirLigneCarte, choisirColonneCarte
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
     * @see ControleurPartie
     * 
     */
    private int ligCarteADepGUI = -1;
    
    /**
     * Permet de r�cup�rer la ligne de la derniere carte d�plac�e par ce joueur dans l'interface graphique. 
     * Elle est r�initialis�e � -1 d�s que le joueur r�el choisit une ligne pour sa carte.
     * Valeurs possibles : (-1 ; derni�re ligne du tapis)
     * @see ControleurPartie
     */
    private int ligCarteDepGUI = -1;
    
    /**
     * Permet de savoir si le d�placement d'une carte est possible pour le joueur, c�d si il peut s�lectionner une carte � d�placer dans l'interface graphique.
     * @see ControleurPartie
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
     * @see ControleurPartie
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

	/**
	 * Permet au joueur de jouer son tour de jeu. Le joueur passe alors � l'�tat en jeu.
	 * 
	 * Cette m�thode v�rifie � quel mode de jeu appartient la partie, pour d�terminer si le joueur doit piocher avant ou apr�s avoir jou� sa carte.
	 * S'il y a au moins 2 cartes sur le tapis, on peut proposer un d�placement avant et/ou apr�s le placement d'une carte, sinon on peut simplement placer une nouvelle carte.
	 * @param partie - la partie en cours
	 * @param tapis - au choix parmi les formes disponibles
	 * @param pioche - la pioche de la partie
	 * @param modeDeJeu au choix entre StrategieAvancee, StrategieVictoireEnnemie et StrategieDeBase
	 * 
	 * @exception NullPointerException - Si tout ou partie de ces param�tres sont null
	 * 
	 * @see Partie, TapisDeJeu, Pioche, StrategieMode, StrategieAvancee, StrategieVictoireEnnemie, StrategieDeBase
	 * 
	 * 
	 */
	public void jouer(Partie partie, TapisDeJeu tapis, Pioche pioche, StrategieMode modeDeJeu) {
		
		Carte cartePiochee;
		
		if(modeDeJeu instanceof StrategieDeBase || modeDeJeu instanceof StrategieVictoireEnnemie) {
			
			cartePiochee = this.piocherCarte(pioche);
			this.getMainDuJoueur().add(cartePiochee);
			this.notifyObservers(cartePiochee);
		}
		
    	if(tapis.getNbCartes()>1) {
    		
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
	
	/**
	 * Permet au joueur de piocher une carte.
	 * 
	 * Si aucune carte n'est disponible dans la pioche, un message est g�n�r�. 
	 * Sinon on r�cup�re la carte en haut de la pioche et on d�cr�mente le nombre de cartes disponibles dans la pioche.
	 * 
	 * @param pioche - la pioche de la partie
	 * @return la carte pioch�e. Un objet de type Carte parmi celles cr��es au d�but de la partie
	 * @exception NullPointerException - Si la pioche est null
	 * 
	 * @see Pioche
	 */
	public Carte piocherCarte(Pioche pioche) {
    	
		if (pioche.getNbreDeCartes() < 0) {

			this.notifyObservers("Aucune carte disponible dans la pioche");			
			return null;
			}
		else {

	    	Carte cartePiochee = pioche.getPioche().poll();
	    	
	    	pioche.compterNbCartes(pioche.getNbreDeCartes() - 1);
	    	
	    	this.notifyObservers(this.getNom() + " a pioch� sa carte :");	    	
	    	return cartePiochee;
    	
		}
	}
	
	/**
	 * M�thode d�finie dans les classes filles de joueur
	 * @param tapis
	 * @param partie
	 * @return true/false
	 * @see JoueurReel
	 * @see JoueurVirtuel
	 */
	public abstract boolean proposerDeplacement(TapisDeJeu tapis, Partie partie);
	
	/**
	 * Place la carte � d�placer dans la console.
	 * 
	 * Apr�s avoir affich� l'�tat actuel du tapis, le programme demande au joueur de choisir une ligne et une colonne pour le d�placement de la carte, tant qu'il n'a pas entr� de valeur valide.
	 * Les coordonn�es sont valides si un placement normal est possible ici (voir placementNormalPossible - TapisDeJeu), si un d�calage est possible, et si elles sont diff�rentes de l'emplacement pr�c�dent de la carte.
	 * Si la case est vide, on place la carte � l'endroit voulu dans l'ArrayList du tapis, sinon on d�cale d'abord les cartes pr�sentes
	 * Pour finir, on affiche le r�sultat de l'emplacement et on incr�mente le nombre de cartes du tapis.
	 * 
	 * @param lig - la ligne � laquelle appartenait pr�c�demment la carte � d�placer (0; nombre de lignes du tapis -1)
	 * @param col - la colonne � laquelle appartenait pr�c�demment la carte � d�placer (0; nombre de colonnes du tapis -1)
	 * @param carteAJouer - la carte � d�placer. Si elle est null, un objet null sera plac� sur le tapis.
	 * @param tapis - le tapis de jeu de la partie
	 * 
	 * @exception NullPointerException - Si le tapis est null
	 * 
	 * 
	 * @see TapisDeJeu
	 * @see Partie
	 * 
	 * 
	 */
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
	
	/**
	 * Place une nouvelle carte, ou la carte � d�placer si on joue dans le GUI.
	 * 
	 * Apr�s avoir affich� l'�tat actuel du tapis, la carte � jouer est d�finie parmi celle(s) de la main du joueur (si un d�placement n'est pas en cours), et affiche la carte de Victoire du joueur. 
	 * le programme demande au joueur de choisir une ligne et une colonne pour le d�placement de la carte, tant qu'il n'a pas entr� de valeur valide.
	 * Une colonne est demand�e seulement si le d�placement ou placement d'une carte n'a pas �t� commenc� dans le GUI.
	 * Les coordonn�es sont valides si un placement normal est possible ici (voir placementNormalPossible - TapisDeJeu) ou si un d�calage est possible
	 * Ce qui suit est fait uniquement si le placement ou d�placement d'une carte n'a pas deja �t� fait dans le GUI.
	 * Si la case est vide, on place la carte � l'endroit voulu dans l'ArrayList du tapis, sinon on d�cale d'abord les cartes pr�sentes
	 * Pour finir, on affiche le r�sultat de l'emplacement et on incr�mente le nombre de cartes du tapis.
	 * 
	 * @param partie
	 * @param tapis - le tapis de jeu de la partie
	 * 
	 * @exception NullPointerException - Si tout ou partie des param�tres sont null

	 * @see TapisDeJeu
	 * @see Partie
	 * 
	 * 
	 */
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
	
	/**
	 * Place une carte dans l'interface graphique.
	 * 
	 * Si la case est vide, on place la carte � l'endroit voulu dans l'ArrayList du tapis, sinon on d�cale d'abord les cartes pr�sentes
	 * Pour finir, on affiche le r�sultat de l'emplacement et on incr�mente le nombre de cartes du tapis.
	 * 
	 * @param ligneCase la ligne de destination de la carte (0; nombre de lignes du tapis -1)
	 * @param colonneCase la colonne de destination de la carte (0; nombre de colonnes du tapis -1)
	 * @param tapis
	 * @param carteAJouer - la carte � placer. Si elle est null, un objet null sera plac� sur le tapis. NullPointerException sera g�n�r�e dans ControleurPartie
	 * 
	 * @see ControleurPartie
	 * @see TapisDeJeu
	 * @see Partie
	 * @exception NullPointerException - si le tapis est null
	 * 
	 * 
	 */
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
	
	/**
	 * Permet de choisir une carte � d�placer dans la console.
	 * 
	 * Une ligne et une colonne est demand�e au joueur tant que la case de cet emplacement est vide (et que rien n'a �t� choisi dans l'interface).
	 * Si aucune carte n'a �t� choisie dans l'interface, on r�cup�re la carte de cet emplacement, on d�cr�mente le nombre de cartes du tapis, et on la remplace par null. Puis on appelle placerCarte().
	 * Si la carte � d�placer a �t� choisie dans l'interface, alors la carteADeplacer est la carteAJouer du joueur.
	 * 
	 * @param partie
	 * @param tapis - le tapis de jeu de la partie
	 * 
	 * @exception NullPointerException - Si tout ou partie des param�tres sont null
	 * 
	 * @see TapisDeJeu
	 * @see Partie
	 * 
	 * 
	 */
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

	
	/**
	 * Permet de choisir une carte � d�placer dans l'interface graphique.
	 * On r�cup�re alors la carte du tapis � l'emplacement ligneCase-colonneCase, on d�cr�mente le nombre de cartes du tapis, et on la remplace par null. Puis on appelle placerCarte().
	 * On affiche le tapis et un message apr�s en avoir retir� la carte
	 * 
	 * @param ligneCase - la ligne de la carte � d�placer (0; nombre de lignes du tapis -1)
	 * @param colonneCase - la colonne de la carte � d�placer (0; nombre de colonnes du tapis -1) 
	 * @param tapis - le tapis de jeu de la partie
	 * 
	 * @exception NullPointerException - Si le tapis est null
	 * 
	 * @see TapisDeJeu
	 * @see ControleurPartie 
	 * 
	 * 
	 */
	public void deplacerCarteGUI(int ligneCase, int colonneCase, TapisDeJeu tapis) {
    	
		this.carteAJouer = tapis.getContainer().get(ligneCase).get(colonneCase);
    	tapis.setNbCartes(tapis.getNbCartes()-1);
    	tapis.getContainer().get(ligneCase).set(colonneCase, null);
    	
    	this.notifyObservers("Vous avez choisi de d�placer la carte " + this.carteAJouer);   
    	this.notifyObservers(tapis); 

	}

	
}
