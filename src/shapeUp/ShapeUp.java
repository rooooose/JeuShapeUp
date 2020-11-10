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
	    	this.lancerLaPartie(this.creerJoueurs(nbJoueurs), this.choisirMode());
	    	System.out.print("Jeu ShapeUp cr��\n");
	    }
	    
	    public String toString() {
	    	StringBuffer sb = new StringBuffer();
	    	sb.append("Liste des joueurs : ");
	    	sb.append(this.mapJoueurs.keySet() + "\n");
	    	sb.append(this.maPartie);
			return sb.toString();
	    }
	    

	    public void lancerLaPartie(Queue<Joueur> listeJoueurs, StrategieMode mode) {
	    	
	    	this.maPartie = new Partie(listeJoueurs, mode);
	    	
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
				        	System.out.println("Je suis d�sol�e, vous ne pouvez choisir que 2 ou 3 joueurs.");
				        } 

			        }while (nb != 2 && nb !=3 );
			        
			        return nb;
	        	}
	    
	    
	    public char definirTypeJoueur(int nb) {
	    	
	    	char type='r';
	    	
	    	do {
    			System.out.println("Veuillez choisir le type du joueur " + nb + ": virtuel (v) ou r�el (r) ?");

    			type = scan.next().charAt(0);
    			scan.nextLine();

			    if (type != 'v' && type!= 'r') {
			        System.out.println("Je suis d�sol�e, vous ne pouvez choisir qu'entre virtuel (v) ou r�el (r).");
			    } 
			    
			}while (type != 'v' && type!= 'r');
	    	
	    	return type;
	    	
	    }

	    public Queue<Joueur> creerJoueurs(int nbJoueurs) {
	    	
	    	char type='r';
	    	String nom;
	    	mapJoueurs = new HashMap<String,Joueur>();
	    	Queue<Joueur> queueJoueurs = new LinkedList<Joueur>();
        		
        		for(int i=1; i<=nbJoueurs; i++) {
        			
        			//d�finition des types des joueurs
        			type = definirTypeJoueur(i);
        			
        			//d�finition des noms  des joueurs
        			nom = definirNomJoueur(i);
        			
        			switch(type) {
	        			case 'v' :
	        				JoueurVirtuel nouveauJoueurV = new JoueurVirtuel(nom);
	        				//System.out.println("Nom du joueur " + i + ": " + nouveauJoueurV.getNom());
	        				queueJoueurs.add(nouveauJoueurV);
	        				mapJoueurs.put(nom, nouveauJoueurV);
	        				break;
	        			case 'r' :
	        				JoueurReel nouveauJoueurR = new JoueurReel(nom);
	        				//System.out.println("Nom du joueur " + i + ": " + nouveauJoueurR.getNom());
	        				queueJoueurs.add(nouveauJoueurR);
	        				mapJoueurs.put(nom, nouveauJoueurR);
	        				break;
	        			default :
	        				System.out.println("Aucun joueur cr��");
	        				break;
	        				
        			}
        		
    			}
			return queueJoueurs;
	    	
	    }
	    
	    public String definirNomJoueur(int nb) {
	    	
	    	String nom;
	    	do {
        		System.out.println("Veuillez choisir le nom du joueur " + nb + ": \n");
        		nom = scan.nextLine();
        		if (mapJoueurs.containsKey(nom)) {
			        System.out.println("Je suis d�sol�e, chaque joueur doit avoir un nom unique");
			    } 
			}while (mapJoueurs.containsKey(nom));
	    	
	    	return nom;
	    }
	    

	    public StrategieMode choisirMode() {
	    	
	    	StrategieMode mode;
	    	//String lettreMode;
	    	char lettreMode='b';
	    	do {
        		System.out.println("Veuillez choisir le mode de partie : \n \t-Mode de Base (b)\n \t-Mode Avanc� (a)\n\t-Mode Victoire Ennemie (v)");
        		lettreMode = scan.next().charAt(0);
    			scan.nextLine();
        		if (lettreMode!= 'b' && lettreMode!= 'a' && lettreMode!= 'v') {
			        System.out.println("Je suis d�sol�e, vous ne pouvez choisir qu'entre les 3 modes propos�s.");
			    }  
			}while (lettreMode!= 'b' && lettreMode!= 'a' && lettreMode!= 'v');
	    	
	    	switch(lettreMode) {
				case 'b' :
					return mode = new StrategieDeBase();
					//break;
				case 'a' :
					return mode = new StrategieAvance();
					//break;
				case 'v' :
					return mode = new StrategieVictoireEnnemie();
					//break;
				default :
					System.out.println("Aucun mode associ�");
					return null;
					//break;
	    	}
	    	
			//return mode;
	    }
	    
	    
	    public FormeTapis choisirFormeTapis() {
	    	
			return null;
	    }
	    

	    public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			ShapeUp jeuShapeUp = new ShapeUp();
			System.out.println(jeuShapeUp);
	    }

}
