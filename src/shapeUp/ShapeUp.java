package shapeUp;

import java.util.Map;

public class ShapeUp {


	    private Partie maPartie;
	    
	    ShapeUp() {

	    	this.lancerLaPartie(choisirNbJoueurs(), mode, forme);
	    }
	    

	    public void lancerLaPartie(int nbreJoueurs, StrategieMode mode, FormeTapis forme) {
	    	
	    	maPartie = new Partie(nbreJoueurs);
	    	
	    }

	    public int choisirNbJoueurs() {
	    	
	    	/*System.out.println("Choisissez le mode de conversion :");
	        System.out.println("1 - Convertisseur Celsius - Fahrenheit");
	        System.out.println("2 - Convertisseur Fahrenheit - Celsius");

	        mode = scan.nextLine().charAt(0);*/
	    	
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
