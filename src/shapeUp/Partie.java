package shapeUp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Partie implements Visitable {
	
    /*private int nbreDeJoueurs;

    public int getNbreDeJoueurs() {
		return nbreDeJoueurs;
	}

	public void setNbreDeJoueurs(int nbreDeJoueurs) {
		this.nbreDeJoueurs = nbreDeJoueurs;
	}*/
	
	
	//private Set<Carte> carteDuJeu = new HashSet<Carte> (); suspens
	
	private List<Carte> carteDuJeu = new ArrayList<Carte> ();
	


	//private Queue<Joueur> listeJoueurs  = new LinkedList<Joueur> ();
	private Map<String,Joueur> listeJoueurs  = new HashMap<String,Joueur> ();
	private TapisDeJeu tapisDeJeu;
	private boolean estFinie;
    private StrategieMode modeDeJeu;
	
	public List<Carte> getCarteDuJeu() {
		return carteDuJeu;
	}
	
	public void setCarteDuJeu(List<Carte> carteDuJeu) {
		this.carteDuJeu = carteDuJeu;
	}
    
	public Map<String,Joueur> getListeJoueurs() {
		return listeJoueurs;
	}
	public void setListeJoueurs(Map<String,Joueur> listeJoueurs) {
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
	
	Partie(Map<String,Joueur> joueurs, StrategieMode mode, TapisDeJeu formeTapisDeJeu){
		//this.setNbreDeJoueurs(nbJoueurs);
		//System.out.print("Nombre de joueurs : " + nbJoueurs);
		System.out.print("Partie créée\n");

		this.setListeJoueurs(joueurs);
		this.setModeDeJeu(mode);
		this.tapisDeJeu = formeTapisDeJeu;
		this.créerLesCartes();
		
		Carte carteTest = new CarteJouable(CouleurType.BLEU, FormeCarte.CERCLE, false);
		CarteJouable c = (CarteJouable) carteTest;
		Carte carteTest1 = new CarteJouable(CouleurType.ROUGE, FormeCarte.CERCLE, false);
		CarteJouable c1 = (CarteJouable) carteTest1;
		listeJoueurs.get("1").strategie.placerCarte(0, 2, c1, tapisDeJeu);
		listeJoueurs.get("1").strategie.placerCarte(0, 2, c, tapisDeJeu);
		//listeJoueurs.get("1").strategie.placerCarte(1, 2, c, tapisDeJeu);
		//listeJoueurs.get("1").strategie.placerCarte(1, 2, c, tapisDeJeu);

	}

	
	
	public void créerLesCartes() {
		
		//Création des cartes cercles vides
		Carte carte1 = new Carte(CouleurType.BLEU, FormeCarte.CERCLE, false);
		carteDuJeu.add(carte1);
		Carte carte2 = new Carte(CouleurType.VERT, FormeCarte.CERCLE, false);
		carteDuJeu.add(carte2);
		Carte carte3 = new Carte(CouleurType.ROUGE, FormeCarte.CERCLE, false);
		carteDuJeu.add(carte3);
		
		//Création des cartes carrées vides
		Carte carte4 = new Carte(CouleurType.BLEU, FormeCarte.CARRE, false);
		carteDuJeu.add(carte4);
		Carte carte5 = new Carte(CouleurType.VERT, FormeCarte.CARRE, false);
		carteDuJeu.add(carte5);
		Carte carte6 = new Carte(CouleurType.ROUGE, FormeCarte.CARRE, false);
		carteDuJeu.add(carte6);
		
		//Création des cartes triangulaires vides
		Carte carte7 = new Carte(CouleurType.BLEU, FormeCarte.TRIANGLE, false);
		carteDuJeu.add(carte7);
		Carte carte8 = new Carte(CouleurType.VERT, FormeCarte.TRIANGLE, false);
		carteDuJeu.add(carte8);
		Carte carte9 = new Carte(CouleurType.ROUGE, FormeCarte.TRIANGLE, false);
		carteDuJeu.add(carte9);
		
		//Création des cartes cercles remplies
		Carte carte10 = new Carte(CouleurType.BLEU, FormeCarte.CERCLE, true);
		carteDuJeu.add(carte10);
		Carte carte11 = new Carte(CouleurType.VERT, FormeCarte.CERCLE, true);
		carteDuJeu.add(carte11);
		Carte carte12 = new Carte(CouleurType.ROUGE, FormeCarte.CERCLE, true);
		carteDuJeu.add(carte12);
		
		//Création des cartes carrées remplies
		Carte carte13 = new Carte(CouleurType.BLEU, FormeCarte.CARRE, true);
		carteDuJeu.add(carte13);
		Carte carte14 = new Carte(CouleurType.VERT, FormeCarte.CARRE, true);
		carteDuJeu.add(carte14);
		Carte carte15 = new Carte(CouleurType.ROUGE, FormeCarte.CARRE, true);
		carteDuJeu.add(carte15);
		
		//Création des cartes triangulaires remplies
		Carte carte16 = new Carte(CouleurType.BLEU, FormeCarte.TRIANGLE, true);
		carteDuJeu.add(carte16);
		Carte carte17 = new Carte(CouleurType.VERT, FormeCarte.TRIANGLE, true);
		carteDuJeu.add(carte17);
		Carte carte18 = new Carte(CouleurType.ROUGE, FormeCarte.TRIANGLE, true);
		carteDuJeu.add(carte18);
		
		/*Iterator<Carte> testIterator = carteDuJeu.iterator(); // Boucle de test pour vérifier la bonne création des cartes
		
		while (testIterator.hasNext()) {
			System.out.println(testIterator.next());
		} */

	}
	
	public String toString() {
    	StringBuffer sb = new StringBuffer();
    	//sb.append("Nombre de joueurs choisi : ");
    	//sb.append(this.getNbreDeJoueurs());
    	sb.append("Liste des types de joueurs : ");
    	sb.append(this.getListeJoueurs()+"\n");
    	sb.append("Mode de jeu : ");
    	sb.append(this.getModeDeJeu()+"\n");
    	sb.append("Forme du tapis de jeu : \n");
    	sb.append(this.tapisDeJeu);
		return sb.toString();
    }
	

	@Override
	public int accepterScore(VisiteurScore visiteur, Joueur joueur) {
		// TODO Auto-generated method stub
		return 0;
	}

    /*

    public List<VisiteurScore>  = new ArrayList<VisiteurScore> ();

    public Pioche ;

    public void utiliserMode(StrategieMode mode) {
    }

    public int calculerScoreTotal(Joueur joueur) {
    }

    public Joueur definirGagnant() {
    }

    public void controlerPlacementCarte(CarteJouable carte) {
    }*/

}
