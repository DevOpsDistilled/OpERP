package devopsdistilled.operp.client.items.exceptions;

public class EntityNameExistsException extends Exception {

	private static final long serialVersionUID = 7326121173982471895L;

	public EntityNameExistsException() {
		super("Entity Name already exists");
	}

	public EntityNameExistsException(String message) {
		super(message);
	}

}
