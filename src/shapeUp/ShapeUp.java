package shapeUp;

import java.util.*;

import vue.Console;
import vue.VueShapeUp;

public class ShapeUp extends Observable {

		private Console consoleDuJeu;
	    private Partie maPartie;
	    private final Scanner scan = new Scanner (System.in);
	    Set<String> nomsJoueurs;

	    
	    ShapeUp() {
	    	//super(new Console());
	    	
	    	this.consoleDuJeu = new Console();
	    	this.addObserver(this.consoleDuJeu);
	    	
	    	int nbJoueurs = this.choisirNbJoueurs();
	    	
	    	this.lancerLaPartie(this.creerJoueurs(nbJoueurs), this.choisirMode(), this.choisirFormeTapis(), this.consoleDuJeu);
	    	this.notifyObservers("Jeu ShapeUp créé\n");
	    	//System.out.print("Jeu ShapeUp créé\n");
	    }
	    
	    public String toString() {
	    	StringBuffer sb = new StringBuffer();
//	    	sb.append("Liste des joueurs : ");
//	    	sb.append(this.nomsJoueurs.keySet() + "\n");
	    	sb.append(this.maPartie);
			return sb.toString();
	    }
	    

	   /* public void lancerLaPartie(Queue<Joueur> listeJoueurs, StrategieMode mode) {
	    	
	    	this.maPartie = new Partie(listeJoueurs, mode);
	    	
	    }*/
	    
	    public void lancerLaPartie(Queue<Joueur> queueJoueurs, StrategieMode mode, TapisDeJeu forme, Console console) {
	    	
	    	this.maPartie = new Partie(queueJoueurs, mode, forme, console);
	    	
	    	//this.maPartie.addObserver(this.consoleDuJeu);
//	    	this.maPartie.setConsoleDuJeu(this.consoleDuJeu);
	    	//this.maPartie.getTapisDeJeu().addObserver(this.consoleDuJeu);
	    }

	    public int choisirNbJoueurs() {

	    		char nbChar='r';
	        	
	        		do {
	        			this.notifyObservers("Veuillez choisir le nombre de joueurs pour votre partie (2 ou 3) : ");
			        	//System.out.println("Veuillez choisir le nombre de joueurs pour votre partie (2 ou 3) : ");
				        //nb = scan.nextInt();
				        nbChar = scan.next().charAt(0);
		    			scan.nextLine();

				        if (nbChar != '2' && nbChar!= '3') {
				        	this.notifyObservers("Je suis désolée, vous ne pouvez choisir que 2 ou 3 joueurs.");
				        	//System.out.println("Je suis désolée, vous ne pouvez choisir que 2 ou 3 joueurs.");
				        } 

			        }while (nbChar != '2' && nbChar !='3' );
			        int nb= Integer.parseInt(String.valueOf(nbChar));
			        return nb;
	        	}
	    

		public char definirTypeJoueur(int nb) {
	    	
	    	char type='r';
	    	
	    	do {
	    		this.notifyObservers("Veuillez choisir le type du joueur " + nb + ": virtuel (v) ou réel (r) ?");
    			//System.out.println("Veuillez choisir le type du joueur " + nb + ": virtuel (v) ou réel (r) ?");

    			type = scan.next().charAt(0);
    			scan.nextLine();

			    if (type != 'v' && type!= 'r') {
			    	this.notifyObservers("Je suis désolée, vous ne pouvez choisir qu'entre virtuel (v) ou réel (r).");
			        //System.out.println("Je suis désolée, vous ne pouvez choisir qu'entre virtuel (v) ou réel (r).");
			    } 
			    
			}while (type != 'v' && type!= 'r');
	    	
	    	return type;
	    	
	    }

	    public Queue<Joueur> creerJoueurs(int nbJoueurs) {
	    	
	    	char type='r';
	    	String nom;
	    	nomsJoueurs = new HashSet<String>();
	    	Queue<Joueur> queueJoueurs = new LinkedList<Joueur>();
        		
        		for(int i=1; i<=nbJoueurs; i++) {
        			
        			//définition des types des joueurs
        			type = definirTypeJoueur(i);
        			
        			//définition des noms  des joueurs
        			nom = definirNomJoueur(i);
        			
        			switch(type) {
	        			case 'v' :
	        				JoueurVirtuel nouveauJoueurV = new JoueurVirtuel(nom, this.consoleDuJeu);
	        				//System.out.println("Nom du joueur " + i + ": " + nouveauJoueurV.getNom());
//	        				nouveauJoueurV.addObserver(consoleDuJeu);
	        				queueJoueurs.add(nouveauJoueurV);
	        				nomsJoueurs.add(nom);
	        				break;
	        			case 'r' :
	        				JoueurReel nouveauJoueurR = new JoueurReel(nom, this.consoleDuJeu);
	        				//System.out.println("Nom du joueur " + i + ": " + nouveauJoueurR.getNom());
//	        				nouveauJoueurR.addObserver(consoleDuJeu);
	        				queueJoueurs.add(nouveauJoueurR);
	        				nomsJoueurs.add(nom);
	        				break;
//	        			default :
//	        				//this.notifyObservers("Aucun joueur créé");
//	        				System.out.println("Aucun joueur créé");
//	        				break;
	        				
        			}
        		
    			}
			return queueJoueurs;
	    	
	    }
	    
	    public String definirNomJoueur(int nb) {
	    	
	    	String nom;
	    	do {
	    		this.notifyObservers("Veuillez choisir le nom du joueur " + nb + ": \n");
        		//System.out.println("Veuillez choisir le nom du joueur " + nb + ": \n");
        		nom = scan.nextLine();
        		if (nomsJoueurs.contains(nom)) {
        			this.notifyObservers("Je suis désolée, chaque joueur doit avoir un nom unique");
			        //System.out.println("Je suis désolée, chaque joueur doit avoir un nom unique");
			    } 
			}while (nomsJoueurs.contains(nom));
	    	
	    	return nom;
	    }
	    

	    public StrategieMode choisirMode() {
	    	
	    	StrategieMode mode;
	    	char lettreMode='b';
	    	do {
	    		this.notifyObservers("Veuillez choisir le mode de partie : \n \t-Mode de Base (b)\n \t-Mode Avancé (a)\n\t-Mode Victoire Ennemie (v)");
        		//System.out.println("Veuillez choisir le mode de partie : \n \t-Mode de Base (b)\n \t-Mode Avancé (a)\n\t-Mode Victoire Ennemie (v)");
        		lettreMode = scan.next().charAt(0);
    			scan.nextLine();
        		if (lettreMode!= 'b' && lettreMode!= 'a' && lettreMode!= 'v') {
        			this.notifyObservers("Je suis désolée, vous ne pouvez choisir qu'entre les 3 modes proposés.");
			        //System.out.println("Je suis désolée, vous ne pouvez choisir qu'entre les 3 modes proposés.");
			    }  
			}while (lettreMode!= 'b' && lettreMode!= 'a' && lettreMode!= 'v');
	    	
	    	switch(lettreMode) {
				case 'b' :
					return mode = new StrategieDeBase(this.consoleDuJeu);
				case 'a' :
					return mode = new StrategieAvance(this.consoleDuJeu);
				case 'v' :
					return mode = new StrategieVictoireEnnemie(this.consoleDuJeu);
				default :
//					//this.notifyObservers("Aucun mode associé");
//					System.out.println("Aucun mode associé");
					return null;
	    	}
	    }
	    
	    
	    public TapisDeJeu choisirFormeTapis() {
	    	
	    	TapisDeJeu forme;
	    	char lettreForme='b';
	    	do {
	    		this.notifyObservers("Veuillez choisir la forme du tapis : \n \t-Rectangle 5x3 (r)\n \t-Triangle rectangle (t)\n \t-Disque (d)");
        		//System.out.println("Veuillez choisir la forme du tapis : \n \t-Rectangle 5x3 (r)\n \t-Triangle rectangle (t)\n \t-Disque (d)");
        		lettreForme = scan.next().charAt(0);
    			scan.nextLine();
        		if (lettreForme!= 'r' && lettreForme!= 't' && lettreForme!= 'd') {
        			this.notifyObservers("Je suis désolée, vous ne pouvez choisir qu'entre les formes proposées.");
			        //System.out.println("Je suis désolée, vous ne pouvez choisir qu'entre les formes proposées.");
			    }  
			}while (lettreForme!= 'r' && lettreForme!= 't' && lettreForme!= 'd');
	    	
	    	switch(lettreForme) {
				case 'r' :
					//TapisRectangle rectangle = new TapisRectangle();
					forme = new TapisRectangle();
					//return rectangle;
					return forme;
				case 't' :
					//TapisTriangleRectangle triangle = new TapisTriangleRectangle();
					forme = new TapisTriangleRectangle();
					//return triangle;
					return forme;
				case 'd' :
					//TapisTriangleRectangle triangle = new TapisTriangleRectangle();
					forme = new TapisCercle();
					//return triangle;
					return forme;
				default :
//					this.notifyObservers("Aucune forme associée");
//					System.out.println("Aucune forme associée");
					return null;
	    	}
	    }
	    

	    public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	    	VueShapeUp test = new VueShapeUp();
			ShapeUp jeuShapeUp = new ShapeUp();
			jeuShapeUp.notifyObservers(jeuShapeUp);
			//System.out.println(jeuShapeUp);
			
			while(!jeuShapeUp.maPartie.isEstFinie()) {
				jeuShapeUp.maPartie.tourDeJeu();
			}
			//System.out.println("Partie finie !"+"\n");
			jeuShapeUp.maPartie.getModeDeJeu().finirLaPartie(jeuShapeUp.maPartie);
			

	    }

}
