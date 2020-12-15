package vue;

import shapeUp.Observable;
import shapeUp.Observer;

public class Console implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		System.out.println(arg);
	}

	
	
}
