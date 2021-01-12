package fr.utt.lo02.shapeUp.modele;

/**
 * L'interface Visitable déclare la méthode qui permettra à un objet Visitable d'être visiter par un visiteur pour récupérer des informations.
 * <br> 
 * Dans notre cas, la partie est Visitable et sera visitée par trois visiteurs correspondants aux différents calculs de score.
 * 
 * @author Shir F, Mathéa Z
 * @see {@link Partie}, {@link VisiteurScore}
 */
public interface Visitable {
	/**
	 * Méthode permettant à l'objet d'être visité pour le calcul de score
	 * 
	 * @param visiteur objet visitant la partie pour connaître certaines informations
	 * @param joueur permet de calculer le score pour chaque joueur
	 * @return entier correspondant au score du joueur entré en paramètre
	 */
    int accepterScore(VisiteurScore visiteur, Joueur joueur);

}
