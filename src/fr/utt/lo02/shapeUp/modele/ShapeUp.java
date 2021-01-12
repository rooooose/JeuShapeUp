package fr.utt.lo02.shapeUp.modele;

import java.util.*;

import fr.utt.lo02.shapeUp.vue.Console;
import fr.utt.lo02.shapeUp.vue.VueShapeUp;
/**
 * Classe principale du projet ShapeUp, cette classe permet de créer une partie suivant les paramètres demandés par le joueur.
 * Cette classe est observable, elle sera observée par la console et une interface graphique
 * 
 * @author Shir F, Mathéa Z
 * @see Observable
 *
 */
public class ShapeUp extends Observable {

	/**
	 * Cet attribut représente les types de joueurs utilisés dans la partie.
	 */
		private LinkedList<String> types = new LinkedList<String>();
		
		/**
		 * Permet de récupérer le type des joueurs de la partie 
		 * @return un LinkedList contenant les types des joueurs 'r' pour un joueur réel et 'v' pour un joueur virtuel
		 * @see {@link JoueurReel}, {@link JoueurVirtuel}
		 */
		public LinkedList<String> getTypes() {
			return types;
		}

		/**
		 * Cet attribut correspond à l'ensemble des joueurs, modélisé en une collection de type Queue.
		 */
		private Queue<Joueur> queueJoueurs = new LinkedList<Joueur>();


/**
 * Permet de récupérer la collection contenant les joueurs
 * 
 * @return la collection contenant les joueurs 
 */
		public Queue<Joueur> getQueueJoueurs() {
			return queueJoueurs;
		}
/**
 * Permet de définir les joueurs de la partie à partir d'une collection de type Queue
 * @param queueJoueurs
 */
		public void setQueueJoueurs(Queue<Joueur> queueJoueurs) {
			this.queueJoueurs = queueJoueurs;
		}

		/**
		 * Cet attribut correspond à la partie de jeu
		 * 
		 * @see Partie
		 */
		private Partie maPartie;
		
		/**
		 * Permet de récupérer la partie de jeu
		 * @return la partie de jeu construite par ShapeUp
		 */
	    public Partie getMaPartie() {
			return maPartie;
		}
/**
 * Permet de définir la partie de jeu
 * @param maPartie
 */
		public void setMaPartie(Partie maPartie) {
			this.maPartie = maPartie;
		}
/**
 * Cet attribut modélise le nom des joueurs dans l'ordre (utilisation d'une collection de type Queue)
 */
	    private LinkedList<String> nomsJoueurs = new LinkedList<String>();
	    /***
	     * Permet de récupérer la collection contenant le nom des joueurs
	     * @return Collection (LinkedList) contenant les noms des joueurs
	     */
	    public LinkedList<String> getNomsJoueurs() {
			return nomsJoueurs;
		}


	   /**
	    * Cet entier permet de modéliser le nombre de joueurs de la partie (2 ou 3)
	    */
		private int nbDeJoueurs;

		/**
		 * Permet de récupérer le nombre de joueurs de la partie (2 ou 3)
		 * @return le nombre de joueurs de la partie
		 */
		public int getNbDeJoueurs() {
			return nbDeJoueurs;
		}
/**
 * Permet de définir le nombre de de la partie.
 * La méthode va notifier les Observer de ShapeUp qu'il y a eu un changement
 * 
 * @param nbDeJoueurs - définit le nombre de joueurs de la partie
 */
		public void setNbDeJoueurs(int nbDeJoueurs) {
			this.nbDeJoueurs = nbDeJoueurs;
			this.setChanged();
			this.notifyObservers(nbDeJoueurs);
			this.clearChanged();
		}

		/**
		 * Attribut permettant de modéliser le tapis de jeu durant la partie (tapis rectangulaire, tapis triangulaire (triangle rectangle) ou tapis criculaire)
		 * 
		 * @see TapisDeJeu
		 */
		private TapisDeJeu formeTapis;
		
		/**
		 * Attribut permettant de modéliser le mode de jeu utilisé (règles de base, règles avancées ou règles "victoire ennemie")
		 * 
		 * @see StrategieMode
		 */
		private StrategieMode mode;
		
		/**
		 * Permet de récupérer le tapis de jeu utilisé, on pourra donc connaître sa forme (rectangulaire, triangulaire ou circulaire)
		 * @return le tapis de jeu utilisé
		 */
	    public TapisDeJeu getFormeTapis() {
			return formeTapis;
		}

	    /**
	     * Permet de définir le tapis de jeu qui sera utilisé (rectangulaire, triangulaire ou circulaire)
	     * La méthode va notifier les Observer de ShapeUp qu'il y a eu un changement
	     * 
	     * @param formeTapis
	     */
		public void setFormeTapis(TapisDeJeu formeTapis) {
			this.formeTapis = formeTapis;
			this.setChanged();
			this.notifyObservers(formeTapis);
			this.clearChanged();
		}
/**
 * Permet de récupérer le mode jeu utilisé (règles de base, règles avancées ou règles "victoire ennemie")
 * 
 * @return mode de jeu utilisé
 */
		public StrategieMode getMode() {
			return mode;
		}

		/**
		 * Permet de définir le mode de jeu à utiliser (règles de base, règles avancées ou règles "victoire ennemie")
		 * La méthode va notifier les Observer de ShapeUp qu'il y a eu un changement
		 * 
		 * @param mode
		 */
		public void setMode(StrategieMode mode) {
			this.mode = mode;
			this.setChanged();
			this.notifyObservers(mode);
			this.clearChanged();
		}

		/**
		 * Constructeur de la classe ShapeUp
		 */
		public ShapeUp() {

	    }
	    
		/**
		 * Méthode permettant de créer la partie de jeu en fonction des paramètres choisis
		 * @param queueJoueurs collection contenant les joueurs
		 * @param mode mode de jeu (règles de base, règles avancées ou règles "victoire ennemie"
		 * @param forme forme de tapis (rectangulaire, triangulaire ou circulaire)
		 */
	    public void lancerLaPartie(Queue<Joueur> queueJoueurs, StrategieMode mode, TapisDeJeu forme) {
	    	
	    	this.maPartie = new Partie(queueJoueurs, mode, forme);
	    }
	    
	    /**
	     * Méthode permettant de créer un joueur de fonction de son type et de son nom
	     * @param ty 'r' pour un joueur réel ou 'v' pour un joueur virtuel
	     * @param nm nom du joueur
	     * 
	     * @see {@link JoueurReel}, {@link JoueurVirtuel}
	     */
	    public void creerJoueur(String ty, String nm) {
	    	
	    	char type= ty.charAt(0);
	    	String nom = nm;

	    		
	    		switch(type) {
	        	case 'v' :
	        		JoueurVirtuel nouveauJoueurV = new JoueurVirtuel(nom);
	        		
	        		this.queueJoueurs.add(nouveauJoueurV);
	        		this.notifyObservers(nouveauJoueurV);
	        		break;
	        		
	        	case 'r' :
	        		JoueurReel nouveauJoueurR = new JoueurReel(nom);
	        		
	        		this.queueJoueurs.add(nouveauJoueurR);
	        		this.notifyObservers(nouveauJoueurR);
	        		break;
	    		}

	    }



}
