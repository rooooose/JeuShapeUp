package shapeUp;

import java.util.ArrayList;

public class TapisDeJeu {
	
    private boolean rempli;
    //private FormeTapis forme; 
    
    
    private ArrayList<ArrayList<Carte>> container;
    private int[][] modele;
    //private int[][] modele = {{1,2},{1,2}};
    
    /*public FormeTapis getForme() {
		return forme;
	}

	public void setForme(FormeTapis forme) {
		this.forme = forme;
	}*/
	
	TapisDeJeu(int[][] modeleForme) {
		
		this.modele= modeleForme;
		
	    container = new ArrayList<ArrayList<Carte>>();
	    for(int i=0; i<this.modele.length; i++) {
			container.add(i,new ArrayList<Carte>());
		}
	    
		//this.setForme(forme);
		
		 /*switch (forme) {
	    	case RECTANGLE : 
	    		Set<CarteJouable> tapisRect = new HashSet<CarteJouable> ();
	    		break;
	    	case TRIANGLERECTANGLE :
	    		Set<CarteJouable> tapisTrRect = new TreeSet<CarteJouable> ();
	    		break;
	    }*/
	}
	
	public boolean placementPossible(int lig, int col) {
		
		return this.modele[lig][col]==1;

    }
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		
		for(int col=0; col<this.modele[0].length; col++) {
			sb.append("  "+col);
		}
		sb.append("\n");
		for(int i=0; i<this.modele.length; i++) {
			sb.append(i);
			for(int j=0; j<this.modele[i].length; j++) {
				if(this.placementPossible(i,j)) {
					sb.append("[ ]");
				} else {
					sb.append("   ");
				}
			}
			sb.append("\n");
		}
		return sb.toString();
		
	}


	
	
}
