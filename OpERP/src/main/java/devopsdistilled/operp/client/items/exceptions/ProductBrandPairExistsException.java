package devopsdistilled.operp.client.items.exceptions;

import devopsdistilled.operp.client.exceptions.EntityValidationException;

public class ProductBrandPairExistsException extends EntityValidationException {

	public ProductBrandPairExistsException(String message) {
		super(message);
	}

	private static final long serialVersionUID = -6474661245907152963L;

}
