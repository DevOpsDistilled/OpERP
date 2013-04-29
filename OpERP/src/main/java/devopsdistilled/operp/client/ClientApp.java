package devopsdistilled.operp.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import devopsdistilled.operp.server.data.entity.Item;
import devopsdistilled.operp.server.data.service.ItemService;
//Test Comment 
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
