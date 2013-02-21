package devopsdistilled.operp.server;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import devopsdistilled.operp.server.model.Item;
import devopsdistilled.operp.server.service.ItemService;

public class ServerApp {
    public static void main(String[] args) {

	@SuppressWarnings("resource")
	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
		"devopsdistilled.operp.server");
	ItemService itemService = ctx.getBean(ItemService.class);
	Item item = itemService.createItem("Test Item from Server");
	System.out.println(item);
    }
}
