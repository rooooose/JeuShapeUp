package shapeUp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Pioche {
   private int nbreDeCartes;

    public int getNbreDeCartes() {
		return nbreDeCartes;
	}

    public void compterNbCartes(int nbreDeCartes) {
    	this.nbreDeCartes = nbreDeCartes;
    	
    }
    
    
	private Set<Carte> pioche = new TreeSet<Carte> ();  
	
	public Set<Carte> getPioche() {
		return pioche;
	}

	public void setPioche(Set<Carte> pioche) {
		this.pioche = pioche;
	}

	
    public Pioche(int nbreDeCartes, Partie maPartie) {
    	this.nbreDeCartes = nbreDeCartes;
    	
    	List<Carte> recupCarteJeu = new ArrayList<Carte>(); 
    	recupCarteJeu.addAll(maPartie.getCarteDuJeu()); 
    	
    	
    	for (int i=0; i < nbreDeCartes; i++) {
    		
    	
    	int arrayLength = recupCarteJeu.size(); 
    	int randomIndex = new Random().nextInt(arrayLength);
    	
    	while (pioche.contains(recupCarteJeu.get(randomIndex)))
    		
    	{
        	arrayLength = 0; 
        	randomIndex = 0; 
        	arrayLength = recupCarteJeu.size(); 
        	randomIndex = new Random().nextInt(arrayLength);
    	}
    	
    	pioche.add(recupCarteJeu.get(randomIndex)); 
    	arrayLength = 0; 
    	randomIndex = 0; 
    	
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
 

    	}
    	
    	

    //}
    }    
    



