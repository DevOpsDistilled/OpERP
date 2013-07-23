package devopsdistilled.operp.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import devopsdistilled.operp.client.context.AppContext;
import devopsdistilled.operp.client.main.MainWindow;

public class ClientApp {

	private static ApplicationContext context;

	public static ApplicationContext getApplicationContext() {
		return context;
	}

	public static void main(String[] args) {
		context = new AnnotationConfigApplicationContext(AppContext.class);

		MainWindow window = context.getBean(MainWindow.class);
		window.init();

		System.out.println(context);
	}
}
