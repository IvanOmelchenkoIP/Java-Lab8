package lab8.exceptions;

public class ThreadAmountException extends Exception {
	
	public ThreadAmountException() {
		super();
	}
	
	public ThreadAmountException(String str) {
		super(str);
	}
	
	public ThreadAmountException(String str, Throwable ex) {
		super(str, ex);
	}
	
	public ThreadAmountException(Throwable ex) {
		super(ex);
	}
}
