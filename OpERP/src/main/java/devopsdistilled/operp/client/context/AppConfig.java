package devopsdistilled.operp.client.context;

import javax.swing.JMenuBar;
import javax.swing.JToolBar;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.view.MainWindow;
import devopsdistilled.operp.client.view.MainWindowListener;
import devopsdistilled.operp.client.view.MenuBar;
import devopsdistilled.operp.client.view.ToolBar;
import devopsdistilled.operp.client.view.controller.MainWindowController;

@Configuration
public class AppConfig {

	@Bean
	public MainWindow mainWindow() {
		return new MainWindow();
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

	@Bean
	public JMenuBar menuBar() {
		return MenuBar.getInstance();
	}

	@Bean
	public JToolBar toolBar() {
		return ToolBar.getInstance();
	}
}
