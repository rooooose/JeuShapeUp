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

    public CarteJouable main;

    public void jouer(StrategieJoueur strategie) {
    	//strategie.placerCarte(ligneCase, colonneCase, carte, tapis);
    }
}
