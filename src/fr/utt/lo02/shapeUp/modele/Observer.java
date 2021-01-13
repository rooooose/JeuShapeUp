package fr.utt.lo02.shapeUp.modele;

/**
 * Permet de respecter le patron de conception Observer correspondant.
 * <br>
 * Les classes qui impl�mentent cette interface pourront observer des objets et se mettre � jour lors de changement des objets observ�s.
 * <br>
 * 
 * @author Shir F, Math�a Z
 *
 * @see Observable
 */
public interface Observer {

	/**
	 * M�thode permettant � l'Observer de se mettre � jour en fonction de l'objet observ� et du changement de l'objet. 
	 * @param o - objet observ� par l'Observer
	 * @param arg - changement notifi� par l'objet observ�
	 */
	void update(Observable o, Object arg);
}
