package vue;

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

import shapeUp.Joueur;
import shapeUp.Observable;
import shapeUp.Observer;
import shapeUp.Partie;
import shapeUp.ShapeUp;
import shapeUp.StrategieAvance;
import shapeUp.StrategieDeBase;
import shapeUp.StrategieMode;
import shapeUp.StrategieVictoireEnnemie;
import shapeUp.TapisCercle;
import shapeUp.TapisDeJeu;
import shapeUp.TapisRectangle;
import shapeUp.TapisTriangleRectangle;

public class Console implements Observer, Runnable {
	
	private ShapeUp jeuShapeUp;
	private Partie partie;
	private Queue<Joueur> joueurs = new LinkedList<Joueur>();
	private final Scanner scan = new Scanner (System.in);
	private BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
	private Thread t;
	private int cptAppelsType = 0;
	private int cptAppelsNom = 0;
	
	public Console(ShapeUp s) {
		this.jeuShapeUp = s;
		this.jeuShapeUp.addObserver(this);
		
		t = new Thread(this);
		t.start();
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
		System.out.println(arg);
		if(this.jeuShapeUp.getNbDeJoueurs() != 0) {
			System.out.println("Appuyez sur Entr�e pour continuer");
		}	
		
	}
	
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
		    	  //System.out.print("Appuyez sur Entr�e pour continuer");
		      }
		     // if (resultat != '2' && resultat != '3') {
		      if (!resultat.equals("2") && !resultat.equals("3")) {
		        	//this.notifyObservers("Je suis d�sol�e, vous ne pouvez choisir que 2 ou 3 joueurs.");
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
	
	public String definirTypeJoueur(int nb) {
    	
    	String type="";
    	this.cptAppelsType++;
    	//String resultat = "";
    	do {
    		//this.notifyObservers("Veuillez choisir le type du joueur " + nb + ": virtuel (v) ou r�el (r) ?");
			System.out.println("Veuillez choisir le type du joueur " + nb + ": virtuel (v) ou r�el (r) ?");
			try {
				type = br.readLine();
				
				if(this.jeuShapeUp.getTypes().size() == this.cptAppelsType) {
					type = this.jeuShapeUp.getTypes().get(nb-1);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//type = resultat.charAt(0);
//			scan.nextLine();

		    if (!type.equals("v") && !type.equals("r")) {
		    	//this.notifyObservers("Je suis d�sol�e, vous ne pouvez choisir qu'entre virtuel (v) ou r�el (r).");
		        System.out.println("Je suis d�sol�e, vous ne pouvez choisir qu'entre virtuel (v) ou r�el (r).");
		    } 
		    
		}while (!type.equals("v") && !type.equals("r"));
    	
    	if(this.jeuShapeUp.getTypes().size() < this.cptAppelsType) {
    		this.jeuShapeUp.getTypes().add(type);
    		this.jeuShapeUp.notifyObservers(type);
		}
    	
    	
    	return type;
    }
	
	 public String definirNomJoueur(int nb) {
	    	
	    	String nom = "";
	    	this.cptAppelsNom++;
	    	do {
	    		//this.notifyObservers("Veuillez choisir le nom du joueur " + nb + ": \n");
     		    System.out.println("Veuillez choisir le nom du joueur " + nb + ": \n");
     		    //nom = scan.nextLine();
     		    try {
					nom = br.readLine();
					
//					if(this.jeuShapeUp.getNomsJoueurs().size() == this.cptAppelsType) {
//						Object[] noms = this.jeuShapeUp.getNomsJoueurs().toArray()[];
//						nom = this.jeuShapeUp.getNomsJoueurs().get(0);
//					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
     		    
     		    if(nom == "") {
     		    	System.out.println("Nom par d�faut");
     		    	nom = "Joueur " + nb;
			    	//this.jeuShapeUp.getNomsJoueurs().add("Joueur " + nb);
			    } else if (this.jeuShapeUp.getNomsJoueurs().contains(nom)) {
     				//this.notifyObservers("Je suis d�sol�e, chaque joueur doit avoir un nom unique");
			        System.out.println("Je suis d�sol�e, chaque joueur doit avoir un nom unique");
			    }
			}while (this.jeuShapeUp.getNomsJoueurs().contains(nom) && nom != "");
	    	
	    	if(this.jeuShapeUp.getNomsJoueurs().size() < this.cptAppelsNom) {
	    		this.jeuShapeUp.getNomsJoueurs().add(nom);
		    	this.jeuShapeUp.notifyObservers(nom);
	    	}
	    	
	    	return nom;
	    }
	    

	    public StrategieMode choisirMode() {
	    	
	    	StrategieMode mode;
	    	char lettreMode='b';
	    	do {
	    		//this.notifyObservers("Veuillez choisir le mode de partie : \n \t-Mode de Base (b)\n \t-Mode Avanc� (a)\n\t-Mode Victoire Ennemie (v)");
	    		System.out.println("Veuillez choisir le mode de partie : \n \t-Mode de Base (b)\n \t-Mode Avanc� (a)\n\t-Mode Victoire Ennemie (v)");
     		lettreMode = scan.next().charAt(0);
 			scan.nextLine();
     		if (lettreMode!= 'b' && lettreMode!= 'a' && lettreMode!= 'v') {
     				//this.notifyObservers("Je suis d�sol�e, vous ne pouvez choisir qu'entre les 3 modes propos�s.");
			        System.out.println("Je suis d�sol�e, vous ne pouvez choisir qu'entre les 3 modes propos�s.");
			    }  
			}while (lettreMode!= 'b' && lettreMode!= 'a' && lettreMode!= 'v');
	    	
	    	switch(lettreMode) {
				case 'b' :
					
					mode = new StrategieDeBase();
					this.jeuShapeUp.setMode(mode);
					this.jeuShapeUp.notifyObservers(mode);
					return mode;
				case 'a' :
					
					
					mode = new StrategieAvance();
					this.jeuShapeUp.setMode(mode);
					this.jeuShapeUp.notifyObservers(mode);
					return mode;
					
				case 'v' :
					mode = new StrategieVictoireEnnemie();
					this.jeuShapeUp.setMode(mode);
					this.jeuShapeUp.notifyObservers(mode);
					return mode;

				default :
					return null;
	    	}
	    	
	    	
	    }
	    
	    
	    public TapisDeJeu choisirFormeTapis() {
	    	
	    	TapisDeJeu forme;
	    	char lettreForme='b';
	    	do {
	    		//this.notifyObservers("Veuillez choisir la forme du tapis : \n \t-Rectangle 5x3 (r)\n \t-Triangle rectangle (t)\n \t-Disque (d)");
	    		System.out.println("Veuillez choisir la forme du tapis : \n \t-Rectangle 5x3 (r)\n \t-Triangle rectangle (t)\n \t-Disque (d)");
     		lettreForme = scan.next().charAt(0);
 			scan.nextLine();
     		if (lettreForme!= 'r' && lettreForme!= 't' && lettreForme!= 'd') {
     				//this.notifyObservers("Je suis d�sol�e, vous ne pouvez choisir qu'entre les formes propos�es.");
			        System.out.println("Je suis d�sol�e, vous ne pouvez choisir qu'entre les formes propos�es.");
			    }  
			}while (lettreForme!= 'r' && lettreForme!= 't' && lettreForme!= 'd');
	    	
	    	switch(lettreForme) {
				case 'r' :
					forme = new TapisRectangle();
					this.jeuShapeUp.setFormeTapis(forme);
					this.jeuShapeUp.notifyObservers(forme);
					return forme;
				case 't' :
					forme = new TapisTriangleRectangle();
					this.jeuShapeUp.setFormeTapis(forme);
					this.jeuShapeUp.notifyObservers(forme);
					return forme;
			case 'd' :
					forme = new TapisCercle();
					this.jeuShapeUp.setFormeTapis(forme);
					this.jeuShapeUp.notifyObservers(forme);
					return forme;		
				default :
					return null;
	    	}
	    }

	@Override
	public void run() {

		//ShapeUp jeuShapeUp = new ShapeUp();
		int nbJoueurs = 0;
		//while(!nbJoueursDde) {
			nbJoueurs = this.choisirNbJoueurs();
		//}
				
		for(int i=1; i<=nbJoueurs; i++) {
			this.jeuShapeUp.creerJoueur(this.definirTypeJoueur(i), this.definirNomJoueur(i));
			System.out.println("Je cr�e un joueur console");
		}
		
		
    	this.jeuShapeUp.lancerLaPartie(this.jeuShapeUp.getQueueJoueurs(), this.choisirMode(), this.choisirFormeTapis());
    	
    	this.partie = this.jeuShapeUp.getMaPartie();
		this.partie.addObserver(this);
		
		this.joueurs = this.partie.getQueueJoueurs();
		Iterator<Joueur> it = this.joueurs.iterator();
		while(it.hasNext()) {
			it.next().addObserver(this);
		}
		//this.mode = this.partie.getModeDeJeu();
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
		
		
		System.out.println(this.jeuShapeUp);
		
		while(!this.jeuShapeUp.getMaPartie().isEstFinie()) {
			this.jeuShapeUp.getMaPartie().tourDeJeu();
		}
		//System.out.println("Partie finie !"+"\n");
		this.jeuShapeUp.getMaPartie().getModeDeJeu().finirLaPartie(jeuShapeUp.getMaPartie());
		
	}

	
	
}
