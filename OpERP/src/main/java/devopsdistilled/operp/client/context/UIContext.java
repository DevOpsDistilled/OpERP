package devopsdistilled.operp.client.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import devopsdistilled.operp.client.items.ItemController;
import devopsdistilled.operp.client.items.ItemControllerImpl;
import devopsdistilled.operp.client.items.ItemModel;
import devopsdistilled.operp.client.items.ItemModelImpl;
import devopsdistilled.operp.client.items.controllers.CreateItemPaneController;
import devopsdistilled.operp.client.items.controllers.impl.CreateItemPaneControllerImpl;
import devopsdistilled.operp.client.items.views.CreateItemPane;
import devopsdistilled.operp.client.main.MainModel;
import devopsdistilled.operp.client.main.MainModelImpl;
import devopsdistilled.operp.client.main.MainWindow;
import devopsdistilled.operp.client.main.MainWindowController;
import devopsdistilled.operp.client.main.MainWindowControllerImpl;

@Configuration
@Import({ NavigationContext.class })
public class UIContext {

	@Bean
	public MainWindowController mainWindowController() {
		return new MainWindowControllerImpl();
	}

	@Bean
	public MainModel mainModel() {
		return new MainModelImpl();
	}

	@Bean
	public MainWindow mainWindow() {
		MainWindow window = MainWindow.getInstance();
		return window;
	}

	@Bean
	public ItemController itemController() {
		return new ItemControllerImpl();
	}

	@Bean
	public ItemModel itemModel() {
		return new ItemModelImpl();
	}

	@Bean
	public CreateItemPane createItemPane() {
		return new CreateItemPane();
	}

	@Bean
	public CreateItemPaneController createItemPaneController() {
		return new CreateItemPaneControllerImpl();
	}

}
