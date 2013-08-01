package devopsdistilled.operp.client.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.items.panes.CategoryDetailsPane;
import devopsdistilled.operp.client.items.panes.ItemDetailsPane;

@Configuration
public class EntityDetailsContext {

	@Bean
	public ItemDetailsPane itemDetailsPane() {
		return new ItemDetailsPane();
	}

	@Bean
	public CategoryDetailsPane categoryDetailsPane() {
		return new CategoryDetailsPane();
	}
}
