package vue;

import shapeUp.Observable;
import shapeUp.Observer;
import shapeUp.ShapeUp;

public class Console implements Observer, Runnable {
	
	private ShapeUp jeuShapeUp;
	public ShapeUp getJeuShapeUp() {
		return jeuShapeUp;
	}

	public void setJeuShapeUp(ShapeUp jeuShapeUp) {
		this.jeuShapeUp = jeuShapeUp;
	}

	private Thread t;
	
	public Console() {
//		this.jeuShapeUp = shapeUp;
//		jeuShapeUp.addObserver(this);
//		t = new Thread(this);
//		t.start();
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
