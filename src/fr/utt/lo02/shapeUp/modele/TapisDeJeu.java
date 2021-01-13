package fr.utt.lo02.shapeUp.modele;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;

public class TapisDeJeu extends Observable{
	
    private int nbCartes;
	
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
	
	private ArrayList<ArrayList<Carte>> container;
	private ArrayList<Carte> ligne;
	private int[][] modele;

	public int getNbCartes() {
		return nbCartes;
	}
	public void setNbCartes(int nbCartes) {
		this.nbCartes = nbCartes;
	}

	public void setContainer(ArrayList<ArrayList<Carte>> container) {
		this.container = container;
	}
	public ArrayList<ArrayList<Carte>> getContainer() {
		return container;
	}

	
	public int[][] getModele() {
		return modele;
	}

	
	TapisDeJeu(int[][] modeleForme) {
		
		setNbCartes(0);
		this.modele= modeleForme;

		
	    this.setContainer(new ArrayList<ArrayList<Carte>>());
	    for(int i=0; i<this.modele.length; i++) {
	    	
	    	ligne = new ArrayList<Carte>();

			this.getContainer().add(ligne);
			
			for(int j=0; j<this.modele[i].length; j++) {
		    		this.getContainer().get(i).add(null);

			}
		}
	}
	
	public boolean placementNormalPossible(int lig, int col) {
		
		if(getNbCartes()==0) {
			return this.modele[lig][col]==1;
		} else {
			return (this.modele[lig][col]==1 && adjacenceRespectee(lig,col) && !this.caseRemplie(lig, col));
		}
		

    }
	
	public boolean adjacenceRespectee(int lig, int col) {
		
		//d�claration + initialisation des variables de condition
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
		
		return (carteEnHaut && derniereLigneVide && carteVideSur0 && this.caseRemplie(lig, col)) || 
				(carteEnBas && premiereLigneVide && carteVideSous0 && this.caseRemplie(lig, col)) || 
				(carteGauche && derniereColVide && carteVideGauche0 && this.caseRemplie(lig, col)) || 
				(carteDroite && premiereColVide && carteVideDroite0 && this.caseRemplie(lig, col));
				
				
	}
	
	public void decalerCartes(int lig, int col) {
		
		int derniereLigne = this.getContainer().size();

		if(carteEnBas && premiereLigneVide && carteVideSous0) {
	        
	        ligne = new ArrayList<Carte>();
			this.getContainer().add(ligne);
			
			//suppression de la ligne exc�dante
			this.getContainer().remove(0);
			
			//remplissage de la ligne avec null
			for(int j=0; j<this.modele[lig].length; j++) {
			    this.getContainer().get(lig).add(null);
			}
	        
		} else if(carteEnHaut && derniereLigneVide && carteVideSur0){

			//ajout d'une nouvelle ligne l� o� on veut ajouter une carte
			ligne = new ArrayList<Carte>();
			this.getContainer().add(lig,ligne);
			
			//remplissage de la ligne avec null
			for(int j=0; j<this.modele[lig].length; j++) {
			    this.getContainer().get(lig).add(null);
			}
			//suppression de la ligne exc�dente
			this.getContainer().remove(derniereLigne);
			
		} else if(carteGauche && derniereColVide && carteVideGauche0){
			
			for(int i=0; i<this.modele.length; i++) {
				
				int derniereColonne = this.getContainer().get(i).size();
				this.getContainer().get(i).add(col, null);
				this.getContainer().get(i).remove(derniereColonne);
			}
			
		} else if(carteDroite && premiereColVide && carteVideDroite0){
			
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
