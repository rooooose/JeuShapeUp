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
	private TapisDeJeu tapisDeJeu;
	private boolean estFinie;
    private StrategieMode modeDeJeu;
	
	public Queue<Joueur> getListeJoueurs() {
		return listeJoueurs;
	}
	public void setListeJoueurs(Queue<Joueur> listeJoueurs) {
		this.listeJoueurs = listeJoueurs;
	}
	
	public StrategieMode getModeDeJeu() {
		return modeDeJeu;
	}
	public void setModeDeJeu(StrategieMode modeDeJeu) {
		this.modeDeJeu = modeDeJeu;
	}
	
	/*public TapisDeJeu getTapisDeJeu() {
		return tapisDeJeu;
	}
	public void setTapisDeJeu(TapisDeJeu tapisDeJeu) {
		this.tapisDeJeu = tapisDeJeu;
	}*/
	
	Partie(Queue<Joueur> joueurs, StrategieMode mode, FormeTapis forme){
		//this.setNbreDeJoueurs(nbJoueurs);
		//System.out.print("Nombre de joueurs : " + nbJoueurs);
		System.out.print("Partie créée\n");
		
		listeJoueurs = new LinkedList<Joueur> ();
		this.setListeJoueurs(joueurs);
		this.setModeDeJeu(mode);
		this.tapisDeJeu = new TapisDeJeu(forme);
	}

	
	
	public String toString() {
    	StringBuffer sb = new StringBuffer();
    	//sb.append("Nombre de joueurs choisi : ");
    	//sb.append(this.getNbreDeJoueurs());
    	sb.append("Liste des types de joueurs : ");
    	sb.append(this.getListeJoueurs()+"\n");
    	sb.append("Mode de jeu : ");
    	sb.append(this.getModeDeJeu()+"\n");
    	sb.append("Forme du tapis de jeu : ");
    	sb.append(this.tapisDeJeu.getForme());
		return sb.toString();
    }
	

	@Override
	public int accepterScore(VisiteurScore visiteur, Joueur joueur) {
		// TODO Auto-generated method stub
		return 0;
	}

    /*

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
    }*/

}
