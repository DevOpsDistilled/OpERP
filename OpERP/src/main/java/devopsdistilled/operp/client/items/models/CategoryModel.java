package devopsdistilled.operp.client.items.models;

import devopsdistilled.operp.client.abstracts.EntityModel;
import devopsdistilled.operp.client.items.panes.models.observers.CategoryModelObserver;
import devopsdistilled.operp.server.data.entity.items.Category;
import devopsdistilled.operp.server.data.service.items.CategoryService;

public interface CategoryModel extends
		EntityModel<Category, CategoryService, CategoryModelObserver> {

}
