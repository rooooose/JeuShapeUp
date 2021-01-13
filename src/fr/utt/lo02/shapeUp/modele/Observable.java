package fr.utt.lo02.shapeUp.modele;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Permet de respecter le patron de conception Observer. <br>
 * Cette classe permet à tous les objets des classes qui en héritent d'être observés par un ou plusieurs Observer.
 * 
 * @author Shir F, Mathéa Z
 *
 * @see Observer
 */
public class Observable {
	
	/**
	 * Collection de type List contenant les Observer d'un objet Observable.
	 */
	private List<Observer> observers = new ArrayList<Observer>();
	
	/**
	 * Permet de définir si un objet Observable a changé ou non <br>
	 * false - quand il n'y a pas de changement <br>
	 * true - lorsqu'il y a un changement
	 */
	private boolean changed;
	
	/**
	 * Permet de définir que l'objet observable a changé.
	 */
	public void setChanged() {
		this.changed = true;
	}
	
	/**
	 * Permet de savoir si l'objet Observable a changé ou non
	 * @return booléen correspondant au changement ou non de l'objet
	 */
	public boolean hasChanged() {
		return this.changed;
	}
	
	/**
	 * Permet de définir que l'objet observable n'a pas changé. <br>
	 * On peut utiliser cette méthode après avoir notifier les Observer d'un changement pour éviter toute confusion.
	 */
	public void clearChanged() {
		this.changed = false;
	}
	
	/**
	 * Cette méthode est utilisée pour ajouter un Observer à la liste des Observer de l'objet observable.
	 * @param o - Observer que l'on souhaite ajouter à la liste des Observer
	 * @see {@link #observers}
	 */
	public void addObserver (Observer o) {
		this.observers.add(o);
	}
	
	/**
	 * Cette méthode permet, si il est présent, de supprimer un des Observer de la liste des Observer de l'objet observable.
	 * @param o - Observer que l'on souhaite supprimer de la liste des Observer
	 * @see {@link #observers}
	 */
	public void deleteObserver(Observer o) {
		this.observers.remove(o);
	}
	
	/**
	 * Permet de notifier les Observer d'un changement de l'objet observable. <br>
	 * Cette méthode va appeler la méthode de mise à jour de tous les Observer de l'objet.
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
