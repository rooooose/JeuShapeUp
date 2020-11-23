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
	
	//Composée de plusieurs cartes en mode avancé ==> List
	private ArrayList<Carte> mainDuJoueur = new ArrayList<Carte>();


	public void jouer(Partie partie, TapisDeJeu tapis, Pioche pioche, StrategieMode modeDeJeu) {
		
		Carte cartePiochee;
		Carte carteAJouer;
		
		if(modeDeJeu instanceof StrategieDeBase || modeDeJeu instanceof StrategieVictoireEnnemie) {
			
			cartePiochee = this.strategie.piocherCarte(pioche);
			this.getMainDuJoueur().add(cartePiochee);
			System.out.println(cartePiochee);
		}
		
    	if(tapis.getNbCartes()>1 && tapis.getNbCartes()<15) {
    		
    		boolean deplacementFait = this.strategie.proposerDeplacement(tapis);
    		
    		System.out.println("Carte(s) en main : " + this.getMainDuJoueur());
    		carteAJouer = this.strategie.definirCarteAJouer(this,modeDeJeu);
    	    modeDeJeu.voirCarteVictoire(partie, this);
    		this.strategie.placerCarte(carteAJouer, tapis);
    		
    		if(!deplacementFait) {
    			this.strategie.proposerDeplacement(tapis);
    		}
    		
    	} else {
        	System.out.println("Carte(s) en main : " + this.getMainDuJoueur());
    		carteAJouer = this.strategie.definirCarteAJouer(this,partie.getModeDeJeu());
    		modeDeJeu.voirCarteVictoire(partie, this);
    		this.strategie.placerCarte(carteAJouer, tapis);
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
	
//	
}
