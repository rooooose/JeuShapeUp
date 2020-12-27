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
	private Thread t;
	private boolean nbJoueursDde = false;
	
	public Console(ShapeUp s) {
		this.jeuShapeUp = s;
		this.jeuShapeUp.addObserver(this);
		
		t = new Thread(this);
		t.start();
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
		if (this.jeuShapeUp.getNbDeJoueurs() > 0) {
			//nbJoueursDde = true;
			//System.out.println(this.jeuShapeUp.getNbDeJoueurs());
			Robot robot = null;
			try {
				robot = new Robot();
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//robot.keyPress(this.jeuShapeUp.getNbDeJoueurs());
			//robot.keyPress(KeyEvent.VK_SHIFT);
			//robot.keyPress(KeyEvent.VK_2);
			//robot.keyPress(KeyEvent.VK_ENTER);
//			System.exit(0);
//			scan.close();
//			
			
//			for(int i=1; i<=this.jeuShapeUp.getNbDeJoueurs(); i++) {
//				this.jeuShapeUp.creerJoueur(this.definirTypeJoueur(i), this.definirNomJoueur(i));
//				
//			}
		}
		
		System.out.println(arg);
		
		
		
	}
	
	public int choisirNbJoueurs() {
		
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		int resultat = 0;
		try {
			do {
			  System.out.println("Veuillez choisir le nombre de joueurs pour votre partie (2 ou 3) : ");
		      //resultat = br.readLine();
		      resultat = Integer.parseInt(br.readLine());
		      this.jeuShapeUp.setNbDeJoueurs(resultat);
		      
		      if (resultat != 2 && resultat != 3) {
		        	//this.notifyObservers("Je suis désolée, vous ne pouvez choisir que 2 ou 3 joueurs.");
		        	System.out.println("Je suis désolée, vous ne pouvez choisir que 2 ou 3 joueurs.");
		      } 
			}while (resultat != 2 && resultat !=3);
		} catch (IOException e) {
		      System.err.println(e.getMessage());
		}

//		char nbChar='r';
//    	
//    		do {
//    			//this.notifyObservers("Veuillez choisir le nombre de joueurs pour votre partie (2 ou 3) : ");
////    			while(nbJoueursDde == false) {
////    				
////    			}
//	        	System.out.println("Veuillez choisir le nombre de joueurs pour votre partie (2 ou 3) : ");
//	        	//while(scan.hasNext()) {
//	        	if(nbJoueursDde == false) {
//	        		nbChar = scan.next().charAt(0);
//	    			scan.nextLine();
//	        	} else {
//	        		System.out.println("nb joueurs choisi");
//	        	}
//	        		
//	        	//}
//
//		        if (nbChar != '2' && nbChar!= '3') {
//		        	//this.notifyObservers("Je suis désolée, vous ne pouvez choisir que 2 ou 3 joueurs.");
//		        	System.out.println("Je suis désolée, vous ne pouvez choisir que 2 ou 3 joueurs.");
//		        } 
//
//	        }while (nbChar != '2' && nbChar !='3' && nbJoueursDde == false);
//	        int nb= Integer.parseInt(String.valueOf(nbChar));
//	        this.jeuShapeUp.setNbDeJoueurs(nb);
//	        
//	        return nb;
			return resultat;
    }
	
	public char definirTypeJoueur(int nb) {
    	
    	char type='r';
    	
    	do {
    		//this.notifyObservers("Veuillez choisir le type du joueur " + nb + ": virtuel (v) ou réel (r) ?");
			System.out.println("Veuillez choisir le type du joueur " + nb + ": virtuel (v) ou réel (r) ?");

			type = scan.next().charAt(0);
			scan.nextLine();

		    if (type != 'v' && type!= 'r') {
		    	//this.notifyObservers("Je suis désolée, vous ne pouvez choisir qu'entre virtuel (v) ou réel (r).");
		        System.out.println("Je suis désolée, vous ne pouvez choisir qu'entre virtuel (v) ou réel (r).");
		    } 
		    
		}while (type != 'v' && type!= 'r');
    	
    	return type;
    }
	
	 public String definirNomJoueur(int nb) {
	    	
	    	String nom;
	    	do {
	    		//this.notifyObservers("Veuillez choisir le nom du joueur " + nb + ": \n");
     		    System.out.println("Veuillez choisir le nom du joueur " + nb + ": \n");
     		    nom = scan.nextLine();
     			if (this.jeuShapeUp.getNomsJoueurs().contains(nom)) {
     				//this.notifyObservers("Je suis désolée, chaque joueur doit avoir un nom unique");
			        System.out.println("Je suis désolée, chaque joueur doit avoir un nom unique");
			    } 
			}while (this.jeuShapeUp.getNomsJoueurs().contains(nom));
	    	
	    	return nom;
	    }
	    

	    public StrategieMode choisirMode() {
	    	
	    	StrategieMode mode;
	    	char lettreMode='b';
	    	do {
	    		//this.notifyObservers("Veuillez choisir le mode de partie : \n \t-Mode de Base (b)\n \t-Mode Avancé (a)\n\t-Mode Victoire Ennemie (v)");
	    		System.out.println("Veuillez choisir le mode de partie : \n \t-Mode de Base (b)\n \t-Mode Avancé (a)\n\t-Mode Victoire Ennemie (v)");
     		lettreMode = scan.next().charAt(0);
 			scan.nextLine();
     		if (lettreMode!= 'b' && lettreMode!= 'a' && lettreMode!= 'v') {
     				//this.notifyObservers("Je suis désolée, vous ne pouvez choisir qu'entre les 3 modes proposés.");
			        System.out.println("Je suis désolée, vous ne pouvez choisir qu'entre les 3 modes proposés.");
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
     				//this.notifyObservers("Je suis désolée, vous ne pouvez choisir qu'entre les formes proposées.");
			        System.out.println("Je suis désolée, vous ne pouvez choisir qu'entre les formes proposées.");
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
