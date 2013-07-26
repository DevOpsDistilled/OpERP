package devopsdistilled.operp.client.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.items.ItemController;
import devopsdistilled.operp.client.items.ItemControllerImpl;

@Configuration
public class EntityControllerContext {
	@Bean
	public ItemController itemController() {
		return new ItemControllerImpl();
	}
}
