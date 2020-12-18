package shapeUp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Observable {
	
	private List<Observer> observers = new ArrayList<Observer>();
	private boolean changed;
	
	public void setChanged() {
		this.changed = true;
	}
	
	public boolean hasChanged() {
		return this.changed;
	}
	
	public void clearChanged() {
		this.changed = false;
	}
	
	public void addObserver (Observer o) {
		this.observers.add(o);
	}
	
	public void deleteObserver(Observer o) {
		this.observers.remove(o);
	}
	
	public void notifyObservers (Object arg) {
		
		Iterator<Observer> itObservers = this.observers.iterator();
		while(itObservers.hasNext()) {
			
			Observer nextObserver = itObservers.next();
			nextObserver.update(this, arg);
			
		}
		
	}
	
//	Observable (Console consoleDeJeu){
//		
//		this.addObserver(consoleDeJeu);
//	}

}
