package shapeUp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Partie implements Visitable {
	
    /*private int nbreDeJoueurs;

    public int getNbreDeJoueurs() {
		return nbreDeJoueurs;
	}

	public void setNbreDeJoueurs(int nbreDeJoueurs) {
		this.nbreDeJoueurs = nbreDeJoueurs;
	}*/
	
	private Queue<Joueur> listeJoueurs  = new LinkedList<Joueur> ();
	
	public Queue<Joueur> getListeJoueurs() {
		return listeJoueurs;
	}

	public void setListeJoueurs(Queue<Joueur> listeJoueurs) {
		this.listeJoueurs = listeJoueurs;
	}

	Partie(Queue<Joueur> listeJoueurs){
		//this.setNbreDeJoueurs(nbJoueurs);
		//System.out.print("Nombre de joueurs : " + nbJoueurs);
		System.out.print("Partie créée\n");
		this.setListeJoueurs(listeJoueurs);
	}

	private boolean estFinie;

    //public StrategieMode ;
	
	public String toString() {
    	StringBuffer sb = new StringBuffer();
    	//sb.append("Nombre de joueurs choisi : ");
    	//sb.append(this.getNbreDeJoueurs());
    	sb.append("Liste des joueurs : ");
    	sb.append(this.getListeJoueurs());
		return sb.toString();
    }
	
	/*

	@Override
	public int accepterScore(VisiteurScore visiteur, Joueur joueur) {
		// TODO Auto-generated method stub
		return 0;
	}

    

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
    }*/

}
