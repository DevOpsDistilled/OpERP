package devopsdistilled.operp.client.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import devopsdistilled.operp.client.items.panes.ItemDetailsDialog;

@Configuration
public class EntityDetailsContext {

	@Bean
	public ItemDetailsDialog itemDetailsDialog() {
		return new ItemDetailsDialog();
	}
}
