package shapeUp;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;

public class TapisDeJeu {
	
    private boolean rempli;
    private int nbCartes;
    private int nbLignesVides;
    private boolean carteEnHaut;
	private boolean carteEnBas;

	public int getNbCartes() {
		return nbCartes;
	}
	public void setNbCartes(int nbCartes) {
		this.nbCartes = nbCartes;
	}

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
	    //setNbLignesVides(this.getContainer().size());
	    
		//this.setForme(forme);
	}
	
	public boolean placementPossible(int lig, int col) {
		
		System.out.println("placement possible appelé");
		return (this.modele[lig][col]==1 && adjacenceRespectee(lig,col));

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
		
		this.carteEnHaut = lig == 0;
		this.carteEnBas = lig == this.getContainer().size()-1;
		
		//il doit y avoir au moins 1 ligne en haut ou en bas des cartes présentes et des 1 en dessous ou dessus d'elles.
		//boolean nbLignesVidesOk = this.getNbLignesVides()>0;
		
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
		
		return carteEnHaut || carteEnBas;
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
		int derniereLigne = this.getContainer().size();
		System.out.print("CARTE EN BAS " + carteEnBas);
		System.out.print("CARTE EN HAUT " + carteEnHaut);
		if(this.carteEnBas) {
			//add à l'envers
			// convertir container en array
//			ArrayList<CarteJouable>[] arrayContainer = new ArrayList[this.getContainer().size()];
//			arrayContainer = this.getContainer().toArray(arrayContainer);
//	        System.arraycopy(arrayContainer, lig, arrayContainer, lig-1, 1);
//	        ArrayList<ArrayList<CarteJouable>> newContainer = new ArrayList<ArrayList<CarteJouable>>();
//	        Collections.addAll(newContainer,arrayContainer);
//	        this.setContainer(newContainer);
	        
	        ligne = new ArrayList<Carte>();
			this.getContainer().add(ligne);
			
			//suppression de la ligne excédante
			this.getContainer().remove(0);
			
			//remplissage de la ligne avec null
			for(int j=0; j<this.modele[lig].length; j++) {
			    this.getContainer().get(lig).add(null);
			}
	        
			//System.out.print("CONTAINER TABLEAU : " + Arrays.toString(arrayContainer));
			System.out.print("CONTAINER RECONVERTI : " + this.getContainer());
	        
		} else if(this.carteEnHaut){
			
			//ajout d'une nouvelle ligne là où on veut ajouter une carte
			ligne = new ArrayList<Carte>();
			this.getContainer().add(lig,ligne);
			System.out.print("AJOUT DE LIGNE FAIT \n");
			
			//remplissage de la ligne avec null
			for(int j=0; j<this.modele[lig].length; j++) {
			    this.getContainer().get(lig).add(null);
			}
			//suppression de la ligne excédente
			this.getContainer().remove(derniereLigne);
			System.out.print("DERNIERE LIGNE SUPPRIMEE : " + derniereLigne);
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
