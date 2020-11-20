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


	public void jouer(TapisDeJeu tapis, Pioche pioche) {
		
		Carte cartePiochee = this.strategie.piocherCarte(pioche);
		this.getMainDuJoueur().add(cartePiochee);
		System.out.println(cartePiochee);
		// méthode choisir déplacer carte (ssi nbCartes>1)
		
//		int ligne = this.strategie.choisirLigneCartePlacement();
//		int colonne = this.strategie.choisirColonneCartePlacement(scan);
    	this.strategie.placerCarte(this.getMainDuJoueur().remove(0), tapis);
    	//this.strategie.deplacerCarte(tapis);
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
