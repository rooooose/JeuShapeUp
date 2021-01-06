package shapeUp;

import java.util.*;

import vue.Console;

public abstract class Joueur extends Observable{
	
	private StrategieJoueur strategie;
    private String nom;
    
    //permet de r�cup�rer la ligne de la derniere carte plac�e dans l'interface graphique
    // initialis�e dans Partie - tourDeJeu()
    private int ligCarteGUI;
    // initialis�e dans Joueur - proposerDeplacement()
    private int ligCarteADepGUI;
    // initialis�e dans JoueurReel - choisirLigneCarte()
    private int ligCarteDepGUI;
    
    private boolean deplacementPossible = false;
    private boolean deplacementEnCours;
    
    public int getLigCarteDepGUI() {
		return ligCarteDepGUI;
	}

	public void setLigCarteDepGUI(int ligCarteDepGUI) {
		this.ligCarteDepGUI = ligCarteDepGUI;
	}
    
    public boolean isDeplacementEnCours() {
		return deplacementEnCours;
	}

	public void setDeplacementEnCours(boolean deplacementEnCours) {
		this.deplacementEnCours = deplacementEnCours;
	}
	
	public int getLigCarteADepGUI() {
		return ligCarteADepGUI;
	}

	public void setLigCarteADepGUI(int ligCarteADepGUI) {
		this.ligCarteADepGUI = ligCarteADepGUI;
	}

    
	public int getLigCarteGUI() {
		return ligCarteGUI;
	}

	public void setLigCarteGUI(int ligCarteGUI) {
		this.ligCarteGUI = ligCarteGUI;
	}
	
	public boolean isDeplacementPossible() {
		return deplacementPossible;
	}

	public void setDeplacementPossible(boolean deplacementPossible) {
		this.deplacementPossible = deplacementPossible;
	}
    
	private int numCarteGUI;
	
	public int getNumCarteGUI() {
		return numCarteGUI;
	}

	public void setNumCarteGUI(int numCarteGUI) {
		this.numCarteGUI = numCarteGUI;
	}

    public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	Joueur(String nom) {
		this.setNom(nom);
		//this.addObserver(console);
		
//	    if(this instanceof JoueurReel ) {
		this.strategie = (StrategieJoueur) this;
//	    	
//	    } else if (this instanceof JoueurVirtuel) {
//	    	this.strategie = (StrategieJoueur) this;
//	    }
	    
	}

	//private String score;
	private Carte carteAJouer = null;
	
	public Carte getCarteAJouer() {
		return carteAJouer;
	}

	public void setCarteAJouer(Carte carteAJouer) {
		this.carteAJouer = carteAJouer;
	}
	
	private Carte carteDeVictoire;
    public Carte getCarteDeVictoire() {
		return carteDeVictoire;
	}

	public void setCarteDeVictoire(Carte carteDeVictoire) {
		this.carteDeVictoire = carteDeVictoire;
	}
	
	//Compos�e de plusieurs cartes en mode avanc� ==> List
	private ArrayList<Carte> mainDuJoueur = new ArrayList<Carte>();


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
	

		
    public ArrayList<Carte> getMainDuJoueur() {
		return mainDuJoueur;
	}

	public void setMain(ArrayList<Carte> main) {
		this.mainDuJoueur = main;
	}

	//public abstract Carte piocherCarte(Pioche pioche);
	
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
  
//	public abstract void deplacerCarte(TapisDeJeu tapis);
//  
//	public abstract void placerCarte(Partie partie, TapisDeJeu tapis);
//  
//	public abstract void placerCarte(int lig, int col, Carte carteAJouer, TapisDeJeu tapis);
  
	
	public void placerCarte(int lig, int col, Carte carteAJouer, TapisDeJeu tapis) {
		
    	int ligneCase;
    	int colonneCase;
    	this.notifyObservers(tapis);    	
    	//System.out.println(tapis);
    	
    	if(tapis.getNbCartes()>0) {
    		this.notifyObservers("Les cartes doivent �tre adjacentes.");    		
    		//System.out.println("Les cartes doivent �tre adjacentes.");
    	}
    	
    	do {
    		ligneCase = this.strategie.choisirLigneCarte(tapis);
        	colonneCase = this.strategie.choisirColonneCarte(tapis);
        	
        	if(!tapis.placementNormalPossible(ligneCase,colonneCase)) {
        		this.notifyObservers("D�sol�e, cette case n'est pas disponible");        		
        		//System.out.print("D�sol�e, cette case n'est pas disponible" + "\n");
        	}
        	if(ligneCase == lig && colonneCase == col) {
        		this.notifyObservers("La carte �tait d�j� plac�e ici" + "\n");        		
        		//System.out.print("La carte �tait d�j� plac�e ici" + "\n");
        	}
        	
    	}while((!tapis.placementNormalPossible(ligneCase,colonneCase) && !tapis.decalagePossible(ligneCase, colonneCase)) || (ligneCase == lig && colonneCase == col));
    	
    	if(!tapis.caseRemplie(ligneCase,colonneCase)) {
    			
    			tapis.getContainer().get(ligneCase).set(colonneCase, carteAJouer);
    			
    	} else if(tapis.caseRemplie(ligneCase,colonneCase) && tapis.decalagePossible(ligneCase, colonneCase)){
    		
    			this.notifyObservers("D�calage du tapis...");    		
    			//System.out.println("D�calage du tapis...");
    		    tapis.decalerCartes(ligneCase, colonneCase);
    		    tapis.getContainer().get(ligneCase).set(colonneCase, carteAJouer);
    	}
    	this.notifyObservers(tapis);
    	//System.out.println(tapis);
    	tapis.setNbCartes(tapis.getNbCartes()+1);

    }
	
	
	public void placerCarte(Partie partie, TapisDeJeu tapis) {
		
    	int ligneCase;
    	int colonneCase = 0;
    	//Carte carteAJouer;
    	this.notifyObservers(tapis);    	
    	//System.out.println(tapis);
    	
    	if(tapis.getNbCartes()>0) {
    		this.notifyObservers("Les cartes doivent �tre adjacentes.");    		
    		//System.out.println("Les cartes doivent �tre adjacentes.");
    	}
    	this.notifyObservers("Carte(s) en main : " + this.getMainDuJoueur());    	
    	//System.out.println("Carte(s) en main : " + this.getMainDuJoueur());
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
	        		//System.out.print("D�sol�e, cette case n'est pas disponible" + "\n");
	        	}
    		}
        	
    	}while(!tapis.placementNormalPossible(ligneCase,colonneCase) && !tapis.decalagePossible(ligneCase, colonneCase) && ((this.ligCarteGUI == -1 && this.ligCarteDepGUI == -1)));
    	
    	if(this.ligCarteGUI == -1 && this.ligCarteDepGUI == -1) {
    		
    		if(!tapis.caseRemplie(ligneCase,colonneCase)) {
    			
        		tapis.getContainer().get(ligneCase).set(colonneCase, carteAJouer);
        			
        	} else if(tapis.caseRemplie(ligneCase,colonneCase) && tapis.decalagePossible(ligneCase, colonneCase)){

        			this.notifyObservers("D�calage du tapis...");      		
        			//System.out.println("D�calage du tapis...");
        		    tapis.decalerCartes(ligneCase, colonneCase);
        		    tapis.getContainer().get(ligneCase).set(colonneCase, carteAJouer);
        	}
        	this.notifyObservers(tapis);   
        	//System.out.println(tapis);
        	tapis.setNbCartes(tapis.getNbCartes()+1);
    	}

    	

    }
	
	public void placerCarteGUI(int ligneCase, int colonneCase, TapisDeJeu tapis, Carte carteAJouer) {  	

//    	if(!tapis.placementNormalPossible(ligneCase,colonneCase) && !tapis.decalagePossible(ligneCase, colonneCase)) {
//    		this.notifyObservers("D�sol�e, cette n'est pas disponible");          		
//    	}
    	
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
    	//System.out.println(tapis);
    	this.notifyObservers("Veuillez choisir une carte � d�placer :");       	
    	//System.out.println("Veuillez choisir une carte � d�placer :");
    	
    	do {
    		
    		ligneCase = this.strategie.choisirLigneCarte(tapis);
    		//on ne peut plus choisir une carte � deplacer dans l'interface
    		this.setDeplacementPossible(false);
    		if(this.ligCarteADepGUI == -1) {
    			colonneCase = this.strategie.choisirColonneCarte(tapis);
            	
            	if(!tapis.caseRemplie(ligneCase,colonneCase)) {
            		this.notifyObservers("D�sol�e, cette case est vide");           		
            		//System.out.println("D�sol�e, cette case est vide");
            	}
    		}
        	
    	}while(!tapis.caseRemplie(ligneCase,colonneCase));
    	
    	Carte carteADeplacer;
    	
    	if(this.ligCarteADepGUI == -1) {
    		
    		//this.carteAJouer = tapis.getContainer().get(ligneCase).get(colonneCase);
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
    	
//        if(!tapis.caseRemplie(ligneCase,colonneCase)) {
//        	this.notifyObservers("D�sol�e, cette case est vide");           		
//
//        }
		this.carteAJouer = tapis.getContainer().get(ligneCase).get(colonneCase);
    	tapis.setNbCartes(tapis.getNbCartes()-1);
    	tapis.getContainer().get(ligneCase).set(colonneCase, null);
    	
    	this.notifyObservers("Vous avez choisi de d�placer la carte " + this.carteAJouer);   
    	this.notifyObservers(tapis); 
    	
    	//this.placerCarte(ligneCase, colonneCase, carteADeplacer, tapis);

	}

	
}
