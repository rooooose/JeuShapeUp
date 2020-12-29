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
	//private final Scanner scan = new Scanner (System.in);
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
			System.out.println("Appuyez sur Entrée pour continuer");
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
		    	  
		      }
		      
		      if (!resultat.equals("2") && !resultat.equals("3")) {
		        	System.out.println("Je suis désolée, vous ne pouvez choisir que 2 ou 3 joueurs.");
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
    		//this.notifyObservers("Veuillez choisir le type du joueur " + nb + ": virtuel (v) ou réel (r) ?");
			System.out.println("Veuillez choisir le type du joueur " + nb + ": virtuel (v) ou réel (r) ?");
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
		    	//this.notifyObservers("Je suis désolée, vous ne pouvez choisir qu'entre virtuel (v) ou réel (r).");
		        System.out.println("Je suis désolée, vous ne pouvez choisir qu'entre virtuel (v) ou réel (r).");
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
					//si le nom du joueur est deja défini
					if(this.jeuShapeUp.getNomsJoueurs().size() == this.cptAppelsNom) {
						
						nom = this.jeuShapeUp.getNomsJoueurs().get(nb-1);
					}
					else if(nom == "") {
	     		    	System.out.println("Nom par défaut");
	     		    	nom = "Joueur " + nb;
				    } else if (this.jeuShapeUp.getNomsJoueurs().contains(nom)) {
				        System.out.println("Je suis désolée, chaque joueur doit avoir un nom unique");
				    }
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
     		    
			}while (this.jeuShapeUp.getNomsJoueurs().contains(nom) && this.jeuShapeUp.getNomsJoueurs().size() != this.cptAppelsNom);
	    	
	    	if(this.jeuShapeUp.getNomsJoueurs().size() < this.cptAppelsNom) {
	    		this.jeuShapeUp.getNomsJoueurs().add(nom);
		    	this.jeuShapeUp.notifyObservers(nom);
	    	}
	    	
	    	return nom;
	    }
	    

	    public StrategieMode choisirMode() {
	    	
	    	StrategieMode mode = null;
	    	String lettreMode="";
	    	do {
	    		System.out.println("Veuillez choisir le mode de partie : \n \t-Mode de Base (b)\n \t-Mode Avancé (a)\n\t-Mode Victoire Ennemie (v)");
//	    		lettreMode = scan.next().charAt(0);
//	    		scan.nextLine();
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
			        System.out.println("Je suis désolée, vous ne pouvez choisir qu'entre les 3 modes proposés.");
			    }  
			}while (!lettreMode.equals("b") && !lettreMode.equals("a") && !lettreMode.equals("v"));
	    	
	    	if(this.jeuShapeUp.getMode()==null) {
	    		
	    		switch(lettreMode.charAt(0)) {
					case 'b' :
						mode = new StrategieDeBase();
					case 'a' :
						mode = new StrategieAvance();
					case 'v' :
						mode = new StrategieVictoireEnnemie();
	    		}
	    		this.jeuShapeUp.setMode(mode);
				this.jeuShapeUp.notifyObservers(mode);
	    	}
	    	return mode;
	    	
	    	
	    }
	    
	    
	    public TapisDeJeu choisirFormeTapis() {
	    	
	    	TapisDeJeu forme = null;
	    	String lettreForme="";
	    	do {
	    		//this.notifyObservers("Veuillez choisir la forme du tapis : \n \t-Rectangle 5x3 (r)\n \t-Triangle rectangle (t)\n \t-Disque (d)");
	    		System.out.println("Veuillez choisir la forme du tapis : \n \t-Rectangle 5x3 (r)\n \t-Triangle rectangle (t)\n \t-Disque (d)");
     		//lettreForme = scan.next().charAt(0);
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
     				//this.notifyObservers("Je suis désolée, vous ne pouvez choisir qu'entre les formes proposées.");
			        System.out.println("Je suis désolée, vous ne pouvez choisir qu'entre les formes proposées.");
			    }  
			}while (!lettreForme.equals("r") && !lettreForme.equals("t") && !lettreForme.equals("d"));
	    	
	    	if(this.jeuShapeUp.getFormeTapis()==null) {
	    		switch(lettreForme.charAt(0)) {
					case 'r' :
						forme = new TapisRectangle();
					case 't' :
						forme = new TapisTriangleRectangle();
					case 'd' :
						forme = new TapisCercle();		
	    		}
	    		this.jeuShapeUp.setFormeTapis(forme);
				this.jeuShapeUp.notifyObservers(forme);
	    	}
	    	return forme;
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
