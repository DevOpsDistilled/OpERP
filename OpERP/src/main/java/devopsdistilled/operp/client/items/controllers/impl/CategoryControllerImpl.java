package devopsdistilled.operp.client.items.controllers;

import javax.inject.Inject;

import org.springframework.context.ApplicationContext;

import devopsdistilled.operp.client.items.panes.controllers.CreateCategoryPaneController;
import devopsdistilled.operp.server.data.entity.items.Category;

public class CategoryControllerImpl implements CategoryController {

	@Inject
	private ApplicationContext context;

	@Override
	public void create() {
		CreateCategoryPaneController createCategoryPaneController = context
				.getBean(CreateCategoryPaneController.class);
		createCategoryPaneController.init();
	}

	@Override
	public void edit(Category entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void list() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Category entity) {
		// TODO Auto-generated method stub

	}

}
