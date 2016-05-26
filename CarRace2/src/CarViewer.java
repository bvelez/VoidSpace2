import javax.swing.JFrame;

public class CarViewer
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();

		frame.setSize(800, 800);
		frame.setTitle("Two cars");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		CarComponent carComponent = new CarComponent(15);
		frame.add(carComponent);

		frame.setVisible(true);
		
		int i = 0;
		while (!carComponent.existsWinner()) {
			frame.repaint();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			carComponent.moveCars();
			i++;
		}
		frame.repaint();
	}
}
