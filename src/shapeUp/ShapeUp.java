package shapeUp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class ShapeUp {


	    private Partie maPartie;
	    private final Scanner scan = new Scanner (System.in);
	    Map<String,Joueur> mapJoueurs;
	    
	    ShapeUp() {
	    	
	    	int nbJoueurs = this.choisirNbJoueurs();
	    	this.lancerLaPartie(this.definirTypeJoueur(nbJoueurs));
	    	System.out.print("Jeu ShapeUp créé\n");
	    }
	    
	    public String toString() {
	    	StringBuffer sb = new StringBuffer();
	    	sb.append(this.mapJoueurs.keySet());
	    	sb.append(this.maPartie);
			return sb.toString();
	    }
	    

	    public void lancerLaPartie(Queue<Joueur> listeJoueurs) {
	    	
	    	this.maPartie = new Partie(listeJoueurs);
	    	
	    }
	    
	    /*public void lancerLaPartie(Queue<Joueur> listeJoueurs, StrategieMode mode, FormeTapis forme) {
	    	
	    	this.maPartie = new Partie(nbreJoueurs);
	    	
	    }*/

	    public int choisirNbJoueurs() {

	        	int nb;
	        	
	        		do {
			        	System.out.println("Veuillez choisir le nombre de joueurs pour votre partie (2 ou 3) : ");
				        nb = scan.nextInt();

				        if (nb != 2 && nb!= 3) {
				        	System.out.println("Je suis désolée, vous ne pouvez choisir que 2 ou 3 joueurs.");
				        } 

			        }while (nb != 2 && nb !=3 );
			        
			        return nb;
	        	}

	    public Queue<Joueur> definirTypeJoueur(int nbJoueurs) {
	    	
	    	char type='r';
	    	String nom;
	    	mapJoueurs = new HashMap<String,Joueur>();
	    	Queue<Joueur> queueJoueurs = new LinkedList<Joueur>();
        		
        		for(int i=1; i<=nbJoueurs; i++) {
        			
        			//définition des types des joueurs
        			do {
	        			System.out.println("Veuillez choisir le type du joueur " + i + ": virtuel (v) ou réel (r) ?");

	        			type = scan.next().charAt(0);
	        			scan.nextLine();
	
	    			    if (type != 'v' && type!= 'r') {
	    			        System.out.println("Je suis désolée, vous ne pouvez choisir qu'entre virtuel (v) ou réel (r).");
	    			    } 
	    			    
        			}while (type != 'v' && type!= 'r');
        			
        			//définition des noms  des joueurs
        			do {
		        		System.out.println("Veuillez choisir le nom du joueur " + i + ": \n");
		        		nom = scan.nextLine();
		        		if (mapJoueurs.containsKey(nom)) {
	    			        System.out.println("Je suis désolée, chaque joueur doit avoir un nom unique");
	    			    } 
    			    
        			}while (mapJoueurs.containsKey(nom));
	    			   
        			
        			switch(type) {
	        			case 'v' :
	        				JoueurVirtuel nouveauJoueurV = new JoueurVirtuel(nom);
	        				System.out.println("Nom du joueur " + i + ": " + nouveauJoueurV.getNom());
	        				queueJoueurs.add(nouveauJoueurV);
	        				mapJoueurs.put(nom, nouveauJoueurV);
	        				break;
	        			case 'r' :
	        				JoueurReel nouveauJoueurR = new JoueurReel(nom);
	        				System.out.println("Nom du joueur " + i + ": " + nouveauJoueurR.getNom());
	        				queueJoueurs.add(nouveauJoueurR);
	        				mapJoueurs.put(nom, nouveauJoueurR);
	        				break;
	        			default :
	        				System.out.println("Aucun joueur créé");
	        				break;
	        				
        			}
        		
    			}
			return queueJoueurs;
	    	
	    }
	    

	    public StrategieMode choisirMode() {
			return null;
	    }


	    public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			ShapeUp jeuShapeUp = new ShapeUp();
			System.out.println(jeuShapeUp);
	    }

}
