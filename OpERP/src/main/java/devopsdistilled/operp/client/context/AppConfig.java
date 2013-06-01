package devopsdistilled.operp.client.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.view.MainWindow;
import devopsdistilled.operp.client.view.MainWindowListener;
import devopsdistilled.operp.client.view.controller.MainWindowController;

@Configuration
public class AppConfig {

	@Bean
	public MainWindow mainWindow() {
		return MainWindow.getInstance();
	}

	@Bean
	public MainWindowListener mainWindowListener() {
		return new MainWindowListener();
	}

	@Bean
	public MainWindowController mainWindowController() {
		MainWindowController mainWindowController = MainWindowController
				.getInstance();

		return mainWindowController;
	}
}
