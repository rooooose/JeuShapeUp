package fr.utt.lo02.shapeUp.vue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import fr.utt.lo02.shapeUp.modele.Joueur;
import fr.utt.lo02.shapeUp.modele.Observable;
import fr.utt.lo02.shapeUp.modele.Observer;
import fr.utt.lo02.shapeUp.modele.Partie;
import fr.utt.lo02.shapeUp.modele.ShapeUp;
import fr.utt.lo02.shapeUp.modele.StrategieAvance;
import fr.utt.lo02.shapeUp.modele.StrategieDeBase;
import fr.utt.lo02.shapeUp.modele.StrategieMode;
import fr.utt.lo02.shapeUp.modele.StrategieVictoireEnnemie;
import fr.utt.lo02.shapeUp.modele.TapisCercle;
import fr.utt.lo02.shapeUp.modele.TapisDeJeu;
import fr.utt.lo02.shapeUp.modele.TapisRectangle;
import fr.utt.lo02.shapeUp.modele.TapisTriangleRectangle;

/**
 * 
 * Mod�lise la console avec laquelle un joueur r�el peut interagir pour passer et recevoir des informations du jeu.
 * Il poss�de un Thread qui lui est propre pour permettre la concurrence avec l'interface graphique, elle impl�mente donc Runnable.
 * Elle impl�mente aussi Observer pour observer les classes du mod�le et se mettre � jour en cons�quence.
 * @see Observer
 * @see Runnable
 *
 * @author Math�a Z, Shir F
 */
public class Console implements Observer, Runnable {
	
	/**
	 * Repr�sente le jeu ShapeUp, qui lance une partie selon divers param�tres.
	 * Si elle est null, l'exception NullPointerException sera g�n�r�e d�s son utilisation
	 * @see ShapeUp
	 */
	private ShapeUp jeuShapeUp;
	
	/**
	 * Repr�sente la partie lanc�e
	 * Si elle est null, l'exception NullPointerException sera g�n�r�e d�s son utilisation
	 * @see Partie
	 */
	private Partie partie;
	
	/**
	 * Mod�lise la liste des joueurs de la partie. Elle peut en contenir 2 ou 3.
	 * Si elle est null, l'exception NullPointerException sera g�n�r�e d�s son utilisation
	 * @see Queue<E>, LinkedList<E>
	 */
	private Queue<Joueur> joueurs = new LinkedList<Joueur>();
	
	/**
	 * Repr�sente un lecteur de flux d'entr�e en mode caract�res, permettant au joueur d'entrer des donn�es dans la console.
	 * S'il est null, l'exception NullPointerException sera g�n�r�e d�s son utilisation
	 * @see BufferedReader
	 */
	private BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
	
	/**
	 * Repr�sente le thread associ� � la console.
	 * S'il est null, l'exception NullPointerException sera g�n�r�e d�s son utilisation
	 * @see Thread
	 */
	private Thread t;
	
	/**
	 * Repr�sente le nombre de fois que la m�thode definirNomJoueur(int nb) a �t� appel�e. Elle permet de ne pas cr�er une 2�me fois le joueur dans l'interface graphique.
	 * En effet le notifyObserver actionne le bouton de validation de la cr�ation du joueur, et appelle donc le controleur qui cr�e le joueur.
	 * Il peut etre �gal � 0, 1, 2 ou 3, selon le nombre de joueurs de la partie
	 * @see VueShapeUp, ControleurShapeUp, definirNomJoueur(int)
	 */
	private int cptAppelsNom = 0;
	
	/**
	 * Getter du nombre d'appels de la m�thode definirNomJoueur(int)
	 * @return le nombre d'appels de la m�thode
	 */
	public int getCptAppelsNom() {
		return cptAppelsNom;
	}
	
	/**
	 * Setter du nombre d'appels de la m�thode definirNomJoueur(int)
	 * @param cptAppelsNom
	 */
	public void setCptAppelsNom(int cptAppelsNom) {
		this.cptAppelsNom = cptAppelsNom;
	}

	/**
	 * Instancie la console en lui associant le jeu ShapeUp et en l'ajoutant � la liste d'observers de ShapeUp.
	 * Son thread est �galement cr�e et d�marr�.
	 * @param s - le jeu ShapeUp
	 * @see ShapeUp
	 */
	public Console(ShapeUp s) {
		this.jeuShapeUp = s;
		this.jeuShapeUp.addObserver(this);
		
		t = new Thread(this);
		t.start();
	}

	/**
	 * Met � jour la console par rapport aux modifications faites dans le mod�le, pour correspondre au patron de conception Observer.
	 * Tous les affichages de la console se font ici.
	 * D�s que la partie est cr��e, elle est associ�e � la console.
	 * @param o - l'objet observ� par la console
	 * @param arg - l'objet modifi� pour lequel on souhaite mettre � jour la vue.
	 * 
	 * .
	 */
	public void update(Observable o, Object arg) {
		
		System.out.println(arg);

		if(this.jeuShapeUp.getMaPartie() != null) {
			this.partie = this.jeuShapeUp.getMaPartie();

		}
		
		
	}
	
	/**
	 * Permet � l'utilisateur de choisir le nombre de joueurs de la partie.
	 * Le programme enregistre la valeur entr�e par l'utilisateur dans l'attribut nbDeJoueurs de ShapeUp, gr�ce � la classe BufferedReader, si elle est valide. La valeur peut �galement �tre enregistr�e si elle a �t� choisie depuis l'interface.
	 * En effet dans ce cas, la valeur aura d�ja �t� ajout�e � nbDeJoueurs.
	 * 
	 * @see nbDeJoueurs
	 * @see ControleurShapeUp
	 * 
	 * @return le nombre de joueurs - 2 ou 3
	 * 
	 * 
	 */
	public int choisirNbJoueurs() {
		
		String resultat = "";
		int nb = 0;
		try {
			do {
			  System.out.println("Veuillez choisir le nombre de joueurs pour votre partie (2 ou 3) : ");
		      resultat = br.readLine();
		      
		      if(this.jeuShapeUp.getNbDeJoueurs()!=0) {
		    	  resultat = ((Integer)this.jeuShapeUp.getNbDeJoueurs()).toString();
		    	  nb= Integer.parseInt(resultat);
		    	   
		      }
		      
		      if (!resultat.equals("2") && !resultat.equals("3")) {
		        	System.out.println("Je suis d�sol�e, vous ne pouvez choisir que 2 ou 3 joueurs.");
		      } 
		      
			}while (!resultat.equals("2") && !resultat.equals("3"));
			
		} catch (IOException e) {
		      System.err.println(e.getMessage());
		}
		
		if(this.jeuShapeUp.getNbDeJoueurs()==0) {
			nb= Integer.parseInt(resultat);
		    this.jeuShapeUp.setNbDeJoueurs(nb);
		}
		
	    return nb;
    }
	
	/**
	 * Permet � l'utilisateur de choisir le type du joueur nb de la partie.
	 * Le programme enregistre la valeur entr�e par l'utilisateur dans le tableau types de ShapeUp, gr�ce � la classe BufferedReader, si elle est valide. La valeur peut �galement �tre enregistr�e si elle a �t� choisie depuis l'interface.
	 * En effet dans ce cas, la valeur aura d�ja �t� ajout�e au tableau types.
	 * @param nb - le num�ro du joueur - 1, 2, ou 3
	 * @return le type du joueur - "v" pour r�el ou "r" pour virtuel, qui sera utilis� pour cr�er les joueurs dans la classe ShapeUp
	 * 
	 * @see creerJoueur(String,String)
	 * @see ControleurShapeUp
	 * 
	 */
	public String definirTypeJoueur(int nb) {
    	
    	String type="";

    	do {
			System.out.println("Veuillez choisir le type du joueur " + nb + ": virtuel (v) ou r�el (r) ?");
			try {	   
				type = br.readLine();
				  
				
				if (!type.equals("v") && !type.equals("r") && this.jeuShapeUp.getTypes().size() < nb) {
			        System.out.println("Je suis d�sol�e, vous ne pouvez choisir qu'entre virtuel (v) ou r�el (r).");
			    }

				else if(this.jeuShapeUp.getTypes().size() >= nb) {
					type = this.jeuShapeUp.getTypes().get(nb-1);
					
				}
				
				 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		}while (!type.equals("v") && !type.equals("r") && this.jeuShapeUp.getTypes().size() < nb);
    	
    	if(this.jeuShapeUp.getTypes().size() < nb) {
    		this.jeuShapeUp.getTypes().add(type);
    		this.jeuShapeUp.notifyObservers(type);
		}
    	
    	
    	return type;
    }
	
	/**
	 * Permet � l'utilisateur de choisir le nom du joueur nb de la partie.
	 * Le programme enregistre la valeur entr�e par l'utilisateur dans le tableau nomsJoueurs de ShapeUp, gr�ce � la classe BufferedReader.
	 * La valeur peut �galement �tre enregistr�e si elle a �t� choisie depuis l'interface. En effet dans ce cas, la valeur aura d�ja �t� ajout�e au tableau nomsJoueurs.
	 * @param nb - le num�ro du joueur - 1, 2, ou 3
	 * @return le nom du joueur qui sera utilis� pour cr�er le joueur dans la classe ShapeUp
	 * 
	 * 
	 * @see creerJoueur(String,String)
	 * @see nomsJoueurs
	 * @see ControleurShapeUp
	 * 
	 */
	public String definirNomJoueur(int nb) {
	    	
	    	String nom = "";
	    	this.setCptAppelsNom(this.getCptAppelsNom() + 1);
	    	
	    	do {

     		    System.out.println("Veuillez choisir le nom du joueur " + nb + ": \n");

     		    try {
					nom = br.readLine();
					//si le nom du joueur est deja d�fini
					if(this.jeuShapeUp.getNomsJoueurs().size() >= nb) {
						nom = this.jeuShapeUp.getNomsJoueurs().get(nb-1);
					}
					else if(nom == "" && this.jeuShapeUp.getNomsJoueurs().size() < nb) {
	     		    	System.out.println("Nom par d�faut");
	     		    	nom = "Joueur " + nb;
				    } else if (this.jeuShapeUp.getNomsJoueurs().contains(nom)) {
				        System.out.println("Je suis d�sol�e, chaque joueur doit avoir un nom unique");
				    }
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
     		    
			}while (this.jeuShapeUp.getNomsJoueurs().contains(nom) && this.jeuShapeUp.getNomsJoueurs().size() < nb);
	    	
	    	if(this.jeuShapeUp.getNomsJoueurs().size() < nb) {
	    		this.jeuShapeUp.getNomsJoueurs().add(nom);
	    	}
	    	
	    	return nom;
	    }
	    
	/**
	 * Permet � l'utilisateur de choisir le mode de la partie.
	 * 
	 * Le programme enregistre la valeur entr�e par l'utilisateur (une lettre repr�sentant le mode) dans l'attribut mode de ShapeUp, gr�ce � la classe BufferedReader, en la convertissant en un objet de la bonne classe.
	 * La valeur peut �galement �tre enregistr�e si elle a �t� choisie depuis l'interface. En effet dans ce cas, la valeur aura d�ja �t� ajout�e � l'attribut mode de la classe ShapeUp.
	 * 
	 * @see StrategieMode
	 * @see StrategieDeBase
	 * @see StrategieAvancee
	 * @see StrategieVictoireEnnemie
	 * @see mode
	 * @see ControleurShapeUp
	 * 
	 * @return le mode de jeu - de type StrategieDeBase, StrategieAvancee ou StrategieVictoireEnnemie
	 * 
	 */
	    public StrategieMode choisirMode() {
	    	
	    	StrategieMode mode = null;
	    	String lettreMode="";
	    	do {
	    		System.out.println("Veuillez choisir le mode de partie : \n \t-Mode de Base (b)\n \t-Mode Avanc� (a)\n\t-Mode Victoire Ennemie (v)");
	    		
	    		try {
					lettreMode = br.readLine();
					
					if(this.jeuShapeUp.getMode()!=null) {
						if((mode = this.jeuShapeUp.getMode()) instanceof StrategieDeBase) {
							lettreMode="b";
						} else if ((mode = this.jeuShapeUp.getMode()) instanceof StrategieAvance) {
							lettreMode="a";
						} else if ((mode = this.jeuShapeUp.getMode()) instanceof StrategieVictoireEnnemie) {
							lettreMode="v";
						}
				     }
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		if (!lettreMode.equals("b") && !lettreMode.equals("a") && !lettreMode.equals("v")) {
			        System.out.println("Je suis d�sol�e, vous ne pouvez choisir qu'entre les 3 modes propos�s.");
			    }  
			}while (!lettreMode.equals("b") && !lettreMode.equals("a") && !lettreMode.equals("v"));
	    	
	    	if(this.jeuShapeUp.getMode()==null) {
	    		
	    		switch(lettreMode.charAt(0)) {
					case 'b' :
						mode = new StrategieDeBase();
						break;
					case 'a' :
						mode = new StrategieAvance();
						break;
					case 'v' :
						mode = new StrategieVictoireEnnemie();
						break;
	    		}
	    		
	    		this.jeuShapeUp.setMode(mode);
	    	}
	    	return mode;
	    	
	    	
	    }
	    
	    /**
		 * Permet � l'utilisateur de choisir la forme de tapis de la partie.
		 * Le programme enregistre la valeur entr�e par l'utilisateur (une lettre repr�sentant la forme) dans l'attribut formeTapis de ShapeUp, gr�ce � la classe BufferedReader, en la convertissant en un objet de la bonne classe.
		 * La valeur peut �galement �tre enregistr�e si elle a �t� choisie depuis l'interface. En effet dans ce cas, la valeur aura d�ja �t� ajout�e � l'attribut formeTapis de la classe ShapeUp.
		 * 
		 * @return la forme de tapis - de type TapisRectangle, TapisCercle ou TapisTriangleRectangle
		 * 
		 * @see TapisRectangle
		 * @see TapisCercle
		 * @see TapisTriangleRectangle
		 * @see formeTapis
		 * @see ControleurShapeUp
		 * 
		 */
	    public TapisDeJeu choisirFormeTapis() {
	    	
	    	TapisDeJeu forme = null;
	    	String lettreForme="";
	    	do {
	    		
	    		System.out.println("Veuillez choisir la forme du tapis : \n \t-Rectangle 5x3 (r)\n \t-Triangle rectangle (t)\n \t-Disque (d)");

     		try {
				lettreForme = br.readLine();
				
				if(this.jeuShapeUp.getFormeTapis()!=null) {
					if ((forme = this.jeuShapeUp.getFormeTapis()) instanceof TapisRectangle) {
						lettreForme="r";
						
					} else if ((forme = this.jeuShapeUp.getFormeTapis()) instanceof TapisTriangleRectangle) {
						lettreForme="t";
						
					} else if ((forme = this.jeuShapeUp.getFormeTapis()) instanceof TapisCercle) {
						lettreForme="d";
						
					} 
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
     		
     		if (!lettreForme.equals("r") && !lettreForme.equals("t") && !lettreForme.equals("d")) {
     			
			        System.out.println("Je suis d�sol�e, vous ne pouvez choisir qu'entre les formes propos�es.");
			    }  
			}while (!lettreForme.equals("r") && !lettreForme.equals("t") && !lettreForme.equals("d"));
	    	
	    	if(this.jeuShapeUp.getFormeTapis()==null) {
	    		switch(lettreForme.charAt(0)) {
					case 'r' :
						forme = new TapisRectangle();
						break;
					case 't' :
						forme = new TapisTriangleRectangle();
						break;
					case 'd' :
						forme = new TapisCercle();
						break;
	    		}
	    		this.jeuShapeUp.setFormeTapis(forme);
	    	}
	    	return forme;
	    }

	/**
	 * 
	 * Ici la m�thode run() ex�cute le programme du jeu depuis la d�finition des param�tres de la partie jusqu'� l'affichage du gagnant.
	 * La console est �galement ajout�e � la liste d'Observers de chaque objet du jeu qui le n�cessite, d�s leur cr�ation.
	 */
	public void run() {

	    int nbJoueurs = this.choisirNbJoueurs();
				
		for(int i=1; i<=nbJoueurs; i++) {

			if(this.jeuShapeUp.getQueueJoueurs().size() < i) {
				String nom = "";
				this.jeuShapeUp.creerJoueur(this.definirTypeJoueur(i), nom = this.definirNomJoueur(i));
				this.jeuShapeUp.notifyObservers(nom);
			}
		}
	
		if(this.jeuShapeUp.getMaPartie() == null) {
			
			this.jeuShapeUp.lancerLaPartie(this.jeuShapeUp.getQueueJoueurs(), this.choisirMode(), this.choisirFormeTapis());
			this.partie = this.jeuShapeUp.getMaPartie();
			this.jeuShapeUp.notifyObservers(this.partie);
		}
		this.partie.addObserver(this);
		this.joueurs = this.partie.getQueueJoueurs();
		Iterator<Joueur> it = this.joueurs.iterator();
		while(it.hasNext()) {
			it.next().addObserver(this);
		}

		if(this.partie.getModeDeJeu() instanceof StrategieDeBase) {
			StrategieDeBase mode = (StrategieDeBase) this.partie.getModeDeJeu();
			mode.addObserver(this);

		} else if(this.partie.getModeDeJeu() instanceof StrategieVictoireEnnemie) {
			StrategieVictoireEnnemie mode = (StrategieVictoireEnnemie) this.partie.getModeDeJeu();
			mode.addObserver(this);

		} else if(this.partie.getModeDeJeu() instanceof StrategieAvance) {
			StrategieAvance mode = (StrategieAvance) this.partie.getModeDeJeu();
			mode.addObserver(this);
		}
	
		
		while(!this.partie.isEstFinie()) {
			this.partie.tourDeJeu();
		}

		this.partie.getModeDeJeu().finirLaPartie(jeuShapeUp.getMaPartie());
		
	}
	
	
}
