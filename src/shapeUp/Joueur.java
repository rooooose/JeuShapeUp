package shapeUp;

import java.util.*;

import vue.Console;

public abstract class Joueur extends Observable{
	
	private StrategieJoueur strategie;
    private String nom;
    private int cptPlacerCarte = 0;
    
    //permet de récupérer la ligne de la derniere carte placée dans l'interface graphique
    private int ligCarteGUI;
    
	public int getLigCarteGUI() {
		return ligCarteGUI;
	}

	public void setLigCarteGUI(int ligCarteGUI) {
		this.ligCarteGUI = ligCarteGUI;
	}
    
    public int getCptPlacerCarte() {
		return cptPlacerCarte;
	}

	public void setCptPlacerCarte(int cptPlacerCarte) {
		this.cptPlacerCarte = cptPlacerCarte;
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

	private Carte carteDeVictoire;
    public Carte getCarteDeVictoire() {
		return carteDeVictoire;
	}

	public void setCarteDeVictoire(Carte carteDeVictoire) {
		this.carteDeVictoire = carteDeVictoire;
	}
	
	//Composée de plusieurs cartes en mode avancé ==> List
	private ArrayList<Carte> mainDuJoueur = new ArrayList<Carte>();


	public void jouer(Partie partie, TapisDeJeu tapis, Pioche pioche, StrategieMode modeDeJeu) {
		
		Carte cartePiochee;
		
		if(modeDeJeu instanceof StrategieDeBase || modeDeJeu instanceof StrategieVictoireEnnemie) {
			
			cartePiochee = this.piocherCarte(pioche);
			this.getMainDuJoueur().add(cartePiochee);
			this.notifyObservers(cartePiochee);
		}
		
    	if(tapis.getNbCartes()>1 && tapis.getNbCartes()<partie.getNbCartesJouables()) {
    		
    		boolean deplacementFait = this.proposerDeplacement(tapis);

    		this.placerCarte(partie, tapis);
    		
    		if(!deplacementFait) {
    			this.proposerDeplacement(tapis);
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
	    	
	    	this.notifyObservers(this.getNom() + " a pioché sa carte :");	    	
	    	//System.out.println("Le joueur virtuel a pioché sa carte");
	    	return cartePiochee;
    	
		}
	}
	
	
	public abstract boolean proposerDeplacement(TapisDeJeu tapis);
  
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
    		this.notifyObservers("Les cartes doivent être adjacentes.");    		
    		//System.out.println("Les cartes doivent être adjacentes.");
    	}
    	
    	do {
    		ligneCase = this.strategie.choisirLigneCarte(tapis);
        	colonneCase = this.strategie.choisirColonneCarte(tapis);
        	
        	if(!tapis.placementNormalPossible(ligneCase,colonneCase)) {
        		this.notifyObservers("Désolée, cette case n'est pas disponible");        		
        		//System.out.print("Désolée, cette case n'est pas disponible" + "\n");
        	}
        	if(ligneCase == lig && colonneCase == col) {
        		this.notifyObservers("La carte était déjà placée ici" + "\n");        		
        		//System.out.print("La carte était déjà placée ici" + "\n");
        	}
        	
    	}while((!tapis.placementNormalPossible(ligneCase,colonneCase) && !tapis.decalagePossible(ligneCase, colonneCase)) || (ligneCase == lig && colonneCase == col));
    	
    	if(!tapis.caseRemplie(ligneCase,colonneCase)) {
    			
    			tapis.getContainer().get(ligneCase).set(colonneCase, carteAJouer);
    			
    	} else if(tapis.caseRemplie(ligneCase,colonneCase) && tapis.decalagePossible(ligneCase, colonneCase)){
    		
    			this.notifyObservers("Décalage du tapis...");    		
    			//System.out.println("Décalage du tapis...");
    		    tapis.decalerCartes(ligneCase, colonneCase);
    		    tapis.getContainer().get(ligneCase).set(colonneCase, carteAJouer);
    	}
    	this.notifyObservers(tapis);
    	//System.out.println(tapis);
    	tapis.setNbCartes(tapis.getNbCartes()+1);

    }
	
	
	public void placerCarte(Partie partie, TapisDeJeu tapis) {
		
		setCptPlacerCarte(getCptPlacerCarte() + 1);
		
    	int ligneCase;
    	int colonneCase = 0;
    	//Carte carteAJouer;
    	this.notifyObservers(tapis);    	
    	//System.out.println(tapis);
    	
    	if(tapis.getNbCartes()>0) {
    		this.notifyObservers("Les cartes doivent être adjacentes.");    		
    		//System.out.println("Les cartes doivent être adjacentes.");
    	}
    	this.notifyObservers("Carte(s) en main : " + this.getMainDuJoueur());    	
    	//System.out.println("Carte(s) en main : " + this.getMainDuJoueur());
		this.carteAJouer = this.strategie.definirCarteAJouer(this, partie.getModeDeJeu());
		partie.getModeDeJeu().voirCarteVictoire(partie, this);
    	
    	do {
    		ligneCase = this.strategie.choisirLigneCarte(tapis);
    		
    		if(this.cptPlacerCarte > tapis.getNbCartes()) {
    			colonneCase = this.strategie.choisirColonneCarte(tapis);

	        	if(!tapis.placementNormalPossible(ligneCase,colonneCase) && !tapis.decalagePossible(ligneCase, colonneCase)) {
	        		this.notifyObservers("Désolée, cette n'est pas disponible");          		
	        		//System.out.print("Désolée, cette case n'est pas disponible" + "\n");
	        	}
    		}
        	
    	}while(!tapis.placementNormalPossible(ligneCase,colonneCase) && !tapis.decalagePossible(ligneCase, colonneCase) && this.cptPlacerCarte > tapis.getNbCartes());
    	
    	if(this.cptPlacerCarte > tapis.getNbCartes()) {
    		
    		if(!tapis.caseRemplie(ligneCase,colonneCase)) {
    			
        		tapis.getContainer().get(ligneCase).set(colonneCase, carteAJouer);
        			
        	} else if(tapis.caseRemplie(ligneCase,colonneCase) && tapis.decalagePossible(ligneCase, colonneCase)){

        			this.notifyObservers("Décalage du tapis...");      		
        			//System.out.println("Décalage du tapis...");
        		    tapis.decalerCartes(ligneCase, colonneCase);
        		    tapis.getContainer().get(ligneCase).set(colonneCase, carteAJouer);
        	}
        	this.notifyObservers(tapis);   
        	//System.out.println(tapis);
        	tapis.setNbCartes(tapis.getNbCartes()+1);
    	}

    	

    }
	
	public void placerCarteGUI(int ligneCase, int colonneCase, TapisDeJeu tapis, Carte carteAJouer) {  	
	
//		carteAJouer = this.strategie.definirCarteAJouer(this, partie.getModeDeJeu());
//		partie.getModeDeJeu().voirCarteVictoire(partie, this);
    	if(!tapis.placementNormalPossible(ligneCase,colonneCase) && !tapis.decalagePossible(ligneCase, colonneCase)) {
    		this.notifyObservers("Désolée, cette n'est pas disponible");          		
    	}
    	
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
	
	public void deplacerCarte(TapisDeJeu tapis) {
    	
    	int ligneCase;
    	int colonneCase;
    	this.notifyObservers(tapis);       	
    	//System.out.println(tapis);
    	this.notifyObservers("Veuillez choisir une carte à déplacer :");       	
    	//System.out.println("Veuillez choisir une carte à déplacer :");
    	
    	do {
    		ligneCase = this.strategie.choisirLigneCarte(tapis);
        	colonneCase = this.strategie.choisirColonneCarte(tapis);
        	
        	if(!tapis.caseRemplie(ligneCase,colonneCase)) {
        		this.notifyObservers("Désolée, cette case est vide");           		
        		//System.out.println("Désolée, cette case est vide");
        	}
    	}while(!tapis.caseRemplie(ligneCase,colonneCase));
    	
    	Carte carteADeplacer = tapis.getContainer().get(ligneCase).get(colonneCase);
    	tapis.setNbCartes(tapis.getNbCartes()-1);
    	tapis.getContainer().get(ligneCase).set(colonneCase, null);
    	
    	this.notifyObservers("Vous avez choisi de déplacer la carte " + carteADeplacer);   
    	//System.out.println("Vous avez choisi de déplacer la carte " + carteADeplacer);
    	
    	this.placerCarte(ligneCase, colonneCase, carteADeplacer, tapis);

	}

}
