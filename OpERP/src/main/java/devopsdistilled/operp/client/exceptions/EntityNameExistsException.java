package devopsdistilled.operp.client.exceptions;


public class EntityNameExistsException extends EntityValidationException {

	private static final long serialVersionUID = 7326121173982471895L;

	public EntityNameExistsException() {
		super("Entity Name already exists");
	}

	public EntityNameExistsException(String message) {
		super(message);
	}

}
