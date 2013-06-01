package devopsdistilled.operp.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import devopsdistilled.operp.client.context.AppConfig;
import devopsdistilled.operp.client.view.controller.MainWindowController;

public class ClientApp {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);

		MainWindowController controller = context.getBean(MainWindowController.class);
		controller.show();
		System.out.println(context);
		
	/*	MainWindowController controller = MainWindowController.getInstance();
		MainWindowListener listener = new MainWindowListener();
		listener.setController(controller);
		MainWindow mainWindow = MainWindow.getInstance();
		mainWindow.setListener(listener);
		controller.setMainWindow(mainWindow);*/
	}

}
