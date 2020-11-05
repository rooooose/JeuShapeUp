package shapeUp;

import java.util.Map;
import java.util.Scanner;

public class ShapeUp {


	    private Partie maPartie;
	    
	    ShapeUp() {

	    	this.lancerLaPartie(choisirNbJoueurs(), mode, forme);
	    }
	    

	    public void lancerLaPartie(int nbreJoueurs, StrategieMode mode, FormeTapis forme) {
	    	
	    	maPartie = new Partie(nbreJoueurs);
	    	
	    }

	    public int choisirNbJoueurs() {
	    	
	    	
	        Scanner scan = new Scanner (System.in);
	        System.out.println("Veuillez choisir le nombre de joueurs pour votre partie (2 ou 3) : ");
	        int nb = scan.nextInt();

	        if (nb != 2 && nb!= 3) {
	        	System.out.println("Je suis désolée, vous ne pouvez choisir que 2 ou 3 joueurs.");
	        } while (nb != 2 && nb !=3 );

	        if (nb == 2 || nb == 3) {

	        }

	        return nb;
	    	
	    	
	    	
	    }
	    
	    public Map definirTypeJoueur() {
	    	
	    }
	    

	    public StrategieMode choisirMode() {
	    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
