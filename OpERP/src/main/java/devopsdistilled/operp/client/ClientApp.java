package devopsdistilled.operp.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import devopsdistilled.operp.client.context.AppContext;
import devopsdistilled.operp.client.main.MainWindow;

public class ClientApp {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(
				AppContext.class);
		MainWindow window = context.getBean(MainWindow.class);
		window.init();

		System.out.println(context);
	}
}
