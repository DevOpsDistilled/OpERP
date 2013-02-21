package devopsdistilled.operp.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import devopsdistilled.operp.server.model.Item;
import devopsdistilled.operp.server.service.ItemService;

public class ClientApp {
    public static void main(String[] args) {
	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
		"devopsdistilled.operp.client");
	ItemService itemService = ctx.getBean(ItemService.class);
	Item item = itemService.createItem("Test Item from Client");
	System.out.println(item);
	ctx.close();
    }
}
