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

	private String score;

    //public StrategieJoueur ;

    public Pioche pioche;

    //public List<Carte>  = new ArrayList<Carte> ();

    public CarteJouable jouer;

    public void jouer(StrategieJoueur strategie) {
    }

}
