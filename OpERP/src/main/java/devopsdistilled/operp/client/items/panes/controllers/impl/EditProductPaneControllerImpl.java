package devopsdistilled.operp.client.items.panes.controllers.impl;

import devopsdistilled.operp.client.items.exceptions.EntityNameExistsException;
import devopsdistilled.operp.client.items.exceptions.NullFieldException;
import devopsdistilled.operp.client.items.panes.controllers.EditProductPaneController;
import devopsdistilled.operp.server.data.entity.items.Product;

public class EditProductPaneControllerImpl implements EditProductPaneController {

	@Override
	public void init(Product entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void validate(Product entity) throws NullFieldException,
			EntityNameExistsException {
		// TODO Auto-generated method stub

	}

	@Override
	public Product save(Product entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
