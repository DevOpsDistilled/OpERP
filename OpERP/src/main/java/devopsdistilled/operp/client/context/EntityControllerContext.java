package devopsdistilled.operp.client.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.items.controllers.CategoryController;
import devopsdistilled.operp.client.items.controllers.CategoryControllerImpl;
import devopsdistilled.operp.client.items.controllers.ItemController;
import devopsdistilled.operp.client.items.controllers.impl.ItemControllerImpl;

@Configuration
public class EntityControllerContext {

	@Bean
	public ItemController itemController() {
		return new ItemControllerImpl();
	}

	@Bean
	public CategoryController categoryController() {
		return new CategoryControllerImpl();
	}
}
