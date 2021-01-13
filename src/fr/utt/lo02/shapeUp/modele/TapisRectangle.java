package fr.utt.lo02.shapeUp.modele;

/**
 * 
 * Repr�sente la forme de Rectangle du tapis de jeu. Elle h�rite de TapisDeJeu
 * Elle d�finit un mod�le qui sera utilis� pour cr�er une liste dynamique repr�sentant le tapis.
 *
 * @author Math�a Z, Shir F
 */
public class TapisRectangle extends TapisDeJeu {
	
	/**
	 * Repr�sente le mod�le fixe attribu� � la forme rectangulaire, gr�ce � un tableau d'entiers. Les 1 repr�sentent une case utilisable.
	 */
	private static final int[][] MODELE = {{1,1,1,1,1},
						   			   	   {1,1,1,1,1},
						   			   	   {1,1,1,1,1}};
	/**
	 * Instancie un tapis de forme rectangulaire en passant son mod�le au constructeur de la classe m�re.
	 */
	public TapisRectangle(){
		super(MODELE);
	}
	
}
