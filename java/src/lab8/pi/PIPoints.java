package lab8.pi;

class PIPoints {
	private int n = 0;
	
	public synchronized void add(int points) {
		n += points;
		return;
	}
	
	public synchronized int getPoints() {
		return n;
	}
}
