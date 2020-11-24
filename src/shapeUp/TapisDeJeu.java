package shapeUp;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;

public class TapisDeJeu {
	
    private int nbCartes;
	private boolean decalVersBasPossible = false;
	private boolean decalVersHautPossible = false;
	private boolean decalVersDroitePossible = false;
	private boolean decalVersGauchePossible = false;
	
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
		//regle d'adjacence + d�placement possible des autres cartes + 1ere carte au milieu
		
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
		
		carteEnHaut = lig == 0;
		carteEnBas = lig == this.getContainer().size()-1;
		carteGauche = col == 0;
		carteDroite = col == this.getContainer().get(lig).size()-1;
		System.out.println("carteEnHaut " + carteEnHaut);

		boolean premiereLigneVide = true;
	    boolean derniereLigneVide = true;
	    boolean premiereColVide = true;
	    boolean derniereColVide = true;
		// A FAIRE / POSSIBILITE DE CONSIDERER UNE CARTE EN BAS OU HAUT SI AU DESSUS OU EN DESSOUS DE 0
		//il doit y avoir au moins 1 ligne en haut ou en bas des cartes pr�sentes et des 1 en dessous ou dessus d'elles.
		//boolean nbLignesVidesOk = this.getNbLignesVides()>0;
		
		// si case l+1 == 0 et case == null
		//==> parcourir matrice pour trouver toutes les cases dont l+1 == 0
		//==> verifier que ces cases (lig col) ne sont pas remplies
		boolean carteVideSur0 = true;
		boolean carteVideSous0 = true;
		boolean carteVideGauche0 = true;
		boolean carteVideDroite0 = true;
		
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
		
//		if(carteEnHaut && derniereLigneVide && carteVideSur0 && this.caseRemplie(lig, col)) {
//			System.out.println("decalVersBasPossible" + decalVersBasPossible);
//			decalVersBasPossible = true;
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

		if(this.carteEnHaut) {
			//add � l'envers
			// convertir container en array
//			ArrayList<CarteJouable>[] arrayContainer = new ArrayList[this.getContainer().size()];
//			arrayContainer = this.getContainer().toArray(arrayContainer);
//	        System.arraycopy(arrayContainer, lig, arrayContainer, lig-1, 1);
//	        ArrayList<ArrayList<CarteJouable>> newContainer = new ArrayList<ArrayList<CarteJouable>>();
//	        Collections.addAll(newContainer,arrayContainer);
//	        this.setContainer(newContainer);
	        
	        ligne = new ArrayList<Carte>();
			this.getContainer().add(ligne);
			
			//suppression de la ligne exc�dante
			this.getContainer().remove(0);
			
			//remplissage de la ligne avec null
			for(int j=0; j<this.modele[lig].length; j++) {
			    this.getContainer().get(lig).add(null);
			}
	        
		} else if(this.carteEnBas){
			
			//ajout d'une nouvelle ligne l� o� on veut ajouter une carte
			ligne = new ArrayList<Carte>();
			this.getContainer().add(lig,ligne);
			//System.out.print("AJOUT DE LIGNE FAIT \n");
			
			//remplissage de la ligne avec null
			for(int j=0; j<this.modele[lig].length; j++) {
			    this.getContainer().get(lig).add(null);
			}
			//suppression de la ligne exc�dente
			this.getContainer().remove(derniereLigne);
			//System.out.println("DERNIERE LIGNE SUPPRIMEE : " + derniereLigne);
			
		} else if(this.carteGauche){
			
			for(int i=0; i<this.modele.length; i++) {
				
				int derniereColonne = this.getContainer().get(i).size();
				this.getContainer().get(i).add(col, null);
				this.getContainer().get(i).remove(derniereColonne);
			}
			
		} else if(this.carteDroite){
			
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
