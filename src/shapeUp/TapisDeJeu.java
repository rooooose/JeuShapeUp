package shapeUp;

import java.util.ArrayList;
import java.util.ListIterator;

public class TapisDeJeu {
	
    private boolean rempli;
    //private FormeTapis forme; 
    
    
    private ArrayList<ArrayList<Carte>> container;
    
    public ArrayList<ArrayList<Carte>> getContainer() {
		return container;
	}
	public void setContainer(ArrayList<ArrayList<Carte>> container) {
		this.container = container;
	}

	private int[][] modele;

    
    /*public FormeTapis getForme() {
		return forme;
	}

	public void setForme(FormeTapis forme) {
		this.forme = forme;
	}*/
	
	TapisDeJeu(int[][] modeleForme) {
		
		this.modele= modeleForme;
		ArrayList<Carte> ligne = new ArrayList<Carte>();
		Carte carteVide = new Carte();
		
	    this.setContainer(new ArrayList<ArrayList<Carte>>());
	    for(int i=0; i<this.modele.length; i++) {
			this.getContainer().add(ligne);
		}
	    
	    //ListIterator<Carte> itLigne = ligne.listIterator();
	    ListIterator<ArrayList<Carte>> itContainer = this.getContainer().listIterator();
	    while(itContainer.hasNext()) {
	    	System.out.print(itContainer.next());
	    	//for(int i=0; i<this.modele.length; i++) {
				
			    for(int j=0; j<this.modele[itContainer.nextIndex()-1].length; j++) {
			    	if(this.modele[itContainer.nextIndex()-1][j]==1) {
		    		   itContainer.next().add(carteVide);
		    		   //System.out.print(getContainer().get(i));
			    	}
						
				}
			// }
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
		//regle d'adjacence + déplacement possible des autres cartes + 1ere carte au milieu
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
		sb.append(this.getContainer());
		return sb.toString();
		
	}


	
	
}
