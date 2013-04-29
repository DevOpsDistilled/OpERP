package devopsdistilled.operp.server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import devopsdistilled.operp.server.context.AppContext;
import devopsdistilled.operp.server.data.entity.Item;
import devopsdistilled.operp.server.data.repo.ItemRepository;

public class ServerApp {
/*
	@Inject
	ItemRepository itemRepository;
*/
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(
				AppContext.class);
		ItemRepository itemRepository = context.getBean(ItemRepository.class);
		
		Item item = new Item();
		item.setName("Test Item");
		item = itemRepository.save(item );
		System.out.println(itemRepository.findOne(item.getId()));
		System.out.println(context);
	}

	
}
