package shapeUp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;

public class TapisDeJeu {
	
    private boolean rempli;
    private int nbCartes;
    private int nbLignesVides;
//    private int nbCartesSurLigne;
//    
//	public int getNbCartesSurLigne() {
//		return nbCartesSurLigne;
//	}
//	public void setNbCartesSurLigne(int nbCartesSurLigne) {
//		this.nbCartesSurLigne = nbCartesSurLigne;
//	}
	public int getNbCartes() {
		return nbCartes;
	}
	public void setNbCartes(int nbCartes) {
		this.nbCartes = nbCartes;
	}
	
	public int getNbLignesVides() {
		return nbLignesVides;
	}
	public void setNbLignesVides(int nbLignesVides) {
		this.nbLignesVides = nbLignesVides;
	}
    //private Carte carteVide;
    //private FormeTapis forme; 

	private ArrayList<ArrayList<CarteJouable>> container;
	ArrayList<CarteJouable> ligne;
    //private Map<Integer,Map<Integer,Carte>> container;

	public void setContainer(ArrayList<ArrayList<CarteJouable>> container) {
		this.container = container;
	}
	public ArrayList<ArrayList<CarteJouable>> getContainer() {
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
		
	    this.setContainer(new ArrayList<ArrayList<CarteJouable>>());
	    for(int i=0; i<this.modele.length; i++) {
	    	
	    	ligne = new ArrayList<CarteJouable>();
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
	    setNbLignesVides(this.getContainer().size());
	    //setNbCartesSurLigne(0);
	    
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
		
		if(lig<this.getContainer().size()-1) {
			caseDessousRemplie = caseRemplie(lig+1,col);
			System.out.println("caseDessousRemplie : "+ caseDessusRemplie);
		}
		
		if(col>0) {
			caseGaucheRemplie = caseRemplie(lig,col-1);
			System.out.println("caseGaucheRemplie : "+ caseGaucheRemplie);
		}
		
		if(col<this.getContainer().get(lig).size()-1) {
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
	
	public boolean decalagePossible(int lig, int col) {
		
		boolean carteEnHaut = lig == 0;
		boolean carteEnBas = lig == this.getContainer().lastIndexOf(ligne);
		//il doit y avoir au moins 1 ligne en haut ou en bas des cartes présentes et des 1 en dessous ou dessus d'elles.
		boolean nbLignesVidesOk = this.getNbLignesVides()>0;
		// si case l+1 == 0 et case == null
		//==> parcourir matrice pour trouver toutes les cases dont l+1 == 0
		//==> verifier que ces cases (lig col) ne sont pas remplies
		boolean carteVideSur0 = true;
		boolean carteVideSous0 = true;
		boolean carteVideGauche0 = true;
		boolean carteVideDroite0 = true;
		
		for(int i=0; i<this.modele.length; i++) {
			
			for(int j=0; j<this.modele[i].length; j++) {
				
				if(this.modele[i][j]==0) {
					
					if(i>0) {
						carteVideSur0 = !caseRemplie(i-1,j);
					}
					
					if(i<this.getContainer().size()-1) {
						carteVideSous0 = !caseRemplie(i+1,j);
					}
					
					if(j>0) {
						carteVideGauche0 = !caseRemplie(i,j-1);
					}
					
					if(j<this.getContainer().get(i).size()-1) {
						carteVideDroite0 = !caseRemplie(i,j+1);
					}
					
				}
				
			}

		}
		
		return ((carteEnHaut && carteVideSur0) || (carteEnBas && carteVideSous0)) && nbLignesVidesOk;
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
		ligne = new ArrayList<CarteJouable>();
		this.getContainer().add(lig,ligne);
		
		for(int j=0; j<this.modele[lig].length; j++) {
	    	this.getContainer().get(lig).add(null);
		}
		//suppression de la ligne excédante
		this.getContainer().remove(this.getContainer().lastIndexOf(ligne));
		
//		ListIterator<Carte> itLigne = ligne.listIterator();
//	    ListIterator<ArrayList<Carte>> itContainer = this.getContainer().listIterator();
//	    ListIterator<ArrayList<Carte>> itContainerNext = this.getContainer().listIterator(lig+1);
//	    
//	    while(itContainer.hasNext() && itContainerNext.hasNext()) {
//	    	
//	    	ArrayList<Carte> elementCourant = itContainer.next();
//	    	ArrayList<Carte> elementSuivant = itContainerNext.next();
//	    	int ligneCourante = this.getContainer().indexOf(elementCourant);
//	    	
//	    	if(caseRemplie(ligneCourante,col)) {
//	    		elementCourant.remove(elementCourant.get(col));
//	    		itContainerNext.add(col,elementCourant.get(col));
//	    	}
//	    	
//		}
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
