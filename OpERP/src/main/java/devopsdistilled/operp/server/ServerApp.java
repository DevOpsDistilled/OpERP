package devopsdistilled.operp.server;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import devopsdistilled.operp.server.context.AppContext;
import devopsdistilled.operp.server.data.entity.Item;

public class ServerApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				AppContext.class);
		Item item = new Item();
		// ItemService itemService = ctx.getBean(ItemService.class);
		// Item item = itemService.createItem("Test Item from Server");
		System.out.println(context);
		System.out.println(item);
	}
}
