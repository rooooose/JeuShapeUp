package shapeUp;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;

public class TapisDeJeu extends Observable{
	
    private int nbCartes;
	private boolean decalVersBasPossible = false;
	private boolean decalVersHautPossible = false;
	private boolean decalVersDroitePossible = false;
	private boolean decalVersGauchePossible = false;
	
	private boolean premiereLigneVide;
	private boolean derniereLigneVide;
	private boolean premiereColVide;
	private boolean derniereColVide;
	
	private boolean carteVideSur0;
	private boolean carteVideSous0;
	private boolean carteVideGauche0;
	private boolean carteVideDroite0;
	
	private boolean carteEnHaut;
	private boolean carteEnBas;
	private boolean carteGauche;
	private boolean carteDroite;

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
	
	public int[][] getModele() {
		return modele;
	}

	
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
	
	public boolean placementNormalPossible(int lig, int col) {
		
		if(getNbCartes()==0) {
			return this.modele[lig][col]==1;
		} else {
			return (this.modele[lig][col]==1 && adjacenceRespectee(lig,col) && !this.caseRemplie(lig, col));
		}
		

    }
	
	public boolean adjacenceRespectee(int lig, int col) {
		//regle d'adjacence + déplacement possible des autres cartes + 1ere carte au milieu
		
		//déclaration + initialisation des variables de condition
		boolean caseDessusRemplie = false;
		boolean caseDessousRemplie = false;
		boolean caseGaucheRemplie = false;
		boolean caseDroiteRemplie = false;

		if(lig>0) {
			caseDessusRemplie = caseRemplie(lig-1,col);
		}
		
		if(lig<this.getContainer().size()-1) {
			caseDessousRemplie = caseRemplie(lig+1,col);
		}
		
		if(col>0) {
			caseGaucheRemplie = caseRemplie(lig,col-1);
		}
		
		if(col<this.getContainer().get(lig).size()-1) {
			caseDroiteRemplie = caseRemplie(lig,col+1);
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
		
//		carteEnHaut = (lig == 0) || (this.modele[lig-1][col]==0);
//		carteEnBas = (lig == this.getContainer().size()-1) || (this.modele[lig+1][col]==0);
//		carteGauche = (col == 0) || (this.modele[lig][col-1]==0);
//		carteDroite = (col == this.getContainer().get(lig).size()-1) || (this.modele[lig][col+1]==0);
		
		carteEnHaut = (lig == 0);
		carteEnBas = (lig == this.getContainer().size()-1);
		carteGauche = (col == 0);
		carteDroite = (col == this.getContainer().get(lig).size()-1);
		
		carteVideSur0 = true;
		carteVideSous0 = true;
		carteVideGauche0 = true;
		carteVideDroite0 = true;
		
		premiereLigneVide = true;
		derniereLigneVide = true;
		premiereColVide = true;
		derniereColVide = true;

		for(int i=0; i<this.modele.length; i++) {
			
			if(premiereColVide) {
				premiereColVide = !caseRemplie(i,0);
			}
			if(derniereColVide) {
				derniereColVide = !caseRemplie(i,this.modele[i].length-1);
			}
			
			for(int j=0; j<this.modele[i].length; j++) {
				
				if(premiereLigneVide) {
					premiereLigneVide = !caseRemplie(0,j);
				}
				if(derniereLigneVide) {
					derniereLigneVide = !caseRemplie(this.modele.length-1,j);
				}
				
				if(this.modele[i][j]==0) {
					
					if(i>0 && carteVideSur0) {
						carteVideSur0 = !caseRemplie(i-1,j);
					}
					
					if(i<this.getContainer().size()-1 && carteVideSous0) {
						carteVideSous0 = !caseRemplie(i+1,j);
					}
					
					if(j>0 && carteVideGauche0) {
						carteVideGauche0 = !caseRemplie(i,j-1);
					}
					
					if(j<this.getContainer().get(i).size()-1 && carteVideDroite0) {
						carteVideDroite0 = !caseRemplie(i,j+1);
					}
					
				}
				
			}

		}
//		System.out.println("carteEnHaut & derniereLigneVide & carteVideSur0 & this.caseRemplie(lig, col)) " 
//		+ (carteEnHaut && derniereLigneVide && carteVideSur0 && this.caseRemplie(lig, col)));
//		
//		System.out.println("carteEnHaut " 
//				+ carteEnHaut);
//		
//		System.out.println("derniereLigneVide " 
//				+ derniereLigneVide);
//		
//		System.out.println("carteVideSur0 " 
//				+ carteVideSur0);
//		
//		
//		System.out.println("(carteEnBas && premiereLigneVide && carteVideSous0 && this.caseRemplie(lig, col)) " 
//				+ (carteEnBas && premiereLigneVide && carteVideSous0 && this.caseRemplie(lig, col)));
//		
//		System.out.println("(carteGauche && derniereColVide && carteVideGauche0 && this.caseRemplie(lig, col)) " 
//				+ (carteGauche && derniereColVide && carteVideGauche0 && this.caseRemplie(lig, col)));
//		
//		System.out.println("(carteDroite && premiereColVide && carteVideDroite0 && this.caseRemplie(lig, col)) " 
//				+ (carteDroite && premiereColVide && carteVideDroite0 && this.caseRemplie(lig, col)));
		
//		if(carteEnHaut && derniereLigneVide && carteVideSur0 && this.caseRemplie(lig, col)) {
//			System.out.println("decalVersBasPossible" + decalVersBasPossible);
//			decalVersBasPossible2 = true;
//			
//		}
//		
//		if(carteEnBas && premiereLigneVide && carteVideSous0 && this.caseRemplie(lig, col)) {
//			System.out.println("decalVersHautPossible" + decalVersHautPossible);
//			decalVersHautPossible = true;
//		}
//		
//		if(carteGauche && derniereColVide && carteVideGauche0 && this.caseRemplie(lig, col)){
//			System.out.println("decalVersDroitePossible" + decalVersDroitePossible);
//			decalVersDroitePossible = true;
//		}
//		
//		if(carteDroite && premiereColVide && carteVideDroite0 && this.caseRemplie(lig, col)) {
//			System.out.println("decalVersGauchePossible" + decalVersGauchePossible);
//			decalVersGauchePossible = true;
//		}
		
		return (carteEnHaut && derniereLigneVide && carteVideSur0 && this.caseRemplie(lig, col)) || 
				(carteEnBas && premiereLigneVide && carteVideSous0 && this.caseRemplie(lig, col)) || 
				(carteGauche && derniereColVide && carteVideGauche0 && this.caseRemplie(lig, col)) || 
				(carteDroite && premiereColVide && carteVideDroite0 && this.caseRemplie(lig, col));
				
				
	}
	
	public void decalerCartes(int lig, int col) {
		
		int derniereLigne = this.getContainer().size();
//		System.out.print("CARTE EN BAS " + carteEnBas);
//		System.out.print("CARTE EN HAUT " + carteEnHaut);

		if(carteEnBas && premiereLigneVide && carteVideSous0) {
			//this.notifyObservers("carte en bas");
			System.out.println("carte en bas");
	        
	        ligne = new ArrayList<Carte>();
			this.getContainer().add(ligne);
			
			//suppression de la ligne excédante
			this.getContainer().remove(0);
			
			//remplissage de la ligne avec null
			for(int j=0; j<this.modele[lig].length; j++) {
			    this.getContainer().get(lig).add(null);
			}
	        
		} else if(carteEnHaut && derniereLigneVide && carteVideSur0){
			//this.notifyObservers("carte en haut");
			System.out.println("carte en haut");
			//ajout d'une nouvelle ligne là où on veut ajouter une carte
			ligne = new ArrayList<Carte>();
			this.getContainer().add(lig,ligne);
			//System.out.print("AJOUT DE LIGNE FAIT \n");
			
			//remplissage de la ligne avec null
			for(int j=0; j<this.modele[lig].length; j++) {
			    this.getContainer().get(lig).add(null);
			}
			//suppression de la ligne excédente
			this.getContainer().remove(derniereLigne);
			//System.out.println("DERNIERE LIGNE SUPPRIMEE : " + derniereLigne);
			
		} else if(carteGauche && derniereColVide && carteVideGauche0){
			//this.notifyObservers("carte gauche");
			System.out.println("carte gauche");
			
			for(int i=0; i<this.modele.length; i++) {
				
				int derniereColonne = this.getContainer().get(i).size();
				this.getContainer().get(i).add(col, null);
				this.getContainer().get(i).remove(derniereColonne);
			}
			
		} else if(carteDroite && premiereColVide && carteVideDroite0){
			//this.notifyObservers("carte droite");
			System.out.println("carte droite");
			for(int i=0; i<this.modele.length; i++) {
				
				this.getContainer().get(i).add(null);
				this.getContainer().get(i).remove(0);
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
			sb.append("\t");
			sb.append(this.getContainer().get(i));
			sb.append("\n");
		}
		return sb.toString();
	}
	




	
	
}
