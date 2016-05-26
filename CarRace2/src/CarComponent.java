import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JComponent;

/**
       This component draws two car shapes.
 */
public class CarComponent extends JComponent
{  
	private static byte redraws = 0;
	private static long accidents = 0;
	private static Random rand = new Random();

	private Car[] theCars;

	public CarComponent(int numCars) {
		theCars = new Car[numCars];
		int yCoord = 0;
		for(int i=0; i<numCars; i++) {
			theCars[i] = new Car(0, yCoord, Color.MAGENTA, i);
			yCoord += 50;
		}
	}

	public boolean existsWinner() {
		for (Car car : theCars) {
			Rectangle bounds = car.getBoundary();
			boolean won = (bounds.getX() + bounds.getWidth()) >= this.getWidth();
			if (won) { 
				car.setColor(Color.GREEN);
				return true; 
			}
		}
		return false;
	}

	public void moveCars() {
		Random generator = new Random();
		for(Car car : this.theCars) {
			car.moveRight(generator.nextInt(20));
		}
	}

	public void paintComponent(Graphics g)
	{  
		Graphics2D g2 = (Graphics2D) g;
		for (int i=0; i<theCars.length; i++) {
			theCars[i].draw(g2);
		}
	}
}