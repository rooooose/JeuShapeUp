package shapeUp;

import java.util.ArrayList;
import java.util.List;

public class Partie implements Visitable {
	
    private int nbreDeJoueurs;

    public int getNbreDeJoueurs() {
		return nbreDeJoueurs;
	}

	public void setNbreDeJoueurs(int nbreDeJoueurs) {
		this.nbreDeJoueurs = nbreDeJoueurs;
	}
	
	Partie(int nbJoueurs){
		this.setNbreDeJoueurs(nbJoueurs);
		System.out.print("Nombre de joueurs : " + nbJoueurs);
	}

	private boolean estFinie;

    public StrategieMode ;

    public List<Joueur>  = new ArrayList<Joueur> ();

    public TapisDeJeu ;

    public List<VisiteurScore>  = new ArrayList<VisiteurScore> ();

    public List<Carte>  = new ArrayList<Carte> ();

    public Pioche ;

    public void utiliserMode(StrategieMode mode) {
    }

    public int calculerScoreTotal(Joueur joueur) {
    }

    public Joueur definirGagnant() {
    }

    public void creerCartes() {
    }

    public void controlerPlacementCarte(CarteJouable carte) {
    }

    public int accepterScore(VisiteurScore visiteur, Joueur joueur) {
    }

}
