package fr.utt.lo02.shapeUp.modele;

import java.util.*;

import fr.utt.lo02.shapeUp.vue.Console;

/**
 * 
 * Représente une partie du jeu ShapeUp. Elle implémente l'interface Visitable pour permettre le calcul des scores.
 * Elle peut être en cours ou terminée.
 * Elle hérite de Observable pour permettre la mise à jour des vues.
 * 
 * @see {@link VuePartie}, {@link Console}
 * 
 * @author Mathéa Z, Shir F
 */
public class Partie extends Observable implements Visitable {

	/**
	 * Modélise l'ensemble des cartes du jeu, qui sont uniques.
	 * @see {@link Set<E>}
	 */
	private Set<Carte> carteDuJeu = new HashSet<Carte> (); 
	
	/**
	 * Modélise la pioche de la partie
	 * Si elle est null, l'exception NullPointerException sera générée dès son utilisation
	 * @see {@link Pioche}
	 */
	private Pioche pioche;
	
	/**
	 * Modélise la classe de score qui calcule celui pour les formes de cartes
	 * @see {@link VisiteurScore}, {@link ScoreForme}
	 * S'il est null, l'exception NullPointerException sera générée dès son utilisation
	 */
	private VisiteurScore scoreForme = new ScoreForme();
	
	/**
	 * Modélise la classe de score qui calcule celui pour les couleurs de cartes
	 * S'il est null, l'exception NullPointerException sera générée dès son utilisation
	 * @see {@link VisiteurScore}, {@link ScoreCouleur}
	 */
	private VisiteurScore scoreCouleur = new ScoreCouleur();
	
	/**
	 * Modélise la classe de score qui calcule celui pour le remplissage des cartes
	 * S'il est null, l'exception NullPointerException sera générée dès son utilisation
	 * @see {@link VisiteurScore}, {@link ScoreRemplissage}
	 */
	private VisiteurScore scoreRemplissage = new ScoreRemplissage();
	
	/**
	 * Modélise la liste des joueurs de la partie. Elle peut en contenir 2 ou 3.
	 * Si elle est null, l'exception NullPointerException sera générée dès son utilisation
	 * @see {@link Queue<E>}, {@link LinkedList<E>}
	 */
	private Queue<Joueur> queueJoueurs;

	/**
	 * Modélise le tapis de jeu de la partie. Il peut avoir une forme triangulaire, rectangulaire ou circulaire
	 * S'il est null, l'exception NullPointerException sera générée dès son utilisation
	 * @see {@link TapisDeJeu}
	 */
	private TapisDeJeu tapisDeJeu;
	
	/**
	 * Représente le statut de la partie. La valeur true signifie que la partie est terminée.
	 */
	private boolean estFinie;
	
	/**
	 * Modélise le nombre de cartes pouvant être placées sur le tapis de jeu.
	 * Si elle est à 0, alors la partie sera terminée alors qu'elle n'a pas été commencée.
	 * @see {@link #tourDeJeu()}
	 * 
	 * Valeurs valides : {15;14}
	 */
	private int nbCartesJouables;
	
	/**
	 * Modélise le joueur actif (en jeu) à un instant T, parmi les joueurs de la partie.
	 * S'il est null, l'exception NullPointerException sera générée dès son utilisation
	 */
	private Joueur joueurActif;
	
	/**
	 * Modélise le mode de la partie : StrategieAvance, StrategieVictoireEnnemie, ou StrategieDeBase
	 * S'il est null, l'exception NullPointerException sera générée dès son utilisation
	 * @see {@link StrategieMode}, {@link StrategieAvance}, {@link StrategieVictoireEnnemie}, {@link StrategieDeBase}
	 */
	private StrategieMode modeDeJeu;
	
	/**
	 * Getter de la pioche de la partie
	 * @return la pioche
	 */
	public Pioche getPioche() {
		return pioche;
	}
	
	/**
	 * Setter de la pioche de la partie
	 * @param pioche
	 */
	public void setPioche(Pioche pioche) {
		this.pioche = pioche;
	}
	
	/**
	 * Getter de la liste de joueurs de la partie
	 * @return la queue de joueurs
	 */
	public Queue<Joueur> getQueueJoueurs() {
		return queueJoueurs;
	}
	
	/**
	 * Setter de la liste de joueurs de la partie 
	 * @param queueJoueurs
	 */
	public void setQueueJoueurs(Queue<Joueur> queueJoueurs) {
		this.queueJoueurs = queueJoueurs;
	}

	/**
	 * Getter du statut de la partie
	 * @return true si la partie est finie
	 */
	public boolean isEstFinie() {
		return estFinie;
	}
	
	/**
	 * Setter du statut de la partie
	 * @param estFinie - le statut de la partie
	 */
	public void setEstFinie(boolean estFinie) {
		this.estFinie = estFinie;
	}
	
	/**
	 * Getter de l'ensemble des cartes du jeu
	 * @return le Set de cartes
	 */
	public Set<Carte> getCarteDuJeu() {
		return carteDuJeu;
	}
	
	/**
	 * Setter de l'ensemble des cartes du jeu
	 * @param carteDuJeu
	 */
	public void setCarteDuJeu(Set<Carte> carteDuJeu) {
		this.carteDuJeu = carteDuJeu;
	}

	/**
	 * Getter du mode de jeu
	 * @return le mode
	 */
	public StrategieMode getModeDeJeu() {
		return modeDeJeu;
	}
	
	/**
	 * Setter du mode de jeu
	 * @param modeDeJeu
	 */
	public void setModeDeJeu(StrategieMode modeDeJeu) {
		this.modeDeJeu = modeDeJeu;
	}
	
	/**
	 * Getter du tapis de jeu de la partie
	 * @return le tapis
	 */
	public TapisDeJeu getTapisDeJeu() {
		return tapisDeJeu;
	}
	
	/**
	 * Setter du tapis de jeu de la partie
	 * @param tapisDeJeu
	 */
	public void setTapisDeJeu(TapisDeJeu tapisDeJeu) {
		this.tapisDeJeu = tapisDeJeu;
	}
	
	/**
	 * Getter du nombre de cartes jouables de la partie
	 * @return le nombre de cartes
	 */
	public int getNbCartesJouables() {
		return nbCartesJouables;
	}
	
	/**
	 * Setter du nombre de cartes jouables de la partie
	 * @param nbCartesJouables
	 */
	public void setNbCartesJouables(int nbCartesJouables) {
		this.nbCartesJouables = nbCartesJouables;
	}
	
	/**
	 * Getter du joueur actif de la partie
	 * @return le joueur actif
	 */
	public Joueur getJoueurActif() {
		return joueurActif;
	}

	/**
	 * Setter du joueur actif de la partie
	 * @param joueurActif
	 */
	public void setJoueurActif(Joueur joueurActif) {
		this.joueurActif = joueurActif;
	}
	
	/**
	 * Instancie une partie en récupérant les paramètres définis dans ShapeUp. 
	 * On définie les attributs de la partie, on crée les cartes et la pioche
	 * @param joueurs 
	 * @param mode
	 * @param formeTapisDeJeu
	 * 
	 * @exception NullPointerException - Si le mode ou la liste de joueurs est null
	 * 
	 * @see {@link ShapeUp}, {@link StrategieMode}, {@link TapisDeJeu}
	 * 
	 */
	Partie(Queue<Joueur> joueurs, StrategieMode mode, TapisDeJeu formeTapisDeJeu){
		
		this.setQueueJoueurs(joueurs);
		this.setModeDeJeu(mode);
		this.tapisDeJeu = formeTapisDeJeu;
		this.créerLesCartes();
		this.setEstFinie(false);
		this.setNbCartesJouables(this.getCarteDuJeu().size() - (this.getQueueJoueurs().size()+1));
		this.pioche = mode.creerLaPiocheDeLaPartie(this);
	}

	
	/**
	 * Crée les 18 cartes de la partie. Elles ont une combinaison forme, couleur, remplissage unique. 
	 * Toutes les combinaisons possibles sont utilisées grâce à 2 boucles for.
	 */
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

	/**
     * Redéfinition de la méthode toString(), qui présente la partie par sa liste de joueurs, son mode et sa forme de tapis de jeu
     * @return le String Buffer converti en String
     */
	public String toString() {
    	StringBuffer sb = new StringBuffer();
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
	
	/**
	 * Récupère le score calculé par le visiteur en paramètre pour le joueur en paramètre
	 * 
	 * @param le visiteur - ScoreForme, ScoreCouleur ou ScoreRemplissage
	 * @return le score du joueur pour tel visiteur
	 * @exception NullPointerException - Si le visiteur ou le joueur est null
	 * @see {@link VisiteurScore}, {@link ScoreRemplissage}, {@link ScoreForme}, {@link ScoreCouleur}
	 */
	public int accepterScore(VisiteurScore visiteur, Joueur joueur) {

		int score = visiteur.visiter(this, joueur.getCarteDeVictoire());
		return score;
	}
	
	/**
	 * Modélise un tour de jeu de la partie.
	 * 
	 * Après avoir récupéré le 1er joueur de la queue et l'avoir défini comme joueur actif, on appelle la méthode jouer() du joueur.
	 * Puis on déplace le joueur au bout de la queue.
	 * Lorsque le tapis de jeu a atteint son nombre maximal de cartes, la partie est finie
	 * 
	 * @see {@link Joueur#jouer(Partie,TapisDeJeu,Pioche,StrategieMode)}
	 */
	public void tourDeJeu()  {
		
		
		this.setJoueurActif(queueJoueurs.peek());

		this.notifyObservers("\n"+"** Au tour de " + this.joueurActif.getNom()+" **");
		
		this.getJoueurActif().setLigCarteGUI(-1);
		this.getJoueurActif().setNumCarteGUI(-1);
		
		queueJoueurs.peek().jouer(this, this.getTapisDeJeu(), this.getPioche(), this.getModeDeJeu());
		queueJoueurs.add(queueJoueurs.poll());
		
		if(this.getTapisDeJeu().getNbCartes() == this.nbCartesJouables) {
			this.setEstFinie(true);
		}
	}

	/**
	 * Calcule le score total du joueur en paramètre en appelant la méthode accepterScore(VisiteurScore, Joueur)
	 * @param joueur
	 * @return le score total du joueur - entier
	 * 
	 * @exception NullPointerException - Si le joueur est null
	 * 
	 * @see {@link #accepterScore(VisiteurScore, Joueur)}
	 */
    public int calculerScoreTotal(Joueur joueur) {

    	int scoreTotal = this.accepterScore(this.scoreForme, joueur)+ this.accepterScore(this.scoreCouleur, joueur)+ this.accepterScore(scoreRemplissage, joueur);
    	return scoreTotal;
    }
    
    /**
     * 
     */
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
    	} else {
    		this.notifyObservers("Egalité ! ;)");
    	}
		
    	
    }

	

	

}
