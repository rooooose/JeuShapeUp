package vue;

import shapeUp.Observable;
import shapeUp.Observer;
import shapeUp.ShapeUp;

public class Console implements Observer, Runnable {
	
	private ShapeUp jeuShapeUp;
	
	public Console(ShapeUp shapeUp) {
		this.jeuShapeUp = shapeUp;
		this.jeuShapeUp.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		System.out.println(arg);
	}

	@Override
	public void run() {

		//ShapeUp jeuShapeUp = new ShapeUp();
		
		System.out.println(this.jeuShapeUp);
		//System.out.println(jeuShapeUp);
		
		while(!this.jeuShapeUp.getMaPartie().isEstFinie()) {
			this.jeuShapeUp.getMaPartie().tourDeJeu();
		}
		//System.out.println("Partie finie !"+"\n");
		this.jeuShapeUp.getMaPartie().getModeDeJeu().finirLaPartie(jeuShapeUp.getMaPartie());
		
	}

	
	
}
