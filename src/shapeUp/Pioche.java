package shapeUp;

import java.util.ArrayList;
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
    	
    	int size = maPartie.getCarteDuJeu().size();
    	
    	for(int i = 0; i < nbreDeCartes;i = i){
    		int item = new Random().nextInt(size);
    		Iterator<Carte> recupIterator = maPartie.getCarteDuJeu().iterator();
    		if (i == item) {
    			pioche.add(recupIterator.next());
    			i++;
    		}
    	        
    	    
    	}
    	System.out.println(pioche);
    }
    
    


}
