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


	public void jouer(TapisDeJeu tapis, Pioche pioche, StrategieMode modeDeJeu) {
		
		Carte cartePiochee = this.strategie.piocherCarte(pioche);
		this.getMainDuJoueur().add(cartePiochee);
		System.out.println(cartePiochee);

		System.out.println("Carte(s) en main : " + this.getMainDuJoueur());
		Carte carteAJouer = this.strategie.definirCarteAJouer(this,modeDeJeu);
		
    	if(tapis.getNbCartes()>1 && tapis.getNbCartes()<15) {
    		
    		boolean deplacementFait = this.strategie.proposerDeplacement(tapis);
    		this.strategie.placerCarte(carteAJouer, tapis);
    		
    		if(!deplacementFait) {
    			this.strategie.proposerDeplacement(tapis);
    		}
    		
    	} else {
    		this.strategie.placerCarte(carteAJouer, tapis);
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
