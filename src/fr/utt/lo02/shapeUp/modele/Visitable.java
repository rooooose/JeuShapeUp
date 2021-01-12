package fr.utt.lo02.shapeUp.modele;

/**
 * L'interface Visitable d�clare la m�thode qui permettra � un objet Visitable d'�tre visiter par un visiteur pour r�cup�rer des informations.
 * <br> 
 * Dans notre cas, la partie est Visitable et sera visit�e par trois visiteurs correspondants aux diff�rents calculs de score.
 * 
 * @author Shir F, Math�a Z
 * @see {@link Partie}, {@link VisiteurScore}
 */
public interface Visitable {
	/**
	 * M�thode permettant � l'objet d'�tre visit� pour le calcul de score
	 * 
	 * @param visiteur objet visitant la partie pour conna�tre certaines informations
	 * @param joueur permet de calculer le score pour chaque joueur
	 * @return entier correspondant au score du joueur entr� en param�tre
	 */
    int accepterScore(VisiteurScore visiteur, Joueur joueur);

}
