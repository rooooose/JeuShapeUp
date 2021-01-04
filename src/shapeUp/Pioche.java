package shapeUp;

import java.util.Queue;
//import java.util.Set;

public class Pioche {
   private int nbreDeCartes;
   //private Set<Carte> pioche;
   private Queue<Carte> pioche;
   
    public int getNbreDeCartes() {
		return nbreDeCartes;
	}

    public void compterNbCartes(int nbreDeCartes) {
    	this.nbreDeCartes = nbreDeCartes;
    	
    }
    
  
	
	public Queue<Carte> getPioche() {
		return pioche;
	}

	public void setPioche(Queue<Carte> pioche) {
		this.pioche = pioche;
	}
	
	
	Pioche (Queue<Carte> pioche) {
		this.pioche = pioche;
		
	}


    	//Iterator<Carte> piocheIt = pioche.iterator();
    	
    	//while (piocheIt.hasNext()) {
    	//System.out.println(piocheIt.next());
    	//}
    	
    	/*for (int i = 0; i < nbreDeCartes; i++) {
    		int longueurListeCarte = maPartie.getCarteDuJeu().size();
    		int randomIndex = new Random().nextInt(longueurListeCarte);
    		
    		pioche.add(maPartie.getCarteDuJeu().get(randomIndex));
    		
    		longueurListeCarte = 0;
    		randomIndex = 0;
    		
    		
    	}
    	
    	Iterator<Carte> piocheIt = pioche.iterator(); 
    	while (piocheIt.hasNext()) {
    	System.out.println(piocheIt.next());
    	}
    	*/
    	
    	


    	
    	
    	//}
 

    	// A SUPPR ?
    	    public String toString() {
    	    	 StringBuffer sbPioche = new StringBuffer();
    	    	// sbCarte.append("Forme de la carte : " +this.forme);
    	    	// sbCarte.append(" Couleur de la carte : " +this.couleur);
    	    	// sbCarte.append(" La carte est remplie : " +this.estRemplie+ "(true -> la carte est remplie)");
    	    	 sbPioche.append("\n");
    	    	 sbPioche.append(this.pioche);
    	    	 sbPioche.append("\n");
    	    	 return sbPioche.toString();
    	    	}
    	}

    //}
    
    



