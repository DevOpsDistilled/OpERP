package devopsdistilled.operp.server;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import devopsdistilled.operp.server.config.AppConfig;
import devopsdistilled.operp.server.model.Item;
import devopsdistilled.operp.server.service.ItemService;

public class ServerApp {
    public static void main(String[] args) {

	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
	ItemService itemService = ctx.getBean(ItemService.class);
	Item item = itemService.createItem("Test Item");
	System.out.println(item);
	ctx.close();
    }
}
