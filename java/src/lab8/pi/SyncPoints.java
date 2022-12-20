package lab8.pi;

class SyncPoints {
	
	private int syncPoints = 0;

	public synchronized void add(int points) {
		syncPoints += points;
		return;
	}

	public synchronized int getPoints() {
		return syncPoints;
	}
}
