package devopsdistilled.operp.client.context;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

import devopsdistilled.operp.client.items.ItemModel;
import devopsdistilled.operp.client.items.ItemModelImpl;
import devopsdistilled.operp.client.items.ItemPane;
import devopsdistilled.operp.client.items.ItemPaneController;
import devopsdistilled.operp.client.items.ItemPaneControllerImpl;
import devopsdistilled.operp.client.items.ListItemModel;
import devopsdistilled.operp.client.items.ListItemModelImpl;
import devopsdistilled.operp.client.items.ListItemPane;
import devopsdistilled.operp.client.items.ListItemPaneController;
import devopsdistilled.operp.client.items.ListItemPaneControllerImpl;
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
	@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
	public ItemModel itemModel() {
		return new ItemModelImpl();
	}

	@Bean
	@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
	public ItemPaneController itemPaneController() {
		return new ItemPaneControllerImpl();
	}

	@Bean
	@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
	public ItemPane itemPane() {
		ItemPaneController controller = itemPaneController();
		ItemModel model = controller.getModel();
		return new ItemPane(controller, model);
	}

	@Bean
	@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
	public ListItemModel listItemModel() {
		return new ListItemModelImpl();
	}

	@Bean
	@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
	public ListItemPaneController listItemPaneController() {
		return new ListItemPaneControllerImpl();
	}

	@Bean
	@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
	public ListItemPane listItemPane() {
		ListItemPaneController controller = listItemPaneController();
		ListItemModel model = controller.getModel();
		return new ListItemPane(controller, model);
	}

}
