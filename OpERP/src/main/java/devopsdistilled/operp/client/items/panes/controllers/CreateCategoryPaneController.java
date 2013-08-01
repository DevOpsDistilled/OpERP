package devopsdistilled.operp.client.items.panes.controllers;

import devopsdistilled.operp.client.abstracts.SubTaskPaneController;
import devopsdistilled.operp.client.items.exceptions.EntityNameExistsException;
import devopsdistilled.operp.client.items.exceptions.NullFieldException;
import devopsdistilled.operp.server.data.entity.items.Category;

public interface CreateCategoryPaneController extends SubTaskPaneController {

	void validate(Category category) throws NullFieldException, EntityNameExistsException;

	Category save(Category category);
	
}
