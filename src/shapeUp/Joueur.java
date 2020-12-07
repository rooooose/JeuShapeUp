package shapeUp;

import java.util.*;

public class Joueur {
    private String nom;

    public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	Joueur(String nom) {
		this.setNom(nom);
	}

	private String score;

    protected StrategieJoueur strategie;

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


	public void jouer(Partie partie, TapisDeJeu tapis, Pioche pioche, StrategieMode modeDeJeu) {
		
		Carte cartePiochee;
		Carte carteAJouer;
		
		if(modeDeJeu instanceof StrategieDeBase || modeDeJeu instanceof StrategieVictoireEnnemie) {
			
			cartePiochee = this.strategie.piocherCarte(pioche);
			this.getMainDuJoueur().add(cartePiochee);
			System.out.println(cartePiochee);
			//System.out.println(pioche);
		}
		
    	if(tapis.getNbCartes()>1 && tapis.getNbCartes()<partie.getNbCartesJouables()) {
    		
    		boolean deplacementFait = this.strategie.proposerDeplacement(tapis, this);
    		
//    		System.out.println("Carte(s) en main : " + this.getMainDuJoueur());
//    		carteAJouer = this.strategie.definirCarteAJouer(this,partie.getModeDeJeu());
//    		modeDeJeu.voirCarteVictoire(partie, this);
    		this.placerCarte(partie, tapis);
    		
    		if(!deplacementFait) {
    			this.strategie.proposerDeplacement(tapis, this);
    		}
    		
    	} else {
//        	System.out.println("Carte(s) en main : " + this.getMainDuJoueur());
//    		carteAJouer = this.strategie.definirCarteAJouer(this,partie.getModeDeJeu());
//    		modeDeJeu.voirCarteVictoire(partie, this);
    		//this.strategie.placerCarte(carteAJouer, tapis);
    		this.placerCarte(partie, tapis);
    	}
    	
    	if(modeDeJeu instanceof StrategieAvance) {
    		
			cartePiochee = this.strategie.piocherCarte(pioche);
			this.getMainDuJoueur().add(cartePiochee);
			System.out.println(cartePiochee);
		}
    }
	
//    public void jouer(StrategieJoueur strategie) {
//    	//strategie.placerCarte(ligneCase, colonneCase, carte, tapis);
//    }
	
    public ArrayList<Carte> getMainDuJoueur() {
		return mainDuJoueur;
	}

	public void setMain(ArrayList<Carte> main) {
		this.mainDuJoueur = main;
	}
	
	
	public void placerCarte(int lig, int col, Carte carteAJouer, TapisDeJeu tapis) {
		
    	int ligneCase;
    	int colonneCase;
    	System.out.println(tapis);
    	
    	if(tapis.getNbCartes()>0) {
    		System.out.println("Les cartes doivent être adjacentes.");
    	}
    	
    	do {
    		ligneCase = this.strategie.choisirLigneCarte(tapis);
        	colonneCase = this.strategie.choisirColonneCarte(tapis);
        	
        	if(!tapis.placementNormalPossible(ligneCase,colonneCase)) {
        		System.out.print("Désolée, cette case n'est pas disponible" + "\n");
        	}
        	if(ligneCase == lig && colonneCase == col) {
        		System.out.print("La carte était déjà placée ici" + "\n");
        	}
        	
    	}while((!tapis.placementNormalPossible(ligneCase,colonneCase) && !tapis.decalagePossible(ligneCase, colonneCase)) || (ligneCase == lig && colonneCase == col));
    	
    	if(!tapis.caseRemplie(ligneCase,colonneCase)) {
    			
    			tapis.getContainer().get(ligneCase).set(colonneCase, carteAJouer);
    			
    	} else if(tapis.caseRemplie(ligneCase,colonneCase) && tapis.decalagePossible(ligneCase, colonneCase)){
    		
    			System.out.println("Décalage du tapis...");
    		    tapis.decalerCartes(ligneCase, colonneCase);
    		    tapis.getContainer().get(ligneCase).set(colonneCase, carteAJouer);
    	}

    	System.out.println(tapis);
    	tapis.setNbCartes(tapis.getNbCartes()+1);
    	System.out.println("NB CARTES : " + tapis.getNbCartes());
    	//carte.setEstPlacee(true); 
    	
    	//nbLignesVides FAUX
    	//System.out.println(tapis.getNbLignesVides());
    }
	
	
	public void placerCarte(Partie partie, TapisDeJeu tapis) {
		
    	int ligneCase;
    	int colonneCase;
    	Carte carteAJouer;
    	
    	System.out.println(tapis);
    	
    	if(tapis.getNbCartes()>0) {
    		System.out.println("Les cartes doivent être adjacentes.");
    	}
    	
    	System.out.println("Carte(s) en main : " + this.getMainDuJoueur());
		carteAJouer = this.strategie.definirCarteAJouer(this, partie.getModeDeJeu());
		partie.getModeDeJeu().voirCarteVictoire(partie, this);
    	
    	do {
    		ligneCase = this.strategie.choisirLigneCarte(tapis);
        	colonneCase = this.strategie.choisirColonneCarte(tapis);
        	
        	if(!tapis.placementNormalPossible(ligneCase,colonneCase) && !tapis.decalagePossible(ligneCase, colonneCase)) {
        		System.out.print("Désolée, cette case n'est pas disponible" + "\n");
        	}
        	
    	}while(!tapis.placementNormalPossible(ligneCase,colonneCase) && !tapis.decalagePossible(ligneCase, colonneCase));

    	if(!tapis.caseRemplie(ligneCase,colonneCase)) {
    			
    		tapis.getContainer().get(ligneCase).set(colonneCase, carteAJouer);
    			
    	} else if(tapis.caseRemplie(ligneCase,colonneCase) && tapis.decalagePossible(ligneCase, colonneCase)){
    		
    			System.out.println("Décalage du tapis...");
    		    tapis.decalerCartes(ligneCase, colonneCase);
    		    tapis.getContainer().get(ligneCase).set(colonneCase, carteAJouer);
    	}

    	System.out.println(tapis);
    	tapis.setNbCartes(tapis.getNbCartes()+1);
    	System.out.println("NB CARTES : " + tapis.getNbCartes());

    }
	
	
	public void deplacerCarte(TapisDeJeu tapis) {
    	
    	int ligneCase;
    	int colonneCase;
    	System.out.println(tapis);
    	System.out.println("Veuillez choisir une carte à déplacer :");
    	
    	do {
    		ligneCase = this.strategie.choisirLigneCarte(tapis);
        	colonneCase = this.strategie.choisirColonneCarte(tapis);
        	
        	if(!tapis.caseRemplie(ligneCase,colonneCase)) {
        		System.out.println("Désolée, cette case est vide");
        	}
    	}while(!tapis.caseRemplie(ligneCase,colonneCase));
    	
    	Carte carteADeplacer = tapis.getContainer().get(ligneCase).get(colonneCase);
    	tapis.setNbCartes(tapis.getNbCartes()-1);
    	tapis.getContainer().get(ligneCase).set(colonneCase, null);

    	System.out.println("Vous avez choisi de déplacer la carte " + carteADeplacer);
    	
    	this.placerCarte(ligneCase, colonneCase, carteADeplacer, tapis);

	}	
}
