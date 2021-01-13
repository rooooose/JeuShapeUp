package fr.utt.lo02.shapeUp.modele;

/**
 * Permet de respecter le patron de conception Observer correspondant.
 * <br>
 * Les classes qui implémentent cette interface pourront observer des objets et se mettre à jour lors de changement des objets observés.
 * <br>
 * 
 * @author Shir F, Mathéa Z
 *
 * @see Observable
 */
public interface Observer {

	/**
	 * Méthode permettant à l'Observer de se mettre à jour en fonction de l'objet observé et du changement de l'objet. 
	 * @param o - objet observé par l'Observer
	 * @param arg - changement notifié par l'objet observé
	 */
	void update(Observable o, Object arg);
}
