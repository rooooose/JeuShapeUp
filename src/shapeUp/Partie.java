package shapeUp;

import java.util.*;

import vue.Console;

public class Partie extends Observable implements Visitable {
	
    /*private int nbreDeJoueurs;

    public int getNbreDeJoueurs() {
		return nbreDeJoueurs;
	}

	public void setNbreDeJoueurs(int nbreDeJoueurs) {
		this.nbreDeJoueurs = nbreDeJoueurs;
	}*/
	

//	private Console consoleDuJeu;
//	public Console getConsoleDuJeu() {
//		return consoleDuJeu;
//	}
//
//	public void setConsoleDuJeu(Console consoleDuJeu) {
//		this.consoleDuJeu = consoleDuJeu;
//	}

	private Set<Carte> carteDuJeu = new HashSet<Carte> (); 
	private Pioche pioche;
	//private List<Carte> carteDuJeu = new ArrayList<Carte> ();
	
	public Pioche getPioche() {
		return pioche;
	}

	public void setPioche(Pioche pioche) {
		this.pioche = pioche;
	}

	private VisiteurScore scoreForme = new ScoreForme();
	private VisiteurScore scoreCouleur = new ScoreCouleur();
	private VisiteurScore scoreRemplissage = new ScoreRemplissage();


//	private Map<String,Joueur> listeJoueurs  = new HashMap<String,Joueur> ();
	private Queue<Joueur> queueJoueurs = new LinkedList<Joueur>();
	//private Map<CarteDeVictoire,Joueur> CarteVictAssociationJoueur;
	private TapisDeJeu tapisDeJeu;
	private boolean estFinie;
	private int nbCartesJouables;
	private Joueur joueurActif = null;
	
	/*public Map<CarteDeVictoire, Joueur> getCarteVictAssociationJoueur() {
		return CarteVictAssociationJoueur;
	}

	public void setCarteVictAssociationJoueur(Map<CarteDeVictoire, Joueur> carteVictAssociationJoueur) {
		this.CarteVictAssociationJoueur = carteVictAssociationJoueur;
	}*/

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
	
	public Joueur getJoueurActif() {
		return joueurActif;
	}

	public void setJoueurActif(Joueur joueurActif) {
		this.joueurActif = joueurActif;
	}
	
	Partie(Queue<Joueur> joueurs, StrategieMode mode, TapisDeJeu formeTapisDeJeu){
		//this.setNbreDeJoueurs(nbJoueurs);
		//System.out.print("Nombre de joueurs : " + nbJoueurs);
		
//		this.addObserver(console);
		
		//this.notifyObservers("Partie créée\n");
		//System.out.print("Partie créée\n");
;
		
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

	}
	
	public String toString() {
    	StringBuffer sb = new StringBuffer();
    	//sb.append("Nombre de joueurs choisi : ");
    	//sb.append(this.getNbreDeJoueurs());
    	sb.append("Liste des joueurs : " + "\n");
    	Iterator<Joueur> it = this.queueJoueurs.iterator();
    	while(it.hasNext()) {
    		Joueur joueur = it.next();
    		sb.append(joueur);
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
		
		
		this.setJoueurActif(queueJoueurs.peek());
		//CarteJouable carteJoueur = (CarteJouable) joueurActif.getMainDuJoueur();
		
		this.notifyObservers("\n"+"** Au tour de " + this.joueurActif.getNom()+" **");
		//System.out.println("\n"+"***** C'est au tour de " + joueurActif.getNom()+" *****");
		
		this.getJoueurActif().setLigCarteGUI(-1);
		this.getJoueurActif().setNumCarteGUI(-1);
		
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

    public int calculerScoreTotal(Joueur joueur) {

    	int scoreTotal = this.accepterScore(this.scoreForme, joueur)+ this.accepterScore(this.scoreCouleur, joueur)+ this.accepterScore(scoreRemplissage, joueur);
    	return scoreTotal;
    }

    public void definirGagnant() {
    	
    	Joueur gagnant = null;
    	boolean egalite = true;
    	Iterator<Joueur> it = queueJoueurs.iterator();
    	
    	while(it.hasNext()) {
    		Joueur joueur = it.next();
    		
    		if(gagnant == null) {
    			gagnant = joueur;
    			
    		}else if(this.calculerScoreTotal(gagnant) < this.calculerScoreTotal(joueur)) {
    			gagnant = joueur;
    			egalite = false;
    		} else if(this.calculerScoreTotal(gagnant) > this.calculerScoreTotal(joueur)) {
    			egalite = false;
    		}
    	}
    	if(!egalite) {
    		this.notifyObservers("Le gagnant est : "+ gagnant.getNom() + " ! Bravo!" );
    		//System.out.println("Le gagnant est : "+ gagnant.getNom() + " !");
    	} else {
    		this.notifyObservers("Egalité ! ;)");
    		//System.out.println("Egalité !");
    	}
		
    	
    }

	

	

}
