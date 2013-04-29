package devopsdistilled.operp.server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import devopsdistilled.operp.server.context.AppContext;
import devopsdistilled.operp.server.data.entity.Item;

public class ServerApp {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);
		Item item = new Item();
		System.out.println(context);
		System.out.println(item);
	}
}
