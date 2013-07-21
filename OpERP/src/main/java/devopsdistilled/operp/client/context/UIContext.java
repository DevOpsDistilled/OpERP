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

	@Bean()
	@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
	public ItemModel itemModel() {
		System.out.println("From itemModel()");
		return new ItemModelImpl();
	}

	@Bean
	@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
	public ItemPaneController itemPaneController() {
		System.out.println("From itemPaneController()");
		return new ItemPaneControllerImpl();
	}

	@Bean
	@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
	public ItemPane itemPane() {
		System.out.println("From itemPane()");
		ItemPaneController controller = itemPaneController();
		ItemModel model = controller.getModel();
		ItemPaneController controller2 = itemPaneController();
		ItemModel model2 = controller2.getModel();
		System.out.println("controller1: " + controller);
		System.out.println("model1: " + model);
		System.out.println("controller2: " + controller2);
		System.out.println("model2: " + model2);
		return new ItemPane(controller, model);
	}
}
