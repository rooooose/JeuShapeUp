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
 * Représente le tapis de jeu de la partie. Les cartes peuvent être placées dessus sous diverses conditions.
 * Il peut être de différentes formes, définies dans ses classes filles : TapisRectangle, TapisTriangleRectangle, TapisCercle
 * Il hérite de Observable pour permettre la mise à jour des vues.
 * 
 * @see VuePartie
 * @see Console
 * @see TapisRectangle
 * @see TapisTriangleRectangle
 * @see TapisCercle
 * 
 * @author Mathéa Z, Shir F
 */
public class TapisDeJeu extends Observable{
	
	/**
	 * Représente le nombre de cartes présentes sur le tapis - de 0 à 15
	 */
    private int nbCartes;
	
    /**
     * Modélise le fait que la 1ère ligne du tapis est vide
     * @see decalagePossible(int, int)
     */
	private boolean premiereLigneVide;
	
	/**
     * Modélise le fait que la dernière ligne du tapis est vide
     * @see decalagePossible(int, int)
     */
	private boolean derniereLigneVide;
	
	/**
     * Modélise le fait que la 1ère colonne du tapis est vide
     * @see decalagePossible(int, int)
     */
	private boolean premiereColVide;
	
	/**
     * Modélise le fait que la dernière colonne du tapis est vide
     * @see decalagePossible(int, int)
     */
	private boolean derniereColVide;
	
	/**
     * Modélise le fait qu'1 case située au-dessus d'un 0 dans le tableau modèle du tapis est vide
     * @see decalagePossible(int, int)
     */
	private boolean carteVideSur0;
	
	/**
     * Modélise le fait qu'1 case située en-dessous d'un 0 dans le tableau modèle du tapis est vide
     * @see decalagePossible(int, int)
     */
	private boolean carteVideSous0;
	
	/**
     * Modélise le fait qu'1 case située à gauche d'un 0 dans le tableau modèle du tapis est vide
     * @see decalagePossible(int, int)
     */
	private boolean carteVideGauche0;
	
	/**
     * Modélise le fait qu'1 case située à droite d'un 0 dans le tableau modèle du tapis est vide
     * @see decalagePossible(int, int)
     */
	private boolean carteVideDroite0;
	
	/**
     * Modélise le fait que la carte souhaitant être placée est tout en haut du tapis (et non sous des cases 0)
     * @see decalagePossible(int, int)
     */
	private boolean carteEnHaut;
	
	/**
     * Modélise le fait que la carte souhaitant être placée est tout en bas du tapis (et non au-dessus de cases 0)
     * @see decalagePossible(int, int)
     */
	private boolean carteEnBas;
	
	/**
     * Modélise le fait que la carte souhaitant être placée est tout à gauche du tapis (et non à droite de cases 0)
     * @see decalagePossible(int, int)
     */
	private boolean carteGauche;
	
	/**
     * Modélise le fait que la carte souhaitant être placée est tout à droite du tapis (et non à gauche de cases 0)
     * @see decalagePossible(int, int)
     */
	private boolean carteDroite;
	
	/**
	 * Modélise la la liste 2D de cartes placées sur le tapis
	 */
	private ArrayList<ArrayList<Carte>> container;
	
	/**
	 * Modélise le tableau d'entier définissant la forme du tapis. Ce modèle sera utilisé pour construire le container.
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
	 * Getter du tableau modèle de la forme de tapis
	 * @return le modèle
	 */
	public int[][] getModele() {
		return modele;
	}

	/**
	 * Instancie le tapis de jeu en récupérant le modèle choisi par l'utilisateur, et en créant l'ArrayList d'ArrayLists dans laquelle on va placer les cartes, en suivant le modèle de la forme.
	 * On ajoute un objet null à chaque case en attendant leur remplissage.
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
	 * Définit lorsqu'un "placement normal" est possible : S'il n'y a encore aucune carte sur le tapis, il suffit qu'il y ait un 1 dans la case (lig;col) du tableau modele.
	 * S'il y en plus que cela, la case doit être vide et l'adjacence doit être respectée
	 * @param lig - la ligne à laquelle on tente de placer la carte
	 * @param col - la colonne à laquelle on tente de placer la carte
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
	 * Définit lorsque l'adjacence est respectée : 
	 * Au moins une des cases entourant celle de coordonnées (lig;col) (haut, bas, gauche, droite) doit être remplie
	 * @param lig - la ligne à laquelle on tente de placer la carte
	 * @param col - la colonne à laquelle on tente de placer la carte
	 * @return true si le placement est possible
	 * 
	 */
	public boolean adjacenceRespectee(int lig, int col) {
		
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
		
		if( caseDessusRemplie || caseDessousRemplie || caseGaucheRemplie || caseDroiteRemplie) {
			return true;
		}else {
			return false;
		}
		
    }
	
	/**
	 * Définit lorsqu'une case est remplie : càd si elle n'est pas nulle
	 * @param la ligne à laquelle on tente de placer la carte
	 * @param col - la colonne à laquelle on tente de placer la carte
	 * @return true si la case est remplie
	 */
	public boolean caseRemplie(int lig, int col) {
		return this.getContainer().get(lig).get(col)!=null;
	}
	
	/**
	 * Définit lorsque le décalage du tapis est possible : 
	 * la case de coordonnées (lig;col) doit être remplie et aux bornes du tapis (haut, bas, gauche, droite selon le sens de décalage).
	 * Selon le sens de décalage également, la ligne ou la colonne opposée doit être vide. De plus, il ne faut pas qu'une carte soit poussée sur une case 0 lors du décalage.
	 * Pour ce faire, l'ensemble du tableau modele est parcouru pour verifier si tous ces paramètres sont respectés.
	 * @param lig - la ligne à laquelle on tente de placer la carte
	 * @param col - la colonne à laquelle on tente de placer la carte
	 * @return true si le décalage est possible
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
	 * Décale les cartes du tapis pour en placer une à la case (lig;col).
	 * Pour cela, selon le sens de décalage, on ajoute une nouvelle ligne ou nouvelle colonne là où l'on veut placer notre carte, on la remplie avec des objets null, et on supprime la ligne excédante
	 * @param lig - la ligne à laquelle on tente de placer la carte
	 * @param col - la colonne à laquelle on tente de placer la carte
	 * @return true si le décalage est possible
	 */
	public void decalerCartes(int lig, int col) {
		
		int derniereLigne = this.getContainer().size();

		if(carteEnBas && premiereLigneVide && carteVideSous0) {
	        
			ArrayList<Carte> ligne = new ArrayList<Carte>();
			this.getContainer().add(ligne);
			
			//suppression de la ligne excédante
			this.getContainer().remove(0);
			
			//remplissage de la ligne avec null
			for(int j=0; j<this.modele[lig].length; j++) {
			    this.getContainer().get(lig).add(null);
			}
	        
		} else if(carteEnHaut && derniereLigneVide && carteVideSur0){

			//ajout d'une nouvelle ligne là où on veut ajouter une carte
			ArrayList<Carte> ligne = new ArrayList<Carte>();
			this.getContainer().add(lig,ligne);
			
			//remplissage de la ligne avec null
			for(int j=0; j<this.modele[lig].length; j++) {
			    this.getContainer().get(lig).add(null);
			}
			//suppression de la ligne excédente
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
     * Redéfinition de la méthode toString(), qui présente le tapis visuellement avec des cases vides [ ] ou remplies [x]. 
     * A coté la liste dynamique est représentée avec son contenu exact, une carte ou un objet null.
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
