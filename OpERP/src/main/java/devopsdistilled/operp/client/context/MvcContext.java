package devopsdistilled.operp.client.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.items.panes.CreateCategoryPane;
import devopsdistilled.operp.client.items.panes.CreateItemPane;
import devopsdistilled.operp.client.items.panes.EditItemPane;
import devopsdistilled.operp.client.items.panes.ListItemPane;
import devopsdistilled.operp.client.items.panes.controllers.CreateCategoryPaneController;
import devopsdistilled.operp.client.items.panes.controllers.CreateItemPaneController;
import devopsdistilled.operp.client.items.panes.controllers.EditItemPaneController;
import devopsdistilled.operp.client.items.panes.controllers.ListItemPaneController;
import devopsdistilled.operp.client.items.panes.controllers.impl.CreateCategoryPaneControllerImpl;
import devopsdistilled.operp.client.items.panes.controllers.impl.CreateItemPaneControllerImpl;
import devopsdistilled.operp.client.items.panes.controllers.impl.EditItemPaneControllerImpl;
import devopsdistilled.operp.client.items.panes.controllers.impl.ListItemPaneControllerImpl;
import devopsdistilled.operp.client.items.panes.models.CreateCategoryPaneModel;
import devopsdistilled.operp.client.items.panes.models.CreateItemPaneModel;
import devopsdistilled.operp.client.items.panes.models.EditItemPaneModel;
import devopsdistilled.operp.client.items.panes.models.ListItemPaneModel;
import devopsdistilled.operp.client.items.panes.models.impl.CreateCategoryPaneModelImpl;
import devopsdistilled.operp.client.items.panes.models.impl.CreateItemPaneModelImpl;
import devopsdistilled.operp.client.items.panes.models.impl.EditItemPaneModelImpl;
import devopsdistilled.operp.client.items.panes.models.impl.ListItemPaneModelImpl;

@Configuration
public class MvcContext {

	@Bean
	public CreateItemPaneModel createItemPaneModel() {
		return new CreateItemPaneModelImpl();
	}

	@Bean
	public ListItemPaneModel listItemPaneModel() {
		return new ListItemPaneModelImpl();
	}

	@Bean
	public EditItemPaneModel editItemPaneModel() {
		return new EditItemPaneModelImpl();
	}

	@Bean
	public CreateCategoryPaneModel createCategoryPaneModel() {
		return new CreateCategoryPaneModelImpl();
	}

	@Bean
	public CreateItemPane createItemPane() {
		return new CreateItemPane();
	}

	@Bean
	public ListItemPane listItemPane() {
		return new ListItemPane();
	}

	@Bean
	public EditItemPane editItemPane() {
		return new EditItemPane();
	}

	@Bean
	public CreateCategoryPane createCategoryPane() {
		return new CreateCategoryPane();
	}

	@Bean
	public CreateItemPaneController createItemPaneController() {
		return new CreateItemPaneControllerImpl();
	}

	@Bean
	public ListItemPaneController listItemPaneController() {
		return new ListItemPaneControllerImpl();
	}

	@Bean
	public EditItemPaneController editItemPaneController() {
		return new EditItemPaneControllerImpl();
	}

	@Bean
	public CreateCategoryPaneController createCategoryPaneController() {
		return new CreateCategoryPaneControllerImpl();
	}
}
