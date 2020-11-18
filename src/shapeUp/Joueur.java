package shapeUp;

import java.util.ArrayList;
import java.util.List;

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

	public Pioche pioche;

    //public List<Carte>  = new ArrayList<Carte> ();
	
	
	private CarteDeVictoire carteDeVictoire;
    public CarteDeVictoire getCarteDeVictoire() {
		return carteDeVictoire;
	}

	public void setCarteDeVictoire(CarteDeVictoire carteDeVictoire) {
		this.carteDeVictoire = carteDeVictoire;
	}

	private CarteJouable main;


	public void jouer(TapisDeJeu tapis, CarteJouable carte) {

    	this.strategie.placerCarte(ligneCase, colonneCase, carte, tapis);
    }
	
//    public void jouer(StrategieJoueur strategie) {
//    	//strategie.placerCarte(ligneCase, colonneCase, carte, tapis);
//    }
	
    public CarteJouable getMain() {
		return main;
	}

	public void setMain(CarteJouable main) {
		this.main = main;
	}
	
//	
}
