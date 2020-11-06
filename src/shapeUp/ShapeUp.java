package shapeUp;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShapeUp {


	    private Partie maPartie;
	    private final Scanner scan = new Scanner (System.in);
	    
	    ShapeUp() {

	    	//this.lancerLaPartie(this.choisirNbJoueurs(), mode, forme);
	    	//this.lancerLaPartie(this.choisirNbJoueurs());
	    	int nbJoueurs = this.choisirNbJoueurs();
	    	System.out.print(this.definirTypeJoueur(nbJoueurs));
	    }
	    
	    public String toString() {
	    	StringBuffer sb = new StringBuffer();
	    	sb.append("Jeu ShapeUp créé\n");
	    	sb.append(this.maPartie);
			return sb.toString();
	    }
	    

	    public void lancerLaPartie(int nbreJoueurs) {
	    	
	    	this.maPartie = new Partie(nbreJoueurs);
	    	
	    }
	    
	    /*public void lancerLaPartie(Queue<Joueurs> listeJoueurs, StrategieMode mode, FormeTapis forme) {
	    	
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
	    	
	    	String type="r";
	    	Queue<Joueur> queueJoueurs = new LinkedList();
        		
        		for(int i=1; i<=nbJoueurs; i++) {
        			
        			do {
	        			System.out.print("Veuillez choisir le type du joueur " + i + ": virtuel (v) ou réel (r) ?");

	        			type = scan.nextLine();
	
	    			    if (type != "v" && type!= "r") {
	    			        System.out.println("Je suis désolée, vous ne pouvez choisir qu'entre virtuel (v) ou réel (r).");
	    			    } 
	    			    
        			}while (type != "v" && type!= "r");
        			
        			switch(type) {
	        			case "v" :
	        				JoueurVirtuel nouveauJoueurV = new JoueurVirtuel();
	        				queueJoueurs.add(nouveauJoueurV);
	        				break;
	        			case "r" :
	        				JoueurReel nouveauJoueurR = new JoueurReel();
	        				queueJoueurs.add(nouveauJoueurR);
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
