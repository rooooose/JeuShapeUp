package fr.utt.lo02.shapeUp.modele;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Permet de respecter le patron de conception Observer. <br>
 * Cette classe permet � tous les objets des classes qui en h�ritent d'�tre observ�s par un ou plusieurs Observer.
 * 
 * @author Shir F, Math�a Z
 *
 * @see Observer
 */
public class Observable {
	
	/**
	 * Collection de type List contenant les Observer d'un objet Observable.
	 */
	private List<Observer> observers = new ArrayList<Observer>();
	
	/**
	 * Permet de d�finir si un objet Observable a chang� ou non <br>
	 * false - quand il n'y a pas de changement <br>
	 * true - lorsqu'il y a un changement
	 */
	private boolean changed;
	
	/**
	 * Permet de d�finir que l'objet observable a chang�.
	 */
	public void setChanged() {
		this.changed = true;
	}
	
	/**
	 * Permet de savoir si l'objet Observable a chang� ou non
	 * @return bool�en correspondant au changement ou non de l'objet
	 */
	public boolean hasChanged() {
		return this.changed;
	}
	
	/**
	 * Permet de d�finir que l'objet observable n'a pas chang�. <br>
	 * On peut utiliser cette m�thode apr�s avoir notifier les Observer d'un changement pour �viter toute confusion.
	 */
	public void clearChanged() {
		this.changed = false;
	}
	
	/**
	 * Cette m�thode est utilis�e pour ajouter un Observer � la liste des Observer de l'objet observable.
	 * @param o - Observer que l'on souhaite ajouter � la liste des Observer
	 * @see {@link #observers}
	 */
	public void addObserver (Observer o) {
		this.observers.add(o);
	}
	
	/**
	 * Cette m�thode permet, si il est pr�sent, de supprimer un des Observer de la liste des Observer de l'objet observable.
	 * @param o - Observer que l'on souhaite supprimer de la liste des Observer
	 * @see {@link #observers}
	 */
	public void deleteObserver(Observer o) {
		this.observers.remove(o);
	}
	
	/**
	 * Permet de notifier les Observer d'un changement de l'objet observable. <br>
	 * Cette m�thode va appeler la m�thode de mise � jour de tous les Observer de l'objet.
	 * 
	 * @see {@link Observer#update(Observable, Object)}
	 * @param arg - Contenu de la notification
	 */
	public void notifyObservers (Object arg) {
		
		Iterator<Observer> itObservers = this.observers.iterator();
		while(itObservers.hasNext()) {
			
			Observer nextObserver = itObservers.next();
			nextObserver.update(this, arg);
			
		}
		
	}

}
