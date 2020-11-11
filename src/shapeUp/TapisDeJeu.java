package shapeUp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TapisDeJeu extends ArrayList{
	
    private boolean rempli;
    private FormeTapis forme; 
    
    private ArrayList<Carte> myThings;
    
    public FormeTapis getForme() {
		return forme;
	}

	public void setForme(FormeTapis forme) {
		this.forme = forme;
	}
	
	TapisDeJeu(FormeTapis forme) {
		
		

	    public ThingContainer(){
	        myThings = new ArrayList<Thing>();
	    }
	    
		this.setForme(forme);
		
		 switch (forme) {
	    	case RECTANGLE : 
	    		Set<CarteJouable> tapisRect = new HashSet<CarteJouable> ();
	    		break;
	    	case TRIANGLERECTANGLE :
	    		Set<CarteJouable> tapisTrRect = new TreeSet<CarteJouable> ();
	    		break;
	    }
	}


	
	
}
