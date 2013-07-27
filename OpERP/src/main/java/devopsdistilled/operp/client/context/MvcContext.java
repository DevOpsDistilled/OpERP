package devopsdistilled.operp.client.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.items.controllers.CreateItemPaneController;
import devopsdistilled.operp.client.items.controllers.EditItemPaneController;
import devopsdistilled.operp.client.items.controllers.ListItemPaneController;
import devopsdistilled.operp.client.items.controllers.impl.CreateItemPaneControllerImpl;
import devopsdistilled.operp.client.items.controllers.impl.EditItemPaneControllerImpl;
import devopsdistilled.operp.client.items.controllers.impl.ListItemPaneControllerImpl;
import devopsdistilled.operp.client.items.models.CreateItemPaneModel;
import devopsdistilled.operp.client.items.models.EditItemPaneModel;
import devopsdistilled.operp.client.items.models.ListItemPaneModel;
import devopsdistilled.operp.client.items.models.impl.CreateItemPaneModelImpl;
import devopsdistilled.operp.client.items.models.impl.EditItemPaneModelImpl;
import devopsdistilled.operp.client.items.models.impl.ListItemPaneModelImpl;
import devopsdistilled.operp.client.items.views.CreateItemPane;
import devopsdistilled.operp.client.items.views.EditItemPane;
import devopsdistilled.operp.client.items.views.ListItemPane;

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
}
