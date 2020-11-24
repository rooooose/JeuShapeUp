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
	
	
	private CarteDeVictoire carteDeVictoire;
    public CarteDeVictoire getCarteDeVictoire() {
		return carteDeVictoire;
	}

	public void setCarteDeVictoire(CarteDeVictoire carteDeVictoire) {
		this.carteDeVictoire = carteDeVictoire;
	}
	
	//Compos�e de plusieurs cartes en mode avanc� ==> List
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
    		
    		System.out.println("Carte(s) en main : " + this.getMainDuJoueur());
    		carteAJouer = this.strategie.definirCarteAJouer(this,partie.getModeDeJeu());
    		modeDeJeu.voirCarteVictoire(partie, this);
    		this.placerCarte(carteAJouer, tapis);
    		
    		if(!deplacementFait) {
    			this.strategie.proposerDeplacement(tapis, this);
    		}
    		
    	} else {
        	System.out.println("Carte(s) en main : " + this.getMainDuJoueur());
    		carteAJouer = this.strategie.definirCarteAJouer(this,partie.getModeDeJeu());
    		modeDeJeu.voirCarteVictoire(partie, this);
    		//this.strategie.placerCarte(carteAJouer, tapis);
    		this.placerCarte(carteAJouer, tapis);
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
	
	
	public void placerCarte(Carte carteAJouer, TapisDeJeu tapis) {
		
    	int ligneCase;
    	int colonneCase;
    	System.out.println(tapis);
    	
    	if(tapis.getNbCartes()>0) {
    		System.out.println("Les cartes doivent �tre adjacentes.");
    	}
    	
//    	System.out.println("Carte(s) en main : " + this.getMainDuJoueur());
//		carteAJouer = this.strategie.definirCarteAJouer(this, partie.getModeDeJeu());
//		partie.getModeDeJeu().voirCarteVictoire(partie, this);
    	
    	do {
    		ligneCase = this.strategie.choisirLigneCarte(tapis);
        	colonneCase = this.strategie.choisirColonneCarte(tapis);
        	
        	if(!tapis.placementNormalPossible(ligneCase,colonneCase)) {
        		System.out.print("D�sol�e, cette case n'est pas disponible" + "\n");
        	}
        	//if(!tapis.placementNormalPossible(ligneCase,colonneCase) && !tapis.decalagePossible(ligneCase, colonneCase))
        	
    	}while(!tapis.placementNormalPossible(ligneCase,colonneCase));
    	//while(!tapis.placementNormalPossible(ligneCase,colonneCase) && !tapis.decalagePossible(ligneCase, colonneCase));
    	
    	if(!tapis.caseRemplie(ligneCase,colonneCase)) {
    			
    			tapis.getContainer().get(ligneCase).set(colonneCase, carteAJouer);
    			
    			//on diminue le nombre de lignes vides
//    			if(tapis.getContainer().get(ligneCase).isEmpty()) {
//    				tapis.setNbLignesVides(tapis.getNbLignesVides()-1);
//    			}
    			
    	} else if(tapis.caseRemplie(ligneCase,colonneCase)){
    		
    			System.out.println("DECALAGE POSSIBLE ");
    		    tapis.decalerCartes(ligneCase, colonneCase);
    		    
    		    //pas oblig� ?
    		    //ligne.remove(colonneCase);

    		    tapis.getContainer().get(ligneCase).set(colonneCase, carteAJouer);
    			
    			//on diminue le nombre de lignes vides
//    			if(tapis.getContainer().get(ligneCase).isEmpty()) {
//    				tapis.setNbLignesVides(tapis.getNbLignesVides()-1);
//    			}
    		    
    	}

    	System.out.println(tapis);
    	tapis.setNbCartes(tapis.getNbCartes()+1);
    	System.out.println("NB CARTES : " + tapis.getNbCartes());
    	//carte.setEstPlacee(true); 
    	
    	//nbLignesVides FAUX
    	//System.out.println(tapis.getNbLignesVides());
    }
	
	
	public void deplacerCarte(TapisDeJeu tapis) {
    	
    	int ligneCase;
    	int colonneCase;
    	System.out.println(tapis);
    	System.out.println("Veuillez choisir une carte � d�placer :");
    	
    	do {
    		ligneCase = this.strategie.choisirLigneCarte(tapis);
        	colonneCase = this.strategie.choisirColonneCarte(tapis);
        	
        	if(!tapis.caseRemplie(ligneCase,colonneCase)) {
        		System.out.println("D�sol�e, cette case est vide");
        	}
    	}while(!tapis.caseRemplie(ligneCase,colonneCase));
    	
    	Carte carteADeplacer = tapis.getContainer().get(ligneCase).get(colonneCase);
    	tapis.setNbCartes(tapis.getNbCartes()-1);
    	tapis.getContainer().get(ligneCase).set(colonneCase, null);
    	
    	//System.out.println(tapis);
    	System.out.println("Vous avez choisi de d�placer la carte " + carteADeplacer);
//    	carteADeplacer.setEstPlacee(false);
    	
    	this.placerCarte(carteADeplacer, tapis);
   	 
//    	carteADeplacer.setEstPlacee(true);
	}
	
//	
}
