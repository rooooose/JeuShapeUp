package shapeUp;

import java.util.*;

public class Partie implements Visitable {
	
    /*private int nbreDeJoueurs;

    public int getNbreDeJoueurs() {
		return nbreDeJoueurs;
	}

	public void setNbreDeJoueurs(int nbreDeJoueurs) {
		this.nbreDeJoueurs = nbreDeJoueurs;
	}*/
	
	//Unicité des cartes du jeu
	private Set<Carte> carteDuJeu = new HashSet<Carte> (); 
	private Pioche pioche;
	//private List<Carte> carteDuJeu = new ArrayList<Carte> ();
	
	public Pioche getPioche() {
		return pioche;
	}

	public void setPioche(Pioche pioche) {
		this.pioche = pioche;
	}

	//LISTE
	private VisiteurScore scoreForme = new ScoreForme();
	private VisiteurScore scoreCouleur = new ScoreCouleur();
	private VisiteurScore scoreRemplissage = new ScoreRemplissage();


	//private Queue<Joueur> listeJoueurs  = new LinkedList<Joueur> ();
	private Map<String,Joueur> listeJoueurs  = new HashMap<String,Joueur> ();
	private Queue<Joueur> queueJoueurs = new LinkedList<Joueur>();
	private Map<CarteDeVictoire,Joueur> CarteVictAssociationJoueur;
	private TapisDeJeu tapisDeJeu;
	private boolean estFinie;
	private int nbCartesJouables;
	
	public Map<CarteDeVictoire, Joueur> getCarteVictAssociationJoueur() {
		return CarteVictAssociationJoueur;
	}

	public void setCarteVictAssociationJoueur(Map<CarteDeVictoire, Joueur> carteVictAssociationJoueur) {
		this.CarteVictAssociationJoueur = carteVictAssociationJoueur;
	}

	public Queue<Joueur> getQueueJoueurs() {
		return queueJoueurs;
	}
	public void setQueueJoueurs(Queue<Joueur> queueJoueurs) {
		this.queueJoueurs = queueJoueurs;
	}

	
	public boolean isEstFinie() {
		return estFinie;
	}
	public void setEstFinie(boolean estFinie) {
		this.estFinie = estFinie;
	}
	
    private StrategieMode modeDeJeu;
	
	public Set<Carte> getCarteDuJeu() {
		return carteDuJeu;
	}
	
	public void setCarteDuJeu(Set<Carte> carteDuJeu) {
		this.carteDuJeu = carteDuJeu;
	}
    
//	public Map<String,Joueur> getListeJoueurs() {
//		return listeJoueurs;
//	}
//	public void setListeJoueurs(Map<String,Joueur> listeJoueurs) {
//		this.listeJoueurs = listeJoueurs;
//	}
	
	public StrategieMode getModeDeJeu() {
		return modeDeJeu;
	}
	public void setModeDeJeu(StrategieMode modeDeJeu) {
		this.modeDeJeu = modeDeJeu;
	}
	
	public TapisDeJeu getTapisDeJeu() {
		return tapisDeJeu;
	}
	public void setTapisDeJeu(TapisDeJeu tapisDeJeu) {
		this.tapisDeJeu = tapisDeJeu;
	}
	
	public int getNbCartesJouables() {
		return nbCartesJouables;
	}
	public void setNbCartesJouables(int nbCartesJouables) {
		this.nbCartesJouables = nbCartesJouables;
	}
	
	Partie(Queue<Joueur> joueurs, StrategieMode mode, TapisDeJeu formeTapisDeJeu){
		//this.setNbreDeJoueurs(nbJoueurs);
		//System.out.print("Nombre de joueurs : " + nbJoueurs);
		System.out.print("Partie créée\n");
		
		//A SUPPR LISTE 
		//this.setListeJoueurs(joueurs);
		
		this.setQueueJoueurs(joueurs);
		this.setModeDeJeu(mode);
		this.tapisDeJeu = formeTapisDeJeu;
		this.créerLesCartes();
		this.setEstFinie(false);
		this.setNbCartesJouables(this.getCarteDuJeu().size() - (this.getQueueJoueurs().size()+1));
		//System.out.println(this.nbCartesJouables);
		
		//conversion map joueurs en Queue
//		Collection<Joueur> valeursMapJoueurs = new LinkedList<Joueur>();
//		valeursMapJoueurs = this.getListeJoueurs().values();
//		queueJoueurs.addAll(valeursMapJoueurs);
		
		this.utiliserMode(this.modeDeJeu);

	}

	
	
	public void créerLesCartes() {
		
		for(CouleurType couleur : CouleurType.values()) {
			
			for(FormeCarte forme : FormeCarte.values()) {
				Carte carteVide = new Carte(couleur, forme, false);
				carteDuJeu.add(carteVide);
				Carte carteRemplie = new Carte(couleur, forme, true);
				carteDuJeu.add(carteRemplie);
			}
		}
		
//		//Création des cartes cercles vides
//		Carte carte1 = new Carte(CouleurType.BLEU, FormeCarte.CERCLE, false);
//		carteDuJeu.add(carte1);
//		Carte carte2 = new Carte(CouleurType.VERT, FormeCarte.CERCLE, false);
//		carteDuJeu.add(carte2);
//		Carte carte3 = new Carte(CouleurType.ROUGE, FormeCarte.CERCLE, false);
//		carteDuJeu.add(carte3);
//		
//		//Création des cartes carrées vides
//		Carte carte4 = new Carte(CouleurType.BLEU, FormeCarte.CARRE, false);
//		carteDuJeu.add(carte4);
//		Carte carte5 = new Carte(CouleurType.VERT, FormeCarte.CARRE, false);
//		carteDuJeu.add(carte5);
//		Carte carte6 = new Carte(CouleurType.ROUGE, FormeCarte.CARRE, false);
//		carteDuJeu.add(carte6);
//		
//		//Création des cartes triangulaires vides
//		Carte carte7 = new Carte(CouleurType.BLEU, FormeCarte.TRIANGLE, false);
//		carteDuJeu.add(carte7);
//		Carte carte8 = new Carte(CouleurType.VERT, FormeCarte.TRIANGLE, false);
//		carteDuJeu.add(carte8);
//		Carte carte9 = new Carte(CouleurType.ROUGE, FormeCarte.TRIANGLE, false);
//		carteDuJeu.add(carte9);
//		
//		//Création des cartes cercles remplies
//		Carte carte10 = new Carte(CouleurType.BLEU, FormeCarte.CERCLE, true);
//		carteDuJeu.add(carte10);
//		Carte carte11 = new Carte(CouleurType.VERT, FormeCarte.CERCLE, true);
//		carteDuJeu.add(carte11);
//		Carte carte12 = new Carte(CouleurType.ROUGE, FormeCarte.CERCLE, true);
//		carteDuJeu.add(carte12);
//		
//		//Création des cartes carrées remplies
//		Carte carte13 = new Carte(CouleurType.BLEU, FormeCarte.CARRE, true);
//		carteDuJeu.add(carte13);
//		Carte carte14 = new Carte(CouleurType.VERT, FormeCarte.CARRE, true);
//		carteDuJeu.add(carte14);
//		Carte carte15 = new Carte(CouleurType.ROUGE, FormeCarte.CARRE, true);
//		carteDuJeu.add(carte15);
//		
//		//Création des cartes triangulaires remplies
//		Carte carte16 = new Carte(CouleurType.BLEU, FormeCarte.TRIANGLE, true);
//		carteDuJeu.add(carte16);
//		Carte carte17 = new Carte(CouleurType.VERT, FormeCarte.TRIANGLE, true);
//		carteDuJeu.add(carte17);
//		Carte carte18 = new Carte(CouleurType.ROUGE, FormeCarte.TRIANGLE, true);
//		carteDuJeu.add(carte18);
		
		/*Iterator<Carte> testIterator = carteDuJeu.iterator(); // Boucle de test pour vérifier la bonne création des cartes
		
		while (testIterator.hasNext()) {
			System.out.println(testIterator.next());
		} */

	}
	
	public String toString() {
    	StringBuffer sb = new StringBuffer();
    	//sb.append("Nombre de joueurs choisi : ");
    	//sb.append(this.getNbreDeJoueurs());
    	sb.append("Liste des joueurs : " + "\n");
    	Iterator<Joueur> it = this.queueJoueurs.iterator();
    	while(it.hasNext()) {
    		Joueur joueur = it.next();
    		sb.append("- " + joueur.getNom() + " -> "+ joueur.strategie + "\n");
    	}
    	
    	sb.append("Mode de jeu : ");
    	sb.append(this.getModeDeJeu()+"\n");
    	sb.append("Forme du tapis de jeu : \n");
    	sb.append(this.tapisDeJeu);
		return sb.toString();
    }
	

	@Override
	public int accepterScore(VisiteurScore visiteur, Joueur joueur) {
		// TODO Auto-generated method stub
		int score = visiteur.visiter(this, joueur.getCarteDeVictoire());
		
		return score;
	}
	
	public void tourDeJeu()  {
		
		
		Joueur joueurActif = queueJoueurs.peek();
		//CarteJouable carteJoueur = (CarteJouable) joueurActif.getMainDuJoueur();
		
		System.out.println("C'est au tour de " + joueurActif.getNom());

		
		queueJoueurs.peek().jouer(this, this.getTapisDeJeu(), this.getPioche(), this.getModeDeJeu());
		//System.out.println(joueurActif.getMainDuJoueur());
		queueJoueurs.add(queueJoueurs.poll());
		
		if(this.getTapisDeJeu().getNbCartes() == this.nbCartesJouables) {
			this.setEstFinie(true);
		}
	}

	
    public void utiliserMode(StrategieMode mode) {
    	 
    	
    	//mode.distribuerCartes(this);
    	this.pioche = mode.creerLaPiocheDeLaPartie(this);
    }
    
    

//    public Pioche ;
//
//    public void utiliserMode(StrategieMode mode) {
//    mode.creerLaPiocheDeLaPartie(maPartie) = this.pioche;
//    
//    }

    public int calculerScoreTotal(Joueur joueur) {

    	int scoreTotal = this.accepterScore(this.scoreForme, joueur)+ this.accepterScore(this.scoreCouleur, joueur)+ this.accepterScore(scoreRemplissage, joueur);
    	return scoreTotal;
    }

//    public Joueur definirGagnant() {
//    }
//
//    public void controlerPlacementCarte(CarteJouable carte) {
//    }

	

	

}
