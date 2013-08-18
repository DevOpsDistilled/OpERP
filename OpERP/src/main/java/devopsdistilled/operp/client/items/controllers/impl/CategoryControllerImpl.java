package devopsdistilled.operp.client.items.controllers.impl;

import javax.inject.Inject;

import org.springframework.context.ApplicationContext;

import devopsdistilled.operp.client.items.controllers.CategoryController;
import devopsdistilled.operp.client.items.models.CategoryModel;
import devopsdistilled.operp.client.items.panes.controllers.CreateCategoryPaneController;
import devopsdistilled.operp.client.items.panes.controllers.EditCategoryPaneController;
import devopsdistilled.operp.client.items.panes.controllers.ListCategoryPaneController;
import devopsdistilled.operp.server.data.entity.items.Category;

public class CategoryControllerImpl implements CategoryController {

	@Inject
	private ApplicationContext context;

	@Inject
	private CategoryModel categoryModel;

	@Override
	public void create() {
		CreateCategoryPaneController createCategoryPaneController = context
				.getBean(CreateCategoryPaneController.class);
		createCategoryPaneController.init();
	}

	@Override
	public void edit(Category category) {
		EditCategoryPaneController editCategoryPaneController = context
				.getBean(EditCategoryPaneController.class);
		editCategoryPaneController.init(category);
	}

	@Override
	public void list() {
		ListCategoryPaneController listCategoryPaneController = context
				.getBean(ListCategoryPaneController.class);
		listCategoryPaneController.init();
	}

	@Override
	public void delete(Category category) {
		categoryModel.deleteAndUpdateModel(category);
	}

	@Override
	public void showDetails(Category entity) {
		// TODO Auto-generated method stub

	}
}
