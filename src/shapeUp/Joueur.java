package shapeUp;

import java.util.*;

import vue.Console;

public abstract class Joueur extends Observable{
    private String nom;

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
//	    	this.strategie = (StrategieJoueur) this;
//	    	
//	    } else if (this instanceof JoueurVirtuel) {
//	    	this.strategie = (StrategieJoueur) this;
//	    }
	    
	}

	private String score;

    //protected StrategieJoueur strategie;



	//public Pioche pioche;

    //public List<Carte>  = new ArrayList<Carte> ();
	
	
	private Carte carteDeVictoire;
    public Carte getCarteDeVictoire() {
		return carteDeVictoire;
	}

	public void setCarteDeVictoire(Carte carteDeVictoire) {
		this.carteDeVictoire = carteDeVictoire;
	}
	
	//Composée de plusieurs cartes en mode avancé ==> List
	private ArrayList<Carte> mainDuJoueur = new ArrayList<Carte>();


	public void jouer(Partie partie, TapisDeJeu tapis, Pioche pioche, StrategieMode modeDeJeu, Console console) {
		
		//this.addObserver(partie.getConsoleDuJeu());
		Carte cartePiochee;
		Carte carteAJouer;
		
		if(modeDeJeu instanceof StrategieDeBase || modeDeJeu instanceof StrategieVictoireEnnemie) {
			
			cartePiochee = this.piocherCarte(pioche);
			this.getMainDuJoueur().add(cartePiochee);
			this.notifyObservers(cartePiochee);
			//System.out.println(cartePiochee);
			//System.out.println(pioche);
		}
		
    	if(tapis.getNbCartes()>1 && tapis.getNbCartes()<partie.getNbCartesJouables()) {
    		
    		boolean deplacementFait = this.proposerDeplacement(tapis, console);
    		
//    		System.out.println("Carte(s) en main : " + this.getMainDuJoueur());
//    		carteAJouer = this.strategie.definirCarteAJouer(this,partie.getModeDeJeu());
//    		modeDeJeu.voirCarteVictoire(partie, this);
    		this.placerCarte(partie, tapis, console);
    		
    		if(!deplacementFait) {
    			this.proposerDeplacement(tapis, console);
    		}
    		
    	} else {
//        	System.out.println("Carte(s) en main : " + this.getMainDuJoueur());
//    		carteAJouer = this.strategie.definirCarteAJouer(this,partie.getModeDeJeu());
//    		modeDeJeu.voirCarteVictoire(partie, this);
    		//this.strategie.placerCarte(carteAJouer, tapis);
    		this.placerCarte(partie, tapis, console);
    	}
    	
    	if(modeDeJeu instanceof StrategieAvance) {
    		
			cartePiochee = this.piocherCarte(pioche);
			this.getMainDuJoueur().add(cartePiochee);
			this.notifyObservers(cartePiochee);
			//System.out.println(cartePiochee);
		}
    }
	

    public ArrayList<Carte> getMainDuJoueur() {
		return mainDuJoueur;
	}

	public void setMain(ArrayList<Carte> main) {
		this.mainDuJoueur = main;
	}
	
	public abstract Carte piocherCarte(Pioche pioche);
	
	public abstract boolean proposerDeplacement(TapisDeJeu tapis, Console console);
  
	public abstract void deplacerCarte(TapisDeJeu tapis, Console console);
  
	public abstract void placerCarte(Partie partie, TapisDeJeu tapis, Console console);
  
	public abstract void placerCarte(int lig, int col, Carte carteAJouer, TapisDeJeu tapis, Console console);
  
//	
//	public void placerCarte(int lig, int col, Carte carteAJouer, TapisDeJeu tapis) {
//		
//    	int ligneCase;
//    	int colonneCase;
//    	//this.notifyObservers(tapis);    	
//    	System.out.println(tapis);
//    	
//    	if(tapis.getNbCartes()>0) {
//    		//this.notifyObservers("Les cartes doivent être adjacentes.");    		
//    		System.out.println("Les cartes doivent être adjacentes.");
//    	}
//    	
//    	do {
//    		ligneCase = this.choisirLigneCarte(tapis);
//        	colonneCase = this.choisirColonneCarte(tapis);
//        	
//        	if(!tapis.placementNormalPossible(ligneCase,colonneCase)) {
//        		//this.notifyObservers("Désolée, cette case n'est pas disponible" + "\n");        		
//        		System.out.print("Désolée, cette case n'est pas disponible" + "\n");
//        	}
//        	if(ligneCase == lig && colonneCase == col) {
//        		//this.notifyObservers("La carte était déjà placée ici" + "\n");        		
//        		System.out.print("La carte était déjà placée ici" + "\n");
//        	}
//        	
//    	}while((!tapis.placementNormalPossible(ligneCase,colonneCase) && !tapis.decalagePossible(ligneCase, colonneCase)) || (ligneCase == lig && colonneCase == col));
//    	
//    	if(!tapis.caseRemplie(ligneCase,colonneCase)) {
//    			
//    			tapis.getContainer().get(ligneCase).set(colonneCase, carteAJouer);
//    			
//    	} else if(tapis.caseRemplie(ligneCase,colonneCase) && tapis.decalagePossible(ligneCase, colonneCase)){
//    		
//    			//this.notifyObservers("Décalage du tapis...");    		
//    			System.out.println("Décalage du tapis...");
//    		    tapis.decalerCartes(ligneCase, colonneCase);
//    		    tapis.getContainer().get(ligneCase).set(colonneCase, carteAJouer);
//    	}
//    	//this.notifyObservers(tapis);
//    	System.out.println(tapis);
//    	tapis.setNbCartes(tapis.getNbCartes()+1);
//    	//this.notifyObservers("Nombre de cartes : " + tapis.getNbCartes());    	
//    	System.out.println("NB CARTES : " + tapis.getNbCartes());
//
//    }
//	
//	
//	public void placerCarte(Partie partie, TapisDeJeu tapis) {
//		
//    	int ligneCase;
//    	int colonneCase;
//    	Carte carteAJouer;
//    	//this.notifyObservers(tapis);    	
//    	System.out.println(tapis);
//    	
//    	if(tapis.getNbCartes()>0) {
//    		//this.notifyObservers("Les cartes doivent être adjacentes.");    		
//    		System.out.println("Les cartes doivent être adjacentes.");
//    	}
//    	//this.notifyObservers("Carte(s) en main : " + this.getMainDuJoueur());    	
//    	System.out.println("Carte(s) en main : " + this.getMainDuJoueur());
//		carteAJouer = this.definirCarteAJouer(this, partie.getModeDeJeu());
//		partie.getModeDeJeu().voirCarteVictoire(partie, this);
//    	
//    	do {
//    		ligneCase = this.choisirLigneCarte(tapis);
//        	colonneCase = this.choisirColonneCarte(tapis);
//        	
//        	if(!tapis.placementNormalPossible(ligneCase,colonneCase) && !tapis.decalagePossible(ligneCase, colonneCase)) {
//        		//this.notifyObservers("Désolée, cette n'est pas disponible" + "\n");          		
//        		System.out.print("Désolée, cette case n'est pas disponible" + "\n");
//        	}
//        	
//    	}while(!tapis.placementNormalPossible(ligneCase,colonneCase) && !tapis.decalagePossible(ligneCase, colonneCase));
//
//    	if(!tapis.caseRemplie(ligneCase,colonneCase)) {
//    			
//    		tapis.getContainer().get(ligneCase).set(colonneCase, carteAJouer);
//    			
//    	} else if(tapis.caseRemplie(ligneCase,colonneCase) && tapis.decalagePossible(ligneCase, colonneCase)){
//
//    			//this.notifyObservers("Décalage du tapis...");      		
//    			System.out.println("Décalage du tapis...");
//    		    tapis.decalerCartes(ligneCase, colonneCase);
//    		    tapis.getContainer().get(ligneCase).set(colonneCase, carteAJouer);
//    	}
//    	//this.notifyObservers(tapis);   
//    	System.out.println(tapis);
//    	tapis.setNbCartes(tapis.getNbCartes()+1);
//    	//this.notifyObservers("Nombre de cartes : " + tapis.getNbCartes());       	
//    	System.out.println("NB CARTES : " + tapis.getNbCartes());
//
//    }
//	
//	
//	public void deplacerCarte(TapisDeJeu tapis) {
//    	
//    	int ligneCase;
//    	int colonneCase;
//    	//this.notifyObservers(tapis);       	
//    	System.out.println(tapis);
//    	//this.notifyObservers("Veuillez choisir une carte à déplacer :");       	
//    	System.out.println("Veuillez choisir une carte à déplacer :");
//    	
//    	do {
//    		ligneCase = this.choisirLigneCarte(tapis);
//        	colonneCase = this.choisirColonneCarte(tapis);
//        	
//        	if(!tapis.caseRemplie(ligneCase,colonneCase)) {
//        		//this.notifyObservers("Désolée, cette case est vide");           		
//        		System.out.println("Désolée, cette case est vide");
//        	}
//    	}while(!tapis.caseRemplie(ligneCase,colonneCase));
//    	
//    	Carte carteADeplacer = tapis.getContainer().get(ligneCase).get(colonneCase);
//    	tapis.setNbCartes(tapis.getNbCartes()-1);
//    	tapis.getContainer().get(ligneCase).set(colonneCase, null);
//    	
//    	//this.notifyObservers("Vous avez choisi de déplacer la carte " + carteADeplacer);   
//    	System.out.println("Vous avez choisi de déplacer la carte " + carteADeplacer);
//    	
//    	this.placerCarte(ligneCase, colonneCase, carteADeplacer, tapis);
//
//	}	
}
