package fr.utt.lo02.shapeUp.modele;

import java.util.*;

import fr.utt.lo02.shapeUp.vue.Console;
import fr.utt.lo02.shapeUp.vue.VueShapeUp;
/**
 * Classe principale du projet ShapeUp, cette classe permet de cr�er une partie suivant les param�tres demand�s par le joueur.
 * Cette classe est observable, elle sera observ�e par la console et une interface graphique
 * 
 * @author Shir F, Math�a Z
 * @see Observable
 *
 */
public class ShapeUp extends Observable {

	/**
	 * Cet attribut repr�sente les types de joueurs utilis�s dans la partie.
	 */
		private LinkedList<String> types = new LinkedList<String>();
		
		/**
		 * Permet de r�cup�rer le type des joueurs de la partie 
		 * @return un LinkedList contenant les types des joueurs 'r' pour un joueur r�el et 'v' pour un joueur virtuel
		 * @see {@link JoueurReel}, {@link JoueurVirtuel}
		 */
		public LinkedList<String> getTypes() {
			return types;
		}

		/**
		 * Cet attribut correspond � l'ensemble des joueurs, mod�lis� en une collection de type Queue.
		 */
		private Queue<Joueur> queueJoueurs = new LinkedList<Joueur>();


/**
 * Permet de r�cup�rer la collection contenant les joueurs
 * 
 * @return la collection contenant les joueurs 
 */
		public Queue<Joueur> getQueueJoueurs() {
			return queueJoueurs;
		}
/**
 * Permet de d�finir les joueurs de la partie � partir d'une collection de type Queue
 * @param queueJoueurs
 */
		public void setQueueJoueurs(Queue<Joueur> queueJoueurs) {
			this.queueJoueurs = queueJoueurs;
		}

		/**
		 * Cet attribut correspond � la partie de jeu
		 * 
		 * @see Partie
		 */
		private Partie maPartie;
		
		/**
		 * Permet de r�cup�rer la partie de jeu
		 * @return la partie de jeu construite par ShapeUp
		 */
	    public Partie getMaPartie() {
			return maPartie;
		}
/**
 * Permet de d�finir la partie de jeu
 * @param maPartie
 */
		public void setMaPartie(Partie maPartie) {
			this.maPartie = maPartie;
		}
/**
 * Cet attribut mod�lise le nom des joueurs dans l'ordre (utilisation d'une collection de type Queue)
 */
	    private LinkedList<String> nomsJoueurs = new LinkedList<String>();
	    /***
	     * Permet de r�cup�rer la collection contenant le nom des joueurs
	     * @return Collection (LinkedList) contenant les noms des joueurs
	     */
	    public LinkedList<String> getNomsJoueurs() {
			return nomsJoueurs;
		}


	   /**
	    * Cet entier permet de mod�liser le nombre de joueurs de la partie (2 ou 3)
	    */
		private int nbDeJoueurs;

		/**
		 * Permet de r�cup�rer le nombre de joueurs de la partie (2 ou 3)
		 * @return le nombre de joueurs de la partie
		 */
		public int getNbDeJoueurs() {
			return nbDeJoueurs;
		}
/**
 * Permet de d�finir le nombre de de la partie.
 * La m�thode va notifier les Observer de ShapeUp qu'il y a eu un changement
 * 
 * @param nbDeJoueurs - d�finit le nombre de joueurs de la partie
 */
		public void setNbDeJoueurs(int nbDeJoueurs) {
			this.nbDeJoueurs = nbDeJoueurs;
			this.setChanged();
			this.notifyObservers(nbDeJoueurs);
			this.clearChanged();
		}

		/**
		 * Attribut permettant de mod�liser le tapis de jeu durant la partie (tapis rectangulaire, tapis triangulaire (triangle rectangle) ou tapis criculaire)
		 * 
		 * @see TapisDeJeu
		 */
		private TapisDeJeu formeTapis;
		
		/**
		 * Attribut permettant de mod�liser le mode de jeu utilis� (r�gles de base, r�gles avanc�es ou r�gles "victoire ennemie")
		 * 
		 * @see StrategieMode
		 */
		private StrategieMode mode;
		
		/**
		 * Permet de r�cup�rer le tapis de jeu utilis�, on pourra donc conna�tre sa forme (rectangulaire, triangulaire ou circulaire)
		 * @return le tapis de jeu utilis�
		 */
	    public TapisDeJeu getFormeTapis() {
			return formeTapis;
		}

	    /**
	     * Permet de d�finir le tapis de jeu qui sera utilis� (rectangulaire, triangulaire ou circulaire)
	     * La m�thode va notifier les Observer de ShapeUp qu'il y a eu un changement
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
 * Permet de r�cup�rer le mode jeu utilis� (r�gles de base, r�gles avanc�es ou r�gles "victoire ennemie")
 * 
 * @return mode de jeu utilis�
 */
		public StrategieMode getMode() {
			return mode;
		}

		/**
		 * Permet de d�finir le mode de jeu � utiliser (r�gles de base, r�gles avanc�es ou r�gles "victoire ennemie")
		 * La m�thode va notifier les Observer de ShapeUp qu'il y a eu un changement
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
		 * M�thode permettant de cr�er la partie de jeu en fonction des param�tres choisis
		 * @param queueJoueurs collection contenant les joueurs
		 * @param mode mode de jeu (r�gles de base, r�gles avanc�es ou r�gles "victoire ennemie"
		 * @param forme forme de tapis (rectangulaire, triangulaire ou circulaire)
		 */
	    public void lancerLaPartie(Queue<Joueur> queueJoueurs, StrategieMode mode, TapisDeJeu forme) {
	    	
	    	this.maPartie = new Partie(queueJoueurs, mode, forme);
	    }
	    
	    /**
	     * M�thode permettant de cr�er un joueur de fonction de son type et de son nom
	     * @param ty 'r' pour un joueur r�el ou 'v' pour un joueur virtuel
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
