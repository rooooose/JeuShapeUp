package shapeUp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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

	public Set<Carte> pioche = new TreeSet<Carte> ();  
	
	public Set<Carte> getPioche() {
		return pioche;
	}

	public void setPioche(Set<Carte> pioche) {
		this.pioche = pioche;
	}


	{  

	
	/*for (int i = 0; i < 14; i++) {
		pioche.add(new Carte());
		
	} */
	
	/*Iterator<Carte> testIterator = pioche.iterator();
	
	while (testIterator.hasNext()) {
		System.out.println(testIterator.next());
	}*/
	

}
}
