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
	private Carte mainDuJoueur;


	public void jouer(TapisDeJeu tapis, Pioche pioche) {
		
		Carte cartePiochee = this.strategie.piocherCarte(pioche);
		this.setMain(cartePiochee);
		System.out.println(cartePiochee);
		// méthode choisir placer carte ou déplacer carte
		
//		int ligne = this.strategie.choisirLigneCartePlacement();
//		int colonne = this.strategie.choisirColonneCartePlacement(scan);
    	this.strategie.placerCarte(this.getMainDuJoueur(), tapis);
    }
	
//    public void jouer(StrategieJoueur strategie) {
//    	//strategie.placerCarte(ligneCase, colonneCase, carte, tapis);
//    }
	
    public Carte getMainDuJoueur() {
		return mainDuJoueur;
	}

	public void setMain(Carte main) {
		this.mainDuJoueur = main;
	}
	
//	
}
