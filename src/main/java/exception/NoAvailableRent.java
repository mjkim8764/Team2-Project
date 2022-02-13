package exception;

public class NoAvailableRent extends Exception {
	public NoAvailableRent(){}
	public NoAvailableRent(String message){
		super(message);
	}
}
