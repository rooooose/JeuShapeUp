package shapeUp;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShapeUp {


	    private Partie maPartie;
	    private final Scanner scan = new Scanner (System.in);
	    
	    ShapeUp() {
	    	
	    	int nbJoueurs = this.choisirNbJoueurs();
	    	this.lancerLaPartie(this.definirTypeJoueur(nbJoueurs));
	    }
	    
	    public String toString() {
	    	StringBuffer sb = new StringBuffer();
	    	sb.append("Jeu ShapeUp créé\n");
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
	    	Queue<Joueur> queueJoueurs = new LinkedList<Joueur>();
        		
        		for(int i=1; i<=nbJoueurs; i++) {
        			
        			//définition des types des joueurs
        			do {
	        			System.out.print("Veuillez choisir le type du joueur " + i + ": virtuel (v) ou réel (r) ?");

	        			type = scan.next().charAt(0);
	        			scan.nextLine();
	
	    			    if (type != 'v' && type!= 'r') {
	    			        System.out.println("Je suis désolée, vous ne pouvez choisir qu'entre virtuel (v) ou réel (r).");
	    			    } 
	    			    
        			}while (type != 'v' && type!= 'r');
        			
        			//définition des noms  des joueurs
	        		System.out.print("Veuillez choisir le nom du joueur " + i + ": \n");
	        		String nom = scan.nextLine();
	    			   
        			
        			switch(type) {
	        			case 'v' :
	        				JoueurVirtuel nouveauJoueurV = new JoueurVirtuel(nom);
	        				System.out.println("Nom du joueur " + i + ": " + nouveauJoueurV.getNom());
	        				queueJoueurs.add(nouveauJoueurV);
	        				break;
	        			case 'r' :
	        				JoueurReel nouveauJoueurR = new JoueurReel(nom);
	        				System.out.println("Nom du joueur " + i + ": " + nouveauJoueurR.getNom());
	        				queueJoueurs.add(nouveauJoueurR);
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
