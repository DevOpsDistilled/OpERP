package devopsdistilled.operp.client.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.view.MainWindow;
import devopsdistilled.operp.client.view.MainWindowListener;
import devopsdistilled.operp.client.view.controller.MainWindowController;

@Configuration
public class AppConfig {

	@Bean
	public MainWindowController mainWindowController() {
		MainWindowController controller = MainWindowController.getInstance();
		MainWindowListener listener = new MainWindowListener();
		listener.setController(controller);
		MainWindow mainWindow = MainWindow.getInstance();
		mainWindow.setListener(listener);
		controller.setMainWindow(mainWindow);
		return controller;
	}
}
