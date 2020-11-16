package shapeUp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;

public class TapisDeJeu {
	
    private boolean rempli;
    private int nbCartes;
    
	public int getNbCartes() {
		return nbCartes;
	}
	public void setNbCartes(int nbCartes) {
		this.nbCartes = nbCartes;
	}
    //private Carte carteVide;
    //private FormeTapis forme; 

	private ArrayList<ArrayList<Carte>> container;
	ArrayList<Carte> ligne;
    //private Map<Integer,Map<Integer,Carte>> container;

	public void setContainer(ArrayList<ArrayList<Carte>> container) {
		this.container = container;
	}
	public ArrayList<ArrayList<Carte>> getContainer() {
		return container;
	}
	
//	public Map<Integer, Map<Integer, Carte>> getContainer() {
//		return container;
//	}
//	public void setContainer(Map<Integer, Map<Integer, Carte>> container) {
//		this.container = container;
//	}

	private int[][] modele;

    
    /*public FormeTapis getForme() {
		return forme;
	}

	public void setForme(FormeTapis forme) {
		this.forme = forme;
	}*/
	
	TapisDeJeu(int[][] modeleForme) {
		
		setNbCartes(0);
		this.modele= modeleForme;
		//boolean debutForme = false;
		
	    this.setContainer(new ArrayList<ArrayList<Carte>>());
	    for(int i=0; i<this.modele.length; i++) {
	    	
	    	ligne = new ArrayList<Carte>();
	    	//Map<Integer,Carte> ligne = new HashMap<Integer,Carte>();
			this.getContainer().add(ligne);
			
			for(int j=0; j<this.modele[i].length; j++) {
				//carteVide = new Carte();
				// VOIR POUR LONGUEUR DE LA LISTE
		    	//if(this.modele[i][j]==1 || !debutForme) {
		    		this.getContainer().get(i).add(null);

//				}
			}
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
		System.out.println("placement possible appelé");
		return (this.modele[lig][col]==1 && adjacenceRespectee(lig,col));
		//return this.modele[lig][col]==1 && adjacenceRespectee(lig,col);
		

    }
	
	public boolean adjacenceRespectee(int lig, int col) {
		//regle d'adjacence + déplacement possible des autres cartes + 1ere carte au milieu
		
		//déclaration + initialisation des variables de condition
		boolean caseDessusRemplie = false;
		boolean caseDessousRemplie = false;
		boolean caseGaucheRemplie = false;
		boolean caseDroiteRemplie = false;
		System.out.println("adjacence appelée");

		if(lig>0) {
			caseDessusRemplie = caseRemplie(lig-1,col);
			System.out.println("caseDessusRemplie : "+ caseDessusRemplie);
		}
		
		if(lig<this.getContainer().size()) {
			caseDessousRemplie = caseRemplie(lig+1,col);
			System.out.println("caseDessousRemplie : "+ caseDessusRemplie);
		}
		
		if(col>0) {
			caseGaucheRemplie = caseRemplie(lig,col-1);
			System.out.println("caseGaucheRemplie : "+ caseGaucheRemplie);
		}
		
		if(col<this.getContainer().get(lig).size()) {
			caseDroiteRemplie = caseRemplie(lig,col+1);
			System.out.println("caseDroiteRemplie : "+ caseDroiteRemplie);
		}
		
//		if(this.getContainer().containsKey(lig-1)) {
//			caseDessusRemplie = this.getContainer().get(lig-1).containsKey(col);
//			System.out.println("caseDessusRemplie : "+ caseDessusRemplie);
//		}
//		if(this.getContainer().containsKey(lig+1)) {
//			caseDessousRemplie = this.getContainer().get(lig+1).containsKey(col);
//			System.out.println("caseDessousRemplie : "+ caseDessousRemplie);
//		}
//		if(this.getContainer().containsKey(lig)) {
//			caseGaucheRemplie = this.getContainer().get(lig).containsKey(col-1);
//			System.out.println("caseGaucheRemplie : "+ caseGaucheRemplie);
//		}
//		if(this.getContainer().containsKey(lig)) {
//			caseDroiteRemplie = this.getContainer().get(lig).containsKey(col+1);
//			System.out.println("caseDroiteRemplie : "+ caseDroiteRemplie);
//		}
		
		if( caseDessusRemplie || caseDessousRemplie || caseGaucheRemplie || caseDroiteRemplie) {
			return true;
		}else {
			return false;
		}
		
    }
	
	public boolean caseRemplie(int lig, int col) {
		return this.getContainer().get(lig).get(col)!=null;
	}
	
	public void decalerCartes(int lig, int col) {
		
		//si en haut ou en bas, on décale la ligne des cartes
//		if(caseRemplie(lig,col)){
//			
//			//parcours de toutes les lignes
//			for(int i=0; i<this.getContainer().size(); i++) {
//				this.getContainer().get(i).get(col).remove();
//			}
//			
//		}
		
		//ListIterator<Carte> itLigne = ligne.listIterator();
	    ListIterator<ArrayList<Carte>> itContainer = this.getContainer().listIterator();
	    
	    while(itContainer.hasNext()) {
	    	
	    	ArrayList<Carte> elementCourant = itContainer.next();
	    	int ligneCourante = this.getContainer().indexOf(elementCourant);
	    	
	    	if(caseRemplie(ligneCourante,col)) {
	    		elementCourant.remove(elementCourant.get(col));
	    		elementCourant.add(col,itContainer.previous().get(col));
	    	}
	    	
		}
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
				
				if(this.modele[i][j]==1) {
					
					if(this.caseRemplie(i,j)) {
						sb.append("[x]");
						
					}else sb.append("[ ]");
					
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
