package fr.utt.lo02.shapeUp.modele;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;

import fr.utt.lo02.shapeUp.vue.Console;

/**
 * 
 * Repr�sente le tapis de jeu de la partie. Les cartes peuvent �tre plac�es dessus sous diverses conditions.
 * Il peut �tre de diff�rentes formes, d�finies dans ses classes filles : TapisRectangle, TapisTriangleRectangle, TapisCercle
 * Il h�rite de Observable pour permettre la mise � jour des vues.
 * 
 * @see VuePartie
 * @see Console
 * @see TapisRectangle
 * @see TapisTriangleRectangle
 * @see TapisCercle
 * 
 * @author Math�a Z, Shir F
 */
public class TapisDeJeu extends Observable{
	
	/**
	 * Repr�sente le nombre de cartes pr�sentes sur le tapis - de 0 � 15
	 */
    private int nbCartes;
	
    /**
     * Mod�lise le fait que la 1�re ligne du tapis est vide
     * @see decalagePossible(int, int)
     */
	private boolean premiereLigneVide;
	
	/**
     * Mod�lise le fait que la derni�re ligne du tapis est vide
     * @see decalagePossible(int, int)
     */
	private boolean derniereLigneVide;
	
	/**
     * Mod�lise le fait que la 1�re colonne du tapis est vide
     * @see decalagePossible(int, int)
     */
	private boolean premiereColVide;
	
	/**
     * Mod�lise le fait que la derni�re colonne du tapis est vide
     * @see decalagePossible(int, int)
     */
	private boolean derniereColVide;
	
	/**
     * Mod�lise le fait qu'1 case situ�e au-dessus d'un 0 dans le tableau mod�le du tapis est vide
     * @see decalagePossible(int, int)
     */
	private boolean carteVideSur0;
	
	/**
     * Mod�lise le fait qu'1 case situ�e en-dessous d'un 0 dans le tableau mod�le du tapis est vide
     * @see decalagePossible(int, int)
     */
	private boolean carteVideSous0;
	
	/**
     * Mod�lise le fait qu'1 case situ�e � gauche d'un 0 dans le tableau mod�le du tapis est vide
     * @see decalagePossible(int, int)
     */
	private boolean carteVideGauche0;
	
	/**
     * Mod�lise le fait qu'1 case situ�e � droite d'un 0 dans le tableau mod�le du tapis est vide
     * @see decalagePossible(int, int)
     */
	private boolean carteVideDroite0;
	
	/**
     * Mod�lise le fait que la carte souhaitant �tre plac�e est tout en haut du tapis (et non sous des cases 0)
     * @see decalagePossible(int, int)
     */
	private boolean carteEnHaut;
	
	/**
     * Mod�lise le fait que la carte souhaitant �tre plac�e est tout en bas du tapis (et non au-dessus de cases 0)
     * @see decalagePossible(int, int)
     */
	private boolean carteEnBas;
	
	/**
     * Mod�lise le fait que la carte souhaitant �tre plac�e est tout � gauche du tapis (et non � droite de cases 0)
     * @see decalagePossible(int, int)
     */
	private boolean carteGauche;
	
	/**
     * Mod�lise le fait que la carte souhaitant �tre plac�e est tout � droite du tapis (et non � gauche de cases 0)
     * @see decalagePossible(int, int)
     */
	private boolean carteDroite;
	
	/**
	 * Mod�lise la la liste 2D de cartes plac�es sur le tapis
	 */
	private ArrayList<ArrayList<Carte>> container;
	
	/**
	 * Mod�lise le tableau d'entier d�finissant la forme du tapis. Ce mod�le sera utilis� pour construire le container.
	 * @see TapisRectangle, TapisTriangleRectangle, TapisCercle
	 */
	private int[][] modele;

	/**
	 * Getter du nombre de cartes du tapis
	 * @return le nombre de cartes - entier
	 */
	public int getNbCartes() {
		return nbCartes;
	}
	
	/**
	 * Setter du nombre de cartes du tapis
	 * @param nbCartes
	 */
	public void setNbCartes(int nbCartes) {
		this.nbCartes = nbCartes;
	}
	
	/**
	 * Getter du container 2D de cartes du tapis de jeu
	 * @return container
	 */
	public ArrayList<ArrayList<Carte>> getContainer() {
		return container;
	}

	/**
	 * Getter du tableau mod�le de la forme de tapis
	 * @return le mod�le
	 */
	public int[][] getModele() {
		return modele;
	}

	/**
	 * Instancie le tapis de jeu en r�cup�rant le mod�le choisi par l'utilisateur, et en cr�ant l'ArrayList d'ArrayLists dans laquelle on va placer les cartes, en suivant le mod�le de la forme.
	 * On ajoute un objet null � chaque case en attendant leur remplissage.
	 * @param modeleForme
	 */
	TapisDeJeu(int[][] modeleForme) {
		
		setNbCartes(0);
		this.modele= modeleForme;

		
	    this.container = new ArrayList<ArrayList<Carte>>();
	    for(int i=0; i<this.modele.length; i++) {
	    	
	    	ArrayList<Carte> ligne = new ArrayList<Carte>();

			this.getContainer().add(ligne);
			
			for(int j=0; j<this.modele[i].length; j++) {
		    		this.getContainer().get(i).add(null);

			}
		}
	}
	
	/**
	 * D�finit lorsqu'un "placement normal" est possible : S'il n'y a encore aucune carte sur le tapis, il suffit qu'il y ait un 1 dans la case (lig;col) du tableau modele.
	 * S'il y en plus que cela, la case doit �tre vide et l'adjacence doit �tre respect�e
	 * @param lig - la ligne � laquelle on tente de placer la carte
	 * @param col - la colonne � laquelle on tente de placer la carte
	 * @return true si le placement est possible
	 * 
	 * @see adjacenceRespectee(int, int), caseRemplie(int, int)
	 */
	public boolean placementNormalPossible(int lig, int col) {
		
		if(getNbCartes()==0) {
			return this.modele[lig][col]==1;
		} else {
			return (this.modele[lig][col]==1 && adjacenceRespectee(lig,col) && !this.caseRemplie(lig, col));
		}
		

    }
	
	/**
	 * D�finit lorsque l'adjacence est respect�e : 
	 * Au moins une des cases entourant celle de coordonn�es (lig;col) (haut, bas, gauche, droite) doit �tre remplie
	 * @param lig - la ligne � laquelle on tente de placer la carte
	 * @param col - la colonne � laquelle on tente de placer la carte
	 * @return true si le placement est possible
	 * 
	 */
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
	
	/**
	 * D�finit lorsqu'une case est remplie : c�d si elle n'est pas nulle
	 * @param la ligne � laquelle on tente de placer la carte
	 * @param col - la colonne � laquelle on tente de placer la carte
	 * @return true si la case est remplie
	 */
	public boolean caseRemplie(int lig, int col) {
		return this.getContainer().get(lig).get(col)!=null;
	}
	
	/**
	 * D�finit lorsque le d�calage du tapis est possible : 
	 * la case de coordonn�es (lig;col) doit �tre remplie et aux bornes du tapis (haut, bas, gauche, droite selon le sens de d�calage).
	 * Selon le sens de d�calage �galement, la ligne ou la colonne oppos�e doit �tre vide. De plus, il ne faut pas qu'une carte soit pouss�e sur une case 0 lors du d�calage.
	 * Pour ce faire, l'ensemble du tableau modele est parcouru pour verifier si tous ces param�tres sont respect�s.
	 * @param lig - la ligne � laquelle on tente de placer la carte
	 * @param col - la colonne � laquelle on tente de placer la carte
	 * @return true si le d�calage est possible
	 */
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
	
	/**
	 * D�cale les cartes du tapis pour en placer une � la case (lig;col).
	 * Pour cela, selon le sens de d�calage, on ajoute une nouvelle ligne ou nouvelle colonne l� o� l'on veut placer notre carte, on la remplie avec des objets null, et on supprime la ligne exc�dante
	 * @param lig - la ligne � laquelle on tente de placer la carte
	 * @param col - la colonne � laquelle on tente de placer la carte
	 * @return true si le d�calage est possible
	 */
	public void decalerCartes(int lig, int col) {
		
		int derniereLigne = this.getContainer().size();

		if(carteEnBas && premiereLigneVide && carteVideSous0) {
	        
			ArrayList<Carte> ligne = new ArrayList<Carte>();
			this.getContainer().add(ligne);
			
			//suppression de la ligne exc�dante
			this.getContainer().remove(0);
			
			//remplissage de la ligne avec null
			for(int j=0; j<this.modele[lig].length; j++) {
			    this.getContainer().get(lig).add(null);
			}
	        
		} else if(carteEnHaut && derniereLigneVide && carteVideSur0){

			//ajout d'une nouvelle ligne l� o� on veut ajouter une carte
			ArrayList<Carte> ligne = new ArrayList<Carte>();
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
	
	/**
     * Red�finition de la m�thode toString(), qui pr�sente le tapis visuellement avec des cases vides [ ] ou remplies [x]. 
     * A cot� la liste dynamique est repr�sent�e avec son contenu exact, une carte ou un objet null.
     * @return le String Buffer converti en String
     */
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
