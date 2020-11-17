package shapeUp;

import java.util.Set;

public class Pioche {
   private int nbreDeCartes;
   private Set<Carte> pioche;
   
    public int getNbreDeCartes() {
		return nbreDeCartes;
	}

    public void compterNbCartes(int nbreDeCartes) {
    	this.nbreDeCartes = nbreDeCartes;
    	
    }
    
  
	
	public Set<Carte> getPioche() {
		return pioche;
	}

	public void setPioche(Set<Carte> pioche) {
		this.pioche = pioche;
	}
	
	
	Pioche (Set<Carte> pioche) {
		this.pioche = pioche;
		
	}
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
 

    	
    	
    	

    //}
    
    



