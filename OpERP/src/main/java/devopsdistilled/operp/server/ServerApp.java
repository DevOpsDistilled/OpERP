package devopsdistilled.operp.server;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

<<<<<<< HEAD
import devopsdistilled.operp.server.config.AppConfig;
=======
import devopsdistilled.operp.server.model.Item;
import devopsdistilled.operp.server.service.ItemService;
>>>>>>> refs/remotes/devops/master

public class ServerApp {
	public static void main(String[] args) {

<<<<<<< HEAD
	ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

	System.out.println(ctx.toString());
    }
=======
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
				"devopsdistilled.operp.server");
		ItemService itemService = ctx.getBean(ItemService.class);
		Item item = itemService.createItem("Test Item from Server");
		System.out.println(item);
	}
>>>>>>> refs/remotes/devops/master
}
