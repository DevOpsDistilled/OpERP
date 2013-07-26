package devopsdistilled.operp.client.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.items.views.ItemDetailsDialog;

@Configuration
public class EntityDetailsContext {

	@Bean
	public ItemDetailsDialog itemDetailsDialog() {
		return new ItemDetailsDialog();
	}
}
