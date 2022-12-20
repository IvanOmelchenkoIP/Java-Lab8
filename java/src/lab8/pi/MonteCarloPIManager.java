package lab8.pi;

public class MonteCarloPIManager {

	private final int ITERATIONS = 1000000;
	
	public void count(int threads) {
		MonteCarloParallel mc = new MonteCarloParallel();
		for (int i = 0; i < threads; i++) {
			Thread thread = new Thread(mc);
			thread.start();
		}
	}
}
