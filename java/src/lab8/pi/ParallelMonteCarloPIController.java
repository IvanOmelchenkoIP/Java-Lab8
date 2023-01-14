package lab8.pi;

import lab8.exceptions.ThreadAmountException;

public class ParallelMonteCarloPIController {

	private final int ITERATIONS = 1000000000;
	
	private ParallelMonteCarloPIModel model;
	private ParallelMonteCarloPIView view;
	
	public ParallelMonteCarloPIController(ParallelMonteCarloPIModel model, ParallelMonteCarloPIView view) {
		this.model = model;
		this.view = view;
	}
	
	public void count(int threads) {
		try {
			double pi = model.countPI(ITERATIONS, threads);
			view.showPI(pi, threads, ITERATIONS);
		} catch (InterruptedException | ThreadAmountException exception) {
			view.showException(exception);
		}
	}
}