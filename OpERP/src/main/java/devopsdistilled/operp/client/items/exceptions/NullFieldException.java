package devopsdistilled.operp.client.items.exceptions;

public class NullFieldException extends Exception {

	private static final long serialVersionUID = -629948828110637464L;

	public NullFieldException() {
		super("Required Fields not set");
	}

	public NullFieldException(String message) {
		super(message);
	}

}
