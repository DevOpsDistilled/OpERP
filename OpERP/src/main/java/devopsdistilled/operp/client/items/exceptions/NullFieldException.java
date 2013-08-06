package devopsdistilled.operp.client.items.exceptions;

import devopsdistilled.operp.client.exceptions.EntityValidationException;

public class NullFieldException extends EntityValidationException {

	private static final long serialVersionUID = -629948828110637464L;

	public NullFieldException() {
		super("Required Fields not set");
	}

	public NullFieldException(String message) {
		super(message);
	}

}
