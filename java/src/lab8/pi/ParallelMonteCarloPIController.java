package lab8.pi;

public class ParallelMonteCarloPIController {

	private final int ITERATIONS = 10000000;
	
	private ParallelMonteCarloPIModel model;
	private ParallelMonteCarloPIView view;
	
	public ParallelMonteCarloPIController(ParallelMonteCarloPIModel model, ParallelMonteCarloPIView view) {
		this.model = model;
		this.view = view;
	}
	
	public void count(int threads) {
		model.setParameters(ITERATIONS, threads);
		for (int i = 0; i < threads; i++) {
			new Thread(model.newPointThread()).start();
		}
		try {
			double pi = model.getPI();
			view.showPI(pi, threads, ITERATIONS);
		} catch (InterruptedException exception) {
			view.showException(exception);
		}
	}
}