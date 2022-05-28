package mvc;

public class Game {
	private Model m;
	public Game(){
		m = new Model();

	}

	public void start() {
		new Thread() { 
			public void run() {
				while (true) {
					m.zeichnen();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
	
}